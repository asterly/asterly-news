package com.zbxh.swsrv.utils;

import org.apache.commons.lang.StringEscapeUtils;

import net.sf.json.JSON;
import net.sf.json.xml.XMLSerializer;


public class XMLToJSON{
	
	/**
	 * ����ѯ�����İ�������json���ݷ���
	 * @param sql ��Ҫ�����sqL���
	 * @param questMethod ��Ҫ��ִ�еķ���
	 * @return
	 */
	public static String queryDataToJSON(String sql,String questMethod) {
		String result=null;
		
		try {
			//�������
			GetXmlData service = new GetXmlData(questMethod);
			//����getByPost();������ȡ���Ľ����
			String resultXML = service.getByPost(sql);
			//ת����json����
			resultXML = StringEscapeUtils.unescapeXml(resultXML);
//			 xmlJSONObj = XML.toJSONObject(resultXML);//���ò���
			if(resultXML.equals("0")) {			//0 ����û�в�ѯ������
				//System.out.println("�������"+resultXML);
				return null;
			}else if(resultXML.equals("1")){ 	//1ִ�н����ȷ
				
				return "1";
			} else if(resultXML.equals("-1")){  //-1����SQL������
				System.out.println("sql������");
				return null;
			}else {
				
				XMLSerializer xmlSerializer = new XMLSerializer(); 
				JSON json = xmlSerializer.read(resultXML);
				//System.out.println("json����===��"+json);//���ò���
	            //��json�������ַ�����ʽ���
				return result =json.toString();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * ִ��д������sql����
	 * @param sql
	 * @param questMethod
	 * @return
	 */
	public static boolean excueteSql(String sql,String questMethod) {;
		
		try {
			//�������
			GetXmlData service = new GetXmlData(questMethod);
			//����getByPost();������ȡ���Ľ����
			String resultXML = service.getByPost(sql);
			//ת����json����
			resultXML = StringEscapeUtils.unescapeXml(resultXML);

			 if(resultXML.equals("1")){ 	//1ִ�н����ȷ 
				
				return true;
			} else if(resultXML.equals("-1")){  
				//-1����SQL������
				System.out.println("sql������");
				return false;
			}else {
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return false;//����쳣ʱ����false;
		}
	}


}
