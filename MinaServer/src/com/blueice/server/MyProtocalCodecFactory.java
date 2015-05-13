package com.blueice.server;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolEncoder;


public class MyProtocalCodecFactory implements ProtocolCodecFactory   {

	@Override
	public ProtocolDecoder getDecoder(IoSession arg0) throws Exception {
		return null;
	}

	@Override
	public ProtocolEncoder getEncoder(IoSession arg0) throws Exception {
		return null;
	}

}
