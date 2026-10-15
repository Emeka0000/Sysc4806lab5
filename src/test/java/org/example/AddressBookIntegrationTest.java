package org.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AddressBookIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void apiIsUp() {
        ResponseEntity<String> response = restTemplate.getForEntity("/api/addressBooks", String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void missingAddressBookReturns404() {
        ResponseEntity<String> response = restTemplate.getForEntity("/addressbook/99999", String.class);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}