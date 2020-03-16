package com.foxminded.collectionframework;

import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		LetterCounter counter = new DistinctLetterCounterCached(new DistinctLetterCounter());
		Formatter printer = new Formatter();
		Scanner scanner = new Scanner(System.in);
		
		while (scanner.hasNext()) {
			String text = scanner.nextLine();
			Map<String, Long> letterOccurrence = counter.count(text);
			System.out.println(printer.format(letterOccurrence, text));
		}
		scanner.close();
	}
}