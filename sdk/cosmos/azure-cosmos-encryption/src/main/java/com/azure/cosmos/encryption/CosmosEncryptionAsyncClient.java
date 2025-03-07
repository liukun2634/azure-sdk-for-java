// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.cosmos.encryption;

import com.azure.core.annotation.ServiceClient;
import com.azure.cosmos.BridgeInternal;
import com.azure.cosmos.CosmosAsyncClient;
import com.azure.cosmos.CosmosAsyncClientEncryptionKey;
import com.azure.cosmos.CosmosAsyncContainer;
import com.azure.cosmos.CosmosAsyncDatabase;
import com.azure.cosmos.CosmosException;
import com.azure.cosmos.encryption.implementation.EncryptionImplementationBridgeHelpers;
import com.azure.cosmos.encryption.keyprovider.EncryptionKeyWrapProvider;
import com.azure.cosmos.implementation.HttpConstants;
import com.azure.cosmos.implementation.Utils;
import com.azure.cosmos.implementation.caches.AsyncCache;
import com.azure.cosmos.models.CosmosClientEncryptionKeyProperties;
import com.azure.cosmos.models.CosmosContainerProperties;
import com.azure.cosmos.models.CosmosContainerResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.io.Closeable;

/**
 * CosmosAsyncClient with encryption support.
 * We have static method in this class which will takes two inputs
 * {@link CosmosAsyncClient} and {@link EncryptionKeyWrapProvider}  and creates cosmosEncryptionAsyncClient as shown below.
 * <pre>
 * {@code
 * CosmosEncryptionAsyncClient cosmosEncryptionAsyncClient =
 * CosmosEncryptionAsyncClient.createCosmosEncryptionAsyncClient(cosmosAsyncClient, encryptionKeyWrapProvider);
 * }
 * </pre>
 */
@ServiceClient(
    builder = CosmosEncryptionClientBuilder.class,
    isAsync = true)
public final class CosmosEncryptionAsyncClient implements Closeable {
    private final static Logger LOGGER = LoggerFactory.getLogger(CosmosEncryptionAsyncClient.class);
    private final CosmosAsyncClient cosmosAsyncClient;
    private final AsyncCache<String, CosmosContainerProperties> containerPropertiesCacheByContainerId;
    private final AsyncCache<String, CosmosClientEncryptionKeyProperties> clientEncryptionKeyPropertiesCacheByKeyId;
    private EncryptionKeyWrapProvider encryptionKeyWrapProvider;

    CosmosEncryptionAsyncClient(CosmosAsyncClient cosmosAsyncClient,
                                EncryptionKeyWrapProvider encryptionKeyWrapProvider) {
        if (cosmosAsyncClient == null) {
            throw new IllegalArgumentException("cosmosClient is null");
        }
        if (encryptionKeyWrapProvider == null) {
            throw new IllegalArgumentException("encryptionKeyWrapProvider is null");
        }
        this.cosmosAsyncClient = cosmosAsyncClient;
        this.encryptionKeyWrapProvider = encryptionKeyWrapProvider;
        this.clientEncryptionKeyPropertiesCacheByKeyId = new AsyncCache<>();
        this.containerPropertiesCacheByContainerId = new AsyncCache<>();
    }

    /**
     * @return the encryption key wrap provider
     */
    public EncryptionKeyWrapProvider getEncryptionKeyWrapProvider() {
        return encryptionKeyWrapProvider;
    }

    Mono<CosmosContainerProperties> getContainerPropertiesAsync(
        CosmosAsyncContainer container,
        boolean shouldForceRefresh) {
        // container Id is unique within a Database.
        String cacheKey =
            container.getDatabase().getId() + "/" + container.getId();

        // cache it against Database and Container ID key.
        if (!shouldForceRefresh) {
            return this.containerPropertiesCacheByContainerId.getAsync(
                cacheKey,
                null,
                () -> container.read().
                    map(cosmosContainerResponse -> getContainerPropertiesWithVersionValidation(cosmosContainerResponse)));
        } else {
            return this.containerPropertiesCacheByContainerId.getAsync(
                cacheKey,
                null,
                () -> container.read().map(cosmosContainerResponse -> getContainerPropertiesWithVersionValidation(cosmosContainerResponse)))
                .flatMap(clientEncryptionPolicy -> this.containerPropertiesCacheByContainerId.getAsync(
                    cacheKey,
                    clientEncryptionPolicy,
                    () -> container.read().map(cosmosContainerResponse -> getContainerPropertiesWithVersionValidation(cosmosContainerResponse))));
        }
    }

    Mono<CosmosClientEncryptionKeyProperties> getClientEncryptionPropertiesAsync(
        String clientEncryptionKeyId,
        String databaseRid,
        CosmosAsyncContainer cosmosAsyncContainer,
        boolean shouldForceRefresh) {
        /// Client Encryption key Id is unique within a Database.
        String cacheKey = databaseRid + "/" + clientEncryptionKeyId;
        if (!shouldForceRefresh) {
            return this.clientEncryptionKeyPropertiesCacheByKeyId.getAsync(cacheKey, null, () -> {
                return this.fetchClientEncryptionKeyPropertiesAsync(cosmosAsyncContainer,
                    clientEncryptionKeyId);
            });
        } else {
            return this.clientEncryptionKeyPropertiesCacheByKeyId.getAsync(cacheKey, null, () ->
                this.fetchClientEncryptionKeyPropertiesAsync(cosmosAsyncContainer,
                    clientEncryptionKeyId)
            ).flatMap(cachedClientEncryptionProperties -> this.clientEncryptionKeyPropertiesCacheByKeyId.getAsync(cacheKey, cachedClientEncryptionProperties, () ->
                this.fetchClientEncryptionKeyPropertiesAsync(cosmosAsyncContainer,
                    clientEncryptionKeyId)));
        }
    }

    Mono<CosmosClientEncryptionKeyProperties> fetchClientEncryptionKeyPropertiesAsync(
        CosmosAsyncContainer container,
        String clientEncryptionKeyId) {
        CosmosAsyncClientEncryptionKey clientEncryptionKey =
            container.getDatabase().getClientEncryptionKey(clientEncryptionKeyId);

        return clientEncryptionKey.read().map(cosmosClientEncryptionKeyResponse ->
            cosmosClientEncryptionKeyResponse.getProperties()
        ).onErrorResume(throwable -> {
            if (!(throwable instanceof Exception)) {
                // fatal error
                LOGGER.error("Unexpected failure {}", throwable.getMessage(), throwable);
                return Mono.error(throwable);
            }
            Exception exception = (Exception) throwable;
            CosmosException dce = Utils.as(exception, CosmosException.class);
            if (dce != null) {
                if (dce.getStatusCode() == HttpConstants.StatusCodes.NOTFOUND) {
                    String message = "Encryption Based Container without Data Encryption Keys. " +
                        "Please make sure you have created the Client Encryption Keys";
                    return Mono.error(BridgeInternal.createCosmosException(HttpConstants.StatusCodes.NOTFOUND, message));
                }
                return Mono.error(dce);
            }

            return Mono.error(exception);
        });
    }

    /**
     * Get the regular CosmosAsyncClient back.
     *
     * @return cosmosAsyncClient
     */
    public CosmosAsyncClient getCosmosAsyncClient() {
        return cosmosAsyncClient;
    }

    /**
     * Gets a database with Encryption capabilities
     *
     * @param cosmosAsyncDatabase original database
     * @return database with encryption capabilities
     */
    public CosmosEncryptionAsyncDatabase getCosmosEncryptionAsyncDatabase(CosmosAsyncDatabase cosmosAsyncDatabase) {
        return new CosmosEncryptionAsyncDatabase(cosmosAsyncDatabase, this);
    }

    /**
     * Gets a database with Encryption capabilities
     *
     * @param databaseId original database id
     * @return database with encryption capabilities
     */
    public CosmosEncryptionAsyncDatabase getCosmosEncryptionAsyncDatabase(String databaseId) {
        CosmosAsyncDatabase database = this.cosmosAsyncClient.getDatabase(databaseId);
        return new CosmosEncryptionAsyncDatabase(database, this);
    }

    /**
     * Close this {@link CosmosAsyncClient} instance and cleans up the resources.
     */
    @Override
    public void close() {
        cosmosAsyncClient.close();
    }

    private CosmosContainerProperties getContainerPropertiesWithVersionValidation(CosmosContainerResponse cosmosContainerResponse) {
        if (cosmosContainerResponse.getProperties().getClientEncryptionPolicy() == null) {
            throw new IllegalArgumentException("Container without client encryption policy cannot be used");
        }

        if (cosmosContainerResponse.getProperties().getClientEncryptionPolicy().getPolicyFormatVersion() > 1) {
            throw new UnsupportedOperationException("This version of the Encryption library cannot be used with this " +
                "container. Please upgrade to the latest version of the same.");
        }

        return cosmosContainerResponse.getProperties();
    }

    static {
        EncryptionImplementationBridgeHelpers.CosmosEncryptionAsyncClientHelper.seCosmosEncryptionAsyncClientAccessor(new EncryptionImplementationBridgeHelpers.CosmosEncryptionAsyncClientHelper.CosmosEncryptionAsyncClientAccessor() {
            @Override
            public Mono<CosmosClientEncryptionKeyProperties> getClientEncryptionPropertiesAsync(CosmosEncryptionAsyncClient cosmosEncryptionAsyncClient, String clientEncryptionKeyId, String databaseRid, CosmosAsyncContainer cosmosAsyncContainer, boolean shouldForceRefresh) {
                return cosmosEncryptionAsyncClient.getClientEncryptionPropertiesAsync(clientEncryptionKeyId,
                    databaseRid, cosmosAsyncContainer, shouldForceRefresh);
            }

            @Override
            public Mono<CosmosContainerProperties> getContainerPropertiesAsync(CosmosEncryptionAsyncClient cosmosEncryptionAsyncClient, CosmosAsyncContainer cosmosAsyncContainer, boolean shouldForceRefresh) {
                return cosmosEncryptionAsyncClient.getContainerPropertiesAsync(cosmosAsyncContainer,
                    shouldForceRefresh);
            }
        });
    }
}
