package org.duh102.unibot.model.events;

import org.duh102.unibot.model.text.RichText;
import org.duh102.unibot.model.sources.ChatChannel;
import org.duh102.unibot.model.sources.EventSource;
import org.duh102.unibot.model.sources.User;

import java.util.Objects;

public class PrivateMessageEvent implements Event {
    private ChatChannel context;
    private RichText message;
    private User source;

    public PrivateMessageEvent() {
    }
    public PrivateMessageEvent(ChatChannel context, User source, RichText message) {
        this.context = context;
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
        return context;
    }

    public RichText respondTo(RichText text) {
        return text;
    }

    @Override
    public boolean equals(Object o) {
        if(! (o instanceof PrivateMessageEvent)) {
            return false;
        }
        PrivateMessageEvent other = (PrivateMessageEvent)o;
        return Objects.equals(context, other.getContext())
                && Objects.equals(source, other.getSource())
                && Objects.equals(message, other.getMessage());
    }
}
