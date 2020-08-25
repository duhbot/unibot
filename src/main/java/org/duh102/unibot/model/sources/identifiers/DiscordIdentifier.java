package org.duh102.unibot.model.sources.identifiers;

import org.duh102.unibot.model.exception.ServiceSpecificUnsupportedException;

public class DiscordIdentifier implements UserIdentifier {
    private String uniqueID;
    private String username;
    private int discriminator;

    public DiscordIdentifier(String uniqueID, String username, int discriminator) {
        this.uniqueID = uniqueID;
        this.username = username;
        this.discriminator = discriminator;
    }

    @Override
    public String getDisplayName() {
        return username;
    }

    @Override
    public String getReferenceName() throws ServiceSpecificUnsupportedException {
        return "@" + username + "#" + discriminator;
    }

    @Override
    public String toString() {
        return username + "#" + discriminator;
    }

    @Override
    public int compareTo(UserIdentifier other) {
        if(getServiceIdentifier() != other.getServiceIdentifier()) {
            return getServiceIdentifier().compareTo(other.getServiceIdentifier());
        }
        return toString().compareTo(other.toString());
    }

    @Override
    public String getServiceIdentifierString() {
        return getServiceIdentifier().name();
    }

    @Override
    public ServiceIdentifier getServiceIdentifier() {
        return ServiceIdentifier.DISCORD;
    }
}
