package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class ContactUsElement{
    public ContactUsElement(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[text()='Contact us']")
    public WebElement contactUsButton;

    @FindBy(id = "id_contact")
    public WebElement subjectHeadingDropDown;

    @FindBy(id = "message")
    public WebElement messageInput;

    @FindBy(id = "submitMessage")
    public WebElement sendButton;

    @FindBy(css = "p[class='alert alert-success']")
    public WebElement successMessage;


}