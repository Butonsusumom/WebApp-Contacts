package serialization;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.tsubulko.entity.Contact;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SerialConverter implements Serialization {
    @Override
    public void serialise(List<Contact> data, String name) throws IOException {
        String baseFile = name;
        ObjectMapper mapper = new ObjectMapper();
        //mapper.enableDefaultTyping();
        String jsonuser = mapper.writeValueAsString(data);
        mapper.writeValue(new File(baseFile),  new ArrayList<Contact>(data));
        System.out.println(jsonuser);


    }

    @Override
    public List<Contact> deserialise(String name,List<Contact> now) throws IOException {
            String jsonuser = "";
            Scanner in = new Scanner(new File(name));
            while(in.hasNext())
                jsonuser += in.nextLine();
            in.close();
            System.out.println(jsonuser);

            ObjectMapper mapper = new ObjectMapper();
            //mapper.enableDefaultTyping();
            CollectionType type = mapper.getTypeFactory().constructCollectionType(List.class,Contact.class);
            List<Contact> result = mapper.readValue(jsonuser, type);

            System.out.println(result);
            return result;
    }

}

