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

public class SIEMNotificationsTest {
	
	private AppiumDriver<MobileElement> driver;
	boolean flag = Platform.IS_ANDROID;
	
	@BeforeMethod
	public void initiateDriver() {
		driver = TestConfig.getInstance().driver;
	}
	
	@Test(priority = 1)
	public void checkSIEMTabElements() {
		try {
			Thread.sleep(5000);
			/*Utility.findElement(driver, "SettingsTabButton").click();
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
			Utility.findElement(driver, "NotificationsTabButton").click();*/
			Thread.sleep(5000);
			TouchAction tap = new TouchAction(driver);
			if(flag) {
				int width = (int) Math.round(DimensionUtil.getWidth(driver)*0.593);
				int height = (int) Math.round(DimensionUtil.getHeight(driver)*0.157);
				int width1 = (int) Math.round(DimensionUtil.getWidth(driver)*0.206);
				driver.swipe(width, height, width1, height, 1000);
				//driver.swipe(640, 346, 222, 342, 1000);
				Utility.findElement(driver, "SIEMServiceButton").click();
				Thread.sleep(5000);
				driver.swipe(900, 1000, 900, 650, 2000);
				Thread.sleep(5000);
				//Utility.findElement(driver, "siem_NotificationItemTile_escalation_assignment").click();
			}
			else {
				int swipe1 = (int) Math.round(DimensionUtil.getWidth(driver)*0.885);
				int swipe2 = (int) Math.round(DimensionUtil.getWidth(driver)*0.36);
				int width = (int) Math.round(DimensionUtil.getWidth(driver)*0.668);
				int height = (int) Math.round(DimensionUtil.getHeight(driver)*0.16);
				driver.swipe(swipe1, height, swipe2, height, 1000);
				Thread.sleep(3000);
				tap.tap(width, height).perform();
				//tap.tap(260, 139).perform();
				Thread.sleep(3000);
				int width1 = (int) Math.round(DimensionUtil.getWidth(driver)*0.52);
				int height1 = (int) Math.round(DimensionUtil.getHeight(driver)*0.27);
				tap.tap(width1, height1).perform();
				//tap.tap(200, 350).perform();
			}
			Thread.sleep(5000);
			Assert.assertTrue(Utility.isElementPresent(driver, "SIEMDetailBackIcon"), "Notifications Tab Esclations Tab Back Icon Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "SIEMDetailTitle"), "Notifications Tab Esclation Tab Header Service Type Text Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "SIEMDetailSubTitle"), "Notifications Tab Esclation Tab Header Name Text Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "details"), "Details Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "Communication thread"), "Communication Thread Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "EsclationTabSeverityText"), "Esclation Tab Severity Text Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "escalationPriorityLabel"), "Esclation Tab Severity Level Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "EsclationTabStatusText"), "Esclation Tab Status Text Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "EsclationTabStatusColouredDot"), "Esclation Tab Status Coloured Dot Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "EsclationTabStatus"), "Esclation Tab Status Coloured Dot Text Not Found");
			
			Thread.sleep(2000);
			if(!Utility.findElement(driver, "SIEMDetailTitle").getText().equals("SIEM")) {
				Assert.assertTrue(false);
			}
			if(!Utility.findElement(driver, "EsclationTabSeverityText").getText().equals("Severity")) {
				Assert.assertTrue(false);
			}
			if(!Utility.findElement(driver, "EsclationTabStatusText").getText().equals("Status")) {
				Assert.assertTrue(false);
			}
			
			Thread.sleep(3000);
			if(flag) {
				Assert.assertTrue(Utility.isElementPresent(driver, "informationText"), "IOMT Details Esclation Tab Information Text Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "informationToggleIcon"), "IOMT Details Esclation Tab Information Toggle Icon Not Found");
			}
			
			Assert.assertTrue(Utility.isElementPresent(driver, "TimeCreatedTitle"), "SIEM Details Esclation Tab Information Time Created Text Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "TimeCreatedDescriptionValue"), "SIEM Details Esclation Tab Information Time Created To Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "AssignedByTitle"), "SIEM Details Esclation Tab Information Assigned By Text Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "AssignedByDescriptionValue"), "SIEM Details Esclation Tab Information Assigned By Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "AcknowledgedByTitle"), "SIEM Details Esclation Tab Information Acknowledged By Text Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "AcknowledgedByDescriptionValue"), "SIEM Details Esclation Tab Information Acknowledged By Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "AcknowledgedTimeTitle"), "SIEM Details Esclation Tab Information Client Ack Time Text Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "AcknowledgedTimeDescriptionValue"), "SIEM Details Esclation Tab Information Client Ack Time Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "AssignedToTitle"), "SIEM Details Esclation Tab Information Assigned To Text Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "AssignedToDescriptionValue"), "SIEM Details Esclation Tab Information Assigned To Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "RemediatedByTitle"), "SIEM Details Esclation Tab Information Remediated By Text Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "RemediatedByDescriptionValue"), "SIEM Details Esclation Tab Information Remediated By Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "RemediationTimeTitle"), "SIEM Details Esclation Tab Information Client Remediation Time Text Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "RemediatedByDescriptionValue"), "SIEM Details Esclation Tab Information Client Remediation Time Not Found");
			
			Thread.sleep(2000);
			if(!Utility.findElement(driver, "informationText").getText().equals("INFORMATION")) {
				Assert.assertTrue(false);
			}
			if(!Utility.findElement(driver, "TimeCreatedTitle").getText().equals("Time Created")) {
				Assert.assertTrue(false);
			}
			if(!Utility.findElement(driver, "AssignedByTitle").getText().equals("Assigned By")) {
				Assert.assertTrue(false);
			}
			if(!Utility.findElement(driver, "AcknowledgedByTitle").getText().equals("Acknowledged By")) {
				Assert.assertTrue(false);
			}
			if(!Utility.findElement(driver, "AcknowledgedTimeTitle").getText().equals("Client Acknowledgement Time")) {
				Assert.assertTrue(false);
			}
			if(!Utility.findElement(driver, "AssignedToTitle").getText().equals("Assigned To")) {
				Assert.assertTrue(false);
			}
			if(!Utility.findElement(driver, "RemediatedByTitle").getText().equals("Remediated By")) {
				Assert.assertTrue(false);
			}
			if(!Utility.findElement(driver, "RemediationTimeTitle").getText().equals("Client Remediation Time")) {
				Assert.assertTrue(false);
			}
			
			Thread.sleep(2000);
			if(flag) {
				Utility.findElement(driver, "informationToggleIcon").click();
			}
			else {
				Utility.findElement(driver, "informationText informationToggleIcon").click();
			}
			
			Thread.sleep(2000);
			if(flag) {
				Assert.assertTrue(Utility.isElementPresent(driver, "notesText"), "SIEM Details Esclation Tab Notes Text Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "notesToggleIcon"), "SIEM Details Esclation Tab Notes Toggle Icon Not Found");
			}
			Assert.assertTrue(Utility.isElementPresent(driver, "notesDescriptionValue"), "SIEM Details Esclation Tab Notes Not Found");
			
			Thread.sleep(2000);
			if(!Utility.findElement(driver, "notesText").getText().equals("NOTES")) {
				Assert.assertTrue(false);
			}
			
			Thread.sleep(2000);
			if(flag) {
				Utility.findElement(driver, "notesToggleIcon").click();
			}
			else {
				Utility.findElement(driver, "notesText notesToggleIcon").click();
			}
			
			Thread.sleep(2000);
			if(flag) {
				Assert.assertTrue(Utility.isElementPresent(driver, "descriptionText"), "SIEM Details Esclation Tab What Is It Text Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "descriptionToggleIcon"), "SIEM Details Esclation Tab What Is It Toggle Icon Not Found");
			}
			Assert.assertTrue(Utility.isElementPresent(driver, "descriptionDescriptionValue"), "SIEM Details Esclation Tab What Is It Description Not Found");
			
			Thread.sleep(2000);
			if(!Utility.findElement(driver, "descriptionText").getText().equals("WHAT IS IT")) {
				Assert.assertTrue(false);
			}
			
			Thread.sleep(2000);
			if(flag) {
				Utility.findElement(driver, "descriptionToggleIcon").click();
			}
			else {
				Utility.findElement(driver, "descriptionText descriptionToggleIcon").click();
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
	
	@Test(priority = 2)
	public void checkSIEMTabCT() {
		try {
			Thread.sleep(5000);
			Utility.findElement(driver, "Communication thread").click();
			Thread.sleep(5000);
			Assert.assertTrue(Utility.isElementPresent(driver, "CTClosedTitle"), "SIEM Communication Preferences Disabled Message Text Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "CTClosedBody"), "SIEM Communication Preferences Live Chat Message Text Not Found");
			
			Thread.sleep(2000);
			if(!Utility.findElement(driver, "CTClosedTitle").getText().equals("The communication thread is disabled for closed items.")) {
				Assert.assertTrue(false);
			}
			if(!Utility.findElement(driver, "CTClosedBody").getText().equals("If you have a question about this item please feel free to utilize the Live Chat feature to chat with a Threat Analyst.")) {
				Assert.assertTrue(false);
			}
			
			Thread.sleep(3000);
			Utility.findElement(driver, "SIEMDetailBackIcon").click();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}

}
