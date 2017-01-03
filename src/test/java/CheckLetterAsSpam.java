import base.TestBase;
import entitySource.User;
import entitySource.UserManager;
import helpers.MyListener;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import steps.LoginSteps;
import steps.MailPageSteps;

/**
 * Created by Iryna_Filipava1 on 12/2/2016.
 */
@Listeners(MyListener.class)
public class CheckLetterAsSpam extends TestBase {

    UserManager tempUser = new UserManager();//TODO
    User firstUser;//TODO
    User secondUser;//TODO


    @BeforeTest
    public void setUpPages() {
        firstUser = tempUser.getUser("firstUser");
        secondUser = tempUser.getUser("secondUser");
    }

    @Test(description = "Check letter from user1 in Spam")
    public void checkMessageInSpam() throws InterruptedException {

        loginSteps.authorizationLikeUser(firstUser);
        String subject = mailPageSteps.sendMessageToUser(secondUser);
        mailPageSteps.logOutFromEmailBox();
        logger.info("Authorization into Gmailbox like second User");
        loginSteps.authorizationLikeUser(secondUser);
        mailPageSteps.markLetterAsSpam()
                .moveToSpamPage();
        Assert.assertTrue(spamSteps.checkLetterInSpam(subject).contentEquals(subject));
    }

}
