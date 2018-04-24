package com.dekyou.study.exception;

import org.junit.Test;

public class App {

	@Test
	public void test() throws Exception {
		try {
			try {
				
				throw new Sneeze();
			} catch (Annoyance a) {
				System.out.println("Caught Annoyance");
				throw a;
			}
		} catch (Sneeze s) {
			System.out.println("Caught Sneeze");
			return;
		} finally {
			System.out.println("Hello World!");
		}
	}
	
	
}
