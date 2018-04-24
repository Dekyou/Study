package com.dekyou.study.inherit;

/**
 * @author GaoJing
 * @date 2018年3月27日
 * 
 */
public class Cat extends Animal {

	@Override
	public void eat() {
		System.out.println("");
	}

	@Override
	public void call() {
		
		super.getWord();
		System.out.println("This is from cat");
	}

	@Override
	public void sleep() {
		System.out.println("");
	}
	
}

