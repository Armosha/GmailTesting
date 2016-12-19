package steps;

import helpers.PropertyProvider;
import EntitySource.User;
import helpers.ConstantContainer;
import helpers.RandomString;
import org.openqa.selenium.WebDriver;
import pages.MailPage;


/**
 * Created by Iryna_Filipava1 on 12/2/2016.
 */
public class MailPageSteps extends AbstactStep {

    private static String SUBJECT_TEXT = "from user1";
    private static String MESSAGE_TEXT = "Hello, java!";
    private static final String LOGIN_USER2 = PropertyProvider.getProperty("login_user2");
    private static final String LOGIN_USER3 = PropertyProvider.getProperty("login_user3");
    private MailPage mailPage;

    public MailPageSteps(WebDriver driver) {
        super(driver);
        mailPage = new MailPage(driver);
    }


    public String sendMessageToUser(User user) {
        logger.info("write and send message to secondUser");
        String subject = "Subject" + RandomString.getRandomStringEng(4);
        mailPage.composeButtonClick();
        mailPage.typeLogin(user.getLogin());
        mailPage.typeSubject(subject);
        mailPage.typeMessage(ConstantContainer.MESSAGE_TEXT);
        mailPage.sendMessageButtonClick();
        return subject;
    }

    public LoginSteps logOutFromEmailBox() {
        logger.info("log out email box");
        mailPage.generalAccountButtonClick();
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

    public StarredPageSteps goToStarredPage() {
        logger.info("move to starred page");
        mailPage.clickStarFlag();
        return new StarredPageSteps(driver);
    }

    public boolean chekStarColor() {
        logger.info("get star color");
        mailPage.getStarColor().contains("#222");
        return true;
    }

    public boolean chekStatus() {
        logger.info("check status");
        mailPage.getStatus().contains("Помеченные");
        return true;
    }

}
