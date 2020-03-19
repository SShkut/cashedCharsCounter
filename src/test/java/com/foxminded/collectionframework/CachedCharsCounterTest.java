package com.foxminded.collectionframework;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

class CachedCharsCounterTest {
	
	@InjectMocks
	private CachedCharasCounter cache;
	
	@Mock
	private UniqueCharsCounter charsCounter;
	
	@BeforeEach
	void setUp() {
		initMocks(this);
	}
	
	@Test
	void givenTwoSameStrings_whenCount_thenOneCountInvoke() {
		String text = "HeLlo World!";
		
		cache.count(text);
		cache.count(text);
		
		verify(charsCounter, times(1)).count(text);
	}
	
	@Test
	void givenText_whenCount_thenCorrectResult() {
		String text = "HellO World  !";		
		Map<Character, Long> expected = new LinkedHashMap<>();
		expected.put('H', 1L);
		expected.put('e', 1L);
		expected.put('l', 3L);
		expected.put('O', 1L);
		expected.put(' ', 3L);
		expected.put('W', 1L);
		expected.put('o', 1L);
		expected.put('r', 1L);
		expected.put('d', 1L);		
		
		when(charsCounter.count(text)).thenReturn(expected);
		Map<Character, Long> actual = cache.count(text);		
		
		assertEquals(expected, actual);
	}
}
