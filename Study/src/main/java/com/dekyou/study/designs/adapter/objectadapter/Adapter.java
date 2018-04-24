package com.dekyou.study.designs.adapter.objectadapter;

/**
 * @author GaoJing
 * @date 2018年4月2日
 * 
 */
public class Adapter implements Targetable {

	private Source source;
	
	public Adapter(Source source) {
		this.source = source;
	}
	
	@Override
	public void method2() {
		System.out.println("this is from Adapter.method2() function!");
	}

	@Override
	public void method1() {
		source.method1();
	}

}

