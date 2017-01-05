import base.TestBase;
import entitySource.User;
import entitySource.UserManager;
import helpers.MyListener;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/**
 * Created by Iryna_Filipava1 on 15.12.2016.
 */

@Listeners(MyListener.class)

@Test(description = "Check color of flag, check letter status")
public class CheckMarkMessage extends TestBase {

    private UserManager tempUser = new UserManager();
    private User firstUser = tempUser.getUser("firstUser");
    private User secondUser = tempUser.getUser("secondUser");
    private SoftAssert as = new SoftAssert();

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
        as.assertTrue(starredSteps.checkLetterInStarred());
        as.assertTrue(mailPageSteps.chekStatus());
        as.assertTrue(mailPageSteps.chekStarColor());
        as.assertTrue(mailPageSteps.checkStarredFolder());
        as.assertAll();

    }
}

