package com.revature.eval.java.core;

import java.util.HashMap;
import java.util.Map;

public class test {
	
	public static void main(String[] args) {
		test t = new test();
		t.wordCount("olly olly in come free");
		
	}
	
	/**
	 * 6. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return
	 */
	public Map<String, Integer> wordCount(String string) {
		// TODO Write an implementation for this method declaration
		String[] words = string.split(" ");
		
		Map<String, Integer> totals = new HashMap<>();
		
		for (String word: words) {
			if (totals.containsKey(word)) {
				totals.replace(word, totals.get(word) + 1);
			} else {
				totals.put(word, 1);
			}
		}
		
		String result = totals.toString();
		System.out.println(result);
		
		return totals; 
	}

}
