package org.duh102.unibot.model.argparse.valueparsers;

import org.duh102.unibot.model.text.RichTextComponent;
import org.duh102.unibot.model.text.texteffects.SimpleColor;
import org.duh102.unibot.model.text.texteffects.TextColor;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RichTextComponentValueParserTest {
    private final RichTextComponentValueParser parser = new RichTextComponentValueParser();

    @Test
    public void testIdentity() {
        RichTextComponent temp = new RichTextComponent("hi", new TextColor(SimpleColor.WHITE), new TextColor(SimpleColor.BLACK));
        assertThat(parser.parse(temp)).isEqualTo(temp);

        temp = new RichTextComponent("oh no", new TextColor(SimpleColor.BLACK), new TextColor(SimpleColor.WHITE));
        assertThat(parser.parse(temp)).isEqualTo(temp);
    }
}
