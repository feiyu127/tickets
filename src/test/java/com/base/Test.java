package com.base;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.util.MailUtils;

public class Test {
	public void test2() throws Exception {
		final String fromMail = "469432416@qq.com";
		String toMail = "nanshouxiao127@163.com";
		String host = "smtp.qq.com";

		Properties prop = new Properties();
		prop.put("mail.smtp.host", host);
		prop.put("mail.smtp.port", 587);
		prop.put("mail.smtp.auth", true);
		Session session = Session.getDefaultInstance(prop, new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromMail, "hmfxzfrphtgybhih"); // 发件人邮件用户名、密码
			}
		});

		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress(fromMail));
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(toMail));
		message.setSubject("这个貌似是标题");
		message.setContent(
				"<h1>这是标题</h1><br/><img src=\"http://img06.tooopen.com/images/20170321/tooopen_sy_202648845187.jpg\" />",
				"text/html");
		Transport.send(message);
		System.out.println("send mail success");
	}

	public static void main(String[] args) throws Exception {
		Test cn = new Test();
		// 设置发件人地址、收件人地址和邮件标题
		cn.test2();
		// hmfxzfrphtgybhih

	}
}
