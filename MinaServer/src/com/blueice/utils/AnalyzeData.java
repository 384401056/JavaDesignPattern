package com.blueice.utils;

import com.blueice.bean.Signal;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class AnalyzeData {
	
	private static Gson gson = new Gson();
	
	
	public static  Signal jsonToBean (String data) {
		
		Signal signal = new Signal();
		
		try {

			signal = gson.fromJson(data, Signal.class);

		}catch (JsonSyntaxException e){
			e.printStackTrace();
		}

		return signal;
	}

}
