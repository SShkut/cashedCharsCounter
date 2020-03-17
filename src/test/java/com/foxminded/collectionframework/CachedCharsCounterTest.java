package com.foxminded.collectionframework;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;

class CachedCharsCounterTest {
	
	private UniqueCharsCounter charsCounter = mock(UniqueCharsCounter.class);
	private CachedCharasCounter cache = new CachedCharasCounter(charsCounter);
	
	@Test
	void givenTwoSameStrings_whenCache_thenOneCountInvoke() {
		String text = "HeLlo World!";
		cache.count(text);
		cache.count(text);
		verify(charsCounter, times(1)).count(text);
	}
}
