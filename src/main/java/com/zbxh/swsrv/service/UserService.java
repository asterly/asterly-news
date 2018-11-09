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
	 * �����û��������������жϵ�¼��ʽ
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
	    	return "�û���";
	    }
		
		
	}

	/**
	 * ��ѯ����Ա����Ϣ
	 */
	public String queryAll() {
		 sql="select * from ss_user";
		String request =XMLToJSON.queryDataToJSON(sql,GetQueryMethod.queryMethod);
		return request;
	}
	
	/**
	 * 	�û���¼�߼�
	 * @param user
	 * @return
	 */
	public String login(User user) {
		 //sql="select * from ss_usertest where "+getUserNameType(user.getUsername())+"=\'"+DigestUtils.md5Hex(user.getUsername())+"\' and password =\'"+user.getPassword()+"\'";
		 sql="select * from ss_user where "+getUserNameType(user.getUsername())+"=\'"+user.getUsername()+"\' and ����=\'"+user.getPassword()+"\' and isdelete=0";
		System.out.println(sql+"\n");
		return XMLToJSON.queryDataToJSON(sql,GetQueryMethod.getQueryMethod());
		
	}
	
	/**
	 * ���Ա�������Ա�߼�
	 */
	public boolean addition(User user) {
		String sql="insert into ss_user(userid,�û���,tel,email,����,����,�Ƿ�༭,Ȩ��,isdelete) values("
				 			+user.getUserID()+",\'"
				 			+user.getUsername()+"\',\'"
				 			+user.getTel()+"\',\'"
				 			+user.getEmail()+"\',\'"
				 			+user.getDepartment()+"\',\'"
				 			+DigestUtils.md5Hex(user.getPassword())+"\',\'" //ʹ��md5��������м��� 
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
	 * ��Ա�����߼��ϵ�ɾ��
	 * @param id
	 * @return
	 */
	public boolean clrearById(String id) {
		sql="update ss_user set isdelete=1 ";
		return XMLToJSON.queryDataToJSON( sql,GetQueryMethod.getInsertMethod())!=null;
	}
	
	
	/**
	 * ����id��ѯԱ����Ϣ
	 */
	@Override
	public String queryById(String id) {
		sql="select userid,username,tel,email,department,power,isdelete from ss_user where id="+Integer.parseInt(id);
		return XMLToJSON.queryDataToJSON( sql,GetQueryMethod.getQueryMethod());
	}

	/**
	 * Ա����Ϣ��������ѯ
	 */
	@Override
	public String queryBypaging(int curentPage, int PageSize) {
		
		return null;
	}
	
	
	public boolean updateByPassword(String password,String userid) {
		String sql="update ss_user set ����=\'"+DigestUtils.md5Hex(password)+"\' where id="+userid;
		return false;
		
	}
	
	
	/**
	 * ��֤�����Ƿ����
	 */
	public boolean validataEmail(@PathVariable String email) {
		String sql="select email from ss_user where email=\'"+email+"\'";
		return XMLToJSON.queryDataToJSON(sql, GetQueryMethod.queryMethod)!=null;
		
	}
	
	
	/**
	 * ��֤�����Ƿ��ѱ�ע��
	 */
	public boolean validateTel(String tel) {
		String sql="select tel from ss_user where tel=\'"+tel+"\'";
		return XMLToJSON.queryDataToJSON(sql, GetQueryMethod.queryMethod)!=null;
		
	}
	
	/**
	 * ��֤�������Ƿ���ȷ
	 */
	public String validateOrdPassword(String password,int id) {
		
		String sql="select tel from ss_user where password=\'"+DigestUtils.md5Hex(password)+"\' and id="+id;
		return XMLToJSON.queryDataToJSON(sql, GetQueryMethod.getQueryMethod());
		
	}
	
}
