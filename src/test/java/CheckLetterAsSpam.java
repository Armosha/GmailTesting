import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Iryna_Filipava1 on 12/2/2016.
 */
public class CheckLetterAsSpam extends TestBase {

    @Test(description = "Check letter from user1 in Spam")
        public void checkMessageInSpam() throws InterruptedException {
        loginSteps.authorizationLikeUser1();
        mailPageSteps.sendMessageToUser2();
        mailPageSteps.logOutFromEmailBox();
        loginSteps.authorizationLikeUser2();
        mailPageSteps.markLetterAsSpam();
        mailPageSteps.moveToSpamPage();
        Assert.assertTrue(spamSteps.checkLetterInSpam());
    }

}
