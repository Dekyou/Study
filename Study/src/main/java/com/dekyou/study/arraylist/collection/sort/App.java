package com.dekyou.study.arraylist.collection.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.poi.ss.formula.functions.T;
import org.junit.Test;

/**
 * @author GaoJing
 * @date 2018年4月27日
 * 
 */
public class App {
	
	@Test
	public void test1() {
		List<Person> listPerson = new ArrayList<Person>();
		Person ps = new Person();
		ps.setName("name18");
		ps.setAge(18);
		ps.setAddress("name18's address");
		listPerson.add(ps);
		
		Person ps1 = new Person();
		ps1.setName("name181");
		ps1.setAge(19);
		ps1.setAddress("name181's address");
		listPerson.add(ps1);
		
		Person ps2 = new Person();
		ps2.setName("name118");
		ps2.setAge(10);
		ps2.setAddress("name118's address");
		listPerson.add(ps2);
		
		
		Person ps3 = new Person();
		ps3.setName("40");
		ps3.setAge(40);
		ps3.setAddress("40's address");
		listPerson.add(ps3);
		
		Person ps4 = new Person();
		ps4.setName("35");
		ps4.setAge(35);
		ps4.setAddress("35's address");
		listPerson.add(ps4);
		
//		Collections.sort(listPerson, new Comparator<Person>() {
//
//			@Override
//			public int compare(Person o1, Person o2) {
//				int result = o2.getAge() - o1.getAge();
////				System.out.println(result);
//				return result;
//			}
//			
//		});
		
		Collections.sort(listPerson);
		
		for (Person pp : listPerson) {
			System.out.println(pp.getAge());
		}
	}
}

