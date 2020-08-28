package org.duh102.unibot.model.sources.identifiers;

import org.duh102.unibot.model.exception.ServiceSpecificUnsupportedException;

public class DiscordChannelIdentifier extends DiscordServiceSpecific implements ChatChannelIdentifier {
    String channelName;
    String channelId;
    DiscordServerIdentifier server;

    public DiscordChannelIdentifier() {
    }
    public DiscordChannelIdentifier(String channelName, String channelId, DiscordServerIdentifier server) {
        this.channelName = channelName;
        this.channelId = channelId;
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

    @Override
    public String getReferenceName() throws ServiceSpecificUnsupportedException {
        return "#" + channelName;
    }

    @Override
    public String getUniqueId() throws ServiceSpecificUnsupportedException {
        return channelId;
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
}
