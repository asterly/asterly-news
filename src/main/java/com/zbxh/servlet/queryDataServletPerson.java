package com.zbxh.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zbxh.service.XMLToJson;

@WebServlet("/queryDataServletPerson")
public class queryDataServletPerson extends HttpServlet{
	 private static final long serialVersionUID = 1L;
     
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public queryDataServletPerson() {
	        super();
	        // TODO Auto-generated constructor stub
	    }

	    /**
	     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	     */
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        // ������Ӧ��������
	        response.setContentType("text/html;charset=UTF-8");
	        String  operator1 = request.getParameter("operator1");
	        String  duan = request.getParameter("duan");
	        String  tlj = request.getParameter("tlj");
	        System.out.println("renrenyuan ��Ա"+operator1+duan +"---"+tlj);
	        //String sql1= "select * from personinfo  where unitid='"+operator1+"' and ������λ='"+duan+"'";
	        String sql1;
	        if(duan.equals("��ѡ��")||duan.equals("��ѡ��")){
	        	 sql1="select PERSONID,����      from personinfo  where UNITID= "+operator1+" and ������λ='"+tlj+"'";
	        }else{
	        	 sql1="(select PERSONID,����       from personinfo  where UNITID in (select id from rymangeunit  where ������λ = '"+duan+"' and TYPENAME = '�������' and  parentid ="+operator1+") and ������λ = '"+duan+"') union all  (select PERSONID,���� from personinfo where UNITID = "+operator1+" and ������λ = '"+duan+"')";
	        }
	         
	        String sq= XMLToJson.Qdata2(sql1,operator1);
	        PrintWriter out = response.getWriter();
	        out.println(sq);
	        out.close();
	        System.out.println(sq);
	    }
	    /**
	     * ����ϵͳ���� ʱ��
	     */
	    public String GetSysDateTime() {
	        DateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINESE);
	        return sf.format(new Date());
	    }
	    // ���� POST ��������ķ���
	    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	doGet(request, response);
	       
	    }
}
