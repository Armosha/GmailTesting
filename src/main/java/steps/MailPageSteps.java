package steps;

import helpers.ConstantContainer;
import org.openqa.selenium.WebDriver;
import pages.MailPage;


/**
 * Created by Iryna_Filipava1 on 12/2/2016.
 */
public class MailPageSteps extends AbstactStep {

    private MailPage mailPage;

    public MailPageSteps(WebDriver driver) {
        super(driver);
        mailPage = new MailPage(driver);
    }

    public MailPageSteps sendMessageToUser2() {
        logger.info("write and send message to user2");
        mailPage.writeMessageToUser2(ConstantContainer.LOGIN_USER2, ConstantContainer.SUBJECT_TEXT, ConstantContainer.MESSAGE_TEXT);
        return this;
    }

    public LoginSteps logOutFromEmailBox() throws InterruptedException {
        logger.info("log out email box");
        mailPage.logOut();
        return new LoginSteps(driver);
    }

    public MailPageSteps markLetterAsSpam() {
        logger.info("mark letter as spam");
        mailPage.markAsSpam();
        return this;
    }

    public SpamSteps moveToSpamPage() {
        logger.info("move to spam page");
        mailPage.goToSpam();
        return new SpamSteps(driver);
    }

    public SettingPageSteps getSettingPage() throws InterruptedException {
        logger.info("move to forward page");
        mailPage.getSetting();
        return new SettingPageSteps(driver);
    }

    public SentSteps goToSentPage() {
        logger.info("move to sent page");
        mailPage.sentMessageButtonClick();
        return new SentSteps(driver);
    }

}
