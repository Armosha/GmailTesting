package steps;

import helpers.PropertyProvider;
import org.openqa.selenium.WebDriver;
import pages.SpamObject;

/**
 * Created by Iryna_Filipava1 on 12/2/2016.
 */
public class SpamSteps extends AbstactStep {

    private SpamObject spamObject;
    private static String SPAMPAGE_EXPECTED_RESULT = PropertyProvider.getProperty("user_name");


    public SpamSteps(WebDriver driver) {
        super(driver);
        spamObject = new SpamObject(driver);
    }

    public boolean checkLetterInSpam() {
        SPAMPAGE_EXPECTED_RESULT.equalsIgnoreCase(spamObject.takeUserName());
        return true;
    }
}
