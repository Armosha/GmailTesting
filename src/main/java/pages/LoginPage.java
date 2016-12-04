package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Iryna_Filipava1 on 12/2/2016.
 */
public class LoginPage extends PageObject {


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "input[id='Email']")
    private WebElement loginField;

    @FindBy(css = "input[id='next']")
    private WebElement nextButton;

    @FindBy(css = "input[id='Passwd']")
    private WebElement passwordField;

    @FindBy(css = "input[id='signIn']")
    private WebElement signInButton;

    @FindBy(css = "#PersistentCookie")
    private WebElement stayInCheck;

    public void loginIntoGmailPostBox(String login, String password) throws InterruptedException {
        loginField.clear();
        loginField.sendKeys(login);
        nextButton.click();
        passwordField.sendKeys(password);
        if (stayInCheck.isSelected()) {
            stayInCheck.click();
        }
        signInButton.click();
    }

}
