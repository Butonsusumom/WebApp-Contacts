package com.tsubulko;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tsubulko.entity.*;
import com.tsubulko.services.ContactList;
import com.tsubulko.services.Manager;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class JsonConverter {
    private final static String baseFile = "contact.json";

    public static void main(String[] args) throws IOException, SQLException {
        List<Contact> contacts = new LinkedList<Contact>();
        ContactList book = new ContactList();
        Contact user= new Contact(1,new Address(1,"Belarus","Minsk", "Perehyodnaya",12,220),
                "Ksusha","Tsubulko","Dmitievna", Contact.Sex.FEMALE,  "2000-14-10", Contact.Marital.SINGLE,
                "tsubulko.ksenia@gmail.com","BSUIR","C:/1.jpg","belarussian");
       // Manager director = new Manager(book);  // связка директора и персонлист
        //director.addContact(user);
        contacts.add(user);
        Email email = new Email("Ksusha", "Nastya", "Hello", "Hello!Have a good day");

        serialization.SerialConverter conv = new serialization.SerialConverter();
        conv.serialise(contacts ,"1.txt");
        contacts  = conv.deserialise("1.txt", contacts );
        System.out.println(contacts);

    }
}
