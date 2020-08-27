package org.duh102.unibot.model.sources.identifiers;

public abstract class DiscordServiceSpecific implements ServiceSpecific {
    @Override
    public String getServiceIdentifierString() {
        return getServiceIdentifier().name();
    }

    @Override
    public ServiceIdentifier getServiceIdentifier() {
        return ServiceIdentifier.DISCORD;
    }
}
