package com.dekyou.study.innercls.second;

import com.dekyou.study.innercls.second.i.Male;

/**
 * @author GaoJing
 * @date 2018年4月10日
 * 
 */
public class FatherImpl implements Male {

	@Override
	public void eat() {
		System.out.println("Father eat");

	}

	@Override
	public void say() {
		System.out.println("Father say");

	}

	@Override
	public void fight() {
		System.out.println("Father figth");

	}

}

