package org.kpi.utility;

import org.kpi.properties.PropertiesFile;

public interface Platform {
	
	boolean IS_ANDROID = PropertiesFile.getInstance().getIsAndroid().equalsIgnoreCase("true");

}
