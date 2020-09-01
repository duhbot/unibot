package org.duh102.unibot.model.sources.identifiers.irc;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.duh102.unibot.model.exception.ServiceSpecificUnsupportedException;
import org.duh102.unibot.model.sources.identifiers.UserIdentifier;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IRCUserIdentifier extends IRCServiceSpecific implements UserIdentifier {
    private String nickname;
    private String username;
    private String host;
    public static final Pattern IRC_USER_PAT = Pattern.compile("^(?<nick>[^!]+)!(?<name>[^@]+)@(?<host>[^\n \t]+)$");

    public IRCUserIdentifier() {
    }
    public IRCUserIdentifier(String serializedForm) throws Exception {
        Matcher match = IRC_USER_PAT.matcher(serializedForm);
        if(!match.matches()) {
            throw new Exception(String.format("Invalid user string %s", serializedForm));
        }
        nickname = match.group("nick");
        username = match.group("name");
        host = match.group("host");
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
    public boolean equals(Object o) {
        if(! (o instanceof IRCUserIdentifier)) {
            return false;
        }
        IRCUserIdentifier other = (IRCUserIdentifier)o;
        return this.compareTo(other) == 0;
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

    @Override
    public int hashCode() {
        return Objects.hash(nickname, username, host);
    }
}
