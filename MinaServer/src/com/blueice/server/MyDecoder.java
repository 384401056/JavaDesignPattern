package com.blueice.server;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;


import org.apache.log4j.Logger;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.CumulativeProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;

/**
 * 解码
 * @author Gaoyanbin
 *
 */
public class MyDecoder extends CumulativeProtocolDecoder  {

	private static Logger logger = Logger.getLogger(MyEncoder.class);

	@Override
	protected boolean doDecode(IoSession session, IoBuffer in,
			ProtocolDecoderOutput out) throws Exception {
		
		if(in.limit()>=38){
			
			CharsetDecoder decoder = Charset.forName("utf-8").newDecoder();
			String str = in.getString(decoder);
			out.write(str);
			
		}
		return false;
	}

}