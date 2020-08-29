package org.duh102.unibot.model.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.type.WritableTypeId;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import org.duh102.unibot.model.sources.identifiers.IRCUserIdentifier;

import java.io.IOException;

import static com.fasterxml.jackson.core.JsonToken.START_OBJECT;

public class IRCUserSerializer extends JsonSerializer<IRCUserIdentifier> {
    @Override
    public void serialize(IRCUserIdentifier ircUserIdentifier, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStringField("id", ircUserIdentifier.getSerializedForm());
    }

    @Override
    public void serializeWithType(IRCUserIdentifier value, JsonGenerator gen, SerializerProvider serializers, TypeSerializer typeSer) throws IOException {
        WritableTypeId typeId = typeSer.typeId(value, START_OBJECT);
        typeSer.writeTypePrefix(gen, typeId);
        serialize(value, gen, serializers);
        typeSer.writeTypeSuffix(gen, typeId);
    }

    @Override
    public Class<IRCUserIdentifier> handledType() {
        return IRCUserIdentifier.class;
    }
}
