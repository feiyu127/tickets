package com.util;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class MailUtils
{
    private String host = ""; // smtp服务器
    
    private String from = ""; // 发件人地址
    
    private String to = ""; // 收件人地址
    
    private String affix = ""; // 附件地址
    
    private String affixName = ""; // 附件名称
    
    private String user = ""; // 用户名
    
    private String pwd = ""; // 密码
    
    private String subject = ""; // 邮件标题
    
    public void setAddress(String from, String to, String subject)
    {
        this.from = from;
        this.to = to;
        this.subject = subject;
    }
    
    public void setAffix(String affix, String affixName)
    {
        this.affix = affix;
        this.affixName = affixName;
    }
    
    public void send(String host, String user, String pwd)
    {
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
        try
        {
            // 加载发件人地址
            message.setFrom(new InternetAddress(from));
            // 加载收件人地址
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            // 加载标题
            message.setSubject(subject);
            
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
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args)
    {
        MailUtils cn = new MailUtils();
        // 设置发件人地址、收件人地址和邮件标题
        cn.setAddress("469432416@qq.com","nanshouxiao127@163.com",  "呵呵呵，我只是测试一下");
        // 设置要发送附件的位置和标题
        
        /**
         * 设置smtp服务器以及邮箱的帐号和密码 用QQ 邮箱作为发生者不好使 （原因不明） 163 邮箱可以，但是必须开启 POP3/SMTP服务 和 IMAP/SMTP服务
         * 因为程序属于第三方登录，所以登录密码必须使用163的授权码
         */
        // 注意： [授权码和你平时登录的密码是不一样的]
        cn.send("smtp.qq.com", "469432416@qq.com", "hmfxzfrphtgybhih");
        cn.send("smtp.qq.com", "469432416@qq.com", "hmfxzfrphtgybhih");
        //hmfxzfrphtgybhih
        
    }
}
