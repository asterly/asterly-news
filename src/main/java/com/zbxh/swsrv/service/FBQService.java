package com.zbxh.swsrv.service;

import com.zbxh.swsrv.entity.FeedBackQuestions;
import com.zbxh.swsrv.utils.GetQueryMethod;
import com.zbxh.swsrv.utils.XMLToJSON;

public class FBQService implements BaseService<FeedBackQuestions> {

	@Override
	public boolean addition(FeedBackQuestions fbq) {
		String sql="insert into ss_feedbackquestions() values("+fbq.getId()+")";
		return XMLToJSON.excueteSql(sql, GetQueryMethod.getInsertMethod());
	}
	
	@Override
	public boolean update(FeedBackQuestions t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String id) {
		
		return false;
	}

	@Override
	public String queryById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String queryAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String queryBypaging(int curentPage, int PageSize) {
		// TODO Auto-generated method stub
		return null;
	}

}
