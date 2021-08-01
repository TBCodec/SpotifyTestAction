package registration;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.RegistrationPage;

import static org.testng.Assert.assertEquals;

public class RegistrationTests extends BaseTests {

    @Test
    public void testSuccessfulRegistration(){
        RegistrationPage registrationPage = homePage.clickRegistration();
        registrationPage.setIAmNotRobot();

    }

}
