package com.blueice.net.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * 
 * 1.创建服务器端。DatagramSocket类 + 指定端口。
 * 2.准备接收容器。字节数组，封装DatagramPacket类
 * 3.包 接收数据。
 * 4.分析。
 * 5.释放资源。
 * @author gaobin
 *
 */

public class Server {

	public static void main(String[] args) {
		try {
	
			DatagramSocket server = new DatagramSocket(7788);
			byte[] buf  = new byte[1024];
			DatagramPacket packet = new DatagramPacket(buf, buf.length);
			
			System.out.println("servie start................");
			
			while (true) {
				server.receive(packet);

				byte[] data = packet.getData();
				int len = data.length;

				if (len > 0) {
					System.out.println(new String(data));
				} else {
					System.out.println("收到无效数据");
				}
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		

	}

}

