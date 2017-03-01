package com.omniture.api.report;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.omniture.api.model.DataRow;

/**
 * The Class DisplayData represents object to hold data displayed in reports. It
 * also provides access to iterators for sorted and unsorted report data.
 * 
 * @author Davinder
 */
public class DisplayData {

	private List<DataRow> rows;

	/**
	 * Instantiates a new display data.
	 *
	 * @param rows
	 *            the rows
	 */
	public DisplayData(List<DataRow> rows) {
		this.rows = rows;
	}

	/**
	 * Gets the rows.
	 *
	 * @return the rows
	 */
	public List<DataRow> getRows() {
		return rows;
	}

	/**
	 * Sets the rows.
	 *
	 * @param rows
	 *            the new rows
	 */
	public void setRows(List<DataRow> rows) {
		this.rows = rows;
	}

	/**
	 * Gives access to Iterator for {@link DisplayData} collection.
	 *
	 * @return the display data iterator
	 */
	public DisplayDataIterator iterator() {
		return new DisplayDataIterator(this);
	}

	/**
	 * Gives access to sorted Iterator for {@link DisplayData} collection.
	 *
	 * @param comparator
	 *            the comparator
	 * @return the display data iterator
	 */
	public DisplayDataIterator sortedIterator(Comparator<DataRow> comparator) {
		Collections.sort(rows, comparator);
		return new DisplayDataIterator(this);
	}
}
