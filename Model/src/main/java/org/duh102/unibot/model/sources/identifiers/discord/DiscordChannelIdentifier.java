package org.duh102.unibot.model.sources.identifiers.discord;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.duh102.unibot.model.exception.ServiceSpecificUnsupportedException;
import org.duh102.unibot.model.sources.identifiers.ChatChannelIdentifier;
import org.duh102.unibot.model.sources.identifiers.ServerIdentifier;

public class DiscordChannelIdentifier extends DiscordServiceSpecific implements ChatChannelIdentifier {
    String channelName;
    String uniqueId;
    DiscordServerIdentifier server;

    public DiscordChannelIdentifier() {
    }
    public DiscordChannelIdentifier(String channelName, String uniqueId, DiscordServerIdentifier server) {
        this.channelName = channelName;
        this.uniqueId = uniqueId;
        this.server = server;
    }


    @Override
    public String getChannelName() {
        return channelName;
    }

    @Override
    public ServerIdentifier getServer() {
        return server;
    }

    @JsonIgnore
    @Override
    public String getReferenceName() throws ServiceSpecificUnsupportedException {
        return "#" + channelName;
    }

    @Override
    public String getUniqueId() throws ServiceSpecificUnsupportedException {
        return uniqueId;
    }

    @Override
    public String toString() {
        return server.toString() + " #" + channelName;
    }

    @Override
    public int compareTo(ChatChannelIdentifier other) {
        if(getServiceIdentifier() != other.getServiceIdentifier()) {
            return getServiceIdentifier().compareTo(other.getServiceIdentifier());
        }
        int serverComparison = server.compareTo(other.getServer());
        if(serverComparison != 0) {
            return serverComparison;
        }
        return channelName.compareTo(other.getChannelName());
    }

    @Override
    public boolean equals(Object o) {
        if(! (o instanceof DiscordChannelIdentifier)) {
            return false;
        }
        DiscordChannelIdentifier other = (DiscordChannelIdentifier)o;
        return this.compareTo(other) == 0;
    }
}
