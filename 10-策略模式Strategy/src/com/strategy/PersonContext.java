package com.strategy;

/**
 * 环境类(Context):用一个ConcreteStrategy对象来配置。维护一个对Strategy对象的引用。可定义一个接口来让Strategy访问它的数据。 
 * 算法解决类，以提供客户选择使用何种解决方案： 
 * @author Gaoyanbin
 *
 */
public class PersonContext {

	TravelStrategy strategy = null;

	public PersonContext(TravelStrategy strategy) {
		super();
		this.strategy = strategy;
	}

	public void setStrategy(TravelStrategy strategy) {
		this.strategy = strategy;
	}
	
	
	public void travel(){
		strategy.travelAlgorithm();
	}
	

}



