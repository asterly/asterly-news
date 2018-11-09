package com.zbxh.swsrv.service;

public interface BaseService<T> {
	
	public boolean  addition(T t);
	
	public boolean update(T t);
	
	public boolean delete(String id);
	
	public String queryById(String id);
	
	public String queryAll();
	
	public String queryBypaging(int curentPage,int PageSize);

}
