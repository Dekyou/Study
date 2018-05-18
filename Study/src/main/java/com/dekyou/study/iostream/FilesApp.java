package com.dekyou.study.iostream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

/**
 * @author GaoJing
 * @date 2018年5月15日
 * 
 */
public class FilesApp {
	
	/**
	 * 一个中文占用2个字节
	 * 一个字符2个字节
	 * 使用InputStream。read()方法，是一个字节一个字节读取，所以会中文乱码
	 * @throws IOException
	 */
	@Test
	public void test() throws IOException {
		File file = new File("D://test.txt");
		FileInputStream inputStream = new FileInputStream(file);
//		int b = 0;
//		while(b != -1) {
//			b = inputStream.read();
//			System.out.print((char)b);
//		}
		byte[] bytes = new byte[64];
		while ( (inputStream.read(bytes)) != -1) {
			System.out.println(new String(bytes));
		}
		
	}
	
//	@Test
//	public void test2() throws IOException {
//		FileReader fileReader = new FileReader("D://test.txt");
//		int i = 0;
//		
//		while(i != -1) {
//			i = fileReader.read();
//			System.out.print((char)i);
//		}
//	}
}

