package com.gaggle.contact.controllers;

import com.gaggle.contact.dao.ContactRepository;
import com.gaggle.contact.domain.Contact;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Positive;

/**
 * Endpoint for interacting with Contacts.
 */
@RestController
@Validated
public class ContactController {
    private static final Logger logger = LoggerFactory.getLogger(ContactController.class);

    private final ContactRepository repository;

    ContactController(final ContactRepository repository) {
        this.repository = repository;
    }

    /**
     * Retrieve a Contact by their unique identifier.
     *
     * @param id the unique identifier of the Contact being requested
     * @return the contact associated with the specified identifier
     */
    @GetMapping("/contacts/{id}")
    public Contact getById(@PathVariable @Positive(message = "id should be greater than 0") final Long id) {
        logger.debug("Attempting to retrieve contact with id={}...", id);

        return repository.findById(id)
                .orElseThrow(() -> new ContactNotFoundException(id));
    }
}
