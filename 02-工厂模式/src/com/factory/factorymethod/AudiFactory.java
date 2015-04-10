package com.factory.factorymethod;

public class AudiFactory {

	public static Car createCar(){
		return new Audi();
	}
	
}
