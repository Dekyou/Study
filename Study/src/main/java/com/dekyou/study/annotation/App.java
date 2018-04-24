package com.dekyou.study.annotation;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class App {

	@Test
	public void test() {
		System.out.println("aaa".toString());
	}
	
	@Override
	@MethodInfo(comments = "This is test", date = "2018-03-08", author = "Dekyou", revision = 2)
	public String toString() {
		return "Override toString method";
	}
	
	@Deprecated
	@MethodInfo(comments = "deprecated method", date = "Nov 17 2012")
	public static void oldMethod() {
	    System.out.println("old method, don't use it.");
	}
	 
	
	@SuppressWarnings("unchecked")
	@MethodInfo(author = "Pankaj", comments = "Main method", date = "Nov 17 2012", revision = 10)
	public static void genericsTest() throws FileNotFoundException {
	    @SuppressWarnings("rawtypes")
		List l = new ArrayList();
	    l.add("abc");
	    oldMethod();
	}

	
}
