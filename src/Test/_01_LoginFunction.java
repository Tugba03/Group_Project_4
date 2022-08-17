package Test;

import POM.ContactUsElement;
import POM.LoginElements;
import Utils.BaseDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class _01_LoginFunction extends BaseDriver {
        LoginElements loginElements;


    @Test
    public void loginFunction(){
        loginElements = new LoginElements(driver);
       wait.until(ExpectedConditions.elementToBeClickable(loginElements.signInButton)).click();

        loginElements.emailInput.sendKeys("group5@yahoo.com");
        loginElements.passwordInput.sendKeys("technostudy");
        wait.until(ExpectedConditions.elementToBeClickable(loginElements.clickSubmitButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(loginElements.homePageButton)).click();





    }


}
