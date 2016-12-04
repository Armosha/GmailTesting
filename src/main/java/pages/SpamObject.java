package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Iryna_Filipava1 on 12/2/2016.
 */
public class SpamObject extends PageObject {

    public SpamObject(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[@name = 'Selya Selenium']")
    private WebElement username;


    public String takeUserName() {
        String result = username.getText().toString();
        return result;
    }
}