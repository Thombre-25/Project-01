package org.kpi.test;

import java.net.URL;
import java.time.Instant;

import org.kpi.properties.PropertiesFile;
import org.kpi.utility.CapabilitiesUtil;
import org.kpi.utility.Platform;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class TestConfig {

	private static TestConfig config;

	public AppiumDriver<MobileElement> driver;
	
	public static Instant startTime;
	public static Instant endTime;

	@BeforeSuite
	public void setup() throws Exception {
		this.config = this;
		
		startTime = Instant.now();
		
		PropertiesFile.getInstance();

		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		if (Platform.IS_ANDROID)
			driver = new AndroidDriver<>(url, CapabilitiesUtil.getAndroidCapabilities());
		else
			driver = new IOSDriver<>(url, CapabilitiesUtil.getiOSCapabilities());

	}

	@AfterSuite
	public void shutdown() {
		try {
			Thread.sleep(10000);
			endTime = Instant.now();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("All Tests are Completed. Shutting down the Driver");
		driver.quit();
	}

	public static TestConfig getInstance() {
		return config;
	}
	
	public AndroidDriver<MobileElement> getAndroidDriver(){
		URL url = null;
		try {
			url = new URL("http://127.0.0.1:4723/wd/hub");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new AndroidDriver<MobileElement>(url, CapabilitiesUtil.getAndroidCapabilities());
	}

}
