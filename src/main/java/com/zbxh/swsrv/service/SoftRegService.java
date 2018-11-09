package com.zbxh.swsrv.service;

import com.zbxh.swsrv.entity.Softregist;
import com.zbxh.swsrv.utils.GetQueryMethod;
import com.zbxh.swsrv.utils.XMLToJSON;

public class SoftRegService implements BaseService<Softregist> {

	@Override
	public boolean addition(Softregist t) {
		String sql="";
		return XMLToJSON.excueteSql(sql, GetQueryMethod.getInsertMethod());
	}

	@Override
	public boolean update(Softregist t) {
		
		return false;
	}

	@Override
	public boolean delete(String id) {
		
		return false;
	}

	@Override
	public String queryById(String id) {
		
		return null;
	}

	@Override
	public String queryAll() {
		String sql="";
		return XMLToJSON.queryDataToJSON(sql, GetQueryMethod.getQueryMethod());
	}

	@Override
	public String queryBypaging(int curentPage, int PageSize) {
		
		return null;
	}

}
