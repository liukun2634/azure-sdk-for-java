// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.botservice.fluent;

import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.Response;
import com.azure.core.util.Context;
import com.azure.resourcemanager.botservice.fluent.models.BotInner;
import com.azure.resourcemanager.botservice.fluent.models.CheckNameAvailabilityResponseBodyInner;
import com.azure.resourcemanager.botservice.models.CheckNameAvailabilityRequestBody;

/** An instance of this class provides access to all the operations defined in BotsClient. */
public interface BotsClient {
    /**
     * Creates a Bot Service. Bot Service is a resource group wide resource type.
     *
     * @param resourceGroupName The name of the Bot resource group in the user subscription.
     * @param resourceName The name of the Bot resource.
     * @param parameters The parameters to provide for the created bot.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return bot resource definition.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    BotInner create(String resourceGroupName, String resourceName, BotInner parameters);

    /**
     * Creates a Bot Service. Bot Service is a resource group wide resource type.
     *
     * @param resourceGroupName The name of the Bot resource group in the user subscription.
     * @param resourceName The name of the Bot resource.
     * @param parameters The parameters to provide for the created bot.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return bot resource definition along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<BotInner> createWithResponse(
        String resourceGroupName, String resourceName, BotInner parameters, Context context);

    /**
     * Updates a Bot Service.
     *
     * @param resourceGroupName The name of the Bot resource group in the user subscription.
     * @param resourceName The name of the Bot resource.
     * @param parameters The parameters to provide for the created bot.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return bot resource definition.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    BotInner update(String resourceGroupName, String resourceName, BotInner parameters);

    /**
     * Updates a Bot Service.
     *
     * @param resourceGroupName The name of the Bot resource group in the user subscription.
     * @param resourceName The name of the Bot resource.
     * @param parameters The parameters to provide for the created bot.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return bot resource definition along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<BotInner> updateWithResponse(
        String resourceGroupName, String resourceName, BotInner parameters, Context context);

    /**
     * Deletes a Bot Service from the resource group.
     *
     * @param resourceGroupName The name of the Bot resource group in the user subscription.
     * @param resourceName The name of the Bot resource.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    void delete(String resourceGroupName, String resourceName);

    /**
     * Deletes a Bot Service from the resource group.
     *
     * @param resourceGroupName The name of the Bot resource group in the user subscription.
     * @param resourceName The name of the Bot resource.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<Void> deleteWithResponse(String resourceGroupName, String resourceName, Context context);

    /**
     * Returns a BotService specified by the parameters.
     *
     * @param resourceGroupName The name of the Bot resource group in the user subscription.
     * @param resourceName The name of the Bot resource.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return bot resource definition.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    BotInner getByResourceGroup(String resourceGroupName, String resourceName);

    /**
     * Returns a BotService specified by the parameters.
     *
     * @param resourceGroupName The name of the Bot resource group in the user subscription.
     * @param resourceName The name of the Bot resource.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return bot resource definition along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<BotInner> getByResourceGroupWithResponse(String resourceGroupName, String resourceName, Context context);

    /**
     * Returns all the resources of a particular type belonging to a resource group.
     *
     * @param resourceGroupName The name of the Bot resource group in the user subscription.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the list of bot service operation response.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<BotInner> listByResourceGroup(String resourceGroupName);

    /**
     * Returns all the resources of a particular type belonging to a resource group.
     *
     * @param resourceGroupName The name of the Bot resource group in the user subscription.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the list of bot service operation response.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<BotInner> listByResourceGroup(String resourceGroupName, Context context);

    /**
     * Returns all the resources of a particular type belonging to a subscription.
     *
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the list of bot service operation response.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<BotInner> list();

    /**
     * Returns all the resources of a particular type belonging to a subscription.
     *
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the list of bot service operation response.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<BotInner> list(Context context);

    /**
     * Check whether a bot name is available.
     *
     * @param parameters The request body parameters to provide for the check name availability request.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response body returned for a request to Bot Service Management to check availability of a bot name.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    CheckNameAvailabilityResponseBodyInner getCheckNameAvailability(CheckNameAvailabilityRequestBody parameters);

    /**
     * Check whether a bot name is available.
     *
     * @param parameters The request body parameters to provide for the check name availability request.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response body returned for a request to Bot Service Management to check availability of a bot name
     *     along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<CheckNameAvailabilityResponseBodyInner> getCheckNameAvailabilityWithResponse(
        CheckNameAvailabilityRequestBody parameters, Context context);
}
