package entitySource;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Iryna_Filipava1 on 12/24/2016.
 */

@XmlRootElement(name = "user")
public class User {

    private String id;
    private String login;
    private String password;

    public User() {
        super();
    }

    public User(String id, String login, String password) {
        super();
        this.id = id;
        this.login = login;
        this.password = password;
    }

    @XmlElement
    public String getId() {
        return id;
    }

    @XmlElement
    public String getLogin() {
        return login;
    }

    @XmlElement
    public String getPassword() {
        return password;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        if (password != null && login != null && id != null) {
            str = str.append("User id is: " + id)
                    .append("\n")
                    .append("User login is: " + login)
                    .append("\n")
                    .append("User password is: " + password);
        }
        return str.toString();
    }
}
