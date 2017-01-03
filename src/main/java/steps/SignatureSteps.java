package steps;

import org.openqa.selenium.WebDriver;
import pages.SignaturePage;

/**
 * Created by Iryna_Filipava1 on 12/19/2016.
 */
public class SignatureSteps extends AbstactStep {

    private SignaturePage signaturePage;


    public SignatureSteps(WebDriver driver) {
        super(driver);
        signaturePage = new SignaturePage(driver);
    }

    public SignatureSteps setSignature() throws InterruptedException {
        logger.info("authorization like User1");
      //  loginPage.authorizationLikeUser();
        logger.info("get setting page");
      //  mailPageSteps.getSettingPage();
        logger.info("set signature in textArea and check 'save' button");
      //  signaturePage.setSignatureInTextArea(ConstantContainer.SIGNATURE1_TEXT);
        return new SignatureSteps(driver);
    }

  /*  public boolean checkSettingTitle() {
        logger.info("check settings' page title");
        driver.getTitle().toString().equalsIgnoreCase(ConstantContainer.SETTINGTITLE_TEXT);
        return true;//TODO
    }*/

    public boolean checkSaveSetingButton() {
        signaturePage.checkigsaveChangesButton();
        return true;//TODO
    }

}