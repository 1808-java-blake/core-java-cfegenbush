package com.revature.eval.java.core;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EvaluationService {

	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 * 
	 * @param string
	 * @return
	 */
	public String reverse(String string) {
		char[] reversed = new char[string.length()];
		for (int i = reversed.length - 1, j=0; i >= 0; i--, j++) {
			reversed[j] = string.charAt(i);
		}
		return new String(reversed);
	}

	/**
	 * 2. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) {
		// TODO Write an implementation for this method declaration
		phrase = phrase.replaceAll("[^A-Za-z]+", " ");
		String[] split = phrase.split(" ");
		char[] letters = new char[phrase.length()];
		
		for (int i = 0; i < split.length; i++ ) {
			String s = split[i];
			letters[i] = s.charAt(0);
		}
		
		String tla = new String(letters);
		tla = tla.trim().toUpperCase();
		return tla;
	}


	/**
	 * 3. Determine if a triangle is equilateral, isosceles, or scalene. An
	 * equilateral triangle has all three sides the same length. An isosceles
	 * triangle has at least two sides the same length. (It is sometimes specified
	 * as having exactly two sides the same length, but for the purposes of this
	 * exercise we'll say at least two.) A scalene triangle has all sides of
	 * different lengths.
	 *
	 */
	static class Triangle {
		private double sideOne;
		private double sideTwo;
		private double sideThree;

		public Triangle() {
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}

		public boolean isEquilateral() {
			// TODO Write an implementation for this method declaration
			if (this.sideOne == this.sideTwo && this.sideTwo == this.sideThree)
				return true;
			return false;
		}

		public boolean isIsosceles() {
			// TODO Write an implementation for this method declaration
			if (this.sideOne == this.sideTwo || this.sideTwo == this.sideThree || this.sideOne == this.sideThree)
				return true;
			return false;
		}

		public boolean isScalene() {
			// TODO Write an implementation for this method declaration
			if (this.sideOne != this.sideTwo)
				return true;
			return false;
		}

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

	/**
	 * 5. Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) {
		// TODO Write an implementation for this method declaration
		String numbers = string.replaceAll("[^0-9]", "");
		
		if (numbers.length() != 10) 
			throw new IllegalArgumentException("number must be ten digits.");	
		return numbers;		
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
		String[] words = string.split("[\\s,]+");
		
		Map<String, Integer> totals = new HashMap<>();
		
		for (String word: words) {
			if (totals.containsKey(word)) {
				totals.replace(word, totals.get(word) + 1);
			} else {
				totals.put(word, 1);
			}
		}
	
		return totals; 
	}

	/**
	 * 7. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	static class BinarySearch<T extends Comparable<T>> {
		private List<T> sortedList;

		public int indexOf(T t) {
			// TODO Write an implementation for this method declaration
			int index = -1;
			int mid = sortedList.size() / 2;
			T comparableIndex = sortedList.get(mid);
			
			if (t.compareTo(comparableIndex) == 0) {
				index = mid;
			} else if (t.compareTo(comparableIndex) > 0) {
				BinarySearch<T> upperLimit = new BinarySearch<T>(sortedList.subList(mid + 1, sortedList.size()));
				index = upperLimit.indexOf(t) + mid + 1;
			} else if (t.compareTo(comparableIndex) < 0) {
				BinarySearch<T> lowerLimit = new BinarySearch<T>(sortedList.subList(0, mid));
				index = lowerLimit.indexOf(t);
			}
			return index;
		}

		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}

	}

	/**
	 * 8. Implement a program that translates from English to Pig Latin.
	 * 
	 * Pig Latin is a made-up children's language that's intended to be confusing.
	 * It obeys a few simple rules (below), but when it's spoken quickly it's really
	 * difficult for non-children (and non-native speakers) to understand.
	 * 
	 * Rule 1: If a word begins with a vowel sound, add an "ay" sound to the end of
	 * the word. Rule 2: If a word begins with a consonant sound, move it to the end
	 * of the word, and then add an "ay" sound to the end of the word. There are a
	 * few more rules for edge cases, and there are regional variants too.
	 * 
	 * See http://en.wikipedia.org/wiki/Pig_latin for more details.
	 * 
	 * @param string
	 * @return
	 */
	public String toPigLatin(String string) {
		// TODO Write an implementation for this method declaration
		String[] vowels = new String[] {"a","e","i","o","u"};
		String[] words = string.split(" ");
		String translatedWord = new String();
		ArrayList<String> result = new ArrayList<String>();
		
		for (String word: words) {
			for (int i = 0; i < word.length(); i++) {
				if (Arrays.asList(vowels).contains(String.valueOf(word.charAt(i))) 
						& !String.valueOf(word.charAt(i+1)).equals("i")) {
					if (i == 0) {
						translatedWord = word + "ay";
						result.add(translatedWord);
						break;
					} else {
						String consonant = word.substring(0, i);
						translatedWord = word.substring(i) + consonant + "ay";
						result.add(translatedWord);
						break;
					}
				}
			}
		}
		String translation = String.join(" ", result);
		return translation;
	}

	/**
	 * 9. An Armstrong number is a number that is the sum of its own digits each
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 * 
	 * @param input
	 * @return
	 */
	public boolean isArmstrongNumber(int input) {
		// TODO Write an implementation for this method declaration
		String inputAsString = String.valueOf(input);
		String[] numbers = inputAsString.split("");
		double total = 0;
		
		for(String number: numbers) {
			double num = Double.valueOf(number);
			num = Math.pow(num, (double) inputAsString.length());
			total += num;
		}
		
		if (total == input) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 10. Compute the prime factors of a given natural number.
	 * 
	 * A prime number is only evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 * 
	 * @param l
	 * @return
	 */
	public List<Long> calculatePrimeFactorsOf(long l) {
		// TODO Write an implementation for this method declaration
		List<Long> primes = new ArrayList<>();
		long input = l;
		
		for (long i = 2L; i <= input; i++) {
			if (input % i == 0) {
				primes.add(i);
				input /= i;
				i--;
			}
		}
		return primes;
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
			return cipher;
		}
	}

	/**
	 * 12. Given a number n, determine what the nth prime is.
	 * 
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
	 * that the 6th prime is 13.
	 * 
	 * If your language provides methods in the standard library to deal with prime
	 * numbers, pretend they don't exist and implement them yourself.
	 * 
	 * @param i
	 * @return
	 */
	public int calculateNthPrime(int i) {
		List<Integer> primes = new ArrayList<Integer>(Arrays.asList(2)); 
		if (i < 1) {
			throw new IllegalArgumentException();
		} else if (i == 1) {
			return primes.get(0);
		}
		
		int x = 1;
		for (int j = 3; x < i; j+=2) {
			boolean isPrime = true;
			for(int y = 2; y < j; y++) {
				if (j % y == 0) {
					isPrime = false;
				}
			}
			if (isPrime != false) {
				primes.add(j);
				x++;
			}
		}
		return primes.get(i - 1);
		
	}

	/**
	 * 13 & 14. Create an implementation of the atbash cipher, an ancient encryption
	 * system created in the Middle East.
	 * 
	 * The Atbash cipher is a simple substitution cipher that relies on transposing
	 * all the letters in the alphabet such that the resulting alphabet is
	 * backwards. The first letter is replaced with the last letter, the second with
	 * the second-last, and so on.
	 * 
	 * An Atbash cipher for the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba It is a
	 * very weak cipher because it only has one possible key, and it is a simple
	 * monoalphabetic substitution cipher. However, this may not have been an issue
	 * in the cipher's time.
	 * 
	 * Ciphertext is written out in groups of fixed length, the traditional group
	 * size being 5 letters, and punctuation is excluded. This is to make it harder
	 * to guess things based on word boundaries.
	 * 
	 * Examples Encoding test gives gvhg Decoding gvhg gives test Decoding gsvjf
	 * rxpyi ldmul cqfnk hlevi gsvoz abwlt gives thequickbrownfoxjumpsoverthelazydog
	 *
	 */
	static class AtbashCipher {

		public static Map<String,String> cipherBet = new HashMap<String,String>(){{
			put("a","z");
			put("b","y");
			put("c","x");
			put("d","w");
			put("e","v");
			put("f","u");
			put("g","t");
			put("h","s");
			put("i","r");
			put("j","q");
			put("k","p");
			put("l","o");
			put("m","n");
			put("n","m");
			put("o","l");
			put("p","k");
			put("q","j");
			put("r","i");
			put("s","h");
			put("t","g");
			put("u","f");
			put("v","e");
			put("w","d");
			put("x","c");
			put("y","b");
			put("z","a");
		}};
		
		
		public static String encode(String string) {
			String numbers = "1234567890";
			String[] splitString = string.toLowerCase().replaceAll("[^A-Za-z0-9]", "").split("");
			StringBuilder sb = new StringBuilder();
			int i = 0;
			for (String s: splitString) {
				if (cipherBet.containsKey(s)) {
					sb.append(cipherBet.get(s));
					i++;
				} else if (numbers.contains(s)) {
					sb.append(s);
					i++;
				}
				if (i % 5 == 0) {
					sb.append(" ");
				}
			}
			String cipherString = sb.toString().trim();
			return cipherString;
		}

		/**
		 * Question 14
		 * 
		 * @param string
		 * @return
		 */
		public static String decode(String string) {
			String decoded = encode(string);
			return decoded.replaceAll(" ", "");
		}
	}

	/**
	 * 15. The ISBN-10 verification process is used to validate book identification
	 * numbers. These normally contain dashes and look like: 3-598-21508-8
	 * 
	 * ISBN The ISBN-10 format is 9 digits (0 to 9) plus one check character (either
	 * a digit or an X only). In the case the check character is an X, this
	 * represents the value '10'. These may be communicated with or without hyphens,
	 * and can be checked for their validity by the following formula:
	 * 
	 * (x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9
	 * * 2 + x10 * 1) mod 11 == 0 If the result is 0, then it is a valid ISBN-10,
	 * otherwise it is invalid.
	 * 
	 * Example Let's take the ISBN-10 3-598-21508-8. We plug it in to the formula,
	 * and get:
	 * 
	 * (3 * 10 + 5 * 9 + 9 * 8 + 8 * 7 + 2 * 6 + 1 * 5 + 5 * 4 + 0 * 3 + 8 * 2 + 8 *
	 * 1) mod 11 == 0 Since the result is 0, this proves that our ISBN is valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isValidIsbn(String string) {
		// TODO Write an implementation for this method declaration
		
		String[] isbn = string.replaceAll("\\-", "").replaceAll("[^0-9X]","").split("");
		int total = 0;
		boolean valid = false;
		if (isbn.length == 10) {
			int i = 10;
			for(String s: isbn) {
				if (s.equals("X")) {
					s = "10";
					int num = Integer.parseInt(s);
					total += num * i;
					i--;
				}
				int num = Integer.valueOf(s);
				total += num * i;
				i--;
			}
		}
		if (total > 0 && total % 11 == 0) {
			valid = true;
		}
		return valid;
	}

	/**
	 * 16. Determine if a sentence is a pangram. A pangram (Greek: παν γράμμα, pan
	 * gramma, "every letter") is a sentence using every letter of the alphabet at
	 * least once. The best known English pangram is:
	 * 
	 * The quick brown fox jumps over the lazy dog.
	 * 
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 * 
	 * @param string
	 * @return
	 */
public boolean isPangram(String string) {
		
		// TODO Write an implementation for this method declaration
		String[] alphabet = {"a","b","c","d","e","f","g","h","i","j","k","l",
				"m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
		List<String> dynamicAlphabet = new ArrayList<String>(Arrays.asList(alphabet));
		if (string.length() == 0) {
			return false;
		}
		
		String[] splitString = string.replaceAll(" ", "").split("");
		for (String s: splitString) {
			if (dynamicAlphabet.contains(s)) {
				dynamicAlphabet.remove(s);
			}
		}
		if (dynamicAlphabet.size() == 0) {
			return true;
		}
		return false;
	}

	/**
	 * 17. Calculate the moment when someone has lived for 10^9 seconds.
	 * 
	 * A gigasecond is 109 (1,000,000,000) seconds.
	 * 
	 * @param given
	 * @return
	 */
	public Temporal getGigasecondDate(Temporal given) {
		// TODO Write an implementation for this method declaration
		if (given instanceof LocalDate) {
			LocalDateTime ldt = LocalDate.from(given).atTime(0, 0);
			given = ldt;
			
		} else if (given instanceof LocalDateTime) {
			LocalDateTime ldt = LocalDateTime.from(given);
			given = ldt;
		}
		
		return given.plus(1000000000, ChronoUnit.SECONDS);
	}

	/**
	 * 18. Given a number, find the sum of all the unique multiples of particular
	 * numbers up to but not including that number.
	 * 
	 * If we list all the natural numbers below 20 that are multiples of 3 or 5, we
	 * get 3, 5, 6, 9, 10, 12, 15, and 18.
	 * 
	 * The sum of these multiples is 78.
	 * 
	 * @param i
	 * @param set
	 * @return
	 */
	public int getSumOfMultiples(int i, int[] set) {
		// TODO Write an implementation for this method declaration
		List<Integer> multiples = new ArrayList<Integer>();
		for (int x = 1; x < i; x++) {
			for(int numInSet: set) {
				if (x % numInSet == 0 & !multiples.contains(x)) {
					multiples.add(x);
				}
			}
		}
		int total = multiples.stream().mapToInt(Integer::intValue).sum();
		return total;
	}

	/**
	 * 19. Given a number determine whether or not it is valid per the Luhn formula.
	 * 
	 * The Luhn algorithm is a simple checksum formula used to validate a variety of
	 * identification numbers, such as credit card numbers and Canadian Social
	 * Insurance Numbers.
	 * 
	 * The task is to check if a given string is valid.
	 * 
	 * Validating a Number Strings of length 1 or less are not valid. Spaces are
	 * allowed in the input, but they should be stripped before checking. All other
	 * non-digit characters are disallowed.
	 * 
	 * Example 1: valid credit card number 1 4539 1488 0343 6467 The first step of
	 * the Luhn algorithm is to double every second digit, starting from the right.
	 * We will be doubling
	 * 
	 * 4_3_ 1_8_ 0_4_ 6_6_ If doubling the number results in a number greater than 9
	 * then subtract 9 from the product. The results of our doubling:
	 * 
	 * 8569 2478 0383 3437 Then sum all of the digits:
	 * 
	 * 8+5+6+9+2+4+7+8+0+3+8+3+3+4+3+7 = 80 If the sum is evenly divisible by 10,
	 * then the number is valid. This number is valid!
	 * 
	 * Example 2: invalid credit card number 1 8273 1232 7352 0569 Double the second
	 * digits, starting from the right
	 * 
	 * 7253 2262 5312 0539 Sum the digits
	 * 
	 * 7+2+5+3+2+2+6+2+5+3+1+2+0+5+3+9 = 57 57 is not evenly divisible by 10, so
	 * this number is not valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isLuhnValid(String string) {
		
		String noSpaces = string.replaceAll("\\s+", "");
		for (char c: noSpaces.toCharArray()) {
			if (!Character.isDigit(c)) {
				return false;
			}
		}
		
		String[] splitString = noSpaces.split("");
		StringBuilder sb = new StringBuilder();
		for (int i = splitString.length - 1; i >= 0; i--) {
			int x = Integer.parseInt(splitString[i]);
			if (i % 2 != 0) {
				x *= 2;
				if (x > 9) {
					x -= 9;
					sb.append(x);
				} else {
					sb.append(x);
				}
			} else {
				sb.append(x);
			}
		}
		String[] numbers = sb.toString().split("");
		int sum = 0;
		for (String s: numbers) {
			sum += Integer.parseInt(s);
		}
		if (sum % 10 == 0) {
			return true;
		}
		return false;
	}

	/**
	 * 20. Parse and evaluate simple math word problems returning the answer as an
	 * integer.
	 * 
	 * Add two numbers together.
	 * 
	 * What is 5 plus 13?
	 * 
	 * 18
	 * 
	 * Now, perform the other three operations.
	 * 
	 * What is 7 minus 5?
	 * 
	 * 2
	 * 
	 * What is 6 multiplied by 4?
	 * 
	 * 24
	 * 
	 * What is 25 divided by 5?
	 * 
	 * 5
	 * 
	 * @param string
	 * @return
	 */
	public int solveWordProblem(String string) {
		// TODO Write an implementation for this method declaration
		String[] splitString = string.substring(8).replaceAll("\\b\\sby\\b|[?]", "").split(" ");
		int firstNum = Integer.parseInt(splitString[0]);
		int secNum = Integer.parseInt(splitString[2]);
		String operator = splitString[1];
		int result = 0;
		
		switch(operator) {
			case "plus": result = firstNum + secNum;
				break;
			case "minus": result = firstNum - secNum;
				break;
			case "multiplied": result = firstNum * secNum;
				break;
			default: result = firstNum / secNum;
		}
		return result;
	}

}
