package org.duh102.unibot.model.events;

import org.duh102.unibot.model.RichText;
import org.duh102.unibot.model.sources.User;

public class PrivateMessageEvent extends MessageEvent {
    public PrivateMessageEvent(User source, RichText message) {
        super(source, message);
    }
}
