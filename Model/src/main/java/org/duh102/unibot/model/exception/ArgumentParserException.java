package org.duh102.unibot.model.exception;

public class ArgumentParserException extends Exception {
    public ArgumentParserException() {
        super();
    }
    public ArgumentParserException(String message) {
        super(message);
    }
    public ArgumentParserException(Throwable cause) {
        super(cause);
    }
    public ArgumentParserException(String message, Throwable cause) {
        super(message, cause);
    }
}
