package org.duh102.unibot.model.argparse.valueparsers;

import org.duh102.unibot.model.text.RichTextComponent;
import org.duh102.unibot.model.text.texteffects.SimpleColor;
import org.duh102.unibot.model.text.texteffects.TextColor;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class FloatValueParserTest {
    private final FloatValueParser parser = new FloatValueParser();

    @Test
    public void testParseFloat() {
        RichTextComponent temp = new RichTextComponent("10", new TextColor(SimpleColor.WHITE), null);
        assertThat(parser.parse(temp)).isEqualTo(10.0f);

        temp = new RichTextComponent("1.2");
        assertThat(parser.parse(temp)).isEqualTo(1.2f);
    }

    @Test
    public void testParseNonFloat() {
        RichTextComponent temp1 = new RichTextComponent("asb");
        assertThatExceptionOfType(NumberFormatException.class).isThrownBy(() -> {
            parser.parse(temp1);
        });

        RichTextComponent temp2 = new RichTextComponent("b-123", new TextColor(SimpleColor.GREEN), new TextColor(SimpleColor.RED));
        assertThatExceptionOfType(NumberFormatException.class).isThrownBy(() -> {
            parser.parse(temp2);
        });

        RichTextComponent temp3 = new RichTextComponent("12.b");
        assertThatExceptionOfType(NumberFormatException.class).isThrownBy(() -> {
            parser.parse(temp3);
        });
    }
}
