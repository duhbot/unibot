package org.duh102.unibot.model.sources.identifiers;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class DiscordServerIdentifier extends DiscordServiceSpecific implements ServerIdentifier {
    private String serverName;
    private String serverId;

    public DiscordServerIdentifier() {
    }
    public DiscordServerIdentifier(String serverName, String serverId) {
        this.serverName = serverName;
        this.serverId = serverId;
    }

    @JsonIgnore
    @Override
    public String getName() {
        return serverName;
    }

    @JsonIgnore
    @Override
    public String getIdentifier() {
        return serverId;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getServerId() {
        return serverId;
    }

    public void setServerId(String serverId) {
        this.serverId = serverId;
    }

    @Override
    public String toString() {
        return String.format("%s (%s)", serverName, serverId);
    }

    @Override
    public int compareTo(ServerIdentifier other) {
        if(getServiceIdentifier() != other.getServiceIdentifier()) {
            return this.getServiceIdentifier().compareTo(other.getServiceIdentifier());
        }
        return serverId.compareTo(other.getIdentifier());
    }

    @Override
    public boolean equals(Object o) {
        if(! (o instanceof DiscordServerIdentifier)) {
            return false;
        }
        DiscordServerIdentifier other = (DiscordServerIdentifier)o;
        return this.compareTo(other) == 0;
    }
}
