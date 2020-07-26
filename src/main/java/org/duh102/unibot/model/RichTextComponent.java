package org.duh102.unibot.model;

public class RichTextComponent {

    private String contents;
    // Color foregroundColor
    // Color backgroundColor
    // TextEffect effect (this would be italics, bold, etc)
    // TextSize size (idk if any chat program allows this)


    public RichTextComponent(String contents) {
        this.contents = contents;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }
}
