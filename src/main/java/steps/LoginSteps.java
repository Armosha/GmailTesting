package steps;

import entitySource.User;
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

    public MailPageSteps authorizationLikeUser(User user) {
        logger.info("Authorization into Gmailbox");
        loginPage.findLoginField();
        loginPage.typeLoginIntoLoginField(user.getLogin());
        loginPage.moveToNextPageButton();
        loginPage.typePasswordIntoPasswordField(user.getPassword());
        loginPage.clickStayInSystemBox();
        return new MailPageSteps(driver);
    }

}