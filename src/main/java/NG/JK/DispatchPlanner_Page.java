package NG.JK;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.ExcelConfig;

public class DispatchPlanner_Page extends ExcelConfig
{
	ChromeDriver driver;
	
	
	public String ParentOrderno;
	public String Split_Qty;
	public String ChildOrderno;
	public String Transportername ; //="PRADEE TRANSP1"
	public String FilePath = "D:\\AutomationTesting2025\\JKNGAutomation\\ExcelData\\ExcelData.xlsx";
	
	public DispatchPlanner_Page(ChromeDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//div[@class='icon-container'and@aria-label=\"Filter\"]")
	WebElement Filter;
	
	@FindBy(name="orderNo")
	WebElement OrderSearch;
	
	@FindBy(xpath="//button[text()='Apply Filters']")
	WebElement Apply_Filters;
	
	@FindBy(xpath="(//input[@type=\"checkbox\"])[2]")
	WebElement OrderAction_Checkbox;
	
	@FindBy(xpath="//div[@aria-label=\"Split\"]")
	WebElement DPOParentOrderSplit_icon;
	
	@FindBy(xpath="//div[@aria-label=\"Assign to Transporter\"]")
	WebElement DPOOrderAssign_icon;
	
	
	
	@FindBy(xpath="//input[@id='outlined-basic']")
	WebElement NewQty_Textbox;
	
	@FindBy(xpath="//div[@aria-label=\"Split Order\"]")
	WebElement DPO_Split_Plus_Btn;
	
	@FindBy(xpath="(//div[@class='side-form-footer MuiBox-root css-0']/button)[2]")
	WebElement Spli_Confirm_Btn;
	
	@FindBy(xpath="//div[@aria-label=\"Refresh\"]")
	WebElement Dpo_Refresh_icon;
	
	@FindBy(xpath="//div[span[text()='SO/STO No']]/span/div[@class='icon-container' and @aria-label='Sort Ascending']")
	WebElement Dpo_SOSTONO_Ascendingarrow;
	
	@FindBy(xpath="//div[span[text()='SO/STO No']]/span/div[@class='icon-container' and @aria-label='Sort Descending']")
	WebElement Dpo_SOSTONO_Descendingarrow;
	
	@FindBy(xpath="//div[@class='MuiFormControl-root css-ik94j6']/label[text()='Remark *']")
	WebElement DPO_AssignTransporterList_RemarkDropdown;
	
	@FindBy(xpath="//div[@id=\"Remark\"]")
	WebElement DPO_AssignTransporterList_RemarkDropdown2;
	
	@FindBy(xpath="//input[@placeholder=\"Search\"]")
	WebElement DPO_AssignTransporterList_SearchTextbox;
	
	
	@FindBy(xpath="//ul[@role=\"listbox\"]/li")
	List<WebElement> Remarklist;
	
	
	//@FindBy(xpath="//div[@class='MuiBox-root css-1rr4qq7']/p[@class='MuiTypography-root MuiTypography-body1 css-1t5h120' and text()='PRADEE TRANSP1']/ancestor::div[@class='MuiBox-root css-15xnogf']/span//input[@type='checkbox']")
	//WebElement DPO_AssignTransporter_Checkbox;
	
	@FindBy(xpath="//button[text()='Submit']")
	WebElement FreightDetails_Submit_btn;
	
	
	@FindBy(xpath="//button[text()='Assign']")
	WebElement DPO_Transporter_Assign_Submit_btn;
	
	
	
	public void DPOFilterClick() 
	{
		/*WebDriverWait w1 = new WebDriverWait(driver,Duration.ofSeconds(30));
		w1.until(ExpectedConditions.elementToBeClickable(Dpo_SOSTONO_Ascendingarrow));*/
		Actions a1 = new Actions(driver);
		a1.moveToElement(Filter).perform();
		
		a1.moveToElement(Filter).click().perform();

		/*WebDriverWait w2 = new WebDriverWait(driver,Duration.ofSeconds(30));
		w2.until(ExpectedConditions.visibilityOf(Filter));
		Filter.click();*/
	}
	
	public void SearchParentOrderNumber() throws IOException
	{
		OrderSearch.click();
		LoadExcel(FilePath,"Order_Data");
		String ParentOrderno = ExcelConfig.getCelldata(1, 1);
		this.ParentOrderno = ParentOrderno;
		OrderSearch.sendKeys(ParentOrderno);
		
	}
	
	public void DpoFilterApplyBtn()
	{
		Apply_Filters.click();
		
	}
	
	public void OrderAction_Checkbox_Click()
	{
		
		OrderAction_Checkbox.click();
	}
	
	public void Dpoparentordersplitbtnclick()
	
	{
		DPOParentOrderSplit_icon.click();
		
	}
	
	public void SplitQty_Textbox() throws IOException
	{
		LoadExcel(FilePath,"Order_Data");
		String Split_Qty = ExcelConfig.getCelldata(1,2);
		this.Split_Qty =Split_Qty;
		NewQty_Textbox.sendKeys(Split_Qty);	
	}
	
	public void Dpo_Split_Plus_Icon_Click()
	{
		
		DPO_Split_Plus_Btn.click();
	}
	
	public void Dpo_Split_Confirm_click()
	{
		Spli_Confirm_Btn.click();
		
	}
	
	public void Dpo_page_Refresh_icon_click() throws InterruptedException
	{
		Thread.sleep(2000);
		
		Dpo_Refresh_icon.click();
	}	
	
	public void Dpo_SO_Byascendingorder()
	{
		Dpo_SOSTONO_Ascendingarrow.click();
		
	}
	
	public void Dpo_SO_ByDescendinggorder()
	{
		Dpo_SOSTONO_Descendingarrow.click();
		
		
	}
	
	public void SearchChildOrderNumber() throws IOException
	{
		OrderSearch.click();
		OrderSearch.clear();
		LoadExcel(FilePath,"Order_Data");
		String ChildOrderno = ExcelConfig.getCelldata(1,3);
		this.ChildOrderno = ChildOrderno;
		OrderSearch.sendKeys(ChildOrderno);		
	}
	
	
	
	public void DPOOrderAssign_icon_click()
	{	
		DPOOrderAssign_icon.click();
		
	}

	public void DPO_AssignTransporterList_SearchTextbox_EnterTransporter()
	{
		
		DPO_AssignTransporterList_SearchTextbox.click();
		DPO_AssignTransporterList_SearchTextbox.sendKeys("Vktrans");
		
		
	}
	
	public void Transporter_Checkbox_click() throws IOException, InterruptedException
	{
		Thread.sleep(2000);
		LoadExcel(FilePath,"Order_Data");
		String Transportername = ExcelConfig.getCelldata(1,4);
		this.Transportername = Transportername;
		WebElement checkboxoftransporter= driver.findElement(By.xpath("//div[@class='MuiBox-root css-1rr4qq7']/p[@class='MuiTypography-root MuiTypography-body1 css-1t5h120' and text()='"+Transportername+"']/ancestor::div[@class='MuiBox-root css-15xnogf']/span//input[@type='checkbox']"));
		//WebElement checkboxoftransporter= driver.findElement(By.xpath("//div[@class='MuiBox-root css-1rr4qq7']/p[@class='MuiTypography-root MuiTypography-body1 css-1t5h120' and text()='Vktrans']/ancestor::div[@class='MuiBox-root css-15xnogf']/span//input[@type='checkbox']"));
		
		checkboxoftransporter.click();
		
	}
	
	
	public void DPO_Transporter_AssignSubmit_Btn_click()
	{
		DPO_Transporter_Assign_Submit_btn.click();
	}
	
	public void DPO_TransporterAssignment_Remark_Selection() throws IOException
	{
		DPO_AssignTransporterList_RemarkDropdown2.click();
		//DPO_AssignTransporterList_RemarkDropdown2.sendKeys("Dedicated");
		//DPO_AssignTransporterList_RemarkDropdown2.sendKeys(Keys.ENTER);
		
		List<WebElement> remarklist = driver.findElements(By.xpath("//ul[@role=\"listbox\"]/li"));
		int cnt = remarklist.size();
		LoadExcel(FilePath,"Order_Data");
		String providedremark = ExcelConfig.getCelldata(1,5);
		
		
		for(int i=0;i<cnt;i++)
		{
			WebElement s2 = remarklist.get(i);
			String s1 = s2.getText();
			System.out.println(s1);
			if(s1.equalsIgnoreCase(providedremark))
			{
				System.out.println("Found Remark "+s1);
				s2.click();
			}
			
			
		}
		
	}
	
	
	public void Fregith_FinalAssignBtn_click()
	{
		
		FreightDetails_Submit_btn.click();
		
	}
	
	
	
	
	
}


