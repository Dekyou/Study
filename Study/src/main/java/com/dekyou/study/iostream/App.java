package com.dekyou.study.iostream;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.junit.Test;

/**
 * 测试输入输出流
 * @author DEKYOU
 */
public class App{
	
	/**
	 * 字符集
	 */
	private final static String CHARSET = "GBK";
	
	/**
	 * 读取文件测试
	 * try-with-resources方式。
	 * 如果你的资源实现了 AutoCloseable 接口，你可以使用这个语法。大多数的 Java 标准资源都继承了这个接口。当你在 try 子句中打开资源，资源会在 try 代码块执行后或异常处理后自动关闭。
	 * uses a try-with-resources statement to automatically close a java.sql.Statement object:
	 */
	@Test
	public void test1() {
		
		String errorInfo = null;
		String fileContent = "";
		String fileContent1 = "";
		
		try(FileInputStream fileInputStream = new FileInputStream("D:\\aa.txt");
			FileReader fileReader = new FileReader("D:\\test.txt");
			Scanner scanner = new Scanner(fileInputStream,CHARSET);
			BufferedReader bufferedReader = new BufferedReader(fileReader)){
			
			while(scanner.hasNextLine()) {
				fileContent += (scanner.nextLine() + System.lineSeparator());
			}
			
			
			System.out.print(fileContent);
			
			if (fileContent != "") {
				throw new FileNotFoundException("找不到文件");
			}
			
			while(bufferedReader.read() != -1) {
				fileContent1 += (bufferedReader.readLine() + System.lineSeparator());
			}
			
			System.out.print(fileContent1);
			
			
			
		}catch(FileNotFoundException e) {
			errorInfo = e.getMessage();
		}catch(IOException e) {
			errorInfo = e.getMessage();
		}finally {
			if (errorInfo != null) {
				System.out.println(errorInfo);
			}
		}
	}

	
}
