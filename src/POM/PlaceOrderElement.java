package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PlaceOrderElement {
    public PlaceOrderElement(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//div[@class='product-container']")
    public WebElement clickOnFirstItem;

    @FindBy(xpath = "//span[text()='Add to cart']")
    public WebElement clickAtToCart;

    @FindBy(css = "a[class='btn btn-default button button-medium']")
    public WebElement firstProceedToCheckOutButton;

    @FindBy(xpath = "//span[text()='Proceed to checkout']")
    public WebElement summaryProceedCheckOut;

    @FindBy(xpath = "//span[text()='Proceed to checkout']")
    public WebElement addressProceedCheckOutButton;

    @FindBy(id = "cgv")
    public WebElement clickRadioButton;

    @FindBy(name = "processCarrier")
    public WebElement shippingCheckOutButton;

    @FindBy(className = "payment_module")
    public WebElement clickPaymentMethod;

    @FindBy(xpath = "//span[text()='I confirm my order']")
    public WebElement confirmOrder;

    @FindBy(xpath = "//strong[text()='Your order on My Store is complete.']")
    public WebElement confirmMessage;

    @FindBy(xpath = "//div[@class='box']")
    public WebElement referenceMessage;

    @FindBy(xpath = "//a[text()='My orders']")
    public WebElement clickMyOrder;

    @FindBy(css = "[class='color-myaccount']")
    public WebElement orderReferenceNumber;






}
