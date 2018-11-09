package com.zbxh.swsrv.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;

public class GetXmlData {
	private String methodname = "";
	private String endpoint = "http://" + getIP() + "/updataService.asmx";
	private static final String targetNamespace = "http://zbxhupdata.com/webservices/";
	private static Service service = new Service();

	public GetXmlData(String method) {
		this.methodname = method;
	}

	public GetXmlData() {

	}

	/**
	 * ��ȡURL·��
	 * 
	 * @return
	 */
	public String getIP() {
		InputStream inputstream = this.getClass().getClassLoader().getResourceAsStream("swsrvconfig.properties");
		Properties properties = new Properties();
		try {
			properties.load(inputstream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String url = properties.getProperty("ip") + ":" + properties.getProperty("port");
		return url;
	}

	/**
	 * ִ��SQL��䲢��ȡ����
	 * 
	 * @param content
	 * @return
	 */
	public String getByPost(String sql) {
		String result = "";
		Object[] objects = new Object[1];
		// ����ͷ������
//		String header = "<?xml version=\"1.0\" encoding=\"utf-8\"?>";
		Call call;
		objects[0] = sql;
//		System.out.println(content);
		try {
			call = (Call) service.createCall();
			call.setTargetEndpointAddress(endpoint);// Զ�̵���·��
			call.setOperationName(new QName(targetNamespace, methodname));
			call.setSOAPActionURI(targetNamespace + methodname);
			call.addParameter(new QName(targetNamespace, "sql"), // ������
					XMLType.XSD_STRING, // ��������:String
					ParameterMode.IN);// ����ģʽ��'IN' or 'OUT'
			call.setReturnType(XMLType.XSD_STRING);// ����ֵ���ͣ�String
//			System.out.println("objectsֵ������"+objects);
			result = (String) call.invoke(objects);// Զ�̵���
//			System.out.println("result===++++>>>>\n"+result);
//			if (result != null && result.length() >= header.length()) {
//				result = result.substring(header.length());
//			}
			result = new String(result.getBytes("utf-8"), "utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
//		System.out.println("���ؽ��++++>>>>"+result);
		return result;
	}

}
