package org.duh102.unibot.model.sources.identifiers.discord;

import org.duh102.unibot.model.exception.ServiceSpecificUnsupportedException;
import org.duh102.unibot.model.sources.identifiers.UserIdentifier;

import java.util.Objects;

public class DiscordUserIdentifier extends DiscordServiceSpecific implements UserIdentifier {
    private String uniqueId;
    private String username;
    private int discriminator;

    public DiscordUserIdentifier() {
    }
    public DiscordUserIdentifier(String uniqueId, String username, int discriminator) {
        this.uniqueId = uniqueId;
        this.username = username;
        this.discriminator = discriminator;
    }

    @Override
    public String getUniqueId() throws ServiceSpecificUnsupportedException {
        return uniqueId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getDiscriminator() {
        return discriminator;
    }

    public void setDiscriminator(int discriminator) {
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
    public boolean equals(Object o) {
        if(! (o instanceof DiscordUserIdentifier)) {
            return false;
        }
        DiscordUserIdentifier other = (DiscordUserIdentifier)o;
        return this.compareTo(other) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(uniqueId, username, discriminator);
    }
}
