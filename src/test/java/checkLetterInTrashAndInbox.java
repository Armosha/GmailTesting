import base.TestBase;
import helpers.MyListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Created by Iryna_Filipava1 on 12/2/2016.
 */

@Listeners(MyListener.class)
public class checkLetterInTrashAndInbox extends TestBase {

    @Test(description = "Check letter with and without attach in Trash and Inbox")
    public void checkMessageInTrash() throws InterruptedException {
        loginSteps.authorizationLikeUser2();
        mailPageSteps.makeForwarding();
       forwardPageSteps.makeForwarding();
    }

}

