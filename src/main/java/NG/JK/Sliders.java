package NG.JK;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Sliders 
{
	ChromeDriver driver;
	
	@FindBy(xpath="//button[@class='sidenavbar-toggle-btn']")
	WebElement SideBar;
	
	
	@FindBy(xpath="//span[text()='Vendor Collaboration']")
	WebElement VendorCollaborationMenu;
	
	@FindBy(xpath="//span[text()='Dispatch Planner']")
	WebElement DispatchPlannerMenu;
	
	@FindBy(xpath="//span[text()=\"Master\"]")
	WebElement MasterMenu;
	
	@FindBy(xpath="//span[text()=\"Dispatch Target\"]")
	WebElement DispatchTargetMenu;
	
	@FindBy(xpath="//span[text()='Vehicle']")
	WebElement VehicleMaster_Menu;
	
	
	public Sliders(ChromeDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void SideBarClick()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		SideBar.click();
	}
	
	public void Vendor_Collaboration_Menu()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		VendorCollaborationMenu.click();
	}
	
	public void Dispatch_Planner_Menu()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		DispatchPlannerMenu.click();
	}
	
	public void Master_Menu()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		MasterMenu.click();
	}
	
	public void VehicleMaster_Menu_Click()
	{	
		VehicleMaster_Menu.click();
	}
	
	public void DispatchTarget_Master_Menu_Click()
	{
		DispatchTargetMenu.click();
	}
	
}