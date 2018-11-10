package org.regeneration;

import org.regeneration.models.Book;
import org.regeneration.repositories.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {


    private static final Logger logger = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(BookRepository bookRepository) {
        return args -> {
            logger.info("Preloading " + bookRepository.save(new Book("The Grapes of Wrath", "0143125508")));
            logger.info("Preloading " + bookRepository.save(new Book("Symposium", " 0872200760")));
            logger.info("Preloading " + bookRepository.save(new Book("Pride and Prejudice", "0486284735")));
            logger.info("Preloading " + bookRepository.save(new Book("The Great Gatsby", "9780141182636")));

        };
    }
}
