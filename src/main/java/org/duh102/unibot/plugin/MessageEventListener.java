package org.duh102.unibot.plugin;

import org.duh102.unibot.model.MessageResponse;
import org.duh102.unibot.model.events.MessageEvent;

public interface MessageEventListener extends EventListener {
    MessageResponse onMessage(MessageEvent event);
}
