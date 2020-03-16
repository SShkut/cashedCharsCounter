package com.foxminded.collectionframework;

import java.util.HashMap;
import java.util.Map;

public class DistinctLetterCounterCached extends LetterCounterDecorator {
	
	Map<String, Map<String, Long>> cachedResults;

	public DistinctLetterCounterCached(LetterCounter letterCounter) {
		super(letterCounter);
		this.cachedResults = new HashMap<>();
	}

	@Override
	public Map<String, Long> count(String text) {
		if (getValueFromCache(text) != null) {
			return getValueFromCache(text);
		}
		Map<String, Long> letterOccurrence = letterCounter.count(text);
		addToCache(letterOccurrence, text);		
		return getValueFromCache(text);
	}

	private void addToCache(Map<String, Long> letterOccurrence, String text) {
		boolean searchResult = cachedResults.containsKey(text);
		if (!searchResult) {
			cachedResults.put(text, letterOccurrence);
		}
	}
	
	public Map<String, Long> getValueFromCache(String text) {
		return cachedResults.get(text);
	}	
}
