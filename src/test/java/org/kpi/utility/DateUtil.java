package org.kpi.utility;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtil {

	public static String convertMillisToDate(long millis) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss");
		Date date = new Date(millis);
		return sdf.format(date);
	}

	public static String getCurrentDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
		return sdf.format(new Date());
	}

	public static String getConvertedTime(Instant startTime, Instant endTime) {
		long difference = Duration.between(startTime, endTime).getSeconds();
		long hours = difference / 3600;
		long minutes = (difference % 3600) / 60;
		long seconds = difference % 60;
		String hoursString = (hours > 0 ? String.valueOf(hours) + " " + "Hour" : "");
		String minutesString = (minutes < 10 && minutes > 0 && hours > 0 ? "0" : "") + (minutes > 0 ? (hours > 0 && seconds == 0 ? String.valueOf(minutes) : String.valueOf(minutes) + " " + "Minutes") : "");
		String secondsString = (seconds == 0 && (hours > 0 || minutes > 0) ? "" : (seconds < 10 && (hours > 0 || minutes > 0) ? "0" : "") + String.valueOf(seconds) + " " + "Seconds");
		return 	hoursString + (hours > 0 ? " " : "") + minutesString + (minutes > 0 ? " " : "") + secondsString;
	}

	public static boolean isVTMLive() {
		ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("America/Chicago"));
		Calendar calendar = GregorianCalendar.from(zonedDateTime);
		if(isNotWeekend(calendar) && isWorkingHours(calendar)) {
			return true;
		}
		else {
			return false;
		}
	}

	private static boolean isNotWeekend(Calendar calendar) {
		if(calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
			return false;
		}
		else {
			return true;
		}
	}
	
	private static boolean isWorkingHours(Calendar calendar) {
		if(calendar.get(Calendar.HOUR) >= 8 && calendar.get(Calendar.HOUR) <= 17) {
			return true;
		}
		else {
			return false;
		}
	}

}
