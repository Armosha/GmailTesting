import EntitySource.User;
import base.TestBase;
import helpers.MyListener;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import steps.LoginSteps;
import steps.MailPageSteps;

/**
 * Created by Iryna_Filipava1 on 12/2/2016.
 */
@Listeners(MyListener.class)
public class CheckLetterAsSpam extends TestBase {

    private LoginSteps loginSteps;
    private MailPageSteps mailPageSteps;

    @BeforeMethod
    public void setUpPages() {

        loginSteps = new LoginSteps(driver);
        mailPageSteps = new MailPageSteps(driver);
    }

    @Test(description = "Check letter from user1 in Spam")

        public void checkMessageInSpam(User user) throws InterruptedException {
        loginSteps.authorizationLikeUser(firstUser);
        String subject = mailPageSteps.sendMessageToUser(secondUser);
        mailPageSteps.logOutFromEmailBox();
        loginSteps.authorizationLikeUser(secondUser);


        mailPageSteps.markLetterAsSpam(subject)
                .moveToSpamPage();
        Assert.assertTrue(spamSteps.checkLetterInSpam(subject));
    }

}
