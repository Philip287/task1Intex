package org.suprun.task1.exception;

public class CustomAppException extends Exception {

    public CustomAppException() {
        super();
    }

    public CustomAppException(String message) {
        super(message);
    }

    public CustomAppException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomAppException(Throwable cause) {
        super(cause);
    }
}
