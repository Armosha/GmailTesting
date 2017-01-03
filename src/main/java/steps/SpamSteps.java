package steps;

import pages.SpamPage;
import org.openqa.selenium.WebDriver;

/**
 * Created by Iryna_Filipava1 on 12/2/2016.
 */
public class SpamSteps extends AbstactStep {

    private SpamPage spamPage;

    public SpamSteps(WebDriver driver) {
        super(driver);
        spamPage = new SpamPage(driver);
    }

    public String checkLetterInSpam(String subject) {
        spamPage.takeSubject();
        return subject;
    }
}
