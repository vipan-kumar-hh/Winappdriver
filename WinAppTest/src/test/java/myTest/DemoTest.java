package myTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;

import io.appium.java_client.windows.WindowsDriver;

public class DemoTest {

	public static WindowsDriver driver = null;
	
	@BeforeClass
	public void setup() {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("app", "give app exe path here or app id");
		cap.setCapability("platformName", "Windows");
		cap.setCapability("deviceName", "WindowsPC");
		try {
			driver = new WindowsDriver(new URL("http://127.0.0.1:4723"), cap);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void cleanup() {
		driver.quit();
		setup();
	}
	
	@AfterSuite
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void SOP() {
		//driver.findElementByName("").click();
		//.sendKeys("");
	}
}
