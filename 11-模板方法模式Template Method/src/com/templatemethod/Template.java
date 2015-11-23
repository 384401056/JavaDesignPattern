package com.templatemethod;

/**
 * 模板类。
 * @author Gaoyanbin
 *
 */
public abstract class Template {

	public void method(){
		this.Primitive1();
		this.Primitive1();
	}
	
	protected abstract void Primitive1();
	protected abstract void Primitive2();
	
}
