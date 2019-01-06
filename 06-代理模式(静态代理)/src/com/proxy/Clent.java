package com.proxy;

/**
 * 客户对象
 *
 */
public class Clent {

	
	public static void main(String[] args) {
		
		//真实对象
		Star realStar  = new RealStar();
		
		//代理对象
		Star proxyStar = new ProxyStar(realStar);

		proxyStar.sing();

		
	}
}
