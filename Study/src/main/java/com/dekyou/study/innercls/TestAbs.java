package com.dekyou.study.innercls;

public abstract class TestAbs implements FatherInterface{
	
	public String getStr() {
		return "This String is from Class : TestAbs.getStr";
	}
	
	public abstract String getStr(String a);
	
	public void test() {
		System.out.println(this.getStr());
	}
	
	/**
	 * 
	 */
	public void in() {}
	
	/**
	 * 
	 */
	protected void out() {}
}
