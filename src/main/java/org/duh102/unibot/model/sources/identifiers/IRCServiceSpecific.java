package org.duh102.unibot.model.sources.identifiers;

public abstract class IRCServiceSpecific implements ServiceSpecific {
    @Override
    public String getServiceIdentifierString() {
        return getServiceIdentifier().toString();
    }

    @Override
    public ServiceIdentifier getServiceIdentifier() {
        return ServiceIdentifier.IRC;
    }
}
