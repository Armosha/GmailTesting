package steps;

import helpers.ConstantContainer;
import org.openqa.selenium.WebDriver;
import pages.SentPage;


public class SentSteps extends AbstactStep {

    private SentPage sentPage;

    public SentSteps(WebDriver driver) {
        super(driver);
        sentPage = new SentPage(driver);
    }

    public SentSteps openMessagefromUser1() {
        logger.info("оpen message from User1");
        sentPage.clickMessagefromUser1();
        return this;
    }

    public boolean checkSignature() {
        logger.info("check Signature");
        ConstantContainer.SIGNATURE1_TEXT.equalsIgnoreCase(sentPage.getSignature());
        return true;
    }

}
