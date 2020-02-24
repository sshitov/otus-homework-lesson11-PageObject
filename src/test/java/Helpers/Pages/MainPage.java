package Helpers.Pages;

import Helpers.DriverManagers.ChromeWebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage {

    protected String baseUrl = "https://otus.ru/";

    public MainPage(){
        PageFactory.initElements(ChromeWebDriver.getDriver(), this);
    }

    @FindBy (css = "[class*='auth'] button")
    protected WebElement loginButton;

    @FindBy (css = ".header2__right p")
    protected WebElement userName;

    @FindBy (css = ".header2-menu__dropdown-text_name")
    protected WebElement myProfile;

    public WebElement getLoginButton() {
        return loginButton;
    }

    public WebElement getUserName() { return userName; }

    public WebElement getMyProfile() {
        return myProfile;
    }

    public void open(){
        ChromeWebDriver.getDriver().get(baseUrl);
    }

    public void openAuthorizationPage() {
        getLoginButton().click();
    }

    public void openProfilePage() {
        ChromeWebDriver.getWait().until(ExpectedConditions.visibilityOf(getUserName()));
        ChromeWebDriver.getAction().moveToElement(getUserName()).perform();
        getMyProfile().click();
    }
}
