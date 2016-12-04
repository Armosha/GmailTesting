package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    @FindBy(xpath = "//div[@class='PN']")
    private WebElement forwardingAddressArea;

    @FindBy(xpath = "//button[@name='next' and text()='След.']")
    private WebElement nextStepButton;


    public void chooseForwarding(String login) throws InterruptedException {

        forwardingPopImap.click();
        Thread.sleep(1000);

        setForwardbutton.click();
        Thread.sleep(1000);

        forwardingAddressArea.sendKeys(login);
        Thread.sleep(1000);

        nextStepButton.click();

    }
}

