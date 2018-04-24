package com.dekyou.study.arraylist.collection.list.arraylist;

import java.util.ArrayList;

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
}

