package org.duh102.unibot.model.sources.identifiers;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;

public enum ServiceIdentifier {
    @JsonEnumDefaultValue
    UNKNOWN,
    GENERIC,
    IRC,
    DISCORD,
    SLACK;

    public String toString() {
        return this.name();
    }
}
