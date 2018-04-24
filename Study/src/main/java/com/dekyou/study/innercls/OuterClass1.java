package com.dekyou.study.innercls;

import org.junit.Test;

public class OuterClass1 extends TestAbs implements FatherInterface {

	@Test
	public void test() {
		OuterClass1.InnerClass innerClass = this.new InnerClass();
//		OuterClass1.InnerClass innerClass1 = new OuterClass1.InnerClass();
//		OuterClass1.InnerClass innerClass2 = new InnerClass();
		innerClass.out();
		innerClass.in();
		innerClass.test();
		super.getStr();
	}
	
	public class InnerClass implements TestInterface{
		
		public String innerVar = "innerVar";
		
		protected String innerVar1 = "innerVar1";
		
		private String innerVar2 = "innerVar2";
		
		String innerVar3 = "innerVar3";
		
		public void test() {
			System.out.println("from OuterClass1.InnerClass.test()");
			System.out.println(innerVar + innerVar1 + innerVar2 + innerVar3);
		}

		@Override
		public void out() {
			System.out.println("Method Overrid by InnerClass.out()");
		}

		@Override
		public void in() {
			System.out.println("Method Voerrid by InnerClass.in()");
		}

		@Override
		public void testIn(TestCls tc) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	protected class InnerClass1{

		
		public String innerVar = "innerVar";
		
		protected String innerVar1 = "innerVar1";
		
		private String innerVar2 = "innerVar2";
		
		String innerVar3 = "innerVar3";
		
		public void test() {
			System.out.println("from OuterClass1.InnerClass.test()");
			System.out.println(innerVar + innerVar1 + innerVar2 + innerVar3);
		}
	}
	
	private class InnerClass2{
		
		public String innerVar = "innerVar";
		
		protected String innerVar1 = "innerVar1";
		
		private String innerVar2 = "innerVar2";
		
		String innerVar3 = "innerVar3";
		
		public void test() {
			System.out.println("from OuterClass2.InnerClass.test()");
			System.out.println(innerVar + innerVar1 + innerVar2 + innerVar3);
		}
		
	}
	
	class InnerClass3{
		
		public String innerVar = "innerVar";
		
		protected String innerVar1 = "innerVar1";
		
		private String innerVar2 = "innerVar2";
		
		String innerVar3 = "innerVar3";
		
		public void test() {
			System.out.println("from OuterClass3.InnerClass.test()");
			System.out.println(innerVar + innerVar1 + innerVar2 + innerVar3);
		}
		
	}
	

	@Override
	public void fatherIn() {
		
	}

	@Override
	public void fatherOut() {
		
	}

	@Override
	public String getStr(String a) {
		return null;
	}
	
	
	public final static void test1() {
		
	}
	
	public void show(TestCls tc) {
		tc.show();
	}
	
}
