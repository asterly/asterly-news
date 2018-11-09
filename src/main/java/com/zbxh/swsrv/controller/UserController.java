package com.zbxh.swsrv.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.zbxh.swsrv.entity.User;
import com.zbxh.swsrv.service.UserService;

/**
 * 
 * �û�,����Ա�����߼�ģ��
 * 
 * @author likun
 *
 */
@Controller
@RequestMapping("/user/")
public class UserController implements BaseController<User>{
	
	UserService us=new UserService();
	
	Map<Object, Object> map=null;
	/**
	 * �û���¼���
	 * @param user
	 * @param model
	 * @return
	 */
	@RequestMapping(value= {"/login","/userLogin"})
	public String Login(User user,ModelMap model,HttpServletRequest request) {
		//System.out.println(user);
		//��ȡ�û���Ϣ
		String userinfo=us.login(user);
		if(userinfo!=null) {
			/*���û���Ϣ ���� session*/
			request.getSession().setAttribute("userinfo", user);
			System.out.println("�ɹ�");
			model.addAttribute("msg", "��¼�ɹ�");
			return "ui/main";
		}else {
			model.addAttribute("msg", "��¼ʧ��");
			System.out.println("ʧ��");
			return "../index";
		}
		
		
	}

	
	/**
	 * �û�ע��������Ա��ģ��
	 */
	@ResponseBody
	@RequestMapping(value= {"/reg","/register","/adduser"},method=RequestMethod.POST)
	public String addition(User user,ModelMap model) {
		System.out.println("ִ������û�"+user);
		if(us.addition(user)) {
			model.addAttribute("msg", "��ӳɹ�");
			return "ui/main";
		}else {
			model.addAttribute("msg", "���ʧ��");
			return "ui/main";
		}
	}

	@Override
	public String queryOne(int id) {
		
		return null;
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


	/**
	 * ��ѯ���е�Ա����Ϣ
	 */
	@Override
	@RequestMapping("/queryAll")
	@ResponseBody
	public String queryAll() {
		System.out.println("��ѯ���е��û���Ϣ");
		return us.queryAll();
	}
	
	/**
	 * �޸�����
	 */
	public String modifyPassword(@PathVariable String newpsswrord) {
		
		
		return "�޸ĳɹ�";
		
		
	}
	
	/**
	 * ��֤�����Ƿ����
	 */
	@ResponseBody
	@RequestMapping(value= {"/validEmai"})
	public String validataEmail(@PathVariable String email) {
		
		map=new HashMap<>();
		
		if(us.validataEmail(email)) {
			//��{"valid":ture}��{"valid":false}��ʽ���ص�ǰ��
			map.put("valid", true);
			//��json��ʽ����
			return new Gson().toJson(map);
		}else {
			map.put("valid", false);
			return new Gson().toJson(map);
		}
		
	}
	
	
	/**
	 * ��֤�����Ƿ��ѱ�ע��
	 */
	@ResponseBody
	@RequestMapping(value= {"/validTel"})
	public String validateTel(@PathVariable String tel) {
			map=new HashMap<>();
		
		if(us.validateTel(tel)) {
			//��{"valid":ture}��{"valid":false}��ʽ���ص�ǰ��
			map.put("valid", true);
			//��json��ʽ����
			return new Gson().toJson(map);
		}else {
			map.put("valid", false);
			return new Gson().toJson(map);
		}
		
	}
	
	/**
	 * ��֤�������Ƿ���ȷ
	 */
	public String validateOrdPassword(@PathVariable String password,HttpServletRequest request) {
		
		Object userinfo=request.getSession().getAttribute("user");
		
		return password;
		
	}
}
