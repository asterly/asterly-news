package com.zbxh.swsrv.utils;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.zbxh.swsrv.entity.User;

public class GetQueryMethod {

	public static String insertMethod;
	public static String queryMethod;
	public static String deleteMethod;
	public static String updateMethod;

	public static String getInsertMethod() {
		return insertMethod;
	}

	public static void setInsertMethod(String insertMethod) {
		GetQueryMethod.insertMethod = insertMethod;
	}

	public static String getQueryMethod() {
		return queryMethod;
	}

	public static void setQueryMethod(String queryMethod) {
		GetQueryMethod.queryMethod = queryMethod;
	}

	public static String getDeleteMethod() {
		return deleteMethod;
	}

	public static void setDeleteMethod(String deleteMethod) {
		GetQueryMethod.deleteMethod = deleteMethod;
	}

	public static String getUpdateMethod() {
		return updateMethod;
	}

	public static void setUpdateMethod(String updateMethod) {
		GetQueryMethod.updateMethod = updateMethod;
	}

	/**
	 * 初始化加载静态方法块
	 */
	static{
		try {
			
			InputStream in = GetQueryMethod.class.getClassLoader().getResourceAsStream("querymethod.xml");
			SAXReader reader = new SAXReader();
			Document doc = reader.read(in);
			// 获取根元素
			
			Element root = doc.getRootElement();
			Element element;
			for (Iterator i = root.elementIterator("method"); i.hasNext();) {
				
				element = (Element) i.next();
				String mthod = element.elementText("name");
//				System.out.println(mthod);
				switch (mthod) {
				case "ExecuteSql":
					setInsertMethod(mthod);
					break;
				case "QueryData":
					setQueryMethod(mthod);
					break;
				case "updateMethod":
					
					setUpdateMethod(mthod);
					break;
				case "deleteMethod":
					
					setDeleteMethod(mthod);
					break;
				default:
					break;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
}
