package org.duh102.unibot.model.sources.identifiers;

import org.duh102.unibot.model.exception.ServiceSpecificUnsupportedException;

public interface ChatChannelIdentifier extends Comparable<ChatChannelIdentifier>, ServiceSpecific {
    String getChannelName();
    ServerIdentifier getServer();
    String getReferenceName() throws ServiceSpecificUnsupportedException;
    String getUniqueId() throws ServiceSpecificUnsupportedException;
}
