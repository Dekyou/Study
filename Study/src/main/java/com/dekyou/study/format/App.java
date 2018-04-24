package com.dekyou.study.format;

import org.junit.Test;

public class App {

	@Test
	public void test() {
		
		for (int i = 0; i <200; i++) {
			System.out.println(String.format("%02d", i));
		}
		
	}
}
