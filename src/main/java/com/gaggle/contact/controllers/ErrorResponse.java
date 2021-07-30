package com.gaggle.contact.controllers;

import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

/**
 * Represents an error response.
 */
public class ErrorResponse {
    private String error;
    private Date timestamp;

    public ErrorResponse() {
        this.timestamp = Calendar.getInstance().getTime();
    }

    public ErrorResponse(final String error) {
        this();
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(final String error) {
        this.error = error;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(final Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof ErrorResponse))
            return false;
        ErrorResponse response = (ErrorResponse) o;
        return Objects.equals(this.error, response.error) &&
                Objects.equals(this.timestamp, response.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.error, this.timestamp);
    }

    @Override
    public String toString() {
        return String.format("ErrorResponse {error=\"%s\", timestamp=[%s]}", this.error, this.timestamp);
    }
}
