package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class OpenSpotifyPage {

    private By userName = By.xpath("//*[@id=\"main\"]//span[@data-testid='user-widget-name']");

    WebDriver driver;

    public OpenSpotifyPage(WebDriver driver) {
            this.driver = driver;
    }

    public String getWebpageURL(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver.getCurrentUrl();
    }

    public String getUserName(){
       return driver.findElement(userName).getText();
    }
}
