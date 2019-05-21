package com.shdic.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.Properties;
import java.util.logging.Level;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import com.itextpdf.text.DocumentException;
import com.shdic.bean.OrderDetailBean;
import com.shdic.bean.SlotBean;
import com.sun.mail.util.MailSSLSocketFactory;

public class SendingEmail {
	
	public static final String spectator = File.separator;

	   
	 public boolean sendEmailWithRcepit(OrderDetailBean orderDetail) 
			 throws GeneralSecurityException, MessagingException, UnsupportedEncodingException, FileNotFoundException, DocumentException{	 
		 if (orderDetail ==null){
			 System.out.println("order detail is null");
			 return false;
		 }
		 
		 CreatePdf createPdf =new CreatePdf();
		 System.out.println("createpdf is null?"+createPdf.equals(null));
		 if(!createPdf.createRecepitPDF(orderDetail)){
			 System.out.println("create recepit pdf fails");
			 return false;
		 }
		 //System.out.println("sendemail parking_id-> "+orderDetail.getParking_id());
		 
		 //set parameters used in path of PDF
		 String recepit_no = orderDetail.getRecepit_no();
		 //精准换行 
		 Properties pp = System.getProperties();
		 String newLine = pp.getProperty("line.separator");
		 //pdf文件路径
		 //String filename = "./Receipt/"+recepit_no+".pdf";  
		 //testing
		 //String filename = "/Receipt/"+"10239920"+".pdf"; 
		 //String filename = ".\\Receipt\\"+"10239920"+".pdf"; 
		 //String filename = "I:\\Receipt\\"+"10239920"+".pdf"; 
		 //String filename = "C:"+spectator+"Receipt"+spectator+"10239920"+".pdf"; 
		 String filename = "C:"+spectator+"Receipt"+spectator+recepit_no+".pdf"; 
         //跟smtp服务器建立一个连接
			String smtpServer = "smtp.163.com";
			String smtpPort = "465";
		    String account = "kaertiger@163.com";
		    String pwd = "Karl163.com";
			String receiver = "413491539@qq.com";  //472936632  413491539
        Properties p = new Properties();
        // 开启debug调试，以便在控制台查看
        p.setProperty("mail.debug", "true");
        p.setProperty("mail.host", smtpServer);//指定邮件服务器，默认端口 25
        p.setProperty("mail.smtp.port", smtpPort); //设定端口
        p.setProperty("mail.smtp.auth", "true");//要采用指定用户名密码的方式去认证
        // 发送邮件协议名称
        p.setProperty("mail.transport.protocol", "smtp");

        // 开启SSL加密，否则会失败
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        p.put("mail.smtp.ssl.enable", "true");
        p.put("mail.smtp.ssl.socketFactory", sf);

        // 创建session
        Session session = Session.getInstance(p);

        // 通过session得到transport对象
        Transport ts = session.getTransport();

        // 连接邮件服务器：邮箱类型，帐号，授权码代替密码（更安全）
        ts.connect(smtpServer, account, pwd);
        // 后面的字符是授权码，不能用qq密码

        //声明一个Message对象(代表一封邮件),从session中创建
        MimeMessage msg = new MimeMessage(session);
        //邮件信息封装
        //1发件人
        msg.setFrom( new InternetAddress(account) );
        //2收件人
        msg.setRecipient(RecipientType.TO, new InternetAddress(receiver) );
        //3邮件内容:主题、内容
        msg.setSubject("Order Receipt : "+orderDetail.getRecepit_no());

        //添加附件部分
        //邮件内容部分1---文本内容
        MimeBodyPart body0 = new MimeBodyPart(); //邮件中的文字部分
        body0.setContent("Hi.dear customer:"+newLine+",Here is your receipt","text/html;charset=utf-8");

        //邮件内容部分2---附件1
        MimeBodyPart body1 = new MimeBodyPart(); //附件1
        DataHandler hand = new DataHandler( new FileDataSource(filename));
        System.out.println("hand is null?"+hand.equals(null));
        body1.setDataHandler( new DataHandler( new FileDataSource(filename)) );//./代表项目根目录下
        
        body1.setFileName( MimeUtility.encodeText("receipt.pdf") );//中文附件名，解决乱码
        System.out.println("body0 is null?"+body0.equals(null));
        System.out.println("body1 is null?"+body1.equals(null));
        
        //把上面的3部分组装在一起，设置到msg中
        MimeMultipart mm = new MimeMultipart();
        mm.addBodyPart(body0);
        mm.addBodyPart(body1);
        msg.setContent(mm);
        System.out.println("mm is null?"+mm.equals(null));
        System.out.println("msg is null?"+msg.equals(null));
        
        System.out.println("ts is null?"+ts.equals(null));
        // 发送邮件  //nullpoint error caused by mail jar conflict!
        ts.sendMessage(msg,msg.getAllRecipients());
        
        ts.close();
		return true;
	 }

}
