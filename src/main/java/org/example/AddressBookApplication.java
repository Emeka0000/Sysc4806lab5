package org.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AddressBookApplication {

    public static void main(String[] args) {
        SpringApplication.run(AddressBookApplication.class, args);
    }

    @Bean
    CommandLineRunner seed(AddressBookRepository repo) {
        return args -> {
            if (repo.count() == 0) {
                AddressBook book = new AddressBook();
                book.addBuddy(new BuddyInfo("Alice Smith", "613-555-0101", "1 Main St"));
                book.addBuddy(new BuddyInfo("Bob Chen", "613-555-0102", "2 Elm St"));
                repo.save(book);
            }
        };
    }
}