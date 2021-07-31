package com.gaggle.contact.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ContactControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    void whenSearchingWithValidContactId_thenReturnCorrectContact() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/api/contacts/1").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("1"))
                .andExpect(jsonPath("$.name").value("Bruce Wayne"));
    }

    @Test
    void whenSearchingWithInvalidContactId_thenReturnCorrectErrorResponse() throws Exception {
        Long id = Long.MAX_VALUE; //should never have this many contacts
        String error = String.format(ContactNotFoundException.CONTACT_NOT_FOUND_MSG, id);

        mvc.perform(MockMvcRequestBuilders.get("/api/contacts/"+id).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.error").value(error));
    }

    @Test
    void whenSearchingWithContactIdNotGreaterThanZero_thenReturnCorrectErrorResponse() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/api/contacts/-99").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error").isNotEmpty());
    }

    @ParameterizedTest
    @ValueSource(strings = {"Bruce Wayne", "bru", "way", "ce wa", "Bruce", "Wayne", "BrUcE wAyNe"})
    void whenSearchingWithValidContactName_thenReturnCorrectContact(final String name) throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/api/contacts?name="+name).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].id").value("1"))
                .andExpect(jsonPath("$[0].name").value("Bruce Wayne"));
    }

    @Test
    void whenSearchingWithContactNameNotFound_thenReturnAnEmptyArrayResponse() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/api/contacts?name=Flash Gordon").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(0));
    }

    @Test
    void whenSearchingWithNoContactName_thenReturnCorrectErrorResponse() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/api/contacts").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error").isNotEmpty());

        mvc.perform(MockMvcRequestBuilders.get("/api/contacts?name=").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error").isNotEmpty());
    }
}
