package org.duh102.unibot.model.sources.identifiers;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Denotes something contains service-specific data
 */
public interface ServiceSpecific {
    /**
     * Get the ServiceIdentifier for the service-specific data that this describes
     * @return The ServiceIdentifier
     */
    @JsonIgnore
    ServiceIdentifier getServiceIdentifier();
}
