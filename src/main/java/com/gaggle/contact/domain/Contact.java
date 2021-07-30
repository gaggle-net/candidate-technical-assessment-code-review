package com.gaggle.contact.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

/**
 * Represents a Contact.
 */
@Entity
public class Contact {

    private @Id @GeneratedValue Long id;
    private @NotBlank String name;

    public Contact() {}

    public Contact(final String name) {
        this.name = name;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Contact))
            return false;
        Contact contact = (Contact) o;
        return Objects.equals(this.id, contact.id) &&
                Objects.equals(this.name, contact.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name);
    }

    @Override
    public String toString() {
        return String.format("Contact {id=%s, name=\"%s\"}", this.id, this.name);
    }
}
