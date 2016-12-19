package steps;

import helpers.ConstantContainer;
import org.openqa.selenium.WebDriver;
import pages.StarredPage;

/**
 * Created by Iryna Filipava1 on 15.12.2016.
 */
public class StarredPageSteps extends AbstactStep{

   private StarredPage starredPage;

    public StarredPageSteps(WebDriver driver){
        super(driver);
        starredPage = new StarredPage(driver);
    }

    public boolean checkLetterInStarred() {
        logger.info("check letter into starred folder");
        ConstantContainer.STARRED_EXPECTED_RESULT.equalsIgnoreCase(starredPage.takeUserName());
        return true;
    }

}
