/*
 * 
 */
package com.omniture.api.report.strategy;

/**
 * The Interface ReportingStrategy must be implemented by all all different kind
 * of strategy for generating reports.
 * 
 * @author Davinder
 */
public interface ReportingStrategy {

	/**
	 * Write report.
	 *
	 * @throws Exception
	 *             the exception
	 */
	public void writeReport() throws Exception;
}
