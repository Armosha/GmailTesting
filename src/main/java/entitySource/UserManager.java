package entitySource;


import Parser.UserJaxBParser;

import java.util.List;

/**
 * Created by Iryna_Filipava1 on 12/24/2016.
 */

public class UserManager {

    UserJaxBParser parser = new UserJaxBParser();
    List<User> usersList = parser.unmarshallList();

    public User getUser(String id) {
        User user = new User();
        for (User u : usersList) {
            if (u.getId().equals(id)) {
                user = u;
            }
        }
        return user;
    }
}


