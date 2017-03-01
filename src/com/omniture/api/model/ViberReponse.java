package com.omniture.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The Class ViberReponse represents Report JSON.
 * 
 * @author Davinder
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ViberReponse {

	private Report report;
	private String waitSeconds;
	private String runSeconds;

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
	 * Gets the wait seconds.
	 *
	 * @return the wait seconds
	 */
	public String getWaitSeconds() {
		return waitSeconds;
	}

	/**
	 * Sets the wait seconds.
	 *
	 * @param waitSeconds
	 *            the new wait seconds
	 */
	public void setWaitSeconds(String waitSeconds) {
		this.waitSeconds = waitSeconds;
	}

	/**
	 * Gets the run seconds.
	 *
	 * @return the run seconds
	 */
	public String getRunSeconds() {
		return runSeconds;
	}

	/**
	 * Sets the run seconds.
	 *
	 * @param runSeconds
	 *            the new run seconds
	 */
	public void setRunSeconds(String runSeconds) {
		this.runSeconds = runSeconds;
	}

}
