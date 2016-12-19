package EntitySource;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "user")
public class User {

    private String login;
    private String password;

    public String getPassword() {
        return password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {

        StringBuilder str = new StringBuilder();
        if (password != null && login != null) {
            str = str.append("User login is: " + login)
                    .append("\n")
                    .append("User password is: " + password);
        }
        return str.toString();
    }
}

