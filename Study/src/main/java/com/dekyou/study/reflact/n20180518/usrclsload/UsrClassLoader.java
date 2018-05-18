package com.dekyou.study.reflact.n20180518.usrclsload;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import com.sun.org.apache.bcel.internal.util.ClassLoader;

/**
 * @author GaoJing
 * @date 2018年5月18日
 * 
 */
public class UsrClassLoader extends ClassLoader {
	
	private String classPath;
	
	String className = "com.dekyou.study.reflact.n20180518.Person";
	
	public UsrClassLoader(String classPath) {
		this.classPath = classPath;
	}
	
	public Class<?> findeClass(String name) throws ClassNotFoundException{
		
		byte[] classData = getData(name);
		
		if (classData == null) {
			throw new ClassNotFoundException();
		}else {
			return defineClass(className, classData, 0, classData.length);
		}
		
	}

	private byte[] getData(String name) {
		String path = classPath + name;
		InputStream is = null;
		try {
			is = new FileInputStream(path);
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			byte[] buffer = new byte[2048];
			int num = 0;
			while( (num = is.read(buffer)) != -1) {
				stream.write(buffer, 0, num);
				return stream.toByteArray();
			}
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
}

