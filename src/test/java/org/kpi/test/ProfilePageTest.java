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

public class ProfilePageTest {
	
	private AppiumDriver<MobileElement> driver;
	boolean flag = Platform.IS_ANDROID;
	
	@BeforeMethod
	public void initiateDriver() {
		driver = TestConfig.getInstance().driver;
	}
	
	@Test
	public void clickProfileEyeIcon() {
		try {
			Thread.sleep(3000);
			if(flag) {
				Utility.findElement(driver, "userInfoButton").click();
			}
			else {
				int width = (int) Math.round(DimensionUtil.getWidth(driver)*0.52);
				int height = (int) Math.round(DimensionUtil.getHeight(driver)*0.155);
				TouchAction tap = new TouchAction(driver);
				tap.tap(width, height).perform();
				//tap.tap(202, 130).perform();
			}
			Thread.sleep(5000);
			Assert.assertTrue(Utility.isElementPresent(driver, "Profile InformationTitle"), "Profile Information is Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "personalInfoTitle"), "Personal Information is Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "name"), "Name is Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "nameValue"), "Name Value is Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "username"), "Username is Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "usernameValue"), "Username Value is Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "email"), "Email is Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "emailValue"), "Email Value is Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "role"), "Role is Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "roleValue"), "Role Value is Not Found");
			
			Thread.sleep(2000);
			if(!Utility.findElement(driver, "Profile InformationTitle").getText().equals("Profile Information")) {
				Assert.assertTrue(false);
			}
			if(!Utility.findElement(driver, "personalInfoTitle").getText().equals("PERSONAL INFORMATION")) {
				Assert.assertTrue(false);
			}
			if(!Utility.findElement(driver, "name").getText().equals("Name")) {
				Assert.assertTrue(false);
			}
			if(!Utility.findElement(driver, "username").getText().equals("UserName")) {
				Assert.assertTrue(false);
			}
			if(!Utility.findElement(driver, "email").getText().equals("Email")) {
				Assert.assertTrue(false);
			}
			if(!Utility.findElement(driver, "role").getText().equals("Role")) {
				Assert.assertTrue(false);
			}
			
			Thread.sleep(5000);
			Utility.findElement(driver, "profileInformationBackButton").click();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}

}
