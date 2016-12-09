package steps;

import helpers.ConstantContainer;
import helpers.PropertyProvider;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

/**
 * Created by Iryna_Filipava1 on 12/2/2016.
 */
public class LoginSteps extends AbstactStep {

    private LoginPage loginPage;

    public LoginSteps(WebDriver driver) {
        super(driver);
        loginPage = new LoginPage(driver);
    }

    public MailPageSteps authorizationLikeUser1() throws InterruptedException {
        logger.info("Authorization");
        loginPage.loginIntoGmailPostBox(ConstantContainer.LOGIN_USER1, ConstantContainer.PASSWORD_USER1);
        return new MailPageSteps(driver);
    }

    public MailPageSteps authorizationLikeUser2() throws InterruptedException {
        logger.info("Authorization");
        loginPage.loginIntoGmailPostBox(ConstantContainer.LOGIN_USER2, ConstantContainer.PASSWORD_USER2);
        return new MailPageSteps(driver);
    }

    public MailPageSteps authorizationLikeUser3() throws InterruptedException {
        logger.info("Authorization");
        loginPage.loginIntoGmailPostBox(ConstantContainer.LOGIN_USER3, ConstantContainer.PASSWORD_USER3);
        return new MailPageSteps(driver);
    }
}
