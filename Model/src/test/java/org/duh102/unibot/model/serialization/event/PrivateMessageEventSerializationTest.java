package org.duh102.unibot.model.serialization.event;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.duh102.unibot.model.events.MessageEvent;
import org.duh102.unibot.model.events.PrivateMessageEvent;
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

public class PrivateMessageEventSerializationTest extends SerializationTest {
    private final RichText message = new RichText("hi");
    private final User user = new User(new IRCUserIdentifier("nickname", "user", "hostname"));
    private final IRCServerIdentifier server = new IRCServerIdentifier("IRCNet");
    private final ChatChannelIdentifier channelId = new IRCChannelIdentifier("channel", server);
    private final ChatChannel channel = new ChatChannel(channelId, Collections.singletonList(user));
    private final PrivateMessageEvent event = new PrivateMessageEvent(channel, user, message);

    @Test
    public void testMessageEventRoundTrip() throws JsonProcessingException {
        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(event);
        PrivateMessageEvent temp = mapper.readValue(json, PrivateMessageEvent.class);
        assertThat(temp).isInstanceOf(PrivateMessageEvent.class).isEqualTo(event);
    }
}
