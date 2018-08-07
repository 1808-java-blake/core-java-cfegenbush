package com.revature.eval.java.core;

import java.util.Arrays;

public class test {
	
	public static void main(String[] args) {
		test t = new test();
		t.getScrabbleScore("cabbage");
		
	}
	
	/**
	 * 4. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public int getScrabbleScore(String string) {
		// TODO Write an implementation for this method declaration
		
		String[] one = new String[] {"A","E","I","O","U","L","N","R","S","T"};
		String[] two = new String[] {"D","G"};
		String[] three = new String[] {"B","C","M","P"};
		String[] four = new String[] {"F","H","V","W","Y"};
		String[] eight = new String[] {"J","X"};
		String[] ten = new String[] {"Q","Z"};
		
		String[] splitString = string.toUpperCase().split("");
		
		int total = 0;
	
		for(String a: splitString)
			if (Arrays.asList(one).contains(a)) {
				total++;
			} else if (Arrays.asList(two).contains(a)) {
				total += 2;
			} else if (Arrays.asList(three).contains(a)) {
				total += 3;
			} else if (Arrays.asList(four).contains(a)) {
				total += 4;
			} else if (Arrays.asList(eight).contains(a)) {
				total += 8;
			} else if (Arrays.asList(ten).contains(a)) {
				total += 10;
			} else {
				total += 5;
			}
		
		return total;
	}

}
