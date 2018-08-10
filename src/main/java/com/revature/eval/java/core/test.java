package com.revature.eval.java.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.revature.eval.java.core.EvaluationService.AtbashCipher;

public class test {
	
	public static void main(String[] args) {
		test t = new test();
		//t.calculateNthPrime(3);
		
	
		
		
		
	}
	
	public int calculateNthPrime(int i) {
		// TODO Write an implementation for this method declaration
		List<Integer> primes = new ArrayList<>();
		if (i == 1) {
			primes.add(2);
		} else if (i == 2) {
			primes.add(2);
			primes.add(3);
		}
		for (int x = 3; x <= i; x++) {
			if (x % 2 == 0) {
				break;
			} else {
				primes.add(x);
			}
		}
		
		int nthPrime = primes.get(i - 1);
		System.out.println(nthPrime);
		return nthPrime;
	}
	
	
}
