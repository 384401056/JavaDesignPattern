package com.proxy;

public class RealStar implements Star {
	@Override
	public void sing() {
		System.out.println("RealStar(明星本人唱歌).sing()");
	}
}
