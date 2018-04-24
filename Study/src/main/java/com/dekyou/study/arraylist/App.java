package com.dekyou.study.arraylist;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class App {

	@Test
	public void test() {
		List<String> listStr = new ArrayList<String>();
		listStr.add("a");
		listStr.add("a");
		listStr.add("a");
		listStr.add("a");
		listStr.add(1, "b");
		listStr.add(1,"");
		System.out.println(listStr);
	}
}
