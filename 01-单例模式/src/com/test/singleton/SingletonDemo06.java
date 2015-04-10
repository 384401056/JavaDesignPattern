package com.test.singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * 懒汉式单例模式。
 * 1.可以延时加载，类加载时不初始化对象。只在使用时才new对象。
 * 2.线程不安全，取对象的方法要加synchronized.否则多个线程并发时，可能会new出一个以上的对象。调用效率变低。
 *
 */
public class SingletonDemo06 implements Serializable {
	
	private static SingletonDemo06 instence = null;
	
	private SingletonDemo06() {
		//用于防止通过反射来破解单例。
//		if(instence != null){
//			throw new RuntimeException();
//		}
	}
	
	
	public static synchronized SingletonDemo06 getInstence(){
		
		if(instence == null){
			instence = new SingletonDemo06();
		}
		return instence;
	}
	
	//反序列化时，如果定义了readResolve()方法，则直接返回此方法指定的对象，不会创建新的对象。
//	private Object readResolve() throws ObjectStreamException{
//		return instence;
//	}
}
