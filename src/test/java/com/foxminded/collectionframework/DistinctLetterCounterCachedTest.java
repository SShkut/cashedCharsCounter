package com.foxminded.collectionframework;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DistinctLetterCounterCachedTest {
	
	private LetterCounter counterCached;
	private Map<String, Long> expected;

	@BeforeEach
	void setUp() throws Exception {
		counterCached = new DistinctLetterCounterCached(new DistinctLetterCounter());
		expected = new HashMap<>();
	}

	@Test
	void givenNewLetterOccurrence_whenAddToCach_thenAdded() {
		String text = "abcdeabc";
		expected.put("a", 2L);
		expected.put("b", 2L);
		expected.put("c", 2L);
		expected.put("d", 1L);
		expected.put("e", 1L);
				
		Map<String, Long> actual = counterCached.count(text);		
		assertEquals(expected, actual);		
	}
	
	@Test
	void givenTwoIdenticalLetterOccurence_whenAddToChach_thenOnlyOneAdded() {
		String text = "abcdeabc";
		expected.put("a", 2L);
		expected.put("b", 2L);
		expected.put("c", 2L);
		expected.put("d", 1L);
		expected.put("e", 1L);		
		
		Map<String, Long> actual = counterCached.count(text);
		actual = counterCached.count(text);
		assertEquals(expected, actual);
	}
}
