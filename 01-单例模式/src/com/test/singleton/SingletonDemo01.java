package com.test.singleton;

/**
 * 饿汉式单例模式。
 * 特点：
 * 1.类加载器加载时new出的对象,是天然线程安全的。
 * 2.不能延时加载，类在初始化时就new出了对象，不管有没有使用。
 *
 */
public class SingletonDemo01 {

	//2.提供一个静态属性。
	private static SingletonDemo01 instence = new SingletonDemo01();
	
	//1.私有构造器。
	private SingletonDemo01(){
		
	}
	
	public static SingletonDemo01 getInstence(){
		return instence;
	}

}
