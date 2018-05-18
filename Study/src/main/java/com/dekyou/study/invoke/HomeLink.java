package com.dekyou.study.invoke;

import com.sun.corba.se.impl.presentation.rmi.InvocationHandlerFactoryImpl;
import com.sun.corba.se.spi.presentation.rmi.PresentationManager;
import com.sun.corba.se.spi.presentation.rmi.PresentationManager.ClassData;

/**
 * @author GaoJing
 * @date 2018年5月9日
 * 
 */
public class HomeLink extends InvocationHandlerFactoryImpl {

	public HomeLink(PresentationManager pm, ClassData classData) {
		super(pm, classData);
		// TODO Auto-generated constructor stub
	}

}

