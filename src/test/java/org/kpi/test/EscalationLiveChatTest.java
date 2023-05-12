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

public class EscalationLiveChatTest {

	private AppiumDriver<MobileElement> driver;
	boolean flag = Platform.IS_ANDROID;

	@BeforeMethod
	public void initiateDriver() {
		driver = TestConfig.getInstance().driver;
	}

	@Test(priority = 0)
	public void checkLCinEscalations() {
		try {
			Thread.sleep(10000);
			TouchAction tap = new TouchAction(driver);
			//Clicking on one Escalation Tile
			if(flag) {
				int width = (int) Math.round(DimensionUtil.getWidth(driver)*0.4);
				int height = (int) Math.round(DimensionUtil.getHeight(driver)*0.23);
				tap.tap(width, height).perform();
				tap.tap(500, 550).perform();	
			}
			else {
				int width = (int) Math.round(DimensionUtil.getWidth(driver)*0.4);
				int height = (int) Math.round(DimensionUtil.getHeight(driver)*0.23);
				tap.tap(width, height).perform();
			}
			Thread.sleep(5000);
			//Clicking on Live Chat Button
			if(flag) {
				Utility.findElement(driver, "LiveChatButton").click();
			}
			else {
				int width = (int) Math.round(DimensionUtil.getWidth(driver)*0.4);
				int height = (int) Math.round(DimensionUtil.getHeight(driver)*0.23);
				tap.tap(width, height).perform();
			}
			Thread.sleep(3000);
			Assert.assertTrue(Utility.isElementPresent(driver, "LCHeading"), "Live Chat Heading in Escalation Live Chat Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "LCHistoryButton"), "Chat History Button in Escalation Live Chat Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "LCCloseButton"), "End Chat Button in Escalation Live Chat Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "LCEscalationIcon"), "Escalation Icon in Escalation Live Chat Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "EsclationTabHeaderNameText"), "Escalation Heading in Escalation Live Chat Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "EsclationTabSeverityText"), "Severity Text in Escalation Live Chat Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "escalationPriorityLabel"), "Severity Value in Escalation Live Chat Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "EsclationTabStatusText"), "Status Text in Escalation Live Chat Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "EsclationTabStatus"), "Status Value in Escalation Live Chat Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "EsclationTabStatusColouredDot"), "Status Dot in Escalation Live Chat Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "ServiceText"), "Service Text in Escalation Live Chat Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "ServiceName"), "Service Name in Escalation Live Chat Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "WhatIsItText"), "What Is It Text in Escalation Live Chat Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "WhatIsItValue"), "What Is It Value in Escalation Live Chat Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "ConnectingMessageDescription"), "Connecting Message Description in Escalation Live Chat Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "DownArrowIcon"), "Down Arrow Icon in Escalation Live Chat Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "LCMessageInputBox"), "Message Input Box in Escalation Live Chat Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "LCSendButton"), "Send Button in Escalation Live Chat Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "LCCharacterCountText"), "Characters Remaining Text in Escalation Live Chat Not Found");
			
			Thread.sleep(2000);
			if(!Utility.findElement(driver, "LCHeading").getText().equals("Chat")) {
				Assert.assertTrue(false);
			}
			if(!Utility.findElement(driver, "EsclationTabSeverityText").getText().equals("Severity")) {
				Assert.assertTrue(false);
			}
			if(!Utility.findElement(driver, "EsclationTabStatusText").getText().equals("Status")) {
				Assert.assertTrue(false);
			}
			if(!Utility.findElement(driver, "ServiceText").getText().equals("Service")) {
				Assert.assertTrue(false);
			}
			if(!Utility.findElement(driver, "WhatIsItText").getText().equals("What is it?")) {
				Assert.assertTrue(false);
			}
			if(!Utility.findElement(driver, "ConnectingMessageDescription").getText().equals("Type a message below to be connected!")) {
				Assert.assertTrue(false);
			}
			if(!Utility.findElement(driver, "LCMessageInputBox").getText().equals("Type a message")) {
				Assert.assertTrue(false);
			}
			if(!Utility.findElement(driver, "LCCharacterCountText").getText().equals("500 Characters Remaining")) {
				Assert.assertTrue(false);
			}

		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 1)
	public void checkLCSendMessage() {
		try {
			Thread.sleep(10000);
			Utility.findElement(driver, "LCMessageInputBox").sendKeys("Testing");
			Thread.sleep(3000);
			Utility.findElement(driver, "LCSendButton").click();
			Thread.sleep(10000);
			Assert.assertTrue(Utility.isElementPresent(driver, "LCEscalationIcon"), " Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "EsclationTabHeaderNameText"), " Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "LCCustomerName"), " Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "LCCustomerSentTime"), " Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "LCChatStartedText"),
					"Chat Started Text in Live Chat Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "LCAnalystConnectingText"),
					"Analyst Connect Text in Live Chat Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "LCChatEndTimer"),
					"Timer for Chat End in LiveChat Not Found");
			
			Thread.sleep(2000);
			if (!Utility.findElement(driver, "LCChatStartedText").getText().contains("chat started - ")) {
				Assert.assertTrue(false);
			}
			if (!Utility.findElement(driver, "LCAnalystConnectingText").getText()
					.contains("Connecting a Threat Analyst - ")) {
				Assert.assertTrue(false);
			}

		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 2)
	public void checkLCMinimizeButton() {
		try {
			Thread.sleep(10000);
			Utility.findElement(driver, "LCMinimizeButton").click();
			Thread.sleep(3000);
			Utility.findElement(driver, "LCFloatingButton").click();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 3)
	public void checkLCEndChatButton() {
		try {
			Thread.sleep(10000);
			Utility.findElement(driver, "LCEndChatButton").click();
			Thread.sleep(3000);
			Utility.findElement(driver, "LCCloseButton").click();
			Thread.sleep(3000);
			driver.navigate().back();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}

}
