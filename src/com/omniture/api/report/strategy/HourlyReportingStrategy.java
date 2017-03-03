package com.omniture.api.report.strategy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.omniture.api.model.DataRow;
import com.omniture.api.report.HourlyReportDisplayCriteria;
import com.omniture.api.report.ReportDisplayCriteria;
import com.omniture.api.report.param.ReportParams;
import com.omniture.api.utils.DateUtils;
import com.omniture.api.utils.ExcelUtils;

/**
 * The Class HourlyReportingStrategy is an implementation of
 * {@link ReportingStrategy} for generating hourly reports.
 * 
 * @author Davinder
 */
public class HourlyReportingStrategy extends AbstractReportingStrategy {

	private static final int[] REPORTING_PAST_DAYS = { -1, -7, -28 };
	private static final int FIRST_ROW_INDEX = 21;
	private static final int FIRST_COLUMN_INDEX = 3;
	private static final int COLUMN_INCREMENT_FACTOR = 4;
	private static final int ROWS_TO_PROCESS = 24;
	private static final int COLUMNS_TO_PROCESS = REPORTING_PAST_DAYS.length + 1;

	/**
	 * Instantiates a new hourly reporting strategy.
	 *
	 * @param params
	 *            the params
	 */
	public HourlyReportingStrategy(ReportParams params) {
		super(params);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.omniture.api.report.strategy.ReportingStrategy#writeReport()
	 */
	@SuppressWarnings("deprecation")
	@Override
	public void writeReport() throws Exception {
		XSSFWorkbook workbook = getXLXSWorkBook();
		List<DataRow> allRows = getParams().getReport().getData();
		ReportDisplayCriteria criteria = new HourlyReportDisplayCriteria();
		List<DataRow> displayRows = criteria.meetCriteria(allRows, getReportingDates());
		Collections.sort(displayRows, getComparator());
		Iterator<DataRow> iterator = displayRows.iterator();

		for (int sheetIdx = 0; sheetIdx < workbook.getNumberOfSheets(); sheetIdx++) {
			XSSFSheet sheet = workbook.getSheetAt(sheetIdx);
			String sheetName = sheet.getSheetName();
			if (getParams().getReportMetrics().contains(sheetName)) {
				for (int i = 0, j = 0; i < COLUMNS_TO_PROCESS; i++) {
					for (int k = 0; k < ROWS_TO_PROCESS; k++) {
						Row row = sheet.getRow(FIRST_ROW_INDEX + k);
						Cell cell = row.getCell(FIRST_COLUMN_INDEX + j);
						if (iterator.hasNext()) {
							Double counts = iterator.next().getCounts();
							cell.setCellType(Cell.CELL_TYPE_NUMERIC);
							cell.setCellValue(counts);
						}
					}
					j = (i == 0) ? j + COLUMN_INCREMENT_FACTOR - 1 : j + COLUMN_INCREMENT_FACTOR;
				}
			}
		}
		ExcelUtils.writeXLSXFile(workbook, getParams().getReportPath());
	}

	/**
	 * Gets the reporting dates as speciafied in
	 * {@link HourlyReportingStrategy#REPORTING_PAST_DAYS}. "-n" will get Date
	 * object of date n days ago.
	 *
	 * @return the reporting dates
	 */
	private List<Date> getReportingDates() {
		List<Date> reportingDates = new ArrayList<Date>();
		List<DataRow> allRows = getParams().getReport().getData();
		DataRow lastRow = allRows.get(allRows.size() - 1);
		Date currentDate = DateUtils.getDate(lastRow.getDay(), lastRow.getMonth(), lastRow.getYear());
		reportingDates.add(currentDate);
		for (int i = 0; i < REPORTING_PAST_DAYS.length; i++) {
			Date newDate = DateUtils.getDate(currentDate, REPORTING_PAST_DAYS[i]);
			reportingDates.add(newDate);
		}
		return reportingDates;
	}

	/**
	 * Gets the comparator for sorting data based on dates in descending order.
	 *
	 * @param rows
	 *            the rows
	 * @return the comparator
	 */
	private Comparator<DataRow> getComparator() {
		return new Comparator<DataRow>() {
			@Override
			public int compare(DataRow o1, DataRow o2) {
				Date dateo1 = DateUtils.getDate(o1.getHour(), o1.getDay(), o1.getMonth(), o1.getYear());
				Date dateo2 = DateUtils.getDate(o2.getHour(), o2.getDay(), o2.getMonth(), o2.getYear());
				return dateo1.compareTo(dateo2);
			}
		};

	}
}
