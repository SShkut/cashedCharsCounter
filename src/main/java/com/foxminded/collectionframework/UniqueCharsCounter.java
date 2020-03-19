package com.foxminded.collectionframework;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Stream;

public class UniqueCharsCounter implements CharsCounter {

	@Override
	public Map<Character, Long> count(String text) {
		if (text.isEmpty()) {
			return new LinkedHashMap<>();
		}
		return Stream.of(text.split("")).collect(groupingBy(s -> s.charAt(0), LinkedHashMap::new, mapping(s -> s, counting())));
	}
}
