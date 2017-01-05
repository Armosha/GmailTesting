package pages;

import org.openqa.selenium.NoAlertPresentException;
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

    @FindBy(xpath = "//a[text()='Forwarding and POP/IMAP']")//Forwarding and POP/IMAP
    private WebElement forwardingPopImap;

    @FindBy(css = "input[value='Add a forwarding address']") //Add a forwarding address
    private WebElement setForwardButton;

    @FindBy(xpath = "//div[@class='PN']//input")
    private WebElement forwardingAddressArea;

    @FindBy(xpath = "//button[@name='next' and text()='Next']")
    private WebElement nextStepButton;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//div[@class='Kj-JD-Jl']//button")
    private WebElement okButton;

    @FindBy(xpath = "//span[@class='gb_8a gbii']")
    private WebElement logOutFromForwardPageGeneralButton;

    @FindBy(xpath = "//a[@class='gb_Fa gb_Ne gb_Ue gb_wb']")
    private WebElement logOutFromForwardPageButton;

    @FindBy(xpath = "//input[@name='sx_em' and @value='1']")
    private WebElement popRadioButton;

    @FindBy(xpath = "//span[@class='e' and text()='creating a filter!']")
    private WebElement createFilterButton;

    @FindBy(xpath = "//input[@class='ZH nr aQa']")
    private WebElement filterFromButton;

    @FindBy(xpath = "//label[text()='Has attachment']")
    private WebElement checkBoxAttachFileButton;

    @FindBy(xpath = "//div[@class='acM']")
    private WebElement createButton;

    @FindBy(xpath = "//label[text()='Delete it']/../input")
    private WebElement deleteItButton;


    @FindBy(xpath = "//label[text()='Always mark it as important']/../input")
    private WebElement importantButton;


    @FindBy(xpath = "//div[@role='button' and text()='Create filter']")
    private WebElement saveFilterButton;

    @FindBy(xpath = "//button[@name='ok']")
    private WebElement filterOkButton;


    public void forwardingPopImapClick() throws InterruptedException {
        wait.waitForElementIsClickable(forwardingPopImap);
        forwardingPopImap.click();
    }

    public void setForwardButtonClick() throws InterruptedException {
        setForwardButton.click();
    }

    public void typeThirdUserLogin(String login) throws InterruptedException {
        forwardingAddressArea.sendKeys(login);
        nextStepButton.click();
        String nameOfMainWindow = driver.getWindowHandle();
        for (String names : driver.getWindowHandles()) {
            if (!names.equals(nameOfMainWindow)) {
                driver.switchTo().window(names);
                submitButton.click();
                driver.switchTo().window(nameOfMainWindow);
                okButton.click();
                wait.waitForElementIsClickable(logOutFromForwardPageGeneralButton);

            }
        }
    }

    public void logOutButtonClick() {
        wait.waitForElementIsClickable(logOutFromForwardPageGeneralButton);
        logOutFromForwardPageGeneralButton.click();
    }

    public void logOutFromForwardPage() {
        wait.waitForElementIsClickable(logOutFromForwardPageButton);
        logOutFromForwardPageButton.click();
        try {
            alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (alertText.contains("Your draft has been modified")) {
                alert.accept();
            }
        } catch (NoAlertPresentException e) {
        }
    }

    public void popRadioButtonClick() {
        popRadioButton.click();
    }

    public void settingButtonClick() {
        createFilterButton.click();
    }

    public void fromFilterButton(String login) {
        filterFromButton.click();
        filterFromButton.sendKeys(login);
        checkBoxAttachFileButton.click();
        createButton.click();
        filterOkButton.click();
        deleteItButton.click();
        importantButton.click();
        saveFilterButton.click();
    }

}

