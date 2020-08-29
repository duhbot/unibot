package org.duh102.unibot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RichText {
    private List<RichTextComponent> components;

    public RichText() {
        components = new ArrayList<>();
    }
    public RichText(List<RichTextComponent> components) {
        this.components = components;
    }
    public RichText(RichText beginning, RichText theRest) {
        components = new ArrayList<>();
        components.addAll(beginning.getComponents());
        components.addAll(theRest.getComponents());
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

    @JsonIgnore
    public String getFormattingRemoved() {
        StringBuilder builder = new StringBuilder();
        for(RichTextComponent component : components) {
            builder.append(component.getRawString());
        }
        return builder.toString();
    }
}
