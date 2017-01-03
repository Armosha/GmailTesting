import base.TestBase;
import entitySource.User;
import entitySource.UserManager;
import helpers.MyListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Created by Iryna_Filipava1 on 12/9/2016.
 */

@Listeners(MyListener.class)

@Test(description = "Check signature")
public class CheckSignature extends TestBase {

    private UserManager tempUser = new UserManager();
    private User firstUser = tempUser.getUser("firstUser");
    private User secondUser = tempUser.getUser("secondUser");

    public void checkSignature() throws InterruptedException {
        Assert.assertTrue(signaturesteps.checkSettingTitle());
        signaturesteps.setSignature();
        Assert.assertTrue(signaturesteps.checkSaveSetingButton());
       // mailPageSteps.sendMessageToUser2();
       // mailPageSteps.goToSentPage();
        sentPages.openMessagefromUser1();
        Assert.assertTrue(sentPages.checkSignature());
    }
}

