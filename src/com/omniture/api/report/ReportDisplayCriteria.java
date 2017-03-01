package com.omniture.api.report;

import java.util.Date;
import java.util.List;

import com.omniture.api.model.DataRow;

/**
 * The Interface ReportDisplayCriteria can be implemented by any class which
 * intends to filter out data from total data received in JSON for display
 * purpose.
 * 
 * @author Davinder
 */
public interface ReportDisplayCriteria {

	/**
	 * Meet criteria.
	 *
	 * @param rows
	 *            the rows
	 * @param reportingDates
	 *            the reporting dates
	 * @return the list
	 */
	public List<DataRow> meetCriteria(List<DataRow> rows, List<Date> reportingDates);

}
