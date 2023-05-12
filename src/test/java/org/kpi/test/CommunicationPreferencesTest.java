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

public class CommunicationPreferencesTest {

	private AppiumDriver<MobileElement> driver;
	boolean flag = Platform.IS_ANDROID;

	@BeforeMethod
	public void initiateDriver() {
		driver = TestConfig.getInstance().driver;
	}

	@Test(priority = 0)
	public void VerifyCommunicationPreferences() {
		try {
			Thread.sleep(5000);
			if(flag) {
				Utility.findElement(driver, "communicationPreferencesMenuButton").click();
			}
			else {
				int width = (int) Math.round(DimensionUtil.getWidth(driver)*0.5);
				int height = (int) Math.round(DimensionUtil.getHeight(driver)*0.28);
				TouchAction tap = new TouchAction(driver);
				tap.tap(width, height).perform();
			}
			Thread.sleep(5000);
			//title check
			Assert.assertTrue(Utility.isElementPresent(driver, "Communication PreferencesTitle"), "Communication Preference is not found");
			Thread.sleep(2000);
			if(!Utility.findElement(driver, "Communication PreferencesTitle").getText().equals("Communication Preferences")) {
				Assert.assertTrue(false);
			}
			Assert.assertTrue(Utility.isElementPresent(driver, "communicationPreferencesBackButton"), "Communication Preference BackButton is not found");
			if(Utility.isElementPresent(driver, "SIEM")) {
				Assert.assertTrue(Utility.isElementPresent(driver, "SIEM"), "SIEM is not found");
			}
			if(Utility.isElementPresent(driver, "VTM")) {
				Assert.assertTrue(Utility.isElementPresent(driver, "VTM"), "VTM is not found");
			}
			if(Utility.isElementPresent(driver, "MDR")) {
				Assert.assertTrue(Utility.isElementPresent(driver, "MDR"), "MDR is not found");
			}
			if(Utility.isElementPresent(driver, "IOMT")) {
				Assert.assertTrue(Utility.isElementPresent(driver, "IOMT"), "IOMT is not found");
			}
			if(Utility.isElementPresent(driver, "General")) {
				Assert.assertTrue(Utility.isElementPresent(driver, "General"), "General is not found");
			}

			Thread.sleep(3000);
			Utility.findElement(driver, "communicationPreferencesBackButton").click();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 1)
	public void verifyServicesCollapsibleView() {
		try {
			Thread.sleep(5000);
			if(flag) {
				Utility.findElement(driver, "communicationPreferencesMenuButton").click();
			}
			else {
				int width = (int) Math.round(DimensionUtil.getWidth(driver)*0.5);
				int height = (int) Math.round(DimensionUtil.getHeight(driver)*0.28);
				TouchAction tap = new TouchAction(driver);
				tap.tap(width, height).perform();
			}
			Thread.sleep(5000);
			if(Utility.isElementPresent(driver, "SIEM")) {
				Thread.sleep(3000);
				Utility.findElement(driver, "SIEM").click();
				Thread.sleep(3000);
				Utility.findElement(driver, "SIEM").click();
			}
			if(Utility.isElementPresent(driver, "VTM")) {
				Thread.sleep(3000);
				Utility.findElement(driver, "VTM").click();
				Thread.sleep(3000);
				Utility.findElement(driver, "VTM").click();
			}
			if(Utility.isElementPresent(driver, "MDR")) {
				Thread.sleep(3000);
				Utility.findElement(driver, "MDR").click();
				Thread.sleep(3000);
				Utility.findElement(driver, "MDR").click();
			}
			if(Utility.isElementPresent(driver, "IOMT")) {
				Thread.sleep(3000);
				Utility.findElement(driver, "IOMT").click();
				Thread.sleep(3000);
				Utility.findElement(driver, "IOMT").click();
			}
			if(Utility.isElementPresent(driver, "General")) {
				Thread.sleep(3000);
				Utility.findElement(driver, "General").click();
				Thread.sleep(3000);
				Utility.findElement(driver, "General").click();
			}
			Thread.sleep(3000);
			Utility.findElement(driver, "communicationPreferencesBackButton").click();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}

}
