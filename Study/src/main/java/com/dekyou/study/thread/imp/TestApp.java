package com.dekyou.study.thread.imp;

/**
 * @author GaoJing
 * @date 2018年5月11日
 * 
 */
public class TestApp {

	
	public static void main(String[] args) {
		Thread1 t1 = new Thread1();
		
		Thread t11 = new Thread(t1);
		Thread t2 = new Thread2();
		
		t2.start();
		t11.start();
		
	}
}

