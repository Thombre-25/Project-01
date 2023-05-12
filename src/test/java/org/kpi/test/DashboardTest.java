package org.kpi.test;

import org.kpi.properties.PropertiesFile;
import org.kpi.utility.Platform;
import org.kpi.utility.Utility;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class DashboardTest {

	private AppiumDriver<MobileElement> driver;
	boolean flag = Platform.IS_ANDROID;

	@BeforeMethod
	public void initiateDriver() {
		driver = TestConfig.getInstance().driver;
	}

	@Test(priority = 0)
	public void checkDashboardScreenElements() {
		try {
			Thread.sleep(10000);
			/*TouchAction tap = new TouchAction(driver);
			tap.tap(200, 200);*/
			//EnvironmentUtil.changeEnvironment(driver);
			Thread.sleep(5000);
			if(flag) {
				Utility.findElement(driver, "usernameInput").clear();
			}
			else {
				Utility.clearText(driver, "usernameInput");
			}
			Utility.findElement(driver, "usernameInput").sendKeys(PropertiesFile.getInstance().getUsername());
			Thread.sleep(2000);
			Utility.findElement(driver, "nextButton").click();
			Thread.sleep(5000);
			Utility.findElement(driver, "passwordInput").sendKeys(PropertiesFile.getInstance().getPassword());
			Thread.sleep(2000);
			Utility.findElement(driver, "loginButton").click();
			Thread.sleep(20000);
			if(flag) {
				Assert.assertTrue(Utility.isElementPresent(driver, "dashboardHeading"), "Dashboard Heading is Not Found");
			}
			if (Utility.isElementPresent(driver, "VTMTile")) {
				Assert.assertTrue(Utility.isElementPresent(driver, "VTMTile"), "VTM Tile is Not Found");
			}
			if (Utility.isElementPresent(driver, "SIEMTile")) {
				Assert.assertTrue(Utility.isElementPresent(driver, "SIEMTile"), "SIEM Tile is Not Found");
			}
			if (Utility.isElementPresent(driver, "IOMTTile")) {
				Assert.assertTrue(Utility.isElementPresent(driver, "IOMTTile"), "IOMT Tile is Not Found");
			}
			if (Utility.isElementPresent(driver, "MDRTile")) {
				Assert.assertTrue(Utility.isElementPresent(driver, "MDRTile"), "MDR Tile is Not Found");
			}
			if (Utility.isElementPresent(driver, "emptyDashboardCard")) {
				Assert.assertTrue(Utility.isElementPresent(driver, "emptyDashboardCard"), "MDR Tile is Not Found");
			}
			Thread.sleep(3000);
			if(Utility.isElementPresent(driver, "VTMTile")) {
				Assert.assertTrue(Utility.isElementPresent(driver, "VtmTitle"), "VTM Title is Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "VTMTotalVulnerabilities"), "VTM Total Vulnerabilities is Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "VTMTotalVulnerabilitiesText"), "VTM Vulnerabilities Text is Not Found");
			}
			if(flag) {
				Utility.findElement(driver, "dashboardHeading").click();
			}
			Thread.sleep(3000);
			if(Utility.isElementPresent(driver, "SIEMTile")) {
				Assert.assertTrue(Utility.isElementPresent(driver, "SiemTitle"), "SIEM Title is Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "SIEMTotalEscalatedAlarms"), "SIEM Total Escalated Alarms is Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "SIEMEscalatedAlarmsToggelButton"), "SIEM Escalated Alarms Toggel Button is Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "SIEMTotalEscalatedAlarmsPreviousMonth"), "SIEM Total Escalated Alarms Previous Month is Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "SIEMEscalatedAlarmsText"), "SIEM Escalated Alarms Text is Not Found");
			}
			Thread.sleep(3000);
			if(Utility.isElementPresent(driver, "IOMTTile")) {
				Assert.assertTrue(Utility.isElementPresent(driver, "IomtTitle"), "IOMT Title is Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "IOMTWeeksNewInventoryCount"), "IOMT Weeks New Inventory Count is Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "IOMTNewInventoryText"), "IOMT New Inventory Text is Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "IOMTThisWeekText"), "IOMT This Week Text is Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "IOMTHighRiskInventoryCount"), "IOMT High Risk Inventory Count is Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "IOMTHighRiskInventoryIcon"), "IOMT High Risk Inventory Icon is Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "IOMTHighRiskInventoryText"), "IOMT High Risk Inventory Text is Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "IOMTInventoryText"), "IOMT Inventory Text is Not Found");
			}
			Thread.sleep(3000);
			if(Utility.isElementPresent(driver, "MDRTile")) {
				Assert.assertTrue(Utility.isElementPresent(driver, "MdrTitle"), "MDR Title is Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "MDREscalatedAlarms"), "MDR Escalated Alarms is Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "MDREscalatedAlarmsText"), "MDR Escalated Alarms Text is Not Found");
			}
			if(Utility.isElementPresent(driver, "emptyDashboardCard")) {
				Assert.assertTrue(Utility.isElementPresent(driver, "emptyDashboardCardTitle"), "Empty Dashboard Card Title is Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "emptyDashboardCardImage"), "Empty Dashboard Card Image is Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "emptyDashboardCardLabel"), "Empty Dashboard Card Label Text is Not Found");
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}

}
