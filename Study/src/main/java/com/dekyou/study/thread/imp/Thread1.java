package com.dekyou.study.thread.imp;

/**
 * @author GaoJing
 * @date 2018年5月11日
 * 
 */
public class Thread1 implements Runnable{
	
	public static int i;
	@Override
	public void run() {
		this.add();
	}
	
	public void add() {
		i++;
	}

}

