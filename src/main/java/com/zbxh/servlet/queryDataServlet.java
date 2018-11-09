package com.zbxh.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.zbxh.service.XMLToJson;

@WebServlet("/queryDataServlet")
public class queryDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public queryDataServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置响应内容类型
		response.setContentType("text/html;charset=UTF-8");
		// pguid是前台的变量名， pguid2是新产生的id值

		String pguid2 = UUID.randomUUID().toString();
		String sq = "";// 返回前台的结果
		String sql1 = "";// sql语句赋值
		String operator1 = request.getParameter("operator1"); // 用于前台传递的值在后台进行判断操作
		String operator = request.getParameter("operator"); // 用于前台传递的值在后台进行判断操作
		String hangye = request.getParameter("hangye"); // 行业
		String zhuanye = request.getParameter("zhuanye"); // 专业
		String rjmc = request.getParameter("rjmc"); // 软件名称
		String dwmc = request.getParameter("dwmc"); // 单位名称（input）
		String pguid = request.getParameter("pguid"); //
		// 用户登录所需变量：单位、姓名、密码
		String unitlogin = request.getParameter("unit");
		String namelogin = request.getParameter("name");
		String pwdlogin = request.getParameter("pwd");
		// 人员注册所需变量operator1,bmadd(部门),username（注册的用户名）,check_val（权限的选择）
		String bmadd = request.getParameter("bmadd");
		String username = request.getParameter("username");
		String quanxian = request.getParameter("quanxian");
		// 进度实施修改阶段完成所需变量
		String value = request.getParameter("value");
		String tablepguid = request.getParameter("tablepguid");
		String sotime = request.getParameter("sotime");
		String quch = request.getParameter("quch");// 问题修改
		String gcjd = request.getParameter("gcjd");
		String fslx = request.getParameter("fslx");// 问题修改
		String hy = request.getParameter("hy");// 行业
		String zy = request.getParameter("zy");// 专业
		String rjxt = request.getParameter("rjxt");// 软件名称（问题查询中的）
		String sjdw1 = request.getParameter("sjdw");
		String wtcause = request.getParameter("wtcause");// 发生原因（问题查询中的）
		String dwcx = request.getParameter("dwcx");// 问题查询（单位）
		String sfjj = request.getParameter("sfjj");// 问题是否解决
		String allcs = request.getParameter("allcs");// 查询全部数据参数
		String department = request.getParameter("department");// 部门名称添加用
		String wentiquery = request.getParameter("wentiquery");

		// 饼状图和柱状图数据，软件管理下面字页面，各个页面的数据总统计，（'软件问题','用户需求','用户使用','工程安装'）
		if (operator1 != null && operator1.equals("图表数据查询pie")) {
			if (fslx.equals("") && rjmc.equals("请选择")) {
				sql1 = "select count(*)  as a ,软件系统 from ss_feedbackquestions where  isdelete <> 1  group by 软件系统 order by 软件系统";
				sq = XMLToJson.BarAndPieSoftNameQuery(sql1);
			} else if (!fslx.equals("") && !rjmc.equals("请选择")) {
				sql1 = "select count(发生原因) AS A,发生原因    from ss_feedbackquestions  where   软件系统='" + rjmc
						+ "'  and  问题类型分属类型 ='" + fslx + "'  and isdelete <> 1 group by 发生原因    order by 发生原因";
				sq = XMLToJson.BarAndPiechildQuery(sql1);
			} else {
				sql1 = "select count(*)  as a ,软件系统 from ss_feedbackquestions where  isdelete <> 1  group by 软件系统  order by 软件系统";
				sq = XMLToJson.BarAndPieSoftNameQuery(sql1);
			}
		}
		if (operator1 != null && operator1.equals("图表数据查询pie1")) {
			if (fslx.equals("") && rjmc.equals("请选择")) {
				sql1 = "select count(*)  as a ,问题类型分属类型  from ss_feedbackquestions where  isdelete <> 1  group by 问题类型分属类型  order by 问题类型分属类型 ";
				sq = XMLToJson.BarAndPieQuery(sql1);
			} else if (!fslx.equals("") && !rjmc.equals("请选择")) {
				sql1 = "select count(发生原因) AS A,发生原因    from ss_feedbackquestions  where   软件系统='" + rjmc
						+ "'  and  问题类型分属类型 ='" + fslx + "'  and isdelete <> 1 group by 发生原因  order by 发生原因";
				sq = XMLToJson.BarAndPiechildQuery(sql1);
			} else {
				sql1 = "select count(问题类型分属类型) AS A,问题类型分属类型    from ss_feedbackquestions  where   软件系统='" + rjmc
						+ "' and isdelete <> 1 group by 问题类型分属类型       order by 问题类型分属类型";
				sq = XMLToJson.BarAndPieQuery(sql1);
			}

		}
		/// 子页面  按照     单位    查询数据     pie 
		/// 数据子页面图表数据查询pie子页面图表数据查询pie子页面图表数据查询pie子页面图表数据查询pie子页面图表数据查询pie子页面图表数据查询pie
		if (operator1 != null && operator1.equals("子页面图表数据查询pie")) {
			if (!rjmc.equals("请选择")) {
				sql1 = "select count(*) AS A,判断级别    from ss_feedbackquestions  where   软件系统='" + rjmc
						+ "'  and  问题类型分属类型 ='" + fslx + "'  and isdelete <> 1 group by 判断级别    order by 判断级别";
				sq = XMLToJson.BarAndPiechildunitQuery(sql1);
			} else {
				sql1 = "select count(*)  as a ,软件系统 from ss_feedbackquestions where  问题类型分属类型 ='" + fslx
						+ "'  and isdelete <> 1  group by 软件系统 order by 软件系统";
				sq = XMLToJson.BarAndPieSoftNameQuery(sql1);
			}
		}
		if (operator1 != null && operator1.equals("子页面图表数据查询pie1")) {
			if (!rjmc.equals("请选择")) {
				sql1 = "select count(*) AS A,发生原因    from ss_feedbackquestions  where   软件系统='" + rjmc
						+ "'  and  问题类型分属类型 ='" + fslx + "'  and isdelete <> 1 group by 发生原因  order by 发生原因";
				sq = XMLToJson.BarAndPiechildQuery(sql1);
			} else {
				//八月三一号
				//sql1 = "select count(发生原因) AS A,发生原因    from ss_feedbackquestions  where    问题类型分属类型 ='" + fslx
				//		+ "'  and isdelete <> 1 group by 发生原因  order by 发生原因 ";
				sql1 = "select count(*) AS A,发生原因    from ss_feedbackquestions  where    问题类型分属类型 ='" + fslx
						+ "'  and isdelete <> 1 group by 发生原因  order by 发生原因 ";
				sq = XMLToJson.BarAndPiechildQuery(sql1);
				System.out.println("是这个吗"+sq);
			}
		}
		if (operator1 != null && operator1.equals("图表数据查询")) {
			if (fslx.equals("") && rjmc.equals("请选择")) {
				sql1 = "select 软件系统    from ss_feedbackquestions  where   isdelete <> 1 group by 软件系统";
				sq = XMLToJson.getLegendUnit(sql1);
				sql1 = "select count(*)  as a ,软件系统,问题类型分属类型 from ss_feedbackquestions where  isdelete <> 1  group by 软件系统,问题类型分属类型 order by 问题类型分属类型,软件系统";
				sq = XMLToJson.BarAndPieCESHI(sql1, sq);
			} else if (!fslx.equals("") && !rjmc.equals("请选择")) {
				sql1 = "select count(发生原因) AS A,发生原因    from ss_feedbackquestions  where   软件系统='" + rjmc
						+ "'  and  问题类型分属类型 ='" + fslx + "'  and isdelete <> 1 group by 发生原因";
				sq = XMLToJson.BarAndPiechildQuery(sql1);
			} else {
				sql1 = "select count(问题类型分属类型) AS A,问题类型分属类型    from ss_feedbackquestions  where   软件系统='" + rjmc
						+ "' and isdelete <> 1 group by 问题类型分属类型 ";
				sq = XMLToJson.BarAndPieQuery(sql1);
			}
		}

		// 软件问题图表查询四个子页面共用一个
		if (operator1 != null && operator1.equals("软件问题图表数据查询")) {
			if (!rjmc.equals("请选择")) {
				sql1 = "select 判断级别   from ss_feedbackquestions  where  行业='" + hy + "' and  专业= '" + zy + "' and 软件系统='"
						+ rjmc + "' and 问题类型分属类型='" + fslx + "'  and   isdelete <> 1  group by 判断级别   order by 判断级别";
				sq = XMLToJson.getSoftUnit(sql1);
				System.out.println("zheshi 测试单位名称    "+sq);
				sql1 = "select 发生原因    from ss_feedbackquestions  where  行业='" + hy + "' and  专业= '" + zy
						+ "' and 软件系统='" + rjmc + "' and 问题类型分属类型='" + fslx
						+ "' and   isdelete <> 1 group by 发生原因    order by 发生原因";
				String sq2 = XMLToJson.getQuestion(sql1);
				System.out.println("  ");
				System.out.println("fashengyuanyin    "+sq2);
					sql1 = "select count(*)  as a ,判断级别,发生原因  from ss_feedbackquestions where  行业='" + hy + "' and  专业= '"
						+ zy + "' and  软件系统='" + rjmc + "' and  问题类型分属类型='" + fslx
						+ "' and  isdelete <> 1  group by 判断级别,发生原因   order by 发生原因,判断级别";
				sq = XMLToJson.ChildSoftUnitBarAndPie(sql1, sq, sq2);
				 
				System.out.println("这是测试的数据： 我要看看结果："+ sq);
			} else {
				sql1 = "select 软件系统    from ss_feedbackquestions  where    isdelete <> 1 group by 软件系统   order by 软件系统";
				sq = XMLToJson.getLegendUnit(sql1);
				System.out.println("222zheshi 软件系统    "+sq);
				sql1 = "select 发生原因    from ss_feedbackquestions  where  问题类型分属类型='" + fslx
						+ "' and   isdelete <> 1 group by 发生原因    order by 发生原因";
				String sq2 = XMLToJson.getQuestion(sql1);
				System.out.println("22fashengyuanyin    "+sq2);
				sql1 = "select count(*)  as a ,软件系统,发生原因  from ss_feedbackquestions where 问题类型分属类型='" + fslx
						+ "' and  isdelete <> 1  group by 软件系统,发生原因   order by 发生原因,软件系统";
				sq = XMLToJson.ChildBarAndPieCESHI(sql1, sq, sq2);
			}
		}
	
		if (operator1 != null && operator1.equals("问题管理子页面单位查询")) {
			if (rjmc.equals("请选择")) {
				sql1 = "select distinct 判断级别      from ss_feedbackquestions where  问题类型分属类型='" + fslx
						+ "'  and isdelete <> 1 ";
			} else {
				sql1 = "select distinct 判断级别        from ss_feedbackquestions where 行业='" + hy + "' and 专业='" + zy
						+ "'  and  软件系统='" + rjmc + "'  and 问题类型分属类型='" + fslx + "'  and isdelete <> 1 ";
			}
			sq = XMLToJson.QuestitionQuery(sql1);
		}
		// 问题管理四个子页面的全部参数显示
		if (operator1 != null && operator1.equals("查询全部参数")) {
			sql1 = "select * from ss_feedbackquestions where pguid='" + allcs
					+ "' and isdelete <> 1 order by 提出时间  desc";
			sq = XMLToJson.QdataProQuery(sql1);
		} else if (operator1 != null && operator1.equals("工程安装查询全部参数")) {
			sql1 = "select * from ss_feedbackquestions where pguid='" + allcs
					+ "' and isdelete <> 1 order by 提出时间  desc";
			sq = XMLToJson.QdataProQuerygc(sql1);
		}
		// 登录姓名查询+++++++++++++++++++++++++++++++++++++++++++
		if (operator1 != null && operator1.equals("登录姓名查询")) {
			sql1 = "select * from ss_user where 部门='" + request.getParameter("unit") + "' order by userid";
			sq = XMLToJson.QdataUser(sql1);

			if (sq.equals("[[\"无选项\",\"无选项\"]]")) {
				sq = "[]";
			}
		}
		// 用户登录部分判断
		if (operator1 != null && operator1.equals("登录")) {
			sql1 = "select * from ss_user where 用户名='" + namelogin + "' order by userid";
			sq = XMLToJson.QdataUser(sql1);
			if (sq.equals("[[\"无选项\",\"无选项\"]]")) {
				sq = "[\"用户名不正确\"]";
			} else {
				sql1 = "select * from ss_user where 用户名='" + namelogin + "' and 密码= '" + pwdlogin + "'order by userid";
				sq = XMLToJson.QdataUser(sql1);
				if (sq.equals("[[\"无选项\",\"无选项\"]]")) {
					sq = "[\"密码不正确\"]";
				}
			}
		}
		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		// 查询已注册用户
		if (operator1 != null && operator1.equals("查询注册用户信息")) {
			sql1 = "select * from ss_user where not 用户名='admin' order by 部门,用户名,userid";
			sq = XMLToJson.QdataUserTable(sql1);
		}
		// 注册用户记录删除
		if (operator1 != null && operator1.equals("注册用户删除记录")) {
			pguid = pguid.substring(0);
			String[] numberArray = pguid.split(",");
			String pguidsql = "userid='" + numberArray[0] + "'  ";
			for (int i = 1; i < numberArray.length; i++) {
				pguidsql += "   or userid='" + numberArray[i] + "'";
			}
			String sql = "DELETE FROM ss_user where " + pguidsql;
			XMLToJson.scSql(sql);

			sql1 = "select * from ss_user where not 用户名='admin' order by 部门,用户名";
			sq = XMLToJson.QdataUserTable(sql1);

		}

		// 修改密码
		if (operator1 != null && operator1.equals("修改密码")) {
			sql1 = "select * from ss_user where 用户名='" + request.getParameter("uname") + "' and 密码= '"
					+ request.getParameter("opwd") + "'";
			sq = XMLToJson.QdataUser(sql1);
			if (sq.equals("[[\"无选项\",\"无选项\"]]")) {
				sq = "2";
			} else {
				String sql = "UPDATE ss_user SET 密码='" + request.getParameter("zpwd") + "' where 用户名='"
						+ request.getParameter("uname") + "'";
				// 打印返回操作数据库的返回值，1为插入成功，-1为失败
				sq = XMLToJson.scSql(sql);
			}
		}
		// 进度名称修改
		if (operator1 != null && operator1.equals("进度名称修改")) {
			sql1 = " select * from ss_stepset where pguid='" + pguid + "' ";
			sq = XMLToJson.jieduanQuery(sql1);
		}
		// 修改进度名称
		if (operator1 != null && operator1.equals("修改进度名称")) {
			String gcjdxg = request.getParameter("gcjdxg");
			int gcjd1 = 0;
			String arr[] = { "第一阶段", "第二阶段", "第三阶段", "第四阶段", "第五阶段", "第六阶段", "第七阶段", "第八阶段", "第九阶段", "第十阶段" };
			for (int i = 0; i < 10; i++) {
				if (gcjdxg.equals(arr[i])) {
					gcjd1 = i + 1;
				}
			}
			if (gcjdxg.equals("0") | gcjdxg.equals("请选择") | gcjdxg.equals("") | gcjdxg.equals(0)) {
				sq = "2";
			} else {
				sql1 = "UPDATE  ss_stepset SET 字段名称='" + gcjd1 + "' ,阶段名称 ='" + request.getParameter("jdmcxg")
						+ "' ,负责人='" + request.getParameter("fzrxg") + "' where pguid='" + pguid + "' ";
				sq = XMLToJson.scSql(sql1);
			}

		}
		// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		// 工程进度名称删除
		if (operator1 != null && operator1.equals("工程进度名称删除")) {
			pguid = pguid.substring(0);
			String[] numberArray = pguid.split(",");
			String pguidsql = "pguid='" + numberArray[0] + "'  ";
			for (int i = 1; i < numberArray.length; i++) {
				pguidsql += "   or pguid='" + numberArray[i] + "'";
			}
			String sql = "DELETE FROM ss_stepset where " + pguidsql;
			XMLToJson.scSql(sql);
			String sqldata = "select * from ss_stepset";
			sq = XMLToJson.jieduanQuery(sqldata);

		}
		// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		// 软件注册数据插入
		if (operator1 != null && operator1.equals("软件注册数据插入")) {
			String sqlbianhao1 = "select 软件编号  from ss_softregist where 行业='" + request.getParameter("hy")
					+ "' and 专业='" + request.getParameter("zy") + "' and 软件名称='" + request.getParameter("rjmc") + "'";
			String bianhaoresult1 = XMLToJson.QuerySoftBianHao(sqlbianhao1);
			bianhaoresult1 = bianhaoresult1.replace("\"", "");
			bianhaoresult1 = bianhaoresult1.replace("[", "");
			bianhaoresult1 = bianhaoresult1.replace("]", "");

			// 插入语句
			String sql = "INSERT INTO SS_INSTALLATION(行业,专业,安装ID,安装单位名称,安装单位级别,上级单位名称,软件编号,软件名称,安装版本号,安装服务器IP,安装服务器端口,服务端代理程序路径,接入密码,安装日期,安装人,备注,S_UDTIME,PGUID,S_SYTIME,S_MFLAG,ISDELETE) VALUES ('"
					+ request.getParameter("hy") + "','" + request.getParameter("zy") + "','" + pguid2 + "','"
					+ request.getParameter("dwmc") + "','" + request.getParameter("dwjb") + "','"
					+ request.getParameter("sjdw") + "','" + bianhaoresult1 + "','" + request.getParameter("rjmc")
					+ "','" + request.getParameter("bbh") + "','" + request.getParameter("fwip") + "','"
					+ request.getParameter("fwdk") + "','" + request.getParameter("azlj") + "','','"
					+ request.getParameter("azrq") + "','" + request.getParameter("azr") + "','"
					+ request.getParameter("bz") + "','" + GetSysDateTime() + "','" + pguid2 + "','','','0')";

			// 打印返回操作数据库的返回值，1为插入成功，-1为失败
			String a = XMLToJson.scSql(sql);
		}

		// 注册管理页面查询
		if (operator1 != null && operator1.equals("注册查询")) {
			sql1 = "select * from SS_SOFTREGIST where isdelete <> 1";
			sq = XMLToJson.QdataRegist(sql1);
		}
		// 进入注册管理页面全部查询
		if (operator1 != null && operator1.equals("注册管理")) {
			sql1 = "select * from SS_SOFTREGIST where isdelete <> 1";
			sq = XMLToJson.QdataRegist(sql1);
		}
		// 注册管理记录修改查询加载数据
		if (operator1 != null && operator1.equals("注册修改")) {
			sql1 = "select * from SS_SOFTREGIST where PGUID ='" + pguid + "' and isdelete <> 1";
			sq = XMLToJson.QdataRegist(sql1);
		}
		// 注册管理记录修改提交
		if (operator1 != null && operator1.equals("注册修改提交")) {
			String sql = "UPDATE ss_softregist SET 行业='" + hangye + "',专业='" + zhuanye + "',软件编号='" + pguid2
					+ "',软件名称='" + request.getParameter("rjmc") + "',使用级别='" + request.getParameter("syjb") + "',端类别='"
					+ request.getParameter("dlb") + "',WEB项目名='" + request.getParameter("xmm") + "',注册版本号='"
					+ request.getParameter("bbh") + "',软件说明='" + request.getParameter("rjsm") + "'" + ",S_UDTIME='"
					+ GetSysDateTime() + "' where PGUID='" + pguid + "'";
			// 打印返回操作数据库的返回值，1为插入成功，-1为失败
			sq = XMLToJson.scSql(sql);
		}

		// 注册记录删除
		if (operator1 != null && operator1.equals("注册记录删除")) {
			pguid = pguid.substring(0);
			String[] numberArray = pguid.split(",");
			String pguidsql = "pguid='" + numberArray[0] + "'  ";
			for (int i = 1; i < numberArray.length; i++) {
				pguidsql += "   or pguid='" + numberArray[i] + "'";
			}
			String sql = "DELETE FROM SS_SOFTREGIST where " + pguidsql;
			XMLToJson.scSql(sql);
			String sqldata = "select * from SS_SOFTREGIST where isdelete <> 1";
			sq = XMLToJson.QdataRegist(sqldata);
		}

		// 注册记录查询
		if (operator1 != null && operator1.equals("注册记录查询")) {
			if (hangye.equals("请选择")) {
				sql1 = "select * from SS_SOFTREGIST where isdelete <> 1";
			} else {
				if (zhuanye.equals("请选择")) {
					sql1 = "select * from SS_SOFTREGIST  where 行业='" + hangye + "' and isdelete <> 1";
				} else {
					if (rjmc.equals("请选择") || rjmc.equals("无选项")) {
						sql1 = "select * from SS_SOFTREGIST  where 行业='" + hangye + "' and 专业='" + zhuanye
								+ "' and isdelete <> 1";
					} else {
						sql1 = "select * from SS_SOFTREGIST  where 行业='" + hangye + "' and 专业='" + zhuanye
								+ "'  and 软件名称='" + rjmc + "' and isdelete <> 1";

					}
				}
			}
			sq = XMLToJson.QdataRegist(sql1);
		}
		// 管理员进行人员注册
		String editYesOrNo = "可编辑";
		if (operator1 != null && operator1.equals("人员注册")) {
			sql1 = "select * from ss_user where 部门='" + bmadd + "' and 用户名='" + username + "'";
			sq = XMLToJson.QdataUser(sql1);
			if (!sq.equals("[[\"无选项\",\"无选项\"]]")) {
				sq = "已存在";
			} else {
				quanxian = quanxian.substring(0, quanxian.length() - 1);
				if (quanxian.indexOf("不可编辑") >= 0) {
					quanxian = quanxian.replace(",不可编辑", "");
					editYesOrNo = "不可编辑";
				}
				quanxian.replace(",", ".");
				sql1 = "insert into  ss_user (部门,用户名,权限,密码,是否编辑)values ('" + bmadd + "','" + username + "','" + quanxian
						+ "','111111','" + editYesOrNo + "')";

				sq = XMLToJson.scSql(sql1);
			}
		}
		// 查询部门名称++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		if (operator1 != null && operator1.equals("查询部门名称信息")) {
			sql1 = "select * from ss_Department  order by SHOWINDEX";
			sq = XMLToJson.QdataDepartmentTable(sql1);
		}

		// 部门名称添加+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		if (operator1 != null && operator1.equals("部门名称添加")) {
			sql1 = "select * from ss_Department where  部门名称='" + department + "'";
			sq = XMLToJson.QdataDepartmentTable(sql1);
			if (!sq.equals("[]")) {
				sq = "已存在";
			} else {
				sql1 = "insert into  ss_department (部门名称,PGUID,S_UDTIME)values ('" + department + "','" + pguid2 + "','"
						+ GetSysDateTime() + "')";
				sq = XMLToJson.scSql(sql1);
			}
		}
		// 部门名称删除+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		if (operator1 != null && operator1.equals("部门名称删除记录")) {
			pguid = pguid.substring(0);
			String[] numberArray = pguid.split(",");
			String pguidsql = "PGUID='" + numberArray[0] + "'  ";
			for (int i = 1; i < numberArray.length; i++) {
				pguidsql += "   or PGUID='" + numberArray[i] + "'";
			}
			String sql2 = "DELETE FROM ss_user where 部门    in  (select 部门名称   from  ss_department where " + pguidsql
					+ " )";
			System.out.println(sql2);
			XMLToJson.scSql(sql2);
			String sql = "DELETE FROM ss_department where " + pguidsql;
			System.out.println(sql);
			XMLToJson.scSql(sql);
			sql1 = "select * from ss_department  order by SHOWINDEX";
			sq = XMLToJson.QdataDepartmentTable(sql1);
		}

		// 软件管理查询
		if (operator1 != null && operator1.equals("软件管理查询")) {
			sql1 = "select * from ss_installation where isdelete <> 1 order by 安装日期 desc";
			sq = XMLToJson.QdataIntall(sql1);
		}
		// 安装记录查询
		if (operator1 != null && operator1.equals("安装记录查询")) {
			if (hangye.equals("请选择")) {
				sql1 = "select * from ss_installation where isdelete <> 1 order by 安装日期 desc";
				sq = XMLToJson.QdataIntall(sql1);
			} else {
				if (!hangye.equals("请选择") && zhuanye.equals("请选择")) {
					sql1 = "select * from ss_installation  where 行业='" + hangye
							+ "' and isdelete <> 1 order by 安装日期 desc";
					sq = XMLToJson.QdataIntall(sql1);
				} else {
					if (!hangye.equals("请选择") && !zhuanye.equals("请选择") & rjmc.equals("请选择")) {
						sql1 = "select * from ss_installation  where 行业='" + hangye + "' and 专业='" + zhuanye
								+ "' and isdelete <> 1 order by 安装日期 desc";
						sq = XMLToJson.QdataIntall(sql1);
					} else {
						sql1 = "select * from ss_installation  where 行业='" + hangye + "' and 专业='" + zhuanye
								+ "'  and 软件名称='" + rjmc + "' and isdelete <> 1 order by 安装日期 desc";
						sq = XMLToJson.QdataIntall(sql1);
					}
				}
			}

		}
		// 软件管理上级单位查询
		if (operator1 != null && operator1.equals("上级单位查询")) {
			sql1 = " select distinct 上级单位名称 from ss_installation where 上级单位名称 is not null order by 上级单位名称";
			sq = XMLToJson.QdataIntall(sql1);
		}
		// 软件管理单位名称查询
		if (operator1 != null && operator1.equals("单位名称查询")) {
			sql1 = "  select distinct 安装单位名称 from ss_installation where 上级单位名称='" + sjdw1
					+ "' and 安装单位名称 is not null order by 安装单位名称";
			sq = XMLToJson.QdataIntall(sql1);
		}
		// 安装管理条件查询
		if (operator1 != null && operator1.equals("安装记录查询1")) {
			/// '''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''
			if (hangye.equals("请选择") && sjdw1.equals("请选择") && dwmc.equals("请选择")) {
				sql1 = "select * from ss_installation where isdelete <> 1 order by 安装日期 desc";
			} else if (hangye.equals("请选择") && !sjdw1.equals("请选择") && dwmc.equals("请选择")) {
				sql1 = "select * from ss_installation where 上级单位名称='" + sjdw1
						+ "' and isdelete <> 1 order by 安装日期 desc";
			} else if (hangye.equals("请选择") && !sjdw1.equals("请选择") && !dwmc.equals("请选择")) {
				sql1 = "select * from ss_installation where 安装单位名称='" + dwmc + "'and 上级单位名称='" + sjdw1
						+ "' and  isdelete <> 1 order by 安装日期 desc";
			} else if (!hangye.equals("请选择") && sjdw1.equals("请选择") && dwmc.equals("请选择")) {
				if (zhuanye.equals("请选择") && rjmc.equals("请选择")) {
					sql1 = "select * from ss_installation where 行业='" + hangye
							+ "'and isdelete <> 1 order by 安装日期 desc";
				} else if (!zhuanye.equals("请选择") && rjmc.equals("请选择")) {
					sql1 = "select * from ss_installation  where 行业='" + hangye + "'and 专业='" + zhuanye
							+ "' and isdelete <> 1 order by 安装日期 desc";
				} else if (!zhuanye.equals("请选择") && !rjmc.equals("请选择")) {
					sql1 = "select * from ss_installation where 行业='" + hangye + "'and 专业='" + zhuanye + "' and 软件名称='"
							+ rjmc + "' and isdelete <> 1 order by 安装日期 desc";
				}
			} else if (!hangye.equals("请选择") && !sjdw1.equals("请选择") && dwmc.equals("请选择")) {
				if (zhuanye.equals("请选择") && rjmc.equals("请选择")) {
					sql1 = "select * from ss_installation  where 行业='" + hangye + "'and 上级单位名称='" + sjdw1
							+ "' and isdelete <> 1 order by 安装日期 desc";
				} else if (!zhuanye.equals("请选择") && rjmc.equals("请选择")) {
					sql1 = "select * from ss_installation  where 行业='" + hangye + "'and 专业='" + zhuanye
							+ "' and 上级单位名称='" + sjdw1 + "' and isdelete <> 1 order by 安装日期 desc";
				} else if (!zhuanye.equals("请选择") && !rjmc.equals("请选择")) {
					sql1 = "select * from ss_installation  where 行业='" + hangye + "'and 专业='" + zhuanye
							+ "' and 上级单位名称='" + sjdw1 + "' and 软件名称='" + rjmc
							+ "' and isdelete <> 1 order by 安装日期 desc";
				}
			} else if (!hangye.equals("请选择") && !sjdw1.equals("请选择") && !dwmc.equals("请选择")) {
				if (zhuanye.equals("请选择") && rjmc.equals("请选择")) {
					sql1 = "select * from ss_installation  where 行业='" + hangye + "'and 上级单位名称='" + sjdw1
							+ "' and 安装单位名称='" + dwmc + "' and isdelete <> 1 order by 安装日期 desc";
				} else if (!zhuanye.equals("请选择") && rjmc.equals("请选择")) {
					sql1 = "select * from ss_installation  where 行业='" + hangye + "'and 专业='" + zhuanye
							+ "' and 上级单位名称='" + sjdw1 + "' and 安装单位名称='" + dwmc
							+ "' and isdelete <> 1 order by 安装日期 desc";
				} else if (!zhuanye.equals("请选择") && !rjmc.equals("请选择")) {
					sql1 = "select * from ss_installation  where 行业='" + hangye + "'and 专业='" + zhuanye + "' and 软件名称='"
							+ rjmc + "'and 上级单位名称='" + sjdw1 + "'and 安装单位名称='" + dwmc
							+ "' and isdelete <> 1 order by 安装日期 desc";
				}
			} else {
				sql1 = "select * from ss_installation where isdelete <> 1 order by 安装日期 desc";
			}
			sq = XMLToJson.QdataIntall(sql1);
		}
		// 安装记录修改查询加载数据
		if (operator1 != null && operator1.equals("安装修改")) {
			sql1 = "select * from ss_installation where PGUID ='" + pguid + "' and isdelete <> 1 order by 安装日期  desc";
			sq = XMLToJson.QdataCHQuery2(sql1);
		}
		// 修改安装记录
		if (operator1 != null && operator1.equals("修改安装记录")) {
			String sqlbianhao = "select 软件编号  from ss_softregist where 行业='" + hangye + "' and 专业='" + zhuanye
					+ "' and 软件名称='" + rjmc + "'";
			String bianhaoresult = XMLToJson.QuerySoftBianHao(sqlbianhao);
			bianhaoresult = bianhaoresult.replace("\"", "");
			bianhaoresult = bianhaoresult.replace("[", "");
			bianhaoresult = bianhaoresult.replace("]", "");

			String sql = "UPDATE ss_installation SET 行业='" + hangye + "',专业='" + zhuanye + "',安装ID='" + pguid + "',"
					+ "安装单位名称='" + request.getParameter("dwmc") + "',安装单位级别='" + request.getParameter("dwjb")
					+ "',上级单位名称='" + request.getParameter("sjdw") + "',软件编号='" + bianhaoresult + "',软件名称='" + rjmc
					+ "',安装版本号='" + request.getParameter("bbh") + "',安装服务器IP='" + request.getParameter("fwip")
					+ "',安装服务器端口='" + request.getParameter("fwdk") + "',服务端代理程序路径='" + request.getParameter("azlj")
					+ "',接入密码='',安装日期='" + request.getParameter("azrq") + "',安装人='" + request.getParameter("azr")
					+ "',备注='" + request.getParameter("bz") + "'" + ",S_UDTIME='" + GetSysDateTime()
					+ "',S_SYTIME='',S_MFLAG='',ISDELETE='0'  where PGUID='" + pguid + "'";
			// 打印返回操作数据库的返回值，1为插入成功，-1为失败 ,问题类型分属类型='"+
			System.out.println(sql);
			sq = XMLToJson.scSql(sql);
		}
		// 安装删除记录
		if (operator1 != null && operator1.equals("安装删除记录")) {
			pguid = pguid.substring(0);
			String[] numberArray = pguid.split(",");
			String pguidsql = "pguid='" + numberArray[0] + "'  ";
			for (int i = 1; i < numberArray.length; i++) {
				pguidsql += "   or pguid='" + numberArray[i] + "'";
			}
			String sql = "DELETE FROM SS_INSTALLATION  where " + pguidsql;
			sq = XMLToJson.scSql(sql);
			/*
			 * String sqldata =
			 * "select * from ss_installation where isdelete <> 1 order by 安装日期 desc"
			 * ; sq = XMLToJson.QdataIntall(sqldata);
			 */
		}

		String sjdw = request.getParameter("sjdwadd");
		String dwjbadd = request.getParameter("dwjbadd");

		// 工程实施查询数据
		if (operator1 != null && operator1.equals("工程实施查询数据")) {
			if (dwmc != null && dwmc.equals("请选择")) {
				sql1 = " select *  from SS_IMPLEMENT where 行业='" + hangye + "'  and 专业='" + zhuanye + "' and 软件名称='"
						+ rjmc + "'order by 单位名称 ";
			} /*
				 * else if (dwmc != null && dwmc.equals("中国铁路总公司")) { sql1 =
				 * " select * from SS_IMPLEMENT where 行业='" + hangye +
				 * "'and 专业='" + zhuanye + "' and 软件名称='" + rjmc +
				 * "' and 单位名称='中国铁路总公司' order  by 单位级别 "; }
				 */ else {
				sql1 = " select *  from SS_IMPLEMENT where 行业='" + hangye + "'  and 专业='" + zhuanye + "' and 软件名称='"
						+ rjmc + "' and 单位名称='" + dwmc + "' or 上级单位=(select pguid from SS_IMPLEMENT  where   行业='"
						+ hangye + "'  and 专业='" + zhuanye + "' and 软件名称='" + rjmc + "' and 单位名称='" + dwmc
						+ "') order by 单位名称";
			}
			System.out.println(sql1);
			sq = XMLToJson.impTableQuery(sql1);
		}

		// 工程实施数据插入
		if (operator1 != null && operator1.equals("工程实施数据插入")) {
			// zhe以后要修改为通过行业专业一步一步的查询得到这两个数组在进行使用级别（单位级别）转换数字
			String[] arr = { "总公司", "路局", "电务段", "车间", "班组", "个人" };
			String[] arr2 = { "总公司", "路局", "通信段", "车间", "班组", "个人" };
			int unitGread = 0;
			if (request.getParameter("zyadd").equals("信号")) {
				for (int i = 0; i < arr.length; i++) {
					if (dwjbadd.equals(arr[i])) {
						unitGread = i + 1;
					}
				}
			}
			if (request.getParameter("zyadd").equals("通信")) {
				for (int i = 0; i < arr2.length; i++) {
					if (dwjbadd.equals(arr2[i])) {
						unitGread = i + 1;
					}
				}
			}
			sql1 = " select *  from SS_IMPLEMENT where 行业='" + request.getParameter("hyadd") + "'  and 专业='"
					+ request.getParameter("zyadd") + "' and 软件名称='" + request.getParameter("rjxtadd") + "'and 单位名称='"
					+ request.getParameter("dwmcadd") + "'and 单位级别='" + unitGread + "'order by 单位名称 ";
			sq = XMLToJson.impTableQuery(sql1);
			// 查询出添加的行业妆业软件名称，单位名称下的pguid，pguid 赋给上级单位
			String sql2 = " select *  from SS_IMPLEMENT where 行业='" + request.getParameter("hyadd") + "'  and 专业='"
					+ request.getParameter("zyadd") + "' and 软件名称='" + request.getParameter("rjxtadd") + "'and 单位名称='"
					+ sjdw + "'order by 单位名称 ";
			String sq2 = XMLToJson.implementPGUIDQuery(sql2);
			if (sq2.equals("[]")) {
				sq2 = "";
			}
			if (sq.equals("[]")) {
				sql1 = "insert into SS_IMPLEMENT (行业,专业,软件名称,单位名称,上级单位,单位级别,施工计划,联系人,公司负责人,工程备注,一阶段,二阶段,三阶段,四阶段,五阶段,六阶段,七阶段,八阶段,九阶段,十阶段,进度备注,S_UDTIME,PGUID)"
						+ "values " + "('" + request.getParameter("hyadd") + "','" + request.getParameter("zyadd")
						+ "','" + request.getParameter("rjxtadd") + "','" + request.getParameter("dwmcadd") + "','" // 单位名称
						+ sq2 + "',"// 上级单位，指的是单位名称的上级单位
						+ unitGread + ",'"// 指的是单位名称的级别
						+ request.getParameter("sgsjadd") + "','" + request.getParameter("lxradd") + "','"
						+ request.getParameter("zblxradd") + "','" + request.getParameter("bzadd")
						+ "','','','','','','','','','','','','" + GetSysDateTime() + "','" + pguid2 + "')";
				sq = XMLToJson.scSql(sql1);
			} else {
				sq = "2";
			}

		}

		// 工程实施删除记录
		if (operator1 != null && operator1.equals("工程实施删除记录")) {
			pguid = pguid.substring(0);
			String[] numberArray = pguid.split(",");
			String pguidsql = "pguid='" + numberArray[0] + "'  ";
			for (int i = 1; i < numberArray.length; i++) {
				pguidsql += "   or pguid='" + numberArray[i] + "'";
			}
			String sql = "DELETE FROM ss_implement  where " + pguidsql;
			XMLToJson.scSql(sql);
			if (dwmc != null && dwmc.equals("请选择")) {
				sql1 = " select *  from SS_IMPLEMENT where 行业='" + hangye + "'  and 专业='" + zhuanye + "' and 软件名称='"
						+ rjmc + "'order by 单位名称 ";
				sq = XMLToJson.impTableQuery(sql1);
			} else {
				sql1 = " select *  from SS_IMPLEMENT where 行业='" + hangye + "'  and 专业='" + zhuanye + "' and 软件名称='"
						+ rjmc + "' and 单位名称='" + dwmc + "' or 上级单位=(select pguid from SS_IMPLEMENT  where   行业='"
						+ hangye + "'  and 专业='" + zhuanye + "' and 软件名称='" + rjmc + "' and 单位名称='" + dwmc
						+ "') order by 单位名称";
				sq = XMLToJson.impTableQuery(sql1);
			}
		}

		// 工程实施修改查询加载数据
		if (operator1 != null && operator1.equals("工程实施修改")) {
			sql1 = "select * from ss_implement where PGUID ='" + pguid + "'";
			sq = XMLToJson.impTableQuerych(sql1);
		}
		// 工程实施修改提交
		if (operator1 != null && operator1.equals("工程实施修改提交")) {
			String[] arr = { "总公司", "路局", "电务段", "车间", "班组", "个人" };
			String[] arr2 = { "总公司", "路局", "通信段", "车间", "班组", "个人" };
			int unitGread = 0;
			if (request.getParameter("zyadd").equals("信号")) {
				for (int i = 0; i < arr.length; i++) {
					if (dwjbadd.equals(arr[i])) {
						unitGread = i + 1;
					}
				}
			}
			if (request.getParameter("zyadd").equals("通信")) {
				for (int i = 0; i < arr2.length; i++) {
					if (dwjbadd.equals(arr2[i])) {
						unitGread = i + 1;
					}
				}
			}
			/*
			 * int unitGread = 0; if (dwjbadd != null && dwjbadd.equals("铁总")) {
			 * unitGread = 1; } if (dwjbadd != null && dwjbadd.equals("局")) {
			 * unitGread = 2; } if (dwjbadd != null && dwjbadd.equals("段")) {
			 * unitGread = 3; }
			 */

			// 查询出添加的行业妆业软件名称，单位名称下的pguid，pguid 赋给上级单位
			String sql2 = " select *  from SS_IMPLEMENT where 行业='" + request.getParameter("hyadd") + "'  and 专业='"
					+ request.getParameter("zyadd") + "' and 软件名称='" + request.getParameter("rjxtadd") + "'and 单位名称='"
					+ sjdw + "'order by 单位名称 ";
			String sq2 = XMLToJson.implementPGUIDQuery(sql2);
			if (sq2.equals("[]")) {
				sq2 = "";
			}
			// 查询出添加的行业妆业软件名称，单位名称下的pguid，pguid 赋给上级单位
			sql1 = "UPDATE SS_IMPLEMENT set 行业='" + request.getParameter("hyadd") + "'," + "专业='"
					+ request.getParameter("zyadd") + "'," + "软件名称='" + request.getParameter("rjxtadd") + "',"
					+ "单位名称='" + request.getParameter("dwmcadd") + "'," + "上级单位='" + sq2 + "'," + "单位级别='" + unitGread
					+ "'," + "施工计划='" + request.getParameter("sgsjadd") + "'," + "联系人='"
					+ request.getParameter("lxradd") + "'," + "公司负责人='" + request.getParameter("zblxradd") + "',"
					+ "工程备注='" + request.getParameter("bzadd") + "'where PGUID='" + pguid + "'";
			sq = XMLToJson.scSql(sql1);
		}

		// +++++++++++++++++++++++++++++++++++++++++++++++++++//
		// 用户信息修改
		if (operator1 != null && operator1.equals("用户信息修改")) {
			sql1 = "select * from ss_user where userid ='" + pguid + "'";
			sq = XMLToJson.QdataUser(sql1);
		}
		String editYesOrNox = "可编辑";
		if (operator1 != null && operator1.equals("人员注册修改")) {
			quanxian = quanxian.substring(0, quanxian.length() - 1);
			if (quanxian.indexOf("不可编辑") >= 0) {
				quanxian = quanxian.replace(",不可编辑", "");
				editYesOrNox = "不可编辑";
			}
			quanxian.replace(",", ".");
			sql1 = "update  ss_user set 部门='" + bmadd + "',用户名='" + username + "',权限='" + quanxian + "',是否编辑='"
					+ editYesOrNox + "' where userid='" + pguid + "'";

			sq = XMLToJson.scSql(sql1);
		}
		// +++++++++++++++++++++++++++++++++++++++++++++++++++//
		// 进度实施查询数据
		if (operator1 != null && operator1.equals("进度实施查询")) {
			sql1 = " select * from ss_stepset  where  行业='" + hangye + "'and 专业='" + zhuanye + "' and 软件名称='" + rjmc
					+ "'order by 字段名称";

			String sqjieduanname = XMLToJson.tableQuery(sql1);
			String rjname = null;
			if (rjmc != null && !rjmc.equals("请选择") && dwmc.equals("请选择")) {
				sql1 = " select * from SS_IMPLEMENT where 行业='" + hangye + "'and 专业='" + zhuanye + "' and 软件名称='" + rjmc
						+ "'  order by 单位级别";

				rjname = XMLToJson.tabledataQuery(sql1, sqjieduanname);
			} /*
				 * else if (rjmc != null && rjmc.equals("中国铁路总公司")) { sql1 =
				 * " select * from SS_IMPLEMENT where 行业='" + hangye +
				 * "'and 专业='" + zhuanye + "' and 软件名称='" + rjmc +
				 * "' and 单位名称='中国铁路总公司' order  by 单位级别 "; rjname =
				 * XMLToJson.tabledataQuery(sql1, sqjieduanname); }
				 */
			else {
				sql1 = " select * from SS_IMPLEMENT where 行业='" + hangye + "'and 专业='" + zhuanye + "' and 软件名称='" + rjmc
						+ "' and 单位名称='" + dwmc + "' or 上级单位=(select pguid from SS_IMPLEMENT  where   行业='" + hangye
						+ "'  and 专业='" + zhuanye + "' and 软件名称='" + rjmc + "' and 单位名称='" + dwmc
						+ "') order  by 单位级别 ";
				rjname = XMLToJson.tabledataQuery(sql1, sqjieduanname);
			}
			sq = "[" + sqjieduanname + "," + rjname + "]";
		}
		// 阶段进度完成更新
		if (operator1 != null && operator1.equals("阶段进度完成更新")) {
			sql1 = "UPDATE  SS_IMPLEMENT SET " + request.getParameter("cellnameOracle") + "='"+ request.getParameter("value") + "'where pguid='" + tablepguid + "'";
			sq = XMLToJson.scSql(sql1);
		}
		// ...................................................................问题查询按钮1........................................................................................
		if (wentiquery != null && wentiquery.equals("问题查询按钮1")) {
			 System.out.println(fslx+  rjxt+wtcause+dwcx+sfjj);
			 //关于单位 原来指的是现在的上级单位，但是现在的上级单位不但能代替原来的，所有新添加一个字段  判断级别   ,它把 问题分为两个级别，铁总和路局，可以代替原来的单位，现在数据库是上级单位
			if (fslx != null && (fslx.equals("软件问题") || fslx.equals("用户使用") || fslx.equals("用户需求")|| fslx.equals("工程安装") || fslx.equals("系统运行问题"))) {
				if(rjxt.equals("请选择")){                 //软件名称=请选择,
					if(wtcause.equals("请选择")){          //软件名称=请选择,发生原因='请选择',
						if(dwcx.equals("请选择")){         //软件名称=请选择,发生原因='请选择',单位名称='请选择',
							if(sfjj.equals("未解决")){     //软件名称=请选择,发生原因='请选择',单位名称='请选择',是否解决='未解决',
								sql1 = "select * from ss_feedbackquestions where 问题类型分属类型='" + fslx+ "'and 是否解决 is null and isdelete <> 1 order by 提出时间  desc";
							}else{                       //软件名称=请选择,发生原因='请选择',单位名称='请选择',是否解决='已解决'
								sql1 = "select * from ss_feedbackquestions where 问题类型分属类型='" + fslx+ "' and 是否解决='已解决'  and isdelete <> 1 order by 提出时间  desc";
							} 
						}else{                          //软件名称=请选择,发生原因='请选择',
							if(sfjj.equals("未解决")){    //软件名称=请选择,发生原因='请选择',单位名称<不等于>'请选择',是否解决='未解决',
								sql1 = "select * from ss_feedbackquestions where 判断级别='"+dwcx+"' and  问题类型分属类型='" + fslx+ "'and 是否解决  is null and isdelete <> 1 order by 提出时间  desc";
							}else{                      //软件名称=请选择,发生原因='请选择',单位名称<不等于>'请选择',是否解决='未解决',
								sql1 = "select * from ss_feedbackquestions where 判断级别='"+dwcx+"' and  问题类型分属类型='" + fslx+ "' and 是否解决='已解决'  and isdelete <> 1 order by 提出时间  desc";
							} 
						} 
					}else{                              //软件名称=请选择,发生原因<不等于>'请选择',
						if(dwcx.equals("请选择")){			//软件名称=请选择,发生原因<不等于>'请选择',单位名称='请选择',
							if(sfjj.equals("未解决")){    //软件名称=请选择,发生原因<不等于>'请选择',单位名称='请选择',是否解决='未解决',
								sql1 = "select * from ss_feedbackquestions where 发生原因='"+wtcause+"' and  问题类型分属类型='" + fslx+ "'and 是否解决  is null and isdelete <> 1 order by 提出时间  desc";
							}else{ 						//软件名称=请选择,发生原因<不等于>'请选择',单位名称='请选择',是否解决='已解决',
								sql1 = "select * from ss_feedbackquestions where 发生原因='"+wtcause+"' and  问题类型分属类型='" + fslx+ "' and 是否解决='已解决'  and isdelete <> 1 order by 提出时间  desc";
							} 
						}else{							//软件名称=请选择,发生原因<不等于>'请选择',单位名称<不等于>'请选择',
							if(sfjj.equals("未解决")){		//软件名称=请选择,发生原因<不等于>'请选择',单位名称<不等于>'请选择',是否解决='未解决',
								sql1 = "select * from ss_feedbackquestions where 发生原因='"+wtcause+"' and 判断级别='"+dwcx+"' and  问题类型分属类型='" + fslx+ "'and 是否解决  is null and isdelete <> 1 order by 提出时间  desc";
							}else{						//软件名称=请选择,发生原因<不等于>'请选择',单位名称<不等于>'请选择',是否解决='已解决',
								sql1 = "select * from ss_feedbackquestions where 发生原因='"+wtcause+"' and 判断级别='"+dwcx+"' and  问题类型分属类型='" + fslx+ "' and 是否解决='已解决'  and isdelete <> 1 order by 提出时间  desc";
							} 
						} 
					} 
				}else{                 					//软件名称<不等于>请选择,
					if(wtcause.equals("请选择")){			//软件名称<不等于>请选择,发生原因='请选择',
						if(dwcx.equals("请选择")){			//软件名称<不等于>请选择,发生原因='请选择',单位名称='请选择',
							if(sfjj.equals("未解决")){	    //软件名称<不等于>请选择,发生原因='请选择',单位名称='请选择',是否解决='未解决',
								sql1 = "select * from ss_feedbackquestions where 行业='"+hy+"' and 专业='"+zy+"' and 软件系统='"+rjxt+"' and  问题类型分属类型='" + fslx+ "'and 是否解决  is null and isdelete <> 1 order by 提出时间  desc";
							}else{						//软件名称<不等于>请选择,发生原因<不等于>'请选择',单位名称='请选择',是否解决='已解决',
								sql1 = "select * from ss_feedbackquestions where 行业='"+hy+"' and 专业='"+zy+"' and 软件系统='"+rjxt+"' and  问题类型分属类型='" + fslx+ "'and 是否解决  ='已解决' and isdelete <> 1 order by 提出时间  desc";
							} 
						}else{							//软件名称<不等于>请选择,发生原因='请选择',单位名称<不等于>'请选择',
							if(sfjj.equals("未解决")){		//软件名称<不等于>请选择,发生原因='请选择',单位名称<不等于>'请选择',是否解决='未解决',
								sql1 = "select * from ss_feedbackquestions where 行业='"+hy+"' and 专业='"+zy+"' and 软件系统='"+rjxt+"' and 判断级别='"+dwcx+"' and  问题类型分属类型='" + fslx+ "'and 是否解决  is null and isdelete <> 1 order by 提出时间  desc";
							}else{						//软件名称<不等于>请选择,发生原因='请选择',单位名称<不等于>'请选择',是否解决='已解决',
								sql1 = "select * from ss_feedbackquestions where 行业='"+hy+"' and 专业='"+zy+"' and 软件系统='"+rjxt+"' and 判断级别='"+dwcx+"' and  问题类型分属类型='" + fslx+ "'and 是否解决  ='已解决' and isdelete <> 1 order by 提出时间  desc";
							} 
						} 
					}else{								//软件名称<不等于>请选择,发生原因<不等于>'请选择',
						if(dwcx.equals("请选择")){			//软件名称<不等于>请选择,发生原因<不等于>'请选择',单位名称='请选择',
							if(sfjj.equals("未解决")){		//软件名称<不等于>请选择,发生原因<不等于>'请选择',单位名称='请选择',是否解决='未解决',
								sql1 = "select * from ss_feedbackquestions where 行业='"+hy+"' and 专业='"+zy+"' and 软件系统='"+rjxt+"' and 发生原因='"+wtcause+"'  and  问题类型分属类型='" + fslx+ "'and 是否解决  is null and isdelete <> 1 order by 提出时间  desc";
							}else{						//软件名称<不等于>请选择,发生原因<不等于>'请选择',单位名称='请选择',是否解决='已解决',
								sql1 = "select * from ss_feedbackquestions where 行业='"+hy+"' and 专业='"+zy+"' and 软件系统='"+rjxt+"' and 发生原因='"+wtcause+"'  and  问题类型分属类型='" + fslx+ "'and 是否解决  ='已解决' and isdelete <> 1 order by 提出时间  desc";
							} 
						}else{							//软件名称<不等于>请选择,发生原因<不等于>'请选择',单位名称<不等于>'请选择',
							if(sfjj.equals("未解决")){		//软件名称<不等于>请选择,发生原因<不等于>'请选择',单位名称<不等于>'请选择',是否解决='未解决',
								sql1 = "select * from ss_feedbackquestions where 行业='"+hy+"' and 专业='"+zy+"' and 软件系统='"+rjxt+"' and 发生原因='"+wtcause+"'  and 判断级别='"+dwcx+"'  and  问题类型分属类型='" + fslx+ "'and 是否解决  is null and isdelete <> 1 order by 提出时间  desc";
							}else{						//软件名称<不等于>请选择,发生原因<不等于>'请选择',单位名称<不等于>'请选择',是否解决='已解决',
								sql1 = "select * from ss_feedbackquestions where 行业='"+hy+"' and 专业='"+zy+"' and 软件系统='"+rjxt+"' and 发生原因='"+wtcause+"'  and 判断级别='"+dwcx+"'  and  问题类型分属类型='" + fslx+ "'and 是否解决  ='已解决' and isdelete <> 1 order by 提出时间  desc";
							} 
						} 
					} 
				}
			 }
			 sq = XMLToJson.QdataProQuery1(sql1);
		}

		if (quch != null && quch.equals("问题修改前数据查询加载")) {
			sql1 = "select * from ss_feedbackquestions where PGUID ='" + request.getParameter("changesj")
					+ "' and isdelete <> 1 order by 提出时间  desc";
			sq = XMLToJson.QdataCHQuery(sql1);
		}

		if (operator1 != null && operator1.equals("修改记录")) {
			String pdjb="";
			if(request.getParameter("dwdinput").equals("")){
				pdjb="中国铁路总公司";
			}else if (request.getParameter("dwdinput").equals("中国铁路总公司")){
				pdjb=request.getParameter("tljinput");
			}else{
				pdjb=request.getParameter("dwdinput");
			}
			String sql = "UPDATE ss_feedbackquestions SET 判断级别='"+pdjb+"',软件系统='" + request.getParameter("rjxtinput") + "',问题描述='" + request.getParameter("wtms") + "'" + ",备注='"
					+ request.getParameter("bz") + "'" + ",截图='" + request.getParameter("scjt") + "'" + ",单位='"
					+ request.getParameter("tljinput") + "'" + ",上级单位='" + request.getParameter("dwdinput") + "'"// 原来下级单位八月十一日修改
					+ ",部门='" + request.getParameter("cjinput") + "'" + ",人员='" + request.getParameter("xminput") + "'"
					+ ",联系电话='" + request.getParameter("lxdh") + "'" + ",记录人='" + request.getParameter("uname") + "'"
					+ ",行业='" + request.getParameter("hyinput") + "'" + ",专业='" + request.getParameter("zyinput") + "'"
					// 以下三行诗新加的八月五号
					+ ",功能='" + request.getParameter("functinput") + "'" + ",发生原因='"
					+ request.getParameter("causeinput") + "'" + ",程序员反馈='" + request.getParameter("pfeedback") + "'"
					+ ",公司意见='" + request.getParameter("compannyop") + "'" + ",预计完成时间='"
					+ request.getParameter("modifyplan") + "'" + ",解决办法='" + request.getParameter("solution") + "'"
					+ ",提出时间='" + request.getParameter("tjsj") + "',S_UDTIME='" + GetSysDateTime() + "',发生版本='"
					+ request.getParameter("oversion") + "' where PGUID='" + pguid + "'";

			sq = XMLToJson.scSql(sql);
		}
		// 问题删除记录
		if (operator1 != null && operator1.equals("问题删除记录")) {
			pguid = pguid.substring(0);
			String[] numberArray = pguid.split(",");
			String pguidsql = "pguid='" + numberArray[0] + "'  ";
			for (int i = 1; i < numberArray.length; i++) {
				pguidsql += "   or pguid='" + numberArray[i] + "'";
			}
			String sql = "DELETE FROM SS_FEEDBACKQUESTIONS  where " + pguidsql;
			XMLToJson.scSql(sql);
			String sqldata="";
			if (fslx != null && fslx.equals("软件问题")) {
				 sqldata = "select * from ss_feedbackquestions where 问题类型分属类型='软件问题' and isdelete <> 1 order by 提出时间  desc";
			} else if (fslx != null && fslx.equals("用户需求")) {
				 sqldata = "select * from ss_feedbackquestions where 问题类型分属类型='用户需求' and isdelete <> 1 order by 提出时间  desc";
			} else if (fslx != null && fslx.equals("用户使用")) {
				 sqldata = "select * from ss_feedbackquestions where 问题类型分属类型='用户使用' and isdelete <> 1 order by 提出时间  desc";
			} else if (fslx != null && fslx.equals("工程安装")) {
				 sqldata = "select * from ss_feedbackquestions where 问题类型分属类型='工程安装' and isdelete <> 1 order by 提出时间  desc";
			} else {
				 sqldata = "select * from ss_feedbackquestions where isdelete <> 1 order by 提出时间  desc";
			}
			sq = XMLToJson.QdataProQuery1(sqldata);
		}
		//
		// 问题修改是否解决
		if (operator1 != null && operator1.equals("问题解决")) {
			pguid = pguid.substring(0);
			String[] numberArray = pguid.split(",");
			String pguidsql = "pguid='" + numberArray[0] + "'  ";
			for (int i = 1; i < numberArray.length; i++) {
				pguidsql += "   or pguid='" + numberArray[i] + "'";
			}
			String sql = "UPDATE SS_FEEDBACKQUESTIONS SET 解决版本='" + request.getParameter("version")
					+ "' ,是否解决='已解决',解决时间 ='" + sotime + "' where " + pguidsql;
			XMLToJson.scSql(sql);
			String sqldata ;
			if (fslx != null && fslx.equals("软件问题")) {
				 sqldata = "select * from ss_feedbackquestions where 问题类型分属类型='软件问题' and isdelete <> 1 order by 提出时间  desc";
			} else if (fslx != null && fslx.equals("用户需求")) {
				 sqldata = "select * from ss_feedbackquestions where 问题类型分属类型='用户需求' and isdelete <> 1 order by 提出时间  desc";
			} else if (fslx != null && fslx.equals("用户使用")) {
				 sqldata = "select * from ss_feedbackquestions where 问题类型分属类型='用户使用' and isdelete <> 1 order by 提出时间  desc";
			} else if (fslx != null && fslx.equals("工程安装")) {
				 sqldata = "select * from ss_feedbackquestions where 问题类型分属类型='工程安装' and isdelete <> 1 order by 提出时间  desc";
			} else if (fslx != null && fslx.equals("系统运行问题")) {
				 sqldata = "select * from ss_feedbackquestions where 问题类型分属类型='系统运行问题' and isdelete <> 1 order by 提出时间  desc";
			}else {
				 sqldata = "select * from ss_feedbackquestions where isdelete <> 1 order by 提出时间  desc";
			}
			sq = XMLToJson.QdataProQuery1(sqldata);
		}

		// 系统设置进度设置页面： 软件安装阶段添加
		if (operator1 != null && operator1.equals("软件安装阶段添加")) {
			String sql = "select *  from ss_stepset where 行业='" + hangye + "'  and 专业='" + zhuanye + "' and 软件名称='"
					+ request.getParameter("rjxt") + "' and  字段名称=" + request.getParameter("gcjd");
			sq = XMLToJson.jieduanQuery(sql);
			if (gcjd.equals("0") | gcjd.equals("请选择") | gcjd.equals("") | gcjd.equals(0)) {
				PrintWriter out1 = response.getWriter();
				out1.println("2");// 请选择
				out1.close();
			} else if (sq != "[]") {
				sql1 = "UPDATE  ss_stepset SET 字段名称='" + request.getParameter("gcjd") + "' ,阶段名称 ='"
						+ request.getParameter("jdmc") + "' ,负责人='" + request.getParameter("fzr") + "' where 行业='"
						+ hangye + "'  and 专业='" + zhuanye + "' and 软件名称='" + request.getParameter("rjxt")
						+ "' and  字段名称=" + request.getParameter("gcjd");
				sq = XMLToJson.scSql(sql1);
			} else {
				sql1 = "insert into   ss_stepset (行业,专业,软件名称,字段名称,阶段名称,负责人,PGUID)values ('" + hangye + "','" + zhuanye
						+ "','" + request.getParameter("rjxt") + "','" + request.getParameter("gcjd") + "','"
						+ request.getParameter("jdmc") + "','" + request.getParameter("fzr") + "','" + pguid2 + "')";
				sq = XMLToJson.scSql(sql1);
			}

		}
		// ........................七月三十一号 上午 添加
		// 功能设置：应用于软件问题的的选项.....................
		if (operator1 != null && operator1.equals("功能设置添加")) {
			// 判断是否重复，返回“【】” 则不重复可以添加，否则重复；
			String sql = "select *   from ss_function where 行业='" + hy + "'  and 专业='" + zy + "' and 软件名称='" + rjmc
					+ "' and  功能= '" + request.getParameter("function1") + "'";
			sq = XMLToJson.functionQuery(sql);
			if (sq.equals("[]")) {
				sql1 = "insert into  ss_function (行业,专业,软件名称,功能,PGUID,isdelete)  values ('" + hy + "','" + zy + "','"
						+ rjmc + "','" + request.getParameter("function1") + "','" + pguid2 + "','0')";
				sq = XMLToJson.scSql(sql1);                // 插入成功返回"1"，否则返回添加失败；
				if (sq.equals("[\"1\"]")) {
					sql = "select *   from ss_function where 行业='" + hy + "'  and 专业='" + zy + "' and 软件名称='" + rjmc
							+ "'";
					sq = XMLToJson.functionQuery(sql);
				} else {
					sq = "[\"添加失败\"]";
				}
			} else {
				sq = "[\"已存在\"]";
			}

		}
		// ......功能设置查询........七月三十一号下午添加，用于查询显示功能的结果和添加软件问题时的选项...........
		if (operator1 != null && operator1.equals("功能设置查询")) {
			// 判断是否重复，返回“【】” 则不重复可以添加，否则重复；
			String sql = "select * from ss_function where 行业='" + hy + "'  and 专业='" + zy + "' and 软件名称='" + rjmc + "'";
			sq = XMLToJson.functionQuery(sql);

		}
		// 功能名称修改查询数据加载...............七月三十一号添加，用于修改功能名称
		if (operator1 != null && operator1.equals("功能名称修改查询数据加载")) {
			String sql = "select * from ss_function where PGUID='" + request.getParameter("pguid") + "'";
			sq = XMLToJson.functionQuery(sql);
		}
		// 修改功能提交................七月三十一号添加，用于修改提交
		if (operator1 != null && operator1.equals("修改功能提交")) {
			String sql = "select * from ss_function where 功能='" + request.getParameter("functionxg") + "'";
			sq = XMLToJson.functionQuery(sql);
			if (!sq.equals("[]")) {
				sq = "[2]";
			} else {
				sql1 = "UPDATE  ss_function SET 功能='" + request.getParameter("functionxg") + "' where pguid='" + pguid
						+ "' ";
				sq = XMLToJson.scSql(sql1);
			}
		}

		// 八月二号添加 ..................... 系统设置原因设置页面：原因设置删除
		if (operator1 != null && operator1.equals("原因设置删除")) {
			pguid = pguid.substring(0);
			String[] numberArray = pguid.split(",");
			String pguidsql = "pguid='" + numberArray[0] + "'  ";
			for (int i = 1; i < numberArray.length; i++) {
				pguidsql += " or pguid='" + numberArray[i] + "'";
			}
			String sql = "DELETE FROM ss_cause where " + pguidsql;
			XMLToJson.scSql(sql);
			String sqldata = "select * from ss_cause where isdelete <> 1 ";
			sq = XMLToJson.CauseWtlx(sqldata);

		}
		// 八月二号添加............. 功能设置删除
		if (operator1 != null && operator1.equals("功能设置删除")) {
			pguid = pguid.substring(0);
			String[] numberArray = pguid.split(",");
			String pguidsql = "pguid='" + numberArray[0] + "'  ";
			for (int i = 1; i < numberArray.length; i++) {
				pguidsql += "   or pguid='" + numberArray[i] + "'";
			}
			String sql = "DELETE FROM ss_function where " + pguidsql;
			XMLToJson.scSql(sql);
			String sqldata = "select * from ss_function";
			sq = XMLToJson.functionQuery(sqldata);
		}

		if (operator1 != null && (operator1.equals("软件问题添加") || operator1.equals("用户需求添加") || operator1.equals("用户使用添加")
				|| operator1.equals("工程安装添加") || operator1.equals("系统运行问题添加") || operator1.equals("添加"))) {
			String fslx1 = request.getParameter("fslx");
			GetWTBH();
			String CharA[] = { "A", "B", "C", "D", "E" };
			String Softq[] = { "软件问题", "用户需求", "用户使用", "工程安装", "系统运行问题" };
			for (int i = 0; i < Softq.length; i++) {
				if (fslx1.equals(Softq[i])) {
					fslx1 = CharA[i];// 得到 问题类型的编码 大写字母 共五种 ；
				}
			}

			String sqla = "select 单位级别  from BD_AU_单位字典表   where  名称='" + request.getParameter("dwd") + "'";
			sq = XMLToJson.getDWjb(sqla);// 得到小写字母 单位级别的编码
			fslx1 = sq + fslx1;
			StringBuffer sb = new StringBuffer();
			sb.append(resultwtbh).insert(8, fslx1);
			resultwtbh = sb.toString();
			System.out.println("问题编号：" + resultwtbh);
			String pdjb="";
			if(request.getParameter("dwd").equals("")){
				pdjb="中国铁路总公司";
			}else if (request.getParameter("dwd").equals("中国铁路总公司")){
				pdjb=request.getParameter("tlj");
			}else{
				pdjb=request.getParameter("dwd");
			}
			// 结果sb.toSring()为”heaaallo”
			// 原来下级单位八月十一日修改
			String sql = "INSERT INTO SS_FEEDBACKQUESTIONS（判断级别,问题编号,解决办法,预计完成时间,公司意见,程序员反馈,发生原因 ,功能,发生版本,软件系统,问题描述,备注,截图,单位,上级单位,部门,人员,联系电话,记录人,行业,专业,提出时间,PGUID,S_UDTIME,问题类型分属类型)"
					+ "VALUES("
					+ "'"
					+pdjb+ "','"+ resultwtbh + "','" + request.getParameter("solution") + "','" + request.getParameter("modifyplan")
					+ "','" + request.getParameter("compannyop") + "','" + request.getParameter("pfeedback") + "','"
					+ request.getParameter("cause") + "','" + request.getParameter("funct") + "','"
					+ request.getParameter("oversion") + "','" + request.getParameter("rjxt") + "','"
					+ request.getParameter("wtms") + "','" + request.getParameter("bz") + "','"
					+ request.getParameter("scjt") + "','" + request.getParameter("tlj") + "','"
					+ request.getParameter("dwd") + "','" + request.getParameter("cj") + "','"
					+ request.getParameter("xm") + "','" + request.getParameter("lxdh") + "','"
					+ request.getParameter("uname") + "','" + request.getParameter("hy") + "','"
					+ request.getParameter("zy") + "','" + request.getParameter("tjsj") + "','" + pguid2 + "','" // pguid是前台的变量名，
					+ GetSysDateTime() + "','" + request.getParameter("fslx") + "')";
			System.out.println("sql:" + sql);
			sq = XMLToJson.scSql(sql);
		}
		if (operator1 != null && operator1.equals("软件安装阶段查询")) {
			sql1 = " select * from ss_stepset where 行业='" + hangye + "'and 专业='" + zhuanye + "' and 软件名称='"
					+ request.getParameter("rjxt") + "'  order  by 字段名称 ";
			sq = XMLToJson.jieduanQuery(sql1);
		}
		// 查询version，版本号；登录页使用
		if (operator1 != null && operator1.equals("查询version")) {
			sq = "[\"" + getVersion() + "\"]";
		}
		PrintWriter out = response.getWriter();
		out.println(sq);
		System.out.println("wwww  " + sq);
		out.close();
	}

	// de得到版本号,在登录也加载
	public String getVersion() {
		InputStream inputstream = this.getClass().getClassLoader().getResourceAsStream("swsrvconfig.properties");
		Properties p = new Properties();
		try {
			p.load(inputstream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String a = "Ver:" + p.getProperty("version");
		return a;
	}

	/**
	 * 返回系统日期 时间
	 */
	public String GetSysDateTime() {
		DateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINESE);
		return sf.format(new Date());
	}

	int a = 1;
	String resultwtbh = "";// 最终返回结果是 日期+序号
	String oldData = "";

	public String GetWTBH() {
		DateFormat sf = new SimpleDateFormat("yyyyMMdd", Locale.CHINESE);
		resultwtbh = sf.format(new Date());
		if (!oldData.equals(resultwtbh)) {
			a = 1;
		}
		oldData = resultwtbh;
		if (a < 10) {
			resultwtbh += "0" + a;
		} else {
			resultwtbh += a;
		}
		a++;
		return resultwtbh;
	}

	// 处理 POST 方法请求的方法
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);

	}
}
