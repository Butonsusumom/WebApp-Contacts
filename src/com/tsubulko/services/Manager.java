package com.tsubulko.services;

import com.tsubulko.entity.Contact;


import com.tsubulko.entity.Phone;
import com.tsubulko.exception.NoSuchContactException;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Manager {
    private ContactList contactList;
    private static final Logger logger = Logger.getLogger(Manager.class);

    private Manager() {
    }

    public Manager(ContactList contactList) {
        this.contactList = contactList;
    }


    public boolean addContact(Contact contact) {
        if (contactList.getContacts().add(contact)) {
            logger.info("contact id" + contact.getId() + " added");
            return true;
        }
        return false;
    }

    public void printContact() {
        for (Contact person :
                contactList.getContacts()) {
            System.out.println(person);
        }
    }

    public boolean removeContact(Contact contact) throws NoSuchContactException {
        if (contactList.getContacts().remove(contact)) {
            logger.info("contact id" + contact.getId() + " removed");
            return true;
        }
        return false;
    }
}

