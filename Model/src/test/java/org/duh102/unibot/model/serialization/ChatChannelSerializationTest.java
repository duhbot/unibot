package org.duh102.unibot.model.serialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.duh102.unibot.model.sources.ChatChannel;
import org.duh102.unibot.model.sources.User;
import org.duh102.unibot.model.sources.identifiers.ChatChannelIdentifier;
import org.duh102.unibot.model.sources.identifiers.irc.IRCChannelIdentifier;
import org.duh102.unibot.model.sources.identifiers.irc.IRCServerIdentifier;
import org.duh102.unibot.model.sources.identifiers.irc.IRCUserIdentifier;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

public class ChatChannelSerializationTest extends SerializationTest {
    private final User user = new User(new IRCUserIdentifier("nickname", "user", "hostname"));
    private final IRCServerIdentifier server = new IRCServerIdentifier("IRCNet");
    private final ChatChannelIdentifier channelId = new IRCChannelIdentifier("channel", server);
    private final ChatChannel channel = new ChatChannel(channelId, Collections.singletonList(user));

    @Test
    public void testChatChannelRoundTrip() throws JsonProcessingException {
        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(channel);
        ChatChannel temp = mapper.readValue(json, ChatChannel.class);
        assertThat(temp).isInstanceOf(ChatChannel.class).isEqualTo(channel);
    }
}
