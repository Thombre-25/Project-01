package org.kpi.properties;

import java.io.FileInputStream;
import java.util.Properties;

import lombok.Data;

@Data
public class PropertiesFile {
	
	public static PropertiesFile propertiesFile;
	
	private PropertiesFile() {
	}
	
	private String username;
	private String password;
	private String ssoUsername;
	private String ssoPassword;
	private String parentChildUsername;
	private String isAndroid;
	private String androidDeviceName;
	private String iosDeviceName;
	private String iosPlatformVersion;
	private String pdfPath;
	private String pdfFileName;
	private String receiverEmail;
	private String senderEmail;
	private String emailUsername;
	private String emailPassword;
	private String buildVersion;
	private String environment;
	private String androidPlatformVersion;
	private String automationToolName;
	private String automationToolVersion;
	
	public void loadProperties() {
		Properties props;
		FileInputStream fis;
		try {
			fis = new FileInputStream("src/test/resources/config.properties");
			props = new Properties();
			props.load(fis);
			username = props.getProperty("client.username");
			password = props.getProperty("client.password");
			parentChildUsername = props.getProperty("client.parentChild.username");
			isAndroid = props.getProperty("os.isAndroid");
			androidDeviceName = props.getProperty("android.deviceName");
			iosDeviceName = props.getProperty("ios.deviceName");
			iosPlatformVersion = props.getProperty("ios.platformVersion");
			pdfPath = props.getProperty("pdfReport.output.path");
			pdfFileName = props.getProperty("pdfReport.fileName");
			receiverEmail = props.getProperty("email.receiver");
			senderEmail = props.getProperty("email.sender");
			emailUsername = props.getProperty("email.username");
			emailPassword = props.getProperty("email.password");
			buildVersion = props.getProperty("app.build.version");
			environment = props.getProperty("app.environment");
			androidPlatformVersion = props.getProperty("android.platformVersion");
			automationToolName = props.getProperty("automation.tool.name");
			automationToolVersion = props.getProperty("automation.tool.version");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static PropertiesFile getInstance() {
		if(propertiesFile == null) {
			propertiesFile = new PropertiesFile();
			propertiesFile.loadProperties();
		}
		return propertiesFile;
	}

	
	
	

}
