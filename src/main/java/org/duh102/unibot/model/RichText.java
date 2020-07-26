package org.duh102.unibot.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RichText {

    private List<RichTextComponent> components;

    public RichText() {
        components = new ArrayList<RichTextComponent>();
    }
    public RichText(String text) {
        components = Collections.singletonList(new RichTextComponent(text));
    }


    public List<RichTextComponent> getComponents() {
        return components;
    }

    public void setComponents(List<RichTextComponent> components) {
        this.components = components;
    }
}
