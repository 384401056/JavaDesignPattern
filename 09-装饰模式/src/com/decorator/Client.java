package com.decorator;

public class Client {
	public static void main(String[] args) {
		
		AICar superCar = new AICar(new WaterCar(new FlayCar(new Car())));
		
		superCar.run();
	}
}
