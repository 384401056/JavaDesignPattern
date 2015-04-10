package com.factory.factorymethod;

/**
 * 通过工厂方法模式来生成对象
 * 1.使用不同的工厂来生成不同的对象。
 * 2.对于新增产品，只要新增对应的工厂类即可。
 * @author Gaoyanbin
 * @author Gaoyanbin
 *
 */
public class Client {

	
	public static void main(String[] args) {
		
		Car c1 = AudiFactory.createCar();
		Car c2 = BydFactory.createCar();
		c1.run();
		c2.run();
		
	}
	
}
