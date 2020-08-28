package org.duh102.unibot.model.events;

import org.duh102.unibot.model.RichText;
import org.duh102.unibot.model.sources.ChatChannel;
import org.duh102.unibot.model.sources.User;

public class MessageEvent extends PrivateMessageEvent {
    public MessageEvent() {
        super();
    }
    public MessageEvent(ChatChannel channel, User source, RichText message) {
        super(channel, source, message);
    }
}
