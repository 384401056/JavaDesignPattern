package com.blueice.server;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolEncoder;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;


public class MyProtocalCodecFactory implements ProtocolCodecFactory   {

	private ProtocolEncoder encoder;  
    private ProtocolDecoder decoder;  
	
	@Override
	public ProtocolDecoder getDecoder(IoSession arg0) throws Exception {
		return new MyDecoder();
	}
		
	@Override
	public ProtocolEncoder getEncoder(IoSession arg0) throws Exception {
		return new MyEncoder();
	}

}
