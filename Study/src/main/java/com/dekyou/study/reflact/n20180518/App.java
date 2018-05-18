package com.dekyou.study.reflact.n20180518;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Test;

import com.dekyou.study.reflact.n20180518.usrclsload.UsrClassLoader;

/**
 * @author GaoJing
 * @date 2018年5月18日
 * 
 */
public class App {
	
	/**
	 * 序列化
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	@Test
	public void write() throws FileNotFoundException, IOException {
		Person person = new Person();
		person.setName("Dekyou");
		person.setAge(27);
		person.setAddress("TestAddresss");
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("D://Person.txt")));
		oos.writeObject(person);
		oos.close();
	}
	
	/**
	 * 反序列化
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws ClassNotFoundException 
	 */
	@Test
	public void read() throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("D://Person.txt")));
		Person person = (Person)ois.readObject();
		ois.close();
		System.out.println(person.getName());
	}
	
	
	@Test
	public void getClassLoadPath() {
		System.out.println(Person.class.getClassLoader().getResource("").toString());
	}
	
	@Test
	public void testClassLoad() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		String path = "D:\\";
		UsrClassLoader usrLoad = new UsrClassLoader(path);
		Class<?> r = usrLoad.findeClass("Person.class");
		System.out.println(r.newInstance());
		
	}

}

