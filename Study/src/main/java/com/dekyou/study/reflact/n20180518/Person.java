package com.dekyou.study.reflact.n20180518;

import java.io.Serializable;

/**
 * @author GaoJing
 * @date 2018年5月18日
 * 
 */
public class Person implements Serializable{

	private static final long serialVersionUID = 2730808990992802031L;

	private String name;
	
	private int age;
	
	private String address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
}

