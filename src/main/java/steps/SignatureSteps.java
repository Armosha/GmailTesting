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
        loginSteps.authorizationLikeUser1();
        mailPageSteps.getSettingPage();
        signaturePage.setSignatureTextArea(ConstantContainer.SIGNATURE1_TEXT);
        mailPageSteps.sendMessageToUser2();
        return new MailPageSteps(driver);
    }

    public SentSteps getSentPage(){
        mailPageSteps.goToSentPage();
        return new SentSteps(driver);
    }
}

