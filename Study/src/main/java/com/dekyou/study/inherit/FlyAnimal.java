package com.dekyou.study.inherit;

/**
 * @author GaoJing
 * @date 2018年4月3日
 * 
 */
public class FlyAnimal implements Biologic {

	public FlyAnimal() {
		System.out.println("FlyAnimal class constructor is called");
	}
	
	
	public void getName1() {
		System.out.println("I'm flyAnimal!");
	}
	
	public void getSpecial() {
		System.out.println("oh, maybe");
	}
	
	
	@Override
	public void eat() {
		// TODO Auto-generated method stub

	}

	@Override
	public void call() {
		// TODO Auto-generated method stub

	}

	@Override
	public void sleep() {
		// TODO Auto-generated method stub

	}

}

