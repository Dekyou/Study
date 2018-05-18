package com.dekyou.study.rt.file;

import java.io.File;

import org.junit.Test;

/**
 * @author GaoJing
 * @date 2018年5月10日
 * 
 */
public class AppFile {
	
	@Test
	public void test() {
		File file  = new File("D://adsfasdf//");
		file.mkdirs();
		if (file.isDirectory()) {
			System.out.println("This is directory");
		}else {
			System.out.println("This is not directory");
		}
	}
}

