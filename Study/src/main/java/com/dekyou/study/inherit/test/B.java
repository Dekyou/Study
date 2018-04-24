package com.dekyou.study.inherit.test;

/**
 * @author GaoJing
 * @date 2018年4月3日
 * 
 */
public class B extends A {
	
	public String show(B obj) {
		return ("B and B");
	}

	@Override
	public String show(A obj) {
		return ("B and A");
	}
	
}
