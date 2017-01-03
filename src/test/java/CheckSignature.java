import base.TestBase;
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

