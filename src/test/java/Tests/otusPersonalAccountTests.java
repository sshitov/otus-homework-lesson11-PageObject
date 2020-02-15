package Tests;

import Helpers.DomainSpecificLanguage.Steps;
import Helpers.DriverManagers.ChromeWebDriver;
import Helpers.Pages.ProfilePage;
import org.hamcrest.core.StringContains;
import org.junit.*;
import org.junit.rules.ErrorCollector;

public class otusPersonalAccountTests {

    ChromeWebDriver chromeWebDriver = new ChromeWebDriver();
    Steps steps = new Steps();
    ProfilePage profilePage = new ProfilePage();

    String userLogin = System.getProperty("userLogin");
    String userPassword = System.getProperty("userPassword");

    @Rule
    public ErrorCollector errorCollector = new ErrorCollector();

    @BeforeClass
    public static void setupDriver() {
        ChromeWebDriver.driverLoad();
    }

    @Before
    public void createWebDriver(){
        chromeWebDriver.create();
    }

    @After
    public void closeWebDriver(){
    ChromeWebDriver.quit();
    }

    @Test
    public void fillAllFieldInProfileAboutYourself() {

        steps.openMainPage();
        steps.openAuthorizationForm();
        steps.fillTheAuthorizationForm(userLogin, userPassword);
        steps.submitAuthorizationForm();
        steps.openProfilePage();
        steps.fillProfileFields()
                .enterLocalFirstName("Сергей")
                .enterLatinFirstName("Sergeiy")
                .enterLocalSecondName("Шитов")
                .enterLatinSecondName("Shitov")
                .enterBlogName("ssergeiy")
                .enterDateOfBirth("16.08.1991")
                .selectCountryRussia()
                .selectCityMoscow()
                .selectRemoteWork()
                .selectCommunicationTypeSkype()
                .openFirstCommunicationTypeList()
                .selectCommunicationTypeSkype()
                .enterValueForFirstCommunicationType("sashitov")
                .addSecondCommunicationType()
                .openSecondCommunicationTypeList()
                .selectCommunicationTypeVK()
                .enterValueForSecondCommunicationType("https://vk.com/feed")
                .selectSecondCommunicationTypeLikePreferred()
                .selectGenderMale()
                .enterCompany("OtusHomeWork")
                .enterPosition("Student")
                .saveChangesOnTheProfilePage();
    }

    @Test
    public void verifyThatChangesInProfileIsSaved() {
        steps.openMainPage();
        steps.openAuthorizationForm();
        steps.fillTheAuthorizationForm(userLogin, userPassword);
        steps.submitAuthorizationForm();
        steps.openProfilePage();

        errorCollector.checkThat(profilePage.getValueTextField(profilePage.getLocalFirstName()), new StringContains("Сергей"));
        errorCollector.checkThat(profilePage.getValueTextField(profilePage.getLatinFirstName()), new StringContains("Sergeiy"));
        errorCollector.checkThat(profilePage.getValueTextField(profilePage.getLocalSecondName()), new StringContains("Шитов"));
        errorCollector.checkThat(profilePage.getValueTextField(profilePage.getLatinSecondName()), new StringContains("Shitov"));
        errorCollector.checkThat(profilePage.getValueTextField(profilePage.getBlogName()), new StringContains("ssergeiy"));
        errorCollector.checkThat(profilePage.getValueTextField(profilePage.getDateOfBirth()), new StringContains("16.08.1991"));
        errorCollector.checkThat(profilePage.getValueTextField(profilePage.getCountry()), new StringContains("Россия"));
        errorCollector.checkThat(profilePage.getValueTextField(profilePage.getCity()), new StringContains("Москва"));
        errorCollector.checkThat(profilePage.getValueCheckField(profilePage.getRemoteWork()), new StringContains("true"));
        errorCollector.checkThat(profilePage.getValueTextField(profilePage.getFirstCommunicationTypeSelector()), new StringContains("skype"));
        errorCollector.checkThat(profilePage.getValueTextField(profilePage.getEnterValueForFirstCommunicationType()), new StringContains("sashitov"));
        errorCollector.checkThat(profilePage.getValueTextField(profilePage.getSecondCommunicationTypeSelector()), new StringContains("vk"));
        errorCollector.checkThat(profilePage.getValueTextField(profilePage.getEnterValueForSecondCommunicationType()), new StringContains("https://vk.com/feed"));
        errorCollector.checkThat(profilePage.getValueCheckField(profilePage.getPreferredSecondCommunicationType()), new StringContains("true"));
        errorCollector.checkThat(profilePage.getValueTextField(profilePage.getGender()), new StringContains("m"));
        errorCollector.checkThat(profilePage.getValueTextField(profilePage.getCompany()), new StringContains("OtusHomeWork"));
        errorCollector.checkThat(profilePage.getValueTextField(profilePage.getPosition()), new StringContains("Student"));

    }

}
