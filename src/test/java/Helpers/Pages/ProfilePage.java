package Helpers.Pages;

import Helpers.DriverManagers.ChromeWebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProfilePage {

    public ProfilePage(){
        PageFactory.initElements(ChromeWebDriver.getDriver(), this);
    }

    @FindBy(css = "[name='fname']")
    protected WebElement localFirstName;

    @FindBy(css = "[name='fname_latin']")
    protected WebElement latinFirstName;

    @FindBy(css = "[name='lname']")
    protected WebElement localSecondName;

    @FindBy(css = "[name='lname_latin']")
    protected WebElement latinSecondName;

    @FindBy(css = "[name='blog_name']")
    protected WebElement blogName;

    @FindBy(css = "[name='date_of_birth']")
    protected WebElement dateOfBirth;

    @FindBy(css = "[data-ajax-slave*='by_country'] label div")
    protected WebElement country;

    @FindBy(css = "[title='Россия']")
    protected WebElement countryRussia;

    @FindBy(css = ".js-lk-cv-dependent-slave-city label div")
    protected WebElement city;

    @FindBy(css = "[title='Москва']")
    protected WebElement cityMoscow;

    @FindBy(css = "[value='remote']")
    protected WebElement RemoteWork;

    @FindBy(css = "[name='contact-0-service']")
    protected WebElement firstCommunicationTypeSelector;

    @FindBy(css = "[title='Facebook']")
    protected WebElement facebookCommunicationType;

    @FindBy(css = "[name='contact-0-value']")
    protected WebElement enterValueForFirstCommunicationType;

    @FindBy(css = ".js-formset > button")
    protected WebElement addNewCommunicationType;

    @FindBy(css = "[name='contact-1-service']")
    protected WebElement secondCommunicationTypeSelector;

    @FindBy(css = ":nth-child(3) > .container__col_ssm-12 button[title='Тelegram']")
    protected WebElement telegramCommunicationType;

    @FindBy(css = "[name='contact-1-value']")
    protected WebElement enterValueForSecondCommunicationType;

    @FindBy(css = "[id='id_contact-1-preferable']")
    protected WebElement preferredSecondCommunicationType;

    @FindBy(css = "[id='id_gender']")
    protected WebElement gender;

    @FindBy(css = "[value='m']")
    protected WebElement genderMale;

    @FindBy(css = "[name='company']")
    protected WebElement company;

    @FindBy(css = "[name='work']")
    protected WebElement position;

    @FindBy(css = "[class*='button_gray']")
    protected WebElement saveChanges;

    //getMethods
    public WebElement getLocalFirstName() {
        return localFirstName;
    }

    public WebElement getLatinFirstName() {
        return latinFirstName;
    }

    public WebElement getLocalSecondName() {
        return localSecondName;
    }

    public WebElement getLatinSecondName() {
        return latinSecondName;
    }

    public WebElement getBlogName() {
        return blogName;
    }

    public WebElement getDateOfBirth() {
        return dateOfBirth;
    }

    public WebElement getCountry() {
        return country;
    }

    public WebElement getCountryRussia() {
        return countryRussia;
    }

    public WebElement getCity() {
        return city;
    }

    public WebElement getCityMoscow() { return cityMoscow; }

    public WebElement getRemoteWork() {
        return RemoteWork;
    }

    public WebElement getFirstCommunicationTypeSelector() {
        return firstCommunicationTypeSelector;
    }

    public WebElement getFacebookCommunicationType() {
        return facebookCommunicationType;
    }

    public WebElement getEnterValueForFirstCommunicationType() {
        return enterValueForFirstCommunicationType;
    }

    public WebElement getAddNewCommunicationType() {
        return addNewCommunicationType;
    }

    public WebElement getSecondCommunicationTypeSelector() {
        return secondCommunicationTypeSelector;
    }

    public WebElement getTelegramCommunicationType() {
        return telegramCommunicationType;
    }

    public WebElement getEnterValueForSecondCommunicationType() {
        return enterValueForSecondCommunicationType;
    }

    public WebElement getPreferredSecondCommunicationType() {
        return preferredSecondCommunicationType;
    }

    public WebElement getGender() {
        return gender;
    }

    public WebElement getGenderMale() {
        return genderMale;
    }

    public WebElement getCompany() {
        return company;
    }

    public WebElement getPosition() {
        return position;
    }

    public WebElement getSaveChanges() { return saveChanges; }

    //Methods
    public ProfilePage enterLocalFirstName(String localFirstName){
        getLocalFirstName().clear();
        getLocalFirstName().sendKeys(localFirstName);
        return this;
    }

    public ProfilePage enterLatinFirstName(String latinFirstName){
        getLatinFirstName().clear();
        getLatinFirstName().sendKeys(latinFirstName);
        return this;
    }

    public ProfilePage enterLocalSecondName(String localSecondName){
        getLocalSecondName().clear();
        getLocalSecondName().sendKeys(localSecondName);
        return this;
    }

    public ProfilePage enterLatinSecondName(String latinSecondName){
        getLatinSecondName().clear();
        getLatinSecondName().sendKeys(latinSecondName);
        return this;
    }

    public ProfilePage enterBlogName(String blogName){
        getBlogName().clear();
        getBlogName().sendKeys(blogName);
        return this;
    }

    public ProfilePage enterDateOfBirth(String dateOfBirth) {
        getDateOfBirth().clear();
        getDateOfBirth().sendKeys(dateOfBirth);
        return this;
    }

    public ProfilePage selectCountryRussia() {
        getCountry().click();
        getCountryRussia().click();
        return this;
    }

    public ProfilePage selectCityMoscow() {
        getCity().click();
        getCityMoscow().click();
        return this;
    }

    public ProfilePage selectRemoteWork() {
        String script = "document.querySelector(\"[value='remote']\").click();";
        ((JavascriptExecutor)ChromeWebDriver.getDriver()).executeScript(script);
        return this;
    }

    public ProfilePage openFirstCommunicationTypeList() {
        String script = "document.querySelector(\"[name='contact-0-service']\").click();";
        ((JavascriptExecutor)ChromeWebDriver.getDriver()).executeScript(script);
        return this;
    }

    public ProfilePage selectCommunicationTypeFacebook() {
        getFacebookCommunicationType().click();
        return this;
    }

    public ProfilePage enterValueForFirstCommunicationType(String value) {
        getEnterValueForFirstCommunicationType().clear();
        getEnterValueForFirstCommunicationType().sendKeys(value);
        return this;
    }

    public ProfilePage addSecondCommunicationType() {
        getAddNewCommunicationType().click();
        return this;
    }

    public ProfilePage openSecondCommunicationTypeList() {
        String script = "document.querySelector(\"[name='contact-1-service']\").click();";
        ((JavascriptExecutor)ChromeWebDriver.getDriver()).executeScript(script);
        return this;
    }

    public ProfilePage selectCommunicationTypeTelegram() {
        getTelegramCommunicationType().click();
        return this;
    }

    public ProfilePage enterValueForSecondCommunicationType(String value) {
        getEnterValueForSecondCommunicationType().clear();
        getEnterValueForSecondCommunicationType().sendKeys(value);
        return this;
    }

    public ProfilePage selectSecondCommunicationTypeLikePreferred() {
        String script = "document.querySelector(\"[id='id_contact-1-preferable']\").click();";
        ((JavascriptExecutor)ChromeWebDriver.getDriver()).executeScript(script);
        return this;
    }

    public ProfilePage selectGenderMale() {
        getGender().click();
        getGenderMale().click();
        return this;
    }

    public ProfilePage enterCompany(String value) {
        getCompany().clear();
        getCompany().sendKeys(value);
        return this;
    }

    public ProfilePage enterPosition(String value) {
        getPosition().clear();
        getPosition().sendKeys(value);
        return this;
    }

    public void saveChangesOnTheProfilePage() {
        getSaveChanges().click();
        ChromeWebDriver.getWait().until(ExpectedConditions.invisibilityOf(getSaveChanges()));

    }

    public String getValueTextField(WebElement webElement){
        return webElement.getAttribute("value");
    }

    public String getValueCheckField(WebElement webElement){
        return webElement.getAttribute("checked");
    }

}
