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

public class IOMTNotificationsTest {
	
	private AppiumDriver<MobileElement> driver;
	boolean flag = Platform.IS_ANDROID;
	
	@BeforeMethod
	public void initiateDriver() {
		driver = TestConfig.getInstance().driver;
	}
	
	@Test(priority = 0)
	public void checkIOMTTabElements() {
		try {
			Thread.sleep(10000);
			TouchAction tap = new TouchAction(driver);
			if(flag) {
				Thread.sleep(5000);
				Utility.findElement(driver, "IOMTServiceButton").click();
				Thread.sleep(15000);
				//Utility.findElement(driver, "iomt_NotificationItemTile_escalation_assignment").click();
			}
			else {
				int width = (int) Math.round(DimensionUtil.getWidth(driver)*0.462);
				int height = (int) Math.round(DimensionUtil.getHeight(driver)*0.16);
				tap.tap(width, height).perform();
				//tap.tap(180, 139).perform();
				Thread.sleep(3000);
				int width1 = (int) Math.round(DimensionUtil.getWidth(driver)*0.52);
				int height1 = (int) Math.round(DimensionUtil.getHeight(driver)*0.27);
				tap.tap(width1, height1).perform();
				//tap.tap(200, 230).perform();
			}
			
			Thread.sleep(5000);
			Assert.assertTrue(Utility.isElementPresent(driver, "IOMTDetailBackIcon"), "Notifications Tab Esclations Tab Back Icon Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "IOMTDetailTitle"), "Notifications Tab Esclation Tab Header Service Type Text Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "IOMTDetailSubTitle"), "Notifications Tab Esclation Tab Header Name Text Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "details"), "Details Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "Communication thread"), "Communication Thread Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "EsclationTabSeverityText"), "IOMT Esclation Tab Severity Text Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "escalationPriorityLabel"), "IOMT Esclation Tab Severity Level Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "EsclationTabStatusText"), "IOMT Esclation Tab Status Text Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "EsclationTabStatusColouredDot"), "IOMT Esclation Tab Status Coloured Dot Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "EsclationTabStatus"), "IOMT Esclation Tab Status Coloured Dot Text Not Found");
			
			Thread.sleep(2000);
			if(!Utility.findElement(driver, "IOMTDetailTitle").getText().equals("IOMT")) {
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
			
			Assert.assertTrue(Utility.isElementPresent(driver, "TimeCreatedTitle"), "IOMT Details Esclation Tab Information Time Created Text Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "TimeCreatedDescriptionValue"), "IOMT Details Esclation Tab Information Time Created To Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "AssignedByTitle"), "IOMT Details Esclation Tab Information Assigned By Text Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "AssignedByDescriptionValue"), "IOMT Details Esclation Tab Information Assigned By Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "AcknowledgedByTitle"), "IOMT Details Esclation Tab Information Acknowledged By Text Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "AcknowledgedByDescriptionValue"), "IOMT Details Esclation Tab Information Acknowledged By Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "AcknowledgedTimeTitle"), "IOMT Details Esclation Tab Information Client Ack Time Text Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "AcknowledgedTimeDescriptionValue"), "IOMT Details Esclation Tab Information Client Ack Time Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "AssignedToTitle"), "IOMT Details Esclation Tab Information Assigned To Text Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "AssignedToDescriptionValue"), "IOMT Details Esclation Tab Information Assigned To Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "RemediatedByTitle"), "IOMT Details Esclation Tab Information Remediated By Text Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "RemediatedByDescriptionValue"), "IOMT Details Esclation Tab Information Remediated By Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "RemediationTimeTitle"), "IOMT Details Esclation Tab Information Client Remediation Time Text Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "RemediatedByDescriptionValue"), "IOMT Details Esclation Tab Information Client Remediation Time Not Found");
			
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
				Assert.assertTrue(Utility.isElementPresent(driver, "notesText"), "IOMT Details Esclation Tab Notes Text Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "notesToggleIcon"), "IOMT Details Esclation Tab Notes Toggle Icon Not Found");
			}
			Assert.assertTrue(Utility.isElementPresent(driver, "notesDescriptionValue"), "IOMT Details Esclation Tab Notes Not Found");
			
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
				Assert.assertTrue(Utility.isElementPresent(driver, "descriptionText"), "IOMT Details Esclation Tab What Is It Text Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "descriptionToggleIcon"), "IOMT Details Esclation Tab What Is It Toggle Icon Not Found");
			}
			Assert.assertTrue(Utility.isElementPresent(driver, "descriptionDescriptionValue"), "IOMT Details Esclation Tab What Is It Description Not Found");
			
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
	
	@Test(priority = 1)
	public void checkIOMTTabCTElements() {
		try {
			Thread.sleep(5000);
			Utility.findElement(driver, "Communication thread").click();
			Thread.sleep(5000);
			Assert.assertTrue(Utility.isElementPresent(driver, "CTClosedTitle"), "IOMT Communication Preferences Disabled Message Text Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "CTClosedBody"), "IOMT Communication Preferences Live Chat Message Text Not Found");
			
			Thread.sleep(2000);
			if(!Utility.findElement(driver, "CTClosedTitle").getText().equals("The communication thread is disabled for closed items.")) {
				Assert.assertTrue(false);
			}
			if(!Utility.findElement(driver, "CTClosedBody").getText().equals("If you have a question about this item please feel free to utilize the Live Chat feature to chat with a Threat Analyst.")) {
				Assert.assertTrue(false);
			}
			
			Thread.sleep(3000);
			Utility.findElement(driver, "IOMTDetailBackIcon").click();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
	
	@Test(priority = 2)
	public void checkIOMTAssignedDetails() {
		try {
			Thread.sleep(5000);
			TouchAction tap = new TouchAction(driver);
			if(flag) {
				//Utility.findElement(driver, "iomt_NotificationItemTile_escalation_assignment").click();
			}
			else {
				int width1 = (int) Math.round(DimensionUtil.getWidth(driver)*0.52);
				int height1 = (int) Math.round(DimensionUtil.getHeight(driver)*0.42);
				tap.tap(width1, height1).perform();
				//tap.tap(140, 600).perform();
			}
			
			Thread.sleep(5000);
			Assert.assertTrue(Utility.isElementPresent(driver, "IOMTDetailBackIcon"), "Notifications Tab Esclations Tab Back Icon Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "IOMTDetailTitle"), "Notifications Tab Esclation Tab Header Service Type Text Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "IOMTDetailSubTitle"), "Notifications Tab Esclation Tab Header Name Text Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "details"), "Details Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "Communication thread"), "Communication Thread Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "EsclationTabSeverityText"), "IOMT Esclation Tab Severity Text Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "escalationPriorityLabel"), "IOMT Esclation Tab Severity Level Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "EsclationTabStatusText"), "IOMT Esclation Tab Status Text Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "EsclationTabStatusColouredDot"), "IOMT Esclation Tab Status Coloured Dot Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "EsclationTabStatus"), "IOMT Esclation Tab Status Coloured Dot Text Not Found");
			
			Thread.sleep(3000);
			if(flag) {
				Assert.assertTrue(Utility.isElementPresent(driver, "informationText"), "IOMT Details Esclation Tab Information Text Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "informationToggleIcon"), "IOMT Details Esclation Tab Information Toggle Icon Not Found");
			}
			
			Assert.assertTrue(Utility.isElementPresent(driver, "TimeCreatedTitle"), "IOMT Details Esclation Tab Information Time Created Text Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "TimeCreatedDescriptionValue"), "IOMT Details Esclation Tab Information Time Created To Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "AssignedByTitle"), "IOMT Details Esclation Tab Information Assigned By Text Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "AssignedByDescriptionValue"), "IOMT Details Esclation Tab Information Assigned By Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "AcknowledgedByTitle"), "IOMT Details Esclation Tab Information Acknowledged By Text Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "AcknowledgedByDescriptionValue"), "IOMT Details Esclation Tab Information Acknowledged By Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "AcknowledgedTimeTitle"), "IOMT Details Esclation Tab Information Client Ack Time Text Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "AcknowledgedTimeDescriptionValue"), "IOMT Details Esclation Tab Information Client Ack Time Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "AssignedToTitle"), "IOMT Details Esclation Tab Information Assigned To Text Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "AssignedToDescriptionValue"), "IOMT Details Esclation Tab Information Assigned To Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "RemediatedByTitle"), "IOMT Details Esclation Tab Information Remediated By Text Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "RemediatedByDescriptionValue"), "IOMT Details Esclation Tab Information Remediated By Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "RemediationTimeTitle"), "IOMT Details Esclation Tab Information Client Remediation Time Text Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "RemediatedByDescriptionValue"), "IOMT Details Esclation Tab Information Client Remediation Time Not Found");
			
			Thread.sleep(2000);
			if(flag) {
				Utility.findElement(driver, "informationToggleIcon").click();
			}
			else {
				Utility.findElement(driver, "informationText informationToggleIcon").click();
			}
			
			Thread.sleep(2000);
			if(flag) {
				Assert.assertTrue(Utility.isElementPresent(driver, "notesText"), "IOMT Details Esclation Tab Notes Text Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "notesToggleIcon"), "IOMT Details Esclation Tab Notes Toggle Icon Not Found");
			}
			Assert.assertTrue(Utility.isElementPresent(driver, "notesDescriptionValue"), "IOMT Details Esclation Tab Notes Not Found");
			Thread.sleep(2000);
			if(flag) {
				Utility.findElement(driver, "notesToggleIcon").click();
			}
			else {
				Utility.findElement(driver, "notesText notesToggleIcon").click();
			}
			
			Thread.sleep(2000);
			if(flag) {
				Assert.assertTrue(Utility.isElementPresent(driver, "descriptionText"), "IOMT Details Esclation Tab What Is It Text Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "descriptionToggleIcon"), "IOMT Details Esclation Tab What Is It Toggle Icon Not Found");
			}
			Assert.assertTrue(Utility.isElementPresent(driver, "descriptionDescriptionValue"), "IOMT Details Esclation Tab What Is It Description Not Found");
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
	
	@Test(priority = 3)
	public void checkIOMTAssignedCT() {
		try {
			Thread.sleep(5000);
			Utility.findElement(driver, "Communication thread").click();
			Thread.sleep(5000);
			Assert.assertTrue(Utility.isElementPresent(driver, "CTClosedTitle"), "IOMT Communication Preferences Disabled Message Text Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "CTClosedBody"), "IOMT Communication Preferences Live Chat Message Text Not Found");
			
			Thread.sleep(3000);
			Utility.findElement(driver, "IOMTDetailBackIcon").click();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}

}