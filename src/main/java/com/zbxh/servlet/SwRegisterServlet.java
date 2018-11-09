package com.zbxh.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zbxh.service.XMLToJson;

@WebServlet("/SwRegisterSrevlet")
public class SwRegisterServlet extends HttpServlet {

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	private static final long serialVersionUID = 1L;
	public SwRegisterServlet(){
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		//������Ӧ��������
		response.setContentType("text/html;charset=UTF-8");
		//��������
		String pguid = UUID.randomUUID().toString();
		System.out.println("123"+request.getParameter("azrq"));
		
		//��ȡ������
		String sqlbianhao="select ������  from ss_softregist where ��ҵ='"+request.getParameter("hy")+"' and רҵ='"+request.getParameter("zy")+"' and �������='"+request.getParameter("rjmc")+"'";
		String bianhaoresult =XMLToJson.QuerySoftBianHao(sqlbianhao);
		bianhaoresult=bianhaoresult.replace("\"", "");
		bianhaoresult=bianhaoresult.replace("[", "");
		bianhaoresult=bianhaoresult.replace("]", "");
		System.out.println(bianhaoresult);
		
		
		//�������
		String sql="INSERT INTO SS_INSTALLATION(��ҵ,רҵ,��װID,��װ��λ����,��װ��λ����,�ϼ���λ����,������,�������,��װ�汾��,��װ������IP,��װ�������˿�,����˴������·��,��������,��װ����,��װ��,��ע,S_UDTIME,PGUID,S_SYTIME,S_MFLAG,ISDELETE) VALUES ('"
				+request.getParameter("hy")+"','"
				+request.getParameter("zy")+"','"
				+pguid+"','"
				+request.getParameter("dwmc")+"','"
				+request.getParameter("dwjb")+"','"
				+request.getParameter("sjdw")+"','"
				+bianhaoresult+"','"
				+request.getParameter("rjmc")+"','"
				+request.getParameter("bbh")+"','"
				+request.getParameter("fwip")+"','"
				+request.getParameter("fwdk")+"','"
				+request.getParameter("azlj")+"','','"
				+request.getParameter("azrq")+"','"
				+request.getParameter("azr")+"','"
				+request.getParameter("bz")+"','"
				+GetSysDateTime()+"','"
				+pguid+"','','','0')";
		
		//��ӡ���ز������ݿ�ķ���ֵ��1Ϊ����ɹ���-1Ϊʧ��
		String a =XMLToJson.scSql(sql);
		PrintWriter out = response.getWriter();
        out.println(a);
        out.close();
        System.out.println(sql);
        System.out.println("���ؽ��"+a);
	}
	/**
	 * ����ϵͳʱ��
	 */
	public String GetSysDateTime(){
		DateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINESE);
        return sf.format(new Date());
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException{
		doGet(request, response);
	}
}
