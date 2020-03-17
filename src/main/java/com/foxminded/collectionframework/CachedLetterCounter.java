package com.foxminded.collectionframework;

import java.util.HashMap;
import java.util.Map;

public class CachedLetterCounter extends CharsCounterDecorator {
	
	private Map<String, Map<Character, Long>> cache;

	public CachedLetterCounter(CharsCounter charsCounter) {
		super(charsCounter);
		this.cache = new HashMap<>();
	}

	@Override
	public Map<Character, Long> count(String text) {
		if (cache.containsKey(text)) {
			return cache.get(text);
		}
		
		Map<Character, Long> characterOccurrence = charsCounter.count(text);
		cache.put(text, characterOccurrence);	
		return characterOccurrence;
	}
}
