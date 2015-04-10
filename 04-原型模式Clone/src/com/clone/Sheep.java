package com.clone;
import java.util.Date;

/**
 * 原型类(浅克隆)
 * 
 * 用于克隆的原型类要实现Cloneable接口。
 * 并重写父类中的clone()方法。
 *
 */
public class Sheep implements Cloneable{
	
	private String name;
	private Date birthDay;
	
	public Sheep() {
	}

	public Sheep(String name, Date birthDay) {
		super();
		this.name = name;
		this.birthDay = birthDay;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
	
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Object obj = super.clone();
		return obj;
	}

}







