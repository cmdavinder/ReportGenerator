package com.omniture.api.report.param;

import java.util.ArrayList;
import java.util.List;

import com.omniture.api.model.Report;

/**
 * The Class ReportParams is parameters class for Report.
 * 
 */
public class ReportParams {

	private Report report;
	private String reportPath;
	private List<String> reportMetrics = new ArrayList<String>();

	/**
	 * Gets the report.
	 *
	 * @return the report
	 */
	public Report getReport() {
		return report;
	}

	/**
	 * Sets the report.
	 *
	 * @param report
	 *            the new report
	 */
	public void setReport(Report report) {
		this.report = report;
	}

	/**
	 * Gets the report path.
	 *
	 * @return the report path
	 */
	public String getReportPath() {
		return reportPath;
	}

	/**
	 * Sets the report path.
	 *
	 * @param reportPath
	 *            the new report path
	 */
	public void setReportPath(String reportPath) {
		this.reportPath = reportPath;
	}

	/**
	 * Gets the report metrics.
	 *
	 * @return the report metrics
	 */
	public List<String> getReportMetrics() {
		return reportMetrics;
	}

	/**
	 * Sets the report metrics.
	 *
	 * @param reportMetrics
	 *            the new report metrics
	 */
	public void setReportMetrics(List<String> reportMetrics) {
		this.reportMetrics = reportMetrics;
	}
}
