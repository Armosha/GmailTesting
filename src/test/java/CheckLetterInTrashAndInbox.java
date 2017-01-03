import base.TestBase;
import entitySource.User;
import entitySource.UserManager;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by Iryna_Filipava1 on 12/2/2016.
 */
public class CheckLetterInTrashAndInbox extends TestBase { //TODO

    UserManager tempUser = new UserManager();
    User firstUser;//TODO
    User thirdUser;
    User secondUser;


    @BeforeTest
    public void setUpPages() {
        secondUser = tempUser.getUser("secondUser");
        thirdUser = tempUser.getUser("thirdUser");
        firstUser = tempUser.getUser("firstUser");

    }

    @Test(description = "Check letter with and without attach in Trash and Inbox")
    public void checkMessageInTrash() throws InterruptedException {
        loginSteps.authorizationLikeUser(secondUser)
                .makeForwarding()
                .forwardingToUserThird(thirdUser);
        mailPageSteps.makeForwarding();
        forwardPageSteps.forwardingToUserThird(thirdUser)
                .logOutFromForwardPage();
        loginSteps.authorizationLikeUser(thirdUser)
                .getPermission();
        mailPageSteps.logOutFromEmailBox()
                .authorizationLikeUser(secondUser)
                .makeForwarding()
                .forwardingSettingPage()
                .setPopSettings(firstUser);

    }
}

