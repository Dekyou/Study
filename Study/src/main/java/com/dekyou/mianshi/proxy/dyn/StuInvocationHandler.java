package com.dekyou.mianshi.proxy.dyn;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author GaoJing
 * @date 2018年5月13日
 * 
 */
public class StuInvocationHandler<T> implements InvocationHandler {

	T target;
	public StuInvocationHandler(T target) {
		this.target = target;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
	
		Object result = method.invoke(target, args);
		return result;
	}

	
}

