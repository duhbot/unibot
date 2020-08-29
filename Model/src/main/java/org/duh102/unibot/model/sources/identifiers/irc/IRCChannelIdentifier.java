package org.duh102.unibot.model.sources.identifiers.irc;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.duh102.unibot.model.exception.ServiceSpecificUnsupportedException;
import org.duh102.unibot.model.sources.identifiers.ChatChannelIdentifier;
import org.duh102.unibot.model.sources.identifiers.ServerIdentifier;

public class IRCChannelIdentifier extends IRCServiceSpecific implements ChatChannelIdentifier {
    private String channelName;
    private IRCServerIdentifier server;

    public IRCChannelIdentifier() {
    }
    public IRCChannelIdentifier(String channelName, IRCServerIdentifier server) {
        this.channelName = channelName;
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
        throw new ServiceSpecificUnsupportedException("IRC does not support channel links");
    }

    @JsonIgnore
    @Override
    public String getUniqueId() throws ServiceSpecificUnsupportedException {
        throw new ServiceSpecificUnsupportedException("IRC does not support unique IDs for channels");
    }

    @Override
    public String toString() {
        return getServer().toString() + " #" + getChannelName();
    }

    @Override
    public int compareTo(ChatChannelIdentifier other) {
        if(getServiceIdentifier() != other.getServiceIdentifier()) {
            return this.getServiceIdentifier().compareTo(other.getServiceIdentifier());
        }
        int serverComparison = server.compareTo(other.getServer());
        if(serverComparison != 0) {
            return serverComparison;
        }
        return channelName.compareTo(other.getChannelName());
    }

    @Override
    public boolean equals(Object o) {
        if(! (o instanceof IRCChannelIdentifier)) {
            return false;
        }
        IRCChannelIdentifier other = (IRCChannelIdentifier)o;
        return this.compareTo(other) == 0;
    }
}
