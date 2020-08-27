package org.duh102.unibot.model.sources.identifiers;

public class IRCServerIdentifier extends IRCServiceSpecific implements ServerIdentifier {
    /**
     * Can contain either the address (if not part of a network, or the network doesn't report a 005 NETWORK= line)
     * Or the network name (if the server is part of a network and it reports a 005 NETWORK= line)
     */
    private String serverName;

    public IRCServerIdentifier(String serverName) {
        this.serverName = serverName;
    }

    @Override
    public String getName() {
        return getIdentifier();
    }

    @Override
    public String getIdentifier() {
        return serverName;
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
}
