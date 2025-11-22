package test;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

public class HomePage {
    private WebDriver driver;

    @FindBy(xpath = "//a[text()='Logout']")
    private WebElement logoutLink;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public LogoutPage logout() {
        logoutLink.click();
        return new LogoutPage(driver);
    }

    public boolean isLoaded() {
        return logoutLink.isDisplayed();
    }
}
