package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FibonacciController {

	@Autowired
	private FibonacciService fibonacciService;

	@RequestMapping("/fibonnaci/{n}")
	public ResponseEntity<?> calFibonacci(@PathVariable int n) {

		if (n < 0) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("invalid interger" + n);
		}
		int[] fib = fibonacciService.fibonacci(n);
		return new ResponseEntity<int[]>(fib, HttpStatus.OK);

	}
}
