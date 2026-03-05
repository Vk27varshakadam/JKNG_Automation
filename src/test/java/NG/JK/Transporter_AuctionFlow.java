package NG.JK;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Transporter_AuctionFlow extends Transporter_Login
{
	@Test(priority=1,groups={"regression","system"})
	public void CommitOfSingleOrder() throws EncryptedDocumentException, IOException, InterruptedException
	{
		
		LoginAndSelectPlant();
		Sliders sd = new Sliders(driver);
		sd.SideBarClick();
		
		Transporter_DirectOrder_Page tdr = new Transporter_DirectOrder_Page(driver);
		tdr.Transporter_Auction_Screen_Access();
		Thread.sleep(10000);
		
		WebElement CountofPendingBids = driver.findElement(By.xpath("//*[text()='Pending Bids']/ancestor::div[@class=\"MuiBox-root css-1mocain\"]/h5"));
		String cnt = CountofPendingBids.getText();
		System.out.println("Pending Bids count is "+cnt);
		int pendingcount = Integer.parseInt(cnt);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(10));

		wait.until(driver -> {
		    WebElement countElement = driver.findElement(By.xpath("//*[text()='Pending Bids']/ancestor::div[@class=\"MuiBox-root css-1mocain\"]/h5"));
		    String text = countElement.getText().replaceAll("[^0-9]", "");
		    return !text.isEmpty() && Integer.parseInt(text) > 0;
		});
		String cnt2 = CountofPendingBids.getText();
		System.out.println("Pending Bids count is "+cnt2);
		int pendingcount2 = Integer.parseInt(cnt2);
		if(pendingcount2>0)
		{
			
			CountofPendingBids.click();
			Actions a1 = new Actions(driver);
			a1.moveToElement(CountofPendingBids).doubleClick();
			
		}
		else
		{
			System.out.println("No order in Auction");
		}
	//Get the Order count available in Auction (Pending Bid)
		tdr.Action_On_Total_Order_Available_In_Auction();
		tdr.BidtheAuctionOrder();
		driver.navigate().refresh();
	}
	

}
