package com.blueice.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LogLevel;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;


public class MinaTimeServer {

	
	private static final int PORT = 9123;

	private static Logger logger = Logger.getLogger(MinaTimeServer.class);
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		PropertyConfigurator.configure("log4j.properties");

		IoAcceptor acceptor = new NioSocketAcceptor();
		
		//这个过滤器用来记录所有的信息，比如创建session(会话)，接收消息，发送消息，关闭会话等

		LoggingFilter logFilter = new LoggingFilter();
		
		ProtocolCodecFactory factory = new TextLineCodecFactory(Charset.forName( "UTF-8" ));
		/**
		 * (协议编解码过滤器).这个过滤器用来转换二进制或协议的专用数据到消息对象中.
		 * 我们这里使用一个已经存在的TextLine工厂，因为我们这里只处理一些文字消息（你不需要再去写编解码部分）。
		 */
		ProtocolCodecFilter proFilter = new ProtocolCodecFilter(factory);
	
		//添加几个过滤器
		acceptor.getFilterChain().addLast("logger", logFilter);
		acceptor.getFilterChain().addLast("codec", proFilter);
		
		logFilter.setSessionClosedLogLevel(LogLevel.NONE);  
		logFilter.setSessionCreatedLogLevel(LogLevel.DEBUG);  
		logFilter.setSessionOpenedLogLevel(LogLevel.INFO);  
		
		/**
		 * 接下来我们需要创建一个handler来实时处理客户端的连接和请求，这个handler 类必须实现 IoHandler这个接口。
		 * 对于所有使用MINA的程序来说，主要的负荷都在这个文件，它为所有客户端请求提供服务。
		 */
		acceptor.setHandler(new TimeServerHandler());
		
		/**
		 * 添加一些NioSocketAcceptor 配置，这将允许我们设置特殊的socket设置来接收客户端的连接。
		 */
		acceptor.getSessionConfig().setReadBufferSize(1024);//指定缓冲区大小来告诉底层操作系统为传入的数据分配多少的空间
        acceptor.getSessionConfig().setIdleTime( IdleStatus.BOTH_IDLE, 10 );//指定多少时间没有读写操作就进入空闲状态。
        

        /**
         * 剩下要做的就是定义套接字地址，该服务器将侦听，实际接入时才会启动服务。
         */
        try {
			InetSocketAddress inetSocketAddress = new InetSocketAddress(PORT);
			acceptor.bind( inetSocketAddress );
			
			logger.info("Server started on port " + PORT);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
        
	}

}


















