package com.blueice.net.url;

import java.net.MalformedURLException;
import java.net.URL;

public class URLDemo01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			
			
			URL url = new URL("http://www.qq.com:8080");//绝对路径的构造。必须是一个完整的URL格式。（包括协议）.
			URL url2 = new URL(url, "soft/index.html?name=李明&age=20");//相对路径的构造.
			
			System.out.println(url.toString());
			System.out.println(url2.toString());
			
			
			System.out.println("协议:"+url2.getProtocol());//使用的协议.
			System.out.println("域名:"+url2.getHost());//域名.
			System.out.println("端口:"+url2.getPort());//端口.
			System.out.println("资源:"+url2.getFile());//资源文件
			System.out.println("相对路径:"+url2.getPath());//相对路径
			System.out.println("参数:"+url2.getQuery());//参数,注意：如果url上有锚点(#)，则参数会返回null
			
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		

	}

}
