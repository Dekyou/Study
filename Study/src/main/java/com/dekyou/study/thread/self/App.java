package com.dekyou.study.thread.self;

/**
 * @author GaoJing
 * @date 2018年4月11日
 * 
 */
public class App {

	public static void main(String[] args) throws InterruptedException {
		
		ThreadTest1 tt = new ThreadTest1();
		Thread t = new Thread(tt, "Name:GaoJing");
		t.start();
	}
	
	
}

