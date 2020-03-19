package com.foxminded.collectionframework;

import java.util.Map;

public interface CharsCounter {
	
	Map<Character, Long> count(String text);
}
