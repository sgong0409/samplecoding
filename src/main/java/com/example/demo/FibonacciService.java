package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class FibonacciService {

	public int[] fibonacci(int n) {
		int[] fib = new int[n];
		fib[0] = 0;
		fib[1] = 1;

		for (int i = 2; i < n; i++) {
			fib[i] = fib[i - 1] + fib[i - 2];
		}

		return fib;
	}

}
