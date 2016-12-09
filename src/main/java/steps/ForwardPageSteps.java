package steps;

import helpers.ConstantContainer;
import helpers.PropertyProvider;
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

    public ForwardPageSteps makeForwarding() throws InterruptedException {
        logger.info("make forwarding");
        forwardPage.chooseForwarding(ConstantContainer.LOGIN_USER3);
        return this;
    }
}
