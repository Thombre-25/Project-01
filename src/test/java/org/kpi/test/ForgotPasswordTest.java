package org.kpi.test;

import org.kpi.properties.PropertiesFile;
import org.kpi.utility.DimensionUtil;
import org.kpi.utility.Platform;
import org.kpi.utility.Utility;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

public class ForgotPasswordTest {
	
	private AppiumDriver<MobileElement> driver;
	
	boolean flag = Platform.IS_ANDROID;
	
	@BeforeMethod
	public void initiateDriver() {
		driver = TestConfig.getInstance().driver;
	}
	
	@Test(priority = 0)
	public void clickForgotPassword() {
		try {
			Thread.sleep(15000);
			Utility.findElement(driver, "usernameInput").sendKeys(PropertiesFile.getInstance().getUsername());
			Thread.sleep(2000);
			Utility.findElement(driver, "nextButton").click();
			Thread.sleep(5000);
			if(flag) {
				Utility.findElement(driver, "forgotPasswordButton").click();
				
			}
			else {
				TouchAction tap = new TouchAction(driver);
				int width = (int) Math.round(DimensionUtil.getWidth(driver)*0.77);
				int height = (int) Math.round(DimensionUtil.getHeight(driver)*0.84);
				tap.tap(width, height).perform();
			}
			Thread.sleep(5000);
			Assert.assertTrue(Utility.isElementPresent(driver, "fortifiedImg"), "Fortified Logo Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "forgotPasswordTitle"), "Forgot Password Title Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "forgotPasswordText"), "Forgot Password Text Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "usernameInputBox"), "Username Input Box Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "resetPasswordButton"), "Reset Password Button Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "ForgotPasswordBackIcon"), "Forgot Password Back Button Not Found");
			
			Thread.sleep(3000);
			if(!Utility.findElement(driver, "forgotPasswordTitle").getText().equals("Forgot password?")) {
				Assert.assertTrue(false);
			}
			if(!Utility.findElement(driver, "forgotPasswordText").getText().equals("Tap the “Reset Password” button and we will send instructions to the email address associated with the username.")) {
				Assert.assertTrue(false);
			}
			if(!Utility.findElement(driver, "usernameInputBox").getText().equals(PropertiesFile.getInstance().getUsername())) {
				Assert.assertTrue(false);
			}
			
			Thread.sleep(5000);
			Utility.findElement(driver, "resetPasswordButton").click();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
	
	@Test(priority = 1)
	public void checkResetPasswordScreenElements() {
		try {
			Thread.sleep(10000);
			/*String pointsText = "1. Has minimum length of 8 characters\r\n"
					+ "2. Contains only allowed characters: uppercase and lowercase letters, numbers, special characters (= + - ^ $ * . [ ]  ( ) ? \" ! @ # % & / \\ , > < ' : ; | _ ~ `) \r\n"
					+ "3. Meets the Password Policy";
			
			String points = "\r\n"
					+ "1. Has minimum length of 8 characters\r\n"
					+ "2. Contains only allowed characters: uppercase and lowercase letters, numbers, special characters (= + - ^ $ * . [ ]  ( ) ? \" ! @ # % & / \\ , > < ' : ; | _ ~ `) \r\n"
					+ "3. Meets the Password Policy";*/
			Thread.sleep(2000);
			Assert.assertTrue(Utility.isElementPresent(driver, "resetPasswordBackButton"), "Reset Password Back Icon Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "fortifiedImg"), "Fortified Logo Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "resetPasswordText"), "Reset Password Title Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "inOrderText"), "In order matter is Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "pointsText"), "Password points is Not Found");
			Thread.sleep(3000);
			if(!Utility.findElement(driver, "resetPasswordText").getText().equals("Reset your password")) {
				Assert.assertTrue(false);
			}
			if(!Utility.findElement(driver, "inOrderText").getText().equals("In order to protect your account, make sure your password:")) {
				Assert.assertTrue(false);
			}
			/*if(!Utility.findElement(driver, "pointsText").getText().equals(points)) {
				Assert.assertTrue(false);
			}*/
			Thread.sleep(3000);
			if(flag) {
				/*int width = (int) Math.round(DimensionUtil.getWidth(driver)*0.75);
				int height = (int) Math.round(DimensionUtil.getHeight(driver)*0.61);
				int height1 = (int) Math.round(DimensionUtil.getHeight(driver)*0.49);*/
				//driver.swipe(width, height, width, height1, 2000);
				driver.swipe(805, 1351, 805, 1076, 2000);
			}
			Thread.sleep(2000);
			Assert.assertTrue(Utility.isElementPresent(driver, "verificationCodeInput"), "Verification Code field is Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "newPasswordInput"), "New Password field is Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "confirmNewPasswordInput"), "Confirm New Password field is Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "newPasswordVisibleButton"), "New Password Visible Button is Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "confirmNewPasswordVisibleButton"), "Confirm New Password Visible Button is Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "resetPasswordButton"), "RESET PASSWORD button is Not Found");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
	
	@Test(priority = 2)
	public void clickPasswordPolicy() {
		try {
			Thread.sleep(5000);
			TouchAction tap = new TouchAction(driver);
			if(flag) {
				/*int width = (int) Math.round(DimensionUtil.getWidth(driver)*0.396);
				int height = (int) Math.round(DimensionUtil.getHeight(driver)*0.56);*/
				//tap.tap(width, height).perform();
				tap.tap(500, 1200).perform();//478, 1411
			}
			else {
				int width = (int) Math.round(DimensionUtil.getWidth(driver)*0.425);
				int height = (int) Math.round(DimensionUtil.getHeight(driver)*0.5);
				tap.tap(width, height).perform();
				//tap.tap(165, 423).perform();
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
			if(!Utility.findElement(driver, "passwordPolicyTitle").getText().equals("Password policy:")) {
				Assert.assertTrue(false);
			}
			if(!Utility.findElement(driver, "passwordPolicyPoint1").getText().equals("1. Password should not contain values known to be commonly-used, expected, or compromised."+"\n")) {
				Assert.assertTrue(false);
			}
			if(!Utility.findElement(driver, "passwordPolicyPoint2").getText().equals("2. Password should not be obtained from previous breach corpuses."+"\n")) {
				Assert.assertTrue(false);
			}
			if(!Utility.findElement(driver, "passwordPolicyPoint3").getText().equals("3. Password should not contain dictionary words."+"\n")) {
				Assert.assertTrue(false);
			}
			if(!Utility.findElement(driver, "passwordPolicyPoint4").getText().equals("4. Password should not contain repetitive or sequential characters (e.g. '111111', '1234abcd')."+"\n")) {
				Assert.assertTrue(false);
			}
			if(!Utility.findElement(driver, "passwordPolicyPoint5").getText().equals("5. Password should not contain context-specific words, such as the name of the service, the username, and derivatives thereof."+"\n")) {
				Assert.assertTrue(false);
			}
			Thread.sleep(3000);
			Utility.findElement(driver, "passwordPolicyCloseButton").click();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
	
	@Test(priority = 3)
	public void checkWeakPassword() {
		try {
			Thread.sleep(3000);
			Utility.findElement(driver, "newPasswordVisibleButton").click();
			Thread.sleep(1000);
			Utility.findElement(driver, "newPasswordInput").sendKeys("abc");
			Thread.sleep(2000);
			Utility.findElement(driver, "inOrderText").click();
			Thread.sleep(5000);
			Assert.assertTrue(Utility.isElementPresent(driver, "Weak"), "Weak is not found");
			Assert.assertTrue(Utility.isElementPresent(driver, "yourPasswordText"), "Password Guessable Text is not found");
			Assert.assertTrue(Utility.isElementPresent(driver, "infoButton"), "Weak Info Button is not found");
			Thread.sleep(2000);
			if(!Utility.findElement(driver, "Weak").getText().equals("Weak")) {
				Assert.assertTrue(false);
			}
			if(!Utility.findElement(driver, "yourPasswordText").getText().equals("Your password is easily guessable")) {
				Assert.assertTrue(false);
			}
			Thread.sleep(1000);
			Utility.findElement(driver, "infoButton").click();
			Thread.sleep(5000);
			Assert.assertTrue(Utility.isElementPresent(driver, "passwordTitle"), "Password Heading in weak section is not found");
			Assert.assertTrue(Utility.isElementPresent(driver, "closeButton"), "Weak Close Button is not found");
			/*Thread.sleep(2000);
			System.out.println(Utility.findElement(driver, "passwordTitle").getText());
			if(!Utility.findElement(driver, "passwordTitle").getText().equals("Your password does not meet the Password Policy?")) {
				Assert.assertTrue(false);
			}*/
			Thread.sleep(5000);
			Utility.findElement(driver, "closeButton").click();
			
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
	
	@Test(priority = 4)
	public void checkAveragePassword() {
		try {
			Thread.sleep(5000);
			if(flag) {
				Utility.findElement(driver, "newPasswordInput").clear();
			}
			else {
				Utility.clearText(driver, "newPasswordInput");
			}
			Thread.sleep(3000);
			Utility.findElement(driver, "newPasswordInput").sendKeys("utxcghfgtre");
			Thread.sleep(2000);
			Utility.findElement(driver, "inOrderText").click();
			//driver.navigate().back();
			Thread.sleep(5000);
			Assert.assertTrue(Utility.isElementPresent(driver, "Average"), "Average is not found");
			Assert.assertTrue(Utility.isElementPresent(driver, "yourPasswordText"), "Password Guessable is not found");
			Assert.assertTrue(Utility.isElementPresent(driver, "infoButton"), "Average Info Button is not found");
			Thread.sleep(2000);
			if(!Utility.findElement(driver, "Average").getText().equals("Average")) {
				Assert.assertTrue(false);
			}
			if(!Utility.findElement(driver, "yourPasswordText").getText().equals("Your password is easily guessable")) {
				Assert.assertTrue(false);
			}
			Thread.sleep(1000);
			Utility.findElement(driver, "infoButton").click();
			Thread.sleep(5000);
			Assert.assertTrue(Utility.isElementPresent(driver, "passwordTitle"), "Password Heading in Average section is not found");
			Assert.assertTrue(Utility.isElementPresent(driver, "closeButton"), "Average Close Button is not found");
			/*Thread.sleep(2000);
			System.out.println(Utility.findElement(driver, "passwordTitle").getText());
			if(!Utility.findElement(driver, "passwordTitle").getText().equals("Your password does not meet the Password Policy?")) {
				Assert.assertTrue(false);
			}*/
			Thread.sleep(5000);
			Utility.findElement(driver, "closeButton").click();
			
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
	
	@Test(priority = 5)
	public void checkStrongPassword() {
		try {
			Thread.sleep(5000);
			if(flag) {
				Utility.findElement(driver, "newPasswordInput").clear();
			}
			else {
				Utility.clearText(driver, "newPasswordInput");
			}
			Thread.sleep(3000);
			Utility.findElement(driver, "newPasswordInput").sendKeys("sxD[.YL&Cng6\\8p");
			Thread.sleep(3000);
			Utility.findElement(driver, "inOrderText").click();
			//driver.navigate().back();
			Thread.sleep(5000);
			Assert.assertTrue(Utility.isElementPresent(driver, "Strong"), "Strong in Strong section is not found");
			Assert.assertTrue(Utility.isElementPresent(driver, "strongPasswordAccepted"), "Password accepted in strong section is not found");
			Assert.assertTrue(Utility.isElementPresent(driver, "tickSymbol"), "Tick symbol in strong section is not found");
			Thread.sleep(2000);
			if(!Utility.findElement(driver, "Strong").getText().equals("Strong")) {
				Assert.assertTrue(false);
			}
			if(!Utility.findElement(driver, "strongPasswordAccepted").getText().equals("Password accepted")) {
				Assert.assertTrue(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
	
	/*@Test(priority = 6)
	public void checkBothPasswordsMatch() {
		try {
			Thread.sleep(5000);//passwordsMatchErrorText
			if(flag) {
				Utility.findElement(driver, "newPasswordInput").clear();
			}
			else {
				Utility.clearText(driver, "newPasswordInput");
			}
			Thread.sleep(3000);
			Utility.findElement(driver, "newPasswordInput").sendKeys("sxD[.YL&Cng6\\8");
			Thread.sleep(3000);
			Utility.findElement(driver, "confirmNewPasswordInput").sendKeys("sxD[.YL&Cng6\\8p");
			Thread.sleep(3000);
			Utility.findElement(driver, "newPasswordVisibleButton").click();
			Thread.sleep(3000);
			Assert.assertTrue(Utility.isElementPresent(driver, "passwordsMatchErrorText"), "Both Passwords Must Match Text Not Found");
			System.out.println("ForgotPasswordTest.checkBothPasswordsMatch() "+Utility.findElement(driver, "passwordsMatchErrorText").getText());
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}*/
	
	@Test(priority = 7)
	public void checkWrongVerificationCode() {
		try {
			Thread.sleep(10000);
			if(!flag) {
				TouchAction tap = new TouchAction(driver);
				int width = (int) Math.round(DimensionUtil.getWidth(driver)*0.52);
				int height = (int) Math.round(DimensionUtil.getHeight(driver)*0.24);
				tap.tap(width, height).perform();
				//tap.tap(200, 200).perform();
			}
			Thread.sleep(3000);
			if(flag) {
				Utility.findElement(driver, "newPasswordInput").clear();
			}
			else {
				Utility.clearText(driver, "newPasswordInput");
			}
			Thread.sleep(3000);
			Utility.findElement(driver, "newPasswordInput").sendKeys("sxD[.YL&Cng6\\8p");
			Thread.sleep(2000);
			Utility.findElement(driver, "confirmNewPasswordInput").sendKeys("sxD[.YL&Cng6\\8p");
			Thread.sleep(3000);
			Utility.findElement(driver, "verificationCodeInput").sendKeys("123456");
			Thread.sleep(3000);
			if(flag) {
				/*int width = (int) Math.round(DimensionUtil.getWidth(driver)*0.746);
				int height = (int) Math.round(DimensionUtil.getHeight(driver)*0.61);
				int height1 = (int) Math.round(DimensionUtil.getHeight(driver)*0.486);*/
				//driver.swipe(width, height, width, height1, 2000);
				driver.swipe(805, 1351, 805, 1076, 2000);
			}
			else {
				Utility.findElement(driver, "pointsText").click();
			}
			Thread.sleep(3000);
			Utility.findElement(driver, "resetPasswordButton").click();
			Thread.sleep(5000);
			Assert.assertTrue(Utility.isElementPresent(driver, "alertIcon"), "Alert Icon Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "resetPasswordErrorID"), "Error Message Not Found");
			/*Thread.sleep(2000);
			if(!Utility.findElement(driver, "resetPasswordErrorID").getText().equals("Invalid code provided, please request a code again.")) {
				Assert.assertTrue(false);
			}*/
			Thread.sleep(3000);
			if(flag) {
				driver.swipe(805, 1076, 805, 1351, 2000);
			}
			Thread.sleep(3000);
			Utility.findElement(driver, "resetPasswordBackButton").click();
			Thread.sleep(3000);
			Utility.findElement(driver, "ForgotPasswordBackIcon").click();
			if(flag) {
				Thread.sleep(3000);
				driver.navigate().back();
			}
			else {
				int width = (int) Math.round(DimensionUtil.getWidth(driver)*0.03);
				int height = (int) Math.round(DimensionUtil.getHeight(driver)*0.294);
				int width1 = (int) Math.round(DimensionUtil.getHeight(driver)*0.56);
				Thread.sleep(3000);
				driver.swipe(width, height, width1, height, 2000);
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}

}
