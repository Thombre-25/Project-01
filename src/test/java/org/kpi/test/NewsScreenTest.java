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

public class NewsScreenTest {

	private AppiumDriver<MobileElement> driver;
	boolean flag = Platform.IS_ANDROID;

	@BeforeMethod
	public void initiateDriver() {
		driver = TestConfig.getInstance().driver;
	}

	@Test(priority = 0)
	public void checkNewsScreenElements() {
		try {
			Thread.sleep(10000);
			Utility.findElement(driver, "NewsTabButton").click();
			Thread.sleep(5000);
			Assert.assertTrue(Utility.isElementPresent(driver, "newsHeading"), "News Heading Not Found");
			if(flag) {
				Assert.assertTrue(Utility.isElementPresent(driver, "newsScreenFlatList"), "News Screen Tiles Not Found");
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 1)
	public void clickNewsTile() {
		try {
			Thread.sleep(5000);
			if(flag) {
				Utility.findElement(driver, "newsScreenItemTitle").click();
			}
			else {
				TouchAction tap = new TouchAction(driver);
				int width = (int) Math.round(DimensionUtil.getWidth(driver)*0.43);
				int height = (int) Math.round(DimensionUtil.getHeight(driver)*0.2);
				tap.tap(width, height).perform();
				//tap.tap(168, 168).perform();
			}
			Thread.sleep(15000);
			Assert.assertTrue(Utility.isElementPresent(driver, "doneButton"), "Done button Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "lockIcon"), "Lock Icon Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "webUrl"), "Web URL Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "fontIncDec"), "Text Format Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "reloadWeb"), "Refresh Button Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "navigateForward"), "Forward Button Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "navigateBack"), "Back Button Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "shareWebLink"), "Share Button Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "openInBrowser"), "Open In Browser Not Found");
			Thread.sleep(5000);
			Utility.findElement(driver, "doneButton").click();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}

}
