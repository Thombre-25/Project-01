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

public class EscalationsScreenTest {

	private AppiumDriver<MobileElement> driver;
	boolean flag = Platform.IS_ANDROID;

	@BeforeMethod
	public void initiateDriver() {
		driver = TestConfig.getInstance().driver;
	}

	@Test(priority = 0)
	public void checkEscalationsScreenElements() {
		try {
			Thread.sleep(10000);
			Utility.findElement(driver, "EscalationsTabButton").click();
			Thread.sleep(5000);
			Assert.assertTrue(Utility.isElementPresent(driver, "escalationsHeading"), "Notifications Screen Heading Not Found");
			Thread.sleep(2000);
			if(!Utility.findElement(driver, "escalationsHeading").getText().equals("Escalations")) {
				Assert.assertTrue(false);
			}
			Thread.sleep(5000);
			Assert.assertTrue(Utility.isElementPresent(driver, "OpenLabel"), "Open Label Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "OpenLabelCloseButton"),
					"Open Label Close Button Not Found");
			Thread.sleep(3000);
			Utility.findElement(driver, "OpenLabelCloseButton").click();
			Thread.sleep(5000);
			if(flag) {
				Assert.assertTrue(Utility.isElementPresent(driver, "AllServiceButton"), "All Service Button Not Found");
				if (Utility.isElementPresent(driver, "MDRServiceButton")) {
					Assert.assertTrue(Utility.isElementPresent(driver, "MDRServiceButton"), "MDR Service Button Not Found");
				}
				if (Utility.isElementPresent(driver, "SIEMServiceButton")) {
					Assert.assertTrue(Utility.isElementPresent(driver, "SIEMServiceButton"),
							"SIEM Service Button Not Found");
				}
				if (Utility.isElementPresent(driver, "VTMServiceButton")) {
					Assert.assertTrue(Utility.isElementPresent(driver, "VTMServiceButton"),
							"SIEM Service Button Not Found");
				}
				if (Utility.isElementPresent(driver, "IOMTServiceButton")) {
					Assert.assertTrue(Utility.isElementPresent(driver, "IOMTServiceButton"),
							"SIEM Service Button Not Found");
				}
				Assert.assertTrue(Utility.isElementPresent(driver, "escalationsItemImage"),	"Escalations Item Image Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "escalationsItemService"), "Escalations Item Service Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "escalationsItemDateTime"), "Escalations Item Date Time Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "escalationsItemName"), "Escalations Item Name Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "escalationPriorityLabel"), "Escalations Item Priority Label Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "escalationsItemAcknowledged"), "Escalations Item Acknowledged Not Found");
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
	
	@Test(priority = 1)
	public void checkSwipeUpandDown() {
		try {
			Thread.sleep(10000);
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
	
	@Test(priority = 2)
	public void checkEscalationsCountMatch() {
		try {
			Thread.sleep(10000);
			TouchAction tap = new TouchAction(driver);
			if(flag) {
				Utility.findElement(driver, "filterButton").click();
			}
			else {
				int width = (int) Math.round(DimensionUtil.getWidth(driver)*0.9);
				int height = (int) Math.round(DimensionUtil.getHeight(driver)*0.83);
				tap.tap(width, height).perform();
				//tap.tap(350, 700).perform();
			}
			Thread.sleep(3000);
			Utility.findElement(driver, "UnacknowledgedCheckBox").click();
			Thread.sleep(3000);
			Utility.findElement(driver, "applyButton").click();
			Thread.sleep(10000);
			if(Utility.isElementPresent(driver, "EscalationsBadgeCount")) {
				Assert.assertTrue(Utility.isElementPresent(driver, "iomt_EscalationItemTile"), "Escalation Item Tile Not Found");				
			}
			Thread.sleep(3000);
			if(flag) {
				Utility.findElement(driver, "UnacknowledgedLabelCloseButton").click();
			}
			else {
				int width1 = (int) Math.round(DimensionUtil.getWidth(driver)*0.4);
				int height1 = (int) Math.round(DimensionUtil.getHeight(driver)*0.23);
				tap.tap(width1, height1).perform();
				//tap.tap(155, 194).perform();
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}

}
