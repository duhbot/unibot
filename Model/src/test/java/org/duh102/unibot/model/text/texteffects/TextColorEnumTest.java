package org.duh102.unibot.model.text.texteffects;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TextColorEnumTest {
    @Test
    public void testGetColor() {
        assertThat(TextColorEnum.WHITE.getColor()).isEqualTo(SimpleColor.WHITE);
    }
}
