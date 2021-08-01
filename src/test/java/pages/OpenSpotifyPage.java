package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class OpenSpotifyPage {

    private By userName = By.xpath("//*[@id=\"main\"]//figure//parent::button//span");

    private WebDriver driver;
    private WebDriverWait wait;

    public OpenSpotifyPage(WebDriver driver) {
            this.driver = driver;
    }

    public String getWebpageURL(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver.getCurrentUrl();
    }

    public String getUserName(){
        wait = new WebDriverWait(driver, 5);
        System.out.println(driver.getCurrentUrl());
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("main")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(userName));
        return driver.findElement(userName).getText();
    }
}
