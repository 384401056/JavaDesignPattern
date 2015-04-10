package com.test.singleton;

/**
 * 懒汉式单例模式。
 * 1.可以延时加载，类加载时不初始化对象。只在使用时才new对象。
 * 2.线程不安全，取对象的方法要加synchronized.否则多个线程并发时，可能会new出一个以上的对象。调用效率变低。
 *
 */
public class SingletonDemo02 {
	
	private static SingletonDemo02 instence = null;
	
	private SingletonDemo02() {
		//用于防止通过反射来破解单例。
//		if(instence != null){
//			throw new RuntimeException();
//		}
	}
	
	
	public static synchronized SingletonDemo02 getInstence(){
		
		if(instence == null){
			instence = new SingletonDemo02();
		}
		return instence;
	}
}
