package org.kpi.test;

import org.kpi.utility.DimensionUtil;
import org.kpi.utility.Platform;
import org.kpi.utility.Utility;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

public class LogoutTest {
	
	private AppiumDriver<MobileElement> driver;
	boolean flag = Platform.IS_ANDROID;
	
	@BeforeMethod
	public void initiateDriver(){
		driver = TestConfig.getInstance().driver;
	}
	
	@Test(priority = 0)
	public void verifyLogoutNoBtn() {
		try {
			Thread.sleep(5000);
			//Log Out Button Click
			if(flag) {
				Utility.findElement(driver, "logOutMenuButton").click();
				Thread.sleep(3000);
				Assert.assertTrue(Utility.isElementPresent(driver, "logoutText"), "Logout Text is Not Found");
				if(!Utility.findElement(driver, "logoutText").getText().equals("Are you sure want to Logout?")) {
					Assert.assertTrue(false);
				}
				Thread.sleep(5000);
				System.out.println(Utility.findElement(driver, "logoutNoButton").getText());
				Utility.findElement(driver, "logoutNoButton").click();
			}
			else {
				int width = (int) Math.round(DimensionUtil.getWidth(driver)*0.5);
				int height = (int) Math.round(DimensionUtil.getHeight(driver)*0.4);
				TouchAction tap = new TouchAction(driver);
				tap.tap(width, height).perform();
				
				Thread.sleep(5000);
				//Log Out No Button
				int width1 = (int) Math.round(DimensionUtil.getWidth(driver)*0.65);
				int height1 = (int) Math.round(DimensionUtil.getHeight(driver)*0.53);
				tap.tap(width1, height1).perform();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
	
	@Test(priority = 1)
	public void verifyLogoutYesBtn() {
		try {
			Thread.sleep(5000);
			//Log Out Button Click
			if(flag) {
				Utility.findElement(driver, "logOutMenuButton").click();
				Thread.sleep(5000);
				Utility.findElement(driver, "logoutYesButton").click();
				
			}
			else {
				int width = (int) Math.round(DimensionUtil.getWidth(driver)*0.5);
				int height = (int) Math.round(DimensionUtil.getHeight(driver)*0.4);
				TouchAction tap = new TouchAction(driver);
				tap.tap(width, height).perform();
				
				Thread.sleep(5000);
				//Log Out Yes Button
				int width1 = (int) Math.round(DimensionUtil.getWidth(driver)*0.78);
				int height1 = (int) Math.round(DimensionUtil.getHeight(driver)*0.53);
				tap.tap(width1, height1).perform();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}

}
