package org.duh102.unibot.model.serializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.duh102.unibot.model.sources.identifiers.IRCUserIdentifier;

import java.io.IOException;

public class IRCUserDeserializer extends JsonDeserializer<IRCUserIdentifier> {
    @Override
    public IRCUserIdentifier deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        ObjectNode node = jsonParser.readValueAsTree();
        try {
            String userIdStr = node.get("id").asText();
            return new IRCUserIdentifier(userIdStr);
        } catch (Exception e) {
            throw new IOException("Invalid IRCUserIdentifier", e);
        }
    }

    @Override
    public Class<?> handledType() {
        return IRCUserIdentifier.class;
    }
}
