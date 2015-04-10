package com.test.singleton;

/**
 * 双重检测锁实现单例模式。
 * 1.可以延时加载，类加载时不初始化对象。只在使用时才new对象。
 * 2.将同步放到了方法内部的if判断中去了。提高了执行的效率。
 * 
 * 但是由于编译器优化原因和JVM底层内部模型的原因偶尔会出问题。不建议使用。
 */
public class SingletonDemo03 {
	
	private static SingletonDemo03 instence = null;
	
	private SingletonDemo03() {
		
	}
	
	public static synchronized SingletonDemo03 getInstence(){
		if(instence == null){
			SingletonDemo03 sc;
			
			synchronized (SingletonDemo03.class) {
				sc = instence;
				if(sc == null){
					synchronized (SingletonDemo03.class) {
						if(sc==null){
							sc = new SingletonDemo03();
						}
					}
					instence = sc;
				}
			}
			
		}
		return instence;
	}
}
