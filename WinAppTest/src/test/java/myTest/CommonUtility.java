package myTest;

import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;

public class CommonUtility {
	
	WindowsDriver driverObj = null;
	
	public boolean GetElement(WindowsDriver driver,String automationId, String controlType)
    {
		int minTime = 1;
		int maxTime = 30;
		this.driverObj = driver;
		boolean elementFound = false;
		
		for(int i = minTime;i<=maxTime;i++) {
			//try finding element by its accessibility id
			if(controlType.equalsIgnoreCase("Id")) {
				System.out.println("INSIDE GETLEMENT ID FOR CONTROL.........");
				boolean displayed = driverObj.findElementByAccessibilityId(automationId).isDisplayed();
				if(displayed == true) {
					elementFound = true;
					System.out.println("Waited for "+i+" seconds..........BEFORE BREAK");
					break;
				}
				try {
					driverObj.wait(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Waited for "+i+" seconds..........");
				continue;
			}
			//try finding element by its name
			else if(controlType.equalsIgnoreCase("Name")){
				boolean displayed = driverObj.findElementByName(automationId).isDisplayed();
				if(displayed == true) {
					elementFound = true;
					break;
				}
				try {
					driverObj.wait(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
      return elementFound;
    }
}
