

/***********************************************************************************
 * TC 17786 : create a cash customer
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

public class TC17786 {

	
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
		openAccMaintenance();
		clickNew();
		addCustDetails();
		addPhoneAndEmail();
		clickSave();
		//clickExit();
		
	}
	
	public void openAccMaintenance() {
		//objects
		String accReceivable ="dgo_ObjectID=#Ctrl12.Accounts Receivable;";
		String accMaintenance = "dgo_ObjectID=#Ctrl12.Accounts Receivable|Account Maintenance;";
		

		//code
		driver.findElementByAccessibilityId(accReceivable).click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElementByAccessibilityId(accMaintenance).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		WebElement newBtn= wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("General")));
//		System.out.println("openSOP()......NewBtn "+newBtn);
	}
	
	public void clickNew() {
		String menuEditName = "Edit";
		WebElement edit = driver.findElementByName(menuEditName);

	//driver.getKeyboard().
		Actions ac = new Actions(driver);
		ac.click(edit).sendKeys(Keys.CONTROL).sendKeys("n").build().perform();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);//ac.sendKeys(Keys.LEFT_CONTROL);
		
		String accType = "dgo_ObjectID=cf_cu_acctype.dbedit;";
		String accTypeVal = driver.findElementByAccessibilityId(accType).getAttribute("Value.Value");
		//String accTypeVal = driver.findElementByAccessibilityId(accType).getText();
		System.out.println("Value of Acc Type "+accTypeVal);

//		WebElement bar1 = driver.findElementByAccessibilityId("dgo_ObjectID=mnuMain.toolbar.;");
//		WebElement insertIcon = driver.findElementByAccessibilityId("dgo_ObjectID=mnuMain.toolbar.mnuEditInsert;");
//		ac.moveToElement(bar1).click().perform();
//		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//		//ac.moveToElement(insertIcon).click().perform();
//		ac.moveToElement(insertIcon).clickAndHold().perform();
//		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		

//		Actions ac2 = new Actions(driver);
//		ac2.keyDown(Keys.CONTROL);
//		ac2.keyUp(Keys.CONTROL);
	}
	public void addCustDetails() {
		String accType ="dgo_ObjectID=cf_cu_acctype.dbedit;";
		String nextBtn = "dgo_ObjectID=cmdNext;";
		String name = "dgo_ObjectID=cf_cu_name;";
		String address = "dgo_ObjectID=#Ctrl22;";
		String city ="dgo_ObjectID=#Ctrl24;";
		String account = "dgo_ObjectID=CF_cu_ACCOUNT.dbedit;";
		String finishBtn = "dgo_ObjectID=cmdNext;";
		
		//data values
		String nameVal = "Ajay Kumar";
		String addressVal = "23 Queens Road, waterloo";
		String cityVal = "Waterloo";
		//switchToInsertWizard();
		//code
		String accTypeVal = driver.findElementByAccessibilityId(accType).getText();
		System.out.println("Value of account type "+accTypeVal);
		//if(accTypeVal.trim().equals("Cash")){
			System.out.println("Account type Cash is selected");
			driver.findElementByAccessibilityId(nextBtn).click();
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
//Actions ac2 = new Actions(driver);
//ac2.keyUp(Keys.CONTROL);
			//add details
			driver.findElementByAccessibilityId(name).clear();
			driver.findElementByAccessibilityId(name).click();
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
			
			driver.findElementByAccessibilityId(name).sendKeys(nameVal);
			driver.findElementByAccessibilityId(name).clear();
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
			driver.findElementByAccessibilityId(name).sendKeys(nameVal);
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
			driver.findElementByAccessibilityId(address).click();
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
			driver.findElementByAccessibilityId(address).sendKeys(addressVal);
			driver.findElementByAccessibilityId(address).click();
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
			driver.findElementByAccessibilityId(city).click();
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
			driver.findElementByAccessibilityId(city).sendKeys(cityVal);
			driver.findElementByAccessibilityId(nextBtn).click();
			
			//verify account details
			String accNo = driver.findElementByAccessibilityId(account).getText();
			System.out.println("Account Number is generated by default: "+accNo);
			driver.findElementByAccessibilityId(finishBtn).click();
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		//}

	}
	
	public void addPhoneAndEmail() {
		String arPhone = "dgo_ObjectID=CUST_GENERAL_CF_cu_PHONE_1;";
		String email = "dgo_ObjectID=CUST_GENERAL_CF_cu_EMAIL;";
	
		
		String arPhoneVal = "519-117-166";
		String emailVal = "ajay@abc.com";
		driver.findElementByAccessibilityId(arPhone).click();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.findElementByAccessibilityId(arPhone).sendKeys(arPhoneVal);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.findElementByAccessibilityId(email).click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElementByAccessibilityId(email).sendKeys(emailVal);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	}
	public void clickSave() {
		String menuEditName = "Edit";
		WebElement edit = driver.findElementByName(menuEditName);
		Actions ac = new Actions(driver);
		ac.click(edit).sendKeys(Keys.CONTROL).sendKeys("s").build().perform();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
	public void clickExit() {
		String exitBtn = "dgo_ObjectID=mnuMain.toolbar.FileExit;";
		driver.findElementByAccessibilityId(exitBtn).click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}
	public void switchToInsertWizard() {
		String windowTitle = "Insert Account Wizard";
	    WebElement winWebElement = driver.findElementByName(windowTitle);
	    System.out.println("winWebElement...... : "+winWebElement);
	    String winHandleStr = winWebElement.getAttribute("NativeWindowHandle");
	    System.out.println("winHandleStr...... : "+winHandleStr);
	    int winHandleInt = Integer.parseInt(winHandleStr);
	    String winHandleHex = Integer.toHexString(winHandleInt);
	    winHandleHex = "0x0000000000"+winHandleHex;

	    
	    System.out.println("winHandleInt...... : "+winHandleInt+"winHandleHex...... : "+winHandleHex);
	    
	    DesiredCapabilities winCapabilities = new DesiredCapabilities();
	    winCapabilities.setCapability("appTopLevelWindow", winHandleHex);
	}
}
