package org.duh102.unibot.model.sources.identifiers;

/**
 * Denotes something contains service-specific data
 */
public interface ServiceSpecific {
    /**
     * Get the service identifier as a string; if this disagrees with getServiceIdentifier,
     *  it came from a service that we do not currently support
     * @return A string representation of the ServiceIdentifier; if getServiceIdentifier is a non-UNKNOWN value,
     *   this string should be deterministically mapped to the same ServiceIdentifier value
     */
    String getServiceIdentifierString();

    /**
     * Get the ServiceIdentifier for the service-specific data that this describes
     * @return The ServiceIdentifier if the source was a known Service, otherwise UNKNOWN
     */
    ServiceIdentifier getServiceIdentifier();
}
