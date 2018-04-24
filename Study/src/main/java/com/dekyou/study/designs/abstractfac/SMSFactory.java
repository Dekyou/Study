package com.dekyou.study.designs.abstractfac;

/**
*@author GaoJing
*@date 2018年3月27日
*/
public class SMSFactory implements Provider {

	public Sender produce() {
		return new SMSSender();
	}

}

