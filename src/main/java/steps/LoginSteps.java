package steps;

import helpers.PropertyProvider;
import pages.LoginPage;
import EntitySource.User;
import org.openqa.selenium.WebDriver;

/**
 * Created by Iryna_Filipava1 on 12/2/2016.
 */
public class LoginSteps extends AbstactStep {

    private LoginPage loginPage;

    private static final String LOGIN_USER1 = PropertyProvider.getProperty("login_user1");
    private static final String PASSWORD_USER1 = PropertyProvider.getProperty("password_user1");
    private static final String LOGIN_USER2 = PropertyProvider.getProperty("login_user2");
    private static final String PASSWORD_USER2 = PropertyProvider.getProperty("password_user2");
    private static final String LOGIN_USER3 = PropertyProvider.getProperty("login_user3");
    private static final String PASSWORD_USER3 = PropertyProvider.getProperty("password_user3");

    public LoginSteps(WebDriver driver) {
        super(driver);
        loginPage = new LoginPage(driver);
    }

    public MailPageSteps authorizationLikeUser(User user) {
        logger.info("Authorization");
        loginPage.findLoginField();
        loginPage.typeLoginIntoLoginField(user.getLogin());
        loginPage.moveToNextPageButton();
        loginPage.typePasswordIntoPasswordField(user.getPassword());
        loginPage.clickStayInSystemBox();
        return new MailPageSteps(driver);
    }
}


/* public MailPageSteps authorizationLikeUser1() throws InterruptedException {
        logger.info("Authorization");
        loginPage.loginIntoGmailPostBox(ConstantContainer.LOGIN_USER1, ConstantContainer.PASSWORD_USER1);
        return new MailPageSteps(driver);
    }

    public MailPageSteps authorizationLikeUser2() throws InterruptedException {
        logger.info("Authorization");
        loginPage.loginIntoGmailPostBox(ConstantContainer.LOGIN_USER2, ConstantContainer.PASSWORD_USER2);
>>>>>>> Stashed changes
        return new MailPageSteps(driver);
    }*/
