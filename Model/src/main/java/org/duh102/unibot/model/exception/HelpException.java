package org.duh102.unibot.model.exception;

public class HelpException extends Exception {
    public HelpException() {
        super();
    }
    public HelpException(String message) {
        super(message);
    }
    public HelpException(Throwable cause) {
        super(cause);
    }
    public HelpException(String message, Throwable cause) {
        super(message, cause);
    }
}
