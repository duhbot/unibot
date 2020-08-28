package org.duh102.unibot.model.sources.identifiers;

public interface ServerIdentifier extends Comparable<ServerIdentifier>, ServiceSpecific {
    String getName();
    String getIdentifier();
}
