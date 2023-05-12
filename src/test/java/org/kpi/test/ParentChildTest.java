package org.kpi.test;

import java.util.List;

import org.kpi.properties.PropertiesFile;
import org.kpi.utility.Platform;
import org.kpi.utility.Utility;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

public class ParentChildTest {
	
	private AppiumDriver<MobileElement> driver;
	boolean flag = Platform.IS_ANDROID;
	
	@BeforeMethod
	public void initiateDriver() {
		//System.out.println("ParentChildTest.initiateDriver()");
		driver = TestConfig.getInstance().driver;
		//driver = TestConfig.getInstance().getAndroidDriver();
	}
	
	@Test(priority = 0)
	public void checkParentChildElements() {
		try {
			Thread.sleep(10000);
			//EnvironmentUtil.changeEnvironment(driver);
			Thread.sleep(5000);
			Utility.findElement(driver, "usernameInput").sendKeys(PropertiesFile.getInstance().getParentChildUsername());
			Thread.sleep(2000);
			Utility.findElement(driver, "nextButton").click();
			Thread.sleep(10000);
			Utility.findElement(driver, "passwordInput").sendKeys(PropertiesFile.getInstance().getPassword());
			Thread.sleep(2000);
			Utility.findElement(driver, "loginButton").click();
			Thread.sleep(20000);
			Thread.sleep(5000);
			TouchAction tap = new TouchAction(driver);
			if(flag) {
				Assert.assertTrue(Utility.isElementPresent(driver, "tenantNameHeader"), "Tenant Name Header Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "tenantDropdownIcon"), "Tenant Dropdown Icon Not Found");
			}
			Thread.sleep(3000);
			if(flag) {
				Utility.findElement(driver, "tenantDropdownIcon").click();
			}
			else {
				tap.tap(70, 108).perform();
			}
			Thread.sleep(5000);
			if(flag) {
				Assert.assertTrue(Utility.isElementPresent(driver, "tenantListTitleText"), "Tenant List Title Text Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "tenantName"), "Tenant Name Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "LCEscalationIcon"), "Escalation Icon Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "openEscalations"), "Escalations Count Not Found");
				Thread.sleep(3000);
				List<MobileElement> list = driver.findElementsByXPath("//android.widget.TextView[@content-desc='tenantName']");
				//System.out.println("List :: "+list);
				for(MobileElement me : list) {
					String meName = me.getText();
					System.out.println("ME :: "+meName);
					Assert.assertTrue(Utility.isElementPresent(driver, meName+" RadioButtonCheckBox"), "Tenant Radio Button CheckBox Not Found");
					//Utility.findElement(driver, meName+" RadioButtonCheckBox").click();
				}
				Thread.sleep(3000);
				if(flag) {
					tap.tap(200, 200).perform();
				}
				else {
					tap.tap(70, 108).perform();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
	
	@Test(priority = 1)
	public void checkPCInNews() {
		try {
			Thread.sleep(5000);
			Utility.findElement(driver, "NewsTabButton").click();
			Thread.sleep(5000);
			TouchAction tap = new TouchAction(driver);
			if(flag) {
				Assert.assertTrue(Utility.isElementPresent(driver, "tenantNameHeader"), "Tenant Name Header Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "tenantDropdownIcon"), "Tenant Dropdown Icon Not Found");
			}
			Thread.sleep(3000);
			if(flag) {
				Utility.findElement(driver, "tenantDropdownIcon").click();
			}
			else {
				tap.tap(70, 108).perform();
			}
			Thread.sleep(5000);
			if(flag) {
				Assert.assertTrue(Utility.isElementPresent(driver, "tenantListTitleText"), "Tenant List Title Text Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "tenantName"), "Tenant Name Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "LCEscalationIcon"), "Escalation Icon Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "openEscalations"), "Escalations Count Not Found");
				Thread.sleep(3000);
				List<MobileElement> list = driver.findElementsByXPath("//android.widget.TextView[@content-desc='tenantName']");
				//System.out.println("List :: "+list);
				for(MobileElement me : list) {
					String meName = me.getText();
					System.out.println("ME :: "+meName);
					Assert.assertTrue(Utility.isElementPresent(driver, meName+" RadioButtonCheckBox"), "Tenant Radio Button CheckBox Not Found");
					//Utility.findElement(driver, meName+" RadioButtonCheckBox").click();
				}
				Thread.sleep(3000);
				if(flag) {
					tap.tap(200, 200).perform();
				}
				else {
					tap.tap(70, 108).perform();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
	
	@Test(priority = 2)
	public void checkPCInEscalations() {
		try {
			Thread.sleep(5000);
			Utility.findElement(driver, "EscalationsTabButton").click();
			Thread.sleep(5000);
			TouchAction tap = new TouchAction(driver);
			if(flag) {
				Assert.assertTrue(Utility.isElementPresent(driver, "tenantNameHeader"), "Tenant Name Header Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "tenantDropdownIcon"), "Tenant Dropdown Icon Not Found");
			}
			Thread.sleep(3000);
			if(flag) {
				Utility.findElement(driver, "tenantDropdownIcon").click();
			}
			else {
				tap.tap(70, 108).perform();
			}
			Thread.sleep(5000);
			if(flag) {
				Assert.assertTrue(Utility.isElementPresent(driver, "tenantListTitleText"), "Tenant List Title Text Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "tenantName"), "Tenant Name Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "LCEscalationIcon"), "Escalation Icon Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "openEscalations"), "Escalations Count Not Found");
				Thread.sleep(3000);
				List<MobileElement> list = driver.findElementsByXPath("//android.widget.TextView[@content-desc='tenantName']");
				//System.out.println("List :: "+list);
				for(MobileElement me : list) {
					String meName = me.getText();
					System.out.println("ME :: "+meName);
					Assert.assertTrue(Utility.isElementPresent(driver, meName+" RadioButtonCheckBox"), "Tenant Radio Button CheckBox Not Found");
					//Utility.findElement(driver, meName+" RadioButtonCheckBox").click();
				}
				Thread.sleep(3000);
				if(flag) {
					tap.tap(200, 200).perform();
				}
				else {
					tap.tap(70, 108).perform();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
	
	@Test(priority = 3)
	public void checkPCInNotifications() {
		try {
			Thread.sleep(5000);
			Utility.findElement(driver, "NotificationsTabButton").click();
			Thread.sleep(5000);
			TouchAction tap = new TouchAction(driver);
			if(flag) {
				Assert.assertTrue(Utility.isElementPresent(driver, "tenantNameHeader"), "Tenant Name Header Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "tenantDropdownIcon"), "Tenant Dropdown Icon Not Found");
			}
			Thread.sleep(3000);
			if(flag) {
				Utility.findElement(driver, "tenantDropdownIcon").click();
			}
			else {
				tap.tap(70, 108).perform();
			}
			Thread.sleep(5000);
			if(flag) {
				Assert.assertTrue(Utility.isElementPresent(driver, "tenantListTitleText"), "Tenant List Title Text Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "tenantName"), "Tenant Name Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "LCEscalationIcon"), "Escalation Icon Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "openEscalations"), "Escalations Count Not Found");
				Thread.sleep(3000);
				List<MobileElement> list = driver.findElementsByXPath("//android.widget.TextView[@content-desc='tenantName']");
				//System.out.println("List :: "+list);
				for(MobileElement me : list) {
					String meName = me.getText();
					System.out.println("ME :: "+meName);
					Assert.assertTrue(Utility.isElementPresent(driver, meName+" RadioButtonCheckBox"), "Tenant Radio Button CheckBox Not Found");
					//Utility.findElement(driver, meName+" RadioButtonCheckBox").click();
				}
				Thread.sleep(3000);
				if(flag) {
					tap.tap(200, 200).perform();
				}
				else {
					tap.tap(70, 108).perform();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
	
	@Test(priority = 4)
	public void checkPCInSettings() {
		try {
			Thread.sleep(5000);
			Utility.findElement(driver, "SettingsTabButton").click();
			Thread.sleep(5000);
			TouchAction tap = new TouchAction(driver);
			if(flag) {
				Assert.assertTrue(Utility.isElementPresent(driver, "tenantNameHeader"), "Tenant Name Header Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "tenantDropdownIcon"), "Tenant Dropdown Icon Not Found");
			}
			Thread.sleep(3000);
			if(flag) {
				Utility.findElement(driver, "tenantDropdownIcon").click();
			}
			else {
				tap.tap(70, 108).perform();
			}
			Thread.sleep(5000);
			if(flag) {
				Assert.assertTrue(Utility.isElementPresent(driver, "tenantListTitleText"), "Tenant List Title Text Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "tenantName"), "Tenant Name Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "LCEscalationIcon"), "Escalation Icon Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "openEscalations"), "Escalations Count Not Found");
				Thread.sleep(3000);
				List<MobileElement> list = driver.findElementsByXPath("//android.widget.TextView[@content-desc='tenantName']");
				//System.out.println("List :: "+list);
				for(MobileElement me : list) {
					String meName = me.getText();
					System.out.println("ME :: "+meName);
					Assert.assertTrue(Utility.isElementPresent(driver, meName+" RadioButtonCheckBox"), "Tenant Radio Button CheckBox Not Found");
					//Utility.findElement(driver, meName+" RadioButtonCheckBox").click();
				}
				Thread.sleep(3000);
				if(flag) {
					tap.tap(200, 200).perform();
				}
				else {
					tap.tap(70, 108).perform();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}

}
