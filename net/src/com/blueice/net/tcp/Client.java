package com.blueice.net.tcp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import com.blueice.net.utils.DES;
import com.google.gson.Gson;

public class Client {

	
	private static Gson gson = new Gson();
	
	public static void main(String[] args) {
		
		Signal signal = new Signal();
		signal.setTemperature(100.88);
		signal.setHumidity(500.04);
		
		String str = "getall-"+ Client.addEmptyString(43);
//		String str = "send-"+gson.toJson(signal);
		//send-{"temperature":23.88,"humidity":56.04}
		try {
			
			Socket client = new Socket("127.0.0.1", 9123);
			BufferedWriter bw  = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			
			bw.write(str);
			bw.newLine();//使用buferedWriter要加行结束符。
			bw.flush();

			//读取服务器的返回值。
			BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
			String res = br.readLine();
			DES des = new DES();
			System.out.println(des.authcode(res, "DECODE", "9b2648fcdfbad80f"));
			bw.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	/**
	 * 加入空字符
	 * @param num
	 * @return
	 */
	private static String addEmptyString(int num){
		
		byte[] bytes = new byte[num];
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<bytes.length;i++){
			sb.append((Byte)bytes[i]);
		}
		
		return sb.toString();
	}
	
}



















