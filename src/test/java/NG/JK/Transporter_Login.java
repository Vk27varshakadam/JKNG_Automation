package NG.JK;

import java.io.IOException;

import java.time.Duration;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;


public class Transporter_Login extends Base
{


	public void LoginAndSelectPlant() throws EncryptedDocumentException, IOException, InterruptedException
	{	
		Login_Page_src tr = new Login_Page_src(driver);
		tr.Enter_Transporter_Username();
		tr.Enter_Transporter_Password();
		tr.Loginclick();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Assert.assertTrue(driver.getTitle().contains("Autotat Inplant"));
		
	/*	Login_Change_Plant_Or_No_StageRout_Popup lcp = new Login_Change_Plant_Or_No_StageRout_Popup(driver);
		lcp.NoStageRouteAlertMsgclick();
		lcp.Plantlistdropdown();
		lcp.changeplant();*/
		
	}
	
	
}
