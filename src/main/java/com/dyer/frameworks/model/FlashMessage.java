package com.dyer.frameworks.model;

/**
 * Domain object represents a flash message.
 */
public class FlashMessage {

    private Status status;
    private String message;

    public FlashMessage(Status status, String message) {
        this.status = status;
        this.message = message;
    }

    public Status getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public static enum Status {
        SUCCESS, FAILURE
    }

}
