package com.test.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.test.bean.Bean;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 *  普通类型、List、Collection等都是用JSONArray解析
 *  
 *  Map、自定义类型是用JSONObject解析
 *  可以将Map理解成一个对象，里面的key/value对可以理解成对象的属性/属性值
 *  即{key1:value1,key2,value2......}
 * 
 * 1.JSONObject是一个name:values集合，通过它的get(key)方法取得的是key后对应的value部分(字符串)
 *         通过它的getJSONObject(key)可以取到一个JSONObject，--> 转换成map,
 *         通过它的getJSONArray(key) 可以取到一个JSONArray ，
 * 
 * 
 */
public class ToJson {

	public static void main(String[] args) {
		
//		baseToJson();
//		System.out.println("-----------------------------------");
//		baseArrayToJson();
//		System.out.println("-----------------------------------");
//		setToJson();
//		mapToJson();
		beanToJson();
	}
	
	/**
	 * 基本数据类型转Json
	 */
	public static void baseToJson(){
		
		int i = 100;
		JSONArray jsonArray = JSONArray.fromObject(i);
		System.out.println(jsonArray);
		
		String s = "['Java Json']";
		JSONArray jsonArray2 = JSONArray.fromObject(s);
		System.out.println(jsonArray2);
		
		double d = 3.1415926;
		JSONArray jsonArray3 = JSONArray.fromObject(d);
		System.out.println(jsonArray3);
		
		boolean b = true;
		JSONArray jsonArray4 = JSONArray.fromObject(b);
		System.out.println(jsonArray4);
		
	}
	
	/**
	 * 一般数组转换成JSON
	 */
	public static void baseArrayToJson(){
		 boolean[] boolArray = new boolean[]{true,false,true};  
	     JSONArray jsonArray1 = JSONArray.fromObject( boolArray );  
	     System.out.println( jsonArray1 );  
	     
	     byte[] buf = new byte[]{1,2,3,4,5,6,7,8,9,10};
	     JSONArray jsonArray2 = JSONArray.fromObject( buf );  
	     System.out.println( jsonArray2 );  
	     
	     int[] ints = new int[]{10,20,30,40,50,60,70,80,90,100};
	     JSONArray jsonArray3 = JSONArray.fromObject(ints);
	     System.out.println(jsonArray3);
	     
	     Double[] doubles = new Double[]{10.34,20.33,30.78,40.45,50.3432,60.6432,70.1246,80.4522,90.0001,100.89001};
	     JSONArray jsonArray4 = JSONArray.fromObject(doubles);
	     System.out.println(jsonArray4);
	     
	     String[] strings = new String[]{"a","b","c","d"};
	     JSONArray jsonArray5 = JSONArray.fromObject(strings);
	     System.out.println(jsonArray5);
	}
	
	/**
	 * List、Collection等都是用JSONArray解析
	 */
	public static void setToJson(){
		
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("a");
		list.add("a");
		list.add("a");
		JSONArray jsonArray = JSONArray.fromObject(list);
		System.out.println(jsonArray);
	}
	
	
	public static void mapToJson(){
		
		Map<String, Object> map = new HashMap<String, Object>(); 
		map.put("name", "李明");
		map.put("age", new Integer(20));
		map.put("addr", "云南省昆明市");
		map.put("bool", new Boolean(true));
		map.put("array", new String[]{"K","L","M"});
		
		JSONObject jsonObject = JSONObject.fromObject(map);
		System.out.println(jsonObject);
		
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

		JSONObject jsonObject = JSONObject.fromObject(bean);
		System.out.println(jsonObject);
		
	}
	
}


























