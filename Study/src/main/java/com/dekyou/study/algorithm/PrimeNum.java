package com.dekyou.study.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;

/**
 * 计算所给的质数分解
 * 
 * @author GaoJing
 *
 */
public class PrimeNum {

	public static List<Integer> listInt = new ArrayList<Integer>();

	@Test
	public void test() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入一个整数:");
		int i = scanner.nextInt();

		this.getPrime(i);
		String strResult = "";
		for (Integer integer : listInt) {
			strResult += ("*" + integer);
		}

		System.out.println("i = " + strResult.substring(1, strResult.length()) + ";");

	}
	
	@Test
	public void test1() {
        int n = 2344234;
        Decompose(n);
	}

	/**
	 * 计算质数
	 * 
	 * @param i
	 */
	private void getPrime(int i) {

		if (i == 2) {
			listInt.add(i);
			return;
		}

		for (int j = 2; j < i; j++) {
			if (i % j == 0) {
				int a = i / j;
				this.getPrime(a);
				this.getPrime(j);
				return;
			}
			if (j == i - 1) {
				listInt.add(i);
				return;
			}
		}
	}

	/**
	 * 
	 * @param n
	 */
	private void Decompose(int n) {
		System.out.print(n + "=");
		for (int i = 2; i <= n; i++) {
			while (n % i == 0 && n != i) {
				n = n / i;
				System.out.print(i + "*");
			}
			if (n == i) {
				System.out.println(i);
				break;
			}

		}
	}
}
