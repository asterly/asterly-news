package com.zbxh.swsrv.utils;

import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class GetSql {
	

	private static String sql=null;
	
	/**
	 * setter , getter
	 * @return
	 */
	public static String getSql() {
		return sql;
	}

	public static void setSql(String sql) {
		GetSql.sql = sql;
	}

	/**
	 *  根据传入节点遍历
	 * @param node
	 */
	public static void getNode(Element node) {
		// System.out.println("当前节点的名称：：" + node.getName());
		List<Attribute> list = node.attributes();
		for (Attribute attr : list) {
			// System.out.println(attr.getText()+"__"+attr.getValue()+"--"+attr.getName());

			if (attr.getValue().equals("insert")) {
				if (!(node.getTextTrim().equals(""))) {
					System.out.println("文本内容：：：：" + node.getText());

				}
			}

		}

		// 查询当前节点的子迭代器
		Iterator<Element> it = node.elementIterator();
		while (it.hasNext()) {
			// 获取下一个节点
			Element element = it.next();
			// 遍历节点
			getNode(element);
		}

	}
	
	/**
	 *  根据传入参数查找
	 * @param node
	 * @param sqlid
	 * @return
	 */
	public static String getNode(Element node,String sqlid) {
		
		 //System.out.println("当前节点的名称：：" + node.getName());
		List<Attribute> list = node.attributes();
		
		for (Attribute attr : list) {
			// System.out.println(attr.getText()+"__"+attr.getValue()+"--"+attr.getName());
			if (attr.getValue().equals(sqlid)) {
				if (!(node.getTextTrim().equals(""))) {
					System.out.println("文本内容：" + node.getText());
					 return sql=node.getText();
				}
			}
			
			
		}

		 //查询当前节点的子迭代器
		Iterator<Element> it = node.elementIterator();
		while (it.hasNext()&&sql==null) {
			// 获取下一个节点
			Element element = it.next();
			// 遍历节点
			System.out.println(element.getName());
			getNode(element,sqlid);
		}
		return sql;

	}
	
	//记载文件和读取
	public static String getSql(String sqlid,String url){
		
		SAXReader reader=new SAXReader();
		Element root=null;
		//Document docment=reader.read(new File("com/zbxh/swsrv/service/userservice.xml"));
		Document doc;
		try {
			doc = reader.read(GetQueryMethod.class.getClassLoader().getResourceAsStream(url));
			 root= doc.getRootElement();
		} catch (DocumentException e) {
			
			e.printStackTrace();
		}
		
		return getNode(root,sqlid);
		
	}
	
	public static void main(String[] args) throws DocumentException {
		System.out.println(getSql("update","com/zbxh/swsrv/service/userservice.xml"));
	}

	
}
