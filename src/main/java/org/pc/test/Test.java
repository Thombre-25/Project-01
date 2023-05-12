package org.pc.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class Test {

	public static void main(String[] args) throws Exception {

		/*Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("CST"));
		System.out.println("Time :: " + calendar.getTime());
		calendar.setTimeZone(TimeZone.getTimeZone("CST"));
		int day = calendar.get(Calendar.DAY_OF_WEEK);
		TimeZone timeZone = calendar.getTimeZone();
		System.out.println("Day :: " + day);
		System.out.println("Time Zone :: " + timeZone.getDisplayName());
		System.out.println("Time :: " + calendar.getTime());*/
		
		/*SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
		TimeZone timeZone = TimeZone.getTimeZone("CST");
		sdf.setTimeZone(timeZone);
		System.out.println("CST :: "+sdf.format(new Date()));
		Date date = sdf.parse(sdf.format(new Date()));
		System.out.println("Date :: "+date);*/
		
		/*ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("America/Chicago"));
		Calendar calendar = GregorianCalendar.from(zonedDateTime);
		System.out.println("Date & Time :: "+zonedDateTime);
		System.out.println("Calendar :: "+calendar);
		if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || 
				calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
			System.out.println("Weekend");
		}
		else {
			System.out.println("Not a Weekend");
		}
		if(calendar.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
			System.out.println("Today is FRIDAY");
		}
		System.out.println("Time Hours :: "+calendar.get(Calendar.HOUR));
		if(calendar.get(Calendar.HOUR) >= 8 && calendar.get(Calendar.HOUR) <= 17) {
			System.out.println("Working Hours");
		}
		else {
			System.out.println("Non Working Hours");
		}*/
		System.out.println("VTM :: "+isVTMLive());

	}
	
	public static boolean isVTMLive() {
		ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("America/Chicago"));
		Calendar calendar = GregorianCalendar.from(zonedDateTime);
		System.out.println("Is Not Weekend :: "+isNotWeekend(calendar));
		System.out.println("Is Working Hours :: "+isWorkingHours(calendar));
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
		if(calendar.get(Calendar.HOUR) >= 8 && calendar.get(Calendar.HOUR) <=17) {
			return true;
		}
		else {
			return false;
		}
	}

}
