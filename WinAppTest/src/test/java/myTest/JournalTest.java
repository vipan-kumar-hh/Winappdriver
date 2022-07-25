

/***********************************************************************************
 * TC 17826
 **********************************************************************************/

package myTest;
import java.net.MalformedURLException;
import java.net.URL;
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

public class JournalTest {

	
	public static WindowsDriver driver = null;
	WebDriverWait wait = null;
	
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
				
	     } catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
	}
	
	@Test
	public void testrunner() {
		journalItemEntry();
		GLAccDtl();   // cursor does not go the next line
		//clickProcessIcon(); //Not working
	}
	
	public void journalItemEntry() {
		
		//page objects
		
		String jDateAut = "dgo_ObjectID=#Ctrl56.Pad.Row2.Cell4.dbedit;";
		String jReference = "dgo_ObjectID=#Ctrl56.Pad.Row2.Cell5.edit;";
		String Misc = "dgo_ObjectID=#Ctrl56.Pad.Row2.Cell6.edit;";
		String funcBtn = "dgo_ObjectID=#Ctrl56.Pad.Row2.Cell7.dbedit.button;";
		String docSeq = "dgo_ObjectID=#Ctrl56.Pad.Row2.Cell9;";

		
		//data values
		String jDateVal = "t";
		String jRefVal = "Vipan_01";
		
		//code
		
		//journal date
		driver.findElementByAccessibilityId(jDateAut).sendKeys(jDateVal);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElementByAccessibilityId(jDateAut).sendKeys(Keys.TAB);
		//journal reference
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.findElementByAccessibilityId(jReference).sendKeys(jRefVal);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.findElementByAccessibilityId(jReference).sendKeys(Keys.TAB);
		driver.findElementByAccessibilityId(Misc).sendKeys(Keys.TAB);
		
		//Function
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.findElementByAccessibilityId(funcBtn).click();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.findElementByAccessibilityId(funcBtn).sendKeys(Keys.DOWN);
		driver.findElementByAccessibilityId(funcBtn).sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.findElementByAccessibilityId(funcBtn).sendKeys(Keys.TAB);
		driver.findElementByAccessibilityId(docSeq).click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElementByAccessibilityId(docSeq).sendKeys(Keys.TAB);	
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		//driver.findElementByAccessibilityId("dgo_ObjectID=#Ctrl60.Pad.Row2.Cell1;").sendKeys(Keys.TAB);
		
		
	}
	
	public void GLAccDtl() {
		
		//Page objects.edit;
		String glAccCol1 = "dgo_ObjectID=#Ctrl60.Pad.Row2.Cell3.edit;";
		String suffix = "dgo_ObjectID=#Ctrl60.Pad.Row2.Cell4.edit;";	
		String glDebitCol1 = "dgo_ObjectID=#Ctrl60.Pad.Row2.Cell7.dbedit;";
		String glCreditCol1 = "dgo_ObjectID=#Ctrl60.Pad.Row2.Cell8.dbedit;";
		String glNarrative1 = "dgo_ObjectID=#Ctrl60.Pad.Row2.Cell9.edit;";
		String glAccCol2 = "dgo_ObjectID=#Ctrl60.Pad.Row3.Cell3.edit;";
		String glDebitCol2 = "dgo_ObjectID=#Ctrl60.Pad.Row3.Cell7.dbedit;";
		String glCreditCol2 = "dgo_ObjectID=#Ctrl60.Pad.Row3.Cell8.dbedit;";
		String glNarrative2 = "dgo_ObjectID=#Ctrl60.Pad.Row3.Cell9.edit;";

String glAccCol1button = "dgo_ObjectID=#Ctrl60.Pad.Row2.Cell3.dbedit.button;";

		
		//data values
		String glAccCol1Val = "0000-100201";
		String glDebitCol1Val = "10";
		String glAccCol2Val = "0000-100201";
		String glDebitCol2Val = "10";
		
		//code
		
		//Write code to click on first element of GL details
//		Actions ac=new Actions(driver);
//		WebElement glAcc2cell = driver.findElementByAccessibilityId(glAccCol1);
//		ac.click(glAcc2cell).build().perform();
	
		////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		//Add data to GL first row
		driver.findElementByAccessibilityId(glAccCol1button).click();
		//driver.findElementByAccessibilityId(glAccCol1).sendKeys(glAccCol1Val);
		/*driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.findElementByAccessibilityId(glAccCol1).sendKeys(Keys.TAB);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.findElementByAccessibilityId(glDebitCol1).sendKeys(glDebitCol1Val);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);		
		driver.findElementByAccessibilityId(glDebitCol1).sendKeys(Keys.TAB);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		//driver.findElementByAccessibilityId(glCreditCol1).sendKeys(Keys.TAB);
		//driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.findElementByAccessibilityId(glNarrative1).sendKeys(Keys.TAB);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		
		//Add data to GL second row
		
		driver.findElementByAccessibilityId(glAccCol2).sendKeys(glAccCol2Val);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.findElementByAccessibilityId(glAccCol2).sendKeys(Keys.TAB);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.findElementByAccessibilityId(glDebitCol2).sendKeys(Keys.TAB);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.findElementByAccessibilityId(glCreditCol2).sendKeys(glDebitCol2Val);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.findElementByAccessibilityId(glCreditCol2).sendKeys(Keys.TAB);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);*/
		
	}
	public void clickProcessIcon() {
		String processIcon = "dgo_ObjectID=mnuMain.toolbar.#Ctrl140;";

		String okBtn = "dgo_ObjectID=#Ctrl2;";
		String processIconName ="Process";
		
		driver.findElementByAccessibilityId(processIcon).click();
		//driver.findElementByName(processIconName).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElementByAccessibilityId(okBtn).click();
	

	}
}
