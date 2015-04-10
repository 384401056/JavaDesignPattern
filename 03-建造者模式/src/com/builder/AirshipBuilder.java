package com.builder;


/**
 * 构造者类 
 */
public interface AirshipBuilder {

	public OrbitalModule builderOrbitalModule();
	public Engine builderEngine();
	public EscapeTower builderEscapeTower();
	
}
