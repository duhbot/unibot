package org.duh102.unibot.model.exception;

public class NoMoreHelpException extends HelpException {
    public NoMoreHelpException() {
        super();
    }
    public NoMoreHelpException(String message) {
        super(message);
    }
    public NoMoreHelpException(Throwable cause) {
        super(cause);
    }
    public NoMoreHelpException(String message, Throwable cause) {
        super(message, cause);
    }
}
