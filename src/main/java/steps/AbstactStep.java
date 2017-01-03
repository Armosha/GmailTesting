package steps;

import helpers.FactoryDriver;
import org.openqa.selenium.WebDriver;
import org.apache.log4j.Logger;


/**
 * Created by Iryna_Filipava1 on 12/2/2016.
 */
public abstract class AbstactStep {

    protected WebDriver driver;
    Logger logger = Logger.getLogger("gmailLogger");//TODO



    public AbstactStep(WebDriver driver) {
        this.driver = FactoryDriver.getInstance();
    }
}
