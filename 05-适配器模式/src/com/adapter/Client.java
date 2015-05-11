package com.adapter;

/**
 * 适配对象
 *
 */
public class Client {

	public int test(Target t){
		return t.handleReq();
	}
	
	/**
	 * 使用类方式的适配器。
	 */
	public static void main(String[] args) {
		
		Client client = new Client();//适配对象
		
//		Adaptee adaptee = new Adaptee();//被适配对象不需要被new,因为适配器对象继承了它， new适配器就会自动new出被适配对象。
		
		Target t = new Adapter();//适配器
		
		int i = client.test(t);

		System.out.println("sum = "+(110+i));
		
	}
	
	
}
