package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.HomePage;

import java.util.concurrent.TimeUnit;

public class BaseTests {

    private WebDriver driver;
    protected HomePage homePage;

    @BeforeEach
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        //System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless");
        options.addArguments("--window-size=1920,1080");
        //options.addArguments("--allow-insecure-localhost");
        options.addArguments("--disable-gpu");
        options.addArguments("--remote-debugging-port=9222");

        /*options.addArguments("disable-infobars");
        options.addArguments("-incognito");
        options.addArguments("--disable-extensions");*/
        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://open.spotify.com/");

        homePage = new HomePage(driver);
        //homePage.clickCookies();
        System.out.println(driver.getCurrentUrl());
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }
}
