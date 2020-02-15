package Helpers.Pages;

import Helpers.DriverManagers.ChromeWebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage {
    ChromeWebDriver chromeWebDriver = new ChromeWebDriver();
    AuthorizationPage authorizationPage = new AuthorizationPage();
    ProfilePage profilePage = new ProfilePage();

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

    public WebElement getUserName() {
        return userName;
    }

    public WebElement getMyProfile() {
        return myProfile;
    }

    public void open(){
        ChromeWebDriver.getDriver().get(baseUrl);
    }

    public void openAuthorizationPage() {
        getLoginButton().click();
        chromeWebDriver.getWait().until(ExpectedConditions.visibilityOf(authorizationPage.getEmail()));
    }

    public void openProfilePage() {
        getMyProfile().click();
        chromeWebDriver.getWait().until(ExpectedConditions.visibilityOf(profilePage.getLocalFirstName()));
    }
}
