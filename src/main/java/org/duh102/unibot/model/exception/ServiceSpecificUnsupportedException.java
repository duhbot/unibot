package org.duh102.unibot.model.exception;

public class ServiceSpecificUnsupportedException extends Exception {
    public ServiceSpecificUnsupportedException() {
        super();
    }
    public ServiceSpecificUnsupportedException(String message) {
        super(message);
    }
    public ServiceSpecificUnsupportedException(Throwable cause) {
        super(cause);
    }
    public ServiceSpecificUnsupportedException(String message, Throwable cause) {
        super(message, cause);
    }
}
