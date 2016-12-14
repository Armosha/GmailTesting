package steps;

import helpers.ConstantContainer;
import org.openqa.selenium.WebDriver;
import pages.SignaturePage;


public class SignatureSteps extends AbstactStep {

    private SignaturePage signaturePage;
    LoginSteps loginSteps = new LoginSteps(driver);
    MailPageSteps mailPageSteps = new MailPageSteps(driver);

    public SignatureSteps(WebDriver driver) {
        super(driver);
        signaturePage = new SignaturePage(driver);
    }

    public MailPageSteps setSignature() throws InterruptedException {
        logger.info("authorization like User1");
        loginSteps.authorizationLikeUser1();
        logger.info("get setting page");
        mailPageSteps.getSettingPage();
        logger.info("set signature in textArea and check 'save' button");
        signaturePage.setSignatureInTextArea(ConstantContainer.SIGNATURE1_TEXT);
        return new MailPageSteps(driver);
    }

    public boolean checkSettingTitle() {
        logger.info("check settings' page title");
        driver.getTitle().toString().equalsIgnoreCase(ConstantContainer.SETTINGTITLE_TEXT);
        return true;
    }

    public boolean checkSaveSetingButton() {
        signaturePage.checkigsaveChangesButton();
        return true;
    }

}

