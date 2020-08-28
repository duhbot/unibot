package org.duh102.unibot.model.sources.identifiers;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "subtype")
@JsonSubTypes({
        @JsonSubTypes.Type(value = IRCServerIdentifier.class, name = "irc"),
        @JsonSubTypes.Type(value = DiscordServerIdentifier.class, name = "discord")
})
public interface ServerIdentifier extends Comparable<ServerIdentifier>, ServiceSpecific {
    String getName();
    String getIdentifier();
}
