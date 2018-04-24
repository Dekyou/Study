package com.dekyou.study.inherit.testabs;

/**
 * @author GaoJing
 * @date 2018年4月8日
 * 
 */
public abstract class Tree {

	public void out() {
		System.out.println(this.getAbc());
	}
	
	public abstract String getAbc();
}

