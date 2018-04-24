package com.dekyou.study.designs.abstractfac;

/**
*@author GaoJing
*@date 2018年3月27日
*/
public interface Provider {
	
	/**
	 * 获取工厂
	 * @return
	 */
	public Sender produce();
	
//	public abstract void c();
}

