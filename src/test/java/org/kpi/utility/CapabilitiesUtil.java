package org.kpi.utility;

import org.kpi.properties.PropertiesFile;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.remote.MobileCapabilityType;

public class CapabilitiesUtil {
	
	private CapabilitiesUtil() {}
	
	public static DesiredCapabilities getAndroidCapabilities() {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, PropertiesFile.getInstance().getAndroidDeviceName());
		dc.setCapability("platformName", "android");
		dc.setCapability("appPackage", "com.fortifiedhealthsecurity.centralcommand.android");
		dc.setCapability("appActivity", ".MainActivity");
		//dc.setCapability("noReset", true);
		//dc.setCapability("appWaitForLaunch", false);
		return dc;
	}
	
	/*public static DesiredCapabilities getiOSCapabilities() {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 12");
		dc.setCapability("platformName", "iOS");
		dc.setCapability("bundleId", "com.fortifiedhealthsecurity.centralcommand.iOS");
		//dc.setCapability("udid", "a16506caa89bf9bea8f95c16048712193d227383");
		dc.setCapability("automationName", "XCUITest");
		dc.setCapability("xcodeOrgId", "AB82VL5Y26");
		dc.setCapability("xcodeSigningId", "Sid Gaikwad");
		return dc;
	}*/
	
	public static DesiredCapabilities getiOSCapabilities() {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, PropertiesFile.getInstance().getIosDeviceName());
		dc.setCapability("platformName", "iOS");
		dc.setCapability("bundleId", "com.fortifiedhealthsecurity.centralcommand.iOS");
		//dc.setCapability("udid", "auto");
		dc.setCapability("automationName", "XCUITest");
		dc.setCapability("xcodeOrgId", "AB82VL5Y26");
		dc.setCapability("xcodeSigningId", "Sid Gaikwad");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, PropertiesFile.getInstance().getIosPlatformVersion());
		dc.setCapability("clearSystemFiles", true);
		dc.setCapability("noReset", true);
		dc.setCapability("usePrebuiltWDA", true);
		return dc;
	}

}
