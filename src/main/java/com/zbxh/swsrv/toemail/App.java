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
//    		   "�ʼ����Ͳ���", 
//    		   "<h1>����һ������ʼ��������</h1>");
//        
//    }
	
	public static void main( String[] args )
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext("spring-mail.xml");
    	 
    	MailMail mm = (MailMail) context.getBean("mailMail");
        mm.sendMail("akun", "This is text content");
        
    }
}
