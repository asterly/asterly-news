package com.zbxh.swsrv.service;

import java.util.Date;
import java.util.UUID;

import com.zbxh.swsrv.entity.Softregist;
import com.zbxh.swsrv.utils.FormatDate;
import com.zbxh.swsrv.utils.GetQueryMethod;
import com.zbxh.swsrv.utils.XMLToJSON;

/**
 * ���ע������
 * ע����е��ֶ�����
 * �����ţ���ҵ��רҵ��������ƣ������WEB��Ŀ����ע��汾��
 * ���˵����ʹ�ü���PGUID��S_UDTIME��S_SYTIME��S_MFLAG��ISDELETE
 * 
 * @author Administrator
 *
 */
public class SoftRegService implements BaseService<Softregist> {
	
	//sqlbase Ϊ���ݾ���softregiste �е��ֶ�
	private static final String sqlbase="������,��ҵ,רҵ,�������,�����,WEB��Ŀ��,ע��汾��,���˵��,ʹ�ü���,PGUID,S_UDTIME,S_SYTIME,S_MFLAG";
	
	/**
	 * ������ע����Ϣ
	 * @param sr //softreguste �ļ�д��
	 */
	@Override
	public boolean addition(Softregist sr) {
		String sql="insert into ss_softregist("+sqlbase+") values(\'"
					+sr.getSoftNo()+"\',\'"
					+sr.getVoaction()+"\',\'"
					+sr.getProfession()+"\',\'"
					+sr.getSoftNo()+"\',"			//�������
					+sr.getPortType()+",\'"					//int �ֶ�����
					+sr.getWebName()+"\',\'"
					+sr.getRegVersion()+"\',\'"
					+sr.getExplan()+"\',\'"			//���˵��
					+sr.getUseClass()+"\',\'"		//ʹ�����
					+UUID.randomUUID().toString()+"\',\'" //UUID�������һ���������Ϊ�����ʶ
					+FormatDate.yyMMdd_HHmmss(new Date())+"\',\'"	//��¼����ʱ��
					+FormatDate.yyMMdd_HHmmss(new Date())+"\',"	//��¼ͬ��ʱ��
					+sr.getMplag()
					+")";
		return XMLToJSON.excueteSql(sql, GetQueryMethod.getInsertMethod());
	}

	@Override
	public boolean update(Softregist sr) {
		String sql="update  ss_softregist set ������=\'"+sr.getSoftNo()
				+"\',��ҵ=\'"+sr.getVoaction()
				+ "\',רҵ=\'"+sr.getProfession()
				+ "\',�������=\'"+sr.getSoftNo()	
				+ "\',�����="+sr.getPortType()	
				+ ", WEB��Ŀ��=\'"+sr.getWebName()			//�������
				+ "\',ע��汾��\'"+sr.getRegVersion()
				+ "\',���˵��=\'"+sr.getExplan()	
				+ "\',ʹ�ü���=\'"+sr.getUseClass()
				+ "\',S_UDTIME="+FormatDate.yyMMdd_HHmmss(new Date())		//��¼����ʱ��
				+ "\',S_SYTIME="+FormatDate.yyMMdd_HHmmss(new Date())	//��¼ͬ��ʱ��
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
