package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginElements {
    public LoginElements(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(css = "a[class='login']")
    public WebElement signInButton;

    @FindBy(id = "email")
    public WebElement emailInput;

    @FindBy(id = "passwd")
    public WebElement passwordInput;

    @FindBy(id = "SubmitLogin")
    public WebElement clickSubmitButton;

    @FindBy(css= "i[class='icon-chevron-left']")
    public WebElement homePageButton;

}