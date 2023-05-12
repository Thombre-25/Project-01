package org.kpi.test;

import org.kpi.properties.PropertiesFile;
import org.kpi.utility.DimensionUtil;
import org.kpi.utility.EnvironmentUtil;
import org.kpi.utility.Platform;
import org.kpi.utility.Utility;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

public class LoginTest {

	private AppiumDriver<MobileElement> driver;
	
	boolean flag = Platform.IS_ANDROID;

	@BeforeMethod
	public void initiateDriver() {
		driver = TestConfig.getInstance().driver;
	}

	@Test(priority = 0)
	public void checkLoginElements() {
		try {
			if(driver != null) {
				Thread.sleep(10000);
				EnvironmentUtil.changeEnvironment(driver, flag);
				Thread.sleep(5000);
				Assert.assertTrue(Utility.isElementPresent(driver, "fortifiedImg"), "Fortified Logo Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "image"), "Image Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "logintoText"), "Log in to Text Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "usernameInput"), "Username Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "nextButton"), "Next Button Not Found");
			}
			else {
				System.out.println("Driver is Null");
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}

	}
	
	/*@Test(priority = 1)
	public void changeEnvironment() {
		try {
			Thread.sleep(5000);
			Utility.findElement(driver, "usernameInput").sendKeys("0000");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//android.widget.TextView[@text=‘QA’]"));
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}*/
	
	@Test(priority = 1)
	public void checkEmptyUsername() {
		try {
			Thread.sleep(10000);
			Utility.findElement(driver, "nextButton").click();
			Thread.sleep(5000);
			if(Utility.isElementPresent(driver, "alertIcon") && Utility.isElementPresent(driver, "usernameErrorID")) {
				Assert.assertTrue(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
	
	/*@Test(priority = 2)
	public void wrongUsername1Letter() {
		try {
			Thread.sleep(5000);
			Utility.findElement(driver, "usernameInput").sendKeys("p");
			Thread.sleep(2000);
			Utility.findElement(driver, "nextButton").click();
			Thread.sleep(5000);
			if(Utility.isElementPresent(driver, "alertIcon") && Utility.isElementPresent(driver, "usernameErrorID")) {
				Assert.assertTrue(false);
			}
			Thread.sleep(5000);
			if(flag) {
				Utility.findElement(driver, "usernameInput").clear();
			}
			else {
				Utility.clearText(driver, "usernameInput");
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
	
	@Test(priority = 3)
	public void wrongUsername7Letters() {
		try {
			Thread.sleep(5000);
			Utility.findElement(driver, "usernameInput").sendKeys("pradeep");
			Thread.sleep(2000);
			Utility.findElement(driver, "nextButton").click();
			Thread.sleep(5000);
			if(Utility.isElementPresent(driver, "alertIcon") && Utility.isElementPresent(driver, "usernameErrorID")) {
				Assert.assertTrue(false);
			}
			Thread.sleep(5000);
			if(flag) {
				Utility.findElement(driver, "usernameInput").clear();
			}
			else {
				Utility.clearText(driver, "usernameInput");
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
	
	@Test(priority = 4)
	public void wrongUsername8Letters() {
		try {
			Thread.sleep(5000);
			Utility.findElement(driver, "usernameInput").sendKeys("pradee.k");
			Thread.sleep(2000);
			Utility.findElement(driver, "nextButton").click();
			Thread.sleep(5000);
			Assert.assertTrue(Utility.isElementPresent(driver, "alertIcon"), "Alert Icon Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "usernameErrorID"), "Error Message Not Found");
			Thread.sleep(2000);
			if(!Utility.findElement(driver, "usernameErrorID").getText().equals("You entered an incorrect username.")) {
				Assert.assertTrue(false);
			}
			Thread.sleep(5000);
			if(flag) {
				Utility.findElement(driver, "usernameInput").clear();
			}
			else {
				Utility.clearText(driver, "usernameInput");
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
	
	@Test(priority = 5)
	public void wrongUsername19Letters() {
		try {
			Thread.sleep(5000);
			Utility.findElement(driver, "usernameInput").sendKeys("pradeep.kpitech.kpi");
			Thread.sleep(2000);
			Utility.findElement(driver, "nextButton").click();
			Thread.sleep(5000);
			Assert.assertTrue(Utility.isElementPresent(driver, "alertIcon"), "Alert Icon Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "usernameErrorID"), "Error Message Not Found");
			Thread.sleep(2000);
			if(!Utility.findElement(driver, "usernameErrorID").getText().equals("You entered an incorrect username.")) {
				Assert.assertTrue(false);
			}
			Thread.sleep(5000);
			if(flag) {
				Utility.findElement(driver, "usernameInput").clear();
			}
			else {
				Utility.clearText(driver, "usernameInput");
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
	
	@Test(priority = 6)
	public void wrongUsername20Letters() {
		try {
			Thread.sleep(5000);
			Utility.findElement(driver, "usernameInput").sendKeys("pradeep.kpitech.kpit");
			Thread.sleep(2000);
			Utility.findElement(driver, "nextButton").click();
			Thread.sleep(5000);
			Assert.assertTrue(Utility.isElementPresent(driver, "alertIcon"), "Alert Icon Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "usernameErrorID"), "Error Message Not Found");
			Thread.sleep(2000);
			if(!Utility.findElement(driver, "usernameErrorID").getText().equals("You entered an incorrect username.")) {
				Assert.assertTrue(false);
			}
			Thread.sleep(5000);
			if(flag) {
				Utility.findElement(driver, "usernameInput").clear();
			}
			else {
				Utility.clearText(driver, "usernameInput");
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
	
	@Test(priority = 7)
	public void wrongUsername21Letters() {
		try {
			Thread.sleep(5000);
			Utility.findElement(driver, "usernameInput").sendKeys("pradeep.kpitech.kpite");
			Thread.sleep(2000);
			if(Utility.findElement(driver, "usernameInput").getText().equals("pradeep.kpitech.kpite")) {
				Assert.assertTrue(false);
			}
			Thread.sleep(2000);
			Utility.findElement(driver, "nextButton").click();
			Thread.sleep(5000);
			Assert.assertTrue(Utility.isElementPresent(driver, "alertIcon"), "Alert Icon Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "usernameErrorID"), "Error Message Not Found");
			Thread.sleep(2000);
			if(!Utility.findElement(driver, "usernameErrorID").getText().equals("You entered an incorrect username.")) {
				Assert.assertTrue(false);
			}
			Thread.sleep(5000);
			if(flag) {
				Utility.findElement(driver, "usernameInput").clear();
			}
			else {
				Utility.clearText(driver, "usernameInput");
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}*/

	@Test(priority = 8)
	public void checkWrongUsername() {
		try {
			Thread.sleep(5000);
			Utility.findElement(driver, "usernameInput").sendKeys("pradeep.k");
			Thread.sleep(2000);
			Utility.findElement(driver, "nextButton").click();
			Thread.sleep(5000);
			Assert.assertTrue(Utility.isElementPresent(driver, "alertIcon"), "Alert Icon Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "usernameErrorID"), "Error Message Not Found");
			Thread.sleep(2000);
			if(!Utility.findElement(driver, "usernameErrorID").getText().equals("You entered an incorrect username.")) {
				Assert.assertTrue(false);
			}
			Thread.sleep(5000);
			if(flag) {
				Utility.findElement(driver, "usernameInput").clear();
			}
			else {
				Utility.clearText(driver, "usernameInput");
			}
			Thread.sleep(5000);
			Utility.findElement(driver, "usernameInput").sendKeys("123456789");
			Thread.sleep(2000);
			Utility.findElement(driver, "nextButton").click();
			Thread.sleep(5000);
			Assert.assertTrue(Utility.isElementPresent(driver, "alertIcon"), "Alert Icon Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "usernameErrorID"), "Error Message Not Found");
			Thread.sleep(2000);
			if(!Utility.findElement(driver, "usernameErrorID").getText().equals("You entered an incorrect username.")) {
				Assert.assertTrue(false);
			}
			Thread.sleep(5000);
			if(flag) {
				Utility.findElement(driver, "usernameInput").clear();
			}
			else {
				Utility.clearText(driver, "usernameInput");
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
	
	/*@Test(priority = 9)
	public void checkUsernameSpace() {
		try {
			Thread.sleep(5000);
			Utility.findElement(driver, "usernameInput").sendKeys("              ");
			Thread.sleep(2000);
			Utility.findElement(driver, "nextButton").click();
			Thread.sleep(5000);
			if(Utility.isElementPresent(driver, "alertIcon") && Utility.isElementPresent(driver, "usernameErrorID")) {
				Assert.assertTrue(false);
			}
			Thread.sleep(5000);
			if(flag) {
				Utility.findElement(driver, "usernameInput").clear();
			}
			else {
				Utility.clearText(driver, "usernameInput");
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}*/
	
	@Test(priority = 10)
	public void checkCorrectUsernameSpace() {
		try {
			Thread.sleep(5000);
			Utility.findElement(driver, "usernameInput").sendKeys(PropertiesFile.getInstance().getUsername()+"     ");
			Thread.sleep(2000);
			Utility.findElement(driver, "nextButton").click();
			Thread.sleep(5000);
			if(flag) {
				driver.navigate().back();
			}
			else {
				int width = (int) Math.round(DimensionUtil.getWidth(driver)*0.03);
				int height = (int) Math.round(DimensionUtil.getHeight(driver)*0.3);
				int width2 = (int) Math.round(DimensionUtil.getWidth(driver)*0.56);
				driver.swipe(width, height, width2, height, 2000);
				//driver.swipe(10, 248, 217, 248, 2000);
			}
			Thread.sleep(3000);
			if(flag) {
				Utility.findElement(driver, "usernameInput").clear();
			}
			else {
				Utility.clearText(driver, "usernameInput");
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
	
	/*@Test(priority = 11)
	public void correctUsername8Letters() {
		try {
			Thread.sleep(5000);
			Utility.findElement(driver, "usernameInput").sendKeys("testchar");
			Thread.sleep(2000);
			Utility.findElement(driver, "nextButton").click();
			Thread.sleep(5000);
			if(flag) {
				driver.navigate().back();
			}
			else {
				int width = (int) Math.round(DimensionUtil.getWidth(driver)*0.03);
				int height = (int) Math.round(DimensionUtil.getHeight(driver)*0.3);
				int width2 = (int) Math.round(DimensionUtil.getWidth(driver)*0.56);
				driver.swipe(width, height, width2, height, 2000);
				//driver.swipe(10, 248, 217, 248, 2000);
			}
			Thread.sleep(3000);
			if(flag) {
				Utility.findElement(driver, "usernameInput").clear();
			}
			else {
				Utility.clearText(driver, "usernameInput");
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
	
	@Test(priority = 12)
	public void correctUsername19Letters() {
		try {
			Thread.sleep(5000);
			Utility.findElement(driver, "usernameInput").sendKeys("kpitest_ninteenchar");
			Thread.sleep(2000);
			Utility.findElement(driver, "nextButton").click();
			Thread.sleep(5000);
			if(flag) {
				driver.navigate().back();
			}
			else {
				int width = (int) Math.round(DimensionUtil.getWidth(driver)*0.03);
				int height = (int) Math.round(DimensionUtil.getHeight(driver)*0.3);
				int width2 = (int) Math.round(DimensionUtil.getWidth(driver)*0.56);
				driver.swipe(width, height, width2, height, 2000);
				//driver.swipe(10, 248, 217, 248, 2000);
			}
			Thread.sleep(3000);
			if(flag) {
				Utility.findElement(driver, "usernameInput").clear();
			}
			else {
				Utility.clearText(driver, "usernameInput");
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
	
	@Test(priority = 13)
	public void correctUsername20Letters() {
		try {
			Thread.sleep(5000);
			Utility.findElement(driver, "usernameInput").sendKeys("kpi_test_twenty_char");
			Thread.sleep(2000);
			Utility.findElement(driver, "nextButton").click();
			Thread.sleep(5000);
			if(flag) {
				driver.navigate().back();
			}
			else {
				int width = (int) Math.round(DimensionUtil.getWidth(driver)*0.03);
				int height = (int) Math.round(DimensionUtil.getHeight(driver)*0.3);
				int width2 = (int) Math.round(DimensionUtil.getWidth(driver)*0.56);
				driver.swipe(width, height, width2, height, 2000);
				//driver.swipe(10, 248, 217, 248, 2000);
			}
			Thread.sleep(3000);
			if(flag) {
				Utility.findElement(driver, "usernameInput").clear();
			}
			else {
				Utility.clearText(driver, "usernameInput");
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}*/

	@Test(priority = 14)
	public void checkCorrectUsername() {
		try {
			Thread.sleep(5000);
			Utility.findElement(driver, "usernameInput").sendKeys(PropertiesFile.getInstance().getUsername());
			Thread.sleep(2000);
			Utility.findElement(driver, "nextButton").click();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 15)
	public void checkPasswordScreenElements() {
		try {
			Thread.sleep(5000);
			Assert.assertTrue(Utility.isElementPresent(driver, "fortifiedImg"), "Fortified Logo Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "image"), "Image Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "logintoText"), "Log in to Text Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "passwordInput"), "Password Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "passwordVisibleButton"), "Password Eye Icon Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "loginButton"), "Login Button Not Found");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
	
	/*@Test(priority = 16)
	public void checkPassword1Letter() {
		try {
			Thread.sleep(5000);
			Utility.findElement(driver, "passwordVisibleButton").click();
			Thread.sleep(2000);
			Utility.findElement(driver, "passwordInput").sendKeys("p");
			Thread.sleep(2000);
			Utility.findElement(driver, "loginButton").click();
			Thread.sleep(5000);
			Assert.assertTrue(Utility.isElementPresent(driver, "alertIcon"), "Alert Icon Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "userSignInErrorID"), "Error Message Not Found");
			Thread.sleep(2000);
			if(!Utility.findElement(driver, "userSignInErrorID").getText().equals("Incorrect password.")) {
				Assert.assertTrue(false);
			}
			Thread.sleep(2000);
			if(flag) {
				Utility.findElement(driver, "passwordInput").clear();
			}
			else {
				Utility.clearText(driver, "passwordInput");
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
	
	@Test(priority = 17)
	public void checkPassword8Letters() {
		try {
			Thread.sleep(5000);
			Utility.findElement(driver, "passwordInput").sendKeys("pradeepk");
			Thread.sleep(2000);
			Utility.findElement(driver, "loginButton").click();
			Thread.sleep(5000);
			Assert.assertTrue(Utility.isElementPresent(driver, "alertIcon"), "Alert Icon Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "userSignInErrorID"), "Error Message Not Found");
			Thread.sleep(2000);
			if(!Utility.findElement(driver, "userSignInErrorID").getText().equals("Incorrect password.")) {
				Assert.assertTrue(false);
			}
			Thread.sleep(2000);
			if(flag) {
				Utility.findElement(driver, "passwordInput").clear();
			}
			else {
				Utility.clearText(driver, "passwordInput");
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}*/

	@Test(priority = 18)
	public void checkWrongPassword() {
		try {
			Thread.sleep(5000);
			Utility.findElement(driver, "passwordInput").sendKeys("etghdiuysh");
			Thread.sleep(2000);
			Utility.findElement(driver, "loginButton").click();
			Thread.sleep(5000);
			Assert.assertTrue(Utility.isElementPresent(driver, "alertIcon"), "Alert Icon Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "userSignInErrorID"), "Error Message Not Found");
			Thread.sleep(2000);
			if(!Utility.findElement(driver, "userSignInErrorID").getText().equals("Incorrect password.")) {
				Assert.assertTrue(false);
			}
			Thread.sleep(2000);
			if(flag) {
				Utility.findElement(driver, "passwordInput").clear();
			}
			else {
				Utility.clearText(driver, "passwordInput");
			}
			Thread.sleep(2000);
			Utility.findElement(driver, "passwordInput").sendKeys("1234567890");
			Thread.sleep(2000);
			Utility.findElement(driver, "loginButton").click();
			Thread.sleep(5000);
			Assert.assertTrue(Utility.isElementPresent(driver, "alertIcon"), "Alert Icon Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "userSignInErrorID"), "Error Message Not Found");
			Thread.sleep(2000);
			if(!Utility.findElement(driver, "userSignInErrorID").getText().equals("Incorrect password.")) {
				Assert.assertTrue(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
	
	@Test(priority = 19)
	public void clickForgotPassword() {
		try {
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
			Thread.sleep(2000);
			Assert.assertTrue(Utility.isElementPresent(driver, "fortifiedImg"), "Fortified Logo Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "forgotPasswordTitle"), "Forgot Password Title Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "forgotPasswordText"), "Forgot Password Text Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "usernameInputBox"), "Username Input Box Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "resetPasswordButton"), "Reset Password Button Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "ForgotPasswordBackIcon"), "Forgot Password Back Button Not Found");
			Thread.sleep(5000);
			driver.navigate().back();
			//Utility.findElement(driver, "ForgotPasswordBackIcon").click();			
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
	
	@Test(priority = 20)
	public void checkEmptyPassword() {
		try {
			Thread.sleep(2000);
			Utility.findElement(driver, "loginButton").click();
			Thread.sleep(5000);
			Assert.assertTrue(Utility.isElementPresent(driver, "alertIcon"), "Alert Icon Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "userSignInErrorID"), "Error Message Not Found");
			Thread.sleep(2000);
			if(!Utility.findElement(driver, "userSignInErrorID").getText().equals("Incorrect password.")) {
				Assert.assertTrue(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
	
	@Test(priority = 21)
	public void verifyLoginFlow() {
		try {
			Thread.sleep(5000);
			Utility.findElement(driver, "passwordInput").sendKeys(PropertiesFile.getInstance().getPassword());
			Thread.sleep(5000);
			Utility.findElement(driver, "loginButton").click();
			Thread.sleep(15000);
			Utility.findElement(driver, "SettingsTabButton").click();
			Thread.sleep(10000);
			if(flag) {
				Utility.findElement(driver, "logOutMenuButton").click();
				Thread.sleep(3000);
				Utility.findElement(driver, "logoutYesButton").click();
			}
			else {
				int width = (int) Math.round(DimensionUtil.getWidth(driver)*0.5);
				int height = (int) Math.round(DimensionUtil.getHeight(driver)*0.4);
				TouchAction tap = new TouchAction(driver);
				tap.tap(width, height).perform();
				//tap.tap(86, 339).perform();
				Thread.sleep(3000);
				int width1 = (int) Math.round(DimensionUtil.getWidth(driver)*0.78);
				int height1 = (int) Math.round(DimensionUtil.getHeight(driver)*0.53);
				tap.tap(width1, height1).perform();
				//tap.tap(304, 448).perform();
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
	

}
