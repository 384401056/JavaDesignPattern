package com.blueice.net.ip;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetDemo01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			InetAddress address = InetAddress.getLocalHost();
			System.out.println(address.getHostAddress());//获取本机ip地址。
			System.out.println(address.getHostName()); //获取本机计算机名。
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		
		

	}

}
