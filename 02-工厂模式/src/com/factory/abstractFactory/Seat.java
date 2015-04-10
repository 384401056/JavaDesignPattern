package com.factory.abstractFactory;

public interface Seat {

	void massage();
}

class LuxurySeat implements Seat{

	@Override
	public void massage() {
		System.out.println("真皮坐椅。");
	}
	
}

class LowSeat implements Seat{
	
	@Override
	public void massage() {
		System.out.println("人造革坐椅。");
	}
	
}