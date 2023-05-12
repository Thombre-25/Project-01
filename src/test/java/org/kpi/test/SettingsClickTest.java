package org.kpi.test;

import org.kpi.utility.Platform;
import org.kpi.utility.Utility;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class SettingsClickTest {

	private AppiumDriver<MobileElement> driver;
	boolean flag = Platform.IS_ANDROID;

	@BeforeMethod
	public void initiateDriver() {
		driver = TestConfig.getInstance().driver;
	}

	@Test(priority = 0)
	public void validateSettingsScreen() {
		try {
			/*Thread.sleep(10000);
			Utility.findElement(driver, "usernameInput").sendKeys(PropertiesFile.getInstance().getUsername());
			Thread.sleep(2000);
			Utility.findElement(driver, "nextButton").click();
			Thread.sleep(5000);
			Utility.findElement(driver, "passwordInput").sendKeys(PropertiesFile.getInstance().getPassword());
			Thread.sleep(2000);
			Utility.findElement(driver, "loginButton").click();
			Thread.sleep(10000);*/
			Thread.sleep(10000);
			Utility.findElement(driver, "SettingsTabButton").click();
			Thread.sleep(10000);
			Assert.assertTrue(Utility.isElementPresent(driver, "settingsHeading"), "Settings is Not Found");
			if(flag) {
				Assert.assertTrue(Utility.isElementPresent(driver, "name"), "Name is Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "role"), "Role is Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "userInfoButton"), "Eye Icon Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "communicationPreferencesMenuImage"), "Communication Preferences Image Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "communicationPreferencesMenuButton"), "Communication Preferences Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "chatHistoryMenuImage"), "Chat History Image Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "chatHistoryMenuButton"), "Chat History Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "securityMenuImage"), "Security Menu Image Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "securityMenuButton"), "Security Menu Button Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "logOutMenuImage"), "Log Out Image Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "logOutMenuButton"), "Log Out Button Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "fortifiedVersionText"), "Fortified Version Not Found");
				Thread.sleep(2000);
				if(!Utility.findElement(driver, "settingsHeading").getText().equals("Settings")) {
					Assert.assertTrue(false);
				}
				if(!Utility.findElement(driver, "communicationPreferencesMenuButton").getText().equals("Communication Preferences")) {
					Assert.assertTrue(false);
				}
				if(!Utility.findElement(driver, "chatHistoryMenuButton").getText().equals("Chat History")) {
					Assert.assertTrue(false);
				}
				if(!Utility.findElement(driver, "securityMenuButton").getText().equals("Security")) {
					Assert.assertTrue(false);
				}
				if(!Utility.findElement(driver, "logOutMenuButton").getText().equals("Log Out")) {
					Assert.assertTrue(false);
				}
				if(!Utility.findElement(driver, "fortifiedVersionText").getText().equals("Fortified Central Command Mobile Version 1.0")) {
					Assert.assertTrue(false);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}


	}



}

