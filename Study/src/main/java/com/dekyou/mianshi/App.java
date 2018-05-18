package com.dekyou.mianshi;

import org.junit.Test;

/**
 * @author GaoJing
 * @date 2018年5月8日
 * 
 */
public class App {
	@Test
	public void test() {
		new SS();
	}
	
	@Test
	public void test2() {
		String a ="123";
		String b = new String("123");
		String c = new String("123");
		
		
		System.out.println(a == b);
		System.out.println( b == c);
		
	}
	
	@Test
	public void test3() {
		String[] a = new String[10];
		int[] b = new int[10];
		
		System.out.println(a[0]);
		System.out.println(b[0]);
	}
}

