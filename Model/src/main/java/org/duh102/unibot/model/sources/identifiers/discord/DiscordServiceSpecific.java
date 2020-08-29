package org.duh102.unibot.model.sources.identifiers.discord;

import org.duh102.unibot.model.sources.identifiers.ServiceIdentifier;
import org.duh102.unibot.model.sources.identifiers.ServiceSpecific;

public abstract class DiscordServiceSpecific implements ServiceSpecific {

    @Override
    public ServiceIdentifier getServiceIdentifier() {
        return ServiceIdentifier.DISCORD;
    }
}
