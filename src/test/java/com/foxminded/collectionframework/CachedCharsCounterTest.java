package com.foxminded.collectionframework;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

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
		assertEquals(charsCounter.count(text), cache.count(text));
	}
}
