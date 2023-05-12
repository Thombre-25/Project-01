package org.kpi.utility;

import org.openqa.selenium.Dimension;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class DimensionUtil {
	
	public static Dimension getSize(AppiumDriver<MobileElement> driver) {
		System.out.println("Size :: "+driver.manage().window().getSize());
		return driver.manage().window().getSize();
	}
	
	public static int getWidth(AppiumDriver<MobileElement> driver) {
		return  getSize(driver).getWidth();
	}
	
	public static int getHeight(AppiumDriver<MobileElement> driver) {
		return  getSize(driver).getHeight();
	}

}
