package steps;

import org.openqa.selenium.WebDriver;
import pages.StarredPage;

/**
 * Created by Iryna Filipava1 on 15.12.2016.
 */
public class StarredPageSteps extends AbstactStep {

    private StarredPage starredPage;

    public StarredPageSteps(WebDriver driver) {
        super(driver);
        starredPage = new StarredPage(driver);
    }

    public boolean checkLetterInStarred() {
        logger.info("get letters' subject from starred Page");
        starredPage.takeSubjectFromStarredPage();
        return true;//TODO
    }
}
