package com.factory.abstractFactory;

public interface CarFactory {

	Engine createEngine();
	Tyre createTyre();
	Seat createSeat();
	
}

class LuxuryCarFactory implements CarFactory{

	@Override
	public Engine createEngine() {
		return new LuxuryEngine();
	}

	@Override
	public Tyre createTyre() {
		return new LuxuryTyre();
	}

	@Override
	public Seat createSeat() {
		return new LuxurySeat();
	}
	
}

class LowyCarFactory implements CarFactory{
	
	@Override
	public Engine createEngine() {
		return new LowEngine();
	}
	
	@Override
	public Tyre createTyre() {
		return new LowTyre();
	}
	
	@Override
	public Seat createSeat() {
		return new LowSeat();
	}
	
}
