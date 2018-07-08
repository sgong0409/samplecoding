package com.example.demo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest(value = FibonacciController.class, secure = false)
public class FibonacciControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private FibonacciService fibonacciService;
	
	@Test
	public void testFibonacci() throws Exception
	{
		int[] mockFib = new int[4];
		mockFib[0] = 0;
		mockFib[1] = 1;
		mockFib[2] = 1;
		mockFib[3] = 2;
		Mockito.when(fibonacciService.fibonacci(Mockito.anyInt())).thenReturn(mockFib);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(
				"/fibonacci/4")
				.accept(MediaType.APPLICATION_JSON).content("test")
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.CREATED.value(), response.getStatus());

		assertEquals("http://localhost/fibonacci/4", response
				.getHeader(HttpHeaders.LOCATION));

	}
	
	@Test
	public void testNagativeNumber() throws Exception
	{
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(
				"/fibonacci/-1")
				.accept(MediaType.APPLICATION_JSON).content("test")
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
        
		assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatus());
	}
}
