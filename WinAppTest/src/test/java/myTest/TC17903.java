

/***********************************************************************************
 * TC 17903 : Cancel a sales order
 **********************************************************************************/

package myTest;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.windows.WindowsDriver;

public class TC17903 {

	
	public static WindowsDriver driver = null;
	WebDriverWait wait = null;
	CommonUtility commUtility = null;
	
	@BeforeClass
	public void setCapabilities() {
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "Windows");
		cap.setCapability("deviceName", "WindowsPC");
		String k8WinHandle = Constants.K8_Win_Handle;
	    cap.setCapability("appTopLevelWindow", k8WinHandle);
	 
	     try {
				driver = new WindowsDriver(new URL("http://127.0.0.1:4723"), cap);
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				
				String title = driver.getTitle();
				System.out.println("Title is : "+title);
				String winHandle = driver.getWindowHandle();
				System.out.println("Win handle  is : "+winHandle);
				wait = new WebDriverWait(driver,30);
				commUtility = new CommonUtility();
	     } catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
	}
	
	@Test
	public void testrunner() {
		openSOP();
		clickOpenIcon();
		fillOrderNoToSearch();
		clickCancelIcon();
		fillCancelReason();
		verifyBalance();
	}
	public void openSOP() {
		//Tree menu selection code
		
		driver.findElementByAccessibilityId("dgo_ObjectID=#Ctrl12.Sales Order Processing;").click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElementByAccessibilityId("dgo_ObjectID=#Ctrl12.Sales Order Processing|Sales Order Processing;").click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	public void clickOpenIcon() {
		String openIcon	= "dgo_ObjectID=menuMain.toolbar.FileOpen;";
		driver.findElementByAccessibilityId(openIcon).click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}
	public void fillOrderNoToSearch() {
		String orderNoTxt = "dgo_ObjectID=editOrderNumber;";
		String okBtn = "dgo_ObjectID=ok;";
		
		//data values
		String ordNo = "766";
		driver.findElementByAccessibilityId(orderNoTxt).click();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.findElementByAccessibilityId(orderNoTxt).sendKeys(ordNo);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		
		driver.findElementByAccessibilityId(okBtn).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
	public void clickCancelIcon() {
		String cancelIcon = "dgo_ObjectID=menuMain.toolbar.FileCancel;";
		
		driver.findElementByAccessibilityId(cancelIcon).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
	public void fillCancelReason() {
		String ordStatusDdlBtn = "dgo_ObjectID=editOrderStatus.dbedit.button;";
		String delLinesBtn = "dgo_ObjectID=ok;";
		String popUpOkBtn = "OK";
		
		driver.findElementByAccessibilityId(ordStatusDdlBtn).click();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.findElementByAccessibilityId(ordStatusDdlBtn).sendKeys(Keys.ARROW_DOWN);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.findElementByAccessibilityId(ordStatusDdlBtn).sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.findElementByAccessibilityId(delLinesBtn).click();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.findElementByName(popUpOkBtn).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	public void verifyBalance() {
		String total = "dgo_ObjectID=TOTALS_CREDITTOTALS_gridSummaryTotals1.Pad.Row5.Cell2;";
		String okBtn = "dgo_ObjectID=ok;";

		
		String totalAmt = driver.findElementByAccessibilityId(total).getText();
		System.out.println("verifyBalance().....Balance amount is  "+totalAmt);
		
		if(totalAmt.equalsIgnoreCase( "0")) {
			driver.findElementByAccessibilityId(okBtn).click();
		}
		else {
			System.out.println("verifyBalance().....Something went wrong. Expected 0 in Total amount but found "+totalAmt);
		}

	}
}
