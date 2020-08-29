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

    @Override
    public RichText respondTo(RichText text) {
        String beginning = String.format("%s: ", getSource().getUserId().getDisplayName());
        return new RichText(new RichText(beginning), text);
    }
}
