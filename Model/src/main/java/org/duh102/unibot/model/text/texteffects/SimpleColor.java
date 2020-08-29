package org.duh102.unibot.model.text.texteffects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.duh102.unibot.model.sources.identifiers.irc.IRCChannelIdentifier;

import java.awt.*;

/**
 * Basically to get around having to try to serialize java.awt.Color
 */
public class SimpleColor {
    private final int red;
    private final int green;
    private final int blue;

    public static final SimpleColor
            BLACK = new SimpleColor(0,0,0),
            RED = new SimpleColor(255,0,0),
            GREEN = new SimpleColor(0,255,0),
            BLUE = new SimpleColor(0,0,255),
            CYAN = new SimpleColor(0,255,255),
            MAGENTA = new SimpleColor(255,0,255),
            YELLOW = new SimpleColor(255,255,0),
            WHITE = new SimpleColor(255,255,255);

    @JsonCreator
    public SimpleColor(
            @JsonProperty("red") int red,
            @JsonProperty("green") int green,
            @JsonProperty("blue") int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public int getRed() {
        return red;
    }
    public int getGreen() {
        return green;
    }
    public int getBlue() {
        return blue;
    }

    @JsonIgnore
    public Color getAsColor() {
        return new Color(getRed(), getGreen(), getBlue());
    }

    @Override
    public boolean equals(Object o) {
        if(! (o instanceof SimpleColor)) {
            return false;
        }
        SimpleColor other = (SimpleColor)o;
        return this.blue == other.getBlue()
                && this.green == other.getGreen()
                && this.red == other.getRed();
    }
}
