package steps;

import helpers.ConstantContainer;
import org.openqa.selenium.WebDriver;
import pages.SettingPage;

/**
 * Created by Iryna_Filipava1 on 12/2/2016.
 */
public class SettingPageSteps extends AbstactStep {

    private SettingPage settingPage;

    public SettingPageSteps(WebDriver driver) {
        super(driver);
        settingPage = new SettingPage(driver);
    }

    public SettingPageSteps makeForwarding() throws InterruptedException {
        logger.info("make forwarding");
        settingPage.chooseForwarding(ConstantContainer.LOGIN_USER3);
        return this;
    }

}
