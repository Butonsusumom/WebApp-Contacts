package com.tsubulko;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tsubulko.entity.*;
import com.tsubulko.services.ContactList;
import com.tsubulko.services.Manager;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class JsonConverter {
    private final static String baseFile = "contact.json";

    public static void main(String[] args) throws IOException {
        ContactList book = new ContactList();
        Contact user = new Contact(1, new Address(1, "Belarus", "Minsk region", "Minsk",
                220), new Phone(1, "375", "29", "6836090", Phone.PhoneType.MOBILE, "Only before 12", 1),
                "Ksusha", "Tsubulko", "Dmitievna", Contact.Sex.FEMALE, new Date(2000, 10, 14), "Belarussian", Contact.Marital.SINGLE,
                "https://vk.com/orange____list", "tsubulko.ksenia@gmail.com", "BSUIR", new Photo(1, "C:/1.jpg"));
        Manager director = new Manager(book);  // связка директора и персонлист
        director.addContact(user);
        Email email = new Email("Ksusha", "Nastya", "Hello", "Hello!Have a good day");



        ObjectMapper mapper = new ObjectMapper();
        String jsonuser = mapper.writeValueAsString(user);
        System.out.println("json user " + jsonuser);
        mapper.writeValue(new File(baseFile), user);

        Contact newUser = mapper.readValue(jsonuser, Contact.class);
        System.out.println(newUser);
    }
}
