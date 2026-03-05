package NG.JK;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import utility.ExcelConfig;

public class DispatchPlanner_Assignement extends Logistic_Login
{
	public String FilePath = "D:\\AutomationTesting2025\\JKNGAutomation\\ExcelData\\ExcelData.xlsx";
	public String ChildOrder1;
	
	  
	
	
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
	/*Thread.sleep(3000);
		
		List<WebElement> listorder = driver.findElements(By.xpath("//table[@class='table-hover text-left data-table']/tbody/tr/td[2]/span"));
		System.out.println(listorder);
		
		int cnt = listorder.size();
		System.out.println("Cnt "+cnt);
		
		
		for (WebElement opt : listorder)
		{
		    System.out.println(opt.getText());
		}
*/
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
	 ChildOrder1 = Splitorder1.getText();
	System.out.println("Child Order1 No "+ChildOrder1);
		
	ExcelConfig exf = new ExcelConfig();
	exf.LoadExcel(FilePath,"Order_Data");
	ExcelConfig.setCelldata(FilePath, 1, 3, ChildOrder1);
	System.out.println("Child Order Added in Excel Successfully");
	
	Thread.sleep(2000);
	
		dpo.Dpo_Split_Confirm_click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Thread.sleep(2000);
		
	/*	WebElement splitorderalertvalue = driver.findElement(By.xpath("(//div[@role='alert']/div)[2]"));
		String xyz = splitorderalertvalue.getText();
		System.out.println("Splitted Order Alert msg "+xyz);
		
	//	Wait<WebDriver> wt4 = new WebDriverWait(driver,Duration.ofSeconds(20));
		//wt4.until(ExpectedConditions.)*/
		
		dpo.Dpo_page_Refresh_icon_click();
		
	}
	
	@Test(priority=2,groups={"regression","system"})
	public void SingleOrderAssignement() throws IOException, InterruptedException
	{
		Thread.sleep(3000);
		DispatchPlanner_Page dpo = new DispatchPlanner_Page(driver);
		WebDriverWait wt = new WebDriverWait(driver,Duration.ofSeconds(30));
		wt.until(ExpectedConditions.elementToBeClickable(dpo.Filter));
		
		dpo.DPOFilterClick();
		
		dpo.SearchChildOrderNumber();
		
		dpo.DpoFilterApplyBtn();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(2000);
		
		dpo.Dpo_SO_ByDescendinggorder();
		dpo.OrderAction_Checkbox_Click();
		dpo.DPOOrderAssign_icon_click();
		dpo.DPO_AssignTransporterList_SearchTextbox_EnterTransporter();
		Thread.sleep(2000);
		dpo.Transporter_Checkbox_click();
		
		wt.until(ExpectedConditions.elementToBeClickable(dpo.DPO_AssignTransporterList_RemarkDropdown));
		//dpo.DPO_TransporterAssignment_Remark_Selection();
		dpo.DPO_TransporterAssignment_Remark_Selection();
		
		dpo.DPO_Transporter_AssignSubmit_Btn_click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		dpo.Fregith_FinalAssignBtn_click();
		
		System.out.println("Order has been assigned Successfully");
		
	}
	
	
}
