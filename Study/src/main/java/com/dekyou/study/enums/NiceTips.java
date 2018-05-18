package com.dekyou.study.enums;

/**
 * @author GaoJing
 * @date 2018年5月16日
 * 
 */
public enum NiceTips {

	FileNoteFund("附件丢失了，请联系管理员"),
	UnExcepted("系统内部错误");
	
	private String message;
	private NiceTips(String message){
		this.message = message;
	}

	@Override
	public String toString() {
		return this.message;
	}

}