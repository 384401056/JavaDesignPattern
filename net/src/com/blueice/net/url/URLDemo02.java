package com.blueice.net.url;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.net.URL;

public class URLDemo02 {
	
	public static void main(String[] args) {
	
		try {
			
			//1.普通流输出URL指向的资源。
//			URL url = new URL("http://www.baidu.com");
//			
//			InputStream is = url.openStream();//获取url指向的资源输入流。
//
//			byte[] flush = new byte[1024];
//			int len = 0;
//			while(-1!=(len=is.read(flush))){
//				
//				System.out.println(new String(flush, 0, len));
//				
//			}
//			
//			is.close();
			
			
			//2.如果上面输入出的中文是乱码，还可以使用转换流。
//			URL url = new URL("http://www.baidu.com");
//			
//			InputStream is = url.openStream();//获取url指向的资源输入流。
//			BufferedReader br = new BufferedReader(new InputStreamReader(is, "utf-8"));
//			
//			String msg = "";
//			
//			while(null!=(msg=br.readLine())){
//				System.out.println(msg);
//			}
//			
//			br.close();
			
			//3.用文件流输出URL指向的资源。
			URL url = new URL("http://www.baidu.com");
			
			InputStream is = url.openStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is, "utf-8"));
			
			FileOutputStream fis = new FileOutputStream("baidu.html");//新建一个文件输出流。
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fis));
			
			String msg = "";
			while (null != (msg = br.readLine())) {
				bw.append(msg);//将读出的数据写入bw中的,即文件中。
				bw.newLine();
			}
			
			bw.flush();
			bw.close();
			br.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
	}
}
