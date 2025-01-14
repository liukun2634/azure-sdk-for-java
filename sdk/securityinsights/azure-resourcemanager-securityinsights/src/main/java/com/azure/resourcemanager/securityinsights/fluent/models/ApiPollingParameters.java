// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.securityinsights.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.securityinsights.models.CodelessConnectorPollingConfigProperties;
import com.azure.resourcemanager.securityinsights.models.CodelessUiConnectorConfigProperties;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/** Represents Codeless API Polling data connector. */
@Fluent
public final class ApiPollingParameters {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(ApiPollingParameters.class);

    /*
     * Config to describe the instructions blade
     */
    @JsonProperty(value = "connectorUiConfig")
    private CodelessUiConnectorConfigProperties connectorUiConfig;

    /*
     * Config to describe the polling instructions
     */
    @JsonProperty(value = "pollingConfig")
    private CodelessConnectorPollingConfigProperties pollingConfig;

    /**
     * Get the connectorUiConfig property: Config to describe the instructions blade.
     *
     * @return the connectorUiConfig value.
     */
    public CodelessUiConnectorConfigProperties connectorUiConfig() {
        return this.connectorUiConfig;
    }

    /**
     * Set the connectorUiConfig property: Config to describe the instructions blade.
     *
     * @param connectorUiConfig the connectorUiConfig value to set.
     * @return the ApiPollingParameters object itself.
     */
    public ApiPollingParameters withConnectorUiConfig(CodelessUiConnectorConfigProperties connectorUiConfig) {
        this.connectorUiConfig = connectorUiConfig;
        return this;
    }

    /**
     * Get the pollingConfig property: Config to describe the polling instructions.
     *
     * @return the pollingConfig value.
     */
    public CodelessConnectorPollingConfigProperties pollingConfig() {
        return this.pollingConfig;
    }

    /**
     * Set the pollingConfig property: Config to describe the polling instructions.
     *
     * @param pollingConfig the pollingConfig value to set.
     * @return the ApiPollingParameters object itself.
     */
    public ApiPollingParameters withPollingConfig(CodelessConnectorPollingConfigProperties pollingConfig) {
        this.pollingConfig = pollingConfig;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (connectorUiConfig() != null) {
            connectorUiConfig().validate();
        }
        if (pollingConfig() != null) {
            pollingConfig().validate();
        }
    }
}
