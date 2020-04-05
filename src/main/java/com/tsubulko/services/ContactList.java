package com.tsubulko.services;



import com.tsubulko.entity.Contact;

import java.util.LinkedList;
import java.util.List;


public class ContactList  {

  private   List<Contact> contacts = new LinkedList<Contact>();



    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }
}
