package org.duh102.unibot.model.argparse;

import org.duh102.unibot.model.exception.ArgumentNotFoundException;
import org.duh102.unibot.model.exception.ArgumentNotRightTypeException;
import org.duh102.unibot.model.exception.UniqueViolationException;
import org.duh102.unibot.model.text.RichText;
import org.duh102.unibot.model.text.RichTextComponent;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Arguments {
    Map<RichTextComponent, Object> arguments;

    public Arguments() {
        arguments = new HashMap<>();
    }
    public Arguments(Map<RichTextComponent, Object> arguments) {
        this.arguments = arguments;
    }

    public Object getArgument(RichTextComponent key) throws ArgumentNotFoundException {
        if(!arguments.containsKey(key)) {
            throw new ArgumentNotFoundException(key.getRawString());
        }
        return arguments.get(key);
    }

    public <T> T getArgument(RichTextComponent key, Class<T> typeClass) throws ArgumentNotFoundException {
        Object value = getArgument(key);
        if(typeClass.isInstance(value)) {
            return (T) value;
        }
        throw new ArgumentNotRightTypeException(key, typeClass);
    }

    public Map<RichTextComponent, Object> getArguments() {
        return arguments;
    }

    public RichText getRichText(RichTextComponent key) throws ArgumentNotFoundException {
        return getArgument(key, RichText.class);
    }

    public String getString(RichTextComponent key) throws ArgumentNotFoundException {
        return getArgument(key, String.class);
    }

    public Integer getInteger(RichTextComponent key) throws ArgumentNotFoundException {
        return getArgument(key, Integer.class);
    }

    public Long getLong(RichTextComponent key) throws ArgumentNotFoundException {
        return getArgument(key, Long.class);
    }

    public Float getFloat(RichTextComponent key) throws ArgumentNotFoundException {
        return getArgument(key, Float.class);
    }

    public Double getDouble(RichTextComponent key) throws ArgumentNotFoundException {
        return getArgument(key, Double.class);
    }

    public static class Builder {
        private Map<RichTextComponent, Object> arguments = new HashMap<>();
        public Builder() {
        }
        public Builder addArgument(RichTextComponent arg, Object value) throws UniqueViolationException {
            if(arguments.containsKey(arg)) {
                throw new UniqueViolationException(String.format("Can't have the same key %s twice", arg));
            }
            arguments.put(arg, value);
            return this;
        }
        public Arguments build() {
            return new Arguments(arguments);
        }
    }

    @Override
    public boolean equals(Object o) {
        if(! (o instanceof Arguments)) {
            return false;
        }
        Arguments other = (Arguments)o;
        return Objects.equals(arguments, other.getArguments());
    }

    @Override
    public int hashCode() {
        return Objects.hash(arguments);
    }
}
