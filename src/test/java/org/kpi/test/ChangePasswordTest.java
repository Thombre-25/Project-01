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

public class ChangePasswordTest {

	private AppiumDriver<MobileElement> driver;
	boolean flag = Platform.IS_ANDROID;

	@BeforeMethod
	public void initiateDriver() {
		driver = TestConfig.getInstance().driver;
	}

	@Test(priority = 0)
	public void validateChangePassword() {
		try {
			Thread.sleep(3000);
			Utility.findElement(driver, "changePasswordMenuButton").click();
			Thread.sleep(5000);
			String points = "\r\n"
					+ "1. Has minimum length of 8 characters\r\n"
					+ "2. Contains only allowed characters: uppercase and lowercase letters, numbers, special characters (= + - ^ $ * . [ ]  ( ) ? \" ! @ # % & / \\ , > < ' : ; | _ ~ `) \r\n"
					+ "3. Meets the Password Policy";
			//title check
			Assert.assertTrue(Utility.isElementPresent(driver, "Change PasswordTitle"), "Change Password is Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "changePasswordBackButton"), "Back Button is Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "inOrderText"), "In order matter is Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "pointsText"), "Password points is Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "oldPasswordInput"), "Old Password field is Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "newPasswordInput"), "New Password field is Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "confirmNewPasswordInput"), "Confirm New Password field is Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "oldPasswordVisibleButton"), "Old Password Visible Button is Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "newPasswordVisibleButton"), "New Password Visible Button is Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "confirmNewPasswordVisibleButton"), "Confirm New Password Visible Button is Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "changePasswordButton"), "CHANGE PASSWORD button is Not Found");
			/*Thread.sleep(2000);
			if(!Utility.findElement(driver, "Change PasswordTitle").getText().equals("Change Password")) {
				Assert.assertTrue(false);
			}
			if(!Utility.findElement(driver, "inOrderText").getText().equals("In order to protect your account, make sure your password:")) {
				Assert.assertTrue(false);
			}
			if(!Utility.findElement(driver, "pointsText").getText().equals(points)) {
				Assert.assertTrue(false);
			}*/
			/*System.out.println("ChangePasswordTest.validateChangePassword() "+Utility.findElement(driver, "Change PasswordTitle").getText());
			System.out.println(Utility.findElement(driver, "inOrderText").getText());
			System.out.println(Utility.findElement(driver, "pointsText").getText());*/
			
			Thread.sleep(3000);
			Utility.findElement(driver, "changePasswordBackButton").click();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 1)
	public void validatePasswordPolicy() {
		try {
			Thread.sleep(3000);
			Utility.findElement(driver, "changePasswordMenuButton").click();
			Thread.sleep(5000);
			TouchAction tap = new TouchAction(driver);
			if(flag) {
				/*int width = (int) Math.round(DimensionUtil.getWidth(driver)*0.407);
				int height = (int) Math.round(DimensionUtil.getHeight(driver)*0.4);
				tap.tap(width, height).perform();*/
				tap.tap(500, 945).perform();
			}
			else {
				int width = (int) Math.round(DimensionUtil.getWidth(driver)*0.425);
				int height = (int) Math.round(DimensionUtil.getHeight(driver)*0.305);
				tap.tap(width, height).perform();
			}
			Thread.sleep(3000);
			Assert.assertTrue(Utility.isElementPresent(driver, "passwordPolicyTitle"), "Password Policy is Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "passwordPolicyPoint1"), "Password Policy point 1 is Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "passwordPolicyPoint2"), "Password Policy point 2 is Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "passwordPolicyPoint3"), "Password Policy point 3 is Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "passwordPolicyPoint4"), "Password Policy point 4 is Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "passwordPolicyPoint5"), "Password Policy point 5 is Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "passwordPolicyCloseButton"), "Password Policy Close Button is Not Found");
			Thread.sleep(3000);
			Utility.findElement(driver, "passwordPolicyCloseButton").click();
			Thread.sleep(3000);
			Utility.findElement(driver, "changePasswordBackButton").click();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 2)
	public void verifyWeakPassword() {
		try {
			Thread.sleep(3000);
			Utility.findElement(driver, "changePasswordMenuButton").click();
			Thread.sleep(3000);
			Utility.findElement(driver, "newPasswordVisibleButton").click();
			Thread.sleep(1000);
			Utility.findElement(driver, "newPasswordInput").sendKeys("abc");
			Thread.sleep(5000);
			Assert.assertTrue(Utility.isElementPresent(driver, "Weak"), "Weak is not found");
			Assert.assertTrue(Utility.isElementPresent(driver, "yourPasswordText"), "Password Guessable Text is not found");
			Assert.assertTrue(Utility.isElementPresent(driver, "infoButton"), "Weak Info Button is not found");
			Thread.sleep(1000);
			Utility.findElement(driver, "infoButton").click();
			Thread.sleep(5000);
			Assert.assertTrue(Utility.isElementPresent(driver, "passwordTitle"), "Password Heading in weak section is not found");
			Assert.assertTrue(Utility.isElementPresent(driver, "closeButton"), "Weak Close Button is not found");
			Thread.sleep(5000);
			Utility.findElement(driver, "closeButton").click();	
			Thread.sleep(3000);
			Utility.findElement(driver, "changePasswordBackButton").click();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 3)
	public void verifyAveragePassword() {
		try {
			Thread.sleep(5000);
			Utility.findElement(driver, "changePasswordMenuButton").click();
			Thread.sleep(3000);
			Utility.findElement(driver, "newPasswordVisibleButton").click();
			Thread.sleep(5000);
			Utility.findElement(driver, "newPasswordInput").sendKeys("utxcghfgtre");
			Thread.sleep(2000);
			Utility.findElement(driver, "inOrderText").click();
			Thread.sleep(5000);
			Assert.assertTrue(Utility.isElementPresent(driver, "Average"), "Average is not found");
			Assert.assertTrue(Utility.isElementPresent(driver, "yourPasswordText"), "Password Guessable is not found");
			Assert.assertTrue(Utility.isElementPresent(driver, "infoButton"), "Average Info Button is not found");
			Thread.sleep(1000);
			Utility.findElement(driver, "infoButton").click();
			Thread.sleep(5000);
			Assert.assertTrue(Utility.isElementPresent(driver, "passwordTitle"), "Password Heading in Average section is not found");
			Thread.sleep(5000);
			Utility.findElement(driver, "closeButton").click();
			Thread.sleep(3000);
			Utility.findElement(driver, "changePasswordBackButton").click();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 4)
	public void verifyStrongPassword() {
		try {
			Thread.sleep(5000);
			Utility.findElement(driver, "changePasswordMenuButton").click();
			Thread.sleep(3000);
			Utility.findElement(driver, "newPasswordVisibleButton").click();
			Thread.sleep(5000);
			Utility.findElement(driver, "newPasswordInput").sendKeys("sxD[.YL&Cng6\\8p");
			Thread.sleep(3000);
			Utility.findElement(driver, "inOrderText").click();
			Thread.sleep(5000);
			Assert.assertTrue(Utility.isElementPresent(driver, "Strong"), "Strong in Strong section is not found");
			Assert.assertTrue(Utility.isElementPresent(driver, "strongPasswordAccepted"), "Password accepted in strong section is not found");
			Assert.assertTrue(Utility.isElementPresent(driver, "tickSymbol"), "Tick symbol in strong section is not found");
			Thread.sleep(3000);
			Utility.findElement(driver, "changePasswordBackButton").click();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 5)
	public void verifyIncorrectOldPassword() {
		try {
			Thread.sleep(5000);
			Utility.findElement(driver, "changePasswordMenuButton").click();
			Thread.sleep(3000);
			Utility.findElement(driver, "oldPasswordVisibleButton").click();
			Thread.sleep(2000);
			Utility.findElement(driver, "newPasswordVisibleButton").click();
			Thread.sleep(2000);
			Utility.findElement(driver, "confirmNewPasswordVisibleButton").click();
			Thread.sleep(5000);
			Utility.findElement(driver, "oldPasswordInput").sendKeys("sxD[.YL&Cn6");
			Thread.sleep(3000);
			Utility.findElement(driver, "newPasswordInput").sendKeys("sxD[.YL&Cng6\\8p");
			Thread.sleep(3000);
			Utility.findElement(driver, "inOrderText").click();
			Thread.sleep(3000);
			Utility.findElement(driver, "confirmNewPasswordInput").sendKeys("sxD[.YL&Cng6\\8p");
			Thread.sleep(3000);
			Utility.findElement(driver, "inOrderText").click();
			Thread.sleep(3000);
			Utility.findElement(driver, "changePasswordButton").click();
			Thread.sleep(10000);
			Assert.assertTrue(Utility.isElementPresent(driver, "incorrectPassword"), "Incorrect Password is not found");
			Thread.sleep(5000);
			Utility.findElement(driver, "changePasswordBackButton").click();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
	
	/*@Test(priority = 6)
	public void checkBothPasswordsMatch() {
		try {
			Thread.sleep(5000);//passwordsMatchErrorText
			Utility.findElement(driver, "oldPasswordInput").sendKeys("sxD[.YL&Cn6");
			Thread.sleep(3000);
			Utility.findElement(driver, "newPasswordInput").sendKeys("sxD[.YL&Cng6");
			Thread.sleep(3000);
			Utility.findElement(driver, "confirmNewPasswordInput").sendKeys("sxD[.YL&Cng6\\8p");
			Thread.sleep(3000);
			Assert.assertTrue(Utility.isElementPresent(driver, "passwordsMatchErrorText"), "Both Passwords Must Match Text Not Found");
			//System.out.println("ForgotPasswordTest.checkBothPasswordsMatch() "+Utility.findElement(driver, "passwordsMatchErrorText").getText());
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}*/

	
	@Test(priority = 7)
	public void verifyCorrectOldPassword() {
		try {
			Thread.sleep(5000);
			Utility.findElement(driver, "changePasswordMenuButton").click();
			Thread.sleep(3000);
			Utility.findElement(driver, "oldPasswordVisibleButton").click();
			Utility.findElement(driver, "newPasswordVisibleButton").click();
			Utility.findElement(driver, "confirmNewPasswordVisibleButton").click();
			Thread.sleep(5000);
			Utility.findElement(driver, "oldPasswordInput").sendKeys("sxD[.YL&Cng6\\8p");
			Thread.sleep(3000);
			Utility.findElement(driver, "inOrderText").click();
			Thread.sleep(3000);
			Utility.findElement(driver, "newPasswordInput").sendKeys("sxD[.YL&Cng6\\8p");
			Thread.sleep(3000);
			Utility.findElement(driver, "inOrderText").click();
			Thread.sleep(3000);
			Utility.findElement(driver, "confirmNewPasswordInput").sendKeys("sxD[.YL&Cng6\\8p");
			Thread.sleep(3000);
			Utility.findElement(driver, "inOrderText").click();
			Thread.sleep(3000);
			Utility.findElement(driver, "changePasswordButton").click();
			//driver.findElement(By.xpath("//android.widget.TextView[@text='CHANGE PASSWORD']")).click();
			Thread.sleep(10000);
			Assert.assertTrue(Utility.isElementPresent(driver, "changePasswordTitle"), "Change Password heading after succesful password change is not found");
			Assert.assertTrue(Utility.isElementPresent(driver, "passwordChangeSuccessfull"), "Password change successful is not found");
			if(flag) {
				Assert.assertTrue(Utility.isElementPresent(driver, "ok"), "OK after successful password change is not found");
				Thread.sleep(3000);
				Utility.findElement(driver, "ok").click();
			}
			else {
				Thread.sleep(3000);
				int width = (int) Math.round(DimensionUtil.getWidth(driver)*0.793);
				int height = (int) Math.round(DimensionUtil.getHeight(driver)*0.546);
				TouchAction tap = new TouchAction(driver);
				tap.tap(width, height).perform();
				//tap.tap(309, 460).perform();
			}
			Thread.sleep(5000);
			Utility.findElement(driver, "securityBackButton").click();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}


}
