package org.duh102.unibot.model.serialization.identifier;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.duh102.unibot.model.serialization.SerializationTest;
import org.duh102.unibot.model.sources.identifiers.discord.DiscordServerIdentifier;
import org.duh102.unibot.model.sources.identifiers.ServerIdentifier;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DiscordServerIdentifierSerializationTest extends SerializationTest {
    private final DiscordServerIdentifier server = new DiscordServerIdentifier("Servar", "1234");

    @Test
    public void testRoundTrip() throws JsonProcessingException {
        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(server);
        ServerIdentifier user2 = mapper.readValue(json, ServerIdentifier.class);
        assertThat(user2).isInstanceOf(DiscordServerIdentifier.class).isEqualTo(server);
    }
}
