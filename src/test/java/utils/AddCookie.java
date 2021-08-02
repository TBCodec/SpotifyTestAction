package utils;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddCookie {

    private WebDriver driver;

    public AddCookie(WebDriver driver) {
        this.driver = driver;
    }

    public void addCookie(){
        driver.manage().addCookie(new Cookie("foo", "bar"));
        Cookie cookie1 = driver.manage().getCookieNamed("foo");
        System.out.println(cookie1);

    }

}
