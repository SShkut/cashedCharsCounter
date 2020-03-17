package com.foxminded.collectionframework;

import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		CharsCounter counter = new CachedLetterCounter(new DistinctLetterCounter());
		Scanner scanner = new Scanner(System.in);
		
		while (scanner.hasNext()) {
			String text = scanner.nextLine();
			Map<Character, Long> characterOccurrence = counter.count(text);
			print(text, characterOccurrence);
		}
		scanner.close();
	}
	
	private static void print(String text, Map<Character, Long> characterOccurrence) {
		System.out.println(text);
		for (Map.Entry<Character, Long> key : characterOccurrence.entrySet()) {
			System.out.println("\"" + key.getKey() + "\"" + " - " + key.getValue());
		}
	}
}