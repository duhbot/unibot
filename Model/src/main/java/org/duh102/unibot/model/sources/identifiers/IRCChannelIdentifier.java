package org.duh102.unibot.model.sources.identifiers;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.duh102.unibot.model.exception.ServiceSpecificUnsupportedException;

public class IRCChannelIdentifier extends IRCServiceSpecific implements ChatChannelIdentifier {
    private String channelName;
    private IRCServerIdentifier serverNetwork;

    public IRCChannelIdentifier() {
    }
    public IRCChannelIdentifier(String channelName, IRCServerIdentifier serverNetwork) {
        this.channelName = channelName;
        this.serverNetwork = serverNetwork;
    }

    @Override
    public String getChannelName() {
        return channelName;
    }

    @Override
    public ServerIdentifier getServer() {
        return serverNetwork;
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
        int serverComparison = serverNetwork.compareTo(other.getServer());
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
