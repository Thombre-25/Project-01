package org.kpi.listener;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.kpi.test.TestConfig;
import org.openqa.selenium.OutputType;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class TestListener implements ITestListener {
	
	@Override
	public void onTestStart(ITestResult result) {
		
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("SUCCESS:" + result.getName());
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("FAIL:" + result.getName());
		try {
			AppiumDriver<MobileElement> driver = TestConfig.getInstance().driver;
			if(driver != null) {
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
				LocalDateTime currentDateTime = LocalDateTime.now();
				File file = driver.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(file, new File("screenshots/"+result.getName()+"_"+dtf.format(currentDateTime)+".png"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("SKIP:" + result.getName());
	}
	
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("PARTIAL SUCCESS:" + result.getName());
	}
	
	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("TIMEOUT:" + result.getName());
	}
	
	@Override
	public void onStart(ITestContext context) {
		
	}
	
	@Override
	public void onFinish(ITestContext context) {
		
	}

}
