package com.sorting.sortingpayload.exception;

public final class ErrorDetails {

    private final String timestamp;
    private final String message;
    private final String details;

    public ErrorDetails(final String timestamp,
                        final String message, final String details) {
        super();
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }
}
