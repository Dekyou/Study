package com.dekyou.study.designs.sington;

/**
 * @author GaoJing
 * @date 2018年3月27日
 * 
 */
public class TestInstance1 implements Runnable {

	private Thread t;
	
	@Override
	public void run() {
		int i = 1000000;
		while (i > 0) {
			SingletonDemo instance1 = SingletonDemo.getNewInstance();
			instance1.add();
			i --;
		}
		
	}

	public void start() {
		if (t == null) {
			t = new Thread(this);
			t.start();
		}
	}
	
}

