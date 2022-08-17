package Test;

import POM.ContactUsElement;
import POM.LoginElements;
import POM.PlaceOrderElement;
import Utils.BaseDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class _03_PlaceOrderFunction extends BaseDriver {
    ContactUsElement contactUsElement;
    LoginElements loginElements;
    PlaceOrderElement placeOrderElement;

    String expectedMessage = "Your message has been successfully sent to our team.";

    @Test
    @Parameters("Contact us")
    public void setContactUsElement(String message) {
        loginElements = new LoginElements(driver);
        contactUsElement = new ContactUsElement(driver);
        placeOrderElement = new PlaceOrderElement(driver);

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

        Assert.assertEquals(contactUsElement.successMessage.getText(), expectedMessage);
        wait.until(ExpectedConditions.elementToBeClickable(loginElements.homePageButton)).click();

        Actions actions = new Actions(driver);
        actions.moveToElement(placeOrderElement.clickOnFirstItem).build().perform();
        placeOrderElement.clickAtToCart.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("arguments[0].scrollIntoView(true);" , placeOrderElement.clickAtToCart);
        placeOrderElement.clickAtToCart.click();
        wait.until(ExpectedConditions.elementToBeClickable(placeOrderElement.firstProceedToCheckOutButton)).click();
        js.executeScript("window.scrollBy(0,750)");
        wait.until(ExpectedConditions.elementToBeClickable(placeOrderElement.summaryProceedCheckOut)).click();
        wait.until(ExpectedConditions.elementToBeClickable(placeOrderElement.addressProceedCheckOutButton)).click();
        placeOrderElement.clickRadioButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(placeOrderElement.shippingCheckOutButton)).click();
        placeOrderElement.clickPaymentMethod.click();
        placeOrderElement.confirmOrder.click();

        Assert.assertTrue(placeOrderElement.confirmMessage.isDisplayed());
        String referenceMessage = placeOrderElement.referenceMessage.getText();

        placeOrderElement.clickMyOrder.click();
        Assert.assertTrue(referenceMessage.contains(placeOrderElement.orderReferenceNumber.getText().trim()));



    }
}