package org.title21.utility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.TimeZone;

public class DateTimeUtils {
	
	public static SimpleDateFormat MMDDFormat = new SimpleDateFormat("MM/dd/yyyy");	
	public static SimpleDateFormat DDMMFormat = new SimpleDateFormat("MM/dd/yyyy");	
	public static SimpleDateFormat DateAndTimeFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a");
	public static SimpleDateFormat TimeFormat = new SimpleDateFormat("hh:mm a");
	
	static TimeZone PSTTimezone = TimeZone.getTimeZone("PST");
	
	/**
	 * Get Current Date PST Time
	 * 
	 * @return
	 */
	public static String getCurrentPSTDateinDDMM() {
		DDMMFormat.setTimeZone(PSTTimezone);
		return MMDDFormat.format(new Date());
	}
	
	/**
	 * Get Current Date PST date (MMDDFormat)
	 * 
	 * @return
	 */
	public static String getCurrentPSTDate() {
		MMDDFormat.setTimeZone(PSTTimezone);
		return MMDDFormat.format(new Date());
	}
	
	/**
	 * Get tomorrow date
	 * 
	 * @return
	 */
	public static String getTomorrowDate() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, 1);
		return MMDDFormat.format(cal.getTime());
	}
	
	public static String getFutureSpecDate(int NoOfDays) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, NoOfDays);
		return MMDDFormat.format(cal.getTime());
	}
	
	/**
	 * Get yesterday's date
	 * 
	 * @return
	 */
	public static String getYesterdayDate() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, -1);
		return MMDDFormat.format(cal.getTime());
	}
		
	/**
	 * Get Future date
	 * 
	 * @return
	 */
	public static String getFutureDate() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH,+new Random().nextInt(100));
		return MMDDFormat.format(cal.getTime());
	}	
	
}
