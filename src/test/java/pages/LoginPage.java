package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LoginPage {

    private WebDriver driver;
    private By userNameField = By.xpath("//input[@id='login-username']");
    private By passwordField = By.xpath("//input[@id='login-password']");
    private By signInButton = By.id("login-button");
    private By rememberMe = By.xpath("//label[@class='ng-binding']");

    private WebDriverWait wait;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }


    public void setUserNameField(String userName){
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(rememberMe));
        driver.findElement(rememberMe).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(userNameField));
        driver.findElement(userNameField).sendKeys(userName);
    }
    public void setPasswordField(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    public OpenSpotifyPage clickSignInButton(){
        wait = new WebDriverWait(driver, 10);
        driver.findElement(signInButton).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.urlContains("https://open.spotify.com/"));
        System.out.println(driver.getCurrentUrl());
        return new OpenSpotifyPage(driver);
    }

}
