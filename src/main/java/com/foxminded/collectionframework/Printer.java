package com.foxminded.collectionframework;

import java.util.Map;

public class Printer {

	public void print(Map<String, Long> letterOccurrence, String text) {
		System.out.println(text);
		for (String key : letterOccurrence.keySet()) {
			System.out.println("\"" + key + "\"" + " - " + letterOccurrence.get(key));
		}
	}
}
