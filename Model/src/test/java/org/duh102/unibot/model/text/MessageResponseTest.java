package org.duh102.unibot.model.text;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MessageResponseTest {
    private final MessageResponse response = new MessageResponse("hi");

    @Test
    public void testConstructors() {
        MessageResponse temp = new MessageResponse();
        assertThat(temp.getMessage()).isEqualTo(new RichText());

        temp = new MessageResponse("hi");
        assertThat(temp).isEqualTo(response);

        RichText text = new RichText("response");
        temp = new MessageResponse(text);
        assertThat(temp.getMessage()).isEqualTo(text);
    }

    @Test
    public void testGettersSetters() {
        assertThat(response.getMessage()).isEqualTo(new RichText("hi"));
        response.setMessage(new RichText("ho"));
        assertThat(response.getMessage()).isEqualTo(new RichText("ho"));
    }

    @Test
    public void testEquals() {
        MessageResponse temp = new MessageResponse("hi");
        assertThat(temp).isEqualTo(response);

        temp = new MessageResponse("ho");
        assertThat(temp).isNotEqualTo(response);
    }
}
