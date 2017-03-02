package com.omniture.api.utils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * The Class DateUtils.
 */
public class DateUtils {

	/**
	 * Gets the date object from day, month and year. The generated Date object
	 * will by default have 00:00:00 time set.
	 *
	 * @param day
	 *            the day
	 * @param month
	 *            the month
	 * @param year
	 *            the year
	 * @return the date
	 */
	public static Date getDate(int day, int month, int year) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, day);
		calendar.set(Calendar.MONTH, month - 1);
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime();
	}

	/**
	 * Gets the date object from hourm day, month and year. The generated Date
	 * object will by default have {hour}:00:00 time set.
	 *
	 * @param hour
	 *            the hour
	 * @param day
	 *            the day
	 * @param month
	 *            the month
	 * @param year
	 *            the year
	 * @return the date
	 */
	public static Date getDate(int hour, int day, int month, int year) {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(Calendar.DAY_OF_MONTH, day);
		calendar.set(Calendar.MONTH, month);
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.HOUR_OF_DAY, hour);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime();
	}

	/**
	 * Gets the date object with respect to date passed to the method. The new
	 * date object is then created as per valeu of {days} integer passed to the
	 * method.
	 *
	 * @param date
	 *            the date
	 * @param days
	 *            the days are specified
	 * @return the date
	 */
	public static Date getDate(Date date, int days) {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, days);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime();
	}

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		List<Date> reportingDates = new ArrayList<Date>();
		reportingDates.add(getDate(26, 1, 2017));
		reportingDates.add(getDate(27, 1, 2017));
		Date jan28 = getDate(28, 1, 2017);
		reportingDates.add(jan28);

		Date date = getDate(jan28, -1);
		System.out.println(date);

		int index = Collections.binarySearch(reportingDates, getDate(jan28, -1), new Comparator<Date>() {

			@Override
			public int compare(Date date1, Date date2) {
				if (date1.getDay() == date2.getDay() && date1.getMonth() == date2.getMonth()
						&& date1.getYear() == date2.getYear()) {
					return 0;
				}
				return date1.compareTo(date2);
			}
		});
		System.out.println("index = " + index);

	}
}
