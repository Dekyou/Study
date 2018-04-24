package com.dekyou.study.designs.adapter.classadapter;

/**
 * @author GaoJing
 * @date 2018年4月2日
 * 
 */
public class Adapter extends Source implements Targetable {

	@Override
	public void method2() {
		System.out.println("this is from Adapter.method2() function!");
	}

}

