package com.dekyou.study.designs.sington;

import com.dekyou.study.thread.runnable.RunnableDemo;

/**
 * @author GaoJing
 * @date 2018年3月27日
 * 
 */
public class App {
	
	public static void main(String[] args) {
		
		TestInstance1 R1 = new TestInstance1();
		R1.start();

		TestInstance1 R2 = new TestInstance1();
		R2.start();
		
//		RunnableDemo R1 = new RunnableDemo("Thread-1");
//		R1.start();
//
//		RunnableDemo R2 = new RunnableDemo("Thread-2");
//		R2.start();
	}
	

}

