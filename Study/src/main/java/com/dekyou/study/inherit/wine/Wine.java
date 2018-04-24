package com.dekyou.study.inherit.wine;

/**
 * @author GaoJing
 * @date 2018年4月3日
 * 
 */
public class Wine {

	public void fun1() {
		System.out.println("this is from Wine.fun1()");
		fun2();
	}
	
	public void fun2() {
		System.out.println("this is from Wine.fun2()");
	}
	
	public void fun3(Wine wine) {
		System.out.println("");
	}
}

