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


    public void findLoginField() {
        loginField.clear();
    }

    public void typeLoginIntoLoginField(String login) {
        loginField.sendKeys(login);
    }

    public void moveToNextPageButton() {
        nextButton.click();
    }

    public void typePasswordIntoPasswordField(String password) {
        passwordField.sendKeys(password);
    }

    public void clickStayInSystemBox() {
        if (stayInCheck.isSelected()) {
            stayInCheck.click();
        }
        signInButton.click();
    }

}
