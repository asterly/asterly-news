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
		System.out.println("相应数据"+test);
		String respData=id.toString(id);
		
		String data="请求的数据"+id+"\n返回的资源-->"+respData+"\ntest"+test;
		
		return data;
	}
	
	public void xmlToJson() {
        String xml = "<class id="  
                + "'1'"  
                + "><student><name>aaaaaa</name><age>21</age></student><student><name>bbbbbb</name><age>22</age></student></class>"; 
		/* 第二种方法，使用json-lib提供的方法 */  
		 //创建 XMLSerializer对象  
		 //XMLSerializer xmlSerializer = new XMLSerializer();  
		 //将xml转为json（注：如果是元素的属性，会在json里的key前加一个@标识）  
		 //String result =xmlSerializer.read(xml).toString();  
		 //输出json内容  
		 //System.out.println(result);  
	}

	 public static void main(String[] args) {  
	        String xml = "<class id="  
	                + "'1'"  
	                + "><student><name>aaaaaa</name><age>21</age></student><student><name>bbbbbb</name><age>22</age></student></class>";  
	  
	        /* 第一种方法，使用JSON-JAVA提供的方法 */  
	        //将xml转为json  
	        JSONObject xmlJSONObj = XML.toJSONObject(xml);  
	        //设置缩进  
	        String jsonPrettyPrintString = xmlJSONObj.toString(4);  
	        //输出格式化后的json  
	        System.out.println(jsonPrettyPrintString);  
	  
//	        /* 第二种方法，使用json-lib提供的方法 */  
//	        //创建 XMLSerializer对象  
//	        XMLSerializer xmlSerializer = new XMLSerializer();  
//	        //将xml转为json（注：如果是元素的属性，会在json里的key前加一个@标识）  
//	        String result = xmlSerializer.read(xml).toString();
////	        String result = xmlSerializer;;
//	        //输出json内容  
//	        System.out.println(result);  
	  
	    }

	public String addition(User t) {
		
		return null;
	}
	

	@Override
	@RequestMapping(value="{id}",method=RequestMethod.DELETE)
	public String queryOne(@PathVariable int id) {
		System.out.println("删除数据id为"+id+"的数据");
		return null;
	}  
	
	@RequestMapping("/queryAll")
	public String queryAll(ModelMap model) {
		System.out.println("数据请求");
		String request=userService.queryAll();
		model.addAttribute("data", request);
		model.addAttribute("msg", "返回消息");
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
