package org.duh102.unibot.plugin;

import org.duh102.unibot.model.events.Event;
import org.pf4j.ExtensionPoint;

public interface EventListener extends ExtensionPoint {
    boolean respondsToEvent(Event event);
}