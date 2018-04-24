package com.dekyou.study.designs.abstractfac;

/**
*@author GaoJing
*@date 2018年3月27日
*/
public class EmailFactory implements Provider {

	@Override
	public Sender produce() {
		return new EmailSender();
	}

}

