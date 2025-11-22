package NG.JK;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DispatchTarget extends Logistic_Login
{
	@Test
	public void SetDispatchTarget() throws EncryptedDocumentException, IOException, InterruptedException
	{
		
		LoginAndSelectPlant();
		Sliders sd = new Sliders(driver);
		sd.SideBarClick();
		sd.Master_Menu();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		sd.DispatchTarget_Master_Menu_Click();
		
		Master_Unique_Functionality muf = new Master_Unique_Functionality(driver);
		muf.Add_To_Master_Btn_click();
		
		WebElement monthnyear = driver.findElement(By.xpath("//input[@name='monthYear']"));
		monthnyear.sendKeys("July");
		
		
		
		
		
		
	}
	
}
