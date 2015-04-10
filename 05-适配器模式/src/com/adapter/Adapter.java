package com.adapter;

/**
 * 适配器的实现类。
 * 
 * 通过类方式来适配被适配对象。
 */
public class Adapter extends Adaptee implements Target {

	@Override
	public int handleReq() {
		String str = super.request();//父类(被适配者的方法)
		return Integer.parseInt(str);
	}

}
