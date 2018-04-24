package com.dekyou.study.arraylist.collection.set.hashset;

import java.util.HashSet;

import org.junit.Test;

/**
 * @author GaoJing
 * @date 2018年4月11日
 * 
 */
public class App {
	
	@Test
	public void test1() {
		String name = "testname";
		HashSet<String> hashSet = new HashSet<String>();
		hashSet.add(name);
		hashSet.add("Fine");
		hashSet.add("1");
		hashSet.add("2");
		hashSet.add("3");
		hashSet.add("Jing");
		
		
		System.out.println(hashSet);
		
		
	}
}

