package org.kpi.test;

import org.kpi.utility.Utility;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class SIEMLiveChatTest {
	
	private AppiumDriver<MobileElement> driver;
	//private boolean flag = Platform.IS_ANDROID;
	
	@BeforeMethod
	public void initiateDriver() {
		driver = TestConfig.getInstance().driver;
	}
	
	@Test(priority = 0)
	public void checkSIEMElements() {
		try {
			/*Thread.sleep(5000);
			Utility.findElement(driver, "LCCloseButton").click();
			Thread.sleep(5000);
			Utility.findElement(driver, "SettingsTabButton").click();
			Thread.sleep(5000);
			Utility.findElement(driver, "logOutMenuButton").click();
			Thread.sleep(5000);
			Utility.findElement(driver, "logoutYesButton").click();
			Thread.sleep(10000);
			Utility.findElement(driver, "usernameInput").sendKeys("user_clientc");
			Thread.sleep(2000);
			Utility.findElement(driver, "nextButton").click();
			Thread.sleep(10000);
			Utility.findElement(driver, "passwordInput").sendKeys(PropertiesFile.getInstance().getPassword());
			Thread.sleep(2000);
			Utility.findElement(driver, "loginButton").click();
			Thread.sleep(20000);
			Utility.findElement(driver, "LiveChatButton").click();*/
			Thread.sleep(5000);
			Utility.findElement(driver, "SIEMServiceButton").click();
			Thread.sleep(5000);
			Assert.assertTrue(Utility.isElementPresent(driver, "LCHeading"), "Live Chat Heading in SIEM Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "LCHistoryButton"), "Chat History Button in SIEM Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "LCEndChatButton"), "End Chat Button in SIEM Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "LCMinimizeButton"), "Minimize Button in SIEM Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "LCChatStartedText"), "IOMT Chat Started Text in SIEM Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "LCAnalystConnectingText"), "Analyst Connect Text in SIEM Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "LCChatEndTimer"), "Timer for Chat End in SIEM Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "Type a message..."), "Message Input Box in SIEM Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "send"), "Send Button in SIEM Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "LCCharacterCountText"), "Characters Remaining Text Not Found");
			
			Thread.sleep(2000);
			if(!Utility.findElement(driver, "LCChatStartedText").getText().contains("SIEM chat started - ")) {
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
	public void checkSIEMMinimizeButton() {
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
	public void checkSIEMEndChatButton() {
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
	public void checkSIEMSendMessage() {
		try {
			Thread.sleep(5000);
			Utility.findElement(driver, "LiveChatButton").click();
			Thread.sleep(3000);
			Utility.findElement(driver, "SIEMServiceButton").click();
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
	public void checkSIEMTimerEndChat() {
		try {
			Thread.sleep(300000);
			Assert.assertTrue(Utility.isElementPresent(driver, "LCHeadsetImage"), "Headset Image After Time Expired in SIEM Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "LCApologiesText"), "Apologies Text After Time Expired in SIEM Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "LCReachUsText"), "Reach Us Text After Time Expired in SIEM Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "LCStartNewChatButton"), "Start New Chat Button After Time Expired in SIEM Not Found");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}*/
	
	@Test(priority = 5)
	public void checkStartNewChat() {
		try {
			Thread.sleep(5000);
			Utility.findElement(driver, "LCStartNewChatButton").click();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}

}