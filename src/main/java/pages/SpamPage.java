package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Iryna_Filipava1 on 12/2/2016.
 */
public class SpamPage extends PageObject {

    public SpamPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='y6']//b")
    private WebElement subject;


    public String takeSubject() {
        return subject.getText().toString();
    }
}