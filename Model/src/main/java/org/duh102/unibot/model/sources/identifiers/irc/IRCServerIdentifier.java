package org.duh102.unibot.model.sources.identifiers.irc;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.duh102.unibot.model.sources.identifiers.ServerIdentifier;

public class IRCServerIdentifier extends IRCServiceSpecific implements ServerIdentifier {

    /**
     * Can contain either the address (if not part of a network, or the network doesn't report a 005 NETWORK= line)
     * Or the network name (if the server is part of a network and it reports a 005 NETWORK= line)
     */
    private String serverName;

    public IRCServerIdentifier() {
    }
    public IRCServerIdentifier(String serverName) {
        this.serverName = serverName;
    }

    @JsonIgnore
    @Override
    public String getName() {
        return getIdentifier();
    }

    @JsonIgnore
    @Override
    public String getIdentifier() {
        return serverName;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    @Override
    public String toString() {
        return serverName;
    }

    @Override
    public int compareTo(ServerIdentifier other) {
        if(getServiceIdentifier() != other.getServiceIdentifier()) {
            return this.getServiceIdentifier().compareTo(other.getServiceIdentifier());
        }
        return serverName.compareTo(other.getIdentifier());
    }

    @Override
    public boolean equals(Object o) {
        if(! (o instanceof IRCServerIdentifier)) {
            return false;
        }
        IRCServerIdentifier other = (IRCServerIdentifier)o;
        return this.compareTo(other) == 0;
    }
}
