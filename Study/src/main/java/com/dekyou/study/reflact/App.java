package com.dekyou.study.reflact;

import java.lang.reflect.Constructor;

import org.junit.Test;

/**
 * 测试的反射类
 * @author DEKYOU
 *
 */
public class App {
	
//	private static final Logger log = LogManager.getLogger(App.class);
	
	@Test
	public void test1() throws ClassNotFoundException {
		Class<?> clazz = Class.forName("com.dekyou.study.reflact.Apple");
		
		System.out.println("============所有的公共构造方法============");
		Constructor<?>[] conArray = clazz.getConstructors();
		for (Constructor<?> c : conArray) {
			System.out.println(c);
		}
		
		System.out.println("===========所有构造方法==================");
		Constructor<?>[]  conArray1 = clazz.getDeclaredConstructors();
		for (Constructor<?> c : conArray1) {
			System.out.println(c);
		}
		
		System.out.println("===================================================");
	}
	
	
	public void getNewClass() {
		Apple apple = new Apple();
		apple.getClass();
	}

	/**
	 * 实例化Java类
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	@Test
	public void getNewInstance() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		Apple apple = new Apple();
		
		Apple apple1 = (Apple) getClass("com.dekyou.study.reflact.Apple").newInstance();
		
		System.out.println(apple1.getSumPrice());
	}
	
	/**
	 * 获取Class
	 * @param name
	 * @return
	 * @throws ClassNotFoundException
	 */
	private Class<?> getClass(String name) throws ClassNotFoundException{
		return Class.forName(name);
	}
	
	
}
