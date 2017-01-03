package steps;

import entitySource.User;
import org.openqa.selenium.WebDriver;
import pages.ForwardPage;

/**
 * Created by Iryna_Filipava1 on 12/2/2016.
 */
public class ForwardPageSteps extends AbstactStep {

    private ForwardPage forwardPage;

    public ForwardPageSteps(WebDriver driver) {
        super(driver);
        forwardPage = new ForwardPage(driver);
    }

    public ForwardPageSteps forwardingToUserThird(User user) throws InterruptedException {
        logger.info("PopImap button click");
        forwardPage.forwardingPopImapClick();
        logger.info("set forward button click");
        forwardPage.setForwardButtonClick();
        logger.info("type third user login");
        forwardPage.typeThirdUserLogin(user.getLogin());
        return this;
    }

    public void logOutFromForwardPage() {
        forwardPage.logOutButtonClick();
        forwardPage.logOutFromForwardPage();
    }

    public ForwardPageSteps forwardingSettingPage() throws InterruptedException {
        logger.info("PopImap button click");
        forwardPage.forwardingPopImapClick();
        return this;
    }

    public ForwardPageSteps setPopSettings(User user){
        forwardPage.popRadioButtonClick();
        forwardPage.settingButtonClick();
        forwardPage.fromFilterButton(user.getLogin());
        return this;
    }


}
