package NG.JK;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.ExcelConfig;

public class Transporter_DirectOrder_Page extends ExcelConfig
{

	ChromeDriver driver;
	public String FilePath = "D:\\AutomationTesting2025\\JKNGAutomation\\ExcelData\\ExcelData.xlsx";
	public  String ChildOrderNo;
	
	@FindBy(xpath="//div[@aria-label=\"Search\"]")
	WebElement SearchOrderIcon;
	
	
	@FindBy(xpath="//button[text()='Direct Order']")
	WebElement Transporter_DirectOrder_LinkPage;
	
	@FindBy(xpath="//input[@class=\"search-input\"]")
	WebElement Transporter_SearchOrder_Textbox;
	
	@FindBy(xpath="//button[text()='To Be Dispatched']")
	WebElement Transporter_ToBeDispatched_LinkPage;
	
	@FindBy(xpath="//span[text()='VKAUCT0341_000010-18']/ancestor::tr/td/div/span//input[@type=\"checkbox\"]")
	WebElement Transporter_Order_Action_Checkbox;
	
	@FindBy(xpath="//div[@aria-label=\"Commit\"]")
	WebElement Transporter_Order_Commit_ActionIcon;
	
	@FindBy(xpath="//button[text()='Commit']")
	WebElement Transporter_Confirm_Commit_Click;
	
	@FindBy(xpath="//div[@aria-label=\"Assign vehicle\"]")
	WebElement Transporter_Vehicle_Allocation_Icon_Click;
	
	@FindBy(xpath="//input[@name=\"trucknumber\"]")
	WebElement Assign_Vehicle_Popup_Vehicle_No_Input_Box;
	
	@FindBy(xpath="//input[@name=\"drivername\"]")
	WebElement Assign_Vehicle_Popup_Vehicle_Driver_LicenseNo_Input_Box;
	
	@FindBy(xpath="//button[text()='Assign Vehicle']")
	WebElement Assign_Vehicle_Popup_AssignVehicle_Button;
	
	
	public Transporter_DirectOrder_Page(ChromeDriver driver)
	{
		this.driver =driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	public void Transporter_OrderSearch_Textbox() throws IOException
	{
	
		
		SearchOrderIcon.click();
		LoadExcel(FilePath,"Order_Data");
		String ChildOrderNo = ExcelConfig.getCelldata(1, 3);
		this.ChildOrderNo=ChildOrderNo;
		
		WebDriverWait wt = new WebDriverWait(driver,Duration.ofSeconds(30));
		wt.until(ExpectedConditions.elementToBeClickable(Transporter_SearchOrder_Textbox));
		Transporter_SearchOrder_Textbox.clear();
		Transporter_SearchOrder_Textbox.click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Transporter_SearchOrder_Textbox.sendKeys(ChildOrderNo);
		Transporter_SearchOrder_Textbox.sendKeys(Keys.ENTER);
		
	}
	
	public void Transporter_ChildOrder_ActionCheckbox_click()
	{
		
		WebElement transordercheckbox = driver.findElement(By.xpath("//span[text()='"+ChildOrderNo+"']/ancestor::tr/td/div/span//input[@type=\"checkbox\"]"));
		transordercheckbox.click();
		
	}
	
	public void Transporter_Commit_SingleChildOrder()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Transporter_Order_Commit_ActionIcon.click();
		
	}
	
	public void Transporter_Confirm_Commit_Btn()
	{
		Transporter_Confirm_Commit_Click.click();		
	}
	
	public void Transporter_Vehicle_Allocation_Icon_Click()
	{
		Transporter_Vehicle_Allocation_Icon_Click.click();
		
	}
	
	public void Transporter_Assign_Vehicle_Popup_VehicleNOEnter() throws IOException
	{
		
		LoadExcel(FilePath,"Order_Data");
		String Vehicle_No = ExcelConfig.getCelldata(1, 6);
		
		Assign_Vehicle_Popup_Vehicle_No_Input_Box.click();
		Assign_Vehicle_Popup_Vehicle_No_Input_Box.sendKeys(Vehicle_No);
		Assign_Vehicle_Popup_Vehicle_No_Input_Box.sendKeys(Keys.DOWN);
		Assign_Vehicle_Popup_Vehicle_No_Input_Box.sendKeys(Keys.ENTER);
		
	}
	
	public void Transporter_Assign_Vehicle_Popup_DriverLicenseNoEnter() throws IOException
	{
		LoadExcel(FilePath,"Order_Data");
		String Driver_No = ExcelConfig.getCelldata(1, 7);
		Assign_Vehicle_Popup_Vehicle_Driver_LicenseNo_Input_Box.click();
		Assign_Vehicle_Popup_Vehicle_Driver_LicenseNo_Input_Box.sendKeys(Driver_No);
		Assign_Vehicle_Popup_Vehicle_Driver_LicenseNo_Input_Box.sendKeys(Keys.DOWN);
		Assign_Vehicle_Popup_Vehicle_Driver_LicenseNo_Input_Box.sendKeys(Keys.ENTER);
		
	}
	
	public void Transporter_Assign_Vehicle_Btn_click()
	{
		
		Assign_Vehicle_Popup_AssignVehicle_Button.click();
		
	}
}
