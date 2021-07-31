package com.gaggle.contact.config;

import com.gaggle.contact.dao.ContactRepository;
import com.gaggle.contact.domain.Contact;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Simple embedded database for use in the proof of concept.
 */
@Configuration
class LoadDatabase {
    private static final Logger logger = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(final ContactRepository repository) {
        return args -> {
            logger.info("Preloading " + repository.save(new Contact("Bruce Wayne", "bwayne@gothamcity.com")));
            logger.info("Preloading " + repository.save(new Contact("Dick Grayson", "dgrayson@gothamcity.com")));
            logger.info("Preloading " + repository.save(new Contact("Jason Todd", "jtodd@gothamcity.com")));
            logger.info("Preloading " + repository.save(new Contact("Selina Kyle", "skyle@gothamcity.com")));
            logger.info("Preloading " + repository.save(new Contact("Oswald Cobblepot", "ocobblepot@gothamcity.com")));
            logger.info("Preloading " + repository.save(new Contact("Edward Nygma", "enygma@gothamcity.com")));
        };
    }
}
