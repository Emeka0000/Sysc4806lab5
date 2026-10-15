package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BuddyInfoTest {

    private BuddyInfo buddy;

    @BeforeEach
    void setUp() {
        buddy = new BuddyInfo("Alice Smith", "613-555-0101");
    }

    @Test
    void testGetName() {
        assertEquals("Alice Smith", buddy.getName());
    }

    @Test
    void testGetPhoneNumber() {
        assertEquals("613-555-0101", buddy.getPhoneNumber());
    }

    @Test
    void testSetName() {
        buddy.setName("Alicia Smith");
        assertEquals("Alicia Smith", buddy.getName());
    }

    @Test
    void testEquals() {
        BuddyInfo same = new BuddyInfo("Alice Smith", "613-555-0101");
        BuddyInfo different = new BuddyInfo("Bob Chen", "613-555-0102");
        assertEquals(buddy, same);
        assertNotEquals(buddy, different);
    }
}