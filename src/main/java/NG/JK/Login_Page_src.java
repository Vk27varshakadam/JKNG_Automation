package NG.JK;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.ExcelConfig;

public class Login_Page_src extends ExcelConfig
{
	ChromeDriver driver;
	public String FilePath = "D:\\AutomationTesting2025\\JKNGAutomation\\ExcelData\\ExcelData.xlsx";
	
	@FindBy(name="username")
	WebElement usernametxt;
	
	@FindBy(name="password")
	WebElement passwordtxt;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement loginbtn;
	
	 public Login_Page_src(ChromeDriver driver)
	 {
		 this.driver = driver; 
		 PageFactory.initElements(driver, this);
	 }
	
	public void Enter_Username() throws IOException
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		LoadExcel(FilePath,"Credentials");
		String username = ExcelConfig.getCelldata(1, 1);
		usernametxt.sendKeys(username);
		
	}
	
	
	public void Enter_Transporter_Username() throws IOException
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		LoadExcel(FilePath,"Credentials");
		String username = ExcelConfig.getCelldata(1, 3);
		usernametxt.sendKeys(username);
		
	}
 
	public void Enter_Password()
	{
		
		String password = ExcelConfig.getCelldata(1, 2);//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		passwordtxt.sendKeys(password);
		
	}
	
	
	public void Enter_Transporter_Password()
	{
		
		String password = ExcelConfig.getCelldata(1, 4);//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		passwordtxt.sendKeys(password);
		
	}
	
	public void Loginclick()
	{
		loginbtn.click();
		
	}
	
	
	
}
