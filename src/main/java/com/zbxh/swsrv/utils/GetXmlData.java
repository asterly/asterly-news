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
	 * 获取URL路径
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
	 * 执行SQL语句并获取数据
	 * 
	 * @param content
	 * @return
	 */
	public String getByPost(String sql) {
		String result = "";
		Object[] objects = new Object[1];
		// 定义头部内容
//		String header = "<?xml version=\"1.0\" encoding=\"utf-8\"?>";
		Call call;
		objects[0] = sql;
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
//			System.out.println("objects值》》》"+objects);
			result = (String) call.invoke(objects);// 远程调用
//			System.out.println("result===++++>>>>\n"+result);
//			if (result != null && result.length() >= header.length()) {
//				result = result.substring(header.length());
//			}
			result = new String(result.getBytes("utf-8"), "utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
//		System.out.println("返回结果++++>>>>"+result);
		return result;
	}

}
