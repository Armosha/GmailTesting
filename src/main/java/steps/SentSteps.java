package steps;

import org.openqa.selenium.WebDriver;
import pages.SentPage;

/**
 * Created by Iryna_Filipava1 on 12/19/2016.
 */
public class SentSteps extends AbstactStep {

    private SentPage sentPage;

    public SentSteps(WebDriver driver) {
        super(driver);
        sentPage = new SentPage(driver);
    }

    public SentSteps openMessagefromUser1() {
        logger.info("оpen message from User1");
        sentPage.clickMessagefromUser1();
        return this;//TODO
    }

    public boolean checkSignature() {
        logger.info("check Signature");
//TODO
        return true;//TODO
    }

}