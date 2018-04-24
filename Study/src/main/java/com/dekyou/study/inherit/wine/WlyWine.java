package com.dekyou.study.inherit.wine;

/**
 * @author GaoJing
 * @date 2018年4月3日
 * 
 */
public class WlyWine extends Wine {

	
	public void fun1(String param) {
		System.out.println("this is from WlyWine.fun1()");
		fun2();
	}

	@Override
	public void fun2() {
		System.out.println("this is from WlyWine.fun2()");
	}

	
}

