package com.factory.abstractFactory;

public interface Tyre {

	void resovle();
	
}

class LuxuryTyre implements Tyre{

	@Override
	public void resovle() {
		System.out.println("高端轮胎");
	}
	
	
}

class LowTyre implements Tyre{

	@Override
	public void resovle() {
		System.out.println("低端轮胎");
	}
	
	
}
