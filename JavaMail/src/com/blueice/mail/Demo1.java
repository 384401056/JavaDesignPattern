package com.blueice.mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class Demo1 {
	public static void main(String[] args) {
		try {
			
			//发送邮件前的配置.
			Properties prop = new Properties();
			prop.setProperty("mail.transport.protocol", "smtp");
			prop.setProperty("mail.smtp.host", "smtp.qq.com");
			prop.setProperty("mail.smtp.auth", "true");
			prop.setProperty("mail.debug", "true");
			
			//创建邮件发送的会话。
			Session session = Session.getInstance(prop);
			
			//创建邮件
			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress("384401056@qq.com"));                        //发件人
			msg.setRecipient(RecipientType.TO, new InternetAddress("384401056@qq.com"));  //收件人
			msg.setSubject("您好！这是来自Estore的用户注册激活邮件");       //邮件标题
			msg.setText("请点击如下连接，激活用户。http://localhost/Estore/ActiveServlet?activecode=");//邮件正文。

			//发送邮件
			Transport transport = session.getTransport();
			transport.connect("384401056@qq.com","king1029");
			transport.sendMessage(msg, msg.getAllRecipients());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
