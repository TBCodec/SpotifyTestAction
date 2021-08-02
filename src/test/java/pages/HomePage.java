package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private WebDriver driver;
    private WebDriverWait wait;
    private By profileButton = By.xpath("//*[@id=\"preview-menu\"]/div/button[1]/span");
    private By registrationButton = By.xpath("//a[@href='https://www.spotify.com/hu/signup/']");
    private By cookiesAcceptButton = By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]");
    private By menuButton = By.xpath("//*[@id=\"preview-menu-container\"]");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void clickMenuButton(){
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(menuButton));
        driver.findElement(menuButton).click();
    }

    public LoginPage clickProfile(){
        clickMenuButton();
        wait = new WebDriverWait(driver, 10);
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
        wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(cookiesAcceptButton));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(cookiesAcceptButton).click();
    }

}