package org.duh102.unibot.model.text;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.duh102.unibot.model.text.texteffects.SimpleColor;
import org.duh102.unibot.model.text.texteffects.TextColor;

import java.util.Objects;

public class RichTextComponent {

    private String rawString;

    // null TextColors are assumed to be platform-default
    @JsonInclude(JsonInclude.Include.NON_NULL)
    TextColor foregroundColor = null;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    TextColor backgroundColor = null;
    // TextEffect effect (this would be italics, bold, etc)
    // TextSize size (idk if any chat program allows this)


    public RichTextComponent() {
        this.rawString = "";
    }
    public RichTextComponent(String rawString) {
        this.rawString = rawString;
    }
    public RichTextComponent(String rawString, TextColor foregroundColor, TextColor backgroundColor) {
        this.rawString = rawString;
        this.foregroundColor = foregroundColor;
        this.backgroundColor = backgroundColor;
    }

    public String getRawString() {
        return rawString;
    }
    public void setRawString(String contents) {
        this.rawString = contents;
    }

    public TextColor getForegroundColor() {
        return foregroundColor;
    }
    public void setForegroundColor(TextColor foregroundColor) {
        this.foregroundColor = foregroundColor;
    }

    public TextColor getBackgroundColor() {
        return backgroundColor;
    }
    public void setBackgroundColor(TextColor backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    @Override
    public boolean equals(Object o) {
        if(! (o instanceof RichTextComponent)) {
            return false;
        }
        RichTextComponent other = (RichTextComponent)o;
        return rawString.equals(other.getRawString())
                && Objects.equals(foregroundColor, other.getForegroundColor())
                && Objects.equals(backgroundColor, other.getBackgroundColor());
    }
}
