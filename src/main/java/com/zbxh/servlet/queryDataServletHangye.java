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
import com.zbxh.service.sswServices;

@WebServlet("/queryDataServletHangye")
public class queryDataServletHangye extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public queryDataServletHangye() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置响应内容类型
		String pguid2 = UUID.randomUUID().toString();
		response.setContentType("text/html;charset=UTF-8");
		String operator1 = request.getParameter("operator1");// 前台传递过来的参数值
		String hangye = request.getParameter("hangye");// 行业
		String zhuanye = request.getParameter("zhuanye");// 妆业
		String rjmc = request.getParameter("rjmc"); // 软件名称
		String syjb = request.getParameter("syjb");// 使用级别
		String wtlxcanshu = request.getParameter("wtlxcanshu");// 前台传递过来的参数值
		String wtlxtj = request.getParameter("wtlxtj");// 前台传递过来的参数值
		String tjlx = request.getParameter("tjlx");// 上层问题类型
		String dwcxcanshu = request.getParameter("dwcxcanshu");// 单位查询参数
		String dwmcadd = request.getParameter("dwmcadd");
		String fslx = request.getParameter("fslx");// 上层问题分属类型
		String sa = request.getParameter("sa");
		String sql1;
		String sq = null;///
		if (operator1 != null && operator1.equals("A00")) {
			operator1 = "0";
		}

		// 获取input单位
		if (operator1 != null && operator1.equals("获取input单位")) {
			sql1 = " select  distinct 单位名称,单位级别  from SS_IMPLEMENT where 行业='" + hangye + "'  and 专业='" + zhuanye
					+ "' and 软件名称='" + rjmc + "'  and  单位级别<=2   order by 单位级别,单位名称";
			sq = XMLToJson.implementQuery(sql1);
			System.out.println("ssdss" + sq);
		}
		// 软件管理页面添加,修改时判断是否重复添加
		if (operator1 != null && operator1.equals("软件管理判断重复")) {
			sql1 = " select count(*)  from ss_installation where 行业='" + request.getParameter("hy") + "'  and 专业='"
					+ request.getParameter("zy") + "' and 软件名称='" + request.getParameter("rjmc") + "'  and  安装版本号='"
					+ request.getParameter("bbh") + "' and 安装单位名称='" + request.getParameter("dwmcinput")
					+ "'  order by 安装单位级别,安装单位名称";
			sq = XMLToJson.QueryDataSql(sql1);
			System.out.println("ssds00000000000000s" + sql1);
			System.out.println("ssd0000000000ss" + sq);
		}

		if (operator1 != null && operator1.equals("端类别")) {
			sql1 = "select 端类别    from ss_softregist where  行业='" + request.getParameter("hy") + "'  and  专业='"
					+ request.getParameter("zy") + "'  and 软件名称='" + request.getParameter("rjmc") + "'  ";
			sq = XMLToJson.QueryDuanLb(sql1);

		} else if (operator1 != null && operator1.equals("IP端口号获取")) {
			sswServices service = new sswServices();
			sq = "[\"" + service.getIP() + "\"]";
		}
		// 工程实施单位级别查询-------------------------6月29日添加---------------------------------------------
		else if (operator1 != null && operator1.equals("工程实施单位级别查询")) {
			// 需要添加判断软件名称不为空的时候 7月1日 还未添加，之后完善，也可在前台直接判断请选择，在软件名称改变的时候判断出
			// 软件名称=“请选择” 不做任何处理，直接返回，这样不会请求后台。
			sql1 = " select 使用级别  from ss_softregist where  行业='" + hangye + "'  and 专业='" + zhuanye + "' and 软件名称='"
					+ rjmc + "'  and isdelete <> 1";
			sq = XMLToJson.Queryunitlevel(sql1);
		}
		// ----------------修改问题记录操作------------------------修改问题记录操作-----------------修改问题记录操作--------------------
		else if (operator1 != null && operator1.equals("修改问题记录操作")) {

			sql1 = " select zyname,zycode  from zy_register where   hycode=(select hycode  from hy_register where   hyname='"
					+ request.getParameter("zhuanyetext") + "' ) and isdelete <> 1";
			sq = XMLToJson.QueryDataZy(sql1);
		}
		// genju根据上级单位的Pguid查询上级单位名称
		else if (operator1 != null && operator1.equals("根据Pguid查询上级单位名称")) {
			sql1 = " select 单位名称  from SS_IMPLEMENT  where   pguid='" + request.getParameter("sa") + "'";
			sq = XMLToJson.QueryDataUpUnitName(sql1);
		}

	
	 else if (operator1 != null && operator1.equals("修改单位名称")) {
			sql1 = " update ss_implement set 上级单位= '" + request.getParameter("axgunit") + "'  where  行业='"
					+ request.getParameter("hy") + "'  and  专业='" + request.getParameter("zy") + "'  and 软件名称='"
					+ request.getParameter("rjxt") + "' and 上级单位='" + request.getParameter("xgunit") + "' ";
			sq = XMLToJson.scSql(sql1);
		} else if (operator1 != null && operator1.equals("上级单位")) { // 去重查询
			String dwjbadd = request.getParameter("dwjbadd");
			// --------------------6月29修改，118--138行--------------------------------------------------
			// zhe以后要修改为通过行业专业一步一步的查询得到这两个数组在进行使用级别（单位级别）转换数字
			String[] arr = { "总公司", "路局", "电务段", "车间", "班组", "个人" };
			String[] arr2 = { "总公司", "路局", "通信段", "车间", "班组", "个人" };
			int unitGread = 0;
			System.out.println(dwjbadd + "jiuzhege " + request.getParameter("zy"));
			if (request.getParameter("zy").equals("信号")) {
				for (int i = 0; i < arr.length; i++) {
					if (dwjbadd.equals(arr[i])) {
						unitGread = i;
					}
				}
			}
			if (request.getParameter("zy").equals("通信")) {
				unitGread = 0;
				for (int i = 0; i < arr2.length; i++) {
					if (dwjbadd.equals(arr2[i])) {
						unitGread = i;
					}
				}
			}
			/*
			 * int unitGread = 4; String dwjbadd =
			 * request.getParameter("dwjbadd"); if (dwjbadd != null &&
			 * dwjbadd.equals("铁总")) { unitGread = 0; } if (dwjbadd != null &&
			 * dwjbadd.equals("局")) { unitGread = 1; } if (dwjbadd != null &&
			 * dwjbadd.equals("段")) { unitGread = 2; }
			 */
			sql1 = " select  DISTINCT 单位名称  from ss_implement  where 单位级别= '" + unitGread + "' and  行业='"
					+ request.getParameter("hy") + "'  and  专业='" + request.getParameter("zy") + "'  and 软件名称='" + rjmc
					+ "' order by 单位名称";
			sq = XMLToJson.implementQuery(sql1);
		} else if (operator1 != null && operator1.equals("查询行业")) {
			sql1 = " select hyname,hycode  from hy_register where   hycode='" + hangye + "' and isdelete <> 1";
			sq = XMLToJson.QueryDataHy(sql1);

		} else if (operator1 != null && operator1.equals("查询专业")) {
			sql1 = " select zyname,zycode  from zy_register where   hycode='" + zhuanye + "' and isdelete <> 1";
			sq = XMLToJson.QueryDataZy(sql1);
		} else if (operator1 != null && operator1.equals("软件名称")) {
			sql1 = " select 软件名称,软件编号 from ss_softregist where  行业='" + hangye + "'and 专业='" + zhuanye
					+ "' and isdelete <> 1 order by 软件名称 ";
			sq = XMLToJson.Qdata4(sql1, operator1);
		} else if (operator1 != null && operator1.equals("查询使用级别")) {
			sql1 = " select levelname,levelcode from zy_unitlevel where  zycode='" + syjb + "' and isdelete <> 1";
			sq = XMLToJson.QueryDataLevel(sql1);
		}
		// 七月三十一日添加......................
		else if (operator1 != null && operator1.equals("原因类型添加")) {
			sql1 = "select *  from ss_cause where 原因='" + request.getParameter("causetj") + "' and isdelete <> 1 ";
			sq = XMLToJson.CauseWtlx(sql1);
			if (sq.equals("[]")) {
				sql1 = "insert into  ss_cause (原因,pguid)values ('" + request.getParameter("causetj") + "','" + pguid2
						+ "')";
				sq = XMLToJson.scSql(sql1);
				if (sq.equals("[\"1\"]")) {
					sql1 = "select *  from ss_cause  where isdelete <> 1 ";
					sq = XMLToJson.CauseWtlx(sql1);
				} else {
					sq = "[\"插入不成功\"]";
				}
			} else {
				sq = "[\"已存在\"]";
			}
		}
		// 原因设置查询........ 七月三十一日添加....................
		else if (operator1 != null && operator1.equals("原因设置查询")) {
			sql1 = "select *  from ss_cause  where isdelete <> 1 ";
			sq = XMLToJson.CauseWtlx(sql1);
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