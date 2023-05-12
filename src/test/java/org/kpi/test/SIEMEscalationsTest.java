package org.kpi.test;

import org.kpi.properties.PropertiesFile;
import org.kpi.utility.DimensionUtil;
import org.kpi.utility.Platform;
import org.kpi.utility.Utility;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

public class SIEMEscalationsTest {

	private AppiumDriver<MobileElement> driver;
	boolean flag = Platform.IS_ANDROID;
	int count = 0;

	@BeforeMethod
	public void initiateDriver() {
		driver = TestConfig.getInstance().driver;
	}

	@Test(priority = 0)
	public void checkSIEMElements() {
		try {
			/*Thread.sleep(5000);
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
			Utility.findElement(driver, "EscalationsTabButton").click();*/
			Thread.sleep(5000);
			TouchAction tap = new TouchAction(driver);
			if(flag) {
				/*int width = (int) Math.round(DimensionUtil.getWidth(driver)*0.593);
				int height = (int) Math.round(DimensionUtil.getHeight(driver)*0.157);
				int width1 = (int) Math.round(DimensionUtil.getWidth(driver)*0.206);
				driver.swipe(width, height, width1, height, 1000);*/
				//driver.swipe(640, 346, 222, 342, 1000);
				Thread.sleep(3000);
				Utility.findElement(driver, "SIEMServiceButton").click();
				Thread.sleep(5000);
				Utility.findElement(driver, "siem_EscalationItemTile").click();
			}
			else {
				int width = (int) Math.round(DimensionUtil.getWidth(driver)*0.962);
				int height = (int) Math.round(DimensionUtil.getHeight(driver)*0.16);
				tap.tap(width, height).perform();
				//tap.tap(375, 135).perform();
				//
				Thread.sleep(5000);
				int width1 = (int) Math.round(DimensionUtil.getWidth(driver)*0.52);
				int height1 = (int) Math.round(DimensionUtil.getHeight(driver)*0.25);
				tap.tap(width1, height1).perform();
				//tap.tap(200, 210).perform();
			}
			Thread.sleep(5000);
			Assert.assertTrue(Utility.isElementPresent(driver, "SIEMDetailBackIcon"), "Notifications Tab Esclations Tab Back Icon Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "SIEMDetailTitle"), "Notifications Tab Esclation Tab Header Service Type Text Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "SIEMDetailSubTitle"), "Notifications Tab Esclation Tab Header Name Text Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "details"), "Details Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "Communication thread"),
					"Communication Thread Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "EsclationTabSeverityText"),
					"SIEM Esclation Tab Severity Text Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "escalationPriorityLabel"),
					"SIEM Esclation Tab Severity Level Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "EsclationTabStatusText"),
					"SIEM Esclation Tab Status Text Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "EsclationTabStatusColouredDot"),
					"SIEM Esclation Tab Status Coloured Dot Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "EsclationTabStatus"),
					"SIEM Esclation Tab Status Coloured Dot Text Not Found");

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
	public void checkSIEMCTElements() {
		try {
			Thread.sleep(5000);
			Utility.findElement(driver, "Communication thread").click();
			Thread.sleep(5000);
			Assert.assertTrue(Utility.isElementPresent(driver, "CTClosedTitle"),
					"SIEM Communication Preferences Disabled Message Text Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "CTClosedBody"),
					"SIEM Communication Preferences Live Chat Message Text Not Found");
			
			Thread.sleep(3000);
			Utility.findElement(driver, "SIEMDetailBackIcon").click();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
	
	@Test(priority = 2)
	public void checkSIEMInProgress() {
		try {
			Thread.sleep(5000);
			TouchAction tap = new TouchAction(driver);
			tap.tap(200, 200).perform();
			/*if(flag) {
				Utility.findElement(driver, "filterButton").click();
			}
			else {
				int width = (int) Math.round(DimensionUtil.getWidth(driver)*0.9);
				int height = (int) Math.round(DimensionUtil.getHeight(driver)*0.83);
				tap.tap(width, height).perform();
				//tap.tap(350, 700).perform();
			}
			Thread.sleep(3000);
			Utility.findElement(driver, "In ProgressCheckBox").click();
			Thread.sleep(3000);
			Utility.findElement(driver, "applyButton").click();
			Thread.sleep(5000);
			if(flag) {
				if(Utility.isElementPresent(driver, "siem_EscalationItemTile")) {
					count = 1;
				}
				else {
					count = 0;
					Utility.findElement(driver, "In ProgressLabelCloseButton").click();
				}
				
			}*/
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
	
	@Test(priority = 3)
	public void checkSIEMInProgressCT() {
		try {
			Thread.sleep(5000);
			TouchAction tap = new TouchAction(driver);
			tap.tap(200, 200).perform();
			/*if(count >= 1) {
				if(flag) {
					Utility.findElement(driver, "siem_EscalationItemTile").click();
				}
				else {
					int width1 = (int) Math.round(DimensionUtil.getWidth(driver)*0.52);
					int height1 = (int) Math.round(DimensionUtil.getHeight(driver)*0.31);
					tap.tap(width1, height1).perform();
					//tap.tap(200, 260).perform();
				}
				Thread.sleep(5000);
				Assert.assertTrue(Utility.isElementPresent(driver, "EsclationTabRemediatedButton"),
						"Esclation Tab Remediated Button Not Found");
				//CT Click for uploading files
				Thread.sleep(5000);
				Utility.findElement(driver, "Communication thread").click();
				Thread.sleep(5000);
				Utility.findElement(driver, "CTAttachIcon").click();//Sample10MB.mov  Sample.mov
				Thread.sleep(5000);
				if(flag) {
					tap.tap(848, 146).perform();
					Thread.sleep(3000);
					driver.findElement(By.id("com.google.android.documentsui:id/search_src_text")).sendKeys("Resume.docx");
					Thread.sleep(3000);
					driver.findElement(By.xpath("//android.widget.TextView[@text='Resume.docx']")).click();
					Thread.sleep(3000);
					Utility.findElement(driver, "ok").click();//Negative Testing in CT
					
					Thread.sleep(5000);
					Utility.findElement(driver, "CTAttachIcon").click();
					Thread.sleep(3000);
					tap.tap(848, 146).perform();
					Thread.sleep(3000);
					driver.findElement(By.id("com.google.android.documentsui:id/search_src_text")).sendKeys("sample");
					Thread.sleep(3000);
					driver.findElement(By.xpath("//android.widget.TextView[@text='Sample10MB.mov']")).click();
					Thread.sleep(3000);
					Utility.findElement(driver, "ok").click();
					Thread.sleep(5000);
					Utility.findElement(driver, "CTAttachIcon").click();//Sample10MB.mov  Sample.mov
					Thread.sleep(5000);
					tap.tap(848, 146).perform();
					Thread.sleep(3000);
					driver.findElement(By.id("com.google.android.documentsui:id/search_src_text")).sendKeys("sample");
					Thread.sleep(3000);
					driver.findElement(By.xpath("//android.widget.TextView[@text='Sample.mov']")).click();
				}
				else {
					int width = (int) Math.round(DimensionUtil.getWidth(driver)*0.34);
					int height = (int) Math.round(DimensionUtil.getHeight(driver)*0.1);
					int height1 = (int) Math.round(DimensionUtil.getHeight(driver)*0.8);
					driver.swipe(width, height, width, height1, 2000);
					//driver.swipe(130, 80, 130, 670, 2000);
				}
				
				Thread.sleep(3000);
				Utility.findElement(driver, "Type a message").sendKeys("Testing");
				Thread.sleep(3000);
				if(flag) {
					Utility.findElement(driver, "CTSendIcon").click();
				}
				else {
					Utility.findElement(driver, "send").click();
				}
			}*/
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
	
	@Test(priority = 4)
	public void checkSIEMMarkAsRemediated() {
		try {
			Thread.sleep(5000);
			TouchAction tap = new TouchAction(driver);
			tap.tap(200, 200).perform();
			/*if(count >= 1) {
				Thread.sleep(30000);
				Utility.findElement(driver, "details").click();
				Thread.sleep(5000);
				//Assign Button Click if available
				if (Utility.isElementPresent(driver, "EsclationTabAssignButton")) {
					Assert.assertTrue(Utility.isElementPresent(driver, "EsclationTabAssignButton"),
							"Esclation Tab Assign Button Not Found");
					Thread.sleep(3000);
					Utility.findElement(driver, "EsclationTabAssignButton").click();
					Thread.sleep(5000);
					Assert.assertTrue(Utility.isElementPresent(driver, "EsclationTabAssignedToHeading"),
							"Esclation Tab AssignedTo Heading Not Found");
					Assert.assertTrue(Utility.isElementPresent(driver, "EsclationTabAssignedToCloseIcon"),
							"Esclation Tab AssignedTo Close Icon Not Found");
			
					Assert.assertTrue(Utility.isElementPresent(driver, "EsclationTabAssignedToServiceImage"),
							"Esclation Tab AssignedTo Service Image Not Found");
					Assert.assertTrue(Utility.isElementPresent(driver, "EsclationTabAssignedToServiceName"),
							"Esclation Tab AssignedTo Service Name Not Found");
					Assert.assertTrue(Utility.isElementPresent(driver, "EsclationTabAssignedToSeverityLevel"),
							"Esclation Tab AssignedTo Severity Level Not Found");
					Assert.assertTrue(Utility.isElementPresent(driver, "EsclationTabAssignedToName"),
							"Esclation Tab AssignedTo Name Not Found");
					Assert.assertTrue(Utility.isElementPresent(driver, "EsclationTabAssignedToDate"),
							"Esclation Tab AssignedTo Date Not Found");
					Assert.assertTrue(Utility.isElementPresent(driver, "EsclationTabAssignedToAssignedUserText"),
							"Esclation Tab AssignedTo Assigned User Text Not Found");
					Assert.assertTrue(Utility.isElementPresent(driver, "EsclationTabAssignedToSearchIcon"),
							"Esclation Tab AssignedTo Search Icon Not Found");
					Assert.assertTrue(Utility.isElementPresent(driver, "EsclationTabAssignedToSearchInput"),
							"Esclation Tab AssignedTo Search Input Not Found");
					Assert.assertTrue(Utility.isElementPresent(driver, "EsclationTabAssignedToPersoneName"),
							"Esclation Tab AssignedTo Persone Name Not Found");
					Assert.assertTrue(Utility.isElementPresent(driver, "EsclationTabAssignedToSubmitButton"),
							"Esclation Tab AssignedTo Submit Button Not Found");
					Thread.sleep(3000);
					Utility.findElement(driver, "EsclationTabAssignedToSearchInput").sendKeys("pradeep");
					Thread.sleep(3000);
					if(flag) {
						Utility.findElement(driver, "EsclationTabAssignedToPersoneName").click();
					}
					else {
						int width2 = (int) Math.round(DimensionUtil.getWidth(driver)*0.51);
						int height2 = (int) Math.round(DimensionUtil.getHeight(driver)*0.387);
						tap.tap(width2, height2).perform();
					}
					Thread.sleep(3000);
					Utility.findElement(driver, "EsclationTabAssignedToSubmitButton").click();
					Thread.sleep(3000);
					if (Utility.isElementPresent(driver, "MDRDetailsAlertToastIcon")) {
						Assert.assertTrue(Utility.isElementPresent(driver, "MDRDetailsAlertToastIcon"),
								"MDR Details Alert Toast Icon Not Found");
						Assert.assertTrue(Utility.isElementPresent(driver, "MDRDetailsAlertToastMessage"),
								"MDR Details Alert Toast Message Text Not Found");
					}
					Thread.sleep(5000);
					Assert.assertTrue(Utility.isElementPresent(driver, "EsclationTabInformationEditIcon"),
							"Esclation Tab Information Edit Icon Not Found");
					Thread.sleep(3000);
					Utility.findElement(driver, "EsclationTabInformationEditIcon").click();
					Thread.sleep(5000);
					if (Utility.isElementPresent(driver, "EsclationTabAssignedToInputCloseIcon")) {
						Assert.assertTrue(Utility.isElementPresent(driver, "EsclationTabAssignedToInputCloseIcon"),
								"Esclation Tab AssignedTo Input Close Icon Not Found");
						Thread.sleep(3000);
						Utility.findElement(driver, "EsclationTabAssignedToInputCloseIcon").click();
					}
					Thread.sleep(3000);
					Utility.findElement(driver, "EsclationTabAssignedToSearchInput").sendKeys("pradeep");
					Thread.sleep(3000);
					if(flag) {
						Utility.findElement(driver, "EsclationTabAssignedToPersoneName").click();
					}
					else {
						int width2 = (int) Math.round(DimensionUtil.getWidth(driver)*0.51);
						int height2 = (int) Math.round(DimensionUtil.getHeight(driver)*0.387);
						tap.tap(width2, height2).perform();
					}
					Thread.sleep(3000);
					Utility.findElement(driver, "EsclationTabAssignedToSubmitButton").click();
				}
				Thread.sleep(3000);
				Utility.findElement(driver, "EsclationTabRemediatedButton").click();
				Thread.sleep(5000);
				Assert.assertTrue(Utility.isElementPresent(driver, "EsclationTabRemediationItemMarkAsRemidatedText"),
						"Mark As Remediated Heading Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "EsclationTabRemediationItemMarkAsRemidatedIcon"),
						"Mark As Remediated Screen Close Button Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "EsclationTabRemediationItemEscalationText"),
						"Esclation Tab Remediation Item Escalation Text Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "EsclationTabRemediationItemEscalationName"),
						"Esclation Tab Remediation Item Escalation Name Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "EsclationTabRemediationItemTimeCreatedText"),
						"Esclation Tab Remediation Item Time Created Text Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "EsclationTabRemediationItemTimeCreated"),
						"Esclation Tab Remediation Item Time Created Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "EsclationTabRemediationItemTextInput"),
						"Esclation Tab Remediation Item Text Input Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "EsclationTabRemediationItemUnderstandingFix"),
						"Esclation Tab Remediation Item Understanding Fix Text Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "EsclationTabRemediationItemAddAttachmentIconText"),
						"Esclation Tab Remediation Item Add Attachment Button Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "EsclationTabRemediationSubmitButton"),
						"Esclation Tab Remediation Submit Button Not Found");
				Thread.sleep(3000);
				Utility.findElement(driver, "EsclationTabRemediationItemTextInput").sendKeys("Testing");
				Thread.sleep(3000);
				Utility.findElement(driver, "EsclationTabRemediationItemAddAttachmentIconText").click();
				Thread.sleep(5000);
				if(flag) {
					tap.tap(848, 146).perform();
					Thread.sleep(3000);
					driver.findElement(By.id("com.google.android.documentsui:id/search_src_text")).sendKeys(".docx");
					Thread.sleep(3000);
					driver.findElement(By.xpath("//android.widget.TextView[@text='Resume.docx']")).click();
					Thread.sleep(3000);
					Utility.findElement(driver, "ok").click();//Negative Testing in Remediation
					
					Thread.sleep(5000);
					Utility.findElement(driver, "EsclationTabRemediationItemAddAttachmentIconText").click();
					Thread.sleep(3000);
					tap.tap(848, 146).perform();
					Thread.sleep(3000);
					driver.findElement(By.id("com.google.android.documentsui:id/search_src_text")).sendKeys("sample");
					Thread.sleep(3000);
					driver.findElement(By.xpath("//android.widget.TextView[@text='sample.pdf']")).click();
					Thread.sleep(3000);
					Assert.assertTrue(Utility.isElementPresent(driver, "imagePreviewIcon"), "Image Preview Icon Not Found");
					Assert.assertTrue(Utility.isElementPresent(driver, "imagePreviewFileName"), "Image Preview File Name Not Found");
					Assert.assertTrue(Utility.isElementPresent(driver, "imagePreviewCloseButton"), "Image Preview Close Button Not Found");
					Thread.sleep(3000);
					Utility.findElement(driver, "EsclationTabRemediationItemAddAttachmentIconText").click();
					Thread.sleep(5000);
					tap.tap(848, 146).perform();
					Thread.sleep(3000);
					driver.findElement(By.id("com.google.android.documentsui:id/search_src_text")).sendKeys("sample");
					Thread.sleep(3000);
					driver.findElement(By.xpath("//android.widget.TextView[@text='sample.pdf']")).click();
					Thread.sleep(3000);
					Utility.findElement(driver, "EsclationTabRemediationItemAddAttachmentIconText").click();
					Thread.sleep(5000);
					tap.tap(848, 146).perform();
					Thread.sleep(3000);
					driver.findElement(By.id("com.google.android.documentsui:id/search_src_text")).sendKeys("sample");
					Thread.sleep(3000);
					driver.findElement(By.xpath("//android.widget.TextView[@text='sample.pdf']")).click();
					Thread.sleep(3000);
					Utility.findElement(driver, "EsclationTabRemediationItemAddAttachmentIconText").click();
					Thread.sleep(5000);
					tap.tap(848, 146).perform();
					Thread.sleep(3000);
					driver.findElement(By.id("com.google.android.documentsui:id/search_src_text")).sendKeys("sample");
					Thread.sleep(3000);
					driver.findElement(By.xpath("//android.widget.TextView[@text='sample.pdf']")).click();
					Thread.sleep(3000);
					Utility.findElement(driver, "ok").click();
				}
				else {
					int width2 = (int) Math.round(DimensionUtil.getWidth(driver)*0.34);
					int height2 = (int) Math.round(DimensionUtil.getHeight(driver)*0.1);
					int height3 = (int) Math.round(DimensionUtil.getHeight(driver)*0.8);
					driver.swipe(width2, height2, width2, height3, 2000);
					//driver.swipe(130, 80, 130, 670, 2000);
				}
				Thread.sleep(3000);
				Utility.findElement(driver, "EsclationTabRemediationSubmitButton").click();
			}*/
			
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
	
	@Test(priority = 5)
	public void checkSIEMEscalationsFeedback() {
		try {
			/*if(count >= 1) {
				Thread.sleep(5000);
				Assert.assertTrue(Utility.isElementPresent(driver, "EsclationFeedbackTitleText"),
						"Esclation Feedback Title Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "EsclationFeedbackIsValuableText"),
						"Esclation Feedback Is Valuable Text Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "EsclationFeedbackThumbUpIconNo"),
						"Esclation Feedback Thumb Up Icon No In No Button Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "EsclationFeedbackNoText"),
						"Esclation Feedback Thumb Up Text No In No Button Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "EsclationFeedbackThumbUpIconYes"),
						"Esclation Feedback Thumb Up Icon Yes In No Button Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "EsclationFeedbackYesText"),
						"Esclation Feedback Thumb Up Text Yes In No Button Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "EsclationFeedbackCommentsTextInput"),
						"Esclation Feedback Comments Text Input Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "EsclationFeedbackSubmitButton"),
						"Esclation Feedback Submit Button Not Found");
			
				Thread.sleep(3000);
				Utility.findElement(driver, "EsclationFeedbackThumbUpIconNo").click();
				Thread.sleep(5000);
				Assert.assertTrue(Utility.isElementPresent(driver, "EsclationFeedbackWhyNotValidText"),
						"Esclation Feedback Why Not Valuable Text Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "False PositiveEsclationFeedbackReason"),
						"False Positive Esclation Feedback Reason Text Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "False PositiveEsclationFeedbackReasonDescription"),
						"False Positive Esclation Feedback Reason Description Text Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "Normal ActivityEsclationFeedbackReason"),
						"Normal Activity Esclation Feedback Reason Text Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "Normal ActivityEsclationFeedbackReasonDescription"),
						"Normal Activity Esclation Feedback Reason Description Text Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "Suppression CandidateEsclationFeedbackReason"),
						"Suppression Candidate Esclation Feedback Reason Text Not Found");
				Assert.assertTrue(
						Utility.isElementPresent(driver, "Suppression CandidateEsclationFeedbackReasonDescription"),
						"Suppression Candidate Esclation Feedback Reason Description Text Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "OtherEsclationFeedbackReason"),
						"Other Esclation Feedback Reason Text Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "OtherEsclationFeedbackReasonDescription"),
						"Other Esclation Feedback Reason Description Text Not Found");
				Thread.sleep(3000);
				Utility.findElement(driver, "False PositiveEsclationFeedbackReason").click();
				Thread.sleep(3000);
				Utility.findElement(driver, "Normal ActivityEsclationFeedbackReason").click();
				Thread.sleep(3000);
				Utility.findElement(driver, "Suppression CandidateEsclationFeedbackReason").click();
				Thread.sleep(3000);
				Utility.findElement(driver, "OtherEsclationFeedbackReason").click();
			
				Thread.sleep(3000);
				Utility.findElement(driver, "EsclationFeedbackThumbUpIconYes").click();
				Thread.sleep(3000);
				Utility.findElement(driver, "EsclationFeedbackCommentsTextInput").sendKeys("Testing");
				Thread.sleep(3000);
				Utility.findElement(driver, "EsclationFeedbackSubmitButton").click();
				Thread.sleep(3000);
				if (Utility.isElementPresent(driver, "MDRDetailsAlertToastIcon")) {
					Assert.assertTrue(Utility.isElementPresent(driver, "MDRDetailsAlertToastIcon"),
							"MDR Details Alert Toast Icon Not Found");
					Assert.assertTrue(Utility.isElementPresent(driver, "MDRDetailsAlertToastMessage"),
							"MDR Details Alert Toast Message Text Not Found");
				}
				Thread.sleep(3000);
				Assert.assertTrue(Utility.isElementPresent(driver, "EsclationTabInformationRemediatedByText"), "MDR Details Esclation Tab Information Remediated By Text Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "EsclationTabInformationRemediatedBy"), "MDR Details Esclation Tab Information Remediated By Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "EsclationTabInformationClientRemediationTimeText"), "MDR Details Esclation Tab Information Client Remediation Time Text Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "EsclationTabInformationClientRemediationTime"), "MDR Details Esclation Tab Information Client Remediation Time Not Found");
				
				Assert.assertTrue(Utility.isElementPresent(driver, "EsclationTabNotesText"), "MDR Details Esclation Tab Notes Text Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "EsclationTabNotesToggleIcon"), "MDR Details Esclation Tab Notes Toggle Icon Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "EsclationTabNotes"), "MDR Details Esclation Tab Notes Not Found");
				if(Utility.isElementPresent(driver, "EsclationTabNotesImageIcon")) {
					Assert.assertTrue(Utility.isElementPresent(driver, "EsclationTabNotesImageIcon"), "MDR Details Esclation Tab Notes Image Icon Not Found");
					Assert.assertTrue(Utility.isElementPresent(driver, "EsclationTabNotesImageName"), "MDR Details Esclation Tab Notes Image Name Not Found");
					Assert.assertTrue(Utility.isElementPresent(driver, "EsclationTabNotesDownloadIcon"), "MDR Details Esclation Tab Notes Download Icon Not Found");
				}
			}*/
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
	
	@Test(priority = 6)
	public void checkSIEM_CT() {
		try {
			/*if(count >= 1) {
				Thread.sleep(5000);
				TouchAction tap = new TouchAction(driver);
				Utility.findElement(driver, "Communication thread").click();
				Thread.sleep(5000);
				Assert.assertTrue(Utility.isElementPresent(driver, "CTClosedTitle"),
						"IOMT Communication Preferences Disabled Message Text Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "CTClosedBody"),
						"IOMT Communication Preferences Live Chat Message Text Not Found");
				Thread.sleep(3000);
				Utility.findElement(driver, "EsclationTabBackIcon").click();
				Thread.sleep(5000);
				if(flag) {
					Utility.findElement(driver, "In ProgressLabelCloseButton").click();
				}
				else {
					int width2 = (int) Math.round(DimensionUtil.getWidth(driver)*0.3);
					int height2 = (int) Math.round(DimensionUtil.getHeight(driver)*0.23);
					tap.tap(width2, height2).perform();
					//tap.tap(118, 193).perform();
				}
			}*/
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
}
