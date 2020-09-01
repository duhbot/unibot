package org.duh102.unibot.model.text;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.*;

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
    public RichText(RichTextComponent text) {
        components = Collections.singletonList(text);
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

    @Override
    public boolean equals(Object o) {
        if(! (o instanceof RichText)) {
            return false;
        }
        RichText other = (RichText)o;
        return Objects.equals(getComponents(), other.getComponents());
    }

    @Override
    public int hashCode() {
        return Objects.hash(components);
    }
}
