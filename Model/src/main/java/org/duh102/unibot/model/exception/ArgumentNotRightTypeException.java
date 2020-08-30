package org.duh102.unibot.model.exception;

import org.duh102.unibot.model.text.RichTextComponent;

public class ArgumentNotRightTypeException extends ArgumentNotFoundException {
    protected Class<?> expectedType;
    public ArgumentNotRightTypeException() {
        super();
    }
    public ArgumentNotRightTypeException(String message) {
        super(message);
    }
    public ArgumentNotRightTypeException(RichTextComponent key, Class<?> expectedType) {
        super(getMessage(key, expectedType));
        this.key = key;
        this.expectedType = expectedType;
    }
    public ArgumentNotRightTypeException(Throwable cause) {
        super(cause);
    }
    public ArgumentNotRightTypeException(String message, Throwable cause) {
        super(message, cause);
    }
    public ArgumentNotRightTypeException(RichTextComponent key, Class<?> expectedType, Throwable cause) {
        super(getMessage(key, expectedType), cause);
        this.key = key;
        this.expectedType = expectedType;
    }

    private static String getMessage(RichTextComponent key, Class<?> expectedType) {
        return String.format("Value for key %s was not type %s", key.getRawString(), expectedType.getName());
    }

    public Class<?> getExpectedType() {
        return expectedType;
    }
}
