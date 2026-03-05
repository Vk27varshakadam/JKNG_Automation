package NG.JK;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import utility.ExcelConfig;

public class Dispatch_Auction extends Logistic_Login
{
	public String FilePath = "D:\\AutomationTesting2025\\JKNGAutomation\\ExcelData\\ExcelData.xlsx";
	public String ChildOrder2;
	
	  
	
	@Test(priority=1,groups={"regression","system"})
	public void Split() throws EncryptedDocumentException, IOException, InterruptedException
	{
		
		LoginAndSelectPlant();
		Sliders sd = new Sliders(driver);
		sd.SideBarClick();
		sd.Vendor_Collaboration_Menu();
		sd.Dispatch_Planner_Menu();
		DispatchPlanner_Page dpo = new DispatchPlanner_Page(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
	Wait<WebDriver> wt =  new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(50))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(ElementClickInterceptedException.class);
		
		wt.until(ExpectedConditions.elementToBeClickable(dpo.Filter));
			
		Thread.sleep(1000);
				
				
		dpo.DPOFilterClick();
		dpo.SearchParentOrderNumber();
		dpo.DpoFilterApplyBtn();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(2000);
	
	  dpo.Dpo_SO_Byascendingorder();
	  
	  Thread.sleep(2000);
		
		
		WebElement DPO_Filtered_PO_Number_Fetch = driver.findElement(By.xpath("//td[@class='data-table-column '][1]/span"));
		String fetchParentOrd = DPO_Filtered_PO_Number_Fetch.getText();
		System.out.println("Parent od "+fetchParentOrd);
		
	AssertJUnit.assertEquals(dpo.ParentOrderno, fetchParentOrd);
	
	dpo.OrderAction_Checkbox_Click();
	dpo.Dpoparentordersplitbtnclick();
	
	
	Wait<WebDriver> wt3 = new WebDriverWait(driver,Duration.ofSeconds(30));
	wt3.until(ExpectedConditions.elementToBeClickable(dpo.NewQty_Textbox));

	dpo.SplitQty_Textbox();
	dpo.Dpo_Split_Plus_Icon_Click();
	
	
	WebElement Splitorder1 = driver.findElement(By.xpath("(//div[@class='side-splited-order-row MuiBox-root css-0']/div/p)[1]"));
	 ChildOrder2 = Splitorder1.getText();
	System.out.println("Child Order2 No "+ChildOrder2);
		
	ExcelConfig exf = new ExcelConfig();
	exf.LoadExcel(FilePath,"Order_Data");
	ExcelConfig.setCelldata(FilePath, 2, 3, ChildOrder2);
	System.out.println("Child Order Added in Excel Successfully");
	
	Thread.sleep(2000);
	
		dpo.Dpo_Split_Confirm_click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Thread.sleep(2000);
		
		dpo.Dpo_page_Refresh_icon_click();	
	}


	@Test(priority=2,groups={"regression","system"})
	public void SingleOrderSentToAuction() throws IOException, InterruptedException
	{
		Thread.sleep(3000);
		DispatchPlanner_Page dpo = new DispatchPlanner_Page(driver);
		WebDriverWait wt = new WebDriverWait(driver,Duration.ofSeconds(30));
		wt.until(ExpectedConditions.elementToBeClickable(dpo.Filter));
		
		dpo.DPOFilterClick();
		
		dpo.SearchChildOrderNumber_TosentAuction();
		
		dpo.DpoFilterApplyBtn();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(2000);
		
		dpo.Dpo_SO_ByDescendinggorder();
		dpo.OrderAction_Checkbox_Click();
		dpo.DPOOrderSentOrderTo_Auction_icon_click();
		dpo.DPO_AuctionTransporterList_SearchTextbox_EnterTransporter1();
		dpo.Transporter1_Auction_Checkbox_click();
		dpo.DPO_AuctionTransporterList_SearchTextbox_EnterTransporter2();
		dpo.Transporter2_Auction_Checkbox_click();
		dpo.SentToAuction_Btn_click();
		
		
	}
	
}
