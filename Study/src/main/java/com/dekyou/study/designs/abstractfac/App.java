package com.dekyou.study.designs.abstractfac;

import org.junit.Test;

/**
*@author GaoJing
*@date 2018年3月27日
*/
public class App {
	
	@Test
	public void test() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		Provider provider = (Provider) Class.forName("com.dekyou.study.designs.EmailFactory").newInstance();
		Sender sender = provider.produce();
		sender.send();
	}
}

