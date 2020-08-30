package org.duh102.unibot.model.text;

import org.duh102.unibot.model.text.texteffects.TextColor;
import org.duh102.unibot.model.text.texteffects.TextColorEnum;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RichTextComponentTest {
    private final TextColor fgColor = new TextColor(TextColorEnum.WHITE);
    private final TextColor bgColor = new TextColor(TextColorEnum.BLACK);
    private final RichTextComponent component = new RichTextComponent("hi", fgColor, bgColor);

    @Test
    public void testConstructors() {
        RichTextComponent temp = new RichTextComponent();
        assertThat(temp.getRawString()).isEmpty();
        assertThat(temp.getForegroundColor()).isNull();
        assertThat(temp.getBackgroundColor()).isNull();

        temp = new RichTextComponent("hi");
        assertThat(temp.getRawString()).isEqualTo("hi");
        assertThat(temp.getForegroundColor()).isNull();
        assertThat(temp.getBackgroundColor()).isNull();

        temp = new RichTextComponent("hi", fgColor, bgColor);
        assertThat(temp.getRawString()).isEqualTo("hi");
        assertThat(temp.getForegroundColor()).isEqualTo(fgColor);
        assertThat(temp.getBackgroundColor()).isEqualTo(bgColor);
    }

    @Test
    public void testEquals() {
        RichTextComponent temp = new RichTextComponent("hi", fgColor, bgColor);
        assertThat(temp).isEqualTo(component);

        temp = new RichTextComponent("ho", fgColor, bgColor);
        assertThat(temp).isNotEqualTo(component);

        temp = new RichTextComponent("hi", bgColor, bgColor);
        assertThat(temp).isNotEqualTo(component);

        temp = new RichTextComponent("hi", fgColor, fgColor);
        assertThat(temp).isNotEqualTo(component);
    }
}
