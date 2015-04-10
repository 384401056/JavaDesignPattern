package com.factory.simplefactory;

/**
 * 通过简单工厂模式（静态工厂模式）来生成对象
 * 1.此工厂类一般都是静态方法，通过接收不同的参数来返回不同的类。
 * 2.不修改工厂类代码无法实现新增产品。对于新增产品能力有限，
 * @author Gaoyanbin
 *
 */
public class Client {

	
	public static void main(String[] args) {

		
		Car car1 = CarFactory.createCar("audi");
		Car car2 = CarFactory.createCar("byd");
		
		car1.run();
		car2.run();
		
	}

}
