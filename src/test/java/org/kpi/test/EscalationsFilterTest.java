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

public class EscalationsFilterTest {

	private AppiumDriver<MobileElement> driver;
	boolean flag = Platform.IS_ANDROID;

	@BeforeMethod
	public void initiateDriver() {
		driver = TestConfig.getInstance().driver;
	}

	@Test(priority = 0)
	public void checkFilterButtonElements() {
		try {
			Thread.sleep(10000);
			if (flag) {
				Utility.findElement(driver, "filterButton").click();
			} else {
				TouchAction tap = new TouchAction(driver);
				int width = (int) Math.round(DimensionUtil.getWidth(driver) * 0.9);
				int height = (int) Math.round(DimensionUtil.getHeight(driver) * 0.83);
				tap.tap(width, height).perform();
				// tap.tap(350, 700).perform();
			}
			Thread.sleep(5000);
			Assert.assertTrue(Utility.isElementPresent(driver, "filterByTitle"), "Filter By Title Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "SeveritySection"), "Severity Section Not Found");
			//Assert.assertTrue(Utility.isElementPresent(driver, "HighLabel"), "High Label in Severity Section Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "HighCheckBox"), "High Check Box for High Label in Severity Section Not Found");
			//Assert.assertTrue(Utility.isElementPresent(driver, "MediumLabel"), "Medium Label in Severity Section Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "MediumCheckBox"), "Medium Check Box for Medium Label in Severity Section Not Found");
			//Assert.assertTrue(Utility.isElementPresent(driver, "LowLabel"), "Low Label in Severity Section Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "LowCheckBox"), "Low Check Box for Low Label in Severity Section Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "AcknowledgementSection"), "Acknowledgement Section Not Found");
			//Assert.assertTrue(Utility.isElementPresent(driver, "AcknowledgedLabel"), "Acknowledged Label in Acknowledgement Section Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "AcknowledgedCheckBox"), "Acknowledged Check Box for Acknowledged Label in Acknowledgement Section Not Found");
			//Assert.assertTrue(Utility.isElementPresent(driver, "UnacknowledgedLabel"), "Unacknowledged Label in Acknowledgement Section Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "UnacknowledgedCheckBox"), "Unacknowledged Check Box for Unacknowledged Label in Acknowledgement Section Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "StatusSection"), "Status Section Not Found");
			//Assert.assertTrue(Utility.isElementPresent(driver, "OpenLabel"), "Open Label in Status Section Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "OpenCheckBox"), "Open Check Box for Open Label in Status Section Not Found");
			//Assert.assertTrue(Utility.isElementPresent(driver, "In ProgressLabel"), "In Progress Label in Status Section Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "In ProgressCheckBox"), "In Progress Check Box for In Progress Label in Status Section Not Found");
			//Assert.assertTrue(Utility.isElementPresent(driver, "ClosedLabel"), "Closed Label in Status Section Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "ClosedCheckBox"), "Closed Check Box for Closed Label in Status Section Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "TimeSection"), "Time Section Not Found");
			//Assert.assertTrue(Utility.isElementPresent(driver, "Last 24 HoursLabel"), "Last24hours Label in Time Section Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "Last 24 HoursCheckBox"), "Last24hours Check Box for Last24hours Label in Time Section Not Found");
			//Assert.assertTrue(Utility.isElementPresent(driver, "Last 7 DaysLabel"), "Last7days Label in Time Section Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "Last 7 DaysCheckBox"), "Last7days Check Box for Last7days Label in Time Section Not Found");
			
			/*Thread.sleep(2000);
			if(!Utility.findElement(driver, "filterByTitle").getText().equals("Filters")) {
				Assert.assertTrue(false);
			}
			if(!Utility.findElement(driver, "SeveritySection").getText().equals("Severity")) {
				Assert.assertTrue(false);
			}
			if(!Utility.findElement(driver, "HighLabel").getText().equals("High")) {
				Assert.assertTrue(false);
			}
			if(!Utility.findElement(driver, "MediumLabel").getText().equals("Medium")) {
				Assert.assertTrue(false);
			}
			if(!Utility.findElement(driver, "LowLabel").getText().equals("Low")) {
				Assert.assertTrue(false);
			}
			if(!Utility.findElement(driver, "AcknowledgementSection").getText().equals("Acknowledgement")) {
				Assert.assertTrue(false);
			}
			if(!Utility.findElement(driver, "AcknowledgedLabel").getText().equals("Acknowledged")) {
				Assert.assertTrue(false);
			}
			if(!Utility.findElement(driver, "UnacknowledgedLabel").getText().equals("Unacknowledged")) {
				Assert.assertTrue(false);
			}
			if(!Utility.findElement(driver, "StatusSection").getText().equals("Status")) {
				Assert.assertTrue(false);
			}
			if(!Utility.findElement(driver, "OpenLabel").getText().equals("Open")) {
				Assert.assertTrue(false);
			}
			if(!Utility.findElement(driver, "In ProgressLabel").getText().equals("In Progress")) {
				Assert.assertTrue(false);
			}
			if(!Utility.findElement(driver, "ClosedLabel").getText().equals("Closed")) {
				Assert.assertTrue(false);
			}
			if(!Utility.findElement(driver, "TimeSection").getText().equals("Time")) {
				Assert.assertTrue(false);
			}
			if(!Utility.findElement(driver, "Last 24 HoursLabel").getText().equals("Last 24 Hours")) {
				Assert.assertTrue(false);
			}
			if(!Utility.findElement(driver, "Last 7 DaysLabel").getText().equals("Last 7 Days")) {
				Assert.assertTrue(false);
			}*/
			
			if (flag) {
				int width = (int) Math.round(DimensionUtil.getWidth(driver)*0.463);
				int height = (int) Math.round(DimensionUtil.getHeight(driver)*0.813);
				int height2 = (int) Math.round(DimensionUtil.getHeight(driver)*0.497);
				driver.swipe(width, height, width, height2, 1000);
				driver.swipe(600, 1800, 600, 400, 1000);
			} else {
				driver.swipe(200, 700, 200, 200, 1000);
			}
			Thread.sleep(3000);
			Assert.assertTrue(Utility.isElementPresent(driver, "AssignmentSection"), "Assignment Section Not Found");
			//Assert.assertTrue(Utility.isElementPresent(driver, "By MeLabel"), "By Me Label in Assignment Section Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "By MeCheckBox"), "By Me CheckBox for By Me Label in Assignment Section Not Found");
			//Assert.assertTrue(Utility.isElementPresent(driver, "To MeLabel"), "To Me Label in Assignment Section Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "To MeCheckBox"), "To Me CheckBox for To Me Label in Assignment Section Not Found");
			//Assert.assertTrue(Utility.isElementPresent(driver, "UnassignedLabel"), "Unassigned Label in Assignment Section Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "UnassignedCheckBox"), "Unassigned CheckBox for UnassignedLabel in Assignment Section Not Found");
			//Assert.assertTrue(Utility.isElementPresent(driver, "FilterDropdown"), "Filter Drop down in Assignment Section Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "clearAllFiltersButton"), "Clear All Filters Button Not Found");
			
			/*Thread.sleep(2000);
			if(!Utility.findElement(driver, "AssignmentSection").getText().equals("Assignment")) {
				Assert.assertTrue(false);
			}
			if(!Utility.findElement(driver, "By MeLabel").getText().equals("By Me")) {
				Assert.assertTrue(false);
			}
			if(!Utility.findElement(driver, "To MeLabel").getText().equals("To Me")) {
				Assert.assertTrue(false);
			}
			if(!Utility.findElement(driver, "UnassignedLabel").getText().equals("Unassigned")) {
				Assert.assertTrue(false);
			}*/
			
			Thread.sleep(2000);
			Assert.assertTrue(Utility.isElementPresent(driver, "closeButton"), "Cancel Button Not Found");
			Assert.assertTrue(Utility.isElementPresent(driver, "applyButton"), "Submit Button Not Found");
			Thread.sleep(3000);
			Utility.findElement(driver, "closeButton").click();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}// 500,1650

	@Test(priority = 1)
	public void clickFilterCheckBox() {
		try {
			Thread.sleep(10000);
			if (flag) {
				Utility.findElement(driver, "filterButton").click();
			} else {
				TouchAction tap = new TouchAction(driver);
				int width = (int) Math.round(DimensionUtil.getWidth(driver) * 0.9);
				int height = (int) Math.round(DimensionUtil.getHeight(driver) * 0.83);
				tap.tap(width, height).perform();
				// tap.tap(350, 700).perform();
			}
			Thread.sleep(3000);
			Utility.findElement(driver, "HighCheckBox").click();
			Utility.findElement(driver, "MediumCheckBox").click();
			Utility.findElement(driver, "LowCheckBox").click();
			Thread.sleep(2000);
			Utility.findElement(driver, "AcknowledgedCheckBox").click();
			Utility.findElement(driver, "UnacknowledgedCheckBox").click();
			Thread.sleep(2000);
			Utility.findElement(driver, "OpenCheckBox").click();
			Utility.findElement(driver, "In ProgressCheckBox").click();
			Utility.findElement(driver, "ClosedCheckBox").click();
			Thread.sleep(2000);
			Utility.findElement(driver, "Last 24 HoursCheckBox").click();
			Utility.findElement(driver, "Last 7 DaysCheckBox").click();
			Thread.sleep(3000);
			driver.swipe(600, 1800, 600, 400, 1000);
			Thread.sleep(3000);
			Utility.findElement(driver, "clearAllFiltersButton").click();
			Thread.sleep(3000);
			Utility.findElement(driver, "closeButton").click();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 2)
	public void checkApplyingSeverityFilters() {
		try {
			Thread.sleep(10000);
			TouchAction tap = new TouchAction(driver);
			if (flag) {
				Utility.findElement(driver, "filterButton").click();
			} else {
				int width = (int) Math.round(DimensionUtil.getWidth(driver) * 0.9);
				int height = (int) Math.round(DimensionUtil.getHeight(driver) * 0.83);
				tap.tap(width, height).perform();
				// tap.tap(350, 700).perform();
			}
			Thread.sleep(3000);
			Utility.findElement(driver, "HighCheckBox").click();
			Thread.sleep(3000);
			Utility.findElement(driver, "applyButton").click();
			if (flag) {
				Thread.sleep(10000);
				Assert.assertTrue(Utility.isElementPresent(driver, "HighLabel"), "High Label Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "HighLabelCloseButton"),
						"High Label Close Button Not Found");
				Thread.sleep(3000);
				Utility.findElement(driver, "HighLabelCloseButton").click();
			} else {
				Thread.sleep(3000);
				int width1 = (int) Math.round(DimensionUtil.getWidth(driver) * 0.19);
				int height1 = (int) Math.round(DimensionUtil.getHeight(driver) * 0.23);
				tap.tap(width1, height1).perform();
				// tap.tap(75, 194).perform();
			}
			Thread.sleep(10000);
			if (flag) {
				Utility.findElement(driver, "filterButton").click();
			} else {
				int width2 = (int) Math.round(DimensionUtil.getWidth(driver) * 0.9);
				int height2 = (int) Math.round(DimensionUtil.getHeight(driver) * 0.83);
				tap.tap(width2, height2).perform();
				// tap.tap(350, 700).perform();
			}
			Thread.sleep(3000);
			Utility.findElement(driver, "MediumCheckBox").click();
			Thread.sleep(3000);
			Utility.findElement(driver, "applyButton").click();
			if (flag) {
				Thread.sleep(10000);
				Assert.assertTrue(Utility.isElementPresent(driver, "MediumLabel"), "Medium Label Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "MediumLabelCloseButton"),
						"Medium Label Close Button Not Found");
				Thread.sleep(3000);
				Utility.findElement(driver, "MediumLabelCloseButton").click();
			} else {
				Thread.sleep(5000);
				int width3 = (int) Math.round(DimensionUtil.getWidth(driver) * 0.25);
				int height3 = (int) Math.round(DimensionUtil.getHeight(driver) * 0.23);
				tap.tap(width3, height3).perform();
				// tap.tap(97, 193).perform();
			}
			Thread.sleep(10000);
			if (flag) {
				Utility.findElement(driver, "filterButton").click();
			} else {
				int width4 = (int) Math.round(DimensionUtil.getWidth(driver) * 0.9);
				int height4 = (int) Math.round(DimensionUtil.getHeight(driver) * 0.83);
				tap.tap(width4, height4).perform();
				// tap.tap(350, 700).perform();
			}
			Thread.sleep(3000);
			Utility.findElement(driver, "LowCheckBox").click();
			Thread.sleep(3000);
			Utility.findElement(driver, "applyButton").click();
			if (flag) {
				Thread.sleep(10000);
				Assert.assertTrue(Utility.isElementPresent(driver, "LowLabel"), "Low Label Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "LowLabelCloseButton"),
						"Low Label Close Button Not Found");
				Thread.sleep(3000);
				Utility.findElement(driver, "LowLabelCloseButton").click();
			} else {
				Thread.sleep(5000);
				int width5 = (int) Math.round(DimensionUtil.getWidth(driver) * 0.19);
				int height5 = (int) Math.round(DimensionUtil.getHeight(driver) * 0.23);
				tap.tap(width5, height5).perform();
				// tap.tap(72, 194).perform();
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 3)
	public void checkApplyingAckFilters() {
		try {
			Thread.sleep(10000);
			TouchAction tap = new TouchAction(driver);
			if (flag) {
				Utility.findElement(driver, "filterButton").click();
			} else {
				int width = (int) Math.round(DimensionUtil.getWidth(driver) * 0.9);
				int height = (int) Math.round(DimensionUtil.getHeight(driver) * 0.83);
				tap.tap(width, height).perform();
				// tap.tap(350, 700).perform();
			}
			Thread.sleep(3000);
			Utility.findElement(driver, "AcknowledgedCheckBox").click();
			Thread.sleep(3000);
			Utility.findElement(driver, "applyButton").click();
			if (flag) {
				Thread.sleep(10000);
				Assert.assertTrue(Utility.isElementPresent(driver, "AcknowledgedLabel"),
						"Acknowledged Label Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "AcknowledgedLabelCloseButton"),
						"Acknowledged Label Close Button Not Found");
				Thread.sleep(3000);
				Utility.findElement(driver, "AcknowledgedLabelCloseButton").click();
			} else {
				Thread.sleep(3000);
				int width1 = (int) Math.round(DimensionUtil.getWidth(driver) * 0.36);
				int height1 = (int) Math.round(DimensionUtil.getHeight(driver) * 0.23);
				tap.tap(width1, height1).perform();
				// tap.tap(139, 194).perform();
			}
			Thread.sleep(10000);
			if (flag) {
				Utility.findElement(driver, "filterButton").click();
			} else {
				int width = (int) Math.round(DimensionUtil.getWidth(driver) * 0.9);
				int height = (int) Math.round(DimensionUtil.getHeight(driver) * 0.83);
				tap.tap(width, height).perform();
				// tap.tap(350, 700).perform();
			}
			Thread.sleep(3000);
			Utility.findElement(driver, "UnacknowledgedCheckBox").click();
			Thread.sleep(3000);
			Utility.findElement(driver, "applyButton").click();
			if (flag) {
				Thread.sleep(10000);
				Assert.assertTrue(Utility.isElementPresent(driver, "UnacknowledgedLabel"),
						"Unacknowledged Label Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "UnacknowledgedLabelCloseButton"),
						"Unacknowledged Label Close Button Not Found");
				Thread.sleep(3000);
				Utility.findElement(driver, "UnacknowledgedLabelCloseButton").click();
			} else {
				Thread.sleep(3000);
				int width3 = (int) Math.round(DimensionUtil.getWidth(driver) * 0.4);
				int height3 = (int) Math.round(DimensionUtil.getHeight(driver) * 0.23);
				tap.tap(width3, height3).perform();
				// tap.tap(155, 194).perform();
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 4)
	public void checkApplyingStatusFilters() {
		try {
			Thread.sleep(10000);
			TouchAction tap = new TouchAction(driver);
			if (flag) {
				Utility.findElement(driver, "filterButton").click();
			} else {
				int width = (int) Math.round(DimensionUtil.getWidth(driver) * 0.9);
				int height = (int) Math.round(DimensionUtil.getHeight(driver) * 0.83);
				tap.tap(width, height).perform();
				// tap.tap(350, 700).perform();
			}
			Thread.sleep(3000);
			Utility.findElement(driver, "OpenCheckBox").click();
			Thread.sleep(3000);
			Utility.findElement(driver, "applyButton").click();
			if (flag) {
				Thread.sleep(10000);
				Assert.assertTrue(Utility.isElementPresent(driver, "OpenLabel"), "Open Label Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "OpenLabelCloseButton"),
						"Open Label Close Button Not Found");
				Thread.sleep(3000);
				Utility.findElement(driver, "OpenLabelCloseButton").click();
			} else {
				Thread.sleep(3000);
				int width1 = (int) Math.round(DimensionUtil.getWidth(driver) * 0.2);
				int height1 = (int) Math.round(DimensionUtil.getHeight(driver) * 0.23);
				tap.tap(width1, height1).perform();
				// tap.tap(78, 196).perform();
			}
			Thread.sleep(10000);
			if (flag) {
				Utility.findElement(driver, "filterButton").click();
			} else {
				int width = (int) Math.round(DimensionUtil.getWidth(driver) * 0.9);
				int height = (int) Math.round(DimensionUtil.getHeight(driver) * 0.83);
				tap.tap(width, height).perform();
				// tap.tap(350, 700).perform();
			}
			Thread.sleep(3000);
			Utility.findElement(driver, "In ProgressCheckBox").click();
			Thread.sleep(3000);
			Utility.findElement(driver, "applyButton").click();
			if (flag) {
				Thread.sleep(10000);
				Assert.assertTrue(Utility.isElementPresent(driver, "In ProgressLabel"), "In Progress Label Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "In ProgressLabelCloseButton"),
						"In Progress Label Close Button Not Found");
				Thread.sleep(3000);
				Utility.findElement(driver, "In ProgressLabelCloseButton").click();
			} else {
				Thread.sleep(5000);
				int width3 = (int) Math.round(DimensionUtil.getWidth(driver) * 0.3);
				int height3 = (int) Math.round(DimensionUtil.getHeight(driver) * 0.23);
				tap.tap(width3, height3).perform();
				// tap.tap(118, 193).perform();
			}
			Thread.sleep(10000);
			if (flag) {
				Utility.findElement(driver, "filterButton").click();
			} else {
				int width = (int) Math.round(DimensionUtil.getWidth(driver) * 0.9);
				int height = (int) Math.round(DimensionUtil.getHeight(driver) * 0.83);
				tap.tap(width, height).perform();
				// tap.tap(350, 700).perform();
			}
			Thread.sleep(3000);
			Utility.findElement(driver, "ClosedCheckBox").click();
			Thread.sleep(3000);
			Utility.findElement(driver, "applyButton").click();
			if (flag) {
				Thread.sleep(10000);
				Assert.assertTrue(Utility.isElementPresent(driver, "ClosedLabel"), "Closed Label Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "ClosedLabelCloseButton"),
						"Closed Label Close Button Not Found");
				Thread.sleep(3000);
				Utility.findElement(driver, "ClosedLabelCloseButton").click();
			} else {
				Thread.sleep(5000);
				int width5 = (int) Math.round(DimensionUtil.getWidth(driver) * 0.23);
				int height5 = (int) Math.round(DimensionUtil.getHeight(driver) * 0.23);
				tap.tap(width5, height5).perform();
				// tap.tap(89, 193).perform();
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 5)
	public void checkApplyingTimeFilters() {
		try {
			Thread.sleep(10000);
			TouchAction tap = new TouchAction(driver);
			if (flag) {
				Utility.findElement(driver, "filterButton").click();
			} else {
				int width = (int) Math.round(DimensionUtil.getWidth(driver) * 0.9);
				int height = (int) Math.round(DimensionUtil.getHeight(driver) * 0.83);
				tap.tap(width, height).perform();
				// tap.tap(350, 700).perform();
			}
			Thread.sleep(3000);
			Utility.findElement(driver, "Last 24 HoursCheckBox").click();
			Thread.sleep(3000);
			Utility.findElement(driver, "applyButton").click();
			if (flag) {
				Thread.sleep(10000);
				Assert.assertTrue(Utility.isElementPresent(driver, "Last 24 HoursLabel"),
						"Last24hours Label Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "Last 24 HoursLabelCloseButton"),
						"Last24hours Label Close Button Not Found");
				Thread.sleep(3000);
				Utility.findElement(driver, "Last 24 HoursLabelCloseButton").click();
			} else {
				Thread.sleep(3000);
				int width1 = (int) Math.round(DimensionUtil.getWidth(driver) * 0.32);
				int height1 = (int) Math.round(DimensionUtil.getHeight(driver) * 0.23);
				tap.tap(width1, height1).perform();
				// tap.tap(125, 194).perform();
			}
			Thread.sleep(10000);
			if (flag) {
				Utility.findElement(driver, "filterButton").click();
			} else {
				int width = (int) Math.round(DimensionUtil.getWidth(driver) * 0.9);
				int height = (int) Math.round(DimensionUtil.getHeight(driver) * 0.83);
				tap.tap(width, height).perform();
				// tap.tap(350, 700).perform();
			}
			Thread.sleep(3000);
			Utility.findElement(driver, "Last 7 DaysCheckBox").click();
			Thread.sleep(3000);
			Utility.findElement(driver, "applyButton").click();
			if (flag) {
				Thread.sleep(10000);
				Assert.assertTrue(Utility.isElementPresent(driver, "Last 7 DaysLabel"), "Last7days Label Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "Last 7 DaysLabelCloseButton"),
						"Last7days Label Close Button Not Found");
				Thread.sleep(3000);
				Utility.findElement(driver, "Last 7 DaysLabelCloseButton").click();
			} else {
				Thread.sleep(3000);
				int width3 = (int) Math.round(DimensionUtil.getWidth(driver) * 0.303);
				int height3 = (int) Math.round(DimensionUtil.getHeight(driver) * 0.23);
				tap.tap(width3, height3).perform();
				// tap.tap(118, 194).perform();
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 6)
	public void checkApplyingAssignmentFilters() {
		try {
			Thread.sleep(10000);
			TouchAction tap = new TouchAction(driver);
			if (flag) {
				Utility.findElement(driver, "filterButton").click();
				Thread.sleep(3000);
				driver.swipe(600, 1800, 600, 400, 1000);
			} else {
				int width = (int) Math.round(DimensionUtil.getWidth(driver) * 0.9);
				int height = (int) Math.round(DimensionUtil.getHeight(driver) * 0.83);
				tap.tap(width, height).perform();
				// tap.tap(350, 700).perform();
				Thread.sleep(3000);
				driver.swipe(200, 700, 200, 200, 1000);
			}
			Thread.sleep(3000);
			Utility.findElement(driver, "By MeCheckBox").click();
			Thread.sleep(3000);
			Utility.findElement(driver, "applyButton").click();
			if (flag) {
				Thread.sleep(10000);
				Assert.assertTrue(Utility.isElementPresent(driver, "By MeLabel"),
						"By Me Label in Assignment Section Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "By MeLabelCloseButton"),
						"By Me Label Close Button Not Found");
				Thread.sleep(3000);
				Utility.findElement(driver, "By MeLabelCloseButton").click();
			} else {
				Thread.sleep(3000);
				int width1 = (int) Math.round(DimensionUtil.getWidth(driver) * 0.32);
				int height1 = (int) Math.round(DimensionUtil.getHeight(driver) * 0.23);
				tap.tap(width1, height1).perform();
				tap.tap(84, 194).perform();
			}
			
			Thread.sleep(10000);
			if (flag) {
				Utility.findElement(driver, "filterButton").click();
				Thread.sleep(3000);
				driver.swipe(600, 1800, 600, 400, 1000);
			} else {
				int width = (int) Math.round(DimensionUtil.getWidth(driver) * 0.9);
				int height = (int) Math.round(DimensionUtil.getHeight(driver) * 0.83);
				tap.tap(width, height).perform();
				// tap.tap(350, 700).perform();
				Thread.sleep(3000);
				driver.swipe(200, 700, 200, 200, 1000);
			}
			Thread.sleep(3000);
			Utility.findElement(driver, "To MeCheckBox").click();
			Thread.sleep(3000);
			Utility.findElement(driver, "applyButton").click();
			if (flag) {
				Thread.sleep(10000);
				Assert.assertTrue(Utility.isElementPresent(driver, "To MeLabel"),
						"To Me Label in Assignment Section Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "To MeLabelCloseButton"),
						"To Me Label Close Button Not Found");
				Thread.sleep(3000);
				Utility.findElement(driver, "To MeLabelCloseButton").click();
			} else {
				Thread.sleep(3000);
				int width1 = (int) Math.round(DimensionUtil.getWidth(driver) * 0.32);
				int height1 = (int) Math.round(DimensionUtil.getHeight(driver) * 0.23);
				tap.tap(width1, height1).perform();
				tap.tap(84, 194).perform();
			}
			
			Thread.sleep(10000);
			if (flag) {
				Utility.findElement(driver, "filterButton").click();
				Thread.sleep(3000);
				driver.swipe(600, 1800, 600, 400, 1000);
			} else {
				int width = (int) Math.round(DimensionUtil.getWidth(driver) * 0.9);
				int height = (int) Math.round(DimensionUtil.getHeight(driver) * 0.83);
				tap.tap(width, height).perform();
				// tap.tap(350, 700).perform();
				Thread.sleep(3000);
				driver.swipe(200, 700, 200, 200, 1000);
			}
			Thread.sleep(3000);
			Utility.findElement(driver, "UnassignedCheckBox").click();
			Thread.sleep(3000);
			Utility.findElement(driver, "applyButton").click();
			if (flag) {
				Thread.sleep(10000);
				Assert.assertTrue(Utility.isElementPresent(driver, "UnassignedLabel"),
						"Unassigned Label in Assignment Section Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "UnassignedLabelCloseButton"),
						"Unassigned Label Close Button Not Found");
				Thread.sleep(3000);
				Utility.findElement(driver, "UnassignedLabelCloseButton").click();
			} else {
				Thread.sleep(3000);
				int width1 = (int) Math.round(DimensionUtil.getWidth(driver) * 0.32);
				int height1 = (int) Math.round(DimensionUtil.getHeight(driver) * 0.23);
				tap.tap(width1, height1).perform();
				tap.tap(119, 194).perform();
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 7)
	public void checkApplyingDropdownFilters() {
		try {
			Thread.sleep(10000);
			TouchAction tap = new TouchAction(driver);
			if (flag) {
				Utility.findElement(driver, "filterButton").click();
				Thread.sleep(3000);
				driver.swipe(600, 1800, 600, 400, 1000);
			} else {
				int width = (int) Math.round(DimensionUtil.getWidth(driver) * 0.9);
				int height = (int) Math.round(DimensionUtil.getHeight(driver) * 0.83);
				tap.tap(width, height).perform();
				// tap.tap(350, 700).perform();
				Thread.sleep(3000);
				driver.swipe(200, 700, 200, 200, 1000);
			}
			/*Thread.sleep(3000);
			if (flag) {
				tap.tap(500, 1650).perform();
			} else {
				Utility.findElement(driver, "FilterDropdown").click();
			}
			Thread.sleep(3000);
			if (flag) {
				Utility.findElement(driver, "DropdownItem").click();
			} else {
				tap.tap(120, 600).perform();
			}
			Thread.sleep(3000);
			Utility.findElement(driver, "applyButton").click();
			if (flag) {
				Thread.sleep(10000);
				Assert.assertTrue(Utility.isElementPresent(driver, "Assigned ToLabel"),
						"Assigned To Label in Assignment Section Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "Assigned ToLabelCloseButton"),
						"Assigned To Label Close Button Not Found");
				Thread.sleep(3000);
				Utility.findElement(driver, "Assigned ToLabelCloseButton").click();
			} else {
				Thread.sleep(3000);
				int width1 = (int) Math.round(DimensionUtil.getWidth(driver) * 0.32);
				int height1 = (int) Math.round(DimensionUtil.getHeight(driver) * 0.23);
				tap.tap(width1, height1).perform();
				tap.tap(223, 194).perform();
			}*/
			Thread.sleep(3000);
			Utility.findElement(driver, "closeButton").click();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 8)
	public void checkMultipleFiltersRemove() {
		try {
			Thread.sleep(10000);
			TouchAction tap = new TouchAction(driver);
			if (flag) {
				Utility.findElement(driver, "filterButton").click();
			} else {
				int width = (int) Math.round(DimensionUtil.getWidth(driver) * 0.9);
				int height = (int) Math.round(DimensionUtil.getHeight(driver) * 0.83);
				tap.tap(width, height).perform();
				// tap.tap(350, 700).perform();
			}
			Thread.sleep(3000);
			Utility.findElement(driver, "HighCheckBox").click();
			Thread.sleep(3000);
			Utility.findElement(driver, "AcknowledgedCheckBox").click();
			Thread.sleep(3000);
			Utility.findElement(driver, "In ProgressCheckBox").click();
			Thread.sleep(3000);
			Utility.findElement(driver, "Last 24 HoursCheckBox").click();
			Thread.sleep(3000);
			Utility.findElement(driver, "applyButton").click();
			if (flag) {
				Thread.sleep(10000);
				Assert.assertTrue(Utility.isElementPresent(driver, "plusButton"),
						"Plus Button in Filters Applied Not Found");
				Thread.sleep(3000);
				Utility.findElement(driver, "plusButton").click();
				Thread.sleep(3000);
				Assert.assertTrue(Utility.isElementPresent(driver, "clearFiltersButton"),
						"Clear Filters Button Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "hideButton"), "Hide Button Not Found");
				Thread.sleep(3000);
				Utility.findElement(driver, "hideButton").click();
				Thread.sleep(3000);
				Utility.findElement(driver, "plusButton").click();
				Thread.sleep(3000);
				Utility.findElement(driver, "clearFiltersButton").click();
			} else {
				Thread.sleep(3000);
				int width1 = (int) Math.round(DimensionUtil.getWidth(driver) * 0.92);
				int height1 = (int) Math.round(DimensionUtil.getHeight(driver) * 0.29);
				tap.tap(width1, height1).perform();
				// tap.tap(360, 240).perform();
				Thread.sleep(3000);
				int width2 = (int) Math.round(DimensionUtil.getWidth(driver) * 0.9);
				int height2 = (int) Math.round(DimensionUtil.getHeight(driver) * 0.35);
				tap.tap(width2, height2).perform();
				// tap.tap(350, 290).perform();
				Thread.sleep(3000);
				int width3 = (int) Math.round(DimensionUtil.getWidth(driver) * 0.92);
				int height3 = (int) Math.round(DimensionUtil.getHeight(driver) * 0.29);
				tap.tap(width3, height3).perform();
				// tap.tap(360, 240).perform();
				Thread.sleep(3000);
				int width4 = (int) Math.round(DimensionUtil.getWidth(driver) * 0.69);
				int height4 = (int) Math.round(DimensionUtil.getHeight(driver) * 0.35);
				tap.tap(width4, height4).perform();
				// tap.tap(270, 290).perform();
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 9)
	public void checkFiltersRemove() {
		try {
			Thread.sleep(10000);
			TouchAction tap = new TouchAction(driver);
			if (flag) {
				Utility.findElement(driver, "filterButton").click();
			} else {
				int width = (int) Math.round(DimensionUtil.getWidth(driver) * 0.9);
				int height = (int) Math.round(DimensionUtil.getHeight(driver) * 0.83);
				tap.tap(width, height).perform();
				// tap.tap(350, 700).perform();
			}
			Thread.sleep(3000);
			Utility.findElement(driver, "HighCheckBox").click();
			Thread.sleep(3000);
			Utility.findElement(driver, "AcknowledgedCheckBox").click();
			Thread.sleep(3000);
			Utility.findElement(driver, "In ProgressCheckBox").click();
			Thread.sleep(3000);
			Utility.findElement(driver, "Last 24 HoursCheckBox").click();
			Thread.sleep(3000);
			Utility.findElement(driver, "applyButton").click();
			if (flag) {
				Thread.sleep(10000);
				Utility.findElement(driver, "plusButton").click();
				Thread.sleep(10000);
				Utility.findElement(driver, "Last 24 HoursLabelCloseButton").click();
				Thread.sleep(10000);
				Utility.findElement(driver, "AcknowledgedLabelCloseButton").click();
				Thread.sleep(10000);
				Utility.findElement(driver, "In ProgressLabelCloseButton").click();
				Thread.sleep(10000);
				Utility.findElement(driver, "HighLabelCloseButton").click();
			} else {
				Thread.sleep(5000);
				int width1 = (int) Math.round(DimensionUtil.getWidth(driver) * 0.93);
				int height1 = (int) Math.round(DimensionUtil.getHeight(driver) * 0.29);
				tap.tap(width1, height1).perform();
				// tap.tap(360, 240).perform();
				Thread.sleep(5000);
				int width2 = (int) Math.round(DimensionUtil.getWidth(driver) * 0.32);
				int height2 = (int) Math.round(DimensionUtil.getHeight(driver) * 0.29);
				tap.tap(width2, height2).perform();
				// tap.tap(125, 247).perform();
				Thread.sleep(5000);
				int width3 = (int) Math.round(DimensionUtil.getWidth(driver) * 0.58);
				int height3 = (int) Math.round(DimensionUtil.getHeight(driver) * 0.23);
				tap.tap(width3, height3).perform();
				// tap.tap(225, 194).perform();
				Thread.sleep(5000);
				int width4 = (int) Math.round(DimensionUtil.getWidth(driver) * 0.52);
				int height4 = (int) Math.round(DimensionUtil.getHeight(driver) * 0.23);
				tap.tap(width4, height4).perform();
				// tap.tap(204, 194).perform();
				Thread.sleep(5000);
				int width5 = (int) Math.round(DimensionUtil.getWidth(driver) * 0.19);
				int height5 = (int) Math.round(DimensionUtil.getHeight(driver) * 0.23);
				tap.tap(width5, height5).perform();
				// tap.tap(75, 194).perform();
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}

	/*@Test(priority = 10)
	public void checkEmptyDataScreen() {
		try {
			Thread.sleep(5000);
			TouchAction tap = new TouchAction(driver);
			if (flag) {
				Utility.findElement(driver, "filterButton").click();
			} else {
				int width = (int) Math.round(DimensionUtil.getWidth(driver) * 0.9);
				int height = (int) Math.round(DimensionUtil.getHeight(driver) * 0.83);
				tap.tap(width, height).perform();
				// tap.tap(350, 700).perform();
			}
			Thread.sleep(3000);
			Utility.findElement(driver, "UnacknowledgedCheckBox").click();
			Thread.sleep(3000);
			Utility.findElement(driver, "applyButton").click();
			if (flag) {
				Thread.sleep(5000);
				Assert.assertTrue(Utility.isElementPresent(driver, "emptyScreenImage"), "Empty Screen Image Not Found");
				Assert.assertTrue(Utility.isElementPresent(driver, "emptyScreenText"), "Empty Screen Text Not Found");
				Thread.sleep(3000);
				Utility.findElement(driver, "UnacknowledgedLabelCloseButton").click();
			} else {
				Thread.sleep(5000);
				int width1 = (int) Math.round(DimensionUtil.getWidth(driver) * 0.4);
				int height1 = (int) Math.round(DimensionUtil.getHeight(driver) * 0.23);
				tap.tap(width1, height1).perform();
				// tap.tap(155, 194).perform();
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}*/

}
