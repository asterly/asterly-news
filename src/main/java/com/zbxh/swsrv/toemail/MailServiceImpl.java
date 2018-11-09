package com.zbxh.swsrv.toemail;

import java.util.Date;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.sun.istack.internal.logging.Logger;

@Service
public class MailServiceImpl {
	@Resource
	private JavaMailSender mailSender;

	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	private MimeMessage mimeMessage;

	public void setMimeMessage(MimeMessage mimeMessage) {
		this.mimeMessage = mimeMessage;
	}

	private static Logger logger = Logger.getLogger(MailServiceImpl.class);

	public void sendAttachMail(MailModel mail) {

		try {
			MimeMessageHelper mailMessage = new MimeMessageHelper(this.mimeMessage, true, "UTF-8");
			mailMessage.setFrom(mail.getFromAddress());// �����ʼ���Ϣ�ķ�����

			mailMessage.setSubject(mail.getSubject());// �����ʼ���Ϣ������
			mailMessage.setSentDate(new Date());// �����ʼ���Ϣ���͵�ʱ��
			mailMessage.setText(mail.getContent(), true); // �����ʼ����ģ�true��ʾ��html�ĸ�ʽ����

			String[] toAddresses = mail.getToAddresses().split(";");// �õ�Ҫ���͵ĵ�ַ����
			for (int i = 0; i < toAddresses.length; i++) {
				mailMessage.setTo(toAddresses[i]);
				/*
				 * for (String fileName : mail.getAttachFileNames()) {
				 * mailMessage.addAttachment(fileName, new File(fileName)); }
				 */
// �����ʼ�
				this.mailSender.send(this.mimeMessage);
				logger.info("send mail ok=" + toAddresses[i]);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	}
}
