package serialization;

import com.tsubulko.entity.Contact;

import java.io.IOException;
import java.util.List;

public interface Serialization {
    public void serialise(List<Contact> data, String name) throws IOException;
    public List<Contact> deserialise(String name, List<Contact> now) throws IOException, ClassNotFoundException, Exception;
}
