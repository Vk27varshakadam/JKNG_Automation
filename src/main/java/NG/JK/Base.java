package NG.JK;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class Base 
{
	//Ganeshay Namaha://
	
	public static ChromeDriver driver;
	
	@BeforeClass
	
    public void Launch()
	{
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("http://inplant.autoplant.in/");
    }

 @AfterClass
 public void LogoutandQuit()
 {
	 WebElement UserProfile = driver.findElement(By.xpath("//span[text()='User Profile']"));
	 UserProfile.click();
	 
	 WebElement logout = driver.findElement(By.xpath("//span[text()='Logout']"));
	 logout.click();
	 
	// driver.quit();
	 
 }
}
	
	
	

