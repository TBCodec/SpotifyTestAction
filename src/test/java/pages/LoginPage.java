package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.google.common.io.Files;
import utils.WindowManager;

import java.io.File;

import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class LoginPage {
    private int i = 0;
    private WebDriver driver;
    private By userNameField = By.xpath("//input[@id='login-username']");
    private By passwordField = By.xpath("//input[@id='login-password']");
    private By signInButton = By.id("login-button");
    private By rememberMe = By.xpath("//label[@class='ng-binding']");
    private By alertWarning = By.xpath("//*[@id=\"app\"]//p[@class]//a");

    private WebDriverWait wait;

    protected WindowManager windowManager;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }


    public void setUserNameField(String userName){
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(rememberMe));
        driver.findElement(rememberMe).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(userNameField));
        driver.findElement(userNameField).click();
        driver.findElement(userNameField).sendKeys(userName);
    }
    public void setPasswordField(String password){
        driver.findElement(passwordField).click();
        driver.findElement(passwordField).sendKeys(password);
    }

    public OpenSpotifyPage clickSignInButton(){
        wait = new WebDriverWait(driver, 10);
        driver.findElement(signInButton).click();
        //driver.switchTo().alert().getText();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        /*
        FluentWait fluentWait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        fluentWait.until(ExpectedConditions.visibilityOfElementLocated(alertWarning));
        */
        /*
        if (driver.findElement(alertWarning).isDisplayed()){
            windowManager = new WindowManager(driver);
            windowManager.refresh();
            setUserNameField("litro@freemail.hu");
            setPasswordField("x2L3c4V5");
            driver.findElement(signInButton).click();
        }
        */
        /*
        try {
            driver.findElement(alertWarning);
            while (i < 5){
                i++;
                clickSignInButton();
            }

        }
        catch (Exception e){
            throw e;
        }*/
        //takeScreenshot();
        wait.until(ExpectedConditions.urlContains("https://open.spotify.com/"));
        System.out.println(driver.getCurrentUrl());
        return new OpenSpotifyPage(driver);
    }

/*

    public void takeScreenshot(){
        var camera = (TakesScreenshot)driver;
        File screenshot = camera.getScreenshotAs(OutputType.FILE);
        try {
            Files.move(screenshot, new File("resources/screenshots/test.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
*/

}
