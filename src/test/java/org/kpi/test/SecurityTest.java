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

public class SecurityTest {
	
	private AppiumDriver<MobileElement> driver;
	boolean flag = Platform.IS_ANDROID;
	
	@BeforeMethod
	public void initiateDriver() {
		driver = TestConfig.getInstance().driver;
	}
	
	@Test(priority = 0)
	public void securityScreenElementsCheck() {
		try {
			/*Thread.sleep(10000);
			Utility.findElement(driver, "usernameInput").sendKeys(PropertiesFile.getInstance().getUsername());
			Thread.sleep(2000);
			Utility.findElement(driver, "nextButton").click();
			Thread.sleep(5000);
			Utility.findElement(driver, "passwordInput").sendKeys(PropertiesFile.getInstance().getPassword());
			Thread.sleep(2000);
			Utility.findElement(driver, "loginButton").click();
			Thread.sleep(10000);*/
			Thread.sleep(10000);
			Utility.findElement(driver, "SettingsTabButton").click();
			Thread.sleep(10000);
			if(flag) {
				Utility.findElement(driver, "securityMenuButton").click();
			}
			else {
				int width = (int) Math.round(DimensionUtil.getWidth(driver)*0.5);
				int height = (int) Math.round(DimensionUtil.getHeight(driver)*0.34);
				TouchAction tap = new TouchAction(driver);
				tap.tap(width, height).perform();
			}
			Thread.sleep(5000);
			Assert.assertTrue(Utility.isElementPresent(driver, "SecurityTitle"), "Security Title Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "securityBackButton"), "Security Back Button Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "touchIDText"), "Enable Touch Id is not found");
			Assert.assertTrue(Utility.isElementPresent(driver, "touchIDToggle"), "Touch Id Toggle Button is not found");
			Assert.assertTrue(Utility.isElementPresent(driver, "changePasswordMenuButton"), "Change Password Menu Button is not found");
			Thread.sleep(2000);
			if(!Utility.findElement(driver, "SecurityTitle").getText().equals("Security")) {
				Assert.assertTrue(false);
			}
			if(!Utility.findElement(driver, "touchIDText").getText().equals("Enable FaceId / TouchId")) {
				Assert.assertTrue(false);
			}
			if(!Utility.findElement(driver, "changePasswordMenuButton").getText().equals("Change Password")) {
				Assert.assertTrue(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}

}
