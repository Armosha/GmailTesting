package base;

import entitySource.UserManager;
import helpers.FactoryDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import steps.*;

/**
 * Created by Iryna_Filipava1 on 12/2/2016.
 */
public class TestBase {

    protected WebDriver driver;
    protected Logger logger;
    protected LoginSteps loginSteps;
    protected MailPageSteps mailPageSteps;
    protected SpamSteps spamSteps;
    protected SettingPageSteps settingPage;
    protected SignatureSteps signaturesteps;
    protected SentSteps sentPages;
    protected StarredPageSteps starredSteps;
    protected ForwardPageSteps forwardPageSteps;
    protected UserManager tempUser;

    @BeforeMethod
    public void setUp() throws Exception {
        this.driver = FactoryDriver.getInstance();
        this.loginSteps = new LoginSteps(driver);
        this.mailPageSteps = new MailPageSteps(driver);
        this.spamSteps = new SpamSteps(driver);
        this.settingPage = new SettingPageSteps(driver);
        this.signaturesteps = new SignatureSteps(driver);
        this.sentPages = new SentSteps(driver);
        this.starredSteps = new StarredPageSteps(driver);
        this.forwardPageSteps = new ForwardPageSteps(driver);
        this.logger = Logger.getLogger("gmailLogger");
        tempUser = new UserManager();
    }

    @AfterMethod
    public void tearDown() throws Exception {
        //FactoryDriver.closeDriver();
       // driver.quit();
    }

}
