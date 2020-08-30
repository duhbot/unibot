package org.duh102.unibot.model.text.texteffects;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SimpleColorTest {
    private final SimpleColor color = new SimpleColor(1,2,3);

    @Test
    public void testConstructors() {
        SimpleColor temp = new SimpleColor(1,2,3);
        assertThat(temp.getRed()).isEqualTo(1);
        assertThat(temp.getGreen()).isEqualTo(2);
        assertThat(temp.getBlue()).isEqualTo(3);
    }

    @Test
    public void testEquals() {
        SimpleColor temp = new SimpleColor(1,2,3);
        assertThat(temp).isEqualTo(color);

        temp = new SimpleColor(2,2,3);
        assertThat(temp).isNotEqualTo(color);

        temp = new SimpleColor(1,3,3);
        assertThat(temp).isNotEqualTo(color);

        temp = new SimpleColor(1,2,1);
        assertThat(temp).isNotEqualTo(color);
    }
}
