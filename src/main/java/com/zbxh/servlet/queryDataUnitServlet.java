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
	        // 设置响应内容类型
	        response.setContentType("text/html;charset=UTF-8");
	        String  operator1 = request.getParameter("operator1");//前台传递过来的参数值
	        String  luju = request.getParameter("luju");//前台传递过来的参数值
	        String sql1="";
	        String sql2="";
	        String sq="";
	        String sq1="";
	        String sq2="";
	        System.out.println("传的值是"+operator1);
	        if(operator1!=null&&operator1.equals("中国铁路总公司")){
	        	  sql1= "select * from rymangeunit where 所属单位 = '"+operator1+"'  and TYPENAME in ('总公司科室')  order by SHOWINDEX";
	        	  sq= XMLToJson.Qdata1(sql1,operator1);
	        	  sq="[[[\"无选项\",\"无选项\"]],"+sq+"]";
	        	  System.out.println(sql1);
	        }
	        else{
	        	if(operator1!=null&&operator1.equals("A00")){
	        		sql1="select 编码,名称 from bd_au_单位字典表  where 上级编码='"+operator1+"' or 上级编码    is null order by 单位编号";  
		        	sq= XMLToJson.Qdata(sql1,operator1);
	        	}else if(operator1!=null&&operator1.equals("下级单位电务段")){
	        		sql1="select 编码,名称 from bd_au_单位字典表   where 上级编码=(select 编码 from bd_au_单位字典表 where 名称 = '"+luju+"') or 上级编码    is null order by 单位编号";  
	        		sq= XMLToJson.Qdata(sql1,operator1);
	        	}else{
	        		sql2= "select * from rymangeunit where 所属单位 = '"+luju+"'  and TYPENAME in ('路局科室')  order by SHOWINDEX";
		        	sq2= XMLToJson.Qdata1(sql2,operator1);
		        	
		        	sql1="select 编码,名称 from bd_au_单位字典表   where 上级编码=(select 编码 from bd_au_单位字典表 where 名称 = '"+luju+"') or 上级编码    is null order by 单位编号";  
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
	     * 返回系统日期 时间
	     */
	    public String GetSysDateTime() {
	        DateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINESE);
	        return sf.format(new Date());
	    }
	    // 处理 POST 方法请求的方法
	    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	doGet(request, response);
	       
	    }
}
