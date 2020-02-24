package Helpers.DomainSpecificLanguage;

import Helpers.Pages.AuthorizationPage;
import Helpers.Pages.MainPage;
import Helpers.Pages.ProfilePage;

public class Steps {

    MainPage mainPage = new MainPage();

    public void openMainPage(){
        mainPage.open();
    }

    public void openAuthorizationForm(){
        MainPage mainPage = new MainPage();
        mainPage.openAuthorizationPage();
    }

    public void fillTheAuthorizationForm(String login, String password){
        AuthorizationPage authorizationPage = new AuthorizationPage();
        authorizationPage.enterLogin(login);
        authorizationPage.enterPassword(password);
    }

    public void submitAuthorizationForm(){
        AuthorizationPage authorizationPage = new AuthorizationPage();
        authorizationPage.authorize();
    }

    public void openProfilePage() {
        MainPage mainPage = new MainPage();
        mainPage.openProfilePage();
    }

    public ProfilePage fillProfileFields(){
        return new ProfilePage();
    }

}
