package com.zbxh.swsrv.toemail;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App {
	
//    public static void main( String[] args ){
//    	ApplicationContext context = 
//             new ClassPathXmlApplicationContext("spring-mail.xml");
//    	 
//    	MailMail mm = (MailMail) context.getBean("mailMail");
//        mm.sendMail("asterly@aliyun.com",
//    		   "1321195508@qq.com",
//    		   "邮件推送测试", 
//    		   "<h1>这是一封测试邮件，请忽略</h1>");
//        
//    }
	
	public static void main( String[] args )
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext("spring-mail.xml");
    	 
    	MailMail mm = (MailMail) context.getBean("mailMail");
        mm.sendMail("akun", "This is text content");
        
    }
}
