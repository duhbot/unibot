package org.duh102.unibot.model.text;

import org.duh102.unibot.model.text.texteffects.SimpleColor;
import org.duh102.unibot.model.text.texteffects.TextColor;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

public class RichTextTest {
    private final RichText richText = new RichText("hi");

    @Test
    public void testConstructors() {
        RichText temp = new RichText();
        assertThat(temp.getComponents()).isEmpty();

        temp = new RichText("hi");
        assertThat(temp.getComponents()).isNotEmpty().hasSize(1).first().isEqualTo(new RichTextComponent("hi"));

        RichTextComponent component = new RichTextComponent("hi", new TextColor(SimpleColor.WHITE), new TextColor(SimpleColor.BLACK));
        temp = new RichText(component);
        assertThat(temp.getComponents()).isNotEmpty().hasSize(1);
        assertThat(temp.getComponents().get(0)).isEqualTo(component);

        RichTextComponent component2 = new RichTextComponent("world", new TextColor(SimpleColor.BLACK), new TextColor(SimpleColor.WHITE));
        RichText temp2 = new RichText(component2);
        temp = new RichText(temp, temp2);
        assertThat(temp.getComponents()).isNotEmpty().hasSize(2);
        assertThat(temp.getComponents().get(0)).isEqualTo(component);
        assertThat(temp.getComponents().get(1)).isEqualTo(component2);
    }

    @Test
    public void testGetterSetter() {
        RichText temp = new RichText("hi");
        RichTextComponent component = new RichTextComponent("world");
        temp.setComponents(Collections.singletonList(component));
        assertThat(temp.getComponents()).isNotEmpty().hasSize(1).first().isEqualTo(component);
    }

    @Test
    public void testGetFormattingRemoved() {
        assertThat(richText.getFormattingRemoved()).isEqualTo("hi");

        RichTextComponent component = new RichTextComponent("hi", new TextColor(SimpleColor.WHITE), new TextColor(SimpleColor.BLACK));
        RichTextComponent component2 = new RichTextComponent("world", new TextColor(SimpleColor.BLACK), new TextColor(SimpleColor.WHITE));

        RichText temp = new RichText(Arrays.asList(component, component2));
        assertThat(temp.getFormattingRemoved()).isEqualTo("hiworld");
    }

    @Test
    public void testEquals() {
        RichTextComponent component = new RichTextComponent("hi", new TextColor(SimpleColor.WHITE), new TextColor(SimpleColor.BLACK));
        RichText temp = new RichText("hi");
        assertThat(temp).isEqualTo(richText);

        temp = new RichText(component);
        assertThat(temp).isNotEqualTo(richText);
    }
}
