package com.omniture.api.utils;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * The Class JSONUtils.
 */
public class JSONUtils {

	private static ObjectMapper mapper = new ObjectMapper();

	/**
	 * Generic implementation for converting Java objects from JSON string.
	 *
	 * @param <T>
	 *            the generic type
	 * @param json
	 *            the json string
	 * @param clazz
	 *            the clazz
	 * @return the t
	 * @throws Exception
	 *             the exception
	 */
	public static <T> T fromJSON(String json, Class<T> clazz) throws Exception {
		return mapper.readValue(json, clazz);
	}

	/**
	 * Generic implementation for converting Java objects from JSON string
	 * written in file.
	 *
	 * @param <T>
	 *            the generic type
	 * @param file
	 *            the file containig JSON string
	 * @param clazz
	 *            the clazz
	 * @return the t
	 * @throws Exception
	 *             the exception
	 */
	public static <T> T fromJSON(File file, Class<T> clazz) throws Exception {
		return mapper.readValue(file, clazz);
	}

	/**
	 * Generic implementation for converting JSON to Java objects.
	 *
	 * @param <T>
	 *            the generic type
	 * @param obj
	 *            the obj to be conberted to JSON string
	 * @return the string
	 * @throws Exception
	 *             the exception
	 */
	public static <T> String toJSON(T obj) throws Exception {
		return mapper.writeValueAsString(obj);
	}
}
