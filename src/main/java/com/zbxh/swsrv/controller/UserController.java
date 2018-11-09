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
 * 用户,管理员处理逻辑模块
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
	 * 用户登录板块
	 * @param user
	 * @param model
	 * @return
	 */
	@RequestMapping(value= {"/login","/userLogin"})
	public String Login(User user,ModelMap model,HttpServletRequest request) {
		//System.out.println(user);
		//获取用户信息
		String userinfo=us.login(user);
		if(userinfo!=null) {
			/*将用户信息 存入 session*/
			request.getSession().setAttribute("userinfo", user);
			System.out.println("成功");
			model.addAttribute("msg", "登录成功");
			return "ui/main";
		}else {
			model.addAttribute("msg", "登录失败");
			System.out.println("失败");
			return "../index";
		}
		
		
	}

	
	/**
	 * 用户注册和添加新员工模块
	 */
	@ResponseBody
	@RequestMapping(value= {"/reg","/register","/adduser"},method=RequestMethod.POST)
	public String addition(User user,ModelMap model) {
		System.out.println("执行添加用户"+user);
		if(us.addition(user)) {
			model.addAttribute("msg", "添加成功");
			return "ui/main";
		}else {
			model.addAttribute("msg", "添加失败");
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
	 * 查询所有的员工信息
	 */
	@Override
	@RequestMapping("/queryAll")
	@ResponseBody
	public String queryAll() {
		System.out.println("查询所有的用户信息");
		return us.queryAll();
	}
	
	/**
	 * 修改密码
	 */
	public String modifyPassword(@PathVariable String newpsswrord) {
		
		
		return "修改成功";
		
		
	}
	
	/**
	 * 验证邮箱是否可用
	 */
	@ResponseBody
	@RequestMapping(value= {"/validEmai"})
	public String validataEmail(@PathVariable String email) {
		
		map=new HashMap<>();
		
		if(us.validataEmail(email)) {
			//以{"valid":ture}或{"valid":false}形式返回到前端
			map.put("valid", true);
			//以json形式返回
			return new Gson().toJson(map);
		}else {
			map.put("valid", false);
			return new Gson().toJson(map);
		}
		
	}
	
	
	/**
	 * 验证邮箱是否已被注册
	 */
	@ResponseBody
	@RequestMapping(value= {"/validTel"})
	public String validateTel(@PathVariable String tel) {
			map=new HashMap<>();
		
		if(us.validateTel(tel)) {
			//以{"valid":ture}或{"valid":false}形式返回到前端
			map.put("valid", true);
			//以json形式返回
			return new Gson().toJson(map);
		}else {
			map.put("valid", false);
			return new Gson().toJson(map);
		}
		
	}
	
	/**
	 * 验证旧密码是否正确
	 */
	public String validateOrdPassword(@PathVariable String password,HttpServletRequest request) {
		
		Object userinfo=request.getSession().getAttribute("user");
		
		return password;
		
	}
}
