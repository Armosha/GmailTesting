package parser;

import entitySource.User;
import entitySource.UsersList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

/**
 * Created by Iryna_Filipava1 on 12/24/2016.
 */
public class UserJaxBParser {

    List<User> usersList;
    private static final String FILE_PATH = "src\\main\\resources\\usersbase.xml";

    public List<User> unmarshallList() {

        try {
            JAXBContext jc = JAXBContext.newInstance(UsersList.class);
            Unmarshaller um = jc.createUnmarshaller();
            UsersList user = (UsersList) um.unmarshal(new File(FILE_PATH));
            usersList = user.getListUsers();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return usersList;
    }
}