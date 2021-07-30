package com.gaggle.contact.config;

import com.gaggle.contact.dao.ContactRepository;
import com.gaggle.contact.domain.Contact;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {
    private static final Logger logger = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(final ContactRepository repository) {
        return args -> {
            logger.info("Preloading " + repository.save(new Contact("Bruce Wayne")));
            logger.info("Preloading " + repository.save(new Contact("Oswald Cobblepot")));
        };
    }
}
