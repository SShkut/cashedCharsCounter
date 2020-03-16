package com.foxminded.collectionframework;

public abstract class LetterCounterDecorator implements LetterCounter {

	LetterCounter letterCounter;
	
	public LetterCounterDecorator(LetterCounter letterCounter) {
		super();
		this.letterCounter = letterCounter;
	}
}
