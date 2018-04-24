package com.dekyou.study.thread.newthd;

import org.junit.Test;

import com.dekyou.study.thread.App;

public class TestThread {
	
	@Test
	public void test1() throws Throwable {
		App app = new App();
		Thread1 thread1 = new Thread1();
		Thread2 thread2 = new Thread2();
		thread1.deal(app);
		
		thread2.deal(app);
		thread1.run();
		thread2.run();
	}
}
