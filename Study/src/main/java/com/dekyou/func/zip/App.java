package com.dekyou.func.zip;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.junit.Test;

/**
 * @author GaoJing
 * @date 2018年5月3日
 * 
 */
public class App {

	public void mainTest() {
		String root = "附件";
		String fileName = "测试";
		
		FileOutputStream fos = null;
		ZipOutputStream zos = null;
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		
		File zipFile = new File("D://official.zip");
		
//		this.write();
	}
	
	
	private void write(String sourceRoot) {
		File sourceFileRoot = new File(sourceRoot);
		File[] sourceFiles  = sourceFileRoot.listFiles();
		
		for (int i = 0;  i < sourceFiles.length; i++) {
			
			if (sourceFiles[i].isDirectory()) {
				continue;
			}
			
		}
		
	}
	
	
	@Test
	public void test() throws IOException {
		File sourcefile = new File("D://DOC");
		
		FileOutputStream fos = null;
		ZipOutputStream zos = null;
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		
		File zipFile = new File("D://test.zip");
		
		File[] sourceFiles = sourcefile.listFiles();

		fos = new FileOutputStream(zipFile);
		zos = new ZipOutputStream(new BufferedOutputStream(fos));
		byte[] bufs = new byte[1024 * 10];
		
		File file = new File("D:\\DOC\\a.txt");
		for (int i = 0; i < sourceFiles.length; i++) {
			
			if (sourceFiles[i].isDirectory()) {
				continue;
			}
			// 创建ZIP实体，并添加进压缩包
			String a = "";
			if ( i == 0) {
				a = "DOC\\";
			}
			
			if ( i == 1) {
				a = "DOC\\aa\\";
			}
			
			if ( i == 2) {
				a = "DOC\\bb\\";
			}
			
			if ( i == 3) {
				a = "DOC\\aa1\\";
			}
			
			
			ZipEntry zipEntry = new ZipEntry(a + file.getName());
			zos.putNextEntry(zipEntry);
			// 读取待压缩的文件并写进压缩包里
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis, 1024 * 10);
			int read = 0;
			while ((read = bis.read(bufs, 0, 1024 * 10)) != -1) {
				zos.write(bufs, 0, read);
			}
		}
		
		try {
			if (null != bis)
				bis.close();
			if (null != zos)
				zos.close();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Test
	public void fileToZip() throws IOException {
		File sourceFile = new File("D://DOC");
		
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		FileOutputStream fos = null;
		ZipOutputStream zos = null;

		File zipFile = new File("D://aa.zip");
		
		File[] sourceFiles = sourceFile.listFiles();
		
		fos = new FileOutputStream(zipFile);
		zos = new ZipOutputStream(new BufferedOutputStream(fos));
		byte[] bufs = new byte[1024 * 10];
		for (int i = 0; i < sourceFiles.length; i++) {
			// 创建ZIP实体，并添加进压缩包
			ZipEntry zipEntry = new ZipEntry(sourceFiles[i].getName());
			zos.putNextEntry(zipEntry);
			// 读取待压缩的文件并写进压缩包里
			fis = new FileInputStream(sourceFiles[i]);
			bis = new BufferedInputStream(fis, 1024 * 10);
			int read = 0;
			while ((read = bis.read(bufs, 0, 1024 * 10)) != -1) {
				zos.write(bufs, 0, read);
			}
		}

		// 关闭流
		try {
			if (null != bis)
				bis.close();
			if (null != zos)
				zos.close();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	@Test
	public void tetet1() throws IOException {
		this.fileToZip();
	}
}
