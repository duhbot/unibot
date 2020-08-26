package org.duh102.unibot.model.events;

import org.duh102.unibot.model.RichText;
import org.duh102.unibot.model.sources.User;

public class MessageEvent implements Event {
    private RichText message;
    private User source;

    public MessageEvent() {
    }
    public MessageEvent(User source, RichText message) {
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
}
