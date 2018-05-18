package com.dekyou.study.thread.imp;

/**
 * @author GaoJing
 * @date 2018年5月11日
 * 
 */
public class Thread2 extends Thread {

	public static int i;
	
	@Override
	public void run() {
		this.add();
		System.out.println(i);
	}
	
	public void add() {
		i++;
	}
}

