package Tests;

import Helpers.DomainSpecificLanguage.Steps;
import Helpers.DriverManagers.ChromeWebDriver;
import Helpers.Pages.ProfilePage;
import org.hamcrest.core.StringContains;
import org.junit.*;
import org.junit.rules.ErrorCollector;

public class OtusPersonalAccountTests {

    ChromeWebDriver chromeWebDriver = new ChromeWebDriver();
    Steps steps = new Steps();

/*    String userLogin = System.getProperty("userLogin");
    String userPassword = System.getProperty("userPassword");*/

    String userLogin = "Shitovsergeya@yandex.ru";
    String userPassword = "ukupnik2134";

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
    public void updateAllPersonalInformation() throws InterruptedException {

        // Change data on the profile page
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
                .openFirstCommunicationTypeList()
                .selectCommunicationTypeFacebook()
                .enterValueForFirstCommunicationType("sashitov")
                .addSecondCommunicationType()
                .openSecondCommunicationTypeList()
                .selectCommunicationTypeTelegram()
                .enterValueForSecondCommunicationType("https://vk.com/feed")
                .selectSecondCommunicationTypeLikePreferred()
                .selectGenderMale()
                .enterCompany("OtusHomeWork")
                .enterPosition("Student")
                .saveChangesOnTheProfilePage();

        // Close the browser and the open profile page in a clean browser
        ChromeWebDriver.getDriver().quit();
        chromeWebDriver.create();

        ProfilePage profilePage = new ProfilePage();

        // Verifying that all change in the fields is saved
        steps.openMainPage();
        steps.openAuthorizationForm();
        steps.fillTheAuthorizationForm(userLogin, userPassword);
        steps.submitAuthorizationForm();
        steps.openProfilePage();

        errorCollector.checkThat("Имя не соответствует ожидаемому",
                profilePage.getValueTextField(profilePage.getLocalFirstName()), new StringContains("Сергей"));
        errorCollector.checkThat("Имя на латинице не соответствует ожидаемому",
                profilePage.getValueTextField(profilePage.getLatinFirstName()), new StringContains("Sergeiy"));
        errorCollector.checkThat("Фамилия не соответствует ожидаемой",
                profilePage.getValueTextField(profilePage.getLocalSecondName()), new StringContains("Шитов"));
        errorCollector.checkThat("Фамилия на латинице не соответствует ожидаемой",
                profilePage.getValueTextField(profilePage.getLatinSecondName()), new StringContains("Shitov"));
        errorCollector.checkThat("Имя в блоге не соответствует ожидаемому",
                profilePage.getValueTextField(profilePage.getBlogName()), new StringContains("ssergeiy"));
        errorCollector.checkThat("Дата рождения не соответствует ожидаемой",
                profilePage.getValueTextField(profilePage.getDateOfBirth()), new StringContains("16.08.1991"));
        errorCollector.checkThat("Страна не соответствует ожидаемой",
                profilePage.getInnerTextTextField(profilePage.getCountry()), new StringContains("Россия"));
        errorCollector.checkThat("Город не соответствует ожидаемому",
                profilePage.getInnerTextTextField(profilePage.getCity()), new StringContains("Москва"));
        errorCollector.checkThat("Значение \"Удаленная работа\" не проставлено",
                profilePage.getValueCheckField(profilePage.getRemoteWork()), new StringContains("true"));
        errorCollector.checkThat("Первый вид связи не facebook",
                profilePage.getValueTextField(profilePage.getFirstCommunicationTypeSelector()), new StringContains("facebook"));
        errorCollector.checkThat("Значение в поле для вида связи skype - не соответсвует ожидаемому",
                profilePage.getValueTextField(profilePage.getEnterValueForFirstCommunicationType()), new StringContains("sashitov"));
        errorCollector.checkThat("Второй вид связи не telegram",
                profilePage.getValueTextField(profilePage.getSecondCommunicationTypeSelector()), new StringContains("telegram"));
        errorCollector.checkThat("Значение в поле для вида связи vk - не соответсвует ожидаемому",
                profilePage.getValueTextField(profilePage.getEnterValueForSecondCommunicationType()), new StringContains("https://vk.com/feed"));
        errorCollector.checkThat("Значение \"Предпочтительный вид связи\" не проставлено",
                profilePage.getValueCheckField(profilePage.getPreferredSecondCommunicationType()), new StringContains("true"));
        errorCollector.checkThat("Пол не соответствует ожидаемому",
                profilePage.getValueTextField(profilePage.getGender()), new StringContains("m"));
        errorCollector.checkThat("Компания не соответствует ожидаемой",
                profilePage.getValueTextField(profilePage.getCompany()), new StringContains("OtusHomeWork"));
        errorCollector.checkThat("Должность не соответствует ожидаемой",
                profilePage.getValueTextField(profilePage.getPosition()), new StringContains("Student"));

    }

}
