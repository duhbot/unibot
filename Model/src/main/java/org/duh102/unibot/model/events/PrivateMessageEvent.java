package org.duh102.unibot.model.events;

import org.duh102.unibot.model.text.RichText;
import org.duh102.unibot.model.sources.ChatChannel;
import org.duh102.unibot.model.sources.EventSource;
import org.duh102.unibot.model.sources.User;

public class PrivateMessageEvent implements Event {
    private ChatChannel channel;
    private RichText message;
    private User source;

    public PrivateMessageEvent() {
    }
    public PrivateMessageEvent(ChatChannel channel, User source, RichText message) {
        this.channel = channel;
        this.source = source;
        this.message = message;
    }

    public RichText getMessage() {
        return message;
    }

    @Override
    public User getSource() {
        return source;
    }

    @Override
    public EventSource getContext() {
        return channel;
    }

    public RichText respondTo(RichText text) {
        return text;
    }
}
