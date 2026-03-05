package utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenshotHelper 
{
	
	public static  void CaptureScreenshot(ChromeDriver driver,String ClassName,String MethodName,String Listenermethodname) throws IOException
	{
		Date d1 = new Date();
		String Todaysdate = new SimpleDateFormat("ddMMyyyy -- HHmmss").format(d1);
		
		
		TakesScreenshot ts =  driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	File destn = new File("D:\\AutomationTesting2025\\JKNGAutomation\\Screenshotsoutput\\capture  "+"   "+Math.random()+
			"  "+Todaysdate+" "+ClassName+" "+MethodName+""+Listenermethodname+".png");
	FileUtils.copyFile(source, destn);
	
	
	}	
}
