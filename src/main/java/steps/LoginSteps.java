package steps;

import helpers.PropertyProvider;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

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

    public MailPageSteps authorizationLikeUser1() throws InterruptedException {
        log.info("Authorization");
        loginPage.loginIntoGmailPostBox(LOGIN_USER1, PASSWORD_USER1);
        return new MailPageSteps(driver);
    }

    public MailPageSteps authorizationLikeUser2() throws InterruptedException {
        log.info("Authorization");
        loginPage.loginIntoGmailPostBox(LOGIN_USER2, PASSWORD_USER2);
        return new MailPageSteps(driver);
    }

    public MailPageSteps authorizationLikeUser3() throws InterruptedException {
        log.info("Authorization");
        loginPage.loginIntoGmailPostBox(LOGIN_USER3, PASSWORD_USER3);
        return new MailPageSteps(driver);
    }
}
