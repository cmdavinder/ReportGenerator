package com.omniture.api.report;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.omniture.api.model.DataRow;
import com.omniture.api.report.strategy.HourlyReportingStrategy;
import com.omniture.api.utils.DateUtils;

/**
 * The Class HourlyReportDisplayCriteria is an implementation of
 * {@link ReportDisplayCriteria} to display data for only desired dates in
 * report generated by {@link HourlyReportingStrategy#writeReport()}.
 * 
 * @author Davinder
 */
public class HourlyReportDisplayCriteria implements ReportDisplayCriteria {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.omniture.api.report.ReportDisplayCriteria#meetCriteria(java.util.
	 * List, java.util.List)
	 */
	@Override
	public List<DataRow> meetCriteria(List<DataRow> rows, List<Date> reportingDates) {
		List<DataRow> updateRows = new ArrayList<DataRow>();
		List<String> list = new ArrayList<String>();
		for (Date date : reportingDates) {
			list.add(date.toString());
		}
		for (DataRow row : rows) {
			int day = row.getDay();
			int month = row.getMonth();
			int year = row.getYear();
			Date date = DateUtils.getDate(day, month, year);
			if (list.contains(date.toString())) {
				updateRows.add(row);
			}
		}
		return updateRows;
	}
}