package com.foxminded.collectionframework;

import java.util.Map;

public class Formatter {
	
	private static final String NEWLINE = System.lineSeparator();

	public String format(Map<String, Long> letterOccurrence, String text) {
		StringBuilder result = new StringBuilder();
		result.append(text + NEWLINE);
		for (Map.Entry<String, Long> key : letterOccurrence.entrySet()) {
			result.append("\"" + key.getKey() + "\"" + " - " + key.getValue() + NEWLINE);
		}
		return result.toString();
	}
}
