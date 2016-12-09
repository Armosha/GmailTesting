package steps;

import helpers.ExplicitWait;
import helpers.FactoryDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by Iryna_Filipava1 on 12/2/2016.
 */
public abstract class AbstactStep {

    protected WebDriver driver;
    protected Logger logger = Logger.getLogger("gmailLogger");

    public AbstactStep(WebDriver driver) {
        this.driver = FactoryDriver.getInstance();
    }
}
