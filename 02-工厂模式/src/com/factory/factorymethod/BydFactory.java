package com.factory.factorymethod;

public class BydFactory {

	public static Car createCar(){
		return new Byd();
	}
	
}
