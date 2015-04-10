package com.factory.simplefactory;

public class CarFactory {

	public static Car createCar(String type) {
		if ("audi".equals(type)) {
			return new Audi();
		} else if ("byd".equals(type)) {
			return new Byd();
		} else {
			return null;
		}
	}
	
	public static Car createAudi(){
		return new Audi();
	}

	public static Car createByd(){
		return new Byd();
	}
}
