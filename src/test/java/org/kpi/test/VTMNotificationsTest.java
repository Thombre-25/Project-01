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

public class VTMNotificationsTest {

	private AppiumDriver<MobileElement> driver;
	boolean flag = Platform.IS_ANDROID;

	@BeforeMethod
	public void initiateDriver() {
		driver = TestConfig.getInstance().driver;
	}

	@Test(priority = 0)
	public void checkVTMNewGroupElements() {
		try {
			Thread.sleep(5000);
			TouchAction tap = new TouchAction(driver);
			if (flag) {
				Utility.findElement(driver, "VTMServiceButton").click();
				Thread.sleep(5000);
				Utility.findElement(driver, "vtm_NotificationItemTile_scan_completed").click();
			} else {
				int width = (int) Math.round(DimensionUtil.getWidth(driver) * 0.28);
				int height = (int) Math.round(DimensionUtil.getHeight(driver) * 0.16);
				tap.tap(width, height).perform();
				// tap.tap(108, 135).perform();
				Thread.sleep(3000);
				int width1 = (int) Math.round(DimensionUtil.getWidth(driver) * 0.36);
				int height1 = (int) Math.round(DimensionUtil.getHeight(driver) * 0.256);
				tap.tap(width1, height1).perform();
				// tap.tap(140, 216).perform();
			}
			
			Thread.sleep(5000);
			Assert.assertTrue(Utility.isElementPresent(driver, "vtmNewGroupBackButton"),
					"VTM New Group Back Button Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "vtmNewGroupServiceName"),
					"VTM New Group Service Name Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "vtmNewGroupTitle"), "VTM New Group Title Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "newGroupDesc"), "VTM New Group Description Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "loginBtn"), "VTM New Group Login Button Not Found");
			
			Thread.sleep(2000);
			if(!Utility.findElement(driver, "vtmNewGroupServiceName").getText().equals("VTM")) {
				Assert.assertTrue(false);
			}
			if(!Utility.findElement(driver, "vtmNewGroupTitle").getText().equals("New group is available")) {
				Assert.assertTrue(false);
			}
			if(!Utility.findElement(driver, "newGroupDesc").getText().equals("To check all the details go to web app")) {
				Assert.assertTrue(false);
			}
			
			Thread.sleep(5000);
			Utility.findElement(driver, "vtmNewGroupBackButton").click();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}

	/*@Test(priority = 1)
	public void checkVTMDetailsElements() {
		try {
			Thread.sleep(5000);
			if(flag) {
				driver.swipe(850, 1980, 850, 550, 1000);
				Thread.sleep(2000);
				driver.swipe(850, 1470, 850, 600, 1000);
				Thread.sleep(5000);
				Utility.findElement(driver, "vtm_NotificationItemTile_vulnerability_assignment").click();}
			else {
				driver.swipe(300, 700, 300, 200, 1000);
				Thread.sleep(2000);
				TouchAction tap = new TouchAction(driver);
				tap.tap(200, 600).perform();
			}
			
			Thread.sleep(10000);
			Assert.assertTrue(Utility.isElementPresent(driver, "VTMDetailBackIcon"), "VTM Detail Back Icon Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "VTMDetailTitle"), "VTM Detail Title Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "VTMDetailSubTitle"), "VTM Detail Sub Title Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "details"), "Details Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "Communication thread"), "Communication Thread Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "VTMDetailsTabSeverityText"), "VTM Details Tab Severity Text Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "escalationPriorityLabel"), "VTM Details Tab Severity Level Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "VTMDetailsTabStatusText"), "VTM Details Tab Status Text Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "EsclationTabStatusColouredDot"), "VTM Details Tab Status Coloured Dot Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "EsclationTabStatus"), "VTM Details Tab Status Coloured Dot Text Not Found");
			
			if(Utility.isElementPresent(driver, "informationText informationToggleIcon")) {
				if(flag) {
					Assert.assertTrue(Utility.isElementPresent(driver, "informationText"), "VTM Details Tab Information Text Not Found");
					Assert.assertTrue(Utility.isElementPresent(driver, "informationToggleIcon"), "VTM Details Tab Information Toggle Icon Not Found");
				}
				
				Assert.assertTrue(Utility.isElementPresent(driver, "AssignedToTitle"), "VTM Details Tab Assign To Text Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "AssignedToDescriptionValue"), "VTM Details Tab Assign To Not Found");
				Thread.sleep(2000);
				if(flag) {
					Utility.findElement(driver, "informationToggleIcon").click();
				}
				else {
					Utility.findElement(driver, "informationText informationToggleIcon").click();
				}
			}
			
			Thread.sleep(2000);
			if(Utility.isElementPresent(driver, "VTMDetailsTabHostCountText VTMDetailsTabHostCountImage")) {
				if(flag) {
					Assert.assertTrue(Utility.isElementPresent(driver, "VTMDetailsTabHostCountText"), "VTM Details Tab Host Count Text Not Found");
					Assert.assertTrue(Utility.isElementPresent(driver, "VTMDetailsTabHostCountImage"), "VTM Details Tab Host Count Image Not Found");
				}
				Assert.assertTrue(Utility.isElementPresent(driver, "VTMDetailsTabHostCount"), "VTM Details Tab Host Count Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "VTMDetailsTabHostViewText"), "VTM Details Tab Host View Text Not Found");
				Thread.sleep(2000);
				if(flag) {
					Utility.findElement(driver, "VTMDetailsTabHostCountImage").click();
				}
				else {
					Utility.findElement(driver, "VTMDetailsTabHostCountText VTMDetailsTabHostCountImage").click();
				}
			}
			
			Thread.sleep(2000);
			if(flag) {
				Assert.assertTrue(Utility.isElementPresent(driver, "synopsisText"), "VTM Details Tab Synopsis Text Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "synopsisToggleIcon"), "VTM Details Tab Synopsis Image Not Found");
			}
			Assert.assertTrue(Utility.isElementPresent(driver, "synopsisDescriptionValue"), "VTM Details Tab Synopsis Not Found");
			Thread.sleep(2000);
			if(flag) {
				Utility.findElement(driver, "synopsisToggleIcon").click();
			}
			else {
				Utility.findElement(driver, "synopsisText synopsisToggleIcon").click();
			}
			
			Thread.sleep(2000);
			if(flag) {
				Assert.assertTrue(Utility.isElementPresent(driver, "descriptionText"), "VTM Details Tab Description Text Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "descriptionToggleIcon"), "VTM Details Tab Description Image Not Found");
			}
			Assert.assertTrue(Utility.isElementPresent(driver, "descriptionDescriptionValue"), "VTM Details Tab Description Not Found");
			Thread.sleep(2000);
			if(flag) {
				Utility.findElement(driver, "descriptionToggleIcon").click();
			}
			else {
				Utility.findElement(driver, "descriptionText descriptionToggleIcon").click();
			}
			
			Thread.sleep(2000);
			if(flag) {
				Assert.assertTrue(Utility.isElementPresent(driver, "solutionText"), "VTM Details Tab Solution Text Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "solutionToggleIcon"), "VTM Details Tab Solution Image Not Found");
			}
			Assert.assertTrue(Utility.isElementPresent(driver, "solutionDescriptionValue"), "VTM Details Tab Solution Not Found");
			Thread.sleep(2000);
			if(flag) {
				Utility.findElement(driver, "solutionToggleIcon").click();
			}
			else {
				Utility.findElement(driver, "solutionText solutionToggleIcon").click();
			}
			
			Thread.sleep(2000);
			if(flag) {
				Assert.assertTrue(Utility.isElementPresent(driver, "referenceInformationText"), "VTM Details Tab Reference Information Text Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "referenceInformationToggleIcon"), "VTM Details Tab Reference Information Image Not Found");
			}
			Assert.assertTrue(Utility.isElementPresent(driver, "referenceInformationDescriptionValue"), "VTM Details Tab Reference Information Not Found");
			Thread.sleep(2000);
			if(flag) {
				Utility.findElement(driver, "referenceInformationToggleIcon").click();
			}
			else {
				Utility.findElement(driver, "referenceInformationText referenceInformationToggleIcon").click();
			}
			
			Thread.sleep(2000);
			if(flag) {
				Assert.assertTrue(Utility.isElementPresent(driver, "pluginDetailsText"), "VTM Details Tab Plugin Details Text Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "pluginDetailsToggleIcon"), "VTM Details Tab Plugin Details Image Not Found");
				Thread.sleep(2000);
				driver.swipe(800, 2000, 800, 1100, 2000);
			}
			else {
				Thread.sleep(2000);
				driver.swipe(300, 700, 300, 300, 2000);
			}
			Thread.sleep(2000);
			Assert.assertTrue(Utility.isElementPresent(driver, "pluginIDTitle"), "VTM Details Tab Plugin Details ID Text Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "pluginIDDescriptionValue"), "VTM Details Tab Plugin Details ID Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "fileNameTitle"), "VTM Details Tab Plugin Details File Name Text Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "fileNameDescriptionValue"), "VTM Details Tab Plugin Details File Name Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "versionTitle"), "VTM Details Tab Plugin Details Version Text Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "versionDescriptionValue"), "VTM Details Tab Plugin Details Version Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "typeTitle"), "VTM Details Tab Plugin Details File Type Text Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "typeDescriptionValue"), "VTM Details Tab Plugin Details Type Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "agentTitle"), "VTM Details Tab Plugin Details Agent Text Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "agentDescriptionValue"), "VTM Details Tab Plugin Details Agent Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "familyTitle"), "VTM Details Tab Plugin Details Family Text Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "familyDescriptionValue"), "VTM Details Tab Plugin Details Family Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "publishedTitle"), "VTM Details Tab Plugin Details Published Text Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "publishedDescriptionValue"), "VTM Details Tab Plugin Details Published Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "updatedTitle"), "VTM Details Tab Plugin Details Updated Text Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "updatedDescriptionValue"), "VTM Details Tab Plugin Details Updated Not Found");
			Thread.sleep(2000);
			if(flag) {
				Utility.findElement(driver, "pluginDetailsToggleIcon").click();
			}
			else {
				Utility.findElement(driver, "pluginDetailsText pluginDetailsToggleIcon").click();
			}
			
			Thread.sleep(2000);
			if(flag) {
				Assert.assertTrue(Utility.isElementPresent(driver, "vulnerabilityInformationText"), "VTM Details Tab Vulnerability Information Text Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "vulnerabilityInformationToggleIcon"), "VTM Details Tab Vulnerability Information Image Not Found");
			}
			Assert.assertTrue(Utility.isElementPresent(driver, "CPETitle"), "VTM Details Tab Vulnerability Information CPE Text Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "CPEDescriptionValue"), "VTM Details Tab Vulnerability Information CPE Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "exploitEaseTitle"), "VTM Details Tab Vulnerability Information Exploit Ease Text Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "exploitEaseDescriptionValue"), "VTM Details Tab Vulnerability Information Exploit Ease Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "patchPublicationDateTitle"), "VTM Details Tab Vulnerability Information Patch Publication Date Text Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "patchPublicationDateDescriptionValue"), "VTM Details Tab Vulnerability Information Patch Publication Date Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "vulnerabilityPublicationDateTitle"), "VTM Details Tab Vulnerability Information Vulnerability Publication Date Text Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "vulnerabilityPublicationDateDescriptionValue"), "VTM Details Tab Vulnerability Information Vulnerability Publication Date Not Found");
			Thread.sleep(2000);
			if(flag) {
				Utility.findElement(driver, "vulnerabilityInformationToggleIcon").click();
			}
			else {
				Utility.findElement(driver, "vulnerabilityInformationText vulnerabilityInformationToggleIcon").click();
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	
	}
	
	@Test(priority = 2)
	public void checkVTMCTElements() {
		try {
			Thread.sleep(5000);
			Utility.findElement(driver, "Communication thread").click();
			Thread.sleep(5000);
			Assert.assertTrue(Utility.isElementPresent(driver, "CTClosedTitle"), "VTM Communication Preferences Empty Message Text Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "CTClosedBody"), "VTM Communication Preferences Contact Text Not Found");
			Thread.sleep(3000);
			Utility.findElement(driver, "VTMDetailBackIcon").click();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}*/

}
