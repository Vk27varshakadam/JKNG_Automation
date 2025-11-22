package test;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
    private WebDriver driver;

    public LogoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isAtLoginPage() {
        return driver.getCurrentUrl().contains("/login");
    }
}

