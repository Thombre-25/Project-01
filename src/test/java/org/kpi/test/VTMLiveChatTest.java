package org.kpi.test;

import org.kpi.utility.DateUtil;
import org.kpi.utility.Utility;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class VTMLiveChatTest {

	private AppiumDriver<MobileElement> driver;
	boolean isVTMLive = DateUtil.isVTMLive();

	@BeforeMethod
	public void initiateDriver() {
		driver = TestConfig.getInstance().driver;
	}

	@Test(priority = 0)
	public void VTMElements() {
		try {
			System.out.println("Is VTM Live :: "+isVTMLive);
			Thread.sleep(5000);
			Utility.findElement(driver, "VTMServiceButton").click();
			Thread.sleep(10000);
			Assert.assertTrue(Utility.isElementPresent(driver, "LCHeading"), "Live Chat Heading in VTM Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "LCHistoryButton"), "Chat History Button in VTM Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "LCClockImage"), "Clock Image in VTM Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "LCNonWorkingHoursText"), "Chat Hours in VTM Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "LCCharacterCountText"), "Characters Remaining Text in VTM Not Found");
			
			Thread.sleep(2000);
			if(!Utility.findElement(driver, "LCNonWorkingHoursText").getText().equals("Chat Hours")) {
				Assert.assertTrue(false);
			}
			if(!Utility.findElement(driver, "LCCharacterCountText").getText().equals("500 Characters Remaining")) {
				Assert.assertTrue(false);
			}
			
			if(isVTMLive) {
				Assert.assertTrue(Utility.isElementPresent(driver, "LCEndChatButton"), "End Chat Button in VTM Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "LCMinimizeButton"), "Minimize Button in VTM Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "LCNWAvailabilityText"), "VTM Live Chat Availability Text in VTM Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "LCNWAnalystNotAvailableText"), "Analyst Not Available Text in VTM Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "LCChatStartedText"), "IOMT Chat Started Text in IOMT Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "LCAnalystConnectingText"), "Analyst Connect Text in IOMT Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "LCChatEndTimer"), "Timer for Chat End in IOMT Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "Type a message..."), "Message Input Box in IOMT Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "send"), "Send Button in IOMT Not Found");
				
				Thread.sleep(2000);
				if(!Utility.findElement(driver, "LCNWAvailabilityText").getText().equals("VTM Live Chat Availability")) {
					Assert.assertTrue(false);
				}
				if(!Utility.findElement(driver, "LCNWAnalystNotAvailableText").getText().equals("Our Threat Analysts are often busy working to assist clients.")) {
					Assert.assertTrue(false);
				}
				if(!Utility.findElement(driver, "LCChatStartedText").getText().contains("VTM chat started - ")) {
					Assert.assertTrue(false);
				}
				if(!Utility.findElement(driver, "LCAnalystConnectingText").getText().contains("Connecting a Threat Analyst - ")) {
					Assert.assertTrue(false);
				}
				if(!Utility.findElement(driver, "Type a message...").getText().equals("Type a message...")) {
					Assert.assertTrue(false);
				}
			}
			else {
				Assert.assertTrue(Utility.isElementPresent(driver, "LCCloseButton"), "End Chat Button in VTM Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "LCNonWorkingApologiesText"), "Apologies Text in VTM Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "LCNonWorkingTextInputBox"), "Message Input Box in VTM Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "LCSendMessageButton"), "Send Message Button in VTM Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "LCStartNewChatButton"), "Start New Chat Button in VTM Not Found");
				
				Thread.sleep(2000);
				if(!Utility.findElement(driver, "LCNonWorkingApologiesText").getText().equals("Our apologies for the inconvenience, it looks like you’ve reached us outside our VTM chat hours.")) {
					Assert.assertTrue(false);
				}
				if(!Utility.findElement(driver, "LCNonWorkingTextInputBox").getText().equals("Type a message here *")) {
					Assert.assertTrue(false);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 1)
	public void checkVTMSendMessage() {
		try {
			Thread.sleep(5000);
			if(isVTMLive) {
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
			}
			else {
				Utility.findElement(driver, "LCNonWorkingTextInputBox").sendKeys("Testing");
				Thread.sleep(3000);
				Utility.findElement(driver, "LCSendMessageButton").click();
				Thread.sleep(5000);
				Assert.assertTrue(Utility.isElementPresent(driver, "LCMessageIcon"), "Message Icon in VTM Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "LCMessageSentSuccessfullyText"), "Message Sent Successfully Text in VTM Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "LCThankYouText"), "Thank You Text in VTM Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "LCStartNewChatButton"), "Start New Chat Button in VTM Not Found");
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 2)
	public void checkVTMStartNewChat() {
		try {
			Thread.sleep(5000);
			Utility.findElement(driver, "LCStartNewChatButton").click();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}

}
