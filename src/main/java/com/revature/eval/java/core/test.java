package com.revature.eval.java.core;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class test {
	
	public static void main(String[] args) {
//		test t = new test();
		RotationalCipher rotationalCipher = new RotationalCipher(5);
		rotationalCipher.rotate("OMG");
		
		
		
	}
	
	/**
	 * 11. Create an implementation of the rotational cipher, also sometimes called
	 * the Caesar cipher.
	 * 
	 * The Caesar cipher is a simple shift cipher that relies on transposing all the
	 * letters in the alphabet using an integer key between 0 and 26. Using a key of
	 * 0 or 26 will always yield the same output due to modular arithmetic. The
	 * letter is shifted for as many values as the value of the key.
	 * 
	 * The general notation for rotational ciphers is ROT + <key>. The most commonly
	 * used rotational cipher is ROT13.
	 * 
	 * A ROT13 on the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: nopqrstuvwxyzabcdefghijklm It is
	 * stronger than the Atbash cipher because it has 27 possible keys, and 25
	 * usable keys.
	 * 
	 * Ciphertext is written out in the same formatting as the input including
	 * spaces and punctuation.
	 * 
	 * Examples: ROT5 omg gives trl ROT0 c gives c ROT26 Cool gives Cool ROT13 The
	 * quick brown fox jumps over the lazy dog. gives Gur dhvpx oebja sbk whzcf bire
	 * gur ynml qbt. ROT13 Gur dhvpx oebja sbk whzcf bire gur ynml qbt. gives The
	 * quick brown fox jumps over the lazy dog.
	 */
	static class RotationalCipher {
		private int key;

		public RotationalCipher(int key) {
			super();
			this.key = key;
		}

		public String rotate(String string) {
			// TODO Write an implementation for this method declaration
			Map<Character,Integer> alphabetValues = new HashMap<Character,Integer>(){{
				put('a',1);
				put('b',2);
				put('c',3);
				put('d',4);
				put('e',5);
				put('f',6);
				put('g',7);
				put('h',8);
				put('i',9);
				put('j',10);
				put('k',11);
				put('l',12);
				put('m',13);
				put('n',14);
				put('o',15);
				put('p',16);
				put('q',17);
				put('r',18);
				put('s',19);
				put('t',20);
				put('u',21);
				put('v',22);
				put('w',23);
				put('x',24);
				put('y',25);
				put('z',26);
			}};
			
			String copyOfInput = string;
			StringBuilder sb = new StringBuilder();
			int counter = 0;
			
			for (char c: copyOfInput.toCharArray()) {
				
				boolean uppercase = false;
				
				if (Character.isUpperCase(c)) {
					uppercase = true;
					c = Character.toLowerCase(c);
				}
				
				if (alphabetValues.containsKey(c)) {
					
					int index = alphabetValues.get(c);
					index += key;
					if (index > 26) {
						int newIndex = index - 27;
						sb.append(alphabetValues.keySet().toArray()[newIndex]);
					} else {
						sb.append(alphabetValues.keySet().toArray()[index - 1]);
					}
				} else {
					sb.append(c);
				}
				
				if (uppercase == true) {
					sb.setCharAt(counter, Character.toUpperCase(sb.charAt(counter)));
				}
				
				counter++;
			}
			String cipher = sb.toString();
			System.out.println(cipher);
			return cipher;
		}
	}
	
	
}
