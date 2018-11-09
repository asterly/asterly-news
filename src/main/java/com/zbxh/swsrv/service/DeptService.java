package com.zbxh.swsrv.service;

import com.zbxh.swsrv.entity.Department;
import com.zbxh.swsrv.utils.GetQueryMethod;
import com.zbxh.swsrv.utils.XMLToJSON;

public class DeptService implements BaseService<Department> {

	@Override
	public boolean addition(Department t) {
		String sql="";
		return XMLToJSON.excueteSql(sql, GetQueryMethod.getInsertMethod());
	}

	
	@Override
	public boolean update(Department t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String queryById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String queryAll() {
		String sql="select * from ss_department";
		return XMLToJSON.queryDataToJSON(sql, GetQueryMethod.getQueryMethod());
	}
	
	/**
	 * 查询部门信息里的所有部门名称
	 * @return
	 */
	public String queryAllByName() {
		String sql="select dnam from ss_department";
		return null;
		
	}

	@Override
	public String queryBypaging(int curentPage, int PageSize) {
		
		return null;
	}

}
