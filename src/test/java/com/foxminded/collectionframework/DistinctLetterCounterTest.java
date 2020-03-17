package com.foxminded.collectionframework;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DistinctLetterCounterTest {
	
	private DistinctLetterCounter counter;
	private Map<Character, Long> actual;
	private Map<Character, Long> expected;

	@BeforeEach
	void setUp() throws Exception {
		counter = new DistinctLetterCounter();
		actual = new LinkedHashMap<Character, Long>();
		expected = new LinkedHashMap<Character, Long>();
	}
	
	@Test
	void givenEmptyString_whenCount_thenNull() {
		String text = "";
		actual = counter.count(text);
		assertEquals(null, actual);
	}

	@Test
	void givenLowerCaseString_whenCount_thenLetterOccurrenceInfo() {
		String text = "abcdeabc";
		expected.put('a', 2L);
		expected.put('b', 2L);
		expected.put('c', 2L);
		expected.put('d', 1L);
		expected.put('e', 1L);
		actual = counter.count(text);
		assertEquals(expected, actual);
	}
	
	@Test
	void givenUpperCaseString_whenCount_thenLetterOccurrenceInfo() {
		String text = "ABCDEABC";
		expected.put('A', 2L);
		expected.put('B', 2L);
		expected.put('C', 2L);
		expected.put('D', 1L);
		expected.put('E', 1L);
		actual = counter.count(text);
		assertEquals(expected, actual);
	}
	
	@Test
	void givenLowerAndUpperCaseStringWithSpaces_whenCount_thenLetterOccurrenceInfo() {
		String text = " HeLlo  @World!@ ";
		expected.put('H', 1L);
		expected.put('e', 1L);
		expected.put('L', 1L);
		expected.put('l', 2L);
		expected.put('o', 2L);
		expected.put(' ', 4L);
		expected.put('W', 1L);
		expected.put('r', 1L);
		expected.put('d', 1L);
		expected.put('!', 1L);
		expected.put('@', 2L);
		actual = counter.count(text);
		assertEquals(expected, actual);
	}
}