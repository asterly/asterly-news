package com.zbxh.swsrv.toemail;

public class MailModel {
	private String fromAddress;// �����˵�ַ1��
	private String toAddresses;// �����˵�ַ,����Ϊ�ܶ����ÿ����ַ֮����";"�ָ����ȷ�˵450065208@qq.com;lpf@sina.com
	private String subject;// �ʼ�����
	private String content;// �ʼ��ı�����
	private String[] attachFileNames;// ����

	public String getFromAddress() {
		return fromAddress;
	}

	public void setFromAddress(String fromAddress) {
		this.fromAddress = fromAddress;
	}

	public String getToAddresses() {
		return toAddresses;
	}

	public void setToAddresses(String toAddresses) {
		this.toAddresses = toAddresses;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setAttachFileNames(String[] attachFileNames) {
		this.attachFileNames = attachFileNames;
	}

	public String[] getAttachFileNames() {
		return attachFileNames;
	}

}
