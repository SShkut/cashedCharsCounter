package com.foxminded.collectionframework;

import java.util.HashMap;
import java.util.Map;

public class CachedCharasCounter extends CharsCounterDecorator {
	
	private Map<String, Map<Character, Long>> cache;

	public CachedCharasCounter(CharsCounter charsCounter) {
		super(charsCounter);
		this.cache = new HashMap<>();
	}

	@Override
	public Map<Character, Long> count(String text) {		
		return cache.computeIfAbsent(text, t -> charsCounter.count(t));
	}
}
