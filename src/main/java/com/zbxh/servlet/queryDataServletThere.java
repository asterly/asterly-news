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

@WebServlet("/queryDataservlectThere")
public class queryDataServletThere extends HttpServlet{
	 private static final long serialVersionUID = 1L;
     
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public queryDataServletThere() {
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
	        System.out.println(operator1);
	        String sql1= "select * from rymangeunit where 所属单位 = '"+operator1+"'  and TYPENAME in ('车间','电务段科室')  order by SHOWINDEX";
	        //operator1="济南电务段";
	        String sq= XMLToJson.Qdata1(sql1,operator1);
	        PrintWriter out = response.getWriter();
	        //out.write(sq);
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
