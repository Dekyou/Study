package com.dekyou.study.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.dekyou.study.thread.runnable.RunnableDemo;

/**
 * 创建线程池
 * @author GaoJing
 *
 */
public class ThreadPool {
	
	public static void main(String[] args) {
		//创建线程池对象、 参数5，代表有5个线程的线程池
		ExecutorService extService = Executors.newFixedThreadPool(5);
		//创建Runnable线程任务对象
		RunnableDemo rd = new RunnableDemo("TestThread 1");
		//从线程池中获取线程对象
		extService.submit(rd);
		extService.shutdown();
		
	}
}
