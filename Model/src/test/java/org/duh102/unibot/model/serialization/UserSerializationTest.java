package org.duh102.unibot.model.serialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.duh102.unibot.model.sources.User;
import org.duh102.unibot.model.sources.identifiers.irc.IRCUserIdentifier;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserSerializationTest extends SerializationTest {
    private final User user = new User(new IRCUserIdentifier("nickname", "user", "hostname"));

    @Test
    public void testMessageEventRoundTrip() throws JsonProcessingException {
        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(user);
        User temp = mapper.readValue(json, User.class);
        assertThat(temp).isInstanceOf(User.class).isEqualTo(user);
    }
}
