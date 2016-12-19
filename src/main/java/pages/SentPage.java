package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Iryna_Filipava1 on 12/19/2016.
 */
public class SentPage extends PageObject {

    public SentPage (WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//div[@class='yW' and text()='Кому: ']")
    private WebElement messageButton;

    @FindBy(xpath = "//div[@class='ajR']")
    private WebElement partOfmessageButton;


    @FindBy(xpath = "//div[@data-smartmail='gmail_signature']/div")
    private WebElement signature;


    public void clickMessagefromUser1() {
        messageButton.click();
        partOfmessageButton.click();
    }

    public String getSignature(){
        String s = signature.getText().toString();
        return s;
    }

}