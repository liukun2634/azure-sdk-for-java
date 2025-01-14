// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
//
// Code generated by Microsoft (R) AutoRest Code Generator.
// Changes may cause incorrect behavior and will be lost if the code is
// regenerated.

package com.azure.search.documents.indexes.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeId;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.time.Duration;
import java.util.List;

/**
 * The AML skill allows you to extend AI enrichment with a custom Azure Machine Learning (AML) model. Once an AML model
 * is trained and deployed, an AML skill integrates it into AI enrichment.
 */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "@odata.type",
        visible = true)
@JsonTypeName("#Microsoft.Skills.Custom.AmlSkill")
@Fluent
public final class AzureMachineLearningSkill extends SearchIndexerSkill {
    /*
     * Identifies the concrete type of the skill.
     */
    @JsonTypeId
    @JsonProperty(value = "@odata.type", required = true)
    private String odataType = "#Microsoft.Skills.Custom.AmlSkill";

    /*
     * (Required for no authentication or key authentication) The scoring URI
     * of the AML service to which the JSON payload will be sent. Only the
     * https URI scheme is allowed.
     */
    @JsonProperty(value = "uri")
    private String scoringUri;

    /*
     * (Required for key authentication) The key for the AML service.
     */
    @JsonProperty(value = "key")
    private String authenticationKey;

    /*
     * (Required for token authentication). The Azure Resource Manager resource
     * ID of the AML service. It should be in the format
     * subscriptions/{guid}/resourceGroups/{resource-group-name}/Microsoft.MachineLearningServices/workspaces/{workspace-name}/services/{service_name}.
     */
    @JsonProperty(value = "resourceId")
    private String resourceId;

    /*
     * (Optional) When specified, indicates the timeout for the http client
     * making the API call.
     */
    @JsonProperty(value = "timeout")
    private Duration timeout;

    /*
     * (Optional for token authentication). The region the AML service is
     * deployed in.
     */
    @JsonProperty(value = "region")
    private String region;

    /*
     * (Optional) When specified, indicates the number of calls the indexer
     * will make in parallel to the endpoint you have provided. You can
     * decrease this value if your endpoint is failing under too high of a
     * request load, or raise it if your endpoint is able to accept more
     * requests and you would like an increase in the performance of the
     * indexer. If not set, a default value of 5 is used. The
     * degreeOfParallelism can be set to a maximum of 10 and a minimum of 1.
     */
    @JsonProperty(value = "degreeOfParallelism")
    private Integer degreeOfParallelism;

    /**
     * Creates an instance of AzureMachineLearningSkill class.
     *
     * @param inputs the inputs value to set.
     * @param outputs the outputs value to set.
     */
    @JsonCreator
    public AzureMachineLearningSkill(
            @JsonProperty(value = "inputs", required = true) List<InputFieldMappingEntry> inputs,
            @JsonProperty(value = "outputs", required = true) List<OutputFieldMappingEntry> outputs) {
        super(inputs, outputs);
    }

    /**
     * Get the odataType property: Identifies the concrete type of the skill.
     *
     * @return the odataType value.
     */
    public String getOdataType() {
        return this.odataType;
    }

    /**
     * Get the scoringUri property: (Required for no authentication or key authentication) The scoring URI of the AML
     * service to which the JSON payload will be sent. Only the https URI scheme is allowed.
     *
     * @return the scoringUri value.
     */
    public String getScoringUri() {
        return this.scoringUri;
    }

    /**
     * Set the scoringUri property: (Required for no authentication or key authentication) The scoring URI of the AML
     * service to which the JSON payload will be sent. Only the https URI scheme is allowed.
     *
     * @param scoringUri the scoringUri value to set.
     * @return the AzureMachineLearningSkill object itself.
     */
    public AzureMachineLearningSkill setScoringUri(String scoringUri) {
        this.scoringUri = scoringUri;
        return this;
    }

    /**
     * Get the authenticationKey property: (Required for key authentication) The key for the AML service.
     *
     * @return the authenticationKey value.
     */
    public String getAuthenticationKey() {
        return this.authenticationKey;
    }

    /**
     * Set the authenticationKey property: (Required for key authentication) The key for the AML service.
     *
     * @param authenticationKey the authenticationKey value to set.
     * @return the AzureMachineLearningSkill object itself.
     */
    public AzureMachineLearningSkill setAuthenticationKey(String authenticationKey) {
        this.authenticationKey = authenticationKey;
        return this;
    }

    /**
     * Get the resourceId property: (Required for token authentication). The Azure Resource Manager resource ID of the
     * AML service. It should be in the format
     * subscriptions/{guid}/resourceGroups/{resource-group-name}/Microsoft.MachineLearningServices/workspaces/{workspace-name}/services/{service_name}.
     *
     * @return the resourceId value.
     */
    public String getResourceId() {
        return this.resourceId;
    }

    /**
     * Set the resourceId property: (Required for token authentication). The Azure Resource Manager resource ID of the
     * AML service. It should be in the format
     * subscriptions/{guid}/resourceGroups/{resource-group-name}/Microsoft.MachineLearningServices/workspaces/{workspace-name}/services/{service_name}.
     *
     * @param resourceId the resourceId value to set.
     * @return the AzureMachineLearningSkill object itself.
     */
    public AzureMachineLearningSkill setResourceId(String resourceId) {
        this.resourceId = resourceId;
        return this;
    }

    /**
     * Get the timeout property: (Optional) When specified, indicates the timeout for the http client making the API
     * call.
     *
     * @return the timeout value.
     */
    public Duration getTimeout() {
        return this.timeout;
    }

    /**
     * Set the timeout property: (Optional) When specified, indicates the timeout for the http client making the API
     * call.
     *
     * @param timeout the timeout value to set.
     * @return the AzureMachineLearningSkill object itself.
     */
    public AzureMachineLearningSkill setTimeout(Duration timeout) {
        this.timeout = timeout;
        return this;
    }

    /**
     * Get the region property: (Optional for token authentication). The region the AML service is deployed in.
     *
     * @return the region value.
     */
    public String getRegion() {
        return this.region;
    }

    /**
     * Set the region property: (Optional for token authentication). The region the AML service is deployed in.
     *
     * @param region the region value to set.
     * @return the AzureMachineLearningSkill object itself.
     */
    public AzureMachineLearningSkill setRegion(String region) {
        this.region = region;
        return this;
    }

    /**
     * Get the degreeOfParallelism property: (Optional) When specified, indicates the number of calls the indexer will
     * make in parallel to the endpoint you have provided. You can decrease this value if your endpoint is failing under
     * too high of a request load, or raise it if your endpoint is able to accept more requests and you would like an
     * increase in the performance of the indexer. If not set, a default value of 5 is used. The degreeOfParallelism can
     * be set to a maximum of 10 and a minimum of 1.
     *
     * @return the degreeOfParallelism value.
     */
    public Integer getDegreeOfParallelism() {
        return this.degreeOfParallelism;
    }

    /**
     * Set the degreeOfParallelism property: (Optional) When specified, indicates the number of calls the indexer will
     * make in parallel to the endpoint you have provided. You can decrease this value if your endpoint is failing under
     * too high of a request load, or raise it if your endpoint is able to accept more requests and you would like an
     * increase in the performance of the indexer. If not set, a default value of 5 is used. The degreeOfParallelism can
     * be set to a maximum of 10 and a minimum of 1.
     *
     * @param degreeOfParallelism the degreeOfParallelism value to set.
     * @return the AzureMachineLearningSkill object itself.
     */
    public AzureMachineLearningSkill setDegreeOfParallelism(Integer degreeOfParallelism) {
        this.degreeOfParallelism = degreeOfParallelism;
        return this;
    }
}
