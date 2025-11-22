package NG.JK;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Master_Unique_Functionality
{
	ChromeDriver driver;
	
	public  Master_Unique_Functionality(ChromeDriver driver)
	{	
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//button[text()='Add To Master +']")
	WebElement AddToMaster_Btn;
	
	
	public void Add_To_Master_Btn_click()
	{
		WebDriverWait wt = new WebDriverWait(driver,Duration.ofSeconds(30));
		wt.until(ExpectedConditions.elementToBeClickable(AddToMaster_Btn));
		
		AddToMaster_Btn.click();
	}	
}
