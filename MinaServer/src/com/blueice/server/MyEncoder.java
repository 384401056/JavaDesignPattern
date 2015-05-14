package com.blueice.server;

import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

import org.apache.log4j.Logger;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoder;
import org.apache.mina.filter.codec.ProtocolEncoderAdapter;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;

/**
 * 编码
 * 服务器端编码无需处理，直接将接收到的数据向下传递 
 * @author Gaoyanbin
 *
 */
public class MyEncoder implements ProtocolEncoder{
	
	private static Logger logger = Logger.getLogger(MyEncoder.class);
	private static Charset charset = Charset.forName("UTF-8");
	
	@Override
	public void encode(IoSession session, Object message,ProtocolEncoderOutput out) throws Exception {
		
		IoBuffer buf = IoBuffer.allocate(100).setAutoExpand(true);
		CharsetEncoder ce = charset.newEncoder();
        buf.putString(message+"\n",ce);  //将String转为IoBuffer。
        buf.flip();
        out.write(buf);
	}

	@Override
	public void dispose(IoSession session) throws Exception {
		
	}
	

}
