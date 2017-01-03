import base.TestBase;
import helpers.MyListener;
import org.testng.Assert;
import entitySource.User;
import entitySource.UserManager;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Created by Iryna_Filipava1 on 12/2/2016.
 */
@Listeners(MyListener.class)
public class CheckLetterAsSpam extends TestBase {

    private UserManager tempUser = new UserManager();
    private User firstUser;
    private User secondUser;


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
        logger.info(("Authorization into Gmailbox like second User"));
        loginSteps.authorizationLikeUser(secondUser);
        mailPageSteps.markLetterAsSpam()
                .moveToSpamPage();
        Assert.assertTrue(spamSteps.checkLetterInSpam(subject).contentEquals(subject));
    }

}
