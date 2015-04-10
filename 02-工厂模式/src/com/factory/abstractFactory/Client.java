package com.factory.abstractFactory;

public class Client {
	public static void main(String[] args) {
		
		CarFactory factory = new LuxuryCarFactory();
		Engine e1 = factory.createEngine();
		Tyre t1 = factory.createTyre();
		Seat s1 = factory.createSeat();
		
		e1.run();
		t1.resovle();
		s1.massage();
	}
}
