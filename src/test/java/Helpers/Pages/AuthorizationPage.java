package Helpers.Pages;

import Helpers.DriverManagers.ChromeWebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AuthorizationPage {
    ChromeWebDriver chromeWebDriver = new ChromeWebDriver();

    public AuthorizationPage(){
        PageFactory.initElements(ChromeWebDriver.getDriver(),this);
    }

    @FindBy(css = "form[class*=login] [name='email']")
    protected WebElement email;

    @FindBy(css = "form[class*=login] [name='password']")
    protected WebElement password;

    @FindBy (css = "form[class*=login] [type='submit']")
    protected WebElement submitButton;

    @FindBy (css = ".header2__right p")
    protected WebElement userName;

    public WebElement getEmail() {
        return email;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getSubmitButton() {
        return submitButton;
    }

    public void enterLogin(String login){
        getEmail().clear();
        getEmail().sendKeys(login);
    }

    public void enterPassword(String password){
        getPassword().clear();
        getPassword().sendKeys(password);
    }

    public void authorize() {
        getSubmitButton().click();
        chromeWebDriver.getWait().until(ExpectedConditions.visibilityOf(userName));
    }
}
