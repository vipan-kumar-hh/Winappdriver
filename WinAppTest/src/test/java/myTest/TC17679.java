/***********************************************************************************
 * TC 17679
 **********************************************************************************/

package myTest;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;

public class TC17679 {
	
	public static WindowsDriver driver = null;
	WebDriverWait wait = null;
	CommonUtility commUtility = null;
	
	String reason = "dgo_ObjectID=HEADER_ADJUSTMENTS_SO_hd_REASON.dbedit;";
	String reasonbtn = "dgo_ObjectID=HEADER_ADJUSTMENTS_SO_hd_REASON.dbedit.button;";
	String reasonlist = "dgo_ObjectID=HEADER_ADJUSTMENTS_SO_hd_REASON.list.i;";

	String del = "dgo_ObjectID=HEADER_ADJUSTMENTS_SO_HD_SUBLOCN_1.dbedit;" ;
	String ref = "dgo_ObjectID=HEADER_ADJUSTMENTS_SO_HD_CUSTORD2;";
	String prod = "dgo_ObjectID=MAIN_LINES_gridMain.Pad.Row2.Cell2.edit;";
	String qty = "dgo_ObjectID=MAIN_LINES_gridMain.Pad.Row2.Cell5.dbedit;";
	
	@BeforeClass
	public void setUpCap() {
		DesiredCapabilities cap = new DesiredCapabilities();
		//cap.setCapability("app", "C:\\WINDOWS\\system32\\notepad.exe");
		cap.setCapability("platformName", "Windows");
		cap.setCapability("deviceName", "WindowsPC");
		
		String iCloudWinHandleHex = Constants.K8_Win_Handle;
	     cap.setCapability("appTopLevelWindow", iCloudWinHandleHex);
	     
		try {
			driver = new WindowsDriver(new URL("http://127.0.0.1:4723"), cap);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
			String title = driver.getTitle();
			System.out.println("Title is : "+title);
			String winHandle = driver.getWindowHandle();
			System.out.println("Win handle  is : "+winHandle);
			
			wait = new WebDriverWait(driver,30);	
			commUtility = new CommonUtility();
/*
			//Gridpad of branchfiles automation

			String grdtable = "dgo_ObjectID=gridCombined.Pad;";
			String grdtablecls = "KCMLGridPad_32";
			int abc = driver.findElementsByAccessibilityId("grdtable").size();
			//List abc = driver.findElementsByAccessibilityId("grdtable");
			System.out.println("OUTSIDE---LIST OF ELEMENT IS ..... "+abc );
			
			
			String rows = driver.findElementByAccessibilityId(grdtable).getAttribute("GridItemPattern.Row");
//			String rows = driver.findElementByClassName(grdtablecls).getAttribute("GridPattern.ColumnCount");
			System.out.println("row vipa num is "+rows);
			//String rows = ((RemoteWebElement) driver.findElementsByClassName("")).getAttribute("GridPattern.RowCount.Value");
			System.out.println("List item is..."+ driver.findElementByAccessibilityId("dgo_ObjectID=gridCombined.Pad.Row2.Cell2;").getText());
			
	*/
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}
	
	@Test
	public void SOPAutomation() {
		openSOP();
		openBiBIS();
		addDetails();
		processDetails();
		//verifyTxnDetails();   //not working
//		eleFoundCode();
		
	}
	
	public void openSOP() {
		//Tree menu selection code
		
		driver.findElementByAccessibilityId("dgo_ObjectID=#Ctrl12.Sales Order Processing;").click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElementByAccessibilityId("dgo_ObjectID=#Ctrl12.Sales Order Processing|Sales Order Processing;").click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		WebElement newBtn= wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("New")));
		System.out.println("openSOP()......NewBtn "+newBtn);
		
//		driver.findElementByAccessibilityId("dgo_ObjectID=#Ctrl12.Sales Order Processing;").click();
//		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
//		driver.findElementByAccessibilityId("dgo_ObjectID=#Ctrl12.Sales Order Processing|Enquiries Menu;").click();
//		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
//		driver.findElementByAccessibilityId("dgo_ObjectID=#Ctrl12.Sales Order Processing|Enquiries Menu|View Sales Log;").click();
	}
	public void openBiBIS() {
		//Select NEW and Bi Book in stock
		String newBtnIcon = "dgo_ObjectID=menuMain.toolbar.FileNew;";
		String ddl_BBIS = "26817";
		String ddl_name_BBIS = "BI Book in Stock";
	
		Actions ac=new Actions(driver);
		WebElement newBtn = driver.findElementByAccessibilityId(newBtnIcon);
		ac.click(newBtn).build().perform();
		ac.sendKeys(Keys.ARROW_DOWN).perform();
		ac.sendKeys(Keys.ENTER).perform();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

	}
	public void addDetails() {
		
		//add reason
		driver.findElementByAccessibilityId(reasonbtn).click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElementByAccessibilityId(reasonbtn).sendKeys(Keys.DOWN);
		driver.findElementByAccessibilityId(reasonbtn).sendKeys(Keys.DOWN);
		driver.findElementByAccessibilityId(reasonbtn).sendKeys(Keys.DOWN);
		driver.findElementByAccessibilityId(reasonbtn).sendKeys(Keys.DOWN);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElementByAccessibilityId(reasonbtn).sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElementByAccessibilityId(reasonbtn).sendKeys(Keys.TAB);
		
		//add delivery type
		
		
		//add reference
		driver.findElementByAccessibilityId(ref).clear();
		driver.findElementByAccessibilityId(ref).sendKeys("vipan kumar");
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.findElementByAccessibilityId(ref).sendKeys(Keys.TAB);
		
		//add product details
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.findElementByAccessibilityId(prod).sendKeys("1010001");
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.findElementByAccessibilityId(prod).sendKeys(Keys.TAB);
		
		//add quantity
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.findElementByAccessibilityId(qty).sendKeys("4");
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.findElementByAccessibilityId(qty).sendKeys(Keys.TAB);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		
	}
	
	public void processDetails() {
		//Click on Process button
		String processBtn = "dgo_ObjectID=menuMain.toolbar.FileProcess;";
		String verifyReason = "dgo_ObjectID=MAIN_STOCKADJUSTMENT_SO_HD_REASON2.dbedit;";


		driver.findElementByAccessibilityId(processBtn).click();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		
		WebElement verReason = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Reason")));
		System.out.println("processDetails().....VerifyReason Button "+verReason);
		
		String reasonCode = driver.findElementByName("Reason").getText();
		System.out.println("processDetails().....VerifyReason text "+reasonCode);
	
		//click popup
		String okBtnBBIS = "dgo_ObjectID=ok;";
		driver.findElementByAccessibilityId(okBtnBBIS).click();
	}
	

	//GridPattern.ColumnCount
	public void verifyTxnDetails() {
		String gridname = "dgo_ObjectID=gridCombined.Pad;";
		//GridPattern.RowCount	11


		String a = driver.findElementByAccessibilityId(gridname).getAttribute("GridPattern.RowCount");
		String b = driver.findElementByAccessibilityId(gridname).getAttribute("GridPattern.RowCount	");
		System.out.println("GridPattern.ColumnCount "+a);
		System.out.println("GridPattern.ColumnCount 2 "+b);
		
	}
	public void performRightClick() {
		//This is not part of test case
		
		Actions actions = new Actions(driver);
		actions.contextClick(driver.findElementByAccessibilityId("dgo_ObjectID=MAIN_LINES_gridMain.Pad.Row2.Cell1;")).perform();
	}
	public void eleFoundCode() {
//		driver.findElementByAccessibilityId("dgo_ObjectID=#Ctrl12.Sales Order Processing;").click();
//		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
//		driver.findElementByAccessibilityId("dgo_ObjectID=#Ctrl12.Sales Order Processing|Sales Order Processing;").click();
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		String quickBtn = "dgo_ObjectID=menuMain.toolbar.FileQuick;";
		String processIcon = "dgo_ObjectID=menuMain.toolbar.FileProcess;";
		String okBtn = "dgo_ObjectID=ok2345;";

		
		driver.findElementByAccessibilityId(processIcon).click();
		boolean quickBtnFound = commUtility.GetElement(driver, okBtn, "Id");
		System.out.println("Value sof quickBtnFound.................................. "+quickBtnFound);

		
	}
}
