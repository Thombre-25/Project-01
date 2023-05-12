package org.kpi.test;

import org.kpi.utility.DimensionUtil;
import org.kpi.utility.Platform;
import org.kpi.utility.Utility;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class NotificationsScreenTest {

	private AppiumDriver<MobileElement> driver;
	boolean flag = Platform.IS_ANDROID;

	@BeforeMethod
	public void initiateDriver() {
		driver = TestConfig.getInstance().driver;
	}

	@Test(priority = 0)
	public void checkNotificationsScreenElements() {
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
			Utility.findElement(driver, "NotificationsTabButton").click();
			Thread.sleep(5000);
			Assert.assertTrue(Utility.isElementPresent(driver, "notificationsHeading"), "Notifications Screen Heading Not Found");
			if(!Utility.findElement(driver, "notificationsHeading").getText().equals("Notifications")) {
				Assert.assertTrue(false);
			}
			Thread.sleep(2000);
			if(flag) {
				Assert.assertTrue(Utility.isElementPresent(driver, "AllServiceButton"), "All Service Button Not Found");
				if(Utility.isElementPresent(driver, "MDRServiceButton")) {
					Assert.assertTrue(Utility.isElementPresent(driver, "MDRServiceButton"), "MDR Service Button Not Found");
				}
				if(Utility.isElementPresent(driver, "SIEMServiceButton")) {
					Assert.assertTrue(Utility.isElementPresent(driver, "SIEMServiceButton"), "SIEM Service Button Not Found");
				}
				if(Utility.isElementPresent(driver, "VTMServiceButton")) {
					Assert.assertTrue(Utility.isElementPresent(driver, "VTMServiceButton"), "SIEM Service Button Not Found");
				}
				if(Utility.isElementPresent(driver, "IOMTServiceButton")) {
					Assert.assertTrue(Utility.isElementPresent(driver, "IOMTServiceButton"), "SIEM Service Button Not Found");
				}
				Assert.assertTrue(Utility.isElementPresent(driver, "notificationItemImage"), "Notification Item Image Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "notificationItemService"), "Notification Item Service Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "notificationItemDateTime"), "Notification Item Date Time Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "notificationItemName"), "Notification Item Name Not Found");
				//Assert.assertTrue(Utility.isElementPresent(driver, "notificationItemdescription"), "Notification Item Description Not Found");
				Thread.sleep(3000);
				driver.swipe(968, 665, 535, 665, 1000);
				Thread.sleep(3000);
				Assert.assertTrue(Utility.isElementPresent(driver, "notificationMarkAsReadIcon"), "Notification Mark As Read Icon Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "notificationMarAsReadText"), "Notification Mark As Read Text Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "notificationRemoveIcon"), "Notification Remove Icon Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "notificationRemoveText"), "Notification Remove Text Not Found");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 1)
	public void checkSwipeUpandDown() {
		try {
			Thread.sleep(5000);
			if(flag) {
				int width = (int) Math.round(DimensionUtil.getWidth(driver)*0.76);
				int height = (int) Math.round(DimensionUtil.getHeight(driver)*0.434);
				int height2 = (int) Math.round(DimensionUtil.getHeight(driver)*0.235);
				driver.swipe(width, height, width, height2, 1000);
				Thread.sleep(5000);
				driver.swipe(width, height2, width, height, 1000);
			}
			else {
				int width = (int) Math.round(DimensionUtil.getWidth(driver)*0.52);
				int height = (int) Math.round(DimensionUtil.getHeight(driver)*0.83);
				int height2 = (int) Math.round(DimensionUtil.getHeight(driver)*0.52);
				driver.swipe(width, height, width, height2, 1000);
				//driver.swipe(200, 700, 200, 200, 1000);
				Thread.sleep(5000);
				driver.swipe(width, height2, width, height, 1000);
				//driver.swipe(200, 200, 200, 700, 1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}

	
	
}
