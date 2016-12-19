package Parser;


import EntitySource.User;
import EntitySource.Users;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

public class XmlJaxbHandler {

    public static List<User> unmarshal(File importFile) throws JAXBException {
        Users users = new Users();
        JAXBContext context = JAXBContext.newInstance(Users.class);
        Unmarshaller um = context.createUnmarshaller();
        users = (Users) um.unmarshal(importFile);
        return users.getUsers();
    }
}
