package org.duh102.unibot.model.exception;

import org.duh102.unibot.model.text.RichTextComponent;

public class ArgumentNotFoundException extends ArgumentParserException {
    protected RichTextComponent key;
    public ArgumentNotFoundException() {
        super();
    }
    public ArgumentNotFoundException(String message) {
        super(message);
    }
    public ArgumentNotFoundException(RichTextComponent key) {
        super(getMessage(key));
        this.key = key;
    }
    public ArgumentNotFoundException(Throwable cause) {
        super(cause);
    }
    public ArgumentNotFoundException(RichTextComponent key, Throwable cause) {
        super(getMessage(key), cause);
        this.key = key;
    }
    public ArgumentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    private static String getMessage(RichTextComponent key) {
        return String.format("Could not find value for key %s", key.getRawString());
    }

    public RichTextComponent getKey() {
        return key;
    }
}
