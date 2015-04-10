package com.test.singleton;

/**
 * 枚举式实现单例模式。
 *
 * 1.实现简单。线程安全，调整效率高。避免通过反射和反序例化的漏洞。但是不能延时加载。
 *
 */
public enum SingletonDemo05 {

	/**
	 * 定义一个枚举元素，它就代表了一个SingletonDemo5的实例。
	 */
	INSTENCE;
	
	/**
	 * 单例可以有自己的操作。
	 */
	public void singletonOperation(){
		//功能处理。
		System.out.println("singletonOperation");
	}

}
