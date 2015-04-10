package com.test.singleton;

public class Client {

	public static void main(String[] args) {
		
		
//		SingletonDemo04 s1 = SingletonDemo04.getInstence();
//		SingletonDemo04 s2 = SingletonDemo04.getInstence();
//		SingletonDemo04 s3 = SingletonDemo04.getInstence();
//		
//		System.out.println(s1);
//		System.out.println(s2);
//		System.out.println(s3);
		
		
		SingletonDemo05 ss1 = SingletonDemo05.INSTENCE;
		SingletonDemo05 ss2 = SingletonDemo05.INSTENCE;
		
		System.out.println(ss1 == ss2);
		
		ss1.singletonOperation();
		ss2.singletonOperation();

	}

}
