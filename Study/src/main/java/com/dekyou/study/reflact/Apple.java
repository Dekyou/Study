package com.dekyou.study.reflact;

import java.io.Serializable;
import java.util.Date;

public class Apple implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3923059706195692014L;

	private String name;
	
	private int count;
	
	private double price;
	
	private Date date;
	
	/**
	 * 构造函数一
	 */
	public Apple() {
		System.out.println("Unknow Apple Name");
	}
	
	/**
	 * 构造函数二
	 * @param name 名称
	 */
	protected Apple(String name) {
		this.name = name;
		System.out.println(name);
	}
	
	/**
	 * 构造函数三
	 * @param name 名称
	 * @param count 数量
	 * @param price 单价
	 */
	private Apple(String name, int count, double price) {
		this.name = name;
		this.count = count;
		this.price = price;
	}
	
	/**
	 * 获取苹果名称
	 * @return 苹果名称
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * 获取总金额
	 * @return 苹果的总价额
	 */
	public double getSumPrice() {
		double sumPrice = count * price;
		return sumPrice;
	}
	
	public Date getDateOfProduction() {
		return this.date;
	}
}
