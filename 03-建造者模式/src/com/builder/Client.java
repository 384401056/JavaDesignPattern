package com.builder;

import javax.print.attribute.standard.Sides;

public class Client {

	public static void main(String[] args) {
		
		AirshipDirector director = new MyDirector(new MyBuilder());
		Airship ship = director.directorAirShip();
		
		System.out.println(ship);
		System.out.println(ship.getEngine().getName());
		System.out.println(ship.getOrbitalModule().getName());
		System.out.println(ship.getEscapeTower().getName());
		
	}

}
