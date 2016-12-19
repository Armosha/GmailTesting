package steps;

import helpers.FactoryDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by Iryna_Filipava1 on 12/2/2016.
 */
public abstract class AbstactStep {

    protected WebDriver driver;
    protected static final Logger logger = LogManager.getRootLogger();


    public AbstactStep(WebDriver driver) {
        this.driver = FactoryDriver.getInstance();
    }
}
