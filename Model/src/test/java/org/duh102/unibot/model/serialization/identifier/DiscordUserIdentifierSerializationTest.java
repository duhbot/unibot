package org.duh102.unibot.model.serialization.identifier;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.duh102.unibot.model.sources.identifiers.discord.DiscordUserIdentifier;
import org.duh102.unibot.model.sources.identifiers.UserIdentifier;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DiscordUserIdentifierSerializationTest {
    private final String uniqueId = "123";
    private final String username = "usarneme";
    private final int discriminator = 4321;
    private final DiscordUserIdentifier user = new DiscordUserIdentifier(uniqueId, username, discriminator);
    private final ObjectMapper mapper = new ObjectMapper();

    @Test
    public void testRoundTrip() throws JsonProcessingException {
        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(user);
        UserIdentifier user2 = mapper.readValue(json, UserIdentifier.class);
        assertThat(user2).isInstanceOf(DiscordUserIdentifier.class).isEqualTo(user);
    }
}
