package com.omniture.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.omniture.api.model.deserializer.CountsListDoubleDeserializer;

/**
 * The Class DataRow represents single data element in {@link Report} "data"
 * array.
 * 
 * @author Davinder
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DataRow {
	private String name;
	private int year;
	private int month;
	private int day;
	private int hour;

	@JsonDeserialize(using = CountsListDoubleDeserializer.class)
	private Double counts;

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name
	 *            the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the year.
	 *
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * Sets the year.
	 *
	 * @param year
	 *            the new year
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * Gets the month.
	 *
	 * @return the month
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * Sets the month.
	 *
	 * @param month
	 *            the new month
	 */
	public void setMonth(int month) {
		this.month = month;
	}

	/**
	 * Gets the day.
	 *
	 * @return the day
	 */
	public int getDay() {
		return day;
	}

	/**
	 * Sets the day.
	 *
	 * @param day
	 *            the new day
	 */
	public void setDay(int day) {
		this.day = day;
	}

	/**
	 * Gets the hour.
	 *
	 * @return the hour
	 */
	public int getHour() {
		return hour;
	}

	/**
	 * Sets the hour.
	 *
	 * @param hour
	 *            the new hour
	 */
	public void setHour(int hour) {
		this.hour = hour;
	}

	/**
	 * Gets the counts.
	 *
	 * @return the counts
	 */
	public Double getCounts() {
		return counts;
	}

	/**
	 * Sets the counts.
	 *
	 * @param counts
	 *            the new counts
	 */
	public void setCounts(Double counts) {
		this.counts = counts;
	}
}
