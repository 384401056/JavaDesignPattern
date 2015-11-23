package com.blueice.utils;

import org.apache.log4j.Logger;

import com.blueice.bean.Signal;
import com.blueice.server.MyEncoder;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class AnalyzeData {
	
	private static Gson gson = new Gson();
	private static Logger logger = Logger.getLogger(AnalyzeData.class);
	
	public static  Signal jsonToBean (String data) {
		
		Signal signal = new Signal();
		
		try {

			signal = gson.fromJson(data, Signal.class);

		}catch (JsonSyntaxException e){
			logger.error(e.getMessage());
		}

		return signal;
	}

}
