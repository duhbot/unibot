package org.duh102.unibot.model.exception;

public class UniqueViolationException extends Exception {
    public UniqueViolationException() {
        super();
    }
    public UniqueViolationException(String message) {
        super(message);
    }
    public UniqueViolationException(Throwable cause) {
        super(cause);
    }
    public UniqueViolationException(String message, Throwable cause) {
        super(message, cause);
    }
}
