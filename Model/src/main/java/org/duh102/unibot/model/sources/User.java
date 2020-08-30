package org.duh102.unibot.model.sources;

import org.duh102.unibot.model.sources.identifiers.UserIdentifier;

import java.util.Objects;

public class User implements EventSource {
    private UserIdentifier userId;

    public User() {
    }
    public User(UserIdentifier userId) {
        this.userId = userId;
    }
    public String toString() {
        return userId.toString();
    }
    
    public UserIdentifier getUserId() {
        return userId;
    }

    @Override
    public boolean equals(Object o) {
        if(! (o instanceof User)) {
            return false;
        }
        User other = (User)o;
        return Objects.equals(userId, other.getUserId());
    }
}
