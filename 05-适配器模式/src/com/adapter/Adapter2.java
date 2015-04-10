package com.adapter;

/**
 * 适配器的实现类。
 * 
 * 通过组和方式来适配被适配对象。(好处：不需要继承被适配对象)
 */
public class Adapter2 implements Target {

	private Adaptee adaptee;
	
	
	public Adapter2(com.adapter.Adaptee adaptee) {
		super();
		this.adaptee = adaptee;
	}


	@Override
	public int handleReq() {
		String str = adaptee.request();//父类(被适配者的方法)
		return Integer.parseInt(str);
	}

}
