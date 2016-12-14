package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Iryna_Filipava1 on 12/2/2016.
 */
public class SignaturePage extends PageObject {

    public SignaturePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@role='textbox']")
    private WebElement signatureTextArea;

    @FindBy(xpath = "//td[2]/label[contains(text(), 'Добавлять')]")
    private WebElement addSignaturebox;

    @FindBy(xpath = "//button[@guidedhelpid='save_changes_button']") //saveChangesButton
    private WebElement saveChangesButton;




    //td[2]/label[contains(text(), 'Добавлять эту подпись')]
  //  @FindBy(css = "input[class='aJb']")
   // private WebElement addSignaturebox;

    public void setSignatureTextArea(String signature) throws InterruptedException {
        signatureTextArea.click();
        signatureTextArea.clear();
        signatureTextArea.sendKeys(signature);
        Thread.sleep(2000);
        addSignaturebox.click();
        Thread.sleep(2000);
        saveChangesButton.click();
        Thread.sleep(2000);


    }
}


