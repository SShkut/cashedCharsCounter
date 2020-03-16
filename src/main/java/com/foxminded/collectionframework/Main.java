package com.foxminded.collectionframework;

import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Cache cache = new Cache();
		Counter counter = new Counter();
		Printer printer = new Printer();
		Scanner scanner = new Scanner(System.in);
		
		while (scanner.hasNext()) {
			String text = scanner.nextLine();
			Map<String, Long> letterOccurrence = cache.getValueFromCache(text);
			if (letterOccurrence == null) {
				letterOccurrence = counter.count(text);
				cache.addToCache(letterOccurrence, text);
			}
			printer.print(cache.getValueFromCache(text), text);
		}
		scanner.close();
	}
}