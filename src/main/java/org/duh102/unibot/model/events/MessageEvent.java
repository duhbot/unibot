package org.duh102.unibot.model.events;

import org.duh102.unibot.model.RichText;
import org.duh102.unibot.model.sources.EventSource;

public class MessageEvent implements Event {
    private RichText message;

    public MessageEvent() {
        message = new RichText();
    }
    public MessageEvent(String text) {
        message = new RichText(text);
    }


    public RichText getMessage() {
        return message;
    }

    public void setMessage(RichText message) {
        this.message = message;
    }

    @Override
    public EventSource getSource() {
        return null;
    }
}
