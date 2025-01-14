// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.securityinsights.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/** The InsightQueryItemPropertiesTableQueryQueriesDefinitionsPropertiesItemsItem model. */
@Fluent
public final class InsightQueryItemPropertiesTableQueryQueriesDefinitionsPropertiesItemsItem {
    @JsonIgnore
    private final ClientLogger logger =
        new ClientLogger(InsightQueryItemPropertiesTableQueryQueriesDefinitionsPropertiesItemsItem.class);

    /*
     * Insight Link Definition Projected Name.
     */
    @JsonProperty(value = "projectedName")
    private String projectedName;

    /*
     * Insight Link Definition Query.
     */
    @JsonProperty(value = "Query")
    private String query;

    /**
     * Get the projectedName property: Insight Link Definition Projected Name.
     *
     * @return the projectedName value.
     */
    public String projectedName() {
        return this.projectedName;
    }

    /**
     * Set the projectedName property: Insight Link Definition Projected Name.
     *
     * @param projectedName the projectedName value to set.
     * @return the InsightQueryItemPropertiesTableQueryQueriesDefinitionsPropertiesItemsItem object itself.
     */
    public InsightQueryItemPropertiesTableQueryQueriesDefinitionsPropertiesItemsItem withProjectedName(
        String projectedName) {
        this.projectedName = projectedName;
        return this;
    }

    /**
     * Get the query property: Insight Link Definition Query.
     *
     * @return the query value.
     */
    public String query() {
        return this.query;
    }

    /**
     * Set the query property: Insight Link Definition Query.
     *
     * @param query the query value to set.
     * @return the InsightQueryItemPropertiesTableQueryQueriesDefinitionsPropertiesItemsItem object itself.
     */
    public InsightQueryItemPropertiesTableQueryQueriesDefinitionsPropertiesItemsItem withQuery(String query) {
        this.query = query;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
    }
}
