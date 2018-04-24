package com.dekyou.study.innercls.second;

import org.junit.Test;

/**
 * @author GaoJing
 * @date 2018年4月10日
 * 
 */
public class App {

	/**
	 * 非静态类的实例化，静态类的实例化直接调用
	 */
	@Test
	public void test() {
		MotherImpl mother = new MotherImpl();
		MotherImpl.Son son = mother.new Son();
		
		son.getMotherName();
		
		son.smile1();
		
		mother.getSonName();
	}
}

