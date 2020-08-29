package org.duh102.unibot.model.plugin;

import org.duh102.unibot.model.text.MessageResponse;
import org.duh102.unibot.model.events.PrivateMessageEvent;

public interface PrivateMessageEventListener extends EventListener {
    MessageResponse onPrivateMessage(PrivateMessageEvent event);
}
