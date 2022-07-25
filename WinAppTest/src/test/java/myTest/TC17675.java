

/***********************************************************************************
 * TC 17764
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

public class TC17675 {

	
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
				
				//switching b/w windows
				String wintitle = "K8_Regression Automation";
				Set<String> windows = driver.getWindowHandles();
				for(String window : windows) {
					driver.switchTo().window(window);
					System.out.println("window name is ......."+driver.getTitle());
				}
				
	     } catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
	}
	
	@Test
	public void testrunner() {
		//clickQuickIcon();
		//fillDelMethodNdProdDetails();
		//step 4 is skipped
		//Step 5
		//enterProductDetails();
		//STEP 6,7,8 ARE SKIPPED
		//STEP 9
		//selectStockOptions();
		step10(); //enter qty and item at same time
		
	}
	
	public void clickQuickIcon() {
		String quickIcon = "dgo_ObjectID=menuMain.toolbar.FileQuick;";
		driver.findElementByAccessibilityId(quickIcon).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		String delMethod = "Delivery method";
		
		//element not found error is thrown using below commands
//		WebElement delMeth= wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("delMethod")));
//		System.out.println("clickQuickIcon.....delMethod "+delMeth +" ...element found");
		
	}
	
	public void fillDelMethodNdProdDetails() {
		
		//objects
		String delMethodBtn = "dgo_ObjectID=HEADER_SALES_SO_hd_DELMETH.dbedit.button;";
		String custOrdNo = "dgo_ObjectID=HEADER_SALES_SO_HD_CUSTORD;";
		String salesperson = "dgo_ObjectID=HEADER_SALES_so_hd_SALESMAN_11.dbedit;";
		String contactName = "dgo_ObjectID=HEADER_SALES_SO_HD_CONTACT;";
		String date = 	"dgo_ObjectID=HEADER_SALES_SO_HD_DATEREQ.dbedit;";
		
		//code
		driver.findElementByAccessibilityId(delMethodBtn).click();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.findElementByAccessibilityId(delMethodBtn).sendKeys(Keys.DOWN);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.findElementByAccessibilityId(delMethodBtn).sendKeys(Keys.ENTER);
		driver.findElementByAccessibilityId(delMethodBtn).sendKeys(Keys.TAB);
		
		driver.findElementByAccessibilityId(custOrdNo).sendKeys(Keys.TAB);
		driver.findElementByAccessibilityId(salesperson).sendKeys(Keys.TAB);
		driver.findElementByAccessibilityId(contactName).sendKeys(Keys.TAB);
		driver.findElementByAccessibilityId(date).sendKeys(Keys.TAB);
		
	}
	public void enterProductDetails() {
		String product = "dgo_ObjectID=MAIN_LINES_gridMain.Pad.Row2.Cell2.edit;";
		String qty = "dgo_ObjectID=MAIN_LINES_gridMain.Pad.Row2.Cell4.edit;";

		//data values
		String productNo = "1010001";
		String qtyVal = "10";
		
		//code
		driver.findElementByAccessibilityId(product).sendKeys(productNo);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.findElementByAccessibilityId(product).sendKeys(Keys.TAB);
		
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.findElementByAccessibilityId(qty).sendKeys(qtyVal);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.findElementByAccessibilityId(qty).sendKeys(Keys.TAB);
	}
	
	public void selectStockOptions() {
		String prodInfoBtn1 = "dgo_ObjectID=MAIN_LINES_gridMain.Pad.Row2.Cell1;";
		String menuStockOpt ="Stock Options...";
		
		//code
		Actions ac = new Actions(driver);
		//ac.contextClick(driver.findElementByAccessibilityId(prodInfoBtn1)).sendKeys(Keys.ARROW_DOWN).build().perform();
		WebElement prodInforBtn = driver.findElementByAccessibilityId(prodInfoBtn1);
		ac.contextClick(prodInforBtn).build().perform();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		for(int i=1;i<=30;i++) {
			ac.sendKeys(Keys.ARROW_DOWN).perform();
		}
		ac.sendKeys(Keys.ARROW_RIGHT).perform();
		ac.sendKeys(Keys.ENTER).perform();
		
		String prodEdit = "dgo_ObjectID=editProduct;";
		String prodName = driver.findElementByAccessibilityId(prodEdit).getText();
		System.out.println("the product name is  "+prodName +" ...element found");
		
		if(!(prodName == null)) {
			ac.keyDown(Keys.ALT).sendKeys(Keys.F4).perform();
			
		}
		
		//driver.findElementByAccessibilityId("Close").click();
		//switchtoPopUP();
		
		//Stock Display - 1646
		
//		WebElement stockOpt = driver.findElementByName(menuStockOpt);
//		System.out.println("selectStockOptions.....WebElement stockOpt "+stockOpt +" ...element found");
//		stockOpt.click();
		
	}
	public void switchtoPopUP() {
		//this method is not entirely working
		DesiredCapabilities cap2 = new DesiredCapabilities();
		cap2.setCapability("platformName", "Windows");
		cap2.setCapability("deviceName", "WindowsPC");
	    cap2.setCapability("app", "Root");
	    WindowsDriver driver2=null;
		try {
			driver2 = new WindowsDriver(new URL("http://127.0.0.1:4723"), cap2);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    String windowTitle = "Stock Display - 1646";
	    WebElement winWebElement = driver2.findElementByName(windowTitle);
	    System.out.println("winWebElement...... : "+winWebElement);
	    String winHandleStr = winWebElement.getAttribute("NativeWindowHandle");
	    System.out.println("winHandleStr...... : "+winHandleStr);
	    int winHandleInt = Integer.parseInt(winHandleStr);
	    String winHandleHex = Integer.toHexString(winHandleInt);
	    winHandleHex = "0x0000000000"+winHandleHex;

	    
	    System.out.println("winHandleInt...... : "+winHandleInt+"winHandleHex...... : "+winHandleHex);
	    
	    DesiredCapabilities winCapabilities = new DesiredCapabilities();
	    winCapabilities.setCapability("appTopLevelWindow", winHandleHex);
	    try {
	    	WindowsDriver driver3 = new WindowsDriver(new URL("http://127.0.0.1:4723"), winCapabilities);
	    	String title = driver3.getTitle();
			System.out.println("Title of pop up is...... : "+title);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void step10() {
		
	}
	
}
