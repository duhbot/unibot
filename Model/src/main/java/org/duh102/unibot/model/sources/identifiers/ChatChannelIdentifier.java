package org.duh102.unibot.model.sources.identifiers;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.duh102.unibot.model.exception.ServiceSpecificUnsupportedException;
import org.duh102.unibot.model.sources.identifiers.discord.DiscordChannelIdentifier;
import org.duh102.unibot.model.sources.identifiers.irc.IRCChannelIdentifier;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "subtype")
@JsonSubTypes({
        @JsonSubTypes.Type(value = IRCChannelIdentifier.class, name = "irc"),
        @JsonSubTypes.Type(value = DiscordChannelIdentifier.class, name = "discord")
})
public interface ChatChannelIdentifier extends Comparable<ChatChannelIdentifier>, ServiceSpecific {
    String getChannelName();
    ServerIdentifier getServer();
    String getReferenceName() throws ServiceSpecificUnsupportedException;
    String getUniqueId() throws ServiceSpecificUnsupportedException;
}
