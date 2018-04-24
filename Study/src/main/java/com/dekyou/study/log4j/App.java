package com.dekyou.study.log4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

/**
 * log4j 2.0+版本
 * 
 * @author DEKYOU
 *
 */
public class App {
	
	
	
	@Test
	public void test() {
		Logger log = LogManager.getLogger(App.class);
		int i = 2 << 3;
		System.out.println(i);
		if (log.isDebugEnabled()) {
			log.debug("This is a test");
			throw new AssertionError("This method should never be called");
		}
		String id = "123";
		String symbol = "333";
		//21:16:06.389 [main] ERROR com.dekyou.study.log4j.App - Processing trade with id:123 and symbol : [333] 
		log.error("Processing trade with id:[{}] and symbol : [{}] ", id, symbol);
		log.error("这是一个测试的例子[{}].", "测试的例子");
		log.trace("trace level");
		log.debug("debug level");
		log.info("info level");
		log.warn("warn level");
		log.error("error level");
		log.fatal("fatal level");
	}
	
	
	@Test
	public void test2() {
		Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);  
		logger.trace("trace level");
		logger.debug("debug level");
		logger.info("info level");
		logger.warn("warn level");
		logger.error("error level");
		logger.fatal("fatal level");
	}
}
