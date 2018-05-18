package com.dekyou.study.arithmetic;

import org.junit.Test;

/**
 * 
 * @author DEKYOU
 */
public class App {
	
	@Test
	public void test() {
		
		int[] sourceData =new int[10000];
		for (int i = 0; i < 10000; i++) {
			int num=(int)(Math.random()*1000000); 
			sourceData[i] = num;
		}
	
		
		BubbleSort bs = new BubbleSort();
		long startT = System.currentTimeMillis();
		bs.sort(sourceData);
		long endT = System.currentTimeMillis();
		
		
		
		long startT1 = System.currentTimeMillis();
		int[] b = bs.sort_self(sourceData, sourceData.length);
		for (int j =0; j<b.length ; j++) {
			System.out.println(b[j]);
		}
		long endT1 = System.currentTimeMillis();
		System.out.println("消耗的时间:" + (endT - startT));
		System.out.println("消耗的时间:" + (endT1 - startT1));
	}
	
}
