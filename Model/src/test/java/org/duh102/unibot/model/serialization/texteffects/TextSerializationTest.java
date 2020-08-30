package org.duh102.unibot.model.serialization.texteffects;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.duh102.unibot.model.text.MessageResponse;
import org.duh102.unibot.model.text.RichText;
import org.duh102.unibot.model.text.RichTextComponent;
import org.duh102.unibot.model.serialization.SerializationTest;
import org.duh102.unibot.model.text.texteffects.SimpleColor;
import org.duh102.unibot.model.text.texteffects.TextColor;
import org.duh102.unibot.model.text.texteffects.TextColorEnum;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TextSerializationTest extends SerializationTest {
    private final SimpleColor color = new SimpleColor(100, 200, 200);
    private final TextColor fgColor = new TextColor(color);
    private final TextColor bgColor = new TextColor(TextColorEnum.BLACK);
    private final RichTextComponent component = new RichTextComponent("Hi", fgColor, bgColor);
    private final RichText text = new RichText(component);
    private final MessageResponse messageResponse = new MessageResponse(text);

    @Test
    public void testSimpleColorRoundTrip() throws JsonProcessingException {
        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(color);
        SimpleColor temp = mapper.readValue(json, SimpleColor.class);
        assertThat(temp).isInstanceOf(SimpleColor.class).isEqualTo(color);
    }

    @Test
    public void testTextColorRoundTrip() throws JsonProcessingException {
        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(fgColor);
        TextColor temp = mapper.readValue(json, TextColor.class);
        assertThat(temp).isInstanceOf(TextColor.class).isEqualTo(fgColor);
    }

    @Test
    public void testRichTextComponentRoundTrip() throws JsonProcessingException {
        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(component);
        RichTextComponent temp = mapper.readValue(json, RichTextComponent.class);
        assertThat(temp).isInstanceOf(RichTextComponent.class).isEqualTo(component);
    }

    @Test
    public void testRichTextRoundTrip() throws JsonProcessingException {
        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(text);
        RichText temp = mapper.readValue(json, RichText.class);
        assertThat(temp).isInstanceOf(RichText.class).isEqualTo(text);
    }

    @Test
    public void testMessageResponseRoundTrip() throws JsonProcessingException {
        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(messageResponse);
        MessageResponse temp = mapper.readValue(json, MessageResponse.class);
        assertThat(temp).isInstanceOf(MessageResponse.class).isEqualTo(messageResponse);
    }
}
