package com.blueice.net.ip;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

public class InetSocketDemo01 {

	public static void main(String[] args) {

		try {
			InetAddress addr = InetAddress.getLocalHost();//获取本机的地址信息。

			InetSocketAddress inetSocket = new InetSocketAddress(addr,9999);
//			InetSocketAddress inetSocket = new InetSocketAddress("Blueice", 9999); //另一种构造。
			System.out.println(inetSocket.getAddress());
			System.out.println(inetSocket.getHostName()); //主机名
			System.out.println(inetSocket.getPort()); //端口

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

	}

}
