package com.tsubulko.services;

import com.tsubulko.entity.Address;
import com.tsubulko.entity.Contact;


import com.tsubulko.entity.Phone;
import com.tsubulko.exception.NoSuchContactException;
import com.tsubulko.util.Addresses;
import com.tsubulko.util.ConnectorDB;
import com.tsubulko.util.Contacts;
import com.tsubulko.util.Phones;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Manager {
    private static final Logger logger = LogManager.getLogger(Manager.class);
    private static ConnectorDB connector;
    private static final Contacts contactsTable;
    private static final Phones phoneNumbersTable;
    private static final Addresses addressesTable;

    static {
        try {
            connector = new ConnectorDB();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        contactsTable = new Contacts(connector);
        phoneNumbersTable = new Phones(connector);
        addressesTable = new Addresses(connector);
    }

    private Manager() {
    }

    public static void addContact(Contact contact) throws SQLException {
        contactsTable.insert(contact);
        Address address = contact.getAddress() != null ? contact.getAddress() : new Address();
        address.setContactId((int) contact.getId());
        addressesTable.insert(address);
    }

    public static void addPhoneNumber(Phone phoneNumber) throws SQLException {
        phoneNumbersTable.insert(phoneNumber);
    }

    public static void removeContact(int id) throws SQLException {
        contactsTable.delete("id = " + id);
        addressesTable.delete("contact_id = " + id);
    }

    public static void removePhoneNumber(int index, int contactId) throws SQLException {
        phoneNumbersTable.delete(String.format("(ind = %d) AND (contact_id = %d)", index, contactId));
    }

    // example of changes: "name = 'newName'", "surname = 'newSurname'"
    public static void editContact(int id, String... changes) throws SQLException {
        contactsTable.edit("id = " + id, changes);
    }

    // example of changes: "name = 'newName'", "surname = 'newSurname'"
    public static void editAddress(int contactId, String... changes) throws SQLException {
        addressesTable.edit("contact_id = " + contactId, changes);
    }

    // example of changes: "number = 12345", "surname = 'newSurname'"
    public static void editPhoneNumber(int contactId, int index, String... changes)
            throws SQLException {
        phoneNumbersTable.edit("(contact_id = " + contactId + ") AND " +
                "(ind = " + index + ")", changes);
    }

    // example of condition: "(id > 3) AND (name != 'test')"
    public static List<Contact> findContacts(String condition) throws SQLException {
        return contactsTable.find(condition);
    }

    // example of condition: "(id > 3) AND (name != 'test')"
    public static List<Phone> findPhoneNumbers(String condition) throws SQLException {
        return phoneNumbersTable.find(condition);
    }

    // example of condition: "(id > 3) AND (name != 'test')"
    public static List<Address> findAddresses(String condition) throws SQLException {
        return addressesTable.find(condition);
    }

    public static void clearContactsTable() throws SQLException {
        clearAddressesTable();
        clearPhoneNumbersTable();
        contactsTable.clear();
    }

    public static void clearAddressesTable() throws SQLException {
        addressesTable.clear();
    }

    public static void clearPhoneNumbersTable() throws SQLException {
        phoneNumbersTable.clear();
    }
}



