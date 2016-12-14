package base;

import helpers.FactoryDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import steps.*;
import org.apache.log4j.Logger;


/**
 * Created by Iryna_Filipava1 on 12/2/2016.
 */
public class TestBase {

    protected WebDriver driver;
    protected Logger log;
    protected LoginSteps loginSteps;
    protected MailPageSteps mailPageSteps;
    protected SpamSteps spamSteps;
    protected SettingPageSteps settingPage;
    protected SignatureSteps signaturesteps;
    protected SentSteps sentPages;

    @BeforeMethod
    public void setUp() throws Exception {
        this.driver = FactoryDriver.getInstance();
        this.loginSteps = new LoginSteps(driver);
        this.mailPageSteps = new MailPageSteps(driver);
        this.spamSteps = new SpamSteps(driver);
        this.settingPage = new SettingPageSteps(driver);
        this.signaturesteps = new SignatureSteps(driver);
        this.sentPages = new SentSteps(driver);
        this.log = Logger.getLogger("gmailLogger");
    }


    @AfterMethod
    public void tearDown() throws Exception {
        FactoryDriver.closeDriver();
       // driver.quit();
    }

}
