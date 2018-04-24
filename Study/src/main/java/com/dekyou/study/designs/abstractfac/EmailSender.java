package com.dekyou.study.designs.abstractfac;

/**
*@author GaoJing
*@date 2018年3月27日
*/
public class EmailSender implements Sender {

	public void send() {
		System.out.println("邮件发送");
	}

}

