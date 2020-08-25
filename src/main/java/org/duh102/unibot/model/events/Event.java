package org.duh102.unibot.model.events;

import org.duh102.unibot.model.sources.EventSource;

public interface Event {
    EventSource getSource();
}
