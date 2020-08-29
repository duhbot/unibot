package org.duh102.unibot.model.sources.identifiers;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.duh102.unibot.model.exception.ServiceSpecificUnsupportedException;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "subtype")
@JsonSubTypes({
        @JsonSubTypes.Type(value = IRCUserIdentifier.class, name = "irc"),
        @JsonSubTypes.Type(value = DiscordUserIdentifier.class, name = "discord")
})
public interface UserIdentifier extends Comparable<UserIdentifier>, ServiceSpecific {
    /**
     * Get the nice display name for a user
     * @return A string display name for the user
     */
    @JsonIgnore
    String getDisplayName();

    /**
     * Get the "linkable" version of the user id
     * @return A string that contains the "linkable" version of the user id
     */
    @JsonIgnore
    String getReferenceName() throws ServiceSpecificUnsupportedException;

    /**
     * Get the unique identifier of the user
     * @return A string representation that contains the unique id of the user
     * @throws ServiceSpecificUnsupportedException if the backing service does not have such a concept
     */
    String getUniqueId() throws ServiceSpecificUnsupportedException;

    void setUniqueId(String uniqueId) throws ServiceSpecificUnsupportedException;
}
