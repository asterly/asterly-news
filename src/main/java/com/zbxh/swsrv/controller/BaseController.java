package com.zbxh.swsrv.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

public interface BaseController<T> {
	
	public String addition( T t,ModelMap model);
	
	public String queryOne( int id);
	
	public String deletById(String id);
	
	public String updateById(String id,Object[]...objects);
	
	public String queryAll();

}
