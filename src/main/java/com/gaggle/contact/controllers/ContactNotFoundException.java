package com.gaggle.contact.controllers;

public class ContactNotFoundException extends RuntimeException {
    public static final String CONTACT_NOT_FOUND_MSG = "No contact found with id = %s";

    ContactNotFoundException(final Long id) {
        super(String.format(CONTACT_NOT_FOUND_MSG, id));
    }
}
