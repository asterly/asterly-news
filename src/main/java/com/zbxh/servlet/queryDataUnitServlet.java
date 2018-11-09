package com.zbxh.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zbxh.service.XMLToJson;
@WebServlet("/queryDataservlect")
public class queryDataUnitServlet extends HttpServlet{
	 private static final long serialVersionUID = 1L;
     
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public queryDataUnitServlet() {
	        super();
	        // TODO Auto-generated constructor stub
	    }

	    /**
	     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	     */
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        // ������Ӧ��������
	        response.setContentType("text/html;charset=UTF-8");
	        String  operator1 = request.getParameter("operator1");//ǰ̨���ݹ����Ĳ���ֵ
	        String  luju = request.getParameter("luju");//ǰ̨���ݹ����Ĳ���ֵ
	        String sql1="";
	        String sql2="";
	        String sq="";
	        String sq1="";
	        String sq2="";
	        System.out.println("����ֵ��"+operator1);
	        if(operator1!=null&&operator1.equals("�й���·�ܹ�˾")){
	        	  sql1= "select * from rymangeunit where ������λ = '"+operator1+"'  and TYPENAME in ('�ܹ�˾����')  order by SHOWINDEX";
	        	  sq= XMLToJson.Qdata1(sql1,operator1);
	        	  sq="[[[\"��ѡ��\",\"��ѡ��\"]],"+sq+"]";
	        	  System.out.println(sql1);
	        }
	        else{
	        	if(operator1!=null&&operator1.equals("A00")){
	        		sql1="select ����,���� from bd_au_��λ�ֵ��  where �ϼ�����='"+operator1+"' or �ϼ�����    is null order by ��λ���";  
		        	sq= XMLToJson.Qdata(sql1,operator1);
	        	}else if(operator1!=null&&operator1.equals("�¼���λ�����")){
	        		sql1="select ����,���� from bd_au_��λ�ֵ��   where �ϼ�����=(select ���� from bd_au_��λ�ֵ�� where ���� = '"+luju+"') or �ϼ�����    is null order by ��λ���";  
	        		sq= XMLToJson.Qdata(sql1,operator1);
	        	}else{
	        		sql2= "select * from rymangeunit where ������λ = '"+luju+"'  and TYPENAME in ('·�ֿ���')  order by SHOWINDEX";
		        	sq2= XMLToJson.Qdata1(sql2,operator1);
		        	
		        	sql1="select ����,���� from bd_au_��λ�ֵ��   where �ϼ�����=(select ���� from bd_au_��λ�ֵ�� where ���� = '"+luju+"') or �ϼ�����    is null order by ��λ���";  
		        	sq1= XMLToJson.Qdata(sql1,operator1);
		        	sq1="["+sq1+",";
		        	sq2=sq2+"]";
		        	sq=sq1+sq2;
	        	}
	        }
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
