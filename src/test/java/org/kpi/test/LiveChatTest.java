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

public class LiveChatTest {
	
	private AppiumDriver<MobileElement> driver;
	boolean flag = Platform.IS_ANDROID;
	
	@BeforeMethod
	public void initiateDriver() {
		driver = TestConfig.getInstance().driver;
	}
	
	@Test(priority = 0)
	public void checkLiveChatElements() {
		
		try {
			Thread.sleep(10000);
			/*Utility.findElement(driver, "usernameInput").sendKeys(PropertiesFile.getInstance().getUsername());
			Thread.sleep(2000);
			Utility.findElement(driver, "nextButton").click();
			Thread.sleep(10000);
			Utility.findElement(driver, "passwordInput").sendKeys(PropertiesFile.getInstance().getPassword());
			Thread.sleep(2000);
			Utility.findElement(driver, "loginButton").click();
			Thread.sleep(20000);*/
			if(flag) {
				Utility.findElement(driver, "LiveChatButton").click();
			}
			else {
				TouchAction tap = new TouchAction(driver);
				int width = (int) Math.round(DimensionUtil.getWidth(driver)*0.425);
				int height = (int) Math.round(DimensionUtil.getHeight(driver)*0.305);
				tap.tap(width, height).perform();
				tap.tap(356, 73).perform();
			}
			Thread.sleep(5000);
			Assert.assertTrue(Utility.isElementPresent(driver, "LCHeading"), "Live Chat Heading Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "LCHistoryButton"), "Chat History Button Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "LCCloseButton"), "Live Chat Close Button Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "LCBannerImage"), "Image in Live Chat Screen Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "LCWelcomeText"), "Welcome Text Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "LCDescriptionText"), "Description Text in Live Chat Screen Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "LCQuestionText"), "Question Text in Live Chat Screen Not Found");
			
			Thread.sleep(2000);
			if(!Utility.findElement(driver, "LCWelcomeText").getText().contains("Welcome,")) {
				Assert.assertTrue(false);
			}
			if(!Utility.findElement(driver, "LCDescriptionText").getText().equals("Connect live with one of our Threat Analysts to discuss an escalation or ask a question")) {
				Assert.assertTrue(false);
			}
			if(!Utility.findElement(driver, "LCQuestionText").getText().equals("What can we help you with?")) {
				Assert.assertTrue(false);
			}
			
			Thread.sleep(2000);
			if(Utility.isElementPresent(driver, "SIEMServiceButton")) {
				Assert.assertTrue(Utility.isElementPresent(driver, "SIEMServiceButton"), "SIEM Service Button Not Found");
			}
			if(Utility.isElementPresent(driver, "IOMTServiceButton")) {
				Assert.assertTrue(Utility.isElementPresent(driver, "IOMTServiceButton"), "IOMT Service Button Not Found");
			}
			if(Utility.isElementPresent(driver, "MDRServiceButton")) {
				Assert.assertTrue(Utility.isElementPresent(driver, "MDRServiceButton"), "MDR Service Button Not Found");
			}
			if(Utility.isElementPresent(driver, "VTMServiceButton")) {
				Assert.assertTrue(Utility.isElementPresent(driver, "VTMServiceButton"), "VTM Service Button Not Found");
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
		
	}

}
