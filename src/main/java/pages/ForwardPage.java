package pages;

import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by Iryna_Filipava1 on 12/2/2016.
 */
public class ForwardPage extends PageObject {

    public ForwardPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[text()='Пересылка и POP/IMAP']")//Forwarding and POP/IMAP
    private WebElement forwardingPopImap;

    @FindBy(css = "input[value='Добавить адрес пересылки']") //Add a forwarding address
    private WebElement setForwardbutton;

    @FindBy(xpath = "//div[@class='PN']/input")
    private WebElement forwardingAddressArea;

    @FindBy(xpath = "//button[@name='next' and text()='След.']")
    private WebElement nextStepButton;

    @FindBy(css = "input[type='submit']")
    private WebElement helpButton;

    @FindBy(xpath = "//button[@name='ok']")
    private WebElement okButton;


    public void chooseForwarding(String login) throws InterruptedException {

        forwardingPopImap.click();
        wait.until(ExpectedConditions.visibilityOf(setForwardbutton));
        setForwardbutton.click();
        wait.until(ExpectedConditions.visibilityOf(forwardingAddressArea));
        forwardingAddressArea.sendKeys(login);
        String forward = driver.getWindowHandle();
        nextStepButton.click();
        Thread.sleep(3000);
       try {
           driver.switchTo().window("Подтвердите адрес пересылки - Google Chrome");
       }catch (NoSuchWindowException e){
           System.out.println(e);
       }
        helpButton.click();
        driver.switchTo().window(forward);
        okButton.click();
    }
}

