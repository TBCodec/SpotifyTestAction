package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private WebDriver driver;
    private By userNameField = By.xpath("//input[@id='login-username']");
    private By passwordField = By.xpath("//input[@id='login-password']");
    private By signInButton = By.id("login-button");
    private WebDriverWait wait;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }


    public void setUserNameField(String userName){
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(userNameField));
        driver.findElement(userNameField).sendKeys(userName);
    }
    public void setPasswordField(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    public OpenSpotifyPage clickSignInButton(){
        driver.findElement(signInButton).click();
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlToBe("https://open.spotify.com/"));
        return new OpenSpotifyPage(driver);
    }

}
