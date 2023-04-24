package com.nashss.se.projectmanagementservice.exceptions;

/**
 * Exception thrown when a Ticket ID is not found in the database.
 */
public class TicketNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 2130472228936839137L;

    /**
     * Exception with no message or cause.
     */
    public TicketNotFoundException() {
        super();
    }

    /**
     * Exception with a message, but no cause.
     * @param message A descriptive message for this exception.
     */
    public TicketNotFoundException(String message) {
        super(message);
    }

    /**
     * Exception with message and cause.
     * @param message A descriptive message for this exception.
     * @param cause The original throwable resulting in this exception.
     */
    public TicketNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Exception with no message, but with a cause.
     * @param cause The original throwable resulting in this exception.
     */
    public TicketNotFoundException(Throwable cause) {
        super(cause);
    }
}
