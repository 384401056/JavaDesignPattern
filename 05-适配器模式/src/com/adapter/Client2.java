package com.adapter;

/**
 * 适配对象
 *
 */
public class Client2 {

	public int test(Target t){
		return t.handleReq();
	}
	
	/**
	 * 使用组合方式的适配器。
	 */
	public static void main(String[] args) {
		
		Client2 client = new Client2();//适配对象
		
		Adaptee adaptee = new Adaptee();//组合方式的适配器要传入被适配对象。
		
		Target t = new Adapter2(adaptee);//适配器
		
		int i = client.test(t);
		
		System.out.println("sum="+(110+i));
		
	}
	
	
}
