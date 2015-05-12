package com.blueice.net.ip;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

public class InetSocketDemo01 {

	public static void main(String[] args) {

		try {
			InetAddress addr = InetAddress.getLocalHost();//��ȡ�����ĵ�ַ��Ϣ��

			InetSocketAddress inetSocket = new InetSocketAddress(addr,9999);
//			InetSocketAddress inetSocket = new InetSocketAddress("Blueice", 9999); //��һ�ֹ��졣
			System.out.println(inetSocket.getAddress());
			System.out.println(inetSocket.getHostName()); //������
			System.out.println(inetSocket.getPort()); //�˿�

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

	}

}
