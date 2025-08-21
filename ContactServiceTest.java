package com.contactservice;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {

    private ContactService service;

    @BeforeEach
    public void setUp() {
        service = new ContactService();
    }

    @Test
    public void testAddContactWithObject() {
        Contact contact = new Contact("001", "Alice", "Smith", "1234567890", "100 Elm Street");
        service.addContact(contact);
        assertEquals("Alice", service.getContactById("001").getFirstName());
    }

    @Test
    public void testAddContactWithFields() {
        String id = service.addContact("Bob", "Jones", "0987654321", "200 Oak Avenue");
        Contact contact = service.getContactById(id);
        assertEquals("Bob", contact.getFirstName());
        assertEquals("Jones", contact.getLastName());
    }

    @Test
    public void testUpdateContactFields() {
        String id = service.addContact("Charlie", "Brown", "1112223333", "300 Pine Road");
        service.updateContact(id, "Chuck", "Bruno", "4445556666", "New Address");
        Contact updated = service.getContactById(id);
        assertEquals("Chuck", updated.getFirstName());
        assertEquals("Bruno", updated.getLastName());
        assertEquals("4445556666", updated.getPhone());
        assertEquals("New Address", updated.getAddress());
    }

    @Test
    public void testDeleteContact() {
        String id = service.addContact("Dana", "White", "7778889999", "400 Maple Blvd");
        service.deleteContact(id);
        assertThrows(IllegalArgumentException.class, () -> service.getContactById(id).getFirstName());
    }

    @Test
    public void testAddDuplicateContactThrowsException() {
        Contact contact = new Contact("005", "Eve", "Adams", "1231231234", "500 Birch Lane");
        service.addContact(contact);
        assertThrows(IllegalArgumentException.class, () -> service.addContact(contact));
    }

    @Test
    public void testUpdateWithInvalidPhoneThrowsException() {
        String id = service.addContact("Frank", "Miller", "9998887777", "600 Cedar Street");
        assertThrows(IllegalArgumentException.class, () -> service.updatePhone(id, "short"));
    }

    @Test
    public void testGeneratedIdLength() {
        String id = service.addContact("Grace", "Hopper", "8887776666", "700 Spruce Way");
        assertEquals(10, id.length());
    }
}
