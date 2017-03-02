/*
 * 
 */
package com.omniture.api;

import java.io.File;

import com.omniture.api.model.ViberReponse;
import com.omniture.api.report.param.ReportParams;
import com.omniture.api.report.strategy.HourlyReportingStrategy;
import com.omniture.api.report.strategy.ReportingStrategy;
import com.omniture.api.utils.JSONUtils;

public class Main {

	private static final String EXCEL_PATH = "C:\\Users\\Davinder\\Desktop\\sample_data\\report.xlsx";
	private static final String SAMPLE_JSON_FILE = "C:\\Users\\Davinder\\Desktop\\sample_data\\Viber_Response_Hour_Report.json";

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {

		try {
			ViberReponse response = JSONUtils.fromJSON(new File(SAMPLE_JSON_FILE), ViberReponse.class);
			ReportParams params = new ReportParams();
			params.setReport(response.getReport());
			params.setReportPath(EXCEL_PATH);
			ReportingStrategy reporting = new HourlyReportingStrategy(params);
			reporting.writeReport();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
