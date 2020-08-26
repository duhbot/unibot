package org.duh102.unibot.plugin;

import org.duh102.unibot.model.MessageResponse;
import org.duh102.unibot.model.events.PrivateMessageEvent;

public interface PrivateMessageEventListener extends EventListener {
    MessageResponse onPrivateMessage(PrivateMessageEvent event);
}
