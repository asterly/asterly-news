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

/**
 * Servlet implementation class HelloForm
 */
@WebServlet("/registerServlet")
public class registerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registerServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // ������Ӧ��������
        response.setContentType("text/html;charset=UTF-8");
        
        // ��������
        String pguid = UUID.randomUUID().toString();
        String dlb=request.getParameter("dlb");
        System.out.println(request.getParameter("syjb"));
        System.out.println(request.getParameter("dlb"));
        /*String sqlHengYeNum="select hycode  from hy_register where   hyname='" + request.getParameter("hy")
					+ "' and isdelete <> 1";
        String HengYeNumValue=XMLToJson.QueryHYNum(sqlHengYeNum);
        System.out.println("sqlHen233432424gYeNum"+HengYeNumValue);*/
        String sqlZhuanYeNum="select zycode  from zy_register where   zyname='" + request.getParameter("zy")
					+ "' and isdelete <> 1";
        String ZhuanYeNumValue=XMLToJson.QueryZYNum(sqlZhuanYeNum);
        System.out.println("sqlZhuanYeNum222222222"+ZhuanYeNumValue);
        
        String pguid2 = UUID.randomUUID().toString();
        pguid2= pguid2.replace("-", "");
        pguid2= pguid2.replace("{", "");
        pguid2= pguid2.replace("}", "");
       /* HengYeNumValue= HengYeNumValue.replace("\"", "");
        HengYeNumValue= HengYeNumValue.replace("[", "");
        HengYeNumValue= HengYeNumValue.replace("]", "");*/
        ZhuanYeNumValue= ZhuanYeNumValue.replace("\"", "");
        ZhuanYeNumValue= ZhuanYeNumValue.replace("[", "");
        ZhuanYeNumValue= ZhuanYeNumValue.replace("]", "");
        pguid2=ZhuanYeNumValue+pguid2;
	   String sqlSoftName="select �������  from ss_softregist  where  ��ҵ='"+request.getParameter("hy")+"'  and  רҵ='"+request.getParameter("zy")+"'  and �������='"+request.getParameter("rjmc")+"'  ";
	   String SoftName =XMLToJson.QuerySoftName(sqlSoftName);
	   
	   String sqlSoftProName="select WEB��Ŀ��  from ss_softregist  where  ��ҵ='"+request.getParameter("hy")+"'  and  רҵ='"+request.getParameter("zy")+"'  and WEB��Ŀ��='"+request.getParameter("xmm")+"'  ";
	   String SoftProName =XMLToJson.QuerySoftProName(sqlSoftProName);
	  
	   if(SoftName.equals("[]") && SoftProName.equals("[]")){
		   String sql="INSERT INTO SS_SOFTREGIST(��ҵ,רҵ,������,�������,ʹ�ü���,�����,WEB��Ŀ��,ע��汾��,���˵��,PGUID,S_UDTIME) VALUES ('"
				   +request.getParameter("hy")+"','"
				   +request.getParameter("zy")+"','"
				   +pguid2+"','"
				   +request.getParameter("rjmc")+"','"
				   +request.getParameter("syjb")+"','"
				   +dlb+"','"
				   +request.getParameter("xmm")+"','"
				   +request.getParameter("bbh")+"','"
				   +request.getParameter("rjsm")+"','"
				   +pguid+"','"
				   +GetSysDateTime()+"')";    
	        String a =XMLToJson.scSql(sql);	        	        
	        PrintWriter out = response.getWriter();
	        out.println(a);
	   }else if(!SoftName.equals("[]")){
	        String resultN="[\"a\"]";
			PrintWriter out = response.getWriter();
		    out.println(resultN);
		    out.close();
	   }else{
	        String resultN="[\"b\"]";
			   PrintWriter out = response.getWriter();
		        out.println(resultN);
		        out.close();
	   }
    }
    /**
     * ����ϵͳ���� ʱ��
     */
    public String GetSysDateTime() {
        DateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINESE);
        return sf.format(new Date());
    }
    int i=1;
    public String GetBianhao() {
    	i++;
 		String  str = String.format("%04d", i);
 	    System.out.println(str);
 	    
      return str;
    }
    
    // ���� POST ��������ķ���
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
