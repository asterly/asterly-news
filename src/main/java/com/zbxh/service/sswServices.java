package com.zbxh.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;

public class sswServices {
	private String methodname = "";
	private String endpoint = "http://" + getIP() + "/updataService.asmx";
	private static final String targetNamespace = "http://zbxhupdata.com/webservices/";
	private static Service service = new Service();

	public sswServices(String method) {
		this.methodname = method;
	}

	public sswServices() {

	}

	public String getIP() {
		InputStream inputstream = this.getClass().getClassLoader().getResourceAsStream("swsrvconfig.properties");
		Properties p = new Properties();
		try {
			p.load(inputstream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String a = p.getProperty("ip") + ":" + p.getProperty("port");
		return a;
	}

	public String getByPost(String content) {
		String result = "";
		Object[] objects = new Object[1];
		String s1 = "<?xml version=\"1.0\" encoding=\"utf-8\"?>";
		Call call;
		String ss = "sql=";
		int pos = content.indexOf(ss);
		content = content.substring(pos + ss.length());
		objects[0] = content;
//		System.out.println(content);
		try {
			call = (Call) service.createCall();
			call.setTargetEndpointAddress(endpoint);// 远程调用路径
			call.setOperationName(new QName(targetNamespace, methodname));
			call.setSOAPActionURI(targetNamespace + methodname);
			call.addParameter(new QName(targetNamespace, "sql"), // 参数名
					XMLType.XSD_STRING, // 参数类型:String
					ParameterMode.IN);// 参数模式：'IN' or 'OUT'
			call.setReturnType(XMLType.XSD_STRING);// 返回值类型：String
			result = (String) call.invoke(objects);// 远程调用
			pos = result.indexOf(s1);
			if (pos >= 0) {
				result = result.substring(pos + s1.length());
			}
			result = new String(result.getBytes("utf-8"), "utf-8");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

}
