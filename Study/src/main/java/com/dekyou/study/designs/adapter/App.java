package com.dekyou.study.designs.adapter;

import org.junit.Test;


/**
 * @author GaoJing
 * @date 2018年4月2日
 * 
 */
public class App {

	@Test
	public void test() {
		com.dekyou.study.designs.adapter.classadapter.Targetable tt = new com.dekyou.study.designs.adapter.classadapter.Adapter();
		tt.method1();
		tt.method2();
	}
	
	@Test
	public void test1() {
		com.dekyou.study.designs.adapter.objectadapter.Source source = new com.dekyou.study.designs.adapter.objectadapter.Source();
		com.dekyou.study.designs.adapter.objectadapter.Targetable tt = new com.dekyou.study.designs.adapter.objectadapter.Adapter(source);
		tt.method1();
		tt.method2();
	}
	
	@Test
	public void test2() {
		com.dekyou.study.designs.adapter.intadapter.Targetable tt = new com.dekyou.study.designs.adapter.intadapter.Wrapper();
		tt.test1();
		tt.method1();
		tt.method2();
	}

}

