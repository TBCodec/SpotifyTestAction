package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private WebDriver driver;
    private WebDriverWait wait;
    private By profileButton = By.xpath("//*[@id=\"main\"]//button[@data-testid='login-button']");
    private By registrationButton = By.xpath("//a[@href='https://www.spotify.com/hu/signup/']");
    private By cookiesAcceptButton = By.id("onetrust-accept-btn-handler");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public LoginPage clickProfile(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(profileButton));
        driver.findElement(profileButton).click();

        return new LoginPage(driver);
    }

    public RegistrationPage clickRegistration(){
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(registrationButton));
        driver.findElement(registrationButton).click();
        return new RegistrationPage(driver);
    }

    public void clickCookies(){
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(cookiesAcceptButton));
        driver.findElement(cookiesAcceptButton).click();
    }

}
