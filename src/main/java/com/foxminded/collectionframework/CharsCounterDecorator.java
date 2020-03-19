package com.foxminded.collectionframework;

public abstract class CharsCounterDecorator implements CharsCounter {

	CharsCounter charsCounter;
	
	public CharsCounterDecorator(CharsCounter charsCounter) {
		this.charsCounter = charsCounter;
	}
}
