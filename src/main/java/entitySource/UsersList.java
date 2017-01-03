package entitySource;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Iryna_Filipava1 on 12/24/2016.
 */

@XmlRootElement(name = "users")
public class UsersList {

    private List<User> usersList = new ArrayList<User>();

    @XmlElement(name = "user")
    public List<User> getListUsers() {
        return usersList;
    }

    public void setListUsers(List<User> listUsers) {
        this.usersList = listUsers;
    }
}
