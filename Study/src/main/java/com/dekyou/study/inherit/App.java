package com.dekyou.study.inherit;

import org.junit.Test;

import com.dekyou.study.inherit.wine.Wine;
import com.dekyou.study.inherit.wine.WlyWine;

/**
 * @author GaoJing
 * @date 2018年3月27日
 * 
 */
public class App {
	
	@Test
	public void test() {
		Biologic cat = new Cat();
		cat.call();
	}
	
	
	@Test
	public void test1() {
		Magpie magpie = new Magpie();
		magpie.Fly();
		
		Predators predators = new Magpie();
		predators.getStatus();
	}
	
	
	@Test
	public void test2() {
		Wine wine = new WlyWine();
		wine.fun1();
		
		
		
		{
			WlyWine wy = new WlyWine();
			wine.fun3(wy);
		}
		
	}
	
}

