package org.kpi.test;

import org.kpi.utility.Utility;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class MDRLiveChatTest {
	
	private AppiumDriver<MobileElement> driver;
	//private boolean flag = Platform.IS_ANDROID;
	
	@BeforeMethod
	public void initiateDriver() {
		driver = TestConfig.getInstance().driver;
	}
	
	@Test(priority = 0)
	public void checkMDRElements() {
		try {
			Thread.sleep(5000);
			Utility.findElement(driver, "MDRServiceButton").click();
			Thread.sleep(10000);
			Assert.assertTrue(Utility.isElementPresent(driver, "LCHeading"), "Live Chat Heading in MDR Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "LCHistoryButton"), "Chat History Button in MDR Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "LCEndChatButton"), "End Chat Button in MDR Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "LCMinimizeButton"), "Minimize Button in MDR Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "LCChatStartedText"), "MDR Chat Started Text in MDR Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "LCAnalystConnectingText"), "Analyst Connect Text in MDR Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "LCChatEndTimer"), "Timer for Chat End in MDR Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "Type a message..."), "Message Input Box in MDR Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "send"), "Send Button in MDR Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "LCCharacterCountText"), "Characters Remaining Text Not Found");
			
			Thread.sleep(2000);
			if(!Utility.findElement(driver, "LCChatStartedText").getText().contains("MDR chat started - ")) {
				Assert.assertTrue(false);
			}
			if(!Utility.findElement(driver, "LCAnalystConnectingText").getText().contains("Connecting a Threat Analyst - ")) {
				Assert.assertTrue(false);
			}
			if(!Utility.findElement(driver, "Type a message...").getText().equals("Type a message...")) {
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
	public void checkMDRMinimizeButton() {
		try {
			Thread.sleep(5000);
			Utility.findElement(driver, "LCMinimizeButton").click();
			Thread.sleep(3000);
			Utility.findElement(driver, "LCFloatingButton").click();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
	
	@Test(priority = 2)
	public void checkMDREndChatButton() {
		try {
			Thread.sleep(5000);
			Utility.findElement(driver, "LCEndChatButton").click();
			Thread.sleep(3000);
			Utility.findElement(driver, "LCCloseButton").click();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
	
	@Test(priority = 3)
	public void checkMDRSendMessage() {
		try {
			Thread.sleep(5000);
			Utility.findElement(driver, "LiveChatButton").click();
			Thread.sleep(3000);
			Utility.findElement(driver, "MDRServiceButton").click();
			Thread.sleep(5000);
			Utility.findElement(driver, "Type a message...").sendKeys("Testing");
			Thread.sleep(3000);
			Utility.findElement(driver, "send").click();
			Thread.sleep(3000);
			Assert.assertTrue(Utility.isElementPresent(driver, "LCCustomerName"), "Name and Client Name Not Found");
			//Assert.assertTrue(Utility.isElementPresent(driver, "LCCustomerMessage"), "Message Just Sent Not Found");
			//Assert.assertTrue(Utility.isElementPresent(driver, "LCCustomerNameBadge"), "Badge With Two Letters Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "LCCustomerSentTime"), "Time of Message Send Not Found");
			Thread.sleep(3000);
			Utility.findElement(driver, "LCEndChatButton").click();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
	
	/*@Test(priority = 4)
	public void checkMDRTimerEndChat() {
		try {
			Thread.sleep(300000);
			Assert.assertTrue(Utility.isElementPresent(driver, "LCHeadsetImage"), "Headset Image After Time Expired in MDR Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "LCApologiesText"), "Apologies Text After Time Expired in MDR Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "LCReachUsText"), "Reach Us Text After Time Expired in MDR Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "LCStartNewChatButton"), "Start New Chat Button After Time Expired in MDR Not Found");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}*/
	
	@Test(priority = 5)
	public void checkMDRStartNewChat() {
		try {
			Thread.sleep(5000);
			Utility.findElement(driver, "LCStartNewChatButton").click();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}

}
