package com.gaggle.contact.controllers;

public class ContactNotFoundException extends RuntimeException {
    public static final String CONTACT_NOT_FOUND_MSG = "No contact found with id = %s";
    public static final String CONTACT_NOT_FOUND_BY_NAME_MSG = "No contact found with name = %s";

    ContactNotFoundException(final Long id) {
        super(String.format(CONTACT_NOT_FOUND_MSG, id));
    }

    ContactNotFoundException(final String name) {
        super(String.format(CONTACT_NOT_FOUND_BY_NAME_MSG, name));
    }
}
