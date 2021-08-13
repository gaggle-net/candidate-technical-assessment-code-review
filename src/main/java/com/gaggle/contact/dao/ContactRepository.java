package com.gaggle.contact.dao;

import com.gaggle.contact.domain.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ContactRepository extends JpaRepository<Contact, Long> {

    /**
     * Locates zero or more Contacts if their name contains the specified String.
     * @param name the full or partial name to search Contacts by
     * @return zero or more Contacts
     */
    Optional<List<Contact>> findByNameContainingIgnoreCase(final String name);

    Optional<List<Contact>> findByEmailContaining(final String email);
}
