package org.duh102.unibot.model.sources.identifiers;

import org.duh102.unibot.model.exception.ServiceSpecificUnsupportedException;

public class DiscordUserIdentifier extends DiscordServiceSpecific implements UserIdentifier {
    private String uniqueID;
    private String username;
    private int discriminator;

    public DiscordUserIdentifier(String uniqueID, String username, int discriminator) {
        this.uniqueID = uniqueID;
        this.username = username;
        this.discriminator = discriminator;
    }

    @Override
    public String getDisplayName() {
        return username;
    }

    public int getDiscriminator() {
        return discriminator;
    }

    @Override
    public String getUniqueId() throws ServiceSpecificUnsupportedException {
        return uniqueID;
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
}
