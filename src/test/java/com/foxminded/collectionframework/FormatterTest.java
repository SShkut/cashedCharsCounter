package com.foxminded.collectionframework;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FormatterTest {
	
	private static final String NEWLINE = System.lineSeparator();	
	private LetterCounter counter;
	private Formatter formatter;

	@BeforeEach
	void setUp() throws Exception {
		counter = new DistinctLetterCounterCached(new DistinctLetterCounter());
		formatter = new Formatter();
	}

	@Test
	void givenText_whenPrint_thenPrintInfo() {
		String text = "Hello world!";
		StringBuilder expected = new StringBuilder();
		expected.append(text + NEWLINE)
				.append("\"H\" - 1" + NEWLINE)
				.append("\"e\" - 1" + NEWLINE)
				.append("\"l\" - 3" + NEWLINE)
				.append("\"o\" - 2" + NEWLINE)
				.append("\"w\" - 1" + NEWLINE)
				.append("\"r\" - 1" + NEWLINE)
				.append("\"d\" - 1" + NEWLINE)
				.append("\"!\" - 1" + NEWLINE);
		String actual = formatter.format(counter.count(text), text);
		assertEquals(expected, actual);
	}
}