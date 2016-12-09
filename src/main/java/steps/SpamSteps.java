package steps;

import helpers.ConstantContainer;
import helpers.PropertyProvider;
import org.openqa.selenium.WebDriver;
import pages.SpamObject;

/**
 * Created by Iryna_Filipava1 on 12/2/2016.
 */
public class SpamSteps extends AbstactStep {

    private SpamObject spamObject;

    public SpamSteps(WebDriver driver) {
        super(driver);
        spamObject = new SpamObject(driver);
    }

    public boolean checkLetterInSpam() {
        logger.info("check letter into spam folder");
        ConstantContainer.SPAMPAGE_EXPECTED_RESULT.equalsIgnoreCase(spamObject.takeUserName());
        return true;
    }
}
