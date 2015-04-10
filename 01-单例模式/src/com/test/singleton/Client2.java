package com.test.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

/**
 * 1.通过反射来破解懒汉式单例。
 * 要想防止这种破解，在单例对象的构造函数中加入如下判断
 * if(instence != null){
 * 		throw new RuntimeException();
 * }
 *
 * 2.通过反序列化的方式来构造多个单例对象。（单例对象要实现Serializable）
 * 要防止这种破解，可在单例对象中定义一个方法。readResolve()
 * private Object readResolve() throws ObjectStreamException{
 * 		return instence;
 * }
 */
public class Client2 {

	public static void main(String[] args) throws Exception {
		SingletonDemo06 s1 = SingletonDemo06.getInstence();
		SingletonDemo06 s2 = SingletonDemo06.getInstence();

		
		System.out.println(s1);
		System.out.println(s2);
		
		/**
		 * 1.通过反射来破解懒汉式单例。
		 */
//		//通过反射获得类。
//		Class<SingletonDemo06> clazz = (Class<SingletonDemo06>) Class.forName("com.test.singleton.SingletonDemo06");
//		
//		//创建一个类构造器。
//		Constructor<SingletonDemo06> constructor = clazz.getDeclaredConstructor(null);
//		constructor.setAccessible(true);//跳过权限检查，才能访问私有的构造方法。
//		
//		//构造对象。
//		SingletonDemo06 s3 = constructor.newInstance();
//		SingletonDemo06 s4 = constructor.newInstance();
//		
//		System.out.println(s3);
//		System.out.println(s4);
		
		/*
		 * 2.通过反序列化的方式来构造多个单例对象。（单例对象要实现Serializable）
		 */

		//将单例对象s1输出到文件中。
		FileOutputStream fos = new FileOutputStream("D:/a.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(s1);
		oos.close();
		fos.close();
		
		//从文件中读出对象。这个对象就是一个新的对象。
		FileInputStream fis = new FileInputStream("D:/a.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		SingletonDemo06 s3 = (SingletonDemo06) ois.readObject();
		ois.close();
		fis.close();
		
		System.out.println(s3);
		
	}

}




















