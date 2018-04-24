package com.dekyou.study.designs.prototype;

/**
 * @author GaoJing
 * @date 2018年3月27日
 * 
 */
public class Prototype implements Cloneable {
	
	@Override
	public Object clone() throws CloneNotSupportedException {
        Prototype proto = (Prototype) super.clone();  
        return proto;
	}
}

