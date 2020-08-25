package org.duh102.unibot.model.sources.identifiers;

public class StringIdentifier implements ServiceSpecific {
    private String identifier;

    public StringIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }

    @Override
    public String getServiceIdentifierString() {
        return getServiceIdentifier().name();
    }

    @Override
    public ServiceIdentifier getServiceIdentifier() {
        return ServiceIdentifier.GENERIC;
    }
}
