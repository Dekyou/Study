package com.dekyou.study.designs.sington;

/**
 * @author GaoJing
 * @date 2018年3月27日
 * 
 */
public class SingletonDemo {
	
	private static SingletonDemo singletonDemo = null;
	
	static {
		singletonDemo = new SingletonDemo(); 
	}
	
	private static int i = 0;
	
	private SingletonDemo() {}
	
	public static SingletonDemo getNewInstance() {
		
			synchronized(singletonDemo) {
				if (singletonDemo == null) {
					singletonDemo = new SingletonDemo();
				}
			}
		return singletonDemo;
	}
	
	public void add() {
		StringBuilder stringBuilder = new StringBuilder();
//		synchronized(this) {
//			i++;
//		}
		String a = stringBuilder.append("第").append(i++).append("运行").toString();
		System.out.println(a);
	}
}

