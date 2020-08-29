package org.duh102.unibot.model.serialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.duh102.unibot.model.sources.identifiers.IRCServerIdentifier;
import org.duh102.unibot.model.sources.identifiers.ServerIdentifier;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class IRCServerIdentifierSerializationTest extends SerializationTest {
    private IRCServerIdentifier server = new IRCServerIdentifier("IRCNet");

    @Test
    public void testRoundTrip() throws JsonProcessingException {
        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(server);
        ServerIdentifier user2 = mapper.readValue(json, ServerIdentifier.class);
        assertThat(user2).isInstanceOf(IRCServerIdentifier.class).isEqualTo(server);
    }
}
