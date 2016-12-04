package pages;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Iryna_Filipava1 on 12/2/2016.
 */
public class MailPage extends PageObject {

    public MailPage(WebDriver driver) {
        super(driver);
    }

    //write a letter
    @FindBy(xpath = "//div[@role='button' and text()='НАПИСАТЬ']")//Compose
    private WebElement writeButton;

    @FindBy(xpath = "//textarea[@name='to']")
    private WebElement rowForInputAddress;

    @FindBy(css = "input[name='subjectbox']")
    private WebElement rowForInputSubject;

    @FindBy(xpath = "//div[@role='textbox']")
    private WebElement areaForWritingMessage;

    @FindBy(xpath = "//div[@role='button' and text()='Отправить']")//Send
    private WebElement sendMessageButton;

    //logout
    @FindBy(css = ".gb_8a.gbii")
    private WebElement logOutFlag;

    @FindBy(css = "a[id='gb_71']")
    private WebElement logOutButton;

    @FindBy(css = "a[id='account-chooser-link']")
    private WebElement logInAnotherUserButton;

    //mark as spam
    @FindBy(xpath = "//div[@role='checkbox']")
    private WebElement flagBox;

    @FindBy(xpath = "//div[@class='ase T-I-J3 J-J5-Ji']")
    private WebElement spamButton;

    @FindBy(xpath = "//div[text()='Спам']")//Spam
    private WebElement chooseButton;


    //go to spam folder
    @FindBy(xpath = "//span[contains(text(), 'Ещё')]")//More
    private WebElement moreActionButton;

    @FindBy(xpath = "//a[contains(text(), 'Спам')]")//Spam
    private WebElement spamActionButton;

    //go to Forwarding Page
    @FindBy(xpath = "//div[@class='aos T-I-J3 J-J5-Ji']")//Settings
    private WebElement settingsButton;

    @FindBy(xpath = "//div[@class='J-N-Jz' and text()='Настройки']")//Settings
    private WebElement settingsText;


    public void writeMessageToUser2(String login, String password, String message) {
        writeButton.click();
        rowForInputAddress.sendKeys(login);
        rowForInputSubject.sendKeys(password);
        areaForWritingMessage.sendKeys(message);
        sendMessageButton.click();
    }

    public void logOut() {
        logOutFlag.click();
        logOutButton.click();
        try {
            alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (alertText.contains("Выполняется запрос к серверу. Если закрыть эту страницу, изменения не будут сохранены.\n" +
                    "Письмо не было отправлено.")) {
                alert.accept();
            }
        } catch (NoAlertPresentException e) {
        }
    }

    public void markAsSpam() {
        flagBox.click();
        spamButton.click();
        chooseButton.click();
    }

    public void goToSpam() {
        moreActionButton.click();
        spamActionButton.click();
    }

    public void chooseForwarding() throws InterruptedException {
        Thread.sleep(1000);
        settingsButton.click();
        settingsText.click();
        Thread.sleep(1000);
    }
}