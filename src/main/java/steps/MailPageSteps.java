package steps;

import entitySource.User;
import helpers.RandomString;
import org.openqa.selenium.WebDriver;
import pages.MailPage;

import java.awt.*;


/**
 * Created by Iryna_Filipava1 on 12/2/2016.
 */
public class MailPageSteps extends AbstactStep {

    private MailPage mailPage;

    public MailPageSteps(WebDriver driver) {
        super(driver);
        mailPage = new MailPage(driver);
    }


    public String sendMessageToUser(User user) throws InterruptedException {
        logger.info("write and send message to secondUser");
        String subject = "Subject" + RandomString.getRandomStringEng(4);
        mailPage.composeButtonClick();
        mailPage.typeLogin(user.getLogin());
        mailPage.typeSubject(subject);
        mailPage.typeMessage("New message");
        mailPage.sendMessageButtonClick();
        return subject;
    }

    public String sendMessageToUserWithAttach(User user) throws AWTException, InterruptedException {
        logger.info("write and send message with attach to secondUser");
        mailPage.composeButtonClick();
        String subject = "Subject" + RandomString.getRandomStringEng(4);
        mailPage.typeLogin(user.getLogin());
        mailPage.typeSubject(subject);
        mailPage.typeMessage("New message");
        mailPage.attachButtonClick();
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
        mailPage.spamFlagBox();
        mailPage.spamButton();
        mailPage.spamButtonClick();
        return this;
    }

    public SpamSteps moveToSpamPage() {
        mailPage.goToSpam();
        return new SpamSteps(driver);
    }

    public String checkLetterInbox(String subject){
        mailPage.findLetterInInbox();
        return subject;
    }

    public ForwardPageSteps makeForwarding() throws InterruptedException {
        mailPage.chooseForwarding();
        return new ForwardPageSteps(driver);
    }

    public StarredPageSteps goToStarredPage() {
        logger.info("move to starred page");
        mailPage.changeStarColor();
        mailPage.clickStarFolder();
        return new StarredPageSteps(driver);
    }

    public boolean chekStarColor() {
        logger.info("get star color");
        return mailPage.getStarColor().contains("#222");
    }/////

    public boolean chekStatus() {
        logger.info("check status mark letter");
        return mailPage.getStatus().contains("Помеченные");
    }////

    public boolean checkStarredFolder() {
        logger.info("check that Starred Folder is displayed");
        return mailPage.getStarredFolderStatus();
    }///

    public void getPermission() {
        mailPage.letterFromGmailClick();
        mailPage.linkFromGmailTeamCklick();
    }
}
