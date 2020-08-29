package org.duh102.unibot.model.serialization.identifier;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.duh102.unibot.model.serialization.SerializationTest;
import org.duh102.unibot.model.sources.identifiers.*;
import org.duh102.unibot.model.sources.identifiers.irc.IRCChannelIdentifier;
import org.duh102.unibot.model.sources.identifiers.irc.IRCServerIdentifier;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class IRCChannelIdentifierSerializationTest extends SerializationTest {
    private final IRCServerIdentifier server = new IRCServerIdentifier("IRCNet");
    private final IRCChannelIdentifier channel = new IRCChannelIdentifier("channel", server);

    @Test
    public void testRoundTrip() throws JsonProcessingException {
        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(channel);
        ChatChannelIdentifier user2 = mapper.readValue(json, ChatChannelIdentifier.class);
        assertThat(user2).isInstanceOf(IRCChannelIdentifier.class).isEqualTo(channel);
    }
}
