package com.dekyou.study.designs.decorater;

/**
 * @author GaoJing
 * @date 2018年4月2日
 * 
 */
public class Decorator implements Sourceable {

	private Sourceable source;
	
	public Decorator(Sourceable source) {
		this.source = source;
	}
	@Override
	public void method() {
		System.out.println("this is from Decorator.method");
		source.method();
	}

}

