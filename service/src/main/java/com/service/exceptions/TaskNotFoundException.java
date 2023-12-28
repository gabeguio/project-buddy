package com.service.exceptions;

import com.service.dynamodb.models.Task;

/**
 * Exception thrown when a com.service.dynamodb.models.Task ID is not found in the database.
 */
public class TaskNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 2130472228936839137L;

    /**
     * Exception with no message or cause.
     */
    public TaskNotFoundException() {
        super();
    }

    /**
     * Exception with a message, but no cause.
     * @param message A descriptive message for this exception.
     */
    public TaskNotFoundException(String message) {
        super(message);
    }

    /**
     * Exception with message and cause.
     * @param message A descriptive message for this exception.
     * @param cause The original throwable resulting in this exception.
     */
    public TaskNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Exception with no message, but with a cause.
     * @param cause The original throwable resulting in this exception.
     */
    public TaskNotFoundException(Throwable cause) {
        super(cause);
    }
}
