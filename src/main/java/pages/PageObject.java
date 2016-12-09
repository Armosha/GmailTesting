package pages;

//import helpers.ExplicitWait;
import helpers.ExplicitWait;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Iryna_Filipava1 on 12/2/2016.
 */
public abstract class PageObject {

    WebDriver driver;
    protected ExplicitWait wait;
    protected Actions actions;
    protected Alert alert;


    public PageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        wait = new ExplicitWait(driver);
         actions = new Actions(this.driver);
    }
}
