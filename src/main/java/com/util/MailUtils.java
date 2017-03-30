package com.util;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.junit.Test;

public class MailUtils {
	private String host = ""; // smtp服务器

	private String from = ""; // 发件人地址

	private String to = ""; // 收件人地址

	private String user = ""; // 用户名

	private String pwd = ""; // 密码

	private String content = ""; // 邮件标题

	public void setAddress(String from, String to, String content) {
		this.from = from;
		this.to = to;
		this.content = content;
	}

	public void send(String host, String user, String pwd) {
		this.host = host;
		this.user = user;
		this.pwd = pwd;

		Properties props = new Properties();

		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", 587);
		props.put("mail.smtp.auth", "true");

		// 用刚刚设置好的props对象构建一个session
		Session session = Session.getDefaultInstance(props);

		session.setDebug(true);

		// 用session为参数定义消息对象
		MimeMessage message = new MimeMessage(session);
		try {
			// 加载发件人地址
			message.setFrom(new InternetAddress(from));
			// 加载收件人地址
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			// 加载标题
			message.setSubject(content);

			// 向multipart对象中添加邮件的各个部分内容，包括文本内容和附件
			Multipart multipart = new MimeMultipart();

			// 设置邮件的文本内容
			BodyPart contentPart = new MimeBodyPart();
			contentPart.setText("邮件的具体内容在此");
			multipart.addBodyPart(contentPart);

			message.setContent(multipart);
			// 保存邮件
			message.saveChanges();
			// 发送邮件
			Transport transport = session.getTransport("smtp");
			// 连接服务器的邮箱
			transport.connect(host, user, pwd);
			// 把邮件发送出去
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		MailUtils cn = new MailUtils();
		// 设置发件人地址、收件人地址和邮件标题
		cn.setAddress("469432416@qq.com", "nanshouxiao127@163.com", "呵呵呵，我只是测试一下");
		// 设置要发送附件的位置和标题

		/**
		 * 设置smtp服务器以及邮箱的帐号和密码 用QQ 邮箱作为发生者不好使 （原因不明） 163 邮箱可以，但是必须开启 POP3/SMTP服务
		 * 和 IMAP/SMTP服务 因为程序属于第三方登录，所以登录密码必须使用163的授权码
		 */
		// 注意： [授权码和你平时登录的密码是不一样的]
		cn.send("smtp.qq.com", "469432416@qq.com", "hmfxzfrphtgybhih");
		cn.send("smtp.qq.com", "469432416@qq.com", "hmfxzfrphtgybhih");
		// hmfxzfrphtgybhih

	}

	@Test
	public void testSimpleEmail() throws AddressException, MessagingException {
		final String fromMail = "469432416@qq.com";
		String toMail = "nanshouxiao127@163.com";
		String host = "smtp.qq.com";

		Properties prop = new Properties();
		prop.put("mail.smtp.host", host);
		prop.put("mail.smtp.port", 587);
		prop.put("mail.smtp.auth", true);
		// prop.put("mail.user", fromMail);
		// prop.put("mail.password", "hmfxzfrphtgybhih");

		// Session session = Session.getDefaultInstance(prop);
		Session session = Session.getDefaultInstance(prop, new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromMail, "hmfxzfrphtgybhih"); // 发件人邮件用户名、密码
			}
		});

		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress(fromMail));
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(toMail));
		message.setSubject("这个貌似是标题");
		// message.setText("这个应该是正文");
//		message.setContent(
//				"<h1>这是标题</h1><br/><img src=\"http://img06.tooopen.com/images/20170321/tooopen_sy_202648845187.jpg\" />",
//				"text/html");
		addFuJian(message, "C:/Users/feiyu/Desktop/CentOS7-Base.repo", "CentOS7-Base.repo");
		Transport.send(message);
		System.out.println("send mail success");
	}

	private void addFuJian(MimeMessage message, String filePath, String fileName) {
		try {
			// 创建消息部分
			BodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setText("This is message body");
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);

			// 附件部分
			messageBodyPart = new MimeBodyPart();
			DataSource source = new FileDataSource(filePath);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(fileName);
			multipart.addBodyPart(messageBodyPart);
			message.setContent(multipart);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 发送完整消息
	}
}
