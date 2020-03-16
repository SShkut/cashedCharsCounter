package com.foxminded.collectionframework;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CounterTest {
	
	private Counter counter;
	private Map<String, Long> result;
	private Map<String, Long> expected;

	@BeforeEach
	void setUp() throws Exception {
		counter = new Counter();
		result = new HashMap<String, Long>();
		expected = new HashMap<String, Long>();
	}

	@Test
	void givenLowerCaseString_whenCount_thenLetterOccurrenceInfo() {
		String text = "abcdeabc";
		expected.put("a", 2L);
		expected.put("b", 2L);
		expected.put("c", 2L);
		expected.put("d", 1L);
		expected.put("e", 1L);
		result = counter.count(text);
		assertEquals(expected, result);
	}
}
