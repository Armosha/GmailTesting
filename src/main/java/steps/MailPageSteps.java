package steps;

import helpers.PropertyProvider;
import helpers.RandomString;
import org.openqa.selenium.WebDriver;
import pages.MailPage;


/**
 * Created by Iryna_Filipava1 on 12/2/2016.
 */
public class MailPageSteps extends AbstactStep {

    private static String SUBJECT_TEXT = RandomString.getRandomStringEng(8);
    private static String MESSAGE_TEXT = RandomString.getRandomStringEng(70);
    private static final String LOGIN_USER2 = PropertyProvider.getProperty("login_user2");
    private static final String LOGIN_USER3 = PropertyProvider.getProperty("login_user3");
    private MailPage mailPage;

    public MailPageSteps(WebDriver driver) {
        super(driver);
        mailPage = new MailPage(driver);
    }

    public MailPageSteps sendMessageToUser2() {
        mailPage.writeMessageToUser2(LOGIN_USER2, SUBJECT_TEXT, MESSAGE_TEXT);
        return this;
    }

    public LoginSteps logOutFromEmailBox() throws InterruptedException {
        mailPage.logOut();
        return new LoginSteps(driver);
    }

    public MailPageSteps markLetterAsSpam() {
        mailPage.markAsSpam();
        return this;
    }

    public SpamSteps moveToSpamPage() {
        mailPage.goToSpam();
        return new SpamSteps(driver);
    }

    public ForwardPageSteps makeForwarding() throws InterruptedException {
        mailPage.chooseForwarding();
        return new ForwardPageSteps(driver);
    }

}
