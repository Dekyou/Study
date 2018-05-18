package com.dekyou.study.arraylist.collection.list.arraylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.junit.Test;

/**
 * @author GaoJing
 * @date 2018年4月10日
 * 
 */
public class App {
	
	@Test
	public void test1() {
		ArrayList<String> listStr = new ArrayList<String>(10);
		
		listStr.ensureCapacity(200);
		listStr.add("a");
		listStr.add("a");
		listStr.add("a");
		listStr.set(1, "n");
		System.out.println(listStr.size());
	}
	
	@Test
	public void test2() {
		ArrayList<Integer> listStr = new ArrayList<Integer>();
		listStr.add(3);
		listStr.add(7);
		listStr.add(7);
		listStr.add(5);
		listStr.add(14);
		listStr.add(1);
		
		
		listStr.remove(0);
		System.out.println(listStr);
		
		Collections.sort(listStr);
		
		System.out.println(listStr);
		
		Collections.sort(listStr, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
		});
		
		System.out.println(listStr);
	}
	
	
	
	
}

