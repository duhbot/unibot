package org.duh102.unibot.model.argparse.valueparsers;

import org.duh102.unibot.model.text.RichTextComponent;
import org.duh102.unibot.model.text.texteffects.SimpleColor;
import org.duh102.unibot.model.text.texteffects.TextColor;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class IntegerValueParserTest {
    private final IntegerValueParser parser = new IntegerValueParser();

    @Test
    public void testParseInteger() {
        RichTextComponent temp = new RichTextComponent("10", new TextColor(SimpleColor.WHITE), null);
        assertThat(parser.parse(temp)).isEqualTo(10);

        temp = new RichTextComponent("-999");
        assertThat(parser.parse(temp)).isEqualTo(-999);
    }

    @Test
    public void testParseNonInteger() {
        RichTextComponent temp1 = new RichTextComponent("asb");
        assertThatExceptionOfType(NumberFormatException.class).isThrownBy(() -> {
            parser.parse(temp1);
        });

        RichTextComponent temp2 = new RichTextComponent("b-123", new TextColor(SimpleColor.GREEN), new TextColor(SimpleColor.RED));
        assertThatExceptionOfType(NumberFormatException.class).isThrownBy(() -> {
            parser.parse(temp2);
        });

        RichTextComponent temp3 = new RichTextComponent("1.23");
        assertThatExceptionOfType(NumberFormatException.class).isThrownBy(() -> {
            parser.parse(temp3);
        });
    }
}
