package org.kpi.listener;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.kpi.pdf.PDFGenerator;
import org.kpi.pdf.model.ResultMeta;
import org.kpi.properties.PropertiesFile;
import org.kpi.utility.Platform;
import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.xml.XmlSuite;

public class ReportsListener implements IReporter {
	
	public static Map<String, ResultMeta> result = new HashMap<String, ResultMeta>();
	
	@Override
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		ResultMeta resultMeta = null;
		ITestContext tc = null;
		for(ISuite suite : suites) {
			String suiteName = suite.getName();
			Map<String, ISuiteResult> suiteResults = suite.getResults();
			for(ISuiteResult sr : suiteResults.values()) {
				if(result.get(suiteName) != null) {
					resultMeta = result.get(suiteName);
				}
				else {
					resultMeta = new ResultMeta();
					resultMeta.setSuiteName(suiteName);
				}
				tc = sr.getTestContext();
				if(tc.getPassedTests().getAllResults() != null && tc.getPassedTests().getAllResults().size() > 0) {
					resultMeta.getPassedList().add(tc.getPassedTests().getAllResults());
				}
				if(tc.getFailedTests().getAllResults() != null && tc.getFailedTests().getAllResults().size() > 0) {
					resultMeta.getFailedList().add(tc.getFailedTests().getAllResults());
				}
				if(tc.getSkippedTests().getAllResults() != null && tc.getSkippedTests().getAllResults().size() > 0) {
					resultMeta.getSkippedList().add(tc.getSkippedTests().getAllResults());
				}
				result.put(suiteName, resultMeta);
			}
			///ITestContext context = null;
			for(String key : suiteResults.keySet()) {
				tc = suiteResults.get(key).getTestContext();
			}
			if(result.size() > 0) {
				PDFGenerator pdfGenerator = new PDFGenerator();
				pdfGenerator.generatePDF(result, tc);
			}
		}
		//IReporter.super.generateReport(xmlSuites, suites, outputDirectory);
		sendEmail();
	}
	
	public void sendEmail() {
		boolean flag = Platform.IS_ANDROID;
		String to = PropertiesFile.getInstance().getReceiverEmail();
		String from = PropertiesFile.getInstance().getSenderEmail();
		final String username = PropertiesFile.getInstance().getEmailUsername();
		final String password = PropertiesFile.getInstance().getEmailPassword();
		
		String host = "smtp.gmail.com";
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		
		// Get Session Object
		Session session = Session.getInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		
		try {
			// Create a default MimeMessage object
			Message msg = new MimeMessage(session);
			
			// Set From: header field of the header
			msg.setFrom(new InternetAddress(from));
			
			InternetAddress[] receiversList = InternetAddress.parse(to, true);
			
			// Set To: header field of the header
			msg.setRecipients(Message.RecipientType.TO, receiversList);
			
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
			
			if(flag) {
				msg.setSubject("Fortified App Test Report for Android "+sdf.format(date));
			}
			else {
				// Set Subject: header field
				msg.setSubject("Fortified App Test Report for IOS "+sdf.format(date));
			}
			
			// Create the message part
			BodyPart msgBodyPart = new MimeBodyPart();
			
			// Now set the actual message
			msgBodyPart.setText("Please find the attached document as Fortified app test report");
			
			// Create a multipart message
			Multipart multipart = new MimeMultipart();
			
			// Set text message part
			multipart.addBodyPart(msgBodyPart);
			
			// Part two is attachment
			String fileName = PropertiesFile.getInstance().getPdfPath()+PropertiesFile.getInstance().getPdfFileName();;
			DataSource fileDataSource = new FileDataSource(fileName);
			msgBodyPart.setDataHandler(new DataHandler(fileDataSource));
			if(flag) {
				msgBodyPart.setFileName("Fortified_Test_Report_Android.pdf");
			}
			else {
				msgBodyPart.setFileName("Fortified_Test_Report_IOS.pdf");
			}
			
			multipart.addBodyPart(msgBodyPart);
			
			// Send the complete message parts
			msg.setContent(multipart);
			
			// Send message
			Transport.send(msg);
			
			System.out.println("PDf Report emailed to "+to);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
