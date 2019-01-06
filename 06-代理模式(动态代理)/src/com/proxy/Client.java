package com.proxy;

import java.lang.reflect.Proxy;

/**
 * 动态代理，其中的代理角色由Proxy方法生成。
 *
 */
public class Client {

	public static void main(String[] args) {

		IStar realIStar = new RealIStar();// 真实对象
		StarHandler handler = new StarHandler(realIStar);

		IStar proxy = (IStar) Proxy.newProxyInstance(
				realIStar.getClass().getClassLoader(),
				realIStar.getClass().getInterfaces(),
				handler);

		//代理类调用实现的方法。
		//每次调用方法都会进入StarHandler中的invoke方法中执行。
		//所以在处理器的invoke方法中可进行统一的流程控制。
//		Object obj = proxy.confer();
//		System.out.println("obj = :"+ obj);
//		proxy.sing();

		proxy.talk("Ha Ha Ha");
		
	}

}
