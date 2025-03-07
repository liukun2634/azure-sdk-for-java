// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datafactory.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/** Log settings of script activity. */
@Fluent
public final class ScriptActivityTypePropertiesLogSettings {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(ScriptActivityTypePropertiesLogSettings.class);

    /*
     * The destination of logs. Type: string.
     */
    @JsonProperty(value = "logDestination", required = true)
    private ScriptActivityLogDestination logDestination;

    /*
     * Log location settings customer needs to provide when enabling log.
     */
    @JsonProperty(value = "logLocationSettings")
    private LogLocationSettings logLocationSettings;

    /**
     * Get the logDestination property: The destination of logs. Type: string.
     *
     * @return the logDestination value.
     */
    public ScriptActivityLogDestination logDestination() {
        return this.logDestination;
    }

    /**
     * Set the logDestination property: The destination of logs. Type: string.
     *
     * @param logDestination the logDestination value to set.
     * @return the ScriptActivityTypePropertiesLogSettings object itself.
     */
    public ScriptActivityTypePropertiesLogSettings withLogDestination(ScriptActivityLogDestination logDestination) {
        this.logDestination = logDestination;
        return this;
    }

    /**
     * Get the logLocationSettings property: Log location settings customer needs to provide when enabling log.
     *
     * @return the logLocationSettings value.
     */
    public LogLocationSettings logLocationSettings() {
        return this.logLocationSettings;
    }

    /**
     * Set the logLocationSettings property: Log location settings customer needs to provide when enabling log.
     *
     * @param logLocationSettings the logLocationSettings value to set.
     * @return the ScriptActivityTypePropertiesLogSettings object itself.
     */
    public ScriptActivityTypePropertiesLogSettings withLogLocationSettings(LogLocationSettings logLocationSettings) {
        this.logLocationSettings = logLocationSettings;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (logDestination() == null) {
            throw logger
                .logExceptionAsError(
                    new IllegalArgumentException(
                        "Missing required property logDestination in model ScriptActivityTypePropertiesLogSettings"));
        }
        if (logLocationSettings() != null) {
            logLocationSettings().validate();
        }
    }
}
