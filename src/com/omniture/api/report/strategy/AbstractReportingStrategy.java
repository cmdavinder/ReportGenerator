package com.omniture.api.report.strategy;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.omniture.api.model.Metric;
import com.omniture.api.report.param.ReportParams;
import com.omniture.api.utils.ExcelUtils;

/**
 * The Class AbstractReportingStrategy is an abstract support class for all
 * {@link ReportingStrategy} implementations.
 * 
 * @author Davinder
 */
public abstract class AbstractReportingStrategy implements ReportingStrategy {

	private ReportParams params;

	/**
	 * Instantiates a new abstract reporting strategy.
	 *
	 * @param params
	 *            the params
	 */
	protected AbstractReportingStrategy(ReportParams params) {
		this.params = params;
		addReportingMetrics();
	}

	/**
	 * Gets the params.
	 *
	 * @return the params
	 */
	protected ReportParams getParams() {
		return this.params;
	}

	/**
	 * Gets the XLXS work book.
	 *
	 * @return the XLXS work book
	 * @throws Exception
	 *             the exception
	 */
	protected XSSFWorkbook getXLXSWorkBook() throws Exception {
		return ExcelUtils.readXLSXFile(params.getReportPath());
	}

	/**
	 * Adds the reporting metrics.
	 */
	private void addReportingMetrics() {
		for (Metric metric : params.getReport().getMetrics()) {
			params.getReportMetrics().add(metric.getName());
		}
	}
}
