package com.contactservice;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactTest {

    @Test
    public void testValidContactCreation() {
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main Street");
        assertEquals("123", contact.getContactId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main Street", contact.getAddress());
    }

    @Test
    public void testInvalidContactIdTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "John", "Doe", "1234567890", "123 Main Street");
        });
    }

    @Test
    public void testNullContactId() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "John", "Doe", "1234567890", "123 Main Street");
        });
    }

    @Test
    public void testInvalidFirstNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "JonathanLongName", "Doe", "1234567890", "123 Main Street");
        });
    }

    @Test
    public void testNullFirstName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", null, "Doe", "1234567890", "123 Main Street");
        });
    }

    @Test
    public void testInvalidLastNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "John", "DoeWithLongLastName", "1234567890", "123 Main Street");
        });
    }

    @Test
    public void testNullLastName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "John", null, "1234567890", "123 Main Street");
        });
    }

    @Test
    public void testInvalidPhoneWrongLength() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "John", "Doe", "12345", "123 Main Street");
        });
    }

    @Test
    public void testInvalidPhoneNonNumeric() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "John", "Doe", "abcdefghij", "123 Main Street");
        });
    }

    @Test
    public void testNullPhone() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "John", "Doe", null, "123 Main Street");
        });
    }

    @Test
    public void testInvalidAddressTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "John", "Doe", "1234567890", "This address is definitely more than thirty characters long");
        });
    }

    @Test
    public void testNullAddress() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "John", "Doe", "1234567890", null);
        });
    }

    @Test
    public void testValidEdgeCaseAddressLength30() {
        String address = "123456789012345678901234567890"; // exactly 30 chars
        Contact contact = new Contact("123", "John", "Doe", "1234567890", address);
        assertEquals(address, contact.getAddress());
    }
}
