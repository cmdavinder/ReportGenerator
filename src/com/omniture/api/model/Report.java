/*
 * 
 */
package com.omniture.api.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The Class Report represents report element of {@link ViberReponse}.
 * 
 * @author Davinder
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Report {

	private String type;
	private List<Metric> metrics;
	private List<DataRow> data;

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * Sets the type.
	 *
	 * @param type
	 *            the new type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Gets the metrics.
	 *
	 * @return the metrics
	 */
	public List<Metric> getMetrics() {
		return metrics;
	}

	/**
	 * Sets the metrics.
	 *
	 * @param metrics
	 *            the new metrics
	 */
	public void setMetrics(List<Metric> metrics) {
		this.metrics = metrics;
	}

	/**
	 * Gets the data.
	 *
	 * @return the data
	 */
	public List<DataRow> getData() {
		return data;
	}

	/**
	 * Sets the data.
	 *
	 * @param data
	 *            the new data
	 */
	public void setData(List<DataRow> data) {
		this.data = data;
	}
}
