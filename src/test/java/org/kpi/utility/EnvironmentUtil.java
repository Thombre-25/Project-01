package org.kpi.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class EnvironmentUtil {
	
	public static void changeEnvironment(AppiumDriver<MobileElement> driver, boolean flag) {
		try {
			//AndroidDriver<MobileElement> driver = TestConfig.getInstance().getAndroidDriver();
			Thread.sleep(15000);
			if(flag) {
				/*MobileElement me = Utility.findElement(driver, "usernameInput");
				me.sendKeys("0000");
				me.sendKeys(Keys.BACK_SPACE);
				me.sendKeys(Keys.BACK_SPACE);*/
				//me.sendKeys(Keys.NUMPAD0);
				driver.getKeyboard().sendKeys("0000");
				//Utility.findElement(driver, "usernameInput").sendKeys("0000", Keys.DELETE, Keys.DELETE);
				/*Thread.sleep(1000);
				Utility.findElement(driver, "usernameInput").sendKeys(Keys.BACK_SPACE);
				Utility.findElement(driver, "usernameInput").sendKeys(Keys.BACK_SPACE);*/
				/*Thread.sleep(2000);
				MobileElement me1 = Utility.findElement(driver, "usernameInput");
				me1.sendKeys("0");*/
				Thread.sleep(3000);
				driver.findElementByXPath("//android.widget.TextView[@text='QA']").click();
				Thread.sleep(3000);
				driver.findElementByXPath("//android.widget.Button[@resource-id='EnvModelSubmitBtn']").click();
			}
			/*Utility.findElement(driver, "usernameInput").click();
			driver.pressKeyCode(AndroidKeyCode.KEYCODE_0);
			driver.pressKeyCode(AndroidKeyCode.KEYCODE_0);
			driver.pressKeyCode(AndroidKeyCode.KEYCODE_0);
			driver.pressKeyCode(AndroidKeyCode.KEYCODE_0);
			Thread.sleep(3000);
			driver.findElementByXPath("//android.widget.TextView[@text='QA']").click();
			Thread.sleep(3000);
			driver.findElementByXPath("//android.widget.Button[@resource-id='EnvModelSubmitBtn']").click();*/
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}

}
