package org.duh102.unibot.model.sources.identifiers.irc;

import org.duh102.unibot.model.sources.identifiers.ServiceIdentifier;
import org.duh102.unibot.model.sources.identifiers.ServiceSpecific;

public abstract class IRCServiceSpecific implements ServiceSpecific {
    @Override
    public ServiceIdentifier getServiceIdentifier() {
        return ServiceIdentifier.IRC;
    }
}
