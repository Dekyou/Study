package com.dekyou.study.thread.newthd;

import com.dekyou.study.thread.App;

public class Thread1 extends Thread{
	
	private App app;

	public void deal(App app) {
		this.app = app;
	}
	
	@Override
	public void run() {
		super.run();
		app.out();
	}
	
}
