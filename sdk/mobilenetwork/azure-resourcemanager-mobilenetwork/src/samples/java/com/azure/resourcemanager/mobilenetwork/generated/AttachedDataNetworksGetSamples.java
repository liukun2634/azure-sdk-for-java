// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.mobilenetwork.generated;

import com.azure.core.util.Context;

/** Samples for AttachedDataNetworks Get. */
public final class AttachedDataNetworksGetSamples {
    /*
     * x-ms-original-file: specification/mobilenetwork/resource-manager/Microsoft.MobileNetwork/preview/2022-01-01-preview/examples/AttachedDataNetworkGet.json
     */
    /**
     * Sample code: Get attached data network.
     *
     * @param manager Entry point to MobileNetworkManager.
     */
    public static void getAttachedDataNetwork(com.azure.resourcemanager.mobilenetwork.MobileNetworkManager manager) {
        manager
            .attachedDataNetworks()
            .getWithResponse("rg1", "TestPacketCoreCP", "TestPacketCoreDP", "TestAttachedDataNetwork", Context.NONE);
    }
}
