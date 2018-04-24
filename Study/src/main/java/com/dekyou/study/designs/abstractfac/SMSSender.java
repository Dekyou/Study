package com.dekyou.study.designs.abstractfac;

/**
*@author GaoJing
*@date 2018年3月27日
*/
public class SMSSender implements Sender {

	@Override
	public void send() {
		System.out.println("短信发送");
	}

}

