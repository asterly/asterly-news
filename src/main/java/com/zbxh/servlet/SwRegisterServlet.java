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
		//设置响应内容类型
		response.setContentType("text/html;charset=UTF-8");
		//处理中文
		String pguid = UUID.randomUUID().toString();
		System.out.println("123"+request.getParameter("azrq"));
		
		//获取软件编号
		String sqlbianhao="select 软件编号  from ss_softregist where 行业='"+request.getParameter("hy")+"' and 专业='"+request.getParameter("zy")+"' and 软件名称='"+request.getParameter("rjmc")+"'";
		String bianhaoresult =XMLToJson.QuerySoftBianHao(sqlbianhao);
		bianhaoresult=bianhaoresult.replace("\"", "");
		bianhaoresult=bianhaoresult.replace("[", "");
		bianhaoresult=bianhaoresult.replace("]", "");
		System.out.println(bianhaoresult);
		
		
		//插入语句
		String sql="INSERT INTO SS_INSTALLATION(行业,专业,安装ID,安装单位名称,安装单位级别,上级单位名称,软件编号,软件名称,安装版本号,安装服务器IP,安装服务器端口,服务端代理程序路径,接入密码,安装日期,安装人,备注,S_UDTIME,PGUID,S_SYTIME,S_MFLAG,ISDELETE) VALUES ('"
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
		
		//打印返回操作数据库的返回值，1为插入成功，-1为失败
		String a =XMLToJson.scSql(sql);
		PrintWriter out = response.getWriter();
        out.println(a);
        out.close();
        System.out.println(sql);
        System.out.println("返回结果"+a);
	}
	/**
	 * 返回系统时间
	 */
	public String GetSysDateTime(){
		DateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINESE);
        return sf.format(new Date());
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException{
		doGet(request, response);
	}
}
