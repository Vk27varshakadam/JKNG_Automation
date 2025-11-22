package test;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

public class LoginPage {
    private WebDriver driver;

    @FindBy(name = "username")
    private WebElement usernameTxt;

    @FindBy(name = "password")
    private WebElement passwordTxt;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginBtn;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public HomePage login(String username, String password) {
        usernameTxt.sendKeys(username);
        passwordTxt.sendKeys(password);
        loginBtn.click();
        return new HomePage(driver);
    }
}

