package org.kpi.pdf.model;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.testng.ITestResult;


public class ResultMeta {
	
	public String suiteName;
	
	public List<Set<ITestResult>> passedList = new LinkedList<Set<ITestResult>>();
	public List<Set<ITestResult>> failedList = new LinkedList<Set<ITestResult>>();
	public List<Set<ITestResult>> skippedList = new LinkedList<Set<ITestResult>>();
	
	public String getSuiteName() {
		return suiteName;
	}
	public void setSuiteName(String suiteName) {
		this.suiteName = suiteName;
	}
	public List<Set<ITestResult>> getPassedList() {
		return passedList;
	}
	public void setPassedList(List<Set<ITestResult>> passedList) {
		this.passedList = passedList;
	}
	public List<Set<ITestResult>> getFailedList() {
		return failedList;
	}
	public void setFailedList(List<Set<ITestResult>> failedList) {
		this.failedList = failedList;
	}
	public List<Set<ITestResult>> getSkippedList() {
		return skippedList;
	}
	public void setSkippedList(List<Set<ITestResult>> skippedList) {
		this.skippedList = skippedList;
	}

}
