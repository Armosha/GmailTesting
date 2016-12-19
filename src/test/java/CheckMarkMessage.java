import base.TestBase;
import helpers.MyListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Created by Iryna_Filipava1 on 15.12.2016.
 */

@Listeners(MyListener.class)

@Test(description = "Check color of flag, check letter status")
public class CheckMarkMessage extends TestBase {

    public void checkMessage() throws InterruptedException {
        loginSteps.authorizationLikeUser1();
        mailPageSteps.goToStarredPage();
        Assert.assertTrue(starredSteps.checkLetterInStarred());
        Assert.assertTrue(mailPageSteps.chekStatus());
        Assert.assertTrue(mailPageSteps.chekStarColor());
    }
}

