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
	        // 设置响应内容类型
	        response.setContentType("text/html;charset=UTF-8");
	        String  operator1 = request.getParameter("operator1");
	        String  duan = request.getParameter("duan");
	        String  tlj = request.getParameter("tlj");
	        System.out.println("renrenyuan 人员"+operator1+duan +"---"+tlj);
	        //String sql1= "select * from personinfo  where unitid='"+operator1+"' and 所属单位='"+duan+"'";
	        String sql1;
	        if(duan.equals("请选择")||duan.equals("无选项")){
	        	 sql1="select PERSONID,姓名      from personinfo  where UNITID= "+operator1+" and 所属单位='"+tlj+"'";
	        }else{
	        	 sql1="(select PERSONID,姓名       from personinfo  where UNITID in (select id from rymangeunit  where 所属单位 = '"+duan+"' and TYPENAME = '车间科室' and  parentid ="+operator1+") and 所属单位 = '"+duan+"') union all  (select PERSONID,姓名 from personinfo where UNITID = "+operator1+" and 所属单位 = '"+duan+"')";
	        }
	         
	        String sq= XMLToJson.Qdata2(sql1,operator1);
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
