package com.dekyou.study.inherit;

/**
 * @author GaoJing
 * @date 2018年4月3日
 * 
 */
public class Magpie extends Predators {

	public Magpie() {
		super("TestPrdators");
		System.out.println("Magpie constructor is called");
		
	}
	
	
	public void Fly() {
		System.out.println("Magpie is flying!");
	}
	
	public void getYeah() {
		System.out.println("I'm singing!");
	}
}

