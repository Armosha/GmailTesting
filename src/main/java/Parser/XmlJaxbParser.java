package Parser;


import EntitySource.User;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


public class XmlJaxbParser {


    public XmlJaxbParser() throws JAXBException {
    }

    public static List<User> createUser(String login, String password) throws ParseException, JAXBException {

        User userFirst = new User();
        userFirst.setLogin(login);
        userFirst.setPassword(password);

        User userSecond = new User();
        userSecond.setLogin(login);
        userSecond.setPassword(password);

        User userThird = new User();
        userThird.setLogin(login);
        userThird.setPassword(password);

        List<User> users = new ArrayList<User>();

        users.add(userFirst);
        users.add(userSecond);
        users.add(userFirst);

        try {
            users = XmlJaxbHandler.unmarshal(new File("usersbase.xml"));
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return users;
    }

}