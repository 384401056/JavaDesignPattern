package com.blueice.net.tcp;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.net.Socket;


import com.google.gson.Gson;

public class Client {

	
	private static Gson gson = new Gson();
	
	public static void main(String[] args) {
		
		
		Signal signal = new Signal();
		signal.setTemperature(23.88);
		signal.setHumidity(56.04);
		
		String str = gson.toJson(signal);
		//{"temperature":23.88,"humidity":56.04}
		try {
			
			Socket client = new Socket("127.0.0.1", 9123);
			BufferedWriter bw  = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			bw.write(str);
			bw.newLine();//使用buferedWriter要加行结束符。
			bw.flush();
			bw.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}