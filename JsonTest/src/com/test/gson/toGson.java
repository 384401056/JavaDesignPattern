package com.test.gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.test.bean.Bean;

/**
 * 使用Gson来生成json数据
 * @author Gaoyanbin
 *
 */
public class toGson {

	private static Gson gson = new Gson();
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		beanToJson();
	}
	
	
	/**
	 * 基本数据类型转Json
	 */
	public static void baseToJson(){
		
		int i = 100;
		String iJson = gson.toJson(i);
		System.out.println("i = "+iJson); 
		
		int ii = gson.fromJson(iJson, new TypeToken<Integer>(){}.getType());
		System.out.println("ii = "+(ii+2));
		
	}
	
	/**
	 * 一般数组转换成JSON
	 */
	public static void baseArrayToJson(){
		
		boolean[] boolArray = new boolean[] { true, false, true };
		String bJson = gson.toJson(boolArray);
		System.out.println(bJson);

		byte[] buf = new byte[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		String bufJson = gson.toJson(buf);
		System.out.println(bufJson);

		int[] ints = new int[] { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 };

		Double[] doubles = new Double[] { 10.34, 20.33, 30.78, 40.45, 50.3432,
				60.6432, 70.1246, 80.4522, 90.0001, 100.89001 };
		String dJson = gson.toJson(doubles);
		System.out.println(dJson);
		
		String[] strings = new String[] { "a", "b", "c", "d" };
		String sJson = gson.toJson(strings);
		System.out.println(sJson);

	}
	

	public static void setToJson(){
		
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("a");
		list.add("a");
		list.add("a");
		
		String listJson = gson.toJson(list);
		System.out.println(listJson);
	}
	
	
	public static void mapToJson(){
		
		Map<String, Object> map = new HashMap<String, Object>(); 
		map.put("name", "李明");
		map.put("age", new Integer(20));
		map.put("addr", "云南省昆明市");
		map.put("bool", new Boolean(true));
		map.put("array", new String[]{"K","L","M"});
		
		String mapJson = gson.toJson(map);
		System.out.println(mapJson);
		
	}
	
	/**
	 * bean转换为Json格式输出。其中bean必须为public.
	 */
	public static void beanToJson(){
		
		Bean bean = new Bean();//
		
		List<String> cards = new ArrayList<String>();
		cards.add("建行"); 
		cards.add("农行"); 
		cards.add("工行"); 
		
		bean.setName("李明");
		bean.setAge(20);
		bean.setAddr("云南省昆明市");
		bean.setCards(cards);
		
		String beanJson = gson.toJson(bean);
		System.out.println(beanJson);
		
		
		Bean bean2 = gson.fromJson(beanJson, Bean.class);
		System.out.println(bean2.getName());
		System.out.println(bean2.getAge()+"");
		System.out.println(bean2.getAddr());
		System.out.println(bean2.getCards());
		
		
		
		
	}

}

















