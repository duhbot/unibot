package org.duh102.unibot.model.sources.identifiers;

public class DiscordServerIdentifier extends DiscordServiceSpecific implements ServerIdentifier {
    private String serverName;
    private String serverId;

    public DiscordServerIdentifier(String serverName, String serverId) {
        this.serverName = serverName;
        this.serverId = serverId;
    }

    @Override
    public String getName() {
        return serverName;
    }

    @Override
    public String getIdentifier() {
        return serverId;
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
        return serverName.compareTo(other.getIdentifier());
    }
}
