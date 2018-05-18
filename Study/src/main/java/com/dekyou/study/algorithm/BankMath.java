package com.dekyou.study.algorithm;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import org.junit.Test;

/**
 * 银行记账的方法
 * 
 * @author GaoJing
 * @date 2018年4月8日
 * 
 * 
 * 1、 ROUND_UP：远离零方向舍入。向绝对值最大的方向舍入，只要舍弃位非0即进位。
 * 2、 ROUND_DOWN：趋向零方向舍入。向绝对值最小的方向输入，所有的位都要舍弃，不存在进位情况。
 * 3、 ROUND_CEILING：向正无穷方向舍入。向正最大方向靠拢。若是正数，舍入行为类似于 ROUND_U
 * P，若为负数，舍入行为类似于 ROUND_DOWN。 Math.round() 方法就是使用的此模式。
 * 4、 ROUND_FLOOR：向负无穷方向舍入。向负无穷方向靠拢。若是正数，舍入行为类似于 ROUND_DOWN；若为负数，舍入行为类似于 ROUND_UP。
 * 5、 HALF_UP：最近数字舍入(5进)。这是我们最经典的四舍五入。
 * 6、 HALF_DOWN：最近数字舍入(5舍)。在这里5是要舍弃的。
 * 7、 HAIL_EVEN：银行家舍入法。
 * 
 * 
 * 
 */
public class BankMath {
	
	
	/*
	 *  1.舍去位的数值小于 5 时，直接舍去。
	 *  2.舍去位的数值大于 5 时，进位后舍去。
	 *  3.当舍去位的数值等于 5 时，若 5 后面还有其他非 0 数值，则进位后舍去，若 5 后面是 0 时，则根据5前一位数的奇偶性来判断，奇数进位，偶数舍去。
	 */
	@Test
	public void test() {
		BigDecimal bd = new BigDecimal(1000);
		BigDecimal bd1 = new BigDecimal(0.34582375);
		bd.multiply(bd1);
		
		BigDecimal bd2 = bd1.setScale(2, RoundingMode.HALF_EVEN);
		
		System.out.println(bd2);
		
	}
	
	@Test
	public void test1() {
		DecimalFormat df = new DecimalFormat("#.00");
		String result = df.format(1.3457950);
		
		System.out.println(result);
	}
	
	@Test
	public void test2() {
		double d = 3.1415926;
		String result = String.format("%.2f", d);
		
		System.out.println(result);
	}
	
	
	@Test
	public void test3() {
		double f = 1.10;
		BigDecimal b = new BigDecimal(f);
		double f1 = b.setScale(2, RoundingMode.DOWN).doubleValue();
	
		System.out.println(f1);
	}
	
}

