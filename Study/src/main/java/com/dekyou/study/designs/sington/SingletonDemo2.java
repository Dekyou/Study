package com.dekyou.study.designs.sington;

/**
 * @author GaoJing
 * @date 2018年3月27日
 * 
 */
public class SingletonDemo2 {

	private SingletonDemo2() {}
	
	public static class SingletonDemo3{
		public static SingletonDemo2 instance = new SingletonDemo2();
	}
	
	public static SingletonDemo2 getNewInstance() {
		return SingletonDemo3.instance;
	}
}

