package org.duh102.unibot.model.text.texteffects;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TextColorTest {
    private final TextColor textColor = new TextColor(TextColorEnum.WHITE);

    @Test
    public void testConstructors() {
        TextColor temp = new TextColor();
        assertThat(temp.getTextColor()).isEqualTo(TextColorEnum.BLACK);
        assertThat(temp.getColor()).isEqualTo(SimpleColor.BLACK);

        temp = new TextColor(TextColorEnum.BLUE);
        assertThat(temp.getTextColor()).isEqualTo(TextColorEnum.BLUE);
        assertThat(temp.getColor()).isEqualTo(SimpleColor.BLUE);

        temp = new TextColor(new SimpleColor(0, 1, 2));
        assertThat(temp.getTextColor()).isEqualTo(TextColorEnum.CUSTOM);
        assertThat(temp.getColor()).isEqualTo(new SimpleColor(0, 1, 2));
    }

    @Test
    public void testEquals() {
        TextColor temp = new TextColor(TextColorEnum.WHITE);
        assertThat(temp).isEqualTo(textColor);

        temp = new TextColor(TextColorEnum.BLACK);
        assertThat(temp).isNotEqualTo(textColor);

        TextColor temp2 = new TextColor(new SimpleColor(1,2,3));
        temp = new TextColor(new SimpleColor(1,2,3));
        assertThat(temp).isEqualTo(temp2);

        temp = new TextColor(new SimpleColor(3,2,1));
        assertThat(temp).isNotEqualTo(temp2);
    }
}
