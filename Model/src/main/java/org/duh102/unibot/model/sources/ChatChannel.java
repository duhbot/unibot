package org.duh102.unibot.model.sources;

import org.duh102.unibot.model.sources.identifiers.ChatChannelIdentifier;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ChatChannel implements EventSource {
    ChatChannelIdentifier identifier;
    List<User> users;

    public ChatChannel() {
    }
    public ChatChannel(ChatChannelIdentifier identifier) {
        this.identifier = identifier;
        users = new ArrayList<>();
    }
    public ChatChannel(ChatChannelIdentifier identifier, List<User> users) {
        this.identifier = identifier;
        this.users = new ArrayList<>(users);
    }

    public ChatChannelIdentifier getIdentifier() {
        return identifier;
    }

    public List<User> getUsers() {
        return users;
    }

    @Override
    public String toString() {
        return identifier.toString();
    }

    @Override
    public boolean equals(Object o) {
        if(! (o instanceof ChatChannel)) {
            return false;
        }
        ChatChannel other = (ChatChannel)o;
        return Objects.equals(identifier, other.getIdentifier())
                && Objects.equals(users, other.getUsers());
    }
}
