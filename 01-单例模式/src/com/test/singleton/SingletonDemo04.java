package com.test.singleton;

/**
 * 静态内部类实现单例模式。
 * 特点：
 * 1.延时加载，线程安全，调整效率高。使用广泛。
 *
 */
public class SingletonDemo04 {

	//2.提供一个静态内部类。
	private static class SingletonClassInstence {
		private static final SingletonDemo04 instence = new SingletonDemo04();
	}
	
	//1.私有构造器。
	private SingletonDemo04(){
		 
	}
	
	public static SingletonDemo04 getInstence(){
		return SingletonClassInstence.instence;
	}

}
