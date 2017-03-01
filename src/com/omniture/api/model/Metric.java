package com.omniture.api.model;

/**
 * The Class Metric represents "metrics" element of {@link Report}
 *
 * @author Davinder
 */
public class Metric {

	private String id;
	private String name;
	private String type;
	private int decimals;
	private int latency;
	private boolean current;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id
	 *            the new id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name
	 *            the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

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
	 * Gets the decimals.
	 *
	 * @return the decimals
	 */
	public int getDecimals() {
		return decimals;
	}

	/**
	 * Sets the decimals.
	 *
	 * @param decimals
	 *            the new decimals
	 */
	public void setDecimals(int decimals) {
		this.decimals = decimals;
	}

	/**
	 * Gets the latency.
	 *
	 * @return the latency
	 */
	public int getLatency() {
		return latency;
	}

	/**
	 * Sets the latency.
	 *
	 * @param latency
	 *            the new latency
	 */
	public void setLatency(int latency) {
		this.latency = latency;
	}

	/**
	 * Checks if is current.
	 *
	 * @return true, if is current
	 */
	public boolean isCurrent() {
		return current;
	}

	/**
	 * Sets the current.
	 *
	 * @param current
	 *            the new current
	 */
	public void setCurrent(boolean current) {
		this.current = current;
	}

}
