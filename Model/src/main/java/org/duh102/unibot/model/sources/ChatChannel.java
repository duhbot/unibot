package org.duh102.unibot.model.sources;

import org.duh102.unibot.model.sources.identifiers.ChatChannelIdentifier;

import java.util.ArrayList;
import java.util.List;

public class ChatChannel implements EventSource {
    ChatChannelIdentifier identifier;
    List<User> users;

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
}
