// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.securityinsights.models;

import com.azure.core.util.ExpandableStringEnum;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.Collection;

/** Defines values for EntityQueriesKind. */
public final class EntityQueriesKind extends ExpandableStringEnum<EntityQueriesKind> {
    /** Static value Expansion for EntityQueriesKind. */
    public static final EntityQueriesKind EXPANSION = fromString("Expansion");

    /** Static value Activity for EntityQueriesKind. */
    public static final EntityQueriesKind ACTIVITY = fromString("Activity");

    /**
     * Creates or finds a EntityQueriesKind from its string representation.
     *
     * @param name a name to look for.
     * @return the corresponding EntityQueriesKind.
     */
    @JsonCreator
    public static EntityQueriesKind fromString(String name) {
        return fromString(name, EntityQueriesKind.class);
    }

    /** @return known EntityQueriesKind values. */
    public static Collection<EntityQueriesKind> values() {
        return values(EntityQueriesKind.class);
    }
}
