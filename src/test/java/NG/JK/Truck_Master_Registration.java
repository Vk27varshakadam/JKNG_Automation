package NG.JK;

import org.testng.annotations.Test;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import utility.ExcelConfig;

public class Truck_Master_Registration  extends Logistic_Login
{

	public String FilePath = "D:\\AutomationTesting2025\\JKNGAutomation\\ExcelData\\ExcelData.xlsx";
	
	
	
	@Test(priority=1)
	public void New_Truck_Registration() throws EncryptedDocumentException, IOException, InterruptedException
	{
	LoginAndSelectPlant();
	Sliders sd = new Sliders(driver);
	sd.SideBarClick();
	sd.Master_Menu();
	sd.VehicleMaster_Menu_Click();

	Master_Unique_Functionality muf = new Master_Unique_Functionality(driver);
	muf.Add_To_Master_Btn_click();
			
	Thread.sleep(2000);
	
	Truck_Master_Page trm = new Truck_Master_Page(driver);
	trm.TruckRegistration_Form_TruckNo_Enter();
	
	trm.TruckRegisgtration_CheckAvailability_Btn_Click();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	trm.TruckRegistration_Rfid_Tag_Text_Box_Enter();
	trm.TruckReg_VehicleCapacity();
	trm.TruckReg_tw();
	trm.TruckReg_GW();
	trm.TruckRegistration_GPS_Check_Selection();
	trm.TruckRegistration_MovementType_Selection();
	trm.TruckRegistration_Transporter_Dropdown();
	trm.VehTypeSelect();
	trm.DriverLicenseEnter();
	trm.DriverNameEnter();
	trm.DriverContactNo();
	trm.DriverExpiryDate();
	trm.TruckReg_RC();
	trm.TruckReg_Manfactby();
	trm.EngineNoEnter();
	trm.TruckReg_ManMMYY();
	trm.ChassisNoEnter();
	trm.TruckReg_ModelNo();
	trm.OwnerShipType();
	//trm.Dedicationclick();
	trm.TruckReg_DocumentSection();
	trm.Permitno();
	trm.PermitType();
	trm.TruckReg_PUCEXPRY();
	trm.PVCIssueDate();
	trm.PVCEXPDate();
	
	trm.TruckReg_RoadTaxRenewdt();
	trm.TruckReg_FitnessRenew();
	trm.TruckReg_VehRegdt();
	trm.TruckReg_VehExpDate();
	
	trm.TruckReg_InsuranceSection();
	trm.InsuranceNo();
	trm.InsuranceCompany();
	trm.InsuranceExpirydate();
	
	
	
	//trm.PUCIssueDateEnter();
	trm.TruckSaveBtn();
	
	String NewTruck = trm.VehicleNo;
	
	ExcelConfig exf = new ExcelConfig();
	exf.LoadExcel(FilePath,"Order_Data");
	ExcelConfig.setCelldata(FilePath, 1, 6, NewTruck);
	System.out.println("Truck No Added in Excel Successfully");
	
	}
}
