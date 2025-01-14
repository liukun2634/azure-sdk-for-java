// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.securityinsights.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.securityinsights.models.ActionPropertiesBase;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/** Action property bag. */
@Fluent
public final class ActionResponseProperties extends ActionPropertiesBase {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(ActionResponseProperties.class);

    /*
     * The name of the logic app's workflow.
     */
    @JsonProperty(value = "workflowId")
    private String workflowId;

    /**
     * Get the workflowId property: The name of the logic app's workflow.
     *
     * @return the workflowId value.
     */
    public String workflowId() {
        return this.workflowId;
    }

    /**
     * Set the workflowId property: The name of the logic app's workflow.
     *
     * @param workflowId the workflowId value to set.
     * @return the ActionResponseProperties object itself.
     */
    public ActionResponseProperties withWorkflowId(String workflowId) {
        this.workflowId = workflowId;
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public ActionResponseProperties withLogicAppResourceId(String logicAppResourceId) {
        super.withLogicAppResourceId(logicAppResourceId);
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    @Override
    public void validate() {
        super.validate();
    }
}
