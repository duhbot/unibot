package org.duh102.unibot.model.serialization.identifier;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.duh102.unibot.model.serialization.SerializationTest;
import org.duh102.unibot.model.sources.identifiers.ChatChannelIdentifier;
import org.duh102.unibot.model.sources.identifiers.discord.DiscordChannelIdentifier;
import org.duh102.unibot.model.sources.identifiers.discord.DiscordServerIdentifier;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DiscordChannelIdentifierSerializationTest extends SerializationTest {
    private final DiscordServerIdentifier server = new DiscordServerIdentifier("servar", "1234");
    private final DiscordChannelIdentifier channel = new DiscordChannelIdentifier("chanell", "1234", server);

    @Test
    public void testRoundTrip() throws JsonProcessingException {
        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(channel);
        ChatChannelIdentifier user2 = mapper.readValue(json, ChatChannelIdentifier.class);
        assertThat(user2).isInstanceOf(DiscordChannelIdentifier.class).isEqualTo(channel);
    }
}
