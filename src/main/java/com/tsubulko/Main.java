package com.tsubulko;

import com.tsubulko.entity.*;
import com.tsubulko.services.ContactList;
import com.tsubulko.services.Manager;

import java.sql.Connection;
import java.util.Date;

import com.tsubulko.util.ConnectorDB;
import org.apache.log4j.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class);
    public static void main(String[] args) {
        ContactList book = new ContactList();
        Contact user= new Contact(1,new Address(1,"Belarus","Minsk region","Minsk",
                220),new Phone(1,"375","29","6836090", Phone.PhoneType.MOBILE,"Only before 12",1),
                "Ksusha","Tsubulko","Dmitievna", Contact.Sex.FEMALE,  new Date(2000,10,14),"Belarussian", Contact.Marital.SINGLE,
                "https://vk.com/orange____list","tsubulko.ksenia@gmail.com","BSUIR",new Photo(1,"C:/1.jpg"));
        Manager director = new Manager(book);  // связка директора и персонлист
        director.addContact(user);
        //logger.info("Это информационное сообщение!");
        director.removeContact(user);
        director.addContact(user);
        director.printContact();

    }
}
