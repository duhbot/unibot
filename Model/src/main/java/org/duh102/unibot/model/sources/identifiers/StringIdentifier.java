package org.duh102.unibot.model.sources.identifiers;

import org.duh102.unibot.model.sources.ChatChannel;

import java.util.Objects;

public class StringIdentifier implements ServiceSpecific {
    private String identifier;

    public StringIdentifier() {
        super();
    }
    public StringIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }

    @Override
    public ServiceIdentifier getServiceIdentifier() {
        return ServiceIdentifier.GENERIC;
    }

    @Override
    public boolean equals(Object o) {
        if(! (o instanceof StringIdentifier)) {
            return false;
        }
        StringIdentifier other = (StringIdentifier)o;
        return Objects.equals(identifier, other.getIdentifier());
    }

    @Override
    public int hashCode() {
        return Objects.hash(identifier);
    }
}
