package org.duh102.unibot.model.sources.identifiers;

public abstract class IRCServiceSpecific implements ServiceSpecific {
    @Override
    public ServiceIdentifier getServiceIdentifier() {
        return ServiceIdentifier.IRC;
    }
}
