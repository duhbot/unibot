package org.duh102.unibot.model.sources.identifiers;

import org.duh102.unibot.model.exception.ServiceSpecificUnsupportedException;

public class IRCIdentifier implements UserIdentifier {
    private String nickname;
    private String username;
    private String host;

    public IRCIdentifier(String nickname, String username, String host) {
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
        return nickname + "!" + username + "@" + host;
    }

    @Override
    public String getServiceIdentifierString() {
        return getServiceIdentifier().name();
    }

    @Override
    public ServiceIdentifier getServiceIdentifier() {
        return ServiceIdentifier.IRC;
    }

    @Override
    public String getDisplayName() {
        return nickname;
    }

    @Override
    public String getReferenceName() throws ServiceSpecificUnsupportedException {
        throw new ServiceSpecificUnsupportedException("IRC does not support user links");
    }
}
