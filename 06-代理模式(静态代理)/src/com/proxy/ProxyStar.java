package com.proxy;

public class ProxyStar implements Star {

	private Star realStar;
	
	public ProxyStar(Star realStar) {
		super();
		this.realStar = realStar;
	}

	public void confer() {
		System.out.println("ProxyStar.confer()");

	}

	public void signContract() {
		System.out.println("ProxyStar.signContract()");
	}

	public void bookTicket() {
		System.out.println("ProxyStar.bookTicket()");
	}


	public void sing() {
		this.confer();
		this.signContract();
		this.bookTicket();
		realStar.sing();
		this.collectMoney();
	}

	public void collectMoney() {
		System.out.println("ProxyStar.collectMoney()");
	}

}
