import base.TestBase;
import entitySource.User;
import entitySource.UserManager;
import helpers.MyListener;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Created by Iryna_Filipava1 on 15.12.2016.
 */

@Listeners(MyListener.class)

@Test(description = "Check color of flag, check letter status")
public class CheckMarkMessage extends TestBase {

    UserManager tempUser = new UserManager();
    User firstUser = tempUser.getUser("firstUser");
    User secondUser = tempUser.getUser("secondUser");

    @BeforeTest
    public void setUpPages() {
        firstUser = tempUser.getUser("firstUser");
        secondUser = tempUser.getUser("secondUser");
    }

    public void checkMessage() throws InterruptedException {
        loginSteps.authorizationLikeUser(firstUser);
        mailPageSteps.sendMessageToUser(secondUser);
        mailPageSteps.logOutFromEmailBox();
        loginSteps.authorizationLikeUser(secondUser);
        mailPageSteps.goToStarredPage();
        Assert.assertTrue(starredSteps.checkLetterInStarred());//TODO
        Assert.assertTrue(mailPageSteps.chekStatus());
        Assert.assertTrue(mailPageSteps.chekStarColor());
        Assert.assertTrue(mailPageSteps.checkStarredFolder());

    }
}

