package org.duh102.unibot.model.plugin;

import org.duh102.unibot.model.text.MessageResponse;
import org.duh102.unibot.model.events.MessageEvent;
import org.duh102.unibot.model.text.RichTextComponent;

import java.util.Map;

public interface MessageEventListener extends EventListener {
    MessageResponse onMessage(MessageEvent event);
    RichTextComponent getPrefix();
}
