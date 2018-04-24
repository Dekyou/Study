package com.dekyou.study.innercls.second;

import com.dekyou.study.innercls.second.i.Female;

/**
 * @author GaoJing
 * @date 2018年4月10日
 * 
 */
public class MotherImpl implements Female {
	
	private String name;
	
	private int age;

	public MotherImpl() {
		this.name = "YeHuiMei";
		this.age = 40;
	}
	@Override
	public void eat() {
		System.out.println("Mother eat");
	}

	@Override
	public void say() {
		System.out.println("Mother say");
	}

	@Override
	public void smile() {
		System.out.println("Mother smile");
	}
	
	
	public void getSonName() {
		Son son = this.new Son();
		son.getName();
	}
	
	public class Son extends FatherImpl{

		private String name;
		
		
		public Son() {
			this.name = "jielun";
		}
		
		public void getName() {
			System.out.println(this.name);
		}
		@Override
		public void fight() {
			System.out.println("Son fight");
		}
		
		public void getMotherName() {
			System.out.println(name);
		}
		
		public void getMotherAge() {
			System.out.println(age);
		}
		
		public void smile1() {
			smile();
		}
	}

}

