package com.proxy;

import java.lang.reflect.Proxy;

/**
 * 动态代理，其中的代理角色由Proxy方法生成。
 *
 */
public class Client {

	public static void main(String[] args) {

		Star realStar = new RealStar();// 真实对象
		StarHandler handler = new StarHandler(realStar);

		//生成代理类对象。
		Star proxy = (Star) Proxy.newProxyInstance(
				ClassLoader.getSystemClassLoader(), new Class[] { Star.class },handler);

		//代理类调用实现的方法。
		//每次调用方法都会进入StarHandler中的invoke方法中执行。
		//所以在处理器的invoke方法中可进行统一的流程控制。
		proxy.confer();
//		proxy.signContract();
//		proxy.bookTicket();
		proxy.sing();
//		proxy.collectMoney();
		
	}

}
