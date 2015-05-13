package com.blueice.server;

import java.sql.SQLException;
import java.util.Date;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.log4j.Logger;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

import com.blueice.bean.Signal;
import com.google.gson.Gson;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class TimeServerHandler extends IoHandlerAdapter {

	
	private static Gson gson = new Gson();
	
	private static Logger logger = Logger.getLogger(TimeServerHandler.class);
	/**
	 * exceptionCaught 应该总是在handler 中定义，来处理一些异常情况，否则异常信息将无法捕捉。
	 * exceptionCaught 方法简单地打印了错误的堆栈跟踪和关闭会话。对于大多数程序，这将是标准的做法，除非处理程序可以从异常状态中恢复。
	 */
	@Override
	public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
		cause.printStackTrace();
	}

	/**
	 * 当接收到客户端的请求信息后触发此方法.
	 * messageReceived 方法来处理从客户端接收到的数据，这里是将当前时间返回给客户端，当收到quit时，会话将被关闭，也会返回一个当前时间给客户端。
	 * 根据所使用的协议编解码器，object 这个参数传递的类型有所不同，以及返回的数据时的session.write(Object) 也不同。如果不指定协议的编解码器，
	 * 你将收到一个类型为IoBuffer 的对象，返回的数据也要求是IoBuffer。
	 */
	@Override
	public void messageReceived(IoSession session, Object message)
			throws Exception {
		
		String str = message.toString();
		
		if (str.trim().equalsIgnoreCase("quit")) {
			session.close(true);
			return;
		}

//		logger.debug("Rec:" + str);
		
//		SignalDaoImp dao = new SignalDaoImp();
//		Signal signal = AnalyzeData.jsonToBean(str);
//		if(signal!=null){
//			saveDate(signal);
//			System.out.println("Save...");
//		}else{
//			System.out.println("Erro...");
//		}

		
		Date date = new Date();
		session.write(date.toString());//向客户端写入数据。
		logger.info(date.toString());
	}

	private void saveDate(Signal signal) {
		String sql = "INSERT INTO tb_signal VALUES(?,?)";
		try {
			ComboPooledDataSource source = new ComboPooledDataSource();
			QueryRunner runner = new QueryRunner(source);
			runner.update(sql,signal.getTemperature(),signal.getHumidity());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 当连接空闲时触发此方法.
	 * sessionIdle 方法将定时调用一次会话，保持空闲状态。
	 * 通过调用acceptor.getSessionConfig().setIdleTime( IdleStatus.BOTH_IDLE, 10 );来设定时间间隔。
	 */
	@Override
	public void sessionIdle(IoSession session, IdleStatus status)
			throws Exception {
	}

	/**
	 *   当信息已经传送给客户端后触发此方法.
	 */
	@Override
	public void messageSent(IoSession session, Object message) throws Exception {
		// TODO Auto-generated method stub
		super.messageSent(session, message);
	}

	/**
	 * 当连接被关闭时触发，例如客户端程序意外退出等等.
	 */
	@Override
	public void sessionClosed(IoSession session) throws Exception {
		// TODO Auto-generated method stub
		super.sessionClosed(session);
	}

	/**
	 * 当一个新客户端连接后触发此方法.
	 */
	@Override
	public void sessionCreated(IoSession session) throws Exception {
		// TODO Auto-generated method stub
		super.sessionCreated(session);
	}

	/**
	 * 当连接后打开时触发此方法，一般此方法与 sessionCreated 会被同时触发
	 */
	@Override
	public void sessionOpened(IoSession session) throws Exception {
		// TODO Auto-generated method stub
		super.sessionOpened(session);
	}
	
	
	
	
	

}
