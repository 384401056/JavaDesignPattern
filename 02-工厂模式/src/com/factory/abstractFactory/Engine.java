package com.factory.abstractFactory;

public interface Engine {

	void run();
	void star();
	
}

class LuxuryEngine implements Engine{

	@Override
	public void run() {
		System.out.println("高端引擎.");
	}

	@Override
	public void star() {
		System.err.println("自动启停.");
		
	}
	
}

class LowEngine implements Engine{

	@Override
	public void run() {
		System.out.println("低端引擎.");
		
	}

	@Override
	public void star() {
		System.err.println("不带自动启停.");
		
	}
	
}
