package NG.JK;

import org.testng.annotations.Test;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Transporter_DirectOrder extends Transporter_Login
{
	@Test(priority=1,groups={"regression","system"})
	public void CommitOfSingleOrder() throws EncryptedDocumentException, IOException, InterruptedException
	{
		
		LoginAndSelectPlant();
		Sliders sd = new Sliders(driver);
		sd.SideBarClick();
		
		Transporter_DirectOrder_Page tdr = new Transporter_DirectOrder_Page(driver);
		//WebDriverWait wt = new WebDriverWait(driver,Duration.ofSeconds(30));
		//wt.until(ExpectedConditions.elementToBeClickable(tdr.Transporter_ToBeDispatched_LinkPage));
		
		System.out.println("Direct page is clickable now");
		
		tdr.Transporter_OrderSearch_Textbox();
		Thread.sleep(1000);
		tdr.Transporter_ChildOrder_ActionCheckbox_click();
		tdr.Transporter_Commit_SingleChildOrder();
		tdr.Transporter_Confirm_Commit_Btn();
		}
	
	@Test(priority=2,groups={"regression","system"})
	public void TruckAllocation() throws IOException, InterruptedException
	{
		Transporter_DirectOrder_Page tdr = new Transporter_DirectOrder_Page(driver);
			
		tdr.Transporter_OrderSearch_Textbox();
		Thread.sleep(1000);
		tdr.Transporter_ChildOrder_ActionCheckbox_click();
		tdr.Transporter_Vehicle_Allocation_Icon_Click();
		tdr.Transporter_Assign_Vehicle_Popup_VehicleNOEnter();
		tdr.Transporter_Assign_Vehicle_Popup_DriverLicenseNoEnter();
		tdr.Action_On_Total_Order_Available_In_Auction();
		tdr.Transporter_Assign_Vehicle_Btn_click();
	
		
	}
	
}
