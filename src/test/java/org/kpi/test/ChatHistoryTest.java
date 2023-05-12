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

public class ChatHistoryTest {
	
	private AppiumDriver<MobileElement> driver;
	boolean flag = Platform.IS_ANDROID;

	@BeforeMethod
	public void initiateDriver() {
		driver = TestConfig.getInstance().driver;
	}
	
	@Test(priority = 0)
	public void validateChatHistory() {
		try {
			Thread.sleep(5000);
			if(flag) {
				Utility.findElement(driver, "chatHistoryMenuButton").click();
			}
			else {
				int width = (int) Math.round(DimensionUtil.getWidth(driver)*0.5);
				int height = (int) Math.round(DimensionUtil.getHeight(driver)*0.28);
				TouchAction tap = new TouchAction(driver);
				tap.tap(width, height).perform();
			}
			Thread.sleep(5000);
			Assert.assertTrue(Utility.isElementPresent(driver, "chatHistoryBackButton"), "Live Chat History Back Button Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "Chat HistoryTitle"), "Live Chat History Heading Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "LiveChatButton"), "Live Chat Button Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "ServiceImage"), "ServiceImage Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "ServiceName"), "ServiceName Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "LCHeading"), "Live Chat Heading Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "LCDurationTime"), "Live Chat Duration Time Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "LCDateAndTime"), "Live Chat Date And Time Not Found");
			Thread.sleep(2000);
			if(!Utility.findElement(driver, "Chat HistoryTitle").getText().equals("Chat History")) {
				Assert.assertTrue(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
	
	@Test(priority = 1)
	public void checkCHTileClick() {
		try {
			Thread.sleep(5000);
			Utility.findElement(driver, "LCHistoryTile").click();
			Thread.sleep(5000);
			Assert.assertTrue(Utility.isElementPresent(driver, "LCDetailBackButton"), "Live Chat DetailBackButton Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "LCDetailHeading"), "Live Chat DetailHeading Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "ServiceText"), "ServiceText Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "ServiceName"), "ServiceName Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "LCDetailTimeCreatedText"), "Live Chat DetailTimeCreatedText Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "LCDetailTimeCreatedValue"), "Live Chat DetailTimeCreatedValue Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "LCDetailDurationText"), "Live Chat DetailDurationText Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "LCDetailDurationValue"), "Live Chat DetailDurationValue Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "LCDownloadButton"), "Live Chat Download Button Not Found");
			
			Thread.sleep(2000);
			if(!Utility.findElement(driver, "LCDetailHeading").getText().contains("Chat: Analyst - ")){
				Assert.assertTrue(false);
			}
			if(!Utility.findElement(driver, "ServiceText").getText().equals("Service")){
				Assert.assertTrue(false);
			}
			if(!Utility.findElement(driver, "LCDetailTimeCreatedText").getText().equals("Time Created")){
				Assert.assertTrue(false);
			}
			if(!Utility.findElement(driver, "LCDetailDurationText").getText().equals("Duration")){
				Assert.assertTrue(false);
			}
			
			if(Utility.isElementPresent(driver, "LCCustomerName")) {
				Assert.assertTrue(Utility.isElementPresent(driver, "LCCustomerName"), "Live Chat CustomerName Not Found");
			}
			if(Utility.isElementPresent(driver, "LCCustomerSentTime")) {
				Assert.assertTrue(Utility.isElementPresent(driver, "LCCustomerSentTime"), "Live Chat CustomerSentTime Not Found");
			}
			if(Utility.isElementPresent(driver, "LCEndedText")) {
				Assert.assertTrue(Utility.isElementPresent(driver, "LCEndedText"), "Live Chat EndedText Not Found");
			}
			Thread.sleep(3000);
			Utility.findElement(driver, "LCDetailBackButton").click();
			Thread.sleep(3000);
			Utility.findElement(driver, "chatHistoryBackButton").click();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}

}
