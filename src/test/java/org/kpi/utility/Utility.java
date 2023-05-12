package org.kpi.utility;

import java.util.NoSuchElementException;

import org.openqa.selenium.Keys;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class Utility {
	
	private Utility(){}
	

	public static boolean isElementPresent(AppiumDriver<MobileElement> driver, String element) {

		try {
			findElement(driver, element);
			//driver.findElement(by);
			return true;

		} catch (NoSuchElementException e) {
			return false;
		} catch (Exception e) {
			return false;
		}


	}
	
	
	public static MobileElement findElement(AppiumDriver<MobileElement> driver,String id ) {
		
		if(Platform.IS_ANDROID) {
			return driver.findElementByAccessibilityId(id);
		}else {
			return driver.findElementById(id);
		}
		
	}
	
	public static void clearText(AppiumDriver<MobileElement> driver, String element) {
		MobileElement mobileElement = findElement(driver, element);
		String text = mobileElement.getText();
		System.out.println("Text :: "+text);
		System.out.println("Length :: "+text.length());
		for(int i=0;i<=text.length();i++) {
			mobileElement.sendKeys(Keys.BACK_SPACE);
		}
	}
}
