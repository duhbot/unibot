package org.duh102.unibot.model.text;

import java.util.Objects;

public class MessageResponse {

    private RichText message;


    public MessageResponse() {
        message = new RichText();
    }
    public MessageResponse(RichText message) {
        this.message = message;
    }
    public MessageResponse(String text) {
        message = new RichText(text);
    }


    public RichText getMessage() {
        return message;
    }

    public void setMessage(RichText message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if(! (o instanceof MessageResponse)) {
            return false;
        }
        MessageResponse other = (MessageResponse)o;
        return Objects.equals(message, other.getMessage());
    }
}
