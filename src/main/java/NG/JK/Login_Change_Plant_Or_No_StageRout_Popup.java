package NG.JK;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login_Change_Plant_Or_No_StageRout_Popup
{
	ChromeDriver driver;
	
	WebDriverWait w1;	
	
	@FindBy(xpath="(//div[@aria-haspopup='listbox'])[1]")
	WebElement PlantListdropdown;
	
	@FindBy(xpath="//button[@class='Toastify__close-button Toastify__close-button--light']")
	WebElement NoStageRouteAlertMsg;

	@FindBy(xpath="(//input[@class='MuiSelect-nativeInput css-147e5lo'])[1]")
	WebElement PlantCodes;
	
	@FindBy(xpath="//ul[@class='MuiList-root MuiList-padding MuiMenu-list css-ubifyk']/li")
	List<WebElement> PlantList;
	
	@FindBy(xpath="/html/body/div[2]/div[3]/div/div/button[2]")
	WebElement PlantUpdatebtn;
	
	@FindBy(xpath="//button[@class=\"Toastify__close-button Toastify__close-button--light\"]")
	WebElement PltupdateSuccess;
	
	@FindBy(xpath="//div[@aria-label=\"Refresh\"]")
	WebElement Refresh_btn;
	
	
	public void NoStageRouteAlertMsgclick()
	{
		w1 = new WebDriverWait(driver,Duration.ofSeconds(30));
		w1.until(ExpectedConditions.visibilityOf(NoStageRouteAlertMsg));
		NoStageRouteAlertMsg.click();
	}
	
	public void Plantlistdropdown()
	{
		w1 = new WebDriverWait(driver,Duration.ofSeconds(30));
		w1.until(ExpectedConditions.visibilityOf(PlantListdropdown));
		PlantListdropdown.click();
	}
	
	public void changeplant() throws InterruptedException
	{	
		String plants =PlantCodes.getAttribute("value");
		System.out.println("plants check "+plants);
	
		String Selectplant ="1001";
		for (WebElement option : PlantList)
		{
            if (option.getAttribute("data-value").equals(Selectplant))
            {
                option.click();
                break;
            }
        }
		System.out.println("Hello");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(100);
		// Scroll to the update button
		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", PlantUpdatebtn);
		Actions a1 = new Actions(driver);
		a1.moveToElement(PlantUpdatebtn).perform();
		
		// Wait for the button to be clickable //
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions.elementToBeClickable(PlantUpdatebtn));
		
		// Click the update button
		PlantUpdatebtn.click();
		System.out.println("Clicked Plant Update button");
		
		WebDriverWait w1 = new WebDriverWait(driver,Duration.ofSeconds(10));
	
		w1.until(ExpectedConditions.elementToBeClickable(PltupdateSuccess));
		System.out.println("hELLO 3");
		PltupdateSuccess.click();
		System.out.println("hELLO 4");
	}
	
	
	
public Login_Change_Plant_Or_No_StageRout_Popup(ChromeDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
	
}
}