package steps;

import helpers.PropertyProvider;
import org.openqa.selenium.WebDriver;
import pages.ForwardPage;

/**
 * Created by Iryna_Filipava1 on 12/2/2016.
 */
public class ForwardPageSteps extends AbstactStep {

    private ForwardPage forwardPage;
    private static final String LOGIN_USER3 = PropertyProvider.getProperty("login_user3");

    public ForwardPageSteps(WebDriver driver) {
        super(driver);
        forwardPage = new ForwardPage(driver);
    }

    public ForwardPageSteps makeForwarding() throws InterruptedException {
        forwardPage.chooseForwarding(LOGIN_USER3);
        return this;
    }
}
