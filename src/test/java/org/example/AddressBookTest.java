package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddressBookTest {

    private AddressBook addressBook;
    private BuddyInfo alice;
    private BuddyInfo bob;

    @BeforeEach
    void setUp() {
        addressBook = new AddressBook();
        alice = new BuddyInfo("Alice Smith", "613-555-0101");
        bob = new BuddyInfo("Bob Chen", "613-555-0102");
        addressBook.addBuddy(alice);
        addressBook.addBuddy(bob);
    }

    @Test
    void testAddBuddy() {
        assertEquals(2, addressBook.size());
    }

    @Test
    void testRemoveBuddy() {
        boolean removed = addressBook.removeBuddy(alice);
        assertTrue(removed);
        assertEquals(1, addressBook.size());
    }

    @Test
    void testFindByName() {
        BuddyInfo found = addressBook.findByName("Bob Chen");
        assertNotNull(found);
        assertEquals(bob, found);
    }
}