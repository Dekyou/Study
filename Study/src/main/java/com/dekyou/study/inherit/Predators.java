package com.dekyou.study.inherit;

/**
 * @author GaoJing
 * @date 2018年4月3日
 * 
 */
public class Predators extends FlyAnimal {
	
	public Predators() {
		System.out.println("Predators constructor is called");
	}
	
	public Predators(String name) {
		System.out.println("Another Predators constructor is called");
	}
	
	public void getName1() {
		System.out.println("I'm Predators!");
	}
	
	public void getStatus() {
		System.out.println("I'm eat meat");
	}
	
}

