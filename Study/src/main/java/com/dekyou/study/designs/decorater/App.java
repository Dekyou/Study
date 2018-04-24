package com.dekyou.study.designs.decorater;

import org.junit.Test;

/**
 * @author GaoJing
 * @date 2018年4月2日
 * 
 */
public class App {

	@Test
	public void test1() {
		Sourceable source = new Source();
		Sourceable source1 = new Decorator(source);
		source1.method();
	}
}

