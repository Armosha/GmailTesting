package steps;

import entitySource.User;
import helpers.RandomString;
import org.openqa.selenium.NoAlertPresentException;
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


    public String sendMessageToUser(User user) {
        logger.info("write and send message to secondUser");
        String subject = "Subject" + RandomString.getRandomStringEng(4);
        mailPage.composeButtonClick();
        mailPage.typeLogin(user.getLogin());
        mailPage.typeSubject(subject);
        mailPage.typeMessage("New message");
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
        mailPage.getStarColor().contains("#222");
        return true;//TODO
    }

    public boolean chekStatus() {
        logger.info("check status mark letter");
        mailPage.getStatus().contains("Помеченные");
        return true;//TODO
    }

    public boolean checkStarredFolder() {
        logger.info("check that Starred Folder is displayd");
        return mailPage.getStarredFolderStatus();
    }

    public void getPermission(){
        mailPage.letterFromGmailClick();
        mailPage.linkFromGmailTeamCklick();

    }



}
