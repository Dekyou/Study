package com.dekyou.mianshi.proxy.dyn;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author GaoJing
 * @date 2018年5月13日
 * 
 */
public class App {

	public static void main(String[]  args) {
		
		Person zhangsan = new Student("zhangsan");
		
		InvocationHandler stuHandler = new StuInvocationHandler<Person>(zhangsan);
		
		Person stuProxy = (Person)Proxy.newProxyInstance(Person.class.getClassLoader(),new Class<?>[] {Person.class}, stuHandler);
		
		stuProxy.giveMoney();
	}
}

