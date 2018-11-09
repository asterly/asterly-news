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
		// ������Ӧ��������
		response.setContentType("text/html;charset=UTF-8");
		// pguid��ǰ̨�ı������� pguid2���²�����idֵ

		String pguid2 = UUID.randomUUID().toString();
		String sq = "";// ����ǰ̨�Ľ��
		String sql1 = "";// sql��丳ֵ
		String operator1 = request.getParameter("operator1"); // ����ǰ̨���ݵ�ֵ�ں�̨�����жϲ���
		String operator = request.getParameter("operator"); // ����ǰ̨���ݵ�ֵ�ں�̨�����жϲ���
		String hangye = request.getParameter("hangye"); // ��ҵ
		String zhuanye = request.getParameter("zhuanye"); // רҵ
		String rjmc = request.getParameter("rjmc"); // �������
		String dwmc = request.getParameter("dwmc"); // ��λ���ƣ�input��
		String pguid = request.getParameter("pguid"); //
		// �û���¼�����������λ������������
		String unitlogin = request.getParameter("unit");
		String namelogin = request.getParameter("name");
		String pwdlogin = request.getParameter("pwd");
		// ��Աע���������operator1,bmadd(����),username��ע����û�����,check_val��Ȩ�޵�ѡ��
		String bmadd = request.getParameter("bmadd");
		String username = request.getParameter("username");
		String quanxian = request.getParameter("quanxian");
		// ����ʵʩ�޸Ľ׶�����������
		String value = request.getParameter("value");
		String tablepguid = request.getParameter("tablepguid");
		String sotime = request.getParameter("sotime");
		String quch = request.getParameter("quch");// �����޸�
		String gcjd = request.getParameter("gcjd");
		String fslx = request.getParameter("fslx");// �����޸�
		String hy = request.getParameter("hy");// ��ҵ
		String zy = request.getParameter("zy");// רҵ
		String rjxt = request.getParameter("rjxt");// ������ƣ������ѯ�еģ�
		String sjdw1 = request.getParameter("sjdw");
		String wtcause = request.getParameter("wtcause");// ����ԭ�������ѯ�еģ�
		String dwcx = request.getParameter("dwcx");// �����ѯ����λ��
		String sfjj = request.getParameter("sfjj");// �����Ƿ���
		String allcs = request.getParameter("allcs");// ��ѯȫ�����ݲ���
		String department = request.getParameter("department");// �������������
		String wentiquery = request.getParameter("wentiquery");

		// ��״ͼ����״ͼ���ݣ��������������ҳ�棬����ҳ���������ͳ�ƣ���'�������','�û�����','�û�ʹ��','���̰�װ'��
		if (operator1 != null && operator1.equals("ͼ�����ݲ�ѯpie")) {
			if (fslx.equals("") && rjmc.equals("��ѡ��")) {
				sql1 = "select count(*)  as a ,���ϵͳ from ss_feedbackquestions where  isdelete <> 1  group by ���ϵͳ order by ���ϵͳ";
				sq = XMLToJson.BarAndPieSoftNameQuery(sql1);
			} else if (!fslx.equals("") && !rjmc.equals("��ѡ��")) {
				sql1 = "select count(����ԭ��) AS A,����ԭ��    from ss_feedbackquestions  where   ���ϵͳ='" + rjmc
						+ "'  and  �������ͷ������� ='" + fslx + "'  and isdelete <> 1 group by ����ԭ��    order by ����ԭ��";
				sq = XMLToJson.BarAndPiechildQuery(sql1);
			} else {
				sql1 = "select count(*)  as a ,���ϵͳ from ss_feedbackquestions where  isdelete <> 1  group by ���ϵͳ  order by ���ϵͳ";
				sq = XMLToJson.BarAndPieSoftNameQuery(sql1);
			}
		}
		if (operator1 != null && operator1.equals("ͼ�����ݲ�ѯpie1")) {
			if (fslx.equals("") && rjmc.equals("��ѡ��")) {
				sql1 = "select count(*)  as a ,�������ͷ�������  from ss_feedbackquestions where  isdelete <> 1  group by �������ͷ�������  order by �������ͷ������� ";
				sq = XMLToJson.BarAndPieQuery(sql1);
			} else if (!fslx.equals("") && !rjmc.equals("��ѡ��")) {
				sql1 = "select count(����ԭ��) AS A,����ԭ��    from ss_feedbackquestions  where   ���ϵͳ='" + rjmc
						+ "'  and  �������ͷ������� ='" + fslx + "'  and isdelete <> 1 group by ����ԭ��  order by ����ԭ��";
				sq = XMLToJson.BarAndPiechildQuery(sql1);
			} else {
				sql1 = "select count(�������ͷ�������) AS A,�������ͷ�������    from ss_feedbackquestions  where   ���ϵͳ='" + rjmc
						+ "' and isdelete <> 1 group by �������ͷ�������       order by �������ͷ�������";
				sq = XMLToJson.BarAndPieQuery(sql1);
			}

		}
		/// ��ҳ��  ����     ��λ    ��ѯ����     pie 
		/// ������ҳ��ͼ�����ݲ�ѯpie��ҳ��ͼ�����ݲ�ѯpie��ҳ��ͼ�����ݲ�ѯpie��ҳ��ͼ�����ݲ�ѯpie��ҳ��ͼ�����ݲ�ѯpie��ҳ��ͼ�����ݲ�ѯpie
		if (operator1 != null && operator1.equals("��ҳ��ͼ�����ݲ�ѯpie")) {
			if (!rjmc.equals("��ѡ��")) {
				sql1 = "select count(*) AS A,�жϼ���    from ss_feedbackquestions  where   ���ϵͳ='" + rjmc
						+ "'  and  �������ͷ������� ='" + fslx + "'  and isdelete <> 1 group by �жϼ���    order by �жϼ���";
				sq = XMLToJson.BarAndPiechildunitQuery(sql1);
			} else {
				sql1 = "select count(*)  as a ,���ϵͳ from ss_feedbackquestions where  �������ͷ������� ='" + fslx
						+ "'  and isdelete <> 1  group by ���ϵͳ order by ���ϵͳ";
				sq = XMLToJson.BarAndPieSoftNameQuery(sql1);
			}
		}
		if (operator1 != null && operator1.equals("��ҳ��ͼ�����ݲ�ѯpie1")) {
			if (!rjmc.equals("��ѡ��")) {
				sql1 = "select count(*) AS A,����ԭ��    from ss_feedbackquestions  where   ���ϵͳ='" + rjmc
						+ "'  and  �������ͷ������� ='" + fslx + "'  and isdelete <> 1 group by ����ԭ��  order by ����ԭ��";
				sq = XMLToJson.BarAndPiechildQuery(sql1);
			} else {
				//������һ��
				//sql1 = "select count(����ԭ��) AS A,����ԭ��    from ss_feedbackquestions  where    �������ͷ������� ='" + fslx
				//		+ "'  and isdelete <> 1 group by ����ԭ��  order by ����ԭ�� ";
				sql1 = "select count(*) AS A,����ԭ��    from ss_feedbackquestions  where    �������ͷ������� ='" + fslx
						+ "'  and isdelete <> 1 group by ����ԭ��  order by ����ԭ�� ";
				sq = XMLToJson.BarAndPiechildQuery(sql1);
				System.out.println("�������"+sq);
			}
		}
		if (operator1 != null && operator1.equals("ͼ�����ݲ�ѯ")) {
			if (fslx.equals("") && rjmc.equals("��ѡ��")) {
				sql1 = "select ���ϵͳ    from ss_feedbackquestions  where   isdelete <> 1 group by ���ϵͳ";
				sq = XMLToJson.getLegendUnit(sql1);
				sql1 = "select count(*)  as a ,���ϵͳ,�������ͷ������� from ss_feedbackquestions where  isdelete <> 1  group by ���ϵͳ,�������ͷ������� order by �������ͷ�������,���ϵͳ";
				sq = XMLToJson.BarAndPieCESHI(sql1, sq);
			} else if (!fslx.equals("") && !rjmc.equals("��ѡ��")) {
				sql1 = "select count(����ԭ��) AS A,����ԭ��    from ss_feedbackquestions  where   ���ϵͳ='" + rjmc
						+ "'  and  �������ͷ������� ='" + fslx + "'  and isdelete <> 1 group by ����ԭ��";
				sq = XMLToJson.BarAndPiechildQuery(sql1);
			} else {
				sql1 = "select count(�������ͷ�������) AS A,�������ͷ�������    from ss_feedbackquestions  where   ���ϵͳ='" + rjmc
						+ "' and isdelete <> 1 group by �������ͷ������� ";
				sq = XMLToJson.BarAndPieQuery(sql1);
			}
		}

		// �������ͼ���ѯ�ĸ���ҳ�湲��һ��
		if (operator1 != null && operator1.equals("�������ͼ�����ݲ�ѯ")) {
			if (!rjmc.equals("��ѡ��")) {
				sql1 = "select �жϼ���   from ss_feedbackquestions  where  ��ҵ='" + hy + "' and  רҵ= '" + zy + "' and ���ϵͳ='"
						+ rjmc + "' and �������ͷ�������='" + fslx + "'  and   isdelete <> 1  group by �жϼ���   order by �жϼ���";
				sq = XMLToJson.getSoftUnit(sql1);
				System.out.println("zheshi ���Ե�λ����    "+sq);
				sql1 = "select ����ԭ��    from ss_feedbackquestions  where  ��ҵ='" + hy + "' and  רҵ= '" + zy
						+ "' and ���ϵͳ='" + rjmc + "' and �������ͷ�������='" + fslx
						+ "' and   isdelete <> 1 group by ����ԭ��    order by ����ԭ��";
				String sq2 = XMLToJson.getQuestion(sql1);
				System.out.println("  ");
				System.out.println("fashengyuanyin    "+sq2);
					sql1 = "select count(*)  as a ,�жϼ���,����ԭ��  from ss_feedbackquestions where  ��ҵ='" + hy + "' and  רҵ= '"
						+ zy + "' and  ���ϵͳ='" + rjmc + "' and  �������ͷ�������='" + fslx
						+ "' and  isdelete <> 1  group by �жϼ���,����ԭ��   order by ����ԭ��,�жϼ���";
				sq = XMLToJson.ChildSoftUnitBarAndPie(sql1, sq, sq2);
				 
				System.out.println("���ǲ��Ե����ݣ� ��Ҫ���������"+ sq);
			} else {
				sql1 = "select ���ϵͳ    from ss_feedbackquestions  where    isdelete <> 1 group by ���ϵͳ   order by ���ϵͳ";
				sq = XMLToJson.getLegendUnit(sql1);
				System.out.println("222zheshi ���ϵͳ    "+sq);
				sql1 = "select ����ԭ��    from ss_feedbackquestions  where  �������ͷ�������='" + fslx
						+ "' and   isdelete <> 1 group by ����ԭ��    order by ����ԭ��";
				String sq2 = XMLToJson.getQuestion(sql1);
				System.out.println("22fashengyuanyin    "+sq2);
				sql1 = "select count(*)  as a ,���ϵͳ,����ԭ��  from ss_feedbackquestions where �������ͷ�������='" + fslx
						+ "' and  isdelete <> 1  group by ���ϵͳ,����ԭ��   order by ����ԭ��,���ϵͳ";
				sq = XMLToJson.ChildBarAndPieCESHI(sql1, sq, sq2);
			}
		}
	
		if (operator1 != null && operator1.equals("���������ҳ�浥λ��ѯ")) {
			if (rjmc.equals("��ѡ��")) {
				sql1 = "select distinct �жϼ���      from ss_feedbackquestions where  �������ͷ�������='" + fslx
						+ "'  and isdelete <> 1 ";
			} else {
				sql1 = "select distinct �жϼ���        from ss_feedbackquestions where ��ҵ='" + hy + "' and רҵ='" + zy
						+ "'  and  ���ϵͳ='" + rjmc + "'  and �������ͷ�������='" + fslx + "'  and isdelete <> 1 ";
			}
			sq = XMLToJson.QuestitionQuery(sql1);
		}
		// ��������ĸ���ҳ���ȫ��������ʾ
		if (operator1 != null && operator1.equals("��ѯȫ������")) {
			sql1 = "select * from ss_feedbackquestions where pguid='" + allcs
					+ "' and isdelete <> 1 order by ���ʱ��  desc";
			sq = XMLToJson.QdataProQuery(sql1);
		} else if (operator1 != null && operator1.equals("���̰�װ��ѯȫ������")) {
			sql1 = "select * from ss_feedbackquestions where pguid='" + allcs
					+ "' and isdelete <> 1 order by ���ʱ��  desc";
			sq = XMLToJson.QdataProQuerygc(sql1);
		}
		// ��¼������ѯ+++++++++++++++++++++++++++++++++++++++++++
		if (operator1 != null && operator1.equals("��¼������ѯ")) {
			sql1 = "select * from ss_user where ����='" + request.getParameter("unit") + "' order by userid";
			sq = XMLToJson.QdataUser(sql1);

			if (sq.equals("[[\"��ѡ��\",\"��ѡ��\"]]")) {
				sq = "[]";
			}
		}
		// �û���¼�����ж�
		if (operator1 != null && operator1.equals("��¼")) {
			sql1 = "select * from ss_user where �û���='" + namelogin + "' order by userid";
			sq = XMLToJson.QdataUser(sql1);
			if (sq.equals("[[\"��ѡ��\",\"��ѡ��\"]]")) {
				sq = "[\"�û�������ȷ\"]";
			} else {
				sql1 = "select * from ss_user where �û���='" + namelogin + "' and ����= '" + pwdlogin + "'order by userid";
				sq = XMLToJson.QdataUser(sql1);
				if (sq.equals("[[\"��ѡ��\",\"��ѡ��\"]]")) {
					sq = "[\"���벻��ȷ\"]";
				}
			}
		}
		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		// ��ѯ��ע���û�
		if (operator1 != null && operator1.equals("��ѯע���û���Ϣ")) {
			sql1 = "select * from ss_user where not �û���='admin' order by ����,�û���,userid";
			sq = XMLToJson.QdataUserTable(sql1);
		}
		// ע���û���¼ɾ��
		if (operator1 != null && operator1.equals("ע���û�ɾ����¼")) {
			pguid = pguid.substring(0);
			String[] numberArray = pguid.split(",");
			String pguidsql = "userid='" + numberArray[0] + "'  ";
			for (int i = 1; i < numberArray.length; i++) {
				pguidsql += "   or userid='" + numberArray[i] + "'";
			}
			String sql = "DELETE FROM ss_user where " + pguidsql;
			XMLToJson.scSql(sql);

			sql1 = "select * from ss_user where not �û���='admin' order by ����,�û���";
			sq = XMLToJson.QdataUserTable(sql1);

		}

		// �޸�����
		if (operator1 != null && operator1.equals("�޸�����")) {
			sql1 = "select * from ss_user where �û���='" + request.getParameter("uname") + "' and ����= '"
					+ request.getParameter("opwd") + "'";
			sq = XMLToJson.QdataUser(sql1);
			if (sq.equals("[[\"��ѡ��\",\"��ѡ��\"]]")) {
				sq = "2";
			} else {
				String sql = "UPDATE ss_user SET ����='" + request.getParameter("zpwd") + "' where �û���='"
						+ request.getParameter("uname") + "'";
				// ��ӡ���ز������ݿ�ķ���ֵ��1Ϊ����ɹ���-1Ϊʧ��
				sq = XMLToJson.scSql(sql);
			}
		}
		// ���������޸�
		if (operator1 != null && operator1.equals("���������޸�")) {
			sql1 = " select * from ss_stepset where pguid='" + pguid + "' ";
			sq = XMLToJson.jieduanQuery(sql1);
		}
		// �޸Ľ�������
		if (operator1 != null && operator1.equals("�޸Ľ�������")) {
			String gcjdxg = request.getParameter("gcjdxg");
			int gcjd1 = 0;
			String arr[] = { "��һ�׶�", "�ڶ��׶�", "�����׶�", "���Ľ׶�", "����׶�", "�����׶�", "���߽׶�", "�ڰ˽׶�", "�ھŽ׶�", "��ʮ�׶�" };
			for (int i = 0; i < 10; i++) {
				if (gcjdxg.equals(arr[i])) {
					gcjd1 = i + 1;
				}
			}
			if (gcjdxg.equals("0") | gcjdxg.equals("��ѡ��") | gcjdxg.equals("") | gcjdxg.equals(0)) {
				sq = "2";
			} else {
				sql1 = "UPDATE  ss_stepset SET �ֶ�����='" + gcjd1 + "' ,�׶����� ='" + request.getParameter("jdmcxg")
						+ "' ,������='" + request.getParameter("fzrxg") + "' where pguid='" + pguid + "' ";
				sq = XMLToJson.scSql(sql1);
			}

		}
		// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		// ���̽�������ɾ��
		if (operator1 != null && operator1.equals("���̽�������ɾ��")) {
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
		// ���ע�����ݲ���
		if (operator1 != null && operator1.equals("���ע�����ݲ���")) {
			String sqlbianhao1 = "select ������  from ss_softregist where ��ҵ='" + request.getParameter("hy")
					+ "' and רҵ='" + request.getParameter("zy") + "' and �������='" + request.getParameter("rjmc") + "'";
			String bianhaoresult1 = XMLToJson.QuerySoftBianHao(sqlbianhao1);
			bianhaoresult1 = bianhaoresult1.replace("\"", "");
			bianhaoresult1 = bianhaoresult1.replace("[", "");
			bianhaoresult1 = bianhaoresult1.replace("]", "");

			// �������
			String sql = "INSERT INTO SS_INSTALLATION(��ҵ,רҵ,��װID,��װ��λ����,��װ��λ����,�ϼ���λ����,������,�������,��װ�汾��,��װ������IP,��װ�������˿�,����˴������·��,��������,��װ����,��װ��,��ע,S_UDTIME,PGUID,S_SYTIME,S_MFLAG,ISDELETE) VALUES ('"
					+ request.getParameter("hy") + "','" + request.getParameter("zy") + "','" + pguid2 + "','"
					+ request.getParameter("dwmc") + "','" + request.getParameter("dwjb") + "','"
					+ request.getParameter("sjdw") + "','" + bianhaoresult1 + "','" + request.getParameter("rjmc")
					+ "','" + request.getParameter("bbh") + "','" + request.getParameter("fwip") + "','"
					+ request.getParameter("fwdk") + "','" + request.getParameter("azlj") + "','','"
					+ request.getParameter("azrq") + "','" + request.getParameter("azr") + "','"
					+ request.getParameter("bz") + "','" + GetSysDateTime() + "','" + pguid2 + "','','','0')";

			// ��ӡ���ز������ݿ�ķ���ֵ��1Ϊ����ɹ���-1Ϊʧ��
			String a = XMLToJson.scSql(sql);
		}

		// ע�����ҳ���ѯ
		if (operator1 != null && operator1.equals("ע���ѯ")) {
			sql1 = "select * from SS_SOFTREGIST where isdelete <> 1";
			sq = XMLToJson.QdataRegist(sql1);
		}
		// ����ע�����ҳ��ȫ����ѯ
		if (operator1 != null && operator1.equals("ע�����")) {
			sql1 = "select * from SS_SOFTREGIST where isdelete <> 1";
			sq = XMLToJson.QdataRegist(sql1);
		}
		// ע������¼�޸Ĳ�ѯ��������
		if (operator1 != null && operator1.equals("ע���޸�")) {
			sql1 = "select * from SS_SOFTREGIST where PGUID ='" + pguid + "' and isdelete <> 1";
			sq = XMLToJson.QdataRegist(sql1);
		}
		// ע������¼�޸��ύ
		if (operator1 != null && operator1.equals("ע���޸��ύ")) {
			String sql = "UPDATE ss_softregist SET ��ҵ='" + hangye + "',רҵ='" + zhuanye + "',������='" + pguid2
					+ "',�������='" + request.getParameter("rjmc") + "',ʹ�ü���='" + request.getParameter("syjb") + "',�����='"
					+ request.getParameter("dlb") + "',WEB��Ŀ��='" + request.getParameter("xmm") + "',ע��汾��='"
					+ request.getParameter("bbh") + "',���˵��='" + request.getParameter("rjsm") + "'" + ",S_UDTIME='"
					+ GetSysDateTime() + "' where PGUID='" + pguid + "'";
			// ��ӡ���ز������ݿ�ķ���ֵ��1Ϊ����ɹ���-1Ϊʧ��
			sq = XMLToJson.scSql(sql);
		}

		// ע���¼ɾ��
		if (operator1 != null && operator1.equals("ע���¼ɾ��")) {
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

		// ע���¼��ѯ
		if (operator1 != null && operator1.equals("ע���¼��ѯ")) {
			if (hangye.equals("��ѡ��")) {
				sql1 = "select * from SS_SOFTREGIST where isdelete <> 1";
			} else {
				if (zhuanye.equals("��ѡ��")) {
					sql1 = "select * from SS_SOFTREGIST  where ��ҵ='" + hangye + "' and isdelete <> 1";
				} else {
					if (rjmc.equals("��ѡ��") || rjmc.equals("��ѡ��")) {
						sql1 = "select * from SS_SOFTREGIST  where ��ҵ='" + hangye + "' and רҵ='" + zhuanye
								+ "' and isdelete <> 1";
					} else {
						sql1 = "select * from SS_SOFTREGIST  where ��ҵ='" + hangye + "' and רҵ='" + zhuanye
								+ "'  and �������='" + rjmc + "' and isdelete <> 1";

					}
				}
			}
			sq = XMLToJson.QdataRegist(sql1);
		}
		// ����Ա������Աע��
		String editYesOrNo = "�ɱ༭";
		if (operator1 != null && operator1.equals("��Աע��")) {
			sql1 = "select * from ss_user where ����='" + bmadd + "' and �û���='" + username + "'";
			sq = XMLToJson.QdataUser(sql1);
			if (!sq.equals("[[\"��ѡ��\",\"��ѡ��\"]]")) {
				sq = "�Ѵ���";
			} else {
				quanxian = quanxian.substring(0, quanxian.length() - 1);
				if (quanxian.indexOf("���ɱ༭") >= 0) {
					quanxian = quanxian.replace(",���ɱ༭", "");
					editYesOrNo = "���ɱ༭";
				}
				quanxian.replace(",", ".");
				sql1 = "insert into  ss_user (����,�û���,Ȩ��,����,�Ƿ�༭)values ('" + bmadd + "','" + username + "','" + quanxian
						+ "','111111','" + editYesOrNo + "')";

				sq = XMLToJson.scSql(sql1);
			}
		}
		// ��ѯ��������++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		if (operator1 != null && operator1.equals("��ѯ����������Ϣ")) {
			sql1 = "select * from ss_Department  order by SHOWINDEX";
			sq = XMLToJson.QdataDepartmentTable(sql1);
		}

		// �����������+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		if (operator1 != null && operator1.equals("�����������")) {
			sql1 = "select * from ss_Department where  ��������='" + department + "'";
			sq = XMLToJson.QdataDepartmentTable(sql1);
			if (!sq.equals("[]")) {
				sq = "�Ѵ���";
			} else {
				sql1 = "insert into  ss_department (��������,PGUID,S_UDTIME)values ('" + department + "','" + pguid2 + "','"
						+ GetSysDateTime() + "')";
				sq = XMLToJson.scSql(sql1);
			}
		}
		// ��������ɾ��+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		if (operator1 != null && operator1.equals("��������ɾ����¼")) {
			pguid = pguid.substring(0);
			String[] numberArray = pguid.split(",");
			String pguidsql = "PGUID='" + numberArray[0] + "'  ";
			for (int i = 1; i < numberArray.length; i++) {
				pguidsql += "   or PGUID='" + numberArray[i] + "'";
			}
			String sql2 = "DELETE FROM ss_user where ����    in  (select ��������   from  ss_department where " + pguidsql
					+ " )";
			System.out.println(sql2);
			XMLToJson.scSql(sql2);
			String sql = "DELETE FROM ss_department where " + pguidsql;
			System.out.println(sql);
			XMLToJson.scSql(sql);
			sql1 = "select * from ss_department  order by SHOWINDEX";
			sq = XMLToJson.QdataDepartmentTable(sql1);
		}

		// ��������ѯ
		if (operator1 != null && operator1.equals("��������ѯ")) {
			sql1 = "select * from ss_installation where isdelete <> 1 order by ��װ���� desc";
			sq = XMLToJson.QdataIntall(sql1);
		}
		// ��װ��¼��ѯ
		if (operator1 != null && operator1.equals("��װ��¼��ѯ")) {
			if (hangye.equals("��ѡ��")) {
				sql1 = "select * from ss_installation where isdelete <> 1 order by ��װ���� desc";
				sq = XMLToJson.QdataIntall(sql1);
			} else {
				if (!hangye.equals("��ѡ��") && zhuanye.equals("��ѡ��")) {
					sql1 = "select * from ss_installation  where ��ҵ='" + hangye
							+ "' and isdelete <> 1 order by ��װ���� desc";
					sq = XMLToJson.QdataIntall(sql1);
				} else {
					if (!hangye.equals("��ѡ��") && !zhuanye.equals("��ѡ��") & rjmc.equals("��ѡ��")) {
						sql1 = "select * from ss_installation  where ��ҵ='" + hangye + "' and רҵ='" + zhuanye
								+ "' and isdelete <> 1 order by ��װ���� desc";
						sq = XMLToJson.QdataIntall(sql1);
					} else {
						sql1 = "select * from ss_installation  where ��ҵ='" + hangye + "' and רҵ='" + zhuanye
								+ "'  and �������='" + rjmc + "' and isdelete <> 1 order by ��װ���� desc";
						sq = XMLToJson.QdataIntall(sql1);
					}
				}
			}

		}
		// ��������ϼ���λ��ѯ
		if (operator1 != null && operator1.equals("�ϼ���λ��ѯ")) {
			sql1 = " select distinct �ϼ���λ���� from ss_installation where �ϼ���λ���� is not null order by �ϼ���λ����";
			sq = XMLToJson.QdataIntall(sql1);
		}
		// �������λ���Ʋ�ѯ
		if (operator1 != null && operator1.equals("��λ���Ʋ�ѯ")) {
			sql1 = "  select distinct ��װ��λ���� from ss_installation where �ϼ���λ����='" + sjdw1
					+ "' and ��װ��λ���� is not null order by ��װ��λ����";
			sq = XMLToJson.QdataIntall(sql1);
		}
		// ��װ����������ѯ
		if (operator1 != null && operator1.equals("��װ��¼��ѯ1")) {
			/// '''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''
			if (hangye.equals("��ѡ��") && sjdw1.equals("��ѡ��") && dwmc.equals("��ѡ��")) {
				sql1 = "select * from ss_installation where isdelete <> 1 order by ��װ���� desc";
			} else if (hangye.equals("��ѡ��") && !sjdw1.equals("��ѡ��") && dwmc.equals("��ѡ��")) {
				sql1 = "select * from ss_installation where �ϼ���λ����='" + sjdw1
						+ "' and isdelete <> 1 order by ��װ���� desc";
			} else if (hangye.equals("��ѡ��") && !sjdw1.equals("��ѡ��") && !dwmc.equals("��ѡ��")) {
				sql1 = "select * from ss_installation where ��װ��λ����='" + dwmc + "'and �ϼ���λ����='" + sjdw1
						+ "' and  isdelete <> 1 order by ��װ���� desc";
			} else if (!hangye.equals("��ѡ��") && sjdw1.equals("��ѡ��") && dwmc.equals("��ѡ��")) {
				if (zhuanye.equals("��ѡ��") && rjmc.equals("��ѡ��")) {
					sql1 = "select * from ss_installation where ��ҵ='" + hangye
							+ "'and isdelete <> 1 order by ��װ���� desc";
				} else if (!zhuanye.equals("��ѡ��") && rjmc.equals("��ѡ��")) {
					sql1 = "select * from ss_installation  where ��ҵ='" + hangye + "'and רҵ='" + zhuanye
							+ "' and isdelete <> 1 order by ��װ���� desc";
				} else if (!zhuanye.equals("��ѡ��") && !rjmc.equals("��ѡ��")) {
					sql1 = "select * from ss_installation where ��ҵ='" + hangye + "'and רҵ='" + zhuanye + "' and �������='"
							+ rjmc + "' and isdelete <> 1 order by ��װ���� desc";
				}
			} else if (!hangye.equals("��ѡ��") && !sjdw1.equals("��ѡ��") && dwmc.equals("��ѡ��")) {
				if (zhuanye.equals("��ѡ��") && rjmc.equals("��ѡ��")) {
					sql1 = "select * from ss_installation  where ��ҵ='" + hangye + "'and �ϼ���λ����='" + sjdw1
							+ "' and isdelete <> 1 order by ��װ���� desc";
				} else if (!zhuanye.equals("��ѡ��") && rjmc.equals("��ѡ��")) {
					sql1 = "select * from ss_installation  where ��ҵ='" + hangye + "'and רҵ='" + zhuanye
							+ "' and �ϼ���λ����='" + sjdw1 + "' and isdelete <> 1 order by ��װ���� desc";
				} else if (!zhuanye.equals("��ѡ��") && !rjmc.equals("��ѡ��")) {
					sql1 = "select * from ss_installation  where ��ҵ='" + hangye + "'and רҵ='" + zhuanye
							+ "' and �ϼ���λ����='" + sjdw1 + "' and �������='" + rjmc
							+ "' and isdelete <> 1 order by ��װ���� desc";
				}
			} else if (!hangye.equals("��ѡ��") && !sjdw1.equals("��ѡ��") && !dwmc.equals("��ѡ��")) {
				if (zhuanye.equals("��ѡ��") && rjmc.equals("��ѡ��")) {
					sql1 = "select * from ss_installation  where ��ҵ='" + hangye + "'and �ϼ���λ����='" + sjdw1
							+ "' and ��װ��λ����='" + dwmc + "' and isdelete <> 1 order by ��װ���� desc";
				} else if (!zhuanye.equals("��ѡ��") && rjmc.equals("��ѡ��")) {
					sql1 = "select * from ss_installation  where ��ҵ='" + hangye + "'and רҵ='" + zhuanye
							+ "' and �ϼ���λ����='" + sjdw1 + "' and ��װ��λ����='" + dwmc
							+ "' and isdelete <> 1 order by ��װ���� desc";
				} else if (!zhuanye.equals("��ѡ��") && !rjmc.equals("��ѡ��")) {
					sql1 = "select * from ss_installation  where ��ҵ='" + hangye + "'and רҵ='" + zhuanye + "' and �������='"
							+ rjmc + "'and �ϼ���λ����='" + sjdw1 + "'and ��װ��λ����='" + dwmc
							+ "' and isdelete <> 1 order by ��װ���� desc";
				}
			} else {
				sql1 = "select * from ss_installation where isdelete <> 1 order by ��װ���� desc";
			}
			sq = XMLToJson.QdataIntall(sql1);
		}
		// ��װ��¼�޸Ĳ�ѯ��������
		if (operator1 != null && operator1.equals("��װ�޸�")) {
			sql1 = "select * from ss_installation where PGUID ='" + pguid + "' and isdelete <> 1 order by ��װ����  desc";
			sq = XMLToJson.QdataCHQuery2(sql1);
		}
		// �޸İ�װ��¼
		if (operator1 != null && operator1.equals("�޸İ�װ��¼")) {
			String sqlbianhao = "select ������  from ss_softregist where ��ҵ='" + hangye + "' and רҵ='" + zhuanye
					+ "' and �������='" + rjmc + "'";
			String bianhaoresult = XMLToJson.QuerySoftBianHao(sqlbianhao);
			bianhaoresult = bianhaoresult.replace("\"", "");
			bianhaoresult = bianhaoresult.replace("[", "");
			bianhaoresult = bianhaoresult.replace("]", "");

			String sql = "UPDATE ss_installation SET ��ҵ='" + hangye + "',רҵ='" + zhuanye + "',��װID='" + pguid + "',"
					+ "��װ��λ����='" + request.getParameter("dwmc") + "',��װ��λ����='" + request.getParameter("dwjb")
					+ "',�ϼ���λ����='" + request.getParameter("sjdw") + "',������='" + bianhaoresult + "',�������='" + rjmc
					+ "',��װ�汾��='" + request.getParameter("bbh") + "',��װ������IP='" + request.getParameter("fwip")
					+ "',��װ�������˿�='" + request.getParameter("fwdk") + "',����˴������·��='" + request.getParameter("azlj")
					+ "',��������='',��װ����='" + request.getParameter("azrq") + "',��װ��='" + request.getParameter("azr")
					+ "',��ע='" + request.getParameter("bz") + "'" + ",S_UDTIME='" + GetSysDateTime()
					+ "',S_SYTIME='',S_MFLAG='',ISDELETE='0'  where PGUID='" + pguid + "'";
			// ��ӡ���ز������ݿ�ķ���ֵ��1Ϊ����ɹ���-1Ϊʧ�� ,�������ͷ�������='"+
			System.out.println(sql);
			sq = XMLToJson.scSql(sql);
		}
		// ��װɾ����¼
		if (operator1 != null && operator1.equals("��װɾ����¼")) {
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
			 * "select * from ss_installation where isdelete <> 1 order by ��װ���� desc"
			 * ; sq = XMLToJson.QdataIntall(sqldata);
			 */
		}

		String sjdw = request.getParameter("sjdwadd");
		String dwjbadd = request.getParameter("dwjbadd");

		// ����ʵʩ��ѯ����
		if (operator1 != null && operator1.equals("����ʵʩ��ѯ����")) {
			if (dwmc != null && dwmc.equals("��ѡ��")) {
				sql1 = " select *  from SS_IMPLEMENT where ��ҵ='" + hangye + "'  and רҵ='" + zhuanye + "' and �������='"
						+ rjmc + "'order by ��λ���� ";
			} /*
				 * else if (dwmc != null && dwmc.equals("�й���·�ܹ�˾")) { sql1 =
				 * " select * from SS_IMPLEMENT where ��ҵ='" + hangye +
				 * "'and רҵ='" + zhuanye + "' and �������='" + rjmc +
				 * "' and ��λ����='�й���·�ܹ�˾' order  by ��λ���� "; }
				 */ else {
				sql1 = " select *  from SS_IMPLEMENT where ��ҵ='" + hangye + "'  and רҵ='" + zhuanye + "' and �������='"
						+ rjmc + "' and ��λ����='" + dwmc + "' or �ϼ���λ=(select pguid from SS_IMPLEMENT  where   ��ҵ='"
						+ hangye + "'  and רҵ='" + zhuanye + "' and �������='" + rjmc + "' and ��λ����='" + dwmc
						+ "') order by ��λ����";
			}
			System.out.println(sql1);
			sq = XMLToJson.impTableQuery(sql1);
		}

		// ����ʵʩ���ݲ���
		if (operator1 != null && operator1.equals("����ʵʩ���ݲ���")) {
			// zhe�Ժ�Ҫ�޸�Ϊͨ����ҵרҵһ��һ���Ĳ�ѯ�õ������������ڽ���ʹ�ü��𣨵�λ����ת������
			String[] arr = { "�ܹ�˾", "·��", "�����", "����", "����", "����" };
			String[] arr2 = { "�ܹ�˾", "·��", "ͨ�Ŷ�", "����", "����", "����" };
			int unitGread = 0;
			if (request.getParameter("zyadd").equals("�ź�")) {
				for (int i = 0; i < arr.length; i++) {
					if (dwjbadd.equals(arr[i])) {
						unitGread = i + 1;
					}
				}
			}
			if (request.getParameter("zyadd").equals("ͨ��")) {
				for (int i = 0; i < arr2.length; i++) {
					if (dwjbadd.equals(arr2[i])) {
						unitGread = i + 1;
					}
				}
			}
			sql1 = " select *  from SS_IMPLEMENT where ��ҵ='" + request.getParameter("hyadd") + "'  and רҵ='"
					+ request.getParameter("zyadd") + "' and �������='" + request.getParameter("rjxtadd") + "'and ��λ����='"
					+ request.getParameter("dwmcadd") + "'and ��λ����='" + unitGread + "'order by ��λ���� ";
			sq = XMLToJson.impTableQuery(sql1);
			// ��ѯ����ӵ���ҵױҵ������ƣ���λ�����µ�pguid��pguid �����ϼ���λ
			String sql2 = " select *  from SS_IMPLEMENT where ��ҵ='" + request.getParameter("hyadd") + "'  and רҵ='"
					+ request.getParameter("zyadd") + "' and �������='" + request.getParameter("rjxtadd") + "'and ��λ����='"
					+ sjdw + "'order by ��λ���� ";
			String sq2 = XMLToJson.implementPGUIDQuery(sql2);
			if (sq2.equals("[]")) {
				sq2 = "";
			}
			if (sq.equals("[]")) {
				sql1 = "insert into SS_IMPLEMENT (��ҵ,רҵ,�������,��λ����,�ϼ���λ,��λ����,ʩ���ƻ�,��ϵ��,��˾������,���̱�ע,һ�׶�,���׶�,���׶�,�Ľ׶�,��׶�,���׶�,�߽׶�,�˽׶�,�Ž׶�,ʮ�׶�,���ȱ�ע,S_UDTIME,PGUID)"
						+ "values " + "('" + request.getParameter("hyadd") + "','" + request.getParameter("zyadd")
						+ "','" + request.getParameter("rjxtadd") + "','" + request.getParameter("dwmcadd") + "','" // ��λ����
						+ sq2 + "',"// �ϼ���λ��ָ���ǵ�λ���Ƶ��ϼ���λ
						+ unitGread + ",'"// ָ���ǵ�λ���Ƶļ���
						+ request.getParameter("sgsjadd") + "','" + request.getParameter("lxradd") + "','"
						+ request.getParameter("zblxradd") + "','" + request.getParameter("bzadd")
						+ "','','','','','','','','','','','','" + GetSysDateTime() + "','" + pguid2 + "')";
				sq = XMLToJson.scSql(sql1);
			} else {
				sq = "2";
			}

		}

		// ����ʵʩɾ����¼
		if (operator1 != null && operator1.equals("����ʵʩɾ����¼")) {
			pguid = pguid.substring(0);
			String[] numberArray = pguid.split(",");
			String pguidsql = "pguid='" + numberArray[0] + "'  ";
			for (int i = 1; i < numberArray.length; i++) {
				pguidsql += "   or pguid='" + numberArray[i] + "'";
			}
			String sql = "DELETE FROM ss_implement  where " + pguidsql;
			XMLToJson.scSql(sql);
			if (dwmc != null && dwmc.equals("��ѡ��")) {
				sql1 = " select *  from SS_IMPLEMENT where ��ҵ='" + hangye + "'  and רҵ='" + zhuanye + "' and �������='"
						+ rjmc + "'order by ��λ���� ";
				sq = XMLToJson.impTableQuery(sql1);
			} else {
				sql1 = " select *  from SS_IMPLEMENT where ��ҵ='" + hangye + "'  and רҵ='" + zhuanye + "' and �������='"
						+ rjmc + "' and ��λ����='" + dwmc + "' or �ϼ���λ=(select pguid from SS_IMPLEMENT  where   ��ҵ='"
						+ hangye + "'  and רҵ='" + zhuanye + "' and �������='" + rjmc + "' and ��λ����='" + dwmc
						+ "') order by ��λ����";
				sq = XMLToJson.impTableQuery(sql1);
			}
		}

		// ����ʵʩ�޸Ĳ�ѯ��������
		if (operator1 != null && operator1.equals("����ʵʩ�޸�")) {
			sql1 = "select * from ss_implement where PGUID ='" + pguid + "'";
			sq = XMLToJson.impTableQuerych(sql1);
		}
		// ����ʵʩ�޸��ύ
		if (operator1 != null && operator1.equals("����ʵʩ�޸��ύ")) {
			String[] arr = { "�ܹ�˾", "·��", "�����", "����", "����", "����" };
			String[] arr2 = { "�ܹ�˾", "·��", "ͨ�Ŷ�", "����", "����", "����" };
			int unitGread = 0;
			if (request.getParameter("zyadd").equals("�ź�")) {
				for (int i = 0; i < arr.length; i++) {
					if (dwjbadd.equals(arr[i])) {
						unitGread = i + 1;
					}
				}
			}
			if (request.getParameter("zyadd").equals("ͨ��")) {
				for (int i = 0; i < arr2.length; i++) {
					if (dwjbadd.equals(arr2[i])) {
						unitGread = i + 1;
					}
				}
			}
			/*
			 * int unitGread = 0; if (dwjbadd != null && dwjbadd.equals("����")) {
			 * unitGread = 1; } if (dwjbadd != null && dwjbadd.equals("��")) {
			 * unitGread = 2; } if (dwjbadd != null && dwjbadd.equals("��")) {
			 * unitGread = 3; }
			 */

			// ��ѯ����ӵ���ҵױҵ������ƣ���λ�����µ�pguid��pguid �����ϼ���λ
			String sql2 = " select *  from SS_IMPLEMENT where ��ҵ='" + request.getParameter("hyadd") + "'  and רҵ='"
					+ request.getParameter("zyadd") + "' and �������='" + request.getParameter("rjxtadd") + "'and ��λ����='"
					+ sjdw + "'order by ��λ���� ";
			String sq2 = XMLToJson.implementPGUIDQuery(sql2);
			if (sq2.equals("[]")) {
				sq2 = "";
			}
			// ��ѯ����ӵ���ҵױҵ������ƣ���λ�����µ�pguid��pguid �����ϼ���λ
			sql1 = "UPDATE SS_IMPLEMENT set ��ҵ='" + request.getParameter("hyadd") + "'," + "רҵ='"
					+ request.getParameter("zyadd") + "'," + "�������='" + request.getParameter("rjxtadd") + "',"
					+ "��λ����='" + request.getParameter("dwmcadd") + "'," + "�ϼ���λ='" + sq2 + "'," + "��λ����='" + unitGread
					+ "'," + "ʩ���ƻ�='" + request.getParameter("sgsjadd") + "'," + "��ϵ��='"
					+ request.getParameter("lxradd") + "'," + "��˾������='" + request.getParameter("zblxradd") + "',"
					+ "���̱�ע='" + request.getParameter("bzadd") + "'where PGUID='" + pguid + "'";
			sq = XMLToJson.scSql(sql1);
		}

		// +++++++++++++++++++++++++++++++++++++++++++++++++++//
		// �û���Ϣ�޸�
		if (operator1 != null && operator1.equals("�û���Ϣ�޸�")) {
			sql1 = "select * from ss_user where userid ='" + pguid + "'";
			sq = XMLToJson.QdataUser(sql1);
		}
		String editYesOrNox = "�ɱ༭";
		if (operator1 != null && operator1.equals("��Աע���޸�")) {
			quanxian = quanxian.substring(0, quanxian.length() - 1);
			if (quanxian.indexOf("���ɱ༭") >= 0) {
				quanxian = quanxian.replace(",���ɱ༭", "");
				editYesOrNox = "���ɱ༭";
			}
			quanxian.replace(",", ".");
			sql1 = "update  ss_user set ����='" + bmadd + "',�û���='" + username + "',Ȩ��='" + quanxian + "',�Ƿ�༭='"
					+ editYesOrNox + "' where userid='" + pguid + "'";

			sq = XMLToJson.scSql(sql1);
		}
		// +++++++++++++++++++++++++++++++++++++++++++++++++++//
		// ����ʵʩ��ѯ����
		if (operator1 != null && operator1.equals("����ʵʩ��ѯ")) {
			sql1 = " select * from ss_stepset  where  ��ҵ='" + hangye + "'and רҵ='" + zhuanye + "' and �������='" + rjmc
					+ "'order by �ֶ�����";

			String sqjieduanname = XMLToJson.tableQuery(sql1);
			String rjname = null;
			if (rjmc != null && !rjmc.equals("��ѡ��") && dwmc.equals("��ѡ��")) {
				sql1 = " select * from SS_IMPLEMENT where ��ҵ='" + hangye + "'and רҵ='" + zhuanye + "' and �������='" + rjmc
						+ "'  order by ��λ����";

				rjname = XMLToJson.tabledataQuery(sql1, sqjieduanname);
			} /*
				 * else if (rjmc != null && rjmc.equals("�й���·�ܹ�˾")) { sql1 =
				 * " select * from SS_IMPLEMENT where ��ҵ='" + hangye +
				 * "'and רҵ='" + zhuanye + "' and �������='" + rjmc +
				 * "' and ��λ����='�й���·�ܹ�˾' order  by ��λ���� "; rjname =
				 * XMLToJson.tabledataQuery(sql1, sqjieduanname); }
				 */
			else {
				sql1 = " select * from SS_IMPLEMENT where ��ҵ='" + hangye + "'and רҵ='" + zhuanye + "' and �������='" + rjmc
						+ "' and ��λ����='" + dwmc + "' or �ϼ���λ=(select pguid from SS_IMPLEMENT  where   ��ҵ='" + hangye
						+ "'  and רҵ='" + zhuanye + "' and �������='" + rjmc + "' and ��λ����='" + dwmc
						+ "') order  by ��λ���� ";
				rjname = XMLToJson.tabledataQuery(sql1, sqjieduanname);
			}
			sq = "[" + sqjieduanname + "," + rjname + "]";
		}
		// �׶ν�����ɸ���
		if (operator1 != null && operator1.equals("�׶ν�����ɸ���")) {
			sql1 = "UPDATE  SS_IMPLEMENT SET " + request.getParameter("cellnameOracle") + "='"+ request.getParameter("value") + "'where pguid='" + tablepguid + "'";
			sq = XMLToJson.scSql(sql1);
		}
		// ...................................................................�����ѯ��ť1........................................................................................
		if (wentiquery != null && wentiquery.equals("�����ѯ��ť1")) {
			 System.out.println(fslx+  rjxt+wtcause+dwcx+sfjj);
			 //���ڵ�λ ԭ��ָ�������ڵ��ϼ���λ���������ڵ��ϼ���λ�����ܴ���ԭ���ģ����������һ���ֶ�  �жϼ���   ,���� �����Ϊ�����������ܺ�·�֣����Դ���ԭ���ĵ�λ���������ݿ����ϼ���λ
			if (fslx != null && (fslx.equals("�������") || fslx.equals("�û�ʹ��") || fslx.equals("�û�����")|| fslx.equals("���̰�װ") || fslx.equals("ϵͳ��������"))) {
				if(rjxt.equals("��ѡ��")){                 //�������=��ѡ��,
					if(wtcause.equals("��ѡ��")){          //�������=��ѡ��,����ԭ��='��ѡ��',
						if(dwcx.equals("��ѡ��")){         //�������=��ѡ��,����ԭ��='��ѡ��',��λ����='��ѡ��',
							if(sfjj.equals("δ���")){     //�������=��ѡ��,����ԭ��='��ѡ��',��λ����='��ѡ��',�Ƿ���='δ���',
								sql1 = "select * from ss_feedbackquestions where �������ͷ�������='" + fslx+ "'and �Ƿ��� is null and isdelete <> 1 order by ���ʱ��  desc";
							}else{                       //�������=��ѡ��,����ԭ��='��ѡ��',��λ����='��ѡ��',�Ƿ���='�ѽ��'
								sql1 = "select * from ss_feedbackquestions where �������ͷ�������='" + fslx+ "' and �Ƿ���='�ѽ��'  and isdelete <> 1 order by ���ʱ��  desc";
							} 
						}else{                          //�������=��ѡ��,����ԭ��='��ѡ��',
							if(sfjj.equals("δ���")){    //�������=��ѡ��,����ԭ��='��ѡ��',��λ����<������>'��ѡ��',�Ƿ���='δ���',
								sql1 = "select * from ss_feedbackquestions where �жϼ���='"+dwcx+"' and  �������ͷ�������='" + fslx+ "'and �Ƿ���  is null and isdelete <> 1 order by ���ʱ��  desc";
							}else{                      //�������=��ѡ��,����ԭ��='��ѡ��',��λ����<������>'��ѡ��',�Ƿ���='δ���',
								sql1 = "select * from ss_feedbackquestions where �жϼ���='"+dwcx+"' and  �������ͷ�������='" + fslx+ "' and �Ƿ���='�ѽ��'  and isdelete <> 1 order by ���ʱ��  desc";
							} 
						} 
					}else{                              //�������=��ѡ��,����ԭ��<������>'��ѡ��',
						if(dwcx.equals("��ѡ��")){			//�������=��ѡ��,����ԭ��<������>'��ѡ��',��λ����='��ѡ��',
							if(sfjj.equals("δ���")){    //�������=��ѡ��,����ԭ��<������>'��ѡ��',��λ����='��ѡ��',�Ƿ���='δ���',
								sql1 = "select * from ss_feedbackquestions where ����ԭ��='"+wtcause+"' and  �������ͷ�������='" + fslx+ "'and �Ƿ���  is null and isdelete <> 1 order by ���ʱ��  desc";
							}else{ 						//�������=��ѡ��,����ԭ��<������>'��ѡ��',��λ����='��ѡ��',�Ƿ���='�ѽ��',
								sql1 = "select * from ss_feedbackquestions where ����ԭ��='"+wtcause+"' and  �������ͷ�������='" + fslx+ "' and �Ƿ���='�ѽ��'  and isdelete <> 1 order by ���ʱ��  desc";
							} 
						}else{							//�������=��ѡ��,����ԭ��<������>'��ѡ��',��λ����<������>'��ѡ��',
							if(sfjj.equals("δ���")){		//�������=��ѡ��,����ԭ��<������>'��ѡ��',��λ����<������>'��ѡ��',�Ƿ���='δ���',
								sql1 = "select * from ss_feedbackquestions where ����ԭ��='"+wtcause+"' and �жϼ���='"+dwcx+"' and  �������ͷ�������='" + fslx+ "'and �Ƿ���  is null and isdelete <> 1 order by ���ʱ��  desc";
							}else{						//�������=��ѡ��,����ԭ��<������>'��ѡ��',��λ����<������>'��ѡ��',�Ƿ���='�ѽ��',
								sql1 = "select * from ss_feedbackquestions where ����ԭ��='"+wtcause+"' and �жϼ���='"+dwcx+"' and  �������ͷ�������='" + fslx+ "' and �Ƿ���='�ѽ��'  and isdelete <> 1 order by ���ʱ��  desc";
							} 
						} 
					} 
				}else{                 					//�������<������>��ѡ��,
					if(wtcause.equals("��ѡ��")){			//�������<������>��ѡ��,����ԭ��='��ѡ��',
						if(dwcx.equals("��ѡ��")){			//�������<������>��ѡ��,����ԭ��='��ѡ��',��λ����='��ѡ��',
							if(sfjj.equals("δ���")){	    //�������<������>��ѡ��,����ԭ��='��ѡ��',��λ����='��ѡ��',�Ƿ���='δ���',
								sql1 = "select * from ss_feedbackquestions where ��ҵ='"+hy+"' and רҵ='"+zy+"' and ���ϵͳ='"+rjxt+"' and  �������ͷ�������='" + fslx+ "'and �Ƿ���  is null and isdelete <> 1 order by ���ʱ��  desc";
							}else{						//�������<������>��ѡ��,����ԭ��<������>'��ѡ��',��λ����='��ѡ��',�Ƿ���='�ѽ��',
								sql1 = "select * from ss_feedbackquestions where ��ҵ='"+hy+"' and רҵ='"+zy+"' and ���ϵͳ='"+rjxt+"' and  �������ͷ�������='" + fslx+ "'and �Ƿ���  ='�ѽ��' and isdelete <> 1 order by ���ʱ��  desc";
							} 
						}else{							//�������<������>��ѡ��,����ԭ��='��ѡ��',��λ����<������>'��ѡ��',
							if(sfjj.equals("δ���")){		//�������<������>��ѡ��,����ԭ��='��ѡ��',��λ����<������>'��ѡ��',�Ƿ���='δ���',
								sql1 = "select * from ss_feedbackquestions where ��ҵ='"+hy+"' and רҵ='"+zy+"' and ���ϵͳ='"+rjxt+"' and �жϼ���='"+dwcx+"' and  �������ͷ�������='" + fslx+ "'and �Ƿ���  is null and isdelete <> 1 order by ���ʱ��  desc";
							}else{						//�������<������>��ѡ��,����ԭ��='��ѡ��',��λ����<������>'��ѡ��',�Ƿ���='�ѽ��',
								sql1 = "select * from ss_feedbackquestions where ��ҵ='"+hy+"' and רҵ='"+zy+"' and ���ϵͳ='"+rjxt+"' and �жϼ���='"+dwcx+"' and  �������ͷ�������='" + fslx+ "'and �Ƿ���  ='�ѽ��' and isdelete <> 1 order by ���ʱ��  desc";
							} 
						} 
					}else{								//�������<������>��ѡ��,����ԭ��<������>'��ѡ��',
						if(dwcx.equals("��ѡ��")){			//�������<������>��ѡ��,����ԭ��<������>'��ѡ��',��λ����='��ѡ��',
							if(sfjj.equals("δ���")){		//�������<������>��ѡ��,����ԭ��<������>'��ѡ��',��λ����='��ѡ��',�Ƿ���='δ���',
								sql1 = "select * from ss_feedbackquestions where ��ҵ='"+hy+"' and רҵ='"+zy+"' and ���ϵͳ='"+rjxt+"' and ����ԭ��='"+wtcause+"'  and  �������ͷ�������='" + fslx+ "'and �Ƿ���  is null and isdelete <> 1 order by ���ʱ��  desc";
							}else{						//�������<������>��ѡ��,����ԭ��<������>'��ѡ��',��λ����='��ѡ��',�Ƿ���='�ѽ��',
								sql1 = "select * from ss_feedbackquestions where ��ҵ='"+hy+"' and רҵ='"+zy+"' and ���ϵͳ='"+rjxt+"' and ����ԭ��='"+wtcause+"'  and  �������ͷ�������='" + fslx+ "'and �Ƿ���  ='�ѽ��' and isdelete <> 1 order by ���ʱ��  desc";
							} 
						}else{							//�������<������>��ѡ��,����ԭ��<������>'��ѡ��',��λ����<������>'��ѡ��',
							if(sfjj.equals("δ���")){		//�������<������>��ѡ��,����ԭ��<������>'��ѡ��',��λ����<������>'��ѡ��',�Ƿ���='δ���',
								sql1 = "select * from ss_feedbackquestions where ��ҵ='"+hy+"' and רҵ='"+zy+"' and ���ϵͳ='"+rjxt+"' and ����ԭ��='"+wtcause+"'  and �жϼ���='"+dwcx+"'  and  �������ͷ�������='" + fslx+ "'and �Ƿ���  is null and isdelete <> 1 order by ���ʱ��  desc";
							}else{						//�������<������>��ѡ��,����ԭ��<������>'��ѡ��',��λ����<������>'��ѡ��',�Ƿ���='�ѽ��',
								sql1 = "select * from ss_feedbackquestions where ��ҵ='"+hy+"' and רҵ='"+zy+"' and ���ϵͳ='"+rjxt+"' and ����ԭ��='"+wtcause+"'  and �жϼ���='"+dwcx+"'  and  �������ͷ�������='" + fslx+ "'and �Ƿ���  ='�ѽ��' and isdelete <> 1 order by ���ʱ��  desc";
							} 
						} 
					} 
				}
			 }
			 sq = XMLToJson.QdataProQuery1(sql1);
		}

		if (quch != null && quch.equals("�����޸�ǰ���ݲ�ѯ����")) {
			sql1 = "select * from ss_feedbackquestions where PGUID ='" + request.getParameter("changesj")
					+ "' and isdelete <> 1 order by ���ʱ��  desc";
			sq = XMLToJson.QdataCHQuery(sql1);
		}

		if (operator1 != null && operator1.equals("�޸ļ�¼")) {
			String pdjb="";
			if(request.getParameter("dwdinput").equals("")){
				pdjb="�й���·�ܹ�˾";
			}else if (request.getParameter("dwdinput").equals("�й���·�ܹ�˾")){
				pdjb=request.getParameter("tljinput");
			}else{
				pdjb=request.getParameter("dwdinput");
			}
			String sql = "UPDATE ss_feedbackquestions SET �жϼ���='"+pdjb+"',���ϵͳ='" + request.getParameter("rjxtinput") + "',��������='" + request.getParameter("wtms") + "'" + ",��ע='"
					+ request.getParameter("bz") + "'" + ",��ͼ='" + request.getParameter("scjt") + "'" + ",��λ='"
					+ request.getParameter("tljinput") + "'" + ",�ϼ���λ='" + request.getParameter("dwdinput") + "'"// ԭ���¼���λ����ʮһ���޸�
					+ ",����='" + request.getParameter("cjinput") + "'" + ",��Ա='" + request.getParameter("xminput") + "'"
					+ ",��ϵ�绰='" + request.getParameter("lxdh") + "'" + ",��¼��='" + request.getParameter("uname") + "'"
					+ ",��ҵ='" + request.getParameter("hyinput") + "'" + ",רҵ='" + request.getParameter("zyinput") + "'"
					// ��������ʫ�¼ӵİ������
					+ ",����='" + request.getParameter("functinput") + "'" + ",����ԭ��='"
					+ request.getParameter("causeinput") + "'" + ",����Ա����='" + request.getParameter("pfeedback") + "'"
					+ ",��˾���='" + request.getParameter("compannyop") + "'" + ",Ԥ�����ʱ��='"
					+ request.getParameter("modifyplan") + "'" + ",����취='" + request.getParameter("solution") + "'"
					+ ",���ʱ��='" + request.getParameter("tjsj") + "',S_UDTIME='" + GetSysDateTime() + "',�����汾='"
					+ request.getParameter("oversion") + "' where PGUID='" + pguid + "'";

			sq = XMLToJson.scSql(sql);
		}
		// ����ɾ����¼
		if (operator1 != null && operator1.equals("����ɾ����¼")) {
			pguid = pguid.substring(0);
			String[] numberArray = pguid.split(",");
			String pguidsql = "pguid='" + numberArray[0] + "'  ";
			for (int i = 1; i < numberArray.length; i++) {
				pguidsql += "   or pguid='" + numberArray[i] + "'";
			}
			String sql = "DELETE FROM SS_FEEDBACKQUESTIONS  where " + pguidsql;
			XMLToJson.scSql(sql);
			String sqldata="";
			if (fslx != null && fslx.equals("�������")) {
				 sqldata = "select * from ss_feedbackquestions where �������ͷ�������='�������' and isdelete <> 1 order by ���ʱ��  desc";
			} else if (fslx != null && fslx.equals("�û�����")) {
				 sqldata = "select * from ss_feedbackquestions where �������ͷ�������='�û�����' and isdelete <> 1 order by ���ʱ��  desc";
			} else if (fslx != null && fslx.equals("�û�ʹ��")) {
				 sqldata = "select * from ss_feedbackquestions where �������ͷ�������='�û�ʹ��' and isdelete <> 1 order by ���ʱ��  desc";
			} else if (fslx != null && fslx.equals("���̰�װ")) {
				 sqldata = "select * from ss_feedbackquestions where �������ͷ�������='���̰�װ' and isdelete <> 1 order by ���ʱ��  desc";
			} else {
				 sqldata = "select * from ss_feedbackquestions where isdelete <> 1 order by ���ʱ��  desc";
			}
			sq = XMLToJson.QdataProQuery1(sqldata);
		}
		//
		// �����޸��Ƿ���
		if (operator1 != null && operator1.equals("������")) {
			pguid = pguid.substring(0);
			String[] numberArray = pguid.split(",");
			String pguidsql = "pguid='" + numberArray[0] + "'  ";
			for (int i = 1; i < numberArray.length; i++) {
				pguidsql += "   or pguid='" + numberArray[i] + "'";
			}
			String sql = "UPDATE SS_FEEDBACKQUESTIONS SET ����汾='" + request.getParameter("version")
					+ "' ,�Ƿ���='�ѽ��',���ʱ�� ='" + sotime + "' where " + pguidsql;
			XMLToJson.scSql(sql);
			String sqldata ;
			if (fslx != null && fslx.equals("�������")) {
				 sqldata = "select * from ss_feedbackquestions where �������ͷ�������='�������' and isdelete <> 1 order by ���ʱ��  desc";
			} else if (fslx != null && fslx.equals("�û�����")) {
				 sqldata = "select * from ss_feedbackquestions where �������ͷ�������='�û�����' and isdelete <> 1 order by ���ʱ��  desc";
			} else if (fslx != null && fslx.equals("�û�ʹ��")) {
				 sqldata = "select * from ss_feedbackquestions where �������ͷ�������='�û�ʹ��' and isdelete <> 1 order by ���ʱ��  desc";
			} else if (fslx != null && fslx.equals("���̰�װ")) {
				 sqldata = "select * from ss_feedbackquestions where �������ͷ�������='���̰�װ' and isdelete <> 1 order by ���ʱ��  desc";
			} else if (fslx != null && fslx.equals("ϵͳ��������")) {
				 sqldata = "select * from ss_feedbackquestions where �������ͷ�������='ϵͳ��������' and isdelete <> 1 order by ���ʱ��  desc";
			}else {
				 sqldata = "select * from ss_feedbackquestions where isdelete <> 1 order by ���ʱ��  desc";
			}
			sq = XMLToJson.QdataProQuery1(sqldata);
		}

		// ϵͳ���ý�������ҳ�棺 �����װ�׶����
		if (operator1 != null && operator1.equals("�����װ�׶����")) {
			String sql = "select *  from ss_stepset where ��ҵ='" + hangye + "'  and רҵ='" + zhuanye + "' and �������='"
					+ request.getParameter("rjxt") + "' and  �ֶ�����=" + request.getParameter("gcjd");
			sq = XMLToJson.jieduanQuery(sql);
			if (gcjd.equals("0") | gcjd.equals("��ѡ��") | gcjd.equals("") | gcjd.equals(0)) {
				PrintWriter out1 = response.getWriter();
				out1.println("2");// ��ѡ��
				out1.close();
			} else if (sq != "[]") {
				sql1 = "UPDATE  ss_stepset SET �ֶ�����='" + request.getParameter("gcjd") + "' ,�׶����� ='"
						+ request.getParameter("jdmc") + "' ,������='" + request.getParameter("fzr") + "' where ��ҵ='"
						+ hangye + "'  and רҵ='" + zhuanye + "' and �������='" + request.getParameter("rjxt")
						+ "' and  �ֶ�����=" + request.getParameter("gcjd");
				sq = XMLToJson.scSql(sql1);
			} else {
				sql1 = "insert into   ss_stepset (��ҵ,רҵ,�������,�ֶ�����,�׶�����,������,PGUID)values ('" + hangye + "','" + zhuanye
						+ "','" + request.getParameter("rjxt") + "','" + request.getParameter("gcjd") + "','"
						+ request.getParameter("jdmc") + "','" + request.getParameter("fzr") + "','" + pguid2 + "')";
				sq = XMLToJson.scSql(sql1);
			}

		}
		// ........................������ʮһ�� ���� ���
		// �������ã�Ӧ�����������ĵ�ѡ��.....................
		if (operator1 != null && operator1.equals("�����������")) {
			// �ж��Ƿ��ظ������ء������� ���ظ�������ӣ������ظ���
			String sql = "select *   from ss_function where ��ҵ='" + hy + "'  and רҵ='" + zy + "' and �������='" + rjmc
					+ "' and  ����= '" + request.getParameter("function1") + "'";
			sq = XMLToJson.functionQuery(sql);
			if (sq.equals("[]")) {
				sql1 = "insert into  ss_function (��ҵ,רҵ,�������,����,PGUID,isdelete)  values ('" + hy + "','" + zy + "','"
						+ rjmc + "','" + request.getParameter("function1") + "','" + pguid2 + "','0')";
				sq = XMLToJson.scSql(sql1);                // ����ɹ�����"1"�����򷵻����ʧ�ܣ�
				if (sq.equals("[\"1\"]")) {
					sql = "select *   from ss_function where ��ҵ='" + hy + "'  and רҵ='" + zy + "' and �������='" + rjmc
							+ "'";
					sq = XMLToJson.functionQuery(sql);
				} else {
					sq = "[\"���ʧ��\"]";
				}
			} else {
				sq = "[\"�Ѵ���\"]";
			}

		}
		// ......�������ò�ѯ........������ʮһ��������ӣ����ڲ�ѯ��ʾ���ܵĽ��������������ʱ��ѡ��...........
		if (operator1 != null && operator1.equals("�������ò�ѯ")) {
			// �ж��Ƿ��ظ������ء������� ���ظ�������ӣ������ظ���
			String sql = "select * from ss_function where ��ҵ='" + hy + "'  and רҵ='" + zy + "' and �������='" + rjmc + "'";
			sq = XMLToJson.functionQuery(sql);

		}
		// ���������޸Ĳ�ѯ���ݼ���...............������ʮһ����ӣ������޸Ĺ�������
		if (operator1 != null && operator1.equals("���������޸Ĳ�ѯ���ݼ���")) {
			String sql = "select * from ss_function where PGUID='" + request.getParameter("pguid") + "'";
			sq = XMLToJson.functionQuery(sql);
		}
		// �޸Ĺ����ύ................������ʮһ����ӣ������޸��ύ
		if (operator1 != null && operator1.equals("�޸Ĺ����ύ")) {
			String sql = "select * from ss_function where ����='" + request.getParameter("functionxg") + "'";
			sq = XMLToJson.functionQuery(sql);
			if (!sq.equals("[]")) {
				sq = "[2]";
			} else {
				sql1 = "UPDATE  ss_function SET ����='" + request.getParameter("functionxg") + "' where pguid='" + pguid
						+ "' ";
				sq = XMLToJson.scSql(sql1);
			}
		}

		// ���¶������ ..................... ϵͳ����ԭ������ҳ�棺ԭ������ɾ��
		if (operator1 != null && operator1.equals("ԭ������ɾ��")) {
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
		// ���¶������............. ��������ɾ��
		if (operator1 != null && operator1.equals("��������ɾ��")) {
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

		if (operator1 != null && (operator1.equals("����������") || operator1.equals("�û��������") || operator1.equals("�û�ʹ�����")
				|| operator1.equals("���̰�װ���") || operator1.equals("ϵͳ�����������") || operator1.equals("���"))) {
			String fslx1 = request.getParameter("fslx");
			GetWTBH();
			String CharA[] = { "A", "B", "C", "D", "E" };
			String Softq[] = { "�������", "�û�����", "�û�ʹ��", "���̰�װ", "ϵͳ��������" };
			for (int i = 0; i < Softq.length; i++) {
				if (fslx1.equals(Softq[i])) {
					fslx1 = CharA[i];// �õ� �������͵ı��� ��д��ĸ ������ ��
				}
			}

			String sqla = "select ��λ����  from BD_AU_��λ�ֵ��   where  ����='" + request.getParameter("dwd") + "'";
			sq = XMLToJson.getDWjb(sqla);// �õ�Сд��ĸ ��λ����ı���
			fslx1 = sq + fslx1;
			StringBuffer sb = new StringBuffer();
			sb.append(resultwtbh).insert(8, fslx1);
			resultwtbh = sb.toString();
			System.out.println("�����ţ�" + resultwtbh);
			String pdjb="";
			if(request.getParameter("dwd").equals("")){
				pdjb="�й���·�ܹ�˾";
			}else if (request.getParameter("dwd").equals("�й���·�ܹ�˾")){
				pdjb=request.getParameter("tlj");
			}else{
				pdjb=request.getParameter("dwd");
			}
			// ���sb.toSring()Ϊ��heaaallo��
			// ԭ���¼���λ����ʮһ���޸�
			String sql = "INSERT INTO SS_FEEDBACKQUESTIONS���жϼ���,������,����취,Ԥ�����ʱ��,��˾���,����Ա����,����ԭ�� ,����,�����汾,���ϵͳ,��������,��ע,��ͼ,��λ,�ϼ���λ,����,��Ա,��ϵ�绰,��¼��,��ҵ,רҵ,���ʱ��,PGUID,S_UDTIME,�������ͷ�������)"
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
					+ request.getParameter("zy") + "','" + request.getParameter("tjsj") + "','" + pguid2 + "','" // pguid��ǰ̨�ı�������
					+ GetSysDateTime() + "','" + request.getParameter("fslx") + "')";
			System.out.println("sql:" + sql);
			sq = XMLToJson.scSql(sql);
		}
		if (operator1 != null && operator1.equals("�����װ�׶β�ѯ")) {
			sql1 = " select * from ss_stepset where ��ҵ='" + hangye + "'and רҵ='" + zhuanye + "' and �������='"
					+ request.getParameter("rjxt") + "'  order  by �ֶ����� ";
			sq = XMLToJson.jieduanQuery(sql1);
		}
		// ��ѯversion���汾�ţ���¼ҳʹ��
		if (operator1 != null && operator1.equals("��ѯversion")) {
			sq = "[\"" + getVersion() + "\"]";
		}
		PrintWriter out = response.getWriter();
		out.println(sq);
		System.out.println("wwww  " + sq);
		out.close();
	}

	// de�õ��汾��,�ڵ�¼Ҳ����
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
	 * ����ϵͳ���� ʱ��
	 */
	public String GetSysDateTime() {
		DateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINESE);
		return sf.format(new Date());
	}

	int a = 1;
	String resultwtbh = "";// ���շ��ؽ���� ����+���
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

	// ���� POST ��������ķ���
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);

	}
}
