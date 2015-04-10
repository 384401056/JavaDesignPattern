package com.clone;
import java.util.Date;

/**
 * 原型类(深克隆)
 */
public class Sheep2 implements Cloneable{
	
	private String name;
	private Date birthDay;
	
	public Sheep2() {
	}

	public Sheep2(String name, Date birthDay) {
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
		
		//添加如下代码，实现深克隆。
		Sheep2 s = (Sheep2) obj;
		s.birthDay = (Date) this.birthDay.clone();
		
		return obj;
	}

}







