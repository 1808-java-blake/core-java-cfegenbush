package com.revature.eval.java.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class test {
	
	public static void main(String[] args) {
		test t = new test();
		t.calculatePrimeFactorsOf(9L);
		
		
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
		System.out.println(Arrays.toString(primes.toArray()));
		return primes;
	}
	
	
}
