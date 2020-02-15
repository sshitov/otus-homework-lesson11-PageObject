package Helpers.DomainSpecificLanguage;

import Helpers.Pages.AuthorizationPage;
import Helpers.Pages.MainPage;
import Helpers.Pages.ProfilePage;

public class Steps {

    MainPage mainPage = new MainPage();
    AuthorizationPage authorizationPage = new AuthorizationPage();
    ProfilePage profilePage = new ProfilePage();


    public void openMainPage(){
        mainPage.open();
    }

    public void openAuthorizationForm(){
        mainPage.openAuthorizationPage();
    }

    public void fillTheAuthorizationForm(String login, String password){
        authorizationPage.enterLogin(login);
        authorizationPage.enterPassword(password);
    }

    public void submitAuthorizationForm(){
        authorizationPage.authorize();
    }

    public void openProfilePage(){
        mainPage.openProfilePage();
    }

    public ProfilePage fillProfileFields(){
        return profilePage;
    }

}
