package org.duh102.unibot.model.serialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.duh102.unibot.model.sources.identifiers.IRCUserIdentifier;
import org.duh102.unibot.model.sources.identifiers.UserIdentifier;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class IRCUserIdentifierSerializationTest extends SerializationTest {
    private final String nickname = "nikki";
    private final String username = "usar";
    private final String hostname = "hurstname";
    private final IRCUserIdentifier user = new IRCUserIdentifier(nickname, username, hostname);

    @Test
    public void testRoundTrip() throws JsonProcessingException {
        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(user);
        UserIdentifier user2 = mapper.readValue(json, UserIdentifier.class);
        assertThat(user2).isInstanceOf(IRCUserIdentifier.class).isEqualTo(user);
    }
}
