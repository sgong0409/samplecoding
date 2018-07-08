package com.example.demo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class FibonacciServiceUnitTests {

	@Configuration
	static class FibonacciServiceTestContextConfiguration {
		@Bean
		public FibonacciService fibonacciService() {
			return new FibonacciService();
		}
	}

	@Autowired
	private FibonacciService fibonacciService;

	@Test
	public void testZero() {
		assertEquals(0, fibonacciService.fibonacci(0));
	}

	@Test
	public void testOne() {
		int[] expected = new int[2];
		expected[0] = 0;
		expected[1] = 1;
		assertEquals(expected, fibonacciService.fibonacci(1));
	}

	@Test
	public void testNegative() {
		assertEquals(null, fibonacciService.fibonacci(-1));
	}

	@Test
	public void testFour() {
		int[] expected = new int[4];
		expected[0] = 0;
		expected[1] = 1;
		expected[2] = 1;
		expected[3] = 2;
		assertEquals(expected, fibonacciService.fibonacci(4));
	}

}
