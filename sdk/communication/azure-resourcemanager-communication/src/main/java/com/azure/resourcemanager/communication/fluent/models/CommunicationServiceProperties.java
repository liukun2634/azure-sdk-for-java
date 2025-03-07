// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.communication.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.communication.models.ProvisioningState;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/** A class that describes the properties of the CommunicationService. */
@Fluent
public final class CommunicationServiceProperties {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(CommunicationServiceProperties.class);

    /*
     * Provisioning state of the resource.
     */
    @JsonProperty(value = "provisioningState", access = JsonProperty.Access.WRITE_ONLY)
    private ProvisioningState provisioningState;

    /*
     * FQDN of the CommunicationService instance.
     */
    @JsonProperty(value = "hostName", access = JsonProperty.Access.WRITE_ONLY)
    private String hostname;

    /*
     * The location where the communication service stores its data at rest.
     */
    @JsonProperty(value = "dataLocation", required = true)
    private String dataLocation;

    /*
     * Resource ID of an Azure Notification Hub linked to this resource.
     */
    @JsonProperty(value = "notificationHubId", access = JsonProperty.Access.WRITE_ONLY)
    private String notificationHubId;

    /*
     * Version of the CommunicationService resource. Probably you need the same
     * or higher version of client SDKs.
     */
    @JsonProperty(value = "version", access = JsonProperty.Access.WRITE_ONLY)
    private String version;

    /*
     * The immutable resource Id of the communication service.
     */
    @JsonProperty(value = "immutableResourceId", access = JsonProperty.Access.WRITE_ONLY)
    private String immutableResourceId;

    /**
     * Get the provisioningState property: Provisioning state of the resource.
     *
     * @return the provisioningState value.
     */
    public ProvisioningState provisioningState() {
        return this.provisioningState;
    }

    /**
     * Get the hostname property: FQDN of the CommunicationService instance.
     *
     * @return the hostname value.
     */
    public String hostname() {
        return this.hostname;
    }

    /**
     * Get the dataLocation property: The location where the communication service stores its data at rest.
     *
     * @return the dataLocation value.
     */
    public String dataLocation() {
        return this.dataLocation;
    }

    /**
     * Set the dataLocation property: The location where the communication service stores its data at rest.
     *
     * @param dataLocation the dataLocation value to set.
     * @return the CommunicationServiceProperties object itself.
     */
    public CommunicationServiceProperties withDataLocation(String dataLocation) {
        this.dataLocation = dataLocation;
        return this;
    }

    /**
     * Get the notificationHubId property: Resource ID of an Azure Notification Hub linked to this resource.
     *
     * @return the notificationHubId value.
     */
    public String notificationHubId() {
        return this.notificationHubId;
    }

    /**
     * Get the version property: Version of the CommunicationService resource. Probably you need the same or higher
     * version of client SDKs.
     *
     * @return the version value.
     */
    public String version() {
        return this.version;
    }

    /**
     * Get the immutableResourceId property: The immutable resource Id of the communication service.
     *
     * @return the immutableResourceId value.
     */
    public String immutableResourceId() {
        return this.immutableResourceId;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (dataLocation() == null) {
            throw logger
                .logExceptionAsError(
                    new IllegalArgumentException(
                        "Missing required property dataLocation in model CommunicationServiceProperties"));
        }
    }
}
