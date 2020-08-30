package org.duh102.unibot.model.serialization.event;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.duh102.unibot.model.events.MessageEvent;
import org.duh102.unibot.model.serialization.SerializationTest;
import org.duh102.unibot.model.sources.ChatChannel;
import org.duh102.unibot.model.sources.User;
import org.duh102.unibot.model.sources.identifiers.ChatChannelIdentifier;
import org.duh102.unibot.model.sources.identifiers.irc.IRCChannelIdentifier;
import org.duh102.unibot.model.sources.identifiers.irc.IRCServerIdentifier;
import org.duh102.unibot.model.sources.identifiers.irc.IRCUserIdentifier;
import org.duh102.unibot.model.text.RichText;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

public class MessageEventSerializationTest extends SerializationTest {
    private final RichText message = new RichText("hi");
    private final User user = new User(new IRCUserIdentifier("nickname", "user", "hostname"));
    private final IRCServerIdentifier server = new IRCServerIdentifier("IRCNet");
    private final ChatChannelIdentifier channelId = new IRCChannelIdentifier("channel", server);
    private final ChatChannel channel = new ChatChannel(channelId, Collections.singletonList(user));
    private final MessageEvent event = new MessageEvent(channel, user, message);

    @Test
    public void testMessageEventRoundTrip() throws JsonProcessingException {
        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(event);
        MessageEvent temp = mapper.readValue(json, MessageEvent.class);
        assertThat(temp).isInstanceOf(MessageEvent.class).isEqualTo(event);
    }
}
