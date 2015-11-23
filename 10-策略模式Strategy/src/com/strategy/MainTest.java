package com.strategy;


public class MainTest {

	/** 
	* 策略模式 
	* 定义一系列的算法,把每一个算法封装起来, 并且使它们可相互替换。本模式使得算法可独立于使用它的客户而变化 
	* 
	*/ 
	public static void main(String[] args) {
		
		PersonContext person = new PersonContext(new AirPlanelStrategy());
		person.travel();
		
		person.setStrategy(new TrainStrategy());
		person.travel();
		
		person.setStrategy(new BicycleStrategy());
		person.travel();
		
		
		person.setStrategy(new TravelStrategy() {
			
			@Override
			public void travelAlgorithm() {
				System.out.println("走路去旅行。");
			}
		});
		person.travel();
	}
}


/**
 * 实现策略的类。代表乘坐飞机去旅行。
 * @author Gaoyanbin
 *
 */
class AirPlanelStrategy implements TravelStrategy{

	@Override
	public void travelAlgorithm() {
		System.out.println("乘坐飞机去旅行。");
	}
	
}

/**
 * 实现策略的类。代表乘坐火车去旅行。
 * @author Gaoyanbin
 *
 */
class TrainStrategy  implements TravelStrategy{

	@Override
	public void travelAlgorithm() {
		System.out.println("乘坐火车去旅行。");
		
	}
	
}

/**
 * 实现策略的类。代表骑自行车去旅行。
 * @author Gaoyanbin
 *
 */
class BicycleStrategy  implements TravelStrategy{

	@Override
	public void travelAlgorithm() {
		System.out.println("骑自行车去旅行。");
		
	}
	
	
}