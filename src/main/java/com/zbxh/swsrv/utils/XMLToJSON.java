package com.zbxh.swsrv.utils;

import org.apache.commons.lang.StringEscapeUtils;

import net.sf.json.JSON;
import net.sf.json.xml.XMLSerializer;


public class XMLToJSON{
	
	/**
	 * 将查询出来的阿数据以json数据返回
	 * @param sql 需要传入的sqL语句
	 * @param questMethod 需要被执行的方法
	 * @return
	 */
	public static String queryDataToJSON(String sql,String questMethod) {
		String result=null;
		
		try {
			//传入解析
			GetXmlData service = new GetXmlData(questMethod);
			//调用getByPost();方法获取到的结果即
			String resultXML = service.getByPost(sql);
			//转换成json数据
			resultXML = StringEscapeUtils.unescapeXml(resultXML);
//			 xmlJSONObj = XML.toJSONObject(resultXML);//备用测试
			if(resultXML.equals("0")) {			//0 代表没有查询到数据
				//System.out.println("结果等于"+resultXML);
				return null;
			}else if(resultXML.equals("1")){ 	//1执行结果正确
				
				return "1";
			} else if(resultXML.equals("-1")){  //-1代表SQL语句错误
				System.out.println("sql语句错误");
				return null;
			}else {
				
				XMLSerializer xmlSerializer = new XMLSerializer(); 
				JSON json = xmlSerializer.read(resultXML);
				//System.out.println("json数据===》"+json);//备用测试
	            //将json数据以字符串形式输出
				return result =json.toString();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 执行写操作的sql方法
	 * @param sql
	 * @param questMethod
	 * @return
	 */
	public static boolean excueteSql(String sql,String questMethod) {;
		
		try {
			//传入解析
			GetXmlData service = new GetXmlData(questMethod);
			//调用getByPost();方法获取到的结果即
			String resultXML = service.getByPost(sql);
			//转换成json数据
			resultXML = StringEscapeUtils.unescapeXml(resultXML);

			 if(resultXML.equals("1")){ 	//1执行结果正确 
				
				return true;
			} else if(resultXML.equals("-1")){  
				//-1代表SQL语句错误
				System.out.println("sql语句错误");
				return false;
			}else {
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return false;//语句异常时返回false;
		}
	}


}
