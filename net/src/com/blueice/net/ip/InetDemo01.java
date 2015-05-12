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
			System.out.println(address.getHostAddress());//��ȡ����ip��ַ��
			System.out.println(address.getHostName()); //��ȡ�������������
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		
		

	}

}
