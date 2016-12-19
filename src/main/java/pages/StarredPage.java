package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Iryna_Filipava1 on 15.12.2016.
 */
public class StarredPage extends PageObject{

    public StarredPage (WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[@class = 'zF']")
    private WebElement userName;

    public String takeUserName() {
        String name = userName.getText().toString();
        return name;
    }
}
