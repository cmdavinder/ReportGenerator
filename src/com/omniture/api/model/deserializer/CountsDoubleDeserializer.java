package com.omniture.api.model.deserializer;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.omniture.api.model.DataRow;

/**
 * The Class CountsListDoubleDeserializer is the custom de-serializer of counts
 * field of {@link DataRow}'
 * 
 * @author Davinder
 */
public class CountsDoubleDeserializer extends JsonDeserializer<Double> {

	private static final Double DEFAULT_VALUE = 00.00D;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.fasterxml.jackson.databind.JsonDeserializer#deserialize(com.fasterxml
	 * .jackson.core.JsonParser,
	 * com.fasterxml.jackson.databind.DeserializationContext)
	 */
	@Override
	public Double deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {

		List<String> countsList = jp.readValueAs(new TypeReference<List<String>>() {
		});
		if (!countsList.isEmpty()) {
			try {
				Double counts = Double.parseDouble(countsList.get(0));
				return counts;
			} catch (NumberFormatException nfe) {
				return DEFAULT_VALUE;
			}
		} else
			return DEFAULT_VALUE;

	}
}
