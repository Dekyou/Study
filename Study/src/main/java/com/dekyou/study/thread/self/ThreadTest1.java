package com.dekyou.study.thread.self;

/**
 * @author GaoJing
 * @date 2018年4月11日
 * 
 */
public class ThreadTest1 implements Runnable{

	@Override
	public void run() {
		synchronized(this) {
			System.out.println("Test");
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
}

