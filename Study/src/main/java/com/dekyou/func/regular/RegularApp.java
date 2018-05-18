package com.dekyou.func.regular;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

/**
 * @author GaoJing
 * @date 2018年5月16日
 * 
 */
public class RegularApp {
	
	//匹配邮箱
	private static final String regix_1 = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";
	private static final String Gao_regix_1 = "^\\w+@{1}\\w+(\\.\\w+)+$";
	private static final ArrayList<String> emailDataList = new ArrayList<String>(20);
	
	private static final String Gao_regix_2 = "^1[3-8]\\d{9}";
	private static final ArrayList<String> phoneNumberDataList = new ArrayList<String>(20);
	
	private static final String Gao_regix_3 = "^\\w+\\d+$";
	//Test email data
	static{
		emailDataList.add("asdfa@qq....com");
		emailDataList.add("asdfaqq.com");
		emailDataList.add("d测试@qq.com");
		emailDataList.add("adf@adf@asdf.qq.com");
		emailDataList.add("pingan@gmail.com");
		emailDataList.add("pinggan@123.com");
		emailDataList.add("&(*@qq.com");
		emailDataList.add("ttttt@sina.com");
		emailDataList.add("dekyou@qq.com");
		emailDataList.add("dekyou@yeah.com");
		emailDataList.add("高靖@aq.com");
		emailDataList.add("fadsf@@@@@cn.cm");
		emailDataList.add("fff@@@@dcn.@@@.com");
		emailDataList.add("dekyou@qq.@qq");
		emailDataList.add("123@qq.com.com.com");
		emailDataList.add("12321##%%@qq.com");
		emailDataList.add("__sadfa@qq..com");
		emailDataList.add("asdf++@qq.com");
		emailDataList.add("gggg$$$@qq.com");
		
		
		phoneNumberDataList.add("qewrqewf");
		phoneNumberDataList.add("12341eqe1324");
		phoneNumberDataList.add("adsfqwe1234.132");
		phoneNumberDataList.add("132412345");
		phoneNumberDataList.add("13816280657");
		phoneNumberDataList.add("11111111111");
		phoneNumberDataList.add("12311111111");
		phoneNumberDataList.add("1234123412");
		phoneNumberDataList.add("123412");
		phoneNumberDataList.add("123412341234");
		
	}
	
	
	
	
	@Test
	public void testEmail() {
		Pattern pattern = Pattern.compile(Gao_regix_1);
		
		for (String str : emailDataList) {
			 Matcher m = pattern.matcher(str);
			 if (m.matches()) {
				 System.out.println(str);
			 }
		}
		
	}
	
	@Test
	public void testPhoneNumber() {
		Pattern pattern = Pattern.compile(Gao_regix_2);
		
		for (String str : phoneNumberDataList) {
			 Matcher m = pattern.matcher(str);
			 if (m.matches()) {
				 System.out.println(str);
			 }
		}
	}
	
	@Test
	public void testAuto() {
		String a = "adsfa444";
		if (Pattern.matches(Gao_regix_3, a)) {
			System.out.println(a);
		}
	}
}

