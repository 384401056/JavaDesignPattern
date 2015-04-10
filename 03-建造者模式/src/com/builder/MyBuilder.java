package com.builder;

/*
 * 构造者的实现类。构造出飞船的所有零件。
 * 
 */
public class MyBuilder implements AirshipBuilder {

	@Override
	public OrbitalModule builderOrbitalModule() {
		OrbitalModule orbitalModule = new OrbitalModule("轨道仓");
		return orbitalModule;
	}

	@Override
	public Engine builderEngine() {
		Engine engine = new Engine("引擎");
		return engine;
	}

	@Override
	public EscapeTower builderEscapeTower() {
		EscapeTower escapeTower = new EscapeTower("逃逸塔");
		return escapeTower;
		
	}

}
