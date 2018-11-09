package com.zbxh.swsrv.controller;

import javax.swing.text.html.FormSubmitEvent.MethodType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zbxh.swsrv.entity.User;
import com.zbxh.swsrv.service.UserService;
import com.zbxh.swsrv.xmltojson.JSONObject;
import com.zbxh.swsrv.xmltojson.XML;



@Controller
@RequestMapping("/userTest/")
public class TestController implements BaseController<User>{
	

	
	public UserService userService=new UserService();
	
	@ResponseBody
	@RequestMapping(value = "{id}/{test}",method = RequestMethod.GET)
	public String test(@PathVariable("id") Long id,@PathVariable("test") String test) {
		System.out.println("��Ӧ����"+test);
		String respData=id.toString(id);
		
		String data="���������"+id+"\n���ص���Դ-->"+respData+"\ntest"+test;
		
		return data;
	}
	
	public void xmlToJson() {
        String xml = "<class id="  
                + "'1'"  
                + "><student><name>aaaaaa</name><age>21</age></student><student><name>bbbbbb</name><age>22</age></student></class>"; 
		/* �ڶ��ַ�����ʹ��json-lib�ṩ�ķ��� */  
		 //���� XMLSerializer����  
		 //XMLSerializer xmlSerializer = new XMLSerializer();  
		 //��xmlתΪjson��ע�������Ԫ�ص����ԣ�����json���keyǰ��һ��@��ʶ��  
		 //String result =xmlSerializer.read(xml).toString();  
		 //���json����  
		 //System.out.println(result);  
	}

	 public static void main(String[] args) {  
	        String xml = "<class id="  
	                + "'1'"  
	                + "><student><name>aaaaaa</name><age>21</age></student><student><name>bbbbbb</name><age>22</age></student></class>";  
	  
	        /* ��һ�ַ�����ʹ��JSON-JAVA�ṩ�ķ��� */  
	        //��xmlתΪjson  
	        JSONObject xmlJSONObj = XML.toJSONObject(xml);  
	        //��������  
	        String jsonPrettyPrintString = xmlJSONObj.toString(4);  
	        //�����ʽ�����json  
	        System.out.println(jsonPrettyPrintString);  
	  
//	        /* �ڶ��ַ�����ʹ��json-lib�ṩ�ķ��� */  
//	        //���� XMLSerializer����  
//	        XMLSerializer xmlSerializer = new XMLSerializer();  
//	        //��xmlתΪjson��ע�������Ԫ�ص����ԣ�����json���keyǰ��һ��@��ʶ��  
//	        String result = xmlSerializer.read(xml).toString();
////	        String result = xmlSerializer;;
//	        //���json����  
//	        System.out.println(result);  
	  
	    }

	public String addition(User t) {
		
		return null;
	}
	

	@Override
	@RequestMapping(value="{id}",method=RequestMethod.DELETE)
	public String queryOne(@PathVariable int id) {
		System.out.println("ɾ������idΪ"+id+"������");
		return null;
	}  
	
	@RequestMapping("/queryAll")
	public String queryAll(ModelMap model) {
		System.out.println("��������");
		String request=userService.queryAll();
		model.addAttribute("data", request);
		model.addAttribute("msg", "������Ϣ");
		return "index";
	}

	@Override
	public String deletById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateById(String id, Object[]... objects) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String queryAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addition(User t, ModelMap model) {
		// TODO Auto-generated method stub
		return null;
	}


}
