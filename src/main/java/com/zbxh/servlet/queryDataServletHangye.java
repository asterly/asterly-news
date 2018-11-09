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
		// ������Ӧ��������
		String pguid2 = UUID.randomUUID().toString();
		response.setContentType("text/html;charset=UTF-8");
		String operator1 = request.getParameter("operator1");// ǰ̨���ݹ����Ĳ���ֵ
		String hangye = request.getParameter("hangye");// ��ҵ
		String zhuanye = request.getParameter("zhuanye");// ױҵ
		String rjmc = request.getParameter("rjmc"); // �������
		String syjb = request.getParameter("syjb");// ʹ�ü���
		String wtlxcanshu = request.getParameter("wtlxcanshu");// ǰ̨���ݹ����Ĳ���ֵ
		String wtlxtj = request.getParameter("wtlxtj");// ǰ̨���ݹ����Ĳ���ֵ
		String tjlx = request.getParameter("tjlx");// �ϲ���������
		String dwcxcanshu = request.getParameter("dwcxcanshu");// ��λ��ѯ����
		String dwmcadd = request.getParameter("dwmcadd");
		String fslx = request.getParameter("fslx");// �ϲ������������
		String sa = request.getParameter("sa");
		String sql1;
		String sq = null;///
		if (operator1 != null && operator1.equals("A00")) {
			operator1 = "0";
		}

		// ��ȡinput��λ
		if (operator1 != null && operator1.equals("��ȡinput��λ")) {
			sql1 = " select  distinct ��λ����,��λ����  from SS_IMPLEMENT where ��ҵ='" + hangye + "'  and רҵ='" + zhuanye
					+ "' and �������='" + rjmc + "'  and  ��λ����<=2   order by ��λ����,��λ����";
			sq = XMLToJson.implementQuery(sql1);
			System.out.println("ssdss" + sq);
		}
		// �������ҳ�����,�޸�ʱ�ж��Ƿ��ظ����
		if (operator1 != null && operator1.equals("��������ж��ظ�")) {
			sql1 = " select count(*)  from ss_installation where ��ҵ='" + request.getParameter("hy") + "'  and רҵ='"
					+ request.getParameter("zy") + "' and �������='" + request.getParameter("rjmc") + "'  and  ��װ�汾��='"
					+ request.getParameter("bbh") + "' and ��װ��λ����='" + request.getParameter("dwmcinput")
					+ "'  order by ��װ��λ����,��װ��λ����";
			sq = XMLToJson.QueryDataSql(sql1);
			System.out.println("ssds00000000000000s" + sql1);
			System.out.println("ssd0000000000ss" + sq);
		}

		if (operator1 != null && operator1.equals("�����")) {
			sql1 = "select �����    from ss_softregist where  ��ҵ='" + request.getParameter("hy") + "'  and  רҵ='"
					+ request.getParameter("zy") + "'  and �������='" + request.getParameter("rjmc") + "'  ";
			sq = XMLToJson.QueryDuanLb(sql1);

		} else if (operator1 != null && operator1.equals("IP�˿ںŻ�ȡ")) {
			sswServices service = new sswServices();
			sq = "[\"" + service.getIP() + "\"]";
		}
		// ����ʵʩ��λ�����ѯ-------------------------6��29�����---------------------------------------------
		else if (operator1 != null && operator1.equals("����ʵʩ��λ�����ѯ")) {
			// ��Ҫ����ж�������Ʋ�Ϊ�յ�ʱ�� 7��1�� ��δ��ӣ�֮�����ƣ�Ҳ����ǰֱ̨���ж���ѡ����������Ƹı��ʱ���жϳ�
			// �������=����ѡ�� �����κδ���ֱ�ӷ��أ��������������̨��
			sql1 = " select ʹ�ü���  from ss_softregist where  ��ҵ='" + hangye + "'  and רҵ='" + zhuanye + "' and �������='"
					+ rjmc + "'  and isdelete <> 1";
			sq = XMLToJson.Queryunitlevel(sql1);
		}
		// ----------------�޸������¼����------------------------�޸������¼����-----------------�޸������¼����--------------------
		else if (operator1 != null && operator1.equals("�޸������¼����")) {

			sql1 = " select zyname,zycode  from zy_register where   hycode=(select hycode  from hy_register where   hyname='"
					+ request.getParameter("zhuanyetext") + "' ) and isdelete <> 1";
			sq = XMLToJson.QueryDataZy(sql1);
		}
		// genju�����ϼ���λ��Pguid��ѯ�ϼ���λ����
		else if (operator1 != null && operator1.equals("����Pguid��ѯ�ϼ���λ����")) {
			sql1 = " select ��λ����  from SS_IMPLEMENT  where   pguid='" + request.getParameter("sa") + "'";
			sq = XMLToJson.QueryDataUpUnitName(sql1);
		}

	
	 else if (operator1 != null && operator1.equals("�޸ĵ�λ����")) {
			sql1 = " update ss_implement set �ϼ���λ= '" + request.getParameter("axgunit") + "'  where  ��ҵ='"
					+ request.getParameter("hy") + "'  and  רҵ='" + request.getParameter("zy") + "'  and �������='"
					+ request.getParameter("rjxt") + "' and �ϼ���λ='" + request.getParameter("xgunit") + "' ";
			sq = XMLToJson.scSql(sql1);
		} else if (operator1 != null && operator1.equals("�ϼ���λ")) { // ȥ�ز�ѯ
			String dwjbadd = request.getParameter("dwjbadd");
			// --------------------6��29�޸ģ�118--138��--------------------------------------------------
			// zhe�Ժ�Ҫ�޸�Ϊͨ����ҵרҵһ��һ���Ĳ�ѯ�õ������������ڽ���ʹ�ü��𣨵�λ����ת������
			String[] arr = { "�ܹ�˾", "·��", "�����", "����", "����", "����" };
			String[] arr2 = { "�ܹ�˾", "·��", "ͨ�Ŷ�", "����", "����", "����" };
			int unitGread = 0;
			System.out.println(dwjbadd + "jiuzhege " + request.getParameter("zy"));
			if (request.getParameter("zy").equals("�ź�")) {
				for (int i = 0; i < arr.length; i++) {
					if (dwjbadd.equals(arr[i])) {
						unitGread = i;
					}
				}
			}
			if (request.getParameter("zy").equals("ͨ��")) {
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
			 * dwjbadd.equals("����")) { unitGread = 0; } if (dwjbadd != null &&
			 * dwjbadd.equals("��")) { unitGread = 1; } if (dwjbadd != null &&
			 * dwjbadd.equals("��")) { unitGread = 2; }
			 */
			sql1 = " select  DISTINCT ��λ����  from ss_implement  where ��λ����= '" + unitGread + "' and  ��ҵ='"
					+ request.getParameter("hy") + "'  and  רҵ='" + request.getParameter("zy") + "'  and �������='" + rjmc
					+ "' order by ��λ����";
			sq = XMLToJson.implementQuery(sql1);
		} else if (operator1 != null && operator1.equals("��ѯ��ҵ")) {
			sql1 = " select hyname,hycode  from hy_register where   hycode='" + hangye + "' and isdelete <> 1";
			sq = XMLToJson.QueryDataHy(sql1);

		} else if (operator1 != null && operator1.equals("��ѯרҵ")) {
			sql1 = " select zyname,zycode  from zy_register where   hycode='" + zhuanye + "' and isdelete <> 1";
			sq = XMLToJson.QueryDataZy(sql1);
		} else if (operator1 != null && operator1.equals("�������")) {
			sql1 = " select �������,������ from ss_softregist where  ��ҵ='" + hangye + "'and רҵ='" + zhuanye
					+ "' and isdelete <> 1 order by ������� ";
			sq = XMLToJson.Qdata4(sql1, operator1);
		} else if (operator1 != null && operator1.equals("��ѯʹ�ü���")) {
			sql1 = " select levelname,levelcode from zy_unitlevel where  zycode='" + syjb + "' and isdelete <> 1";
			sq = XMLToJson.QueryDataLevel(sql1);
		}
		// ������ʮһ�����......................
		else if (operator1 != null && operator1.equals("ԭ���������")) {
			sql1 = "select *  from ss_cause where ԭ��='" + request.getParameter("causetj") + "' and isdelete <> 1 ";
			sq = XMLToJson.CauseWtlx(sql1);
			if (sq.equals("[]")) {
				sql1 = "insert into  ss_cause (ԭ��,pguid)values ('" + request.getParameter("causetj") + "','" + pguid2
						+ "')";
				sq = XMLToJson.scSql(sql1);
				if (sq.equals("[\"1\"]")) {
					sql1 = "select *  from ss_cause  where isdelete <> 1 ";
					sq = XMLToJson.CauseWtlx(sql1);
				} else {
					sq = "[\"���벻�ɹ�\"]";
				}
			} else {
				sq = "[\"�Ѵ���\"]";
			}
		}
		// ԭ�����ò�ѯ........ ������ʮһ�����....................
		else if (operator1 != null && operator1.equals("ԭ�����ò�ѯ")) {
			sql1 = "select *  from ss_cause  where isdelete <> 1 ";
			sq = XMLToJson.CauseWtlx(sql1);
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