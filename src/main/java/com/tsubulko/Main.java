package com.tsubulko;

import com.tsubulko.entity.*;
import com.tsubulko.services.ContactList;
import com.tsubulko.services.Manager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import com.tsubulko.util.ConnectorDB;
import org.apache.log4j.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class);
    public static void main(String[] args) throws SQLException {
        Contact user= new Contact(1,new Address(1,"Belarus","Minsk", "Perehyodnaya",12,220),
                "Ksusha","Tsubulko","Dmitievna", Contact.Sex.FEMALE,  "2000-14-10", Contact.Marital.SINGLE,
                "tsubulko.ksenia@gmail.com","BSUIR","C:/1.jpg","belarussian");
      /*    Manager director = new Manager(book);  // связка директора и персонлист
        director.addContact(user);
        //logger.info("Это информационное сообщение!");
        director.removeContact(user);
        director.addContact(user);
        director.printContact();*/
        Manager.addContact(user);
        Manager.removeContact(0);
        Manager.addPhoneNumber(new Phone(2,1,"375","29","6836090", Phone.PhoneType.MOBILE,"Before 12"));
        Manager.removePhoneNumber(0, 0);
       Manager.addContact(new Contact("lol", "kek"));


    }
}
