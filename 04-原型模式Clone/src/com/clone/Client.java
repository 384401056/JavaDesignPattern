package com.clone;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 测试原型模式（浅克隆）
 * @author Administrator
 *
 */
public class Client {

	public static void main(String[] args) throws CloneNotSupportedException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date(100000000L);
		
		Sheep sheep = new Sheep("少莉", date);
		System.out.println(sheep);
		System.out.println(sheep.getName());
		System.out.println(sdf.format(sheep.getBirthDay()));
		
		Sheep sheepClone = (Sheep) sheep.clone();
		sheepClone.setName("多莉");
		System.out.println(sheepClone);
		System.out.println(sheepClone.getName());
		System.out.println(sdf.format(sheepClone.getBirthDay()));
		
		//将原型对象指向的date对象进行修改后，sheepClone的date也改变了。说明这是浅克隆。
		date.setTime(999999999999L);
		
		System.out.println(sheep);
		System.out.println(sheep.getName());
		System.out.println(sdf.format(sheep.getBirthDay()));
		
		System.out.println(sheepClone);
		System.out.println(sheepClone.getName());
		System.out.println(sdf.format(sheepClone.getBirthDay()));
	}

}
