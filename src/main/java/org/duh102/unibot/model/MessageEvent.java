package org.duh102.unibot.model;

public class MessageEvent {
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
}
