import base.TestBase;
import entitySource.User;
import entitySource.UserManager;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.awt.*;

/**
 * Created by Iryna_Filipava1 on 12/2/2016.
 */
public class CheckLetterInTrashAndInbox extends TestBase {

    private SoftAssert as = new SoftAssert();
    private UserManager tempUser = new UserManager();
    private User firstUser;
    private User thirdUser;
    private User secondUser;


    @BeforeTest
    public void setUpPages() {
        secondUser = tempUser.getUser("secondUser");
        thirdUser = tempUser.getUser("thirdUser");
        firstUser = tempUser.getUser("firstUser");
    }

    @Test(description = "Check letter with and without attach in Trash and Inbox")
    public void checkMessageInTrash() throws InterruptedException, AWTException {
        loginSteps.authorizationLikeUser(secondUser)
                .makeForwarding()
                .forwardingToUserThird(thirdUser);
        forwardPageSteps.logOutFromForwardPage();
        loginSteps.authorizationLikeUser(thirdUser)
                .getPermission();
        mailPageSteps.logOutFromEmailBox()
                .authorizationLikeUser(secondUser)
                .makeForwarding()
                .forwardingSettingPage()
                .setPopSettings(firstUser);
        forwardPageSteps.logOutFromForwardPage();
        loginSteps.authorizationLikeUser(firstUser);
        String subject = mailPageSteps.sendMessageToUser(secondUser);
        String subjectLetterWithAttach = mailPageSteps.sendMessageToUserWithAttach(secondUser);
        mailPageSteps.logOutFromEmailBox()
                .authorizationLikeUser(secondUser);
        as.assertTrue(mailPageSteps.checkLetterInbox(subject).contentEquals(subject));

    }
}

