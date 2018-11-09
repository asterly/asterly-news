package com.zbxh.swsrv.service;


import java.util.regex.Pattern;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import com.zbxh.swsrv.entity.User;
import com.zbxh.swsrv.utils.GetQueryMethod;
import com.zbxh.swsrv.utils.XMLToJSON;

@Service
public class UserService implements BaseService<User>{
	
	private String sql=null;
	
	/**
	 * 根据用户名的数据类型判断登录方式
	 * @param username
	 * @return
	 */
	public static String getUserNameType(String username) {
		
	    String eamil_regEx = "[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?";
	    String tel_regEx="^(0|86|17951)?(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$";
	    
	    if(Pattern.compile(eamil_regEx,Pattern.CASE_INSENSITIVE).matcher(username).matches()) {
	    	return "email";
	    }else if(Pattern.compile(tel_regEx,Pattern.CASE_INSENSITIVE).matcher(username).matches()) {
	    	return "tel";
	    }else {
	    	return "用户名";
	    }
		
		
	}

	/**
	 * 查询所有员工信息
	 */
	public String queryAll() {
		 sql="select * from ss_user";
		String request =XMLToJSON.queryDataToJSON(sql,GetQueryMethod.queryMethod);
		return request;
	}
	
	/**
	 * 	用户登录逻辑
	 * @param user
	 * @return
	 */
	public String login(User user) {
		 //sql="select * from ss_usertest where "+getUserNameType(user.getUsername())+"=\'"+DigestUtils.md5Hex(user.getUsername())+"\' and password =\'"+user.getPassword()+"\'";
		 sql="select * from ss_user where "+getUserNameType(user.getUsername())+"=\'"+user.getUsername()+"\' and 密码=\'"+user.getPassword()+"\' and isdelete=0";
		System.out.println(sql+"\n");
		return XMLToJSON.queryDataToJSON(sql,GetQueryMethod.getQueryMethod());
		
	}
	
	/**
	 * 添加员工或管理员逻辑
	 */
	public boolean addition(User user) {
		String sql="insert into ss_user(userid,用户名,tel,email,部门,密码,是否编辑,权限,isdelete) values("
				 			+user.getUserID()+",\'"
				 			+user.getUsername()+"\',\'"
				 			+user.getTel()+"\',\'"
				 			+user.getEmail()+"\',\'"
				 			+user.getDepartment()+"\',\'"
				 			+DigestUtils.md5Hex(user.getPassword())+"\',\'" //使用md5对密码进行加密 
				 			+user.getPower()+"\',\'"
				 			+user.getIseidt()+"\',1)";
		 System.out.println(sql+GetQueryMethod.getInsertMethod());
		return XMLToJSON.excueteSql( sql,GetQueryMethod.getInsertMethod());
		
	}

	@Override
	public boolean update(User user) {
		sql="update ss_usertest set username=\'"+user.getUsername()
					+"\' tel=\'"+user.getTel()
					+"\' email=\'"+user.getEmail()
					+"\' department=\'"+user.getDepartment()
					+"\' power=\'"+user.getPower()
					+" where id="+user.getUserID();
		return XMLToJSON.queryDataToJSON( sql,GetQueryMethod.getInsertMethod())!=null;
	}

	@Override
	public boolean delete(String id) {
		sql="delete ss_user where id="+Integer.parseInt(id);
		return XMLToJSON.queryDataToJSON( sql,GetQueryMethod.getInsertMethod())!=null;
	}
	
	/**
	 * 对员工做逻辑上的删除
	 * @param id
	 * @return
	 */
	public boolean clrearById(String id) {
		sql="update ss_user set isdelete=1 ";
		return XMLToJSON.queryDataToJSON( sql,GetQueryMethod.getInsertMethod())!=null;
	}
	
	
	/**
	 * 根据id查询员工信息
	 */
	@Override
	public String queryById(String id) {
		sql="select userid,username,tel,email,department,power,isdelete from ss_user where id="+Integer.parseInt(id);
		return XMLToJSON.queryDataToJSON( sql,GetQueryMethod.getQueryMethod());
	}

	/**
	 * 员工信息的批量查询
	 */
	@Override
	public String queryBypaging(int curentPage, int PageSize) {
		
		return null;
	}
	
	
	public boolean updateByPassword(String password,String userid) {
		String sql="update ss_user set 密码=\'"+DigestUtils.md5Hex(password)+"\' where id="+userid;
		return false;
		
	}
	
	
	/**
	 * 验证邮箱是否可用
	 */
	public boolean validataEmail(@PathVariable String email) {
		String sql="select email from ss_user where email=\'"+email+"\'";
		return XMLToJSON.queryDataToJSON(sql, GetQueryMethod.queryMethod)!=null;
		
	}
	
	
	/**
	 * 验证邮箱是否已被注册
	 */
	public boolean validateTel(String tel) {
		String sql="select tel from ss_user where tel=\'"+tel+"\'";
		return XMLToJSON.queryDataToJSON(sql, GetQueryMethod.queryMethod)!=null;
		
	}
	
	/**
	 * 验证旧密码是否正确
	 */
	public String validateOrdPassword(String password,int id) {
		
		String sql="select tel from ss_user where password=\'"+DigestUtils.md5Hex(password)+"\' and id="+id;
		return XMLToJSON.queryDataToJSON(sql, GetQueryMethod.getQueryMethod());
		
	}
	
}
