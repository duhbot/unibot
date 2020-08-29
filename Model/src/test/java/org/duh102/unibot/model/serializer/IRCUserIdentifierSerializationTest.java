package org.duh102.unibot.model.serializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.duh102.unibot.model.sources.identifiers.IRCUserIdentifier;
import org.duh102.unibot.model.sources.identifiers.UserIdentifier;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class IRCUserIdentifierSerializationTest {
    private final IRCUserIdentifier user = new IRCUserIdentifier("nikki", "usar", "hurstname");
    private final ObjectMapper mapper = new ObjectMapper();

    @Test
    public void testRoundTrip() throws JsonProcessingException {
        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(user);
        UserIdentifier user2 = mapper.readValue(json, UserIdentifier.class);
        assertThat(user2).isInstanceOf(IRCUserIdentifier.class).isEqualTo(user);
    }

    @Test
    public void testSerialization() throws JsonProcessingException {
        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(user);
        assertThat(json).contains("nikki").contains("usar").contains("hurstname");
    }

    @Test
    public void testDeserialization() throws JsonProcessingException {
        String json = "{ \"subtype\":\"irc\", \"id\":\"nikki!usar@hurstname\" }";
        UserIdentifier user2 = mapper.readValue(json, UserIdentifier.class);
        assertThat(user2).isInstanceOf(IRCUserIdentifier.class).isEqualTo(user);
    }
}
