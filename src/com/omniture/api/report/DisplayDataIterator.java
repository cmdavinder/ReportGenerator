package com.omniture.api.report;

import java.util.List;

import com.omniture.api.model.DataRow;

/**
 * The Class DisplayDataIterator is an iterator of {@link DisplayData}
 * collection.
 * 
 * @author Davinder
 */
public class DisplayDataIterator {

	private DisplayData displayData;
	private int idx;

	/**
	 * Instantiates a new display data iterator.
	 *
	 * @param displayData
	 *            the display data
	 */
	public DisplayDataIterator(DisplayData displayData) {
		this.displayData = displayData;
		this.idx = -1;
	}

	/**
	 * Checks for next.
	 *
	 * @return true, if successful
	 */
	public boolean hasNext() {
		return findNextIdx() != -1;
	}

	/**
	 * Next.
	 *
	 * @return the data row
	 */
	public DataRow next() {
		idx = findNextIdx();
		if (idx != -1) {
			return displayData.getRows().get(idx);
		}
		return null;
	}

	/**
	 * Find next idx.
	 *
	 * @return the int
	 */
	private int findNextIdx() {
		List<DataRow> rows = displayData.getRows();
		int tempIdx = idx;
		tempIdx++;
		if (tempIdx >= rows.size()) {
			tempIdx = -1;
		}
		return tempIdx;
	}
}
