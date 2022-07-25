package myTest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;

import io.appium.java_client.windows.WindowsDriver;

public class Demo {

	public static WindowsDriver driver = null;
	//C:\WINDOWS\system32    0x0000000000EA06AA
	@BeforeClass
	public void setup() throws MalformedURLException{
		
		//Working code for notepad...............................
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("app", "C:\\WINDOWS\\system32\\notepad.exe");
		//cap.setCapability("app", "kclient!App");
		//cap.setCapability("appTopLevelWindow", 15337130);
		//cap.setCapability("appTopLevelWindow", "0x0000000000600D48");
		cap.setCapability("platformName", "Windows");
		cap.setCapability("deviceName", "WindowsPC");
		try {
			driver = new WindowsDriver(new URL("http://127.0.0.1:4723"), cap);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
		//Working code for notepad END...............................
		
		
		
		
		
/*		
		
		//Create the driver and attach to the root
        DesiredCapabilities desktopCapabilities = new DesiredCapabilities();
        desktopCapabilities.setCapability("platformName", "Windows");
        desktopCapabilities.setCapability("deviceName", "WindowsPC");
        desktopCapabilities.setCapability("app", "Root");
       /* try {
			//WindowsDriver desktopSession = new WindowsDriver(new URL("http://127.0.0.1:4723"), desktopCapabilities);
			//desktopSession.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*

        DesiredCapabilities iCloudCapabilities = new DesiredCapabilities();
        iCloudCapabilities.setCapability("platformName", "Windows");
        iCloudCapabilities.setCapability("deviceName", "WindowsPC");
        
        
/*
        //Get the window element for your respective application
        List BHWebElement = desktopSession.findElementsByName ("iCloud");
        //check whether iCloud app is open or not
        if (BHWebElement.size() == 1)
        {
            String iCloudWinHandleStr = BHWebElement.get(0).getAttribute("NativeWindowHandle");
            int iCloudWinHandleInt = Integer.parseInt(iCloudWinHandleStr);
            String iCloudWinHandleHex = Integer.toHexString(iCloudWinHandleInt);
            iCloudCapabilities.setCapability("appTopLevelWindow", iCloudWinHandleHex);
        }
        else
        {
            iCloudCapabilities.setCapability("ms:waitForAppLaunch",5);
            iCloudCapabilities.setCapability("app", "C:\\Program Files (x86)\\Common Files\\Apple\\Internet Services\\iCloud.exe");
        }

       
       //0x00000000000C1042
       String iCloudWinHandleHex = "0x000C1042";
       iCloudCapabilities.setCapability("appTopLevelWindow", iCloudWinHandleHex);
       //iCloudCapabilities.setCapability("appTopLevelWindow", "0x0000000000EA06AA");
       
       
       try {
    	   WindowsDriver driver = new WindowsDriver(new URL("http://127.0.0.1:4723"), iCloudCapabilities);
    	   driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    	   System.out.println("WAITING......................");
    	   driver.findElementByName("Exit").click();
    	  // driver.findElementByName("Reason").sendKeys("");
   	} catch (MalformedURLException e) {
   		// TODO Auto-generated catch block
   		e.printStackTrace();
   	}
       
       //iCloudSession.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		
		
*/	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	@AfterMethod
	public void cleanup() {
		//driver.quit();
		try {
			setup();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@AfterMethod
	@AfterSuite
	public void tearDown() {
		//driver.quit();
	}
	
	@Test
	public void SOP() {
		//driver1.findElementByName("File").click();
		//.sendKeys("");
	}
}
