package org.duh102.unibot.model.text.texteffects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Objects;

public class TextColor {
    private TextColorEnum textColor;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private SimpleColor customColor = null;

    public TextColor() {
        this.textColor = TextColorEnum.BLACK;
    }
    public TextColor(TextColorEnum colorEnum) {
        this.textColor = colorEnum;
    }
    public TextColor(SimpleColor customColor) {
        this.textColor = TextColorEnum.CUSTOM;
        this.customColor = customColor;
    }

    public TextColorEnum getTextColor() {
        return textColor;
    }

    public void setTextColor(TextColorEnum textColor) {
        this.textColor = textColor;
    }
    public SimpleColor getCustomColor() {
        return customColor;
    }
    public void setCustomColor(SimpleColor customColor) {
        this.customColor = customColor;
    }

    @JsonIgnore
    public SimpleColor getColor() {
        if( textColor == TextColorEnum.CUSTOM ) {
            return customColor;
        } else {
            return textColor.getColor();
        }
    }

    @Override
    public boolean equals(Object o) {
        if(! (o instanceof TextColor)) {
            return false;
        }
        TextColor other = (TextColor)o;
        return textColor == other.getTextColor()
                && Objects.equals(customColor, other.getCustomColor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(textColor, customColor);
    }
}
