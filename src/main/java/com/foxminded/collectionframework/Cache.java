package com.foxminded.collectionframework;

import java.util.HashMap;
import java.util.Map;

public class Cache {
	
	private Map<String, Map<String, Long>> cachedResults;

	public Cache() {
		cachedResults = new HashMap<>();
	}

	public void addToCache(Map<String, Long> letterOccurrence, String text) {
		boolean searchResult = cachedResults.containsKey(text);
		if (!searchResult) {
			cachedResults.put(text, letterOccurrence);
		}
	}
	
	public Map<String, Long> getValueFromCache(String text) {
		return cachedResults.get(text);
	}
}
