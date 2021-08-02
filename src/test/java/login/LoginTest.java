package login;

import base.BaseTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.OpenSpotifyPage;

public class LoginTest extends BaseTests {

    @Test
    public void testSuccessfulLogin(){
        LoginPage loginPage = homePage.clickProfile();
        loginPage.setUserNameField("litro@freemail.hu");
        loginPage.setPasswordField("x2L3c4V5");
        OpenSpotifyPage openSpotifyPage = loginPage.clickSignInButton();
        String logInUser = openSpotifyPage.getUserName();
        Assertions.assertEquals(logInUser, "Szia, litro");
    }

}
