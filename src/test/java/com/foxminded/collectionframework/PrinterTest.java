package com.foxminded.collectionframework;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PrinterTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void givenText_whenPrint_thenPrintInfo() {
		StringBuilder expected = new StringBuilder();
		expected.append("Hello world!")
				.append("\"H\" - 1")
				.append("\"e\" - 1")
				.append("\"l\" - 3")
				.append("\"o\" - 2")
				.append("\"w\" - 1")
				.append("\"r\" - 1")
				.append("\"d\" - 1")
				.append("\"!\" - 1");
		
		fail("Not implemented");
	}
}