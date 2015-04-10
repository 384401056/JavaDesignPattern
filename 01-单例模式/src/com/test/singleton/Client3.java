package com.test.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.util.concurrent.CountDownLatch;

/**
 * 使用线程辅助类，在多线程环境下测试五种单例模式的使用效率。
 */
public class Client3 {

	public static void main(String[] args) throws Exception {
		
		//计时
		long star = System.currentTimeMillis();
		
		//开启线程数。
		int thredNum = 10;
		
		//同步辅助类。传入线程数。
		final CountDownLatch countDownLatch = new CountDownLatch(thredNum);
		
		//循环开启10个线程。
		for(int i = 0;i<thredNum ;i++){
			new Thread(new Runnable() {
				@Override
				public void run() {

					//循环创建1000000个单便对象。
					for(int i = 0;i<1000000;i++){
//						Object o = SingletonDemo01.getInstence();//5ms
//						Object o = SingletonDemo02.getInstence();//2263ms
//						Object o = SingletonDemo03.getInstence();//2738
//						Object o = SingletonDemo04.getInstence();//6ms
//						Object o = SingletonDemo05.INSTENCE;//5ms
					}
					
					countDownLatch.countDown();//计数器减一。
				}
			}).start();
			
		}
		
		countDownLatch.await();//main线程等待，直到计数器为0.再开始往下执行。
		
		long end = System.currentTimeMillis();
		System.out.println("总耗时："+(end - star)+"ms");
	}
	
	
	
}




















