package pages;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

/**
 * Created by Iryna_Filipava1 on 12/2/2016.
 */
public class MailPage extends PageObject {

    public MailPage(WebDriver driver) {
        super(driver);
    }

    //write a letter
    @FindBy(xpath = "//div[@role='button' and text()='COMPOSE']")//Compose
    private WebElement writeButton;

    @FindBy(xpath = "//textarea[@name='to']")
    private WebElement rowForInputAddress;

    @FindBy(css = "input[name='subjectbox']")
    private WebElement rowForInputSubject;

    @FindBy(xpath = "//div[@role='textbox']")
    private WebElement areaForWritingMessage;

    @FindBy(xpath = "//div[@role='button' and text()='Send']")//Send
    private WebElement sendMessageButton;

    @FindBy(xpath = "//a[contains(text(), 'Send')]") //Send
    private WebElement sentMessageButton;

    @FindBy(xpath = "//div[@class='y6']//b[1]")
    private WebElement rowSubject;


    //logout
    @FindBy(css = ".gb_8a.gbii")
    private WebElement logOutFlag;

    @FindBy(xpath = "//a[@class='gb_Fa gb_Ne gb_Ue gb_wb']")
    private WebElement logOutButton;

    @FindBy(css = "a[id='account-chooser-link']")
    private WebElement logInAnotherUserButton;

    //mark as spam
    @FindBy(xpath = "//div[@role='checkbox']")
    private WebElement flagBox;

    @FindBy(xpath = "//div[@class='ase T-I-J3 J-J5-Ji']")
    private WebElement spamButton;

    @FindBy(xpath = "//div[text()='Spam']")//Spam
    private WebElement chooseButton;


    //go to spam folder
    @FindBy(xpath = "//span[contains(text(), 'More')]")//More
    private WebElement moreActionButton;

    @FindBy(xpath = "//a[contains(text(), 'Spam')]")//Spam
    private WebElement spamActionButton;

    //go to Forwarding Page
    @FindBy(xpath = "//div[@class='aos T-I-J3 J-J5-Ji']")//Settings
    private WebElement settingsButton;

    @FindBy(xpath = "//div[@class='J-N-Jz' and text()='Settings']")//Settings
    private WebElement settingsText;

    // mark message and check color
    @FindBy(xpath = "//td[@class='apU xY']") //Star
    private WebElement yellowStarFlag;

    @FindBy(xpath = "//span[@class='aXw T-KT']") //Star
    private WebElement commaStarFlag;

    @FindBy(xpath = "//span[@class='nU ']")
    private WebElement markLettersButton;

    @FindBy(xpath = "//span[@email='forwarding-noreply@google.com'][1]")
    private WebElement letterFromGmailTeam;

    @FindBy(xpath = "//div//a[4]")
    private WebElement linkFromGmailTeam;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//div[@class='a1 aaA aMZ']")
    private WebElement attachButton;

    @FindBy(xpath = "//div[@class='y6']")
    private WebElement subjectString;


    public void composeButtonClick() {
        wait.waitForElementIsClickable(writeButton);
        writeButton.click();
    }

    public void typeLogin(String login) {
        rowForInputAddress.sendKeys(login);
    }

    public void typeSubject(String subject) {
        rowForInputSubject.sendKeys(subject);
    }

    public void typeMessage(String message) {
        areaForWritingMessage.sendKeys(message);
    }

    public void sendMessageButtonClick() throws InterruptedException {
        sendMessageButton.click();
        wait.waitForElementIsClickable(writeButton);
        Thread.sleep(1000);
    }

    public void attachButtonClick() throws InterruptedException, AWTException {
        attachButton.click();
        StringSelection ss = new StringSelection("C:\\Logs.log");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
        Robot robot = new Robot();
        Thread.sleep(3000);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
        Thread.sleep(6000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(6000);
    }

    public void generalAccountButtonClick() {
        logOutFlag.click();
    }

    public void logOut() {
        logOutButton.click();
        try {
            alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (alertText.contains("Your draft has been modified")) {
                alert.accept();
            }
        } catch (NoAlertPresentException e) {
        }
    }

    public String findLetterInInbox() {
        return subjectString.getText().toString();
    }

    public void spamFlagBox() {
        flagBox.click();
    }

    public void spamButton() {
        spamButton.click();
    }

    public void spamButtonClick() {
        chooseButton.click();
    }


    public void goToSpam() {
        moreActionButton.click();
        spamActionButton.click();
    }

    public void chooseForwarding() throws InterruptedException {
        settingsButton.click();
        settingsText.click();
    }

    public void sentMessageButtonClick() {
        sentMessageButton.click();

    }

    public void changeStarColor() {
        commaStarFlag.click();
    }

    public void clickStarFolder() {
        markLettersButton.click();
    }

    public String getStatus() {
        return yellowStarFlag.getAttribute("title");
    }

    public String getStarColor() {
        return yellowStarFlag.getCssValue("color");
    }

    public boolean getStarredFolderStatus() {
        return markLettersButton.isDisplayed();
    }

    public void letterFromGmailClick() {
        letterFromGmailTeam.click();
    }

    public void linkFromGmailTeamCklick() {
        linkFromGmailTeam.click();
        String nameOfMainWindow = driver.getWindowHandle();
        for (String names : driver.getWindowHandles()) {
            if (!names.equals(nameOfMainWindow)) {
                driver.switchTo().window(names);
                submitButton.click();
            }
            driver.switchTo().window(nameOfMainWindow);
        }
    }
}
