package com.zbxh.swsrv.service;

import java.util.Date;
import java.util.UUID;

import com.zbxh.swsrv.entity.Softregist;
import com.zbxh.swsrv.utils.FormatDate;
import com.zbxh.swsrv.utils.GetQueryMethod;
import com.zbxh.swsrv.utils.XMLToJSON;

/**
 * 软件注册服务层
 * 注册表中的字段名：
 * 软件编号，行业，专业，软件名称，端类别，WEB项目名，注册版本号
 * 软件说明，使用级别，PGUID，S_UDTIME，S_SYTIME，S_MFLAG，ISDELETE
 * 
 * @author Administrator
 *
 */
public class SoftRegService implements BaseService<Softregist> {
	
	//sqlbase 为数据据中softregiste 中的字段
	private static final String sqlbase="软件编号,行业,专业,软件名称,端类别,WEB项目名,注册版本号,软件说明,使用级别,PGUID,S_UDTIME,S_SYTIME,S_MFLAG";
	
	/**
	 * 添加软件注册信息
	 * @param sr //softreguste 的简写名
	 */
	@Override
	public boolean addition(Softregist sr) {
		String sql="insert into ss_softregist("+sqlbase+") values(\'"
					+sr.getSoftNo()+"\',\'"
					+sr.getVoaction()+"\',\'"
					+sr.getProfession()+"\',\'"
					+sr.getSoftNo()+"\',"			//软件名称
					+sr.getPortType()+",\'"					//int 字段类型
					+sr.getWebName()+"\',\'"
					+sr.getRegVersion()+"\',\'"
					+sr.getExplan()+"\',\'"			//软件说明
					+sr.getUseClass()+"\',\'"		//使用类别
					+UUID.randomUUID().toString()+"\',\'" //UUID随机生成一个随机数作为软件标识
					+FormatDate.yyMMdd_HHmmss(new Date())+"\',\'"	//记录更新时间
					+FormatDate.yyMMdd_HHmmss(new Date())+"\',"	//记录同步时间
					+sr.getMplag()
					+")";
		return XMLToJSON.excueteSql(sql, GetQueryMethod.getInsertMethod());
	}

	@Override
	public boolean update(Softregist sr) {
		String sql="update  ss_softregist set 软件编号=\'"+sr.getSoftNo()
				+"\',行业=\'"+sr.getVoaction()
				+ "\',专业=\'"+sr.getProfession()
				+ "\',软件名称=\'"+sr.getSoftNo()	
				+ "\',端类别="+sr.getPortType()	
				+ ", WEB项目名=\'"+sr.getWebName()			//软件名称
				+ "\',注册版本号\'"+sr.getRegVersion()
				+ "\',软件说明=\'"+sr.getExplan()	
				+ "\',使用级别=\'"+sr.getUseClass()
				+ "\',S_UDTIME="+FormatDate.yyMMdd_HHmmss(new Date())		//记录更新时间
				+ "\',S_SYTIME="+FormatDate.yyMMdd_HHmmss(new Date())	//记录同步时间
				+ "\',S_MFLAG="+sr.getMplag()
				+" where id=\'"+sr.getPguid()+"\'";
		return XMLToJSON.excueteSql(sql, GetQueryMethod.getInsertMethod());
	}

	@Override
	public boolean delete(String id) {
		
		String sql="delete from ss_softregist where PGUID=\'"+id+"\'";
		
		return XMLToJSON.excueteSql(sql, GetQueryMethod.getInsertMethod());
	}

	@Override
	public String queryById(String id) {
		String sql="select "+sqlbase+" from ss_softregist where PGUID=\'"+id+"\'";
		return XMLToJSON.queryDataToJSON(sql, GetQueryMethod.getQueryMethod());
	}

	@Override
	public String queryAll() {
		String sql="select "+sqlbase+",isdelete from ss_softregist";
		return XMLToJSON.queryDataToJSON(sql, GetQueryMethod.getQueryMethod());
	}

	@Override
	public String queryBypaging(int curentPage, int PageSize) {
		
		return null;
	}

}
