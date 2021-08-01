package login;

import base.BaseTests;
import org.junit.jupiter.api.RepeatedTest;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import pages.LoginPage;
import pages.OpenSpotifyPage;

public class LoginTest extends BaseTests {

    @RepeatedTest(5)
    public void testSuccessfulLogin(){
        LoginPage loginPage = homePage.clickProfile();
        loginPage.setUserNameField("litro@freemail.hu");
        loginPage.setPasswordField("x2L3c4V5");
        OpenSpotifyPage openSpotifyPage = loginPage.clickSignInButton();
        String actualURL = openSpotifyPage.getWebpageURL();
        assertEquals(actualURL, "https://open.spotify.com/");
        String logedInUser = openSpotifyPage.getUserName();
        assertEquals(logedInUser, "litro");
    }

}
