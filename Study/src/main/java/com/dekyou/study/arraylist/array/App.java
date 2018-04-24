package com.dekyou.study.arraylist.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * @author GaoJing
 * @date 2018年4月10日
 * 
 */
public class App{
		
	/**
	 * 数组的声明
	 */
	@Test
	public void test1() {
		
		//一维数组
		String[] array = new String[10];
		
		System.out.println(array.getClass().getSuperclass());
		System.out.println(array.getClass().getName());
		System.out.println(array.length);
		
		//二维数组
		String[][] array_02 = new String[11][10];
		System.out.println(array_02.getClass().getSuperclass());
		System.out.println(array_02.getClass().getName());
		System.out.println(array_02.length);
		
		//三维数组
		String[][][] array_03 = new String[10][10][10];
		System.out.println(array_03.getClass().getSuperclass());
		System.out.println(array_03.getClass().getName());
		System.out.println(array_03.length);
		
	}
	
	
	/**
	 * 测试自定义String类 可变数组
	 */
	@Test
	public void test2() {
		VariableArray va = new VariableArray();
		va.add("1");
		va.add("2");
		va.add("3");
		va.add("4");
		va.add("5");
		va.add("6");
		va.add("1");
		va.add("2");
		va.add("3");
		va.add("4");
		va.add("5");
		va.add("6");
		
		System.out.println(va.toString());
		
		System.out.println(va.getLength());
		
		System.out.println(va.getCapacity());
		
		va.add(300, "what so what");
		
		va.del(300);
		
		System.out.println(va.toString());
		
		System.out.println(va.getLength());
		
		System.out.println(va.getCapacity());
	}
	
	/**
	 * 测试asList问题
	 * 
	 */
	@Test
	public void test3() {
		Integer[] aa = new Integer[10];
		
		List<Integer> a = Arrays.asList(aa);
		System.out.println(a.toString());
	}
	
	/**
	 * 测试性能
	 */
	@Test
	public void test4() {
		String word = "Test";
		
		long startTime = System.currentTimeMillis();
		VariableArray va = new VariableArray();
		for (int i= 0; i < 100000; i++) {
			va.add(word);
		}
		long endTime = System.currentTimeMillis();
		
		System.out.println(endTime - startTime);
		
		long startTime1 = System.currentTimeMillis();
		ArrayList<String> listString = new ArrayList<String>();
		for (int i= 0; i < 100000; i++) {
			listString.add(word);
		}
		long endTime1 = System.currentTimeMillis();
		
		System.out.println(endTime1 - startTime1);
	}

}

