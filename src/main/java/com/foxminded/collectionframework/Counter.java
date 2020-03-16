package com.foxminded.collectionframework;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Counter {
	
	public Map<String, Long> count(String text) {
		Map<String, Long> letterOccurrence = new HashMap<>();
		letterOccurrence = Stream.of(text.split("")).collect(groupingBy(s -> s, mapping(s -> s, counting())));		
		return letterOccurrence;
	}
}
