package org.kpi.pdf;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.kpi.pdf.model.ResultMeta;
import org.kpi.properties.PropertiesFile;
import org.kpi.test.TestConfig;
import org.kpi.utility.DateUtil;
import org.testng.ITestContext;
import org.testng.ITestResult;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.kernel.events.PdfDocumentEvent;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.AreaBreak;

public class PDFGenerator {
	
	public void generatePDF(Map<String, ResultMeta> result, ITestContext context) {
		try {
			if(result != null && result.size() > 0) {
				int passed = 0, failed = 0, skipped = 0, total = 0;
				//String path = "/Users/kishorependyala/Desktop/TestCasesPDF/fortified_testcases_report.pdf";
				String path = PropertiesFile.getInstance().getPdfPath()+PropertiesFile.getInstance().getPdfFileName();
				PdfWriter writer = new PdfWriter(path);
				PdfDocument pdfDoc = new PdfDocument(writer);
				pdfDoc.addNewPage();
				Document doc = new Document(pdfDoc);
				AreaBreak areaBreak = new AreaBreak();

				PdfFont font = PdfFontFactory.createFont(FontConstants.HELVETICA);

				pdfDoc.addEventHandler(PdfDocumentEvent.END_PAGE, new PageHeader());
				pdfDoc.addEventHandler(PdfDocumentEvent.END_PAGE, new PageFooter(doc));
				
				PdfPage page = pdfDoc.getFirstPage();

				for(String suiteName : result.keySet()) {
					ResultMeta resultMeta = result.get(suiteName);

					List<ITestResult> passList = new LinkedList<ITestResult>();
					List<ITestResult> failList = new LinkedList<ITestResult>();
					List<ITestResult> skipList = new LinkedList<ITestResult>();

					if(resultMeta.getPassedList() != null && resultMeta.getPassedList().size() > 0) {
						for(Set<ITestResult> itrs : resultMeta.getPassedList()) {
							passList.addAll(itrs);
						}
					}

					if(resultMeta.getFailedList() != null && resultMeta.getFailedList().size() > 0) {
						for(Set<ITestResult> itrs : resultMeta.getFailedList()) {
							failList.addAll(itrs);
						}
					}

					if(resultMeta.getSkippedList() != null && resultMeta.getSkippedList().size() > 0) {
						for(Set<ITestResult> itrs : resultMeta.getSkippedList()) {
							skipList.addAll(itrs);
						}
					}

					passed = passList.size();
					failed = failList.size();
					skipped = skipList.size();
					
					System.out.println("Passed :: "+passList.size());
					System.out.println("Failed :: "+failList.size());
					System.out.println("Skipped :: "+skipList.size());

					total = passed + failed + skipped;
					PDFUIGenerator.generateDetailsTable(doc, font, getAllDetails());
					PDFUIGenerator.generateCircles(doc, pdfDoc, font, page, total, passed, failed, skipped);
					if(passList.size()>0) {
						if(passList.size()>10) {
							List<ITestResult> firstPageList = passList.subList(0, 10);
							System.out.println("First Page List :: "+firstPageList.size());
							PDFUIGenerator.generatePassedTable(doc, font, firstPageList);
							List<ITestResult> reminaingPassedList = passList.subList(10, passList.size());
							System.out.println("Total Value:"+reminaingPassedList.size());
							for(var value : chunkList(reminaingPassedList, 30)) {
								System.out.println("Value:"+value.size());
								if(value != null && value.size() > 0) {
									PDFUIGenerator.generateSecondPassedTable(doc, font, value);
								}
							}
						}
						else {
							PDFUIGenerator.generatePassedTable(doc, font, passList);
						}
						/*List<ITestResult> reminaingPassedList = null;
						if(passList.size()>10) {	
						  reminaingPassedList=passList.subList(10, passList.size());
						  System.out.println("Total Value:"+reminaingPassedList.size());
						  for(var value: chunkList(reminaingPassedList,30)) {
							  System.out.println("Value:"+value.size());
							  if(value!=null && value.size()>0)
							   PDFUIGenerator.generateSecondPassedTable(doc, font, value);
						  }
						  
						}*/
						/*doc.add(areaBreak);
						List<ITestResult> passedList = passList.subList(0, passList.size());
						for(var value : chunkList(passedList, 30)) {
							if(value != null && value.size()>0) {
								PDFUIGenerator.generateSecondPassedTable(doc, font, value);
							}
						}*/
					}
					if(failed>0) {
						doc.add(areaBreak);
						for(var value: chunkList(failList,30)) {
							  System.out.println("Value:"+value.size());
							  if(value!=null && value.size()>0)
							   PDFUIGenerator.generateFailedTable(doc, font, value);
						  }
					}
					if(skipped>0) {
						doc.add(areaBreak);
						for(var value: chunkList(skipList,30)) {
							  System.out.println("Value:"+value.size());
							  if(value!=null && value.size()>0)
							   PDFUIGenerator.generateSkippedTable(doc, font, value);
						  }
					}
				}//for each loop
				doc.close();
				System.out.println("PDF report generated in path :: "+path);
			}//if
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//generatePDF

	private static  <T> List<List<T>> chunkList(List<T> list, int chunkSize) {
	    if (chunkSize <= 0) {
	        throw new IllegalArgumentException("Invalid chunk size: " + chunkSize);
	    }
	    List<List<T>> chunkList = new ArrayList<>(list.size() / chunkSize);
	    for (int i = 0; i < list.size(); i += chunkSize) {
	        chunkList.add(list.subList(i, i + chunkSize >= list.size() ? list.size() : i + chunkSize));
	    }
	    return chunkList;
	}//chunkList
	
	private static Map<String, String> getAllDetails(){
		PropertiesFile props = PropertiesFile.getInstance();
		boolean isAndroid = props.getIsAndroid().equalsIgnoreCase("true");
		String os;
		String osVersion;
		if(isAndroid) {
			os = "Android";
			osVersion = props.getAndroidPlatformVersion();
		}
		else {
			os = "iOS";
			osVersion = props.getIosPlatformVersion();
		}
		Map<String, String> map = new LinkedHashMap<>();
		map.put("Build Version", props.getBuildVersion());
		map.put("Environment", props.getEnvironment());
		map.put("Device OS", os);
		map.put("Device OS Version", osVersion);
		map.put("Client Name", "Client A");
		map.put("Username", props.getUsername());
		map.put("User Role", "Leader, Owner, Analyst");
		map.put("Execution Duration", DateUtil.getConvertedTime(TestConfig.startTime, TestConfig.endTime));
		map.put("Automation Tool", props.getAutomationToolName());
		map.put("Automation Tool Version", props.getAutomationToolVersion());
		return map;
	}

}// class