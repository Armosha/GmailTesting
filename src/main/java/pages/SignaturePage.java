package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
<<<<<<< HEAD
 * Created by Iryna_Filipava1 on 12/2/2016.
=======
 * Created by Iryna_Filipava1 on 12/19/2016.
>>>>>>> tempbranch1
 */
public class SignaturePage extends PageObject {

    public SignaturePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@role='textbox']")
    private WebElement signatureTextArea;

    @FindBy(css = "input[class='aJb']")
    private WebElement addSignaturebox;

    @FindBy(xpath = "//button[@guidedhelpid='save_changes_button']") //saveChangesButton
    private WebElement saveChangesButton;

    @FindBy(xpath = "//span[@class='rc' and text() = 'Подпись:']")
    private WebElement tempbutton;

    public void setSignatureInTextArea(String signature) throws InterruptedException {
        signatureTextArea.click();
        signatureTextArea.clear();
        signatureTextArea.sendKeys(signature);
        actions.click(tempbutton).build().perform(); //TODO
        actions.click(saveChangesButton).build().perform(); //TODO
    }

    public boolean checkigsaveChangesButton() {
        saveChangesButton.isEnabled();
        return false;
    }
}