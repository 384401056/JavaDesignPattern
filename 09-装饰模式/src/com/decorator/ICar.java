package com.decorator;

/**
 * 抽象构造角色。
 * @author Gaoyanbin
 *
 */
public interface ICar {
	void run();
}

//具体构造角色。
class Car implements ICar{

	@Override
	public void run() {
		System.out.println("我在地上跑！");
	}
	
}

//具体装饰角色。
class CarDecorator implements ICar{

	protected ICar car;//持有构造角色的引用。
	
	public CarDecorator(ICar car) {
		super();
		this.car = car;
	}

	@Override
	public void run() {
		car.run();//调用真实对象的方法。
	}
	
}


//具体的装饰类
class FlayCar extends CarDecorator{

	public FlayCar(ICar car) {
		super(car);
	}
	
	@Override
	public void run() {
		super.run();
		System.out.println("还可以在天上飞！");
	}
}

//具体的装饰类
class WaterCar extends CarDecorator{
	
	public WaterCar(ICar car) {
		super(car);
	}
	
	@Override
	public void run() {
		super.run();
		System.out.println("还可以在水里游！");
	}
}

//具体的装饰类
class AICar extends CarDecorator{
	
	public AICar(ICar car) {
		super(car);
	}
	
	@Override
	public void run() {
		super.run();
		System.out.println("还可以自动驾驶！");
	}
}




















