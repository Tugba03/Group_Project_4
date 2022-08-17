package Test;

import POM.ContactUsElement;
import POM.LoginElements;
import Utils.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class _02_ContactUsFunction extends BaseDriver {

    ContactUsElement contactUsElement;
    LoginElements loginElements;

    String expectedMessage = "Your message has been successfully sent to our team.";

    @Test
    @Parameters("Contact us")
    public void setContactUsElement(String message){
        loginElements = new LoginElements(driver);
        contactUsElement = new ContactUsElement(driver);


        wait.until(ExpectedConditions.elementToBeClickable(loginElements.signInButton)).click();
        loginElements.emailInput.sendKeys("group5@yahoo.com");
        loginElements.passwordInput.sendKeys("technostudy");
        wait.until(ExpectedConditions.elementToBeClickable(loginElements.clickSubmitButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(loginElements.homePageButton)).click();

        contactUsElement.contactUsButton.click();
        Select select = new Select(contactUsElement.subjectHeadingDropDown);
        select.selectByVisibleText("Webmaster");
        contactUsElement.messageInput.sendKeys(message);
        wait.until(ExpectedConditions.visibilityOf(contactUsElement.messageInput));
        wait.until(ExpectedConditions.elementToBeClickable(contactUsElement.sendButton)).click();

        Assert.assertEquals(contactUsElement.successMessage.getText(),expectedMessage);
        wait.until(ExpectedConditions.elementToBeClickable(loginElements.homePageButton)).click();







    }


}
