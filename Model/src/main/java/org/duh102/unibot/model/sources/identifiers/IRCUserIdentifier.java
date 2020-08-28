package org.duh102.unibot.model.sources.identifiers;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.duh102.unibot.model.exception.ServiceSpecificUnsupportedException;

public class IRCUserIdentifier extends IRCServiceSpecific implements UserIdentifier {
    private String nickname;
    private String username;
    private String host;

    public IRCUserIdentifier() {
    }
    public IRCUserIdentifier(String nickname, String username, String host) {
        this.nickname = nickname;
        this.username = username;
        this.host = host;
    }

    public String getNickname() {
        return nickname;
    }

    public String getUsername() {
        return username;
    }

    public String getHost() {
        return host;
    }

    @Override
    public int compareTo(UserIdentifier other) {
        if(getServiceIdentifier() != other.getServiceIdentifier()) {
            return getServiceIdentifier().compareTo(other.getServiceIdentifier());
        }
        return toString().compareTo(other.toString());
    }

    @Override
    public String toString() {
        try {
            return getUniqueId();
        } catch (ServiceSpecificUnsupportedException e) {
            return nickname;
        }
    }

    @Override
    public String getDisplayName() {
        return nickname;
    }

    @JsonIgnore
    @Override
    public String getReferenceName() throws ServiceSpecificUnsupportedException {
        throw new ServiceSpecificUnsupportedException("IRC does not support user links");
    }

    @JsonIgnore
    @Override
    public String getUniqueId() throws ServiceSpecificUnsupportedException {
        throw new ServiceSpecificUnsupportedException("IRC does not support unique IDs for users");
    }
}
