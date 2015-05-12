package com.blueice.net.udp;

import java.awt.List;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.util.ArrayList;



/**
 * UPD网络的客户端。
 * 
 * 1.创建客户端，DatagramSocket类
 * 2.准备数据 字节数组。
 * 3.打包 DatagramSocket+服务器地址和端口。
 * 4.发送。
 * 5.释放资源。
 * 
 */
public class Client {
	public static void main(String[] args) {
		
		try{
			
			String msg = "";
			InetSocketAddress address = new InetSocketAddress("localhost", 9123);
			
			for (int i = 0; i < 100; i++) {
				DatagramSocket client = new DatagramSocket();
				msg = "我是客户端"+i;
				byte[] buf = msg.getBytes();
				DatagramPacket packet = new DatagramPacket(buf, buf.length, address);
				Thread.sleep(10);
				client.send(packet);
				System.out.println("send massage!!!");
				client.close();
			}

			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
