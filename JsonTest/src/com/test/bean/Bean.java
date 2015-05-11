package com.test.bean;

import java.util.List;

public class Bean {
	private String name;
	private int age;
	private String addr;
	private List<String> cards;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getCards() {
		
		String res = "";
		
		for(String str:cards){
			res+=str+" ";
		}
		
		return res;
	}
	public void setCards(List<String> cards) {
		this.cards = cards;
	}

}
