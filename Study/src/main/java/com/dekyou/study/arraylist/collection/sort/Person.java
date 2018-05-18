package com.dekyou.study.arraylist.collection.sort;

/**
 * @author GaoJing
 * @date 2018年4月27日
 * 
 */
public class Person implements Comparable<Person>{
	
	private int age;
	
	private String name;
	
	private String address;
	
	private String email;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int compareTo(Person o) {
		
		return this.getAge();
	}
	
}

