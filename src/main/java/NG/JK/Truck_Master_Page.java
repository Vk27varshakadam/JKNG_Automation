package NG.JK;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
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

public class Truck_Master_Page extends ExcelConfig
{

	ChromeDriver driver;
	public String FilePath = "D:\\AutomationTesting2025\\JKNGAutomation\\ExcelData\\ExcelData.xlsx";
	String VehicleNo;
	
	public Truck_Master_Page(ChromeDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(xpath="//input[@name='vehicleNumber']")
	WebElement TruckNo;
	
	@FindBy(xpath="//label[span[text()='Vehicle Number']]/ancestor::div[@class=\"MuiFormControl-root MuiFormControl-fullWidth MuiTextField-root css-1vbfw84\"]/div/input[@type=\"text\"]")
	WebElement Trucktext;
	
	@FindBy(xpath="//input[@id=\":r3n:\"and @type=\"text\"]")
	WebElement TruckText2;
	
	@FindBy(xpath="//span[text()='Check Availability']")
	WebElement CheckAvailability_Btn;
	
	@FindBy(xpath="//input[@name=\"rfidTagId\"]")
	WebElement Rfid_Tag_Text_Box;
	
	@FindBy(id="vehicleCarryingCapacity")
	WebElement vehicleCarryingCapacity_textbox;
	
	@FindBy(xpath="//div[@id=\"gpsDeviceFlag\"]")
	WebElement GPSAvailability;
	
	@FindBy(xpath="//div[@id=\"movementType\"]")
	WebElement MovementType_List_Dropdown;
	
	@FindBy(xpath="//span[text()='Transporter Name ']/ancestor::div[@class=\"MuiFormControl-root MuiFormControl-marginNormal MuiFormControl-fullWidth css-jkid3g\"]/div/div[@aria-haspopup=\"listbox\"]")
	WebElement Transporter_Name_Dropdown;
	
	@FindBy(xpath="//div[@aria-labelledby=\"vehicleType vehicleType\"]")
	WebElement VehType;
	
	@FindBy(xpath="//input[@name=\"driverLicense\"]")
	WebElement DriveLicense;
	
	@FindBy(xpath="//input[@name=\"driverName\"]")
	WebElement DriverName;
	
	@FindBy(xpath="//input[@name=\"driverContactNumber\"]")
	WebElement DriverContactNo;
	
	@FindBy(xpath="//input[@name=\"driverLicenceExpiryDate\"]")
	WebElement DriverExpDate;
	
	@FindBy(xpath="//div[@aria-labelledby=\"ownershipType ownershipType\"]")
	WebElement OwnerShipType;
	
	@FindBy(xpath="//button[text()='Save']")
	WebElement SaveBtn;
	
	@FindBy(xpath="//input[@name=\"engineNumber\"]")
	WebElement EngNo;
	
	@FindBy(xpath="//input[@name=\"chassisNumber\"]")
	WebElement chassinNo;
	
	@FindBy(xpath="(//label[text()='Dedication:']/ancestor::div[@class='form-group'] //span[.//input[contains(@class,'PrivateSwitchBase-input') and @type='checkbox']])[2]")
	WebElement Dedication;
	
	@FindBy(xpath="//input[@name=\"permitNumber\"]")
	WebElement PermitNo;
	
	@FindBy(xpath="//input[@name=\"driverName\"]")
	WebElement PermitType;
	
	@FindBy(xpath="//button[text()='Document ']")
	WebElement DoucmentLink;
	
	@FindBy(xpath="//input[@name=\"pucIssueDate\"]")
	WebElement PUCIssueDate;
	
	@FindBy(xpath="//input[@id='vehicleCarryingCapacity']")
	WebElement Vehcapacity;
	
	@FindBy(xpath="//input[@name=\"tarewt\"]")
	WebElement tw;
	
	@FindBy(xpath="//input[@name=\"grosswt\"]")
	WebElement GW;
	
	@FindBy(xpath="//input[@name=\"rcNumber\"]")
	WebElement rcno;
	
	@FindBy(xpath="//input[@name=\"manufacturedBy\"]")
	WebElement Manfactby;
	
	@FindBy(xpath="//input[@name=\"manufactureMonthYear\"]")
	WebElement ManMMYY;
	
	@FindBy(xpath="//input[@placeholder=\"Enter Model No\"]")
	WebElement ModelNo;
	
	@FindBy(xpath="//input[@name=\"pucExpiryDate\"]")
	WebElement PUCEXPRY;
	
	@FindBy(xpath="//input[@name=\"roadTaxRenewDate\"]")
	WebElement RoadTaxRenewdt;
	
	@FindBy(xpath="//input[@name=\"fitnessCertRenewalDate\"]")
	WebElement FitnessRenew;
	
	@FindBy(xpath="//input[@name=\"vehicleRegistrationDate\"]")
	WebElement VehRegdt;
	
	@FindBy(xpath="//input[@name=\"vehicleExpiryDate\"]")
	WebElement VehExpDate;
	
	@FindBy(xpath="//button[text()='Insurance ']")
	WebElement InsuranceLink;
	
	@FindBy(xpath="//input[@name=\"insuranceNumber\"]")
	WebElement InsuranceNo;
	
	@FindBy(xpath="//input[@name=\"insuranceCompany\"]")
	WebElement InsuranceCo;
	
	@FindBy(xpath="//input[@name=\"insuranceExpiryDate\"]")
	WebElement InsExpdt;
	
	
	public void TruckRegistration_Form_TruckNo_Enter() throws IOException
	{
		LoadExcel(FilePath,"Truck_Registration");
		String ExtVehicleNo =	ExcelConfig.getCelldata(1, 1);
		WebDriverWait wt = new WebDriverWait(driver,Duration.ofSeconds(30));
		wt.until(ExpectedConditions.elementToBeClickable(TruckNo));
		
		Date d1 = new Date();
		String todaydttime = new SimpleDateFormat("ddMMyyyy--HHmmss").format(d1);
		String[] dttime = todaydttime.split("--");
		String timeonly = dttime[1];
		String toddate = dttime[0];
		String dtonly = toddate.substring(0, 2);
		//String monthonly = toddate.substring(2, 4);
		
		String VehicleNo =ExtVehicleNo.concat(dtonly).concat(timeonly);
		
		
		TruckNo.click();
		TruckNo.clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		TruckNo.sendKeys(VehicleNo);
		this.VehicleNo =VehicleNo;
	}
	
	public void TruckRegisgtration_CheckAvailability_Btn_Click()
	{	
		WebDriverWait wt = new WebDriverWait(driver,Duration.ofSeconds(30));
				wt.until(ExpectedConditions.elementToBeClickable(CheckAvailability_Btn));
		
		CheckAvailability_Btn.click();
	}
	
	public void TruckRegistration_Rfid_Tag_Text_Box_Enter() throws IOException, InterruptedException
	{

		LoadExcel(FilePath,"Truck_Registration");
		String RFID_Tagexcel =	ExcelConfig.getCelldata(1, 2);
		
		WebDriverWait wt = new WebDriverWait(driver,Duration.ofSeconds(30));
		wt.until(ExpectedConditions.elementToBeClickable(Rfid_Tag_Text_Box));
		
		String RFID_Tag = "RFID"+VehicleNo;
		Thread.sleep(1000);
		Rfid_Tag_Text_Box.click();
		Rfid_Tag_Text_Box.sendKeys(RFID_Tag);
		
	}
	
	/*public void TruckRegistraiton_vehicleCarryingCapacity_Enter() throws IOException
	{
		LoadExcel(FilePath,"Truck_Registration");
		String RFID_Tag =	ExcelConfig.getCelldata(1, 3);
		vehicleCarryingCapacity_textbox.sendKeys();		
	}*/
	
	public void TruckRegistration_GPS_Check_Selection() throws IOException
	{
		LoadExcel(FilePath,"Truck_Registration");
		String GPSYESORNO =	ExcelConfig.getCelldata(1, 3);
		GPSAvailability.click();
		WebElement GPSValue = driver.findElement(By.xpath("//ul[@class=\"MuiList-root MuiList-padding MuiMenu-list css-ubifyk\"]/li[@data-value=\'"+GPSYESORNO+"']"));
		GPSValue.click();
	}
	
	public void TruckRegistration_MovementType_Selection()
	{
		String Movement_Type =	ExcelConfig.getCelldata(1, 4);
		MovementType_List_Dropdown.click();
		WebElement MovementTypeSelection = driver.findElement(By.xpath("//ul[@aria-labelledby=\"movementType\"]/li[@data-value=\'"+Movement_Type+"']"));
		MovementTypeSelection.click();	
	}
	
	public void TruckRegistration_Transporter_Dropdown()
	{
		String TransporterName =	ExcelConfig.getCelldata(1, 5);
		Transporter_Name_Dropdown.click();
		List<WebElement> TransporterNameList = driver.findElements(By.xpath("//div[@class='MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation8 MuiPopover-paper MuiMenu-paper MuiMenu-paper css-d1xm6m']/ul[@role=\"listbox\"]/li"));
		//String Transname = TransporterNameList.toString();
		
		for(WebElement trans : TransporterNameList)
		{	
			if(trans.getText().equalsIgnoreCase(TransporterName))
			{		
				trans.click();
				return;	
			}		
		}
	}
	
	public void VehTypeSelect() throws IOException
	{
		
		VehType.click();
		
		List<WebElement> VehTypeList = driver.findElements(By.xpath("//ul[@aria-labelledby=\"vehicleType\"]/li"));
		
		LoadExcel(FilePath,"Truck_Registration");
		String VehicleType =	ExcelConfig.getCelldata(1, 6);
		
		for(WebElement vehtype : VehTypeList)
		{
			if(vehtype.getText().equalsIgnoreCase(VehicleType))
			{	
				vehtype.click();
			}
		}
	}
	
	public void DriverLicenseEnter() throws IOException
	{
		Actions a1 = new Actions(driver);
		a1.doubleClick(DriveLicense).perform();
		

		LoadExcel(FilePath,"Truck_Registration");
		String DriverLicenseNoData =	ExcelConfig.getCelldata(1, 7);
		DriveLicense.sendKeys(DriverLicenseNoData);
		DriveLicense.sendKeys(Keys.ENTER);
		DriveLicense.sendKeys(Keys.DOWN);
		DriveLicense.sendKeys(Keys.ENTER);
		
	}
	
	public void DriverNameEnter() throws IOException
	{
		LoadExcel(FilePath,"Truck_Registration");
		String DriverNameData =	ExcelConfig.getCelldata(1, 8);
		DriverName.sendKeys(DriverNameData);
	}
	
	public void DriverContactNo() throws IOException
	{
		LoadExcel(FilePath,"Truck_Registration");
		String DriverConctactNoData =	ExcelConfig.getCelldata(1, 9);
		DriverContactNo.click();
		DriverContactNo.clear();
		DriverContactNo.sendKeys(Keys.BACK_SPACE);
		DriverContactNo.sendKeys(DriverConctactNoData);
		
	}
	
	public void DriverExpiryDate() throws IOException
	{

		LoadExcel(FilePath,"Truck_Registration");
		String DriverExpiryDateData =	ExcelConfig.getCelldata(1, 10);
		DriverExpDate.click();
		DriverExpDate.sendKeys(DriverExpiryDateData);
	}
	
	public void OwnerShipType() throws IOException, InterruptedException
	{
		LoadExcel(FilePath,"Truck_Registration");
		String Owndership =	ExcelConfig.getCelldata(1, 11);
		OwnerShipType.click();
		Thread.sleep(3000);
		try {
			List<WebElement> OwnerShiptypelist = driver.findElements(By.xpath("//ul[@aria-labelledby=\"ownershipType\"]/li"));
			for (WebElement owner : OwnerShiptypelist) {
				try {
					System.out.println("List of ownershiptype started " + owner.getText());

					if (owner.getText().equalsIgnoreCase(Owndership)) {
						owner.click();
						Thread.sleep(3000);
					}
				}catch (Exception e) {
					e.printStackTrace();
				}
			
			} 
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void EngineNoEnter() throws IOException
	{
		LoadExcel(FilePath,"Truck_Registration");
		String EngineNumber =	ExcelConfig.getCelldata(1, 12);
		EngNo.click();
		EngNo.sendKeys(EngineNumber);
		}
	
	public void ChassisNoEnter() throws IOException
	{
		LoadExcel(FilePath,"Truck_Registration");
		String ChassisNumber =	ExcelConfig.getCelldata(1, 13);
		chassinNo.click();
		
		chassinNo.sendKeys(ChassisNumber);
		
	}
	
	
	
	
	public void Permitno()
	{
		PermitNo.click();
		PermitNo.sendKeys("Permit0001");
	}
	
	
	public void PermitType()
	{
		PermitType.click();
		PermitType.sendKeys("INDIAN");
		
	}
	
	public void Dedicationclick() throws InterruptedException
	{
		Thread.sleep(1000);
		Dedication.click();

		Thread.sleep(1000);
	}
	
	public void TruckReg_DocumentSection()
	{
		DoucmentLink.click();
		
	}
	
	/*public void PUCIssueDateEnter() throws IOException
	{
		LoadExcel(FilePath,"Truck_Registration");
		String PUCIssuDt =	ExcelConfig.getCelldata(1, 14);
		PUCIssueDate.click();
		
		
		PUCIssueDate.sendKeys(PUCIssuDt);
		
	}
	*/
	public void TruckReg_VehicleCapacity() throws IOException
	{

		LoadExcel(FilePath,"Truck_Registration");
		String Vehcc =	ExcelConfig.getCelldata(1, 14);
		Vehcapacity.sendKeys(Vehcc);
		
	}
	
	public void TruckReg_tw() throws IOException
	{

		LoadExcel(FilePath,"Truck_Registration");
		String TW =	ExcelConfig.getCelldata(1, 15);
		tw.sendKeys(TW);
		
	}
	
	public void TruckReg_GW() throws IOException
	{
		LoadExcel(FilePath,"Truck_Registration");
		String GROSSWT =	ExcelConfig.getCelldata(1, 16);
		
		GW.sendKeys(GROSSWT);
		
	}
	
	public void TruckReg_RC() throws IOException
	{

		LoadExcel(FilePath,"Truck_Registration");
		String RCNmber =	ExcelConfig.getCelldata(1, 17);
		rcno.sendKeys(RCNmber);
	}
	
	public void TruckReg_Manfactby() throws IOException
	{

		LoadExcel(FilePath,"Truck_Registration");
		String ManufactureBy =	ExcelConfig.getCelldata(1, 18);
		Manfactby.sendKeys(ManufactureBy);
	}
	
	public void TruckReg_ManMMYY() throws IOException, InterruptedException
	{
		LoadExcel(FilePath,"Truck_Registration");
		String Manufacturemm =	ExcelConfig.getCelldata(1, 19);
		String Manufactureyy =	ExcelConfig.getCelldata(1, 20);
		Thread.sleep(1000);
		ManMMYY.sendKeys(Manufacturemm+Keys.TAB+Manufactureyy);
		Thread.sleep(1000);
	}
	
	public void TruckReg_ModelNo() throws IOException
	{
		LoadExcel(FilePath,"Truck_Registration");
		String ModelNumber =	ExcelConfig.getCelldata(1, 21);
		ModelNo.sendKeys(ModelNumber);
	}
	
	public void TruckReg_PUCEXPRY() throws IOException
	{

		LoadExcel(FilePath,"Truck_Registration");
		String PUCEXPIRYDATE =	ExcelConfig.getCelldata(1, 22);	
		PUCEXPRY.sendKeys(PUCEXPIRYDATE);	
	}
	
	public void TruckReg_RoadTaxRenewdt() throws IOException
	{

		LoadExcel(FilePath,"Truck_Registration");
		String RoadTaxRenew =	ExcelConfig.getCelldata(1, 23);	
		RoadTaxRenewdt.sendKeys(RoadTaxRenew);
	}
	
	public void TruckReg_FitnessRenew() throws IOException
	{

		LoadExcel(FilePath,"Truck_Registration");
		String FitnessRenewdt =	ExcelConfig.getCelldata(1, 24);
		FitnessRenew.sendKeys(FitnessRenewdt);
	}
	
	public void TruckReg_VehRegdt() throws IOException
	{
		LoadExcel(FilePath,"Truck_Registration");
		String VehRegistrationdt =	ExcelConfig.getCelldata(1, 25);
		VehRegdt.sendKeys(VehRegistrationdt);
	}
	
	public void TruckReg_VehExpDate() throws IOException
	{

		LoadExcel(FilePath,"Truck_Registration");
		String VehExpirydt =	ExcelConfig.getCelldata(1, 26);
		VehExpDate.sendKeys(VehExpirydt);
	}
	
	public void TruckReg_InsuranceSection()
	{
		
		InsuranceLink.click();
		
	}
	
	public void InsuranceNo() throws IOException
	{

		LoadExcel(FilePath,"Truck_Registration");
		String InsuranceNumber =	ExcelConfig.getCelldata(1, 27);
		InsuranceNo.sendKeys(InsuranceNumber);
	}
	
	public void InsuranceCompany() throws IOException
	{
		LoadExcel(FilePath,"Truck_Registration");
		String InsCompany =	ExcelConfig.getCelldata(1, 28);
		InsuranceCo.sendKeys(InsCompany);
	}
	
	public void InsuranceExpirydate() throws IOException
	{

		LoadExcel(FilePath,"Truck_Registration");
		String InsExpDate =	ExcelConfig.getCelldata(1, 29);
		InsExpdt.sendKeys(InsExpDate);
	}
	
	public void TruckSaveBtn()
	{
		SaveBtn.click();
		
	}
	
	
	
}
