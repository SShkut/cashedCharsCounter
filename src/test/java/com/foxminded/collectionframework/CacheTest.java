package com.foxminded.collectionframework;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CacheTest {
	
	private Map<String, Map<String, Long>> expected;
	private Map<String, Long> letterOccurrence;
	private Cache cache = new Cache();

	@BeforeEach
	void setUp() throws Exception {
		expected = new HashMap<String, Map<String, Long>>();
		letterOccurrence = new HashMap<String, Long>();
	}

	@Test
	void givenNewLetterOccurrence_whenAddToCach_thenAdded() {
		String text = "abcdeabc";
		letterOccurrence.put("a", 2L);
		letterOccurrence.put("b", 2L);
		letterOccurrence.put("c", 2L);
		letterOccurrence.put("d", 1L);
		letterOccurrence.put("e", 1L);
		
		expected.put(text, letterOccurrence);		
		cache.addToCache(letterOccurrence, text);		
		assertEquals(expected.get(text), cache.getValueFromCache(text));		
	}
	
	@Test
	void givenTwoIdenticalLetterOccurence_whenAddToChach_thenOnlyOneAdded() {
		String text = "abcdeabc";
		letterOccurrence.put("a", 2L);
		letterOccurrence.put("b", 2L);
		letterOccurrence.put("c", 2L);
		letterOccurrence.put("d", 1L);
		letterOccurrence.put("e", 1L);		
		
		expected.put(text, letterOccurrence);		
		cache.addToCache(letterOccurrence, text);
		cache.addToCache(letterOccurrence, text);
		
		assertEquals(expected.get(text), cache.getValueFromCache(text));
	}
}
