package com.dekyou.study.inherit.test;

/**
 * @author GaoJing
 * @date 2018年4月3日
 * 
 */
public class A {
	
	public String show(D obj) {
		return ("A and D");
	}

	public String show(A obj) {
		return ("A and A");
	}
}
