package com.dekyou.study.finals;

/**
 * @author GaoJing
 * @date 2018年5月14日
 * 
 */
public class App {

	
	public static void main(String[] args) {
		PersonBean pb = new PersonBean();
		pb.setAge("11");
		pb.setName("GaoJing");
		pb.setGender("male");
		
		PersonBean pb1 = new PersonBean();
		pb1.setAge("111");
		pb1.setName("Dekyou");
		pb1.setGender("male");
		
		
		assignment(pb);
		assignment(pb1);
	
	}
	
	
	public static void assignment(PersonBean et) {
		final PersonBean pbf = et;
		System.out.println(pbf.getName());
	}
}

