// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.mobilenetwork.models;

import com.azure.core.management.Region;
import com.azure.core.util.Context;
import com.azure.resourcemanager.mobilenetwork.fluent.models.DataNetworkInner;
import java.util.Map;

/** An immutable client-side representation of DataNetwork. */
public interface DataNetwork {
    /**
     * Gets the id property: Fully qualified resource Id for the resource.
     *
     * @return the id value.
     */
    String id();

    /**
     * Gets the name property: The name of the resource.
     *
     * @return the name value.
     */
    String name();

    /**
     * Gets the type property: The type of the resource.
     *
     * @return the type value.
     */
    String type();

    /**
     * Gets the location property: The geo-location where the resource lives.
     *
     * @return the location value.
     */
    String location();

    /**
     * Gets the tags property: Resource tags.
     *
     * @return the tags value.
     */
    Map<String, String> tags();

    /**
     * Gets the provisioningState property: The provisioning state of the data network resource.
     *
     * @return the provisioningState value.
     */
    ProvisioningState provisioningState();

    /**
     * Gets the description property: An optional description for this data network.
     *
     * @return the description value.
     */
    String description();

    /**
     * Gets the region of the resource.
     *
     * @return the region of the resource.
     */
    Region region();

    /**
     * Gets the name of the resource region.
     *
     * @return the name of the resource region.
     */
    String regionName();

    /**
     * Gets the inner com.azure.resourcemanager.mobilenetwork.fluent.models.DataNetworkInner object.
     *
     * @return the inner object.
     */
    DataNetworkInner innerModel();

    /** The entirety of the DataNetwork definition. */
    interface Definition
        extends DefinitionStages.Blank,
            DefinitionStages.WithLocation,
            DefinitionStages.WithParentResource,
            DefinitionStages.WithCreate {
    }
    /** The DataNetwork definition stages. */
    interface DefinitionStages {
        /** The first stage of the DataNetwork definition. */
        interface Blank extends WithLocation {
        }
        /** The stage of the DataNetwork definition allowing to specify location. */
        interface WithLocation {
            /**
             * Specifies the region for the resource.
             *
             * @param location The geo-location where the resource lives.
             * @return the next definition stage.
             */
            WithParentResource withRegion(Region location);

            /**
             * Specifies the region for the resource.
             *
             * @param location The geo-location where the resource lives.
             * @return the next definition stage.
             */
            WithParentResource withRegion(String location);
        }
        /** The stage of the DataNetwork definition allowing to specify parent resource. */
        interface WithParentResource {
            /**
             * Specifies resourceGroupName, mobileNetworkName.
             *
             * @param resourceGroupName The name of the resource group. The name is case insensitive.
             * @param mobileNetworkName The name of the mobile network.
             * @return the next definition stage.
             */
            WithCreate withExistingMobileNetwork(String resourceGroupName, String mobileNetworkName);
        }
        /**
         * The stage of the DataNetwork definition which contains all the minimum required properties for the resource
         * to be created, but also allows for any other optional properties to be specified.
         */
        interface WithCreate extends DefinitionStages.WithTags, DefinitionStages.WithDescription {
            /**
             * Executes the create request.
             *
             * @return the created resource.
             */
            DataNetwork create();

            /**
             * Executes the create request.
             *
             * @param context The context to associate with this operation.
             * @return the created resource.
             */
            DataNetwork create(Context context);
        }
        /** The stage of the DataNetwork definition allowing to specify tags. */
        interface WithTags {
            /**
             * Specifies the tags property: Resource tags..
             *
             * @param tags Resource tags.
             * @return the next definition stage.
             */
            WithCreate withTags(Map<String, String> tags);
        }
        /** The stage of the DataNetwork definition allowing to specify description. */
        interface WithDescription {
            /**
             * Specifies the description property: An optional description for this data network..
             *
             * @param description An optional description for this data network.
             * @return the next definition stage.
             */
            WithCreate withDescription(String description);
        }
    }
    /**
     * Begins update for the DataNetwork resource.
     *
     * @return the stage of resource update.
     */
    DataNetwork.Update update();

    /** The template for DataNetwork update. */
    interface Update extends UpdateStages.WithTags {
        /**
         * Executes the update request.
         *
         * @return the updated resource.
         */
        DataNetwork apply();

        /**
         * Executes the update request.
         *
         * @param context The context to associate with this operation.
         * @return the updated resource.
         */
        DataNetwork apply(Context context);
    }
    /** The DataNetwork update stages. */
    interface UpdateStages {
        /** The stage of the DataNetwork update allowing to specify tags. */
        interface WithTags {
            /**
             * Specifies the tags property: Resource tags..
             *
             * @param tags Resource tags.
             * @return the next definition stage.
             */
            Update withTags(Map<String, String> tags);
        }
    }
    /**
     * Refreshes the resource to sync with Azure.
     *
     * @return the refreshed resource.
     */
    DataNetwork refresh();

    /**
     * Refreshes the resource to sync with Azure.
     *
     * @param context The context to associate with this operation.
     * @return the refreshed resource.
     */
    DataNetwork refresh(Context context);
}
