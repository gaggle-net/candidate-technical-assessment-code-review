package com.gaggle.contact;

import com.gaggle.contact.controllers.ContactController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class ContactServiceApplicationTests {

	@Autowired
	private ContactController controller;

	@Test
	void contextLoads() {
		assertNotNull(controller);
	}

}
