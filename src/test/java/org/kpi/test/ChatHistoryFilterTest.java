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

public class ChatHistoryFilterTest {
	
	private AppiumDriver<MobileElement> driver;
	boolean flag = Platform.IS_ANDROID;

	@BeforeMethod
	public void initiateDriver() {
		driver = TestConfig.getInstance().driver;
	}
	
	@Test(priority = 0)
	public void checkCHFilterElements() {
		try {
			Thread.sleep(5000);
			if(flag) {
				Utility.findElement(driver, "chatHistoryMenuButton").click();
			}
			else {
				int width = (int) Math.round(DimensionUtil.getWidth(driver)*0.5);
				int height = (int) Math.round(DimensionUtil.getHeight(driver)*0.28);
				TouchAction tap = new TouchAction(driver);
				tap.tap(width, height).perform();
			}
			Thread.sleep(5000);
			Assert.assertTrue(Utility.isElementPresent(driver, "chatFilterButton"), "Filter Button in Live Chat History Not Found");
			Thread.sleep(3000);
			Utility.findElement(driver, "chatFilterButton").click();
			Thread.sleep(5000);
			Assert.assertTrue(Utility.isElementPresent(driver, "filterByTitle"), "Filter Title in Live Chat History Filters Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "TimeSection"), "Time Section in Live Chat History Filters Not Found");
			//Assert.assertTrue(Utility.isElementPresent(driver, "Last 24 HoursLabel"), "Last24hours Label in Time Section in Live Chat History Filters Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "Last 24 HoursCheckBox"), "Last24hours Check Box for Last24hours Label in Time Section in Live Chat History Filters Not Found");
			//Assert.assertTrue(Utility.isElementPresent(driver, "Last 7 DaysLabel"), "Last7days Label in Time Section in Live Chat History Filters Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "Last 7 DaysCheckBox"), "Last7days Check Box for Last7days Label in Time Section in Live Chat History Filters Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "ServiceSection"), "Service Section in Live Chat History Filters Not Found");
			Thread.sleep(2000);
			if(!Utility.findElement(driver, "filterByTitle").getText().equals("Filters")) {
				Assert.assertTrue(false);
			}
			if(!Utility.findElement(driver, "TimeSection").getText().equals("Time")) {
				Assert.assertTrue(false);
			}
			/*if(!Utility.findElement(driver, "Last 24 HoursLabel").getText().equals("Last 24 Hours")) {
				Assert.assertTrue(false);
			}
			if(!Utility.findElement(driver, "Last 7 DaysLabel").getText().equals("Last 7 Days")) {
				Assert.assertTrue(false);
			}*/
			if(!Utility.findElement(driver, "ServiceSection").getText().equals("Service")) {
				Assert.assertTrue(false);
			}
			
			if(Utility.isElementPresent(driver, "VTMCheckBox")) {
				//Assert.assertTrue(Utility.isElementPresent(driver, "VTMLabel"), "VTM Label in Service Section in Live Chat History Filters Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "VTMCheckBox"), "VTM Check Box for VTM Label in Service Section in Live Chat History Filters Not Found");
				/*Thread.sleep(2000);
				if(!Utility.findElement(driver, "VTMLabel").getText().equals("VTM")) {
					Assert.assertTrue(false);
				}*/
			}
			if(Utility.isElementPresent(driver, "IOMTCheckBox")) {
				//Assert.assertTrue(Utility.isElementPresent(driver, "IOMTLabel"), "IOMT Label in Service Section in Live Chat History Filters Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "IOMTCheckBox"), "IOMT Check Box for IOMT Label in Service Section in Live Chat History Filters Not Found");
				/*Thread.sleep(2000);
				if(!Utility.findElement(driver, "IOMTLabel").getText().equals("IOMT")) {
					Assert.assertTrue(false);
				}*/
			}
			if(Utility.isElementPresent(driver, "MDRCheckBox")) {
				//Assert.assertTrue(Utility.isElementPresent(driver, "MDRLabel"), "MDR Label in Service Section in Live Chat History Filters Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "MDRCheckBox"), "MDR Check Box for MDR Label in Service Section in Live Chat History Filters Not Found");
				/*Thread.sleep(2000);
				if(!Utility.findElement(driver, "MDRLabel").getText().equals("MDR")) {
					Assert.assertTrue(false);
				}*/
			}
			if(Utility.isElementPresent(driver, "SIEMCheckBox")) {
				//Assert.assertTrue(Utility.isElementPresent(driver, "SIEMLabel"), "SIEM Label in Service Section in Live Chat History Filters Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "SIEMCheckBox"), "SIEM Check Box for SIEM Label in Service Section in Live Chat History Filters Not Found");
				/*Thread.sleep(2000);
				if(!Utility.findElement(driver, "SIEMLabel").getText().equals("SIEM")) {
					Assert.assertTrue(false);
				}*/
			}
			Thread.sleep(2000);
			Assert.assertTrue(Utility.isElementPresent(driver, "chatClearAllFiltersButton"), "Clear All Filters Button in Live Chat History Filters Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "chatCloseButton"), "Close Button in Live Chat History Filters Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "chatApplyButton"), "Apply Button in Live Chat History Filters Not Found");
			Thread.sleep(3000);
			Utility.findElement(driver, "chatCloseButton").click();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
	
	@Test(priority = 1)
	public void clickCHFilterCheckBox() {
		try {
			Thread.sleep(5000);
			Utility.findElement(driver, "chatFilterButton").click();
			Thread.sleep(3000);
			Utility.findElement(driver, "Last 24 HoursCheckBox").click();
			Utility.findElement(driver, "Last 7 DaysCheckBox").click();
			Thread.sleep(3000);
			if(Utility.isElementPresent(driver, "VTMCheckBox")) {
				Utility.findElement(driver, "VTMCheckBox").click();
			}
			if(Utility.isElementPresent(driver, "IOMTCheckBox")) {
				Utility.findElement(driver, "IOMTCheckBox").click();
			}
			if(Utility.isElementPresent(driver, "SIEMCheckBox")) {
				Utility.findElement(driver, "SIEMCheckBox").click();
			}
			if(Utility.isElementPresent(driver, "MDRCheckBox")) {
				Utility.findElement(driver, "MDRCheckBox").click();
			}
			Thread.sleep(3000);
			Utility.findElement(driver, "chatClearAllFiltersButton").click();
			Thread.sleep(3000);
			Utility.findElement(driver, "chatCloseButton").click();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
	
	@Test(priority = 2)
	public void checkCHTimeFilters() {
		try {
			Thread.sleep(5000);
			Utility.findElement(driver, "chatFilterButton").click();
			Thread.sleep(3000);
			Utility.findElement(driver, "Last 24 HoursCheckBox").click();
			Thread.sleep(3000);
			Utility.findElement(driver, "chatApplyButton").click();
			Thread.sleep(5000);
			Utility.findElement(driver, "chatFilterButton").click();
			Thread.sleep(3000);
			Utility.findElement(driver, "chatClearAllFiltersButton").click();
			Thread.sleep(3000);
			Utility.findElement(driver, "Last 7 DaysCheckBox").click();
			Thread.sleep(3000);
			Utility.findElement(driver, "chatApplyButton").click();
			Thread.sleep(5000);
			Utility.findElement(driver, "chatFilterButton").click();
			Thread.sleep(3000);
			Utility.findElement(driver, "chatClearAllFiltersButton").click();
			Thread.sleep(3000);
			Utility.findElement(driver, "chatApplyButton").click();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
	
	@Test(priority = 3)
	public void checkCHServiceFilters() {
		try {
			Thread.sleep(5000);
			Utility.findElement(driver, "chatFilterButton").click();
			Thread.sleep(3000);
			if(Utility.isElementPresent(driver, "VTMCheckBox")) {
				Utility.findElement(driver, "VTMCheckBox").click();
				Thread.sleep(3000);
				Utility.findElement(driver, "chatApplyButton").click();
				Thread.sleep(5000);
				Utility.findElement(driver, "chatFilterButton").click();
				Thread.sleep(3000);
				Utility.findElement(driver, "chatClearAllFiltersButton").click();
			}
			Thread.sleep(3000);
			if(Utility.isElementPresent(driver, "IOMTCheckBox")) {
				Utility.findElement(driver, "IOMTCheckBox").click();
				Thread.sleep(3000);
				Utility.findElement(driver, "chatApplyButton").click();
				Thread.sleep(5000);
				Utility.findElement(driver, "chatFilterButton").click();
				Thread.sleep(3000);
				Utility.findElement(driver, "chatClearAllFiltersButton").click();
			}
			Thread.sleep(3000);
			if(Utility.isElementPresent(driver, "SIEMCheckBox")) {
				Utility.findElement(driver, "SIEMCheckBox").click();
				Thread.sleep(3000);
				Utility.findElement(driver, "chatApplyButton").click();
				Thread.sleep(5000);
				Utility.findElement(driver, "chatFilterButton").click();
				Thread.sleep(3000);
				Utility.findElement(driver, "chatClearAllFiltersButton").click();
			}
			Thread.sleep(3000);
			if(Utility.isElementPresent(driver, "MDRCheckBox")) {
				Utility.findElement(driver, "MDRCheckBox").click();
				Thread.sleep(3000);
				Utility.findElement(driver, "chatApplyButton").click();
				Thread.sleep(5000);
				Utility.findElement(driver, "chatFilterButton").click();
				Thread.sleep(3000);
				Utility.findElement(driver, "chatClearAllFiltersButton").click();
			}
			Thread.sleep(3000);
			Utility.findElement(driver, "chatApplyButton").click();
			Thread.sleep(3000);
			Utility.findElement(driver, "chatHistoryBackButton").click();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}

}
