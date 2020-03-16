package com.foxminded.collectionframework;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;

import java.util.Map;
import java.util.stream.Stream;

public class DistinctLetterCounter implements LetterCounter {

	@Override
	public Map<String, Long> count(String text) {
		return Stream.of(text.split("")).collect(groupingBy(s -> s, mapping(s -> s, counting())));
	}
}
