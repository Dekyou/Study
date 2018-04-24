package com.dekyou.study.innercls;

import org.junit.Test;

public class App {
	
	@Test
	public void test() {
		OuterClass1 oc = new OuterClass1();
		OuterClass1.InnerClass oc_ic = oc.new InnerClass();
	}
	
	@Test
	public void test2() {
		OuterClass1 cls1 = new OuterClass1();
		cls1.show(new TestCls() {
			@Override
			public void show() {
				System.out.println("xxxxxxxxx");
			}
		});
	}
	
	public void test3() {
		
	}

}
