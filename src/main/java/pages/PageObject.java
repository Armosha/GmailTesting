package pages;

import helpers.ExplicitWait;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Iryna_Filipava1 on 12/2/2016.
 */
public abstract class PageObject {

    protected Alert alert;
    WebDriver driver;
    protected ExplicitWait wait;
    protected Actions actions;



    public PageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
     //   actions = new Actions(this.driver);
     //   wait = new ExplicitWait(this.driver);
    }
}
