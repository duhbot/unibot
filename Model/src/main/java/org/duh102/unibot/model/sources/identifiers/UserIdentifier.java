package org.duh102.unibot.model.sources.identifiers;

import org.duh102.unibot.model.exception.ServiceSpecificUnsupportedException;

public interface UserIdentifier extends Comparable<UserIdentifier>, ServiceSpecific {
    /**
     * Get the nice display name for a user
     * @return A string display name for the user
     */
    String getDisplayName();

    /**
     * Get the "linkable" version of the user id
     * @return A string that contains the "linkable" version of the user id
     */
    String getReferenceName() throws ServiceSpecificUnsupportedException;

    /**
     * Get the unique identifier of the user
     * @return A string representation that contains the unique id of the user
     * @throws ServiceSpecificUnsupportedException if the backing service does not have such a concept
     */
    String getUniqueId() throws ServiceSpecificUnsupportedException;
}
