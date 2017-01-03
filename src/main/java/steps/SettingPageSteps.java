package steps;

import entitySource.User;
import org.openqa.selenium.WebDriver;
import pages.SettingPage;

/**
 * Created by Iryna_Filipava1 on 12/19/2016.
 */
public class SettingPageSteps  extends AbstactStep {

    private SettingPage settingPage;


    public SettingPageSteps(WebDriver driver) {
        super(driver);
        settingPage = new SettingPage(driver);
    }

    public SettingPageSteps makeForwarding(User user) throws InterruptedException {
        logger.info("make forwarding");
        settingPage.chooseForwarding(user.getLogin());
        return this;
    }

}