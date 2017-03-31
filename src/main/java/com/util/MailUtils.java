package com.util;

import java.util.Collections;
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

public class MailUtils
{
    
    private static final String username = "469432416@qq.com";
    
    private static final String nickName = "飞羽";
    
    private static final String password = "hmfxzfrphtgybhih";
    
    private static final String host = "smtp.qq.com";
    
    private static final int port = 587;
    
    public static Session getSession()
    {
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.qq.com");
        prop.put("mail.smtp.port", 587);
        prop.put("mail.smtp.auth", true);
        Session session = Session.getDefaultInstance(prop, new Authenticator()
        {
            public PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication(username, password); // 发件人邮件用户名、密码
            }
        });
        return session;
    }
    
    @Test
    public void testSimpleEmail()
    {
        String fromMail = "469432416@qq.com";
        String[] toMails = {"1119290647@qq.com"};
        testSimpleEmail(fromMail, toMails);
    }
    
    public void send()
    {
        
        Properties props = new Properties();
        
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", 587);
        props.put("mail.smtp.auth", "true");
        
        // 用刚刚设置好的props对象构建一个session
        Session session = Session.getDefaultInstance(props);
        
        session.setDebug(true);
        
        // 用session为参数定义消息对象
        MimeMessage message = new MimeMessage(session);
        try
        {
            // 加载发件人地址
            message.setFrom(new InternetAddress(username));
            // 加载收件人地址
            message.addRecipient(Message.RecipientType.TO, new InternetAddress("nanshouxiao127@163.com"));
            // 加载标题
            message.setSubject("标题");
            
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
            transport.connect(host, username, password);
            // 把邮件发送出去
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public void test2() throws Exception {
        final String fromMail = "469432416@qq.com";
        final String toMail = "1119290647@qq.com";
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
    public static void main(String[] args) throws Exception
    {
        MailUtils cn = new MailUtils();
        // 设置发件人地址、收件人地址和邮件标题
       cn.test2();
        // hmfxzfrphtgybhih
        
    }
    
    public void testSimpleEmail(String fromMail, String[] toMails)
    {
        Session session = getSession();
        session.setDebug(true);
        MimeMessage message = new MimeMessage(session);
        try
        {
            message.setFrom(new InternetAddress(fromMail, nickName));
            message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(StringUtils.join(toMails, ";")));
            message.setSubject("两个图片附件");
            
            Multipart multipart = new MimeMultipart();
            
            // 创建消息部分
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent("这是两个图片附件啊<img src=\"http://img06.tooopen.com/images/20170321/tooopen_sy_202648845187.jpg\" />", "text/html;charset=utf-8");
            multipart.addBodyPart(messageBodyPart);
             addFiles(multipart, "C:/Users/Administrator/Desktop/testTelnet.bat");
            message.setContent(multipart);
            message.saveChanges();
            Transport.send(message);
        }
        catch (Exception e)
        {
            // TODO: handle exception
        }
        System.out.println("send mail success");
    }
    
    private void addFiles(Multipart multipart, String... files)
    {
        if (files == null || files.length == 0)
        {
            return;
        }
        BodyPart messageBodyPart;
        try
        {
            for (String file : files)
            {
                messageBodyPart = new MimeBodyPart();
                DataSource source = new FileDataSource(file);
                messageBodyPart.setDataHandler(new DataHandler(source));
                messageBodyPart.setFileName(source.getName());
                multipart.addBodyPart(messageBodyPart);
                
            }
        }
        catch (MessagingException e)
        {
            e.printStackTrace();
        }
    }
}
