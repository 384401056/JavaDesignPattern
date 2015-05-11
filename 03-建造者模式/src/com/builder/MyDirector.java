package com.builder;

public class MyDirector implements AirshipDirector {

	private AirshipBuilder builder;
	
	
	public MyDirector(AirshipBuilder builder) {
		this.builder = builder;
	}

	@Override
	public Airship directorAirShip() {
		
		Airship ship = new Airship();
		ship.setEngine(builder.builderEngine());
		ship.setOrbitalModule(builder.builderOrbitalModule());
		ship.setEscapeTower(builder.builderEscapeTower());

		return ship;
	}

}
