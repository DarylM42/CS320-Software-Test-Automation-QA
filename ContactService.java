package com.contactservice;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ContactService {

    private final Map<String, Contact> contacts = new HashMap<>();

    public void addContact(Contact contact) {
        if (contact == null || contacts.containsKey(contact.getContactId())) {
            throw new IllegalArgumentException("Contact cannot be null and must have a unique ID.");
        }
        contacts.put(contact.getContactId(), contact);
    }

    public String addContact(String firstName, String lastName, String phone, String address) {
        String id = generateUniqueId();
        Contact contact = new Contact(id, firstName, lastName, phone, address);
        addContact(contact);
        return id;
    }

    public void deleteContact(String contactId) {
        if (contactId == null || !contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID must exist to delete.");
        }
        contacts.remove(contactId);
    }

    public void updateContact(String contactId, String firstName, String lastName, String phone, String address) {
        validateField("firstName", firstName);
        validateField("lastName", lastName);
        validateField("phone", phone);
        validateField("address", address);

        Contact updated = new Contact(contactId, firstName, lastName, phone, address);
        contacts.put(contactId, updated);
    }

    public void updateFirstName(String contactId, String newFirstName) {
        validateField("firstName", newFirstName);
        updateField(contactId, "firstName", newFirstName);
    }

    public void updateLastName(String contactId, String newLastName) {
        validateField("lastName", newLastName);
        updateField(contactId, "lastName", newLastName);
    }

    public void updatePhone(String contactId, String newPhone) {
        validateField("phone", newPhone);
        updateField(contactId, "phone", newPhone);
    }

    public void updateAddress(String contactId, String newAddress) {
        validateField("address", newAddress);
        updateField(contactId, "address", newAddress);
    }

    private void updateField(String contactId, String field, String value) {
        Contact contact = getContact(contactId);
        String firstName = field.equals("firstName") ? value : contact.getFirstName();
        String lastName  = field.equals("lastName")  ? value : contact.getLastName();
        String phone     = field.equals("phone")     ? value : contact.getPhone();
        String address   = field.equals("address")   ? value : contact.getAddress();

        Contact updated = new Contact(contactId, firstName, lastName, phone, address);
        contacts.put(contactId, updated);
    }

    private void validateField(String field, String value) {
        switch (field) {
            case "firstName":
            case "lastName":
                if (value == null || value.length() > 10) {
                    throw new IllegalArgumentException(field + " must be non-null and ≤ 10 characters.");
                }
                break;
            case "phone":
                if (value == null || value.length() != 10 || !value.matches("\\d+")) {
                    throw new IllegalArgumentException("Phone number must be exactly 10 digits.");
                }
                break;
            case "address":
                if (value == null || value.length() > 30) {
                    throw new IllegalArgumentException("Address must be non-null and ≤ 30 characters.");
                }
                break;
            default:
                throw new IllegalArgumentException("Unknown field: " + field);
        }
    }

    private Contact getContact(String contactId) {
        if (contactId == null || !contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID must exist.");
        }
        return contacts.get(contactId);
    }

    public Contact getContactById(String contactId) {
        if (contactId == null || !contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID must exist.");
        }
        return contacts.get(contactId);
    }

    private String generateUniqueId() {
        return UUID.randomUUID().toString().substring(0, 10);
    }
}
