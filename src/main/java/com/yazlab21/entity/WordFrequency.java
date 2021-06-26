package com.yazlab21.entity;

public class WordFrequency {
	
	private String word; 
	private int count;
	
	public String getWord() {
		if(word == null) {
			word = new String();
		}
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "WordFrequency{" +
				"word='" + word + '\'' +
				", count=" + count +
				'}'+"\n";
	}
}
