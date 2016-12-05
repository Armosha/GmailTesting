package base;

//import helpers.ExplicitWait;
import helpers.FactoryDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import steps.ForwardPageSteps;
import steps.LoginSteps;
import steps.MailPageSteps;
import steps.SpamSteps;

/**
 * Created by Iryna_Filipava1 on 12/2/2016.
 */
public class TestBase {

    protected WebDriver driver;
    protected Logger log;
    protected LoginSteps loginSteps;
    protected MailPageSteps mailPageSteps;
    protected SpamSteps spamSteps;
    protected ForwardPageSteps forwardPageSteps;

    @BeforeMethod
    public void setUp() throws Exception {
        this.driver = FactoryDriver.getInstance();
        this.loginSteps = new LoginSteps(driver);
        this.mailPageSteps = new MailPageSteps(driver);
        this.spamSteps = new SpamSteps(driver);
        this.forwardPageSteps = new ForwardPageSteps(driver);
        this.log = LogManager.getRootLogger();
    }


    @AfterMethod
    public void tearDown() throws Exception {
        FactoryDriver.closeDriver();
       // driver.quit();
    }

}
