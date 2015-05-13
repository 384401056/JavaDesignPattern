package com.blueice.log4j;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Test {

	public static void main(String[] args) {

		PropertyConfigurator.configure("log4j.properties");
		// 在后台输出
		Logger logger1 = Logger.getLogger(Test.class);
		logger1.debug("debug!!!");
		logger1.info("info!!!");
		logger1.warn("warn!!!");
		logger1.error("error!!!");
		logger1.fatal("fatal!!!");
	}

}
