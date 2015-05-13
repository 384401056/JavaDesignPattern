package com.blueice.server;

import org.apache.log4j.Logger;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoder;
import org.apache.mina.filter.codec.ProtocolEncoderAdapter;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;

/**
 * 编码
 * @author Gaoyanbin
 *
 */
public class MylEncoder implements ProtocolEncoder{
	
	private static Logger logger = Logger.getLogger(MylEncoder.class);

	@Override
	public void encode(IoSession session, Object message,ProtocolEncoderOutput out) throws Exception {
		
		logger.info(message);
	}

	@Override
	public void dispose(IoSession session) throws Exception {
		// TODO Auto-generated method stub
		
	}
	

}
