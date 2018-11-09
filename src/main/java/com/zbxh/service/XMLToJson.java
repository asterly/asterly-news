package com.zbxh.service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import org.dom4j.DocumentHelper;
import org.apache.commons.lang.StringEscapeUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
//import org.dom4j.Node;

import com.zbxh.databean.DoUnitData;
import com.zbxh.databean.JdData;

public class XMLToJson {
	public static String scSql(String sql) {
		String result = "[\"";
		sswServices service = new sswServices("ExecuteSql");
		String sss = service.getByPost("sql=" + sql);
		sss = StringEscapeUtils.unescapeXml(sss);
		String s1 = "<int xmlns=\"http://zbxhupdata.com/webservices/\">";
		int i1 = sss.indexOf(s1);
		if (i1 >= 0) {
			sss = sss.substring(i1 + s1.length());
		}

		String s2 = "</int>";
		int pos = sss.indexOf(s2);
		if (pos >= 0) {
			sss = sss.substring(0, pos);
		}
		result += sss;
		result += "\"]";
		return result;
	}

	public static String QueryDataSql(String sql) {
		String result = "[";

		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			Document document = DocumentHelper.parseText(sss);
			Element root = document.getRootElement();
			List<Element> list = root.elements("Table");
			for (Element element : list) {
				result += element.element("COUNT_x0028__x002A__x0029_").getTextTrim();

			}
			result += "]";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	}

	public static String Qdata(String sql, String id) {
		String result = "[[\"��ѡ��\",\"��ѡ��\"],";
		String result1 = "[[\"��ѡ��\",\"��ѡ��\"],";
		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			if (sss.equals("0")) {
				result = result1;
			} else {
				Document document = DocumentHelper.parseText(sss);
				Element root = document.getRootElement();
				List<Element> list = root.elements("Table");
				for (Element element : list) {
					result += "[\"" + element.element("����").getTextTrim(); // +"<span
																			// color=\"red\">"
																			// </span>
					result += "\",\"" + element.element("����").getTextTrim() + "\"";
					result += "],";
				}
			}
			result = result.substring(0, result.length() - 1);
			result += "]";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static String Qdata1(String sql, String id) {
		String result = "[[\"��ѡ��\",\"��ѡ��\"],";
		String result1 = "[[\"��ѡ��\",\"��ѡ��\"],";
		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			if (sss.equals("0")) {
				result = result1;
			} else {
				Document document = DocumentHelper.parseText(sss);
				Element root = document.getRootElement();
				List<Element> list = root.elements("Table");
				for (Element element : list) {
					// if(element.element("������λ").getTextTrim().equals(id)){
					result += "[\"" + element.element("ID").getTextTrim(); // +"<span
																			// color=\"red\">"
																			// </span>
					result += "\",\"" + element.element("NAME").getTextTrim() + "\"";
					result += "],";
					// }
				}
			}
			result = result.substring(0, result.length() - 1);
			result += "]";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static String Qdata2(String sql, String id) {
		String result = "[[\"��ѡ��\",\"��ѡ��\"],";
		String result1 = "[[\"��ѡ��\",\"��ѡ��\"],";
		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			if (sss.equals("0")) {
				result = result1;
			} else {
				Document document = DocumentHelper.parseText(sss);
				Element root = document.getRootElement();
				List<Element> list = root.elements("Table");
				for (Element element : list) {
					// if(element.element("������λ").getTextTrim().equals(id)){
					result += "[\"" + element.element("PERSONID").getTextTrim(); // +"<span
																					// color=\"red\">"
																					// </span>
					result += "\",\"" + element.element("����").getTextTrim() + "\"";
					result += "],";
					// }
				}
			}
			result = result.substring(0, result.length() - 1);
			result += "]";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// ��ѯ��ҵ�ı�ţ�
	public static String QueryHYNum(String sql) {
		String result = "[";
		String result1 = "[";
		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			if (sss.equals("0")) {
				result = result1;
			} else {
				Document document = DocumentHelper.parseText(sss);
				Element root = document.getRootElement();
				List<Element> list = root.elements("Table");
				for (Element element : list) {
					result += "\"" + element.element("HYCODE").getTextTrim() + "\"";
				}
			}
			// result=result.substring(0, result.length()-1);
			result += "]";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// ��ѯרҵ�ı��
	public static String QueryZYNum(String sql) {
		String result = "[";
		String result1 = "[";
		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			if (sss.equals("0")) {
				result = result1;
			} else {
				Document document = DocumentHelper.parseText(sss);
				Element root = document.getRootElement();
				List<Element> list = root.elements("Table");
				for (Element element : list) {
					result += "\"" + element.element("ZYCODE").getTextTrim() + "\""; // +"<span
																						// color=\"red\">"
																						// </span>
				}
			}
			// result=result.substring(0, result.length()-1);
			result += "]";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static String QuerySoftNum(String sql) {
		String result = "[";
		String result1 = "[";
		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			if (sss.equals("<NewDataSet><Table /></NewDataSet>")) {
				result += "0";
			} else {
				if (sss.equals("0")) {
					result = result1;
				} else {
					Document document = DocumentHelper.parseText(sss);
					Element root = document.getRootElement();
					List<Element> list = root.elements("Table");
					for (Element element : list) {
						Element ele1 = element.element("�������");
						if (null != ele1) {
							result += "\"" + ele1.getTextTrim() + "\"";
						} else {
							result += "";
						}
					}
				}

			}

			result += "]";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// ��ȡ�������
	public static String QuerySoftName(String sql) {
		String result = "[";
		String result1 = "[";
		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			if (sss.equals("<NewDataSet><Table /></NewDataSet>")) {
				result += "0";
			} else {
				if (sss.equals("0")) {
					result = result1;
				} else {
					Document document = DocumentHelper.parseText(sss);
					Element root = document.getRootElement();
					List<Element> list = root.elements("Table");
					for (Element element : list) {
						Element ele1 = element.element("�������");
						if (null != ele1) {
							result += "\"" + ele1.getTextTrim() + "\"";
						} else {
							result += "\"0\"";
						}
					}
				}

			}

			result += "]";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// ��ȡ��Ŀ����
	public static String QuerySoftProName(String sql) {
		String result = "[";
		String result1 = "[";
		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			if (sss.equals("<NewDataSet><Table /></NewDataSet>")) {
				result += "0";
			} else {
				if (sss.equals("0")) {
					result = result1;
				} else {
					Document document = DocumentHelper.parseText(sss);
					Element root = document.getRootElement();
					List<Element> list = root.elements("Table");
					for (Element element : list) {
						Element ele1 = element.element("��Ŀ����");
						if (null != ele1) {
							result += "\"" + ele1.getTextTrim() + "\"";
						} else {
							result += "\"0\"";
						}
					}
				}
			}
			result += "]";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// ��ȡ������
	public static String QuerySoftBianHao(String sql) {
		String result = "[";
		String result1 = "[";
		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			if (sss.equals("<NewDataSet><Table /></NewDataSet>")) {
				result += "0";
			} else {
				if (sss.equals("0")) {
					result = result1;
				} else {
					Document document = DocumentHelper.parseText(sss);
					Element root = document.getRootElement();
					List<Element> list = root.elements("Table");
					for (Element element : list) {
						Element ele1 = element.element("������");
						if (null != ele1) {
							result += "\"" + ele1.getTextTrim() + "\"";
						} else {
							result += "\"0\"";
						}
					}
				}
			}
			result += "]";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// ��ȡ�����
	public static String QueryDuanLb(String sql) {
		String result = "[";
		String result1 = "[";
		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			if (sss.equals("<NewDataSet><Table /></NewDataSet>")) {
				result += "0";
			} else {
				if (sss.equals("0")) {
					result = result1;
				} else {
					Document document = DocumentHelper.parseText(sss);
					Element root = document.getRootElement();
					List<Element> list = root.elements("Table");
					for (Element element : list) {
						Element ele1 = element.element("�����");
						if (null != ele1) {
							result += "\"" + ele1.getTextTrim() + "\"";
						} else {
							result += "\"0\"";
						}
					}
				}
			}

			result += "]";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// ��ȡ�������ͣ�����ѡ��

	public static String QueryWtlx(String sql) {
		String result = "[\"��ѡ��\",";
		String result1 = "[[\"��ѡ��\",";
		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			if (sss.equals("<NewDataSet><Table /></NewDataSet>")) {
				result += "0";
			} else {
				if (sss.equals("0")) {
					result = result1;
				} else {
					Document document = DocumentHelper.parseText(sss);
					Element root = document.getRootElement();
					List<Element> list = root.elements("Table");
					for (Element element : list) {
						Element ele1 = element.element("��������");
						if (null != ele1) {
							result += "\"" + ele1.getTextTrim() + "\",";
						} else {
							result += "\"0\"";
						}
					}
				}
			}
			result = result.substring(0, result.length() - 1);

			result += "]";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// cha��ѯ��ҵ
	public static String QueryDataHy(String sql) {
		String result = "[[\"��ѡ��\",\"��ѡ��\"],";
		String result1 = "[[\"��ѡ��\",\"��ѡ��\"],";
		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			if (sss.equals("0")) {
				result = result1;
			} else {
				Document document = DocumentHelper.parseText(sss);
				Element root = document.getRootElement();
				List<Element> list = root.elements("Table");
				for (Element element : list) {
					result += "[\"" + element.element("HYCODE").getTextTrim();
					result += "\",\"" + element.element("HYNAME").getTextTrim() + "\"";
					result += "],";
				}
			}
			result = result.substring(0, result.length() - 1);
			result += "]";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// ��ѯרҵ
	public static String QueryDataZy(String sql) {
		String result = "[[\"��ѡ��\",\"��ѡ��\"],";
		String result1 = "[[\"��ѡ��\",\"��ѡ��\"],";
		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			if (sss.equals("0")) {
				result = result1;
			} else {
				Document document = DocumentHelper.parseText(sss);
				Element root = document.getRootElement();
				List<Element> list = root.elements("Table");
				for (Element element : list) {
					result += "[\"" + element.element("ZYCODE").getTextTrim();
					result += "\",\"" + element.element("ZYNAME").getTextTrim() + "\"";
					result += "],";
				}
			}
			result = result.substring(0, result.length() - 1);
			result += "]";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// ��ѯruanjian ���ʹ�ü��𣬸������ע���ǵļ����ѯ
	public static String Queryunitlevel(String sql) {
		String result = "��ѡ��,";
		String result1 = "��ѡ��,";
		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			if (sss.equals("0")) {
				result = result1;
			} else {
				Document document = DocumentHelper.parseText(sss);
				Element root = document.getRootElement();
				List<Element> list = root.elements("Table");
				for (Element element : list) {
					result += element.element("ʹ�ü���").getTextTrim();
				}
			}

			result = result.substring(0, result.length() - 1);
			String[] arrsq = result.split(",");
			String sq2 = "";
			for (int i = 0; i < arrsq.length; i++) {
				sq2 += "\"" + arrsq[i] + "\",";
			}
			result = "[" + sq2.substring(0, sq2.length() - 1) + "]";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// ��ѯʹ�ü���
	public static String QueryDataLevel(String sql) {
		String result = "[[\"��ѡ��\",\"��ѡ��\"],";
		String result1 = "[[\"��ѡ��\",\"��ѡ��\"],";
		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			if (sss.equals("0")) {
				result = result1;
			} else {
				Document document = DocumentHelper.parseText(sss);
				Element root = document.getRootElement();
				List<Element> list = root.elements("Table");
				for (Element element : list) {
					result += "[\"" + element.element("LEVELCODE").getTextTrim();
					result += "\",\"" + element.element("LEVELNAME").getTextTrim() + "\"";
					result += "],";
				}
			}
			result = result.substring(0, result.length() - 1);
			result += "]";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static String Qdata3(String sql) {
		String result = "[[\"��ѡ��\",\"��ѡ��\"],";
		String result1 = "[[\"��ѡ��\",\"��ѡ��\"],";
		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			if (sss.equals("0")) {
				result = result1;
			} else {
				Document document = DocumentHelper.parseText(sss);
				Element root = document.getRootElement();
				List<Element> list = root.elements("Table");
				for (Element element : list) {

					result += "[\"" + element.element("NID").getTextTrim(); // +"<span
																			// color=\"red\">"
																			// </span>
					result += "\",\"" + element.element("����").getTextTrim() + "\"";
					result += "],";
				}
			}
			result = result.substring(0, result.length() - 1);
			result += "]";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static String Qdata4(String sql, String id) {
		String result = "[[\"��ѡ��\",\"��ѡ��\"],";
		String result1 = "[[\"��ѡ��\",\"��ѡ��\"],";
		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			if (sss.equals("0")) {
				result = result1;
			} else {
				Document document = DocumentHelper.parseText(sss);
				Element root = document.getRootElement();
				List<Element> list = root.elements("Table");
				for (Element element : list) {
					result += "[\"" + element.element("������").getTextTrim(); // +"<span
																				// color=\"red\">"
																				// </span>
					result += "\",\"" + element.element("�������").getTextTrim() + "\"";
					result += "],";
				}
			}
			result = result.substring(0, result.length() - 1);
			result += "]";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// ��񲿷�
	// ���1����
	public static String QdataRegist(String sql) {
		String result = "[";
		String result1 = "[]";
		String pguid = "[";
		String id = "[";
		String id1 = "[";
		String id2 = "[";
		String id3 = "[";
		String id4 = "[";
		String id5 = "[";
		String id6 = "[";
		String id7 = "[";
		int i;
		String arr[] = { "�����", "�ͻ���" };
		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			if (sss.equals("0")) {
				result = result1;
			} else {
				Document document = DocumentHelper.parseText(sss);
				Element root = document.getRootElement();
				List<Element> list = root.elements("Table");
				i = 1;
				Element element1 = null;
				for (Element element : list) {

					element1 = element.element("PGUID");
					if (element1 != null) {
						pguid += "\"";
						pguid += element1.getTextTrim() + "\",";
					} else {
						pguid += "\"\",";
					}

					id += "\"" + i + "\",";

					element1 = element.element("��ҵ");
					if (element1 != null) {
						id1 += "\"";
						id1 += element1.getTextTrim() + "\",";
					} else {
						id1 += "\"\",";
					}

					element1 = element.element("רҵ");
					if (element1 != null) {
						id2 += "\"";
						id2 += element1.getTextTrim() + "\",";
					} else {
						id2 += "\"\",";
					}

					element1 = element.element("�������");
					if (element1 != null) {
						id3 += "\"";
						id3 += element1.getTextTrim() + "\",";
					} else {
						id3 += "\"\",";
					}

					element1 = element.element("ʹ�ü���");
					if (element1 != null) {
						id4 += "\"";
						id4 += element1.getTextTrim() + "\",";
					} else {
						id4 += "\"\",";
					}

					element1 = element.element("�����");
					if (element1 != null) {
						id5 += "\"";
						id5 += arr[Integer.parseInt(element1.getTextTrim())] + "\",";
					} else {
						id5 += "\"\",";
					}

					element1 = element.element("WEB��Ŀ��");
					if (element1 != null) {
						id6 += "\"";
						id6 += element1.getTextTrim() + "\",";
					} else {
						id6 += "\"\",";
					}
					element1 = element.element("���˵��");
					if (element1 != null) {
						id7 += "\"";
						id7 += element1.getTextTrim() + "\",";
					} else {
						id7 += "\"\",";
					}

					i++;
				}

				pguid = pguid.substring(0, pguid.length() - 1);

				id = id.substring(0, id.length() - 1);
				id1 = id1.substring(0, id1.length() - 1);
				id2 = id2.substring(0, id2.length() - 1);
				id3 = id3.substring(0, id3.length() - 1);
				id4 = id4.substring(0, id4.length() - 1);
				id5 = id5.substring(0, id5.length() - 1);
				id6 = id6.substring(0, id6.length() - 1);
				id7 = id7.substring(0, id7.length() - 1);
				id7 = id7.replaceAll("\\\\", "\\\\\\\\");
				pguid += "],";

				id += "],";
				id1 += "],";
				id2 += "],";
				id3 += "],";
				id4 += "],";
				id5 += "],";
				id6 += "],";
				id7 += "]";
				result += pguid + id + id1 + id2 + id3 + id4 + id5 + id6 + id7 + "]";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// ���2
	public static String QdataIntall(String sql) {
		String result = "[";
		String result1 = "[]";
		String pguid = "[";
		String id = "[";
		String id1 = "[";
		String id2 = "[";
		String id3 = "[";
		String id4 = "[";
		String id5 = "[";
		String id6 = "[";
		String id7 = "[";
		String id8 = "[";
		String id9 = "[";
		String id10 = "[";
		String id11 = "[";
		int i;
		String arr[] = { "��ѡ��", "�ܹ�˾", "·��", "�����", "����", "����", "����" };
		String arr2[] = { "��ѡ��", "�ܹ�˾", "·��", "ͨ�Ŷ�", "����", "����", "����" };
		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			if (sss.equals("0")) {
				result = result1;
			} else {
				Document document = DocumentHelper.parseText(sss);
				Element root = document.getRootElement();
				List<Element> list = root.elements("Table");
				i = 1;
				Element element1 = null;
				for (Element element : list) {

					element1 = element.element("PGUID");
					if (element1 != null) {
						pguid += "\"";
						pguid += element1.getTextTrim() + "\",";
					} else {
						pguid += "\"\",";
					}

					id += "\"" + i + "\",";
					element1 = element.element("��װ��λ����");
					if (element1 != null) {
						id1 += "\"";
						id1 += element1.getTextTrim() + "\",";
					} else {
						id1 += "\"\",";
					}

					element1 = element.element("��װ��λ����");
					if (element1 != null) {
						id2 += "\"";
						if (element.element("רҵ").getTextTrim().equals("�ź�")) {
							id2 += arr[Integer.parseInt(element1.getTextTrim())] + "\",";
						}
						if (element.element("רҵ").getTextTrim().equals("ͨ��")) {
							id2 += arr2[Integer.parseInt(element1.getTextTrim())] + "\",";
						}

					} else {
						id2 += "\"\",";
					}

					element1 = element.element("�ϼ���λ����");
					if (element1 != null) {
						id3 += "\"";
						id3 += element1.getTextTrim() + "\",";
					} else {
						id3 += "\"\",";
					}

					element1 = element.element("�������");
					if (element1 != null) {
						id4 += "\"";
						id4 += element1.getTextTrim() + "\",";
					} else {
						id4 += "\"\",";
					}

					element1 = element.element("��װ�汾��");
					if (element1 != null) {
						id5 += "\"";
						id5 += element1.getTextTrim() + "\",";
					} else {
						id5 += "\"\",";
					}

					element1 = element.element("��װ������IP");
					if (element1 != null) {
						id6 += "\"";
						id6 += element1.getTextTrim() + "\",";
					} else {
						id6 += "\"\",";
					}

					element1 = element.element("��װ�������˿�");
					if (element1 != null) {
						id7 += "\"";
						id7 += element1.getTextTrim() + "\",";
					} else {
						id7 += "\"\",";
					}

					element1 = element.element("����˴������·��");
					if (element1 != null) {
						id8 += "\"";
						id8 += element1.getTextTrim() + "\",";
					} else {
						id8 += "\"\",";
					}

					element1 = element.element("��װ����");
					if (element1 != null) {
						id9 += "\"";
						id9 += element1.getTextTrim() + "\",";
					} else {
						id9 += "\"\",";
					}

					element1 = element.element("��װ��");
					if (element1 != null) {
						id10 += "\"";
						id10 += element1.getTextTrim() + "\",";
					} else {
						id10 += "\"\",";
					}

					element1 = element.element("��ע");
					if (element1 != null) {
						id11 += "\"";
						id11 += element1.getTextTrim() + "\",";
					} else {
						id11 += "\"\",";
					}

					i++;
				}

				pguid = pguid.substring(0, pguid.length() - 1);

				id = id.substring(0, id.length() - 1);
				id1 = id1.substring(0, id1.length() - 1);
				id2 = id2.substring(0, id2.length() - 1);
				id3 = id3.substring(0, id3.length() - 1);
				id4 = id4.substring(0, id4.length() - 1);
				id5 = id5.substring(0, id5.length() - 1);
				id6 = id6.substring(0, id6.length() - 1);
				id7 = id7.substring(0, id7.length() - 1);
				id8 = id8.substring(0, id8.length() - 1);
				id8 = id8.replaceAll("\\\\", "\\\\\\\\");
				id9 = id9.substring(0, id9.length() - 1);
				id10 = id10.substring(0, id10.length() - 1);
				id11 = id11.substring(0, id11.length() - 1);
				id11 = id11.replaceAll("\\\\", "\\\\\\\\");

				pguid += "],";

				id += "],";
				id1 += "],";
				id2 += "],";
				id3 += "],";
				id4 += "],";
				id5 += "],";
				id6 += "],";
				id7 += "],";
				id8 += "],";
				id9 += "],";
				id10 += "],";
				id11 += "]";
				result += pguid + id + id1 + id2 + id3 + id4 + id5 + id6 + id7 + id8 + id9 + id10 + id11 + "]";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// ���3
	public static String QdataProQuery(String sql) {
		String result = "[";
		String result1 = "[]";
		String pguid = "[";
		String i = "[";
		String id = "[";
		String id1 = "[";
		String id2 = "[";
		String id3 = "[";
		String id4 = "[";
		String id5 = "[";
		String id6 = "[";
		String id7 = "[";
		String id8 = "[";
		String id9 = "[";
		String id10 = "[";
		String id11 = "[";
		String id12 = "[";
		int ii = 1;
		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			if (sss.equals("0")) {
				result = result1;
			} else {
				Document document = DocumentHelper.parseText(sss);
				Element root = document.getRootElement();
				List<Element> list = root.elements("Table");
				Element element1 = null;

				for (Element element : list) {

					element1 = element.element("PGUID");
					if (element1 != null) {
						pguid += "\"";
						pguid += element1.getTextTrim() + "\",";
					} else {
						pguid += "\"\",";
					}
					i += "\"" + ii + "\",";
					element1 = element.element("��λ");
					if (element1 != null) {
						id += "\"";
						id += element1.getTextTrim() + "\",";
					} else {
						id += "\"\",";
					}

					element1 = element.element("�ϼ���λ");//ԭ���¼���λ����ʮһ���޸�
					if (element1 != null) {
						id1 += "\"";
						id1 += element1.getTextTrim() + "\",";
					} else {
						id1 += "\"\",";
					}

					element1 = element.element("����");
					if (element1 != null) {
						id2 += "\"";
						id2 += element1.getTextTrim() + "\",";
					} else {
						id2 += "\"\",";
					}

					element1 = element.element("��Ա");
					if (element1 != null) {
						id3 += "\"";
						id3 += element1.getTextTrim() + "\",";
					} else {
						id3 += "\"\",";
					}

					element1 = element.element("��ϵ�绰");
					if (element1 != null) {
						id4 += "\"";
						id4 += element1.getTextTrim() + "\",";
					} else {
						id4 += "\"\",";
					}
					element1 = element.element("���ϵͳ");
					if (element1 != null) {
						id5 += "\"";
						id5 += element1.getTextTrim() + "\",";
					} else {
						id5 += "\"\",";
					}

					element1 = element.element("���ʱ��");
					if (element1 != null) {
						id6 += "\"";
						id6 += element1.getTextTrim() + "\",";
					} else {
						id6 += "\"\",";
					}

					element1 = element.element("��������");
					if (element1 != null) {
						id7 += "\"";
						id7 += element1.getTextTrim() + "\",";
					} else {
						id7 += "\"\",";
					}
					element1 = element.element("�Ƿ���");
					if (element1 != null) {
						id8 += "\"";
						id8 += element1.getTextTrim() + "\",";
					} else {
						id8 += "\"\",";
					}

					element1 = element.element("���ʱ��");
					if (element1 != null) {
						id9 += "\"";
						id9 += element1.getTextTrim() + "\",";
					} else {
						id9 += "\"\",";
					}
					element1 = element.element("��������");
					if (element1 != null) {
						id10 += "\"";
						id10 += element1.getTextTrim() + "\",";
					} else {
						id10 += "\"\",";
					}
					element1 = element.element("��ע");
					if (element1 != null) {
						id11 += "\"";
						id11 += element1.getTextTrim() + "\",";
					} else {
						id11 += "\"\",";
					}
					element1 = element.element("��ͼ");
					if (element1 != null) {
						id12 += "\"";
						id12 += element1.getTextTrim() + "\",";
					} else {
						id12 += "\"\",";
					}
					ii++;
				}

				pguid = pguid.substring(0, pguid.length() - 1);
				i = i.substring(0, i.length() - 1);
				id = id.substring(0, id.length() - 1);
				id1 = id1.substring(0, id1.length() - 1);
				id2 = id2.substring(0, id2.length() - 1);
				id3 = id3.substring(0, id3.length() - 1);
				id4 = id4.substring(0, id4.length() - 1);
				id5 = id5.substring(0, id5.length() - 1);
				id6 = id6.substring(0, id6.length() - 1);
				id7 = id7.substring(0, id7.length() - 1);
				id8 = id8.substring(0, id8.length() - 1);
				id9 = id9.substring(0, id9.length() - 1);
				id10 = id10.substring(0, id10.length() - 1);
				id10 = id10.replaceAll("\\\\", "\\\\\\\\");
				id11 = id11.substring(0, id11.length() - 1);
				id11 = id11.replaceAll("\\\\", "\\\\\\\\");
				id12 = id12.substring(0, id12.length() - 1);
				pguid += "],";
				i += "],";
				id += "],";
				id1 += "],";
				id2 += "],";
				id3 += "],";
				id4 += "],";
				id5 += "],";
				id6 += "],";
				id7 += "],";
				id8 += "],";
				id9 += "],";
				id10 += "],";
				id11 += "],";
				id12 += "]";

				result += pguid + i + id1 + id + id2 + id3 + id4 + id5 + id6 + id7 + id8 + id9 + id10 + id11 + id12
						+ "]";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// �������������
	public static String QdataProQuery1(String sql) {
		String result = "[";
		String result1 = "[]";
		String pguid = "[";
		String i = "[";
		String id = "[";
		String id1 = "[";
		String id2 = "[";
		String id3 = "[";
		String wtnum = "[";
		String id5 = "[";
		String tcr = "[";// �����
		String fsbb = "[";// �����汾
		String jjsj = "[";// ���ʱ��
		String jjbb = "[";// ����汾
		String wtlxfslx="[";//wtlxfslx���ࣨ�������ͷ������ͣ�
		String gn="[";//����
		String id4 = "[";//��������
		String fsyy = "[";//����ԭ��
		String cxyfk = "[";//����Ա����
		String gsyj = "[";//��˾���
		String yjwcsj = "[";//Ԥ�����ʱ��
		String jjbf = "[";//����취
		String lxdh = "[";//��ϵ�绰
		
		int ii = 1;
		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			if (sss.equals("0")) {
				result = result1;
			} else {
				Document document = DocumentHelper.parseText(sss);
				Element root = document.getRootElement();
				List<Element> list = root.elements("Table");
				Element element1 = null;
				for (Element element : list) {
					element1 = element.element("PGUID");
					if (element1 != null) {
						pguid += "\""+ element1.getTextTrim() + "\",";
					} else {
						pguid += "\"\",";
					}
					i += "\"" + ii + "\",";
					element1 = element.element("������");
					if (element1 != null) {
						wtnum += "\""+ element1.getTextTrim() + "\",";
					} else {
						wtnum += "\"\",";
					}
					element1 = element.element("��λ");
					if (element1 != null) {
						id += "\""+ element1.getTextTrim() + "\",";
					} else {
						id += "\"\",";
					}
					element1 = element.element("�ϼ���λ");//ԭ���¼���λ����ʮһ���޸�
					if (element1 != null) {
						id1 += "\""+ element1.getTextTrim() + "\",";
					} else {
						id1 += "\"\",";
					}
					element1 = element.element("����");
					if (element1 != null) {
						id2 += "\""+ element1.getTextTrim() + "\",";
					} else {
						id2 += "\"\",";
					}
					// .......���¶���........�����
					element1 = element.element("��Ա");
					if (element1 != null) {
						tcr += "\""+ element1.getTextTrim() + "\",";
					} else {
						tcr += "\"\",";
					}

					element1 = element.element("���ʱ��");
					if (element1 != null) {
						id3 += "\""+ element1.getTextTrim() + "\",";
					} else {
						id3 += "\"\",";
					}
					// .......���¶���........����汾
					element1 = element.element("�����汾");
					if (element1 != null) {
						fsbb += "\""+ element1.getTextTrim() + "\",";
					} else {
						fsbb += "\"\",";
					}
					// .......���¶���.......���ʱ��.
					element1 = element.element("���ʱ��");
					if (element1 != null) {
						jjsj += "\""+ element1.getTextTrim() + "\",";
					} else {
						jjsj += "\"\",";
					}
					// .......���¶���.......���ʱ��.
					element1 = element.element("����汾");
					if (element1 != null) {
						jjbb += "\"" + element1.getTextTrim() + "\",";
					} else {
						jjbb += "\"\",";
					}
					// .......���¶���.......���ࣨ�������ͷ������ͣ�
					element1 = element.element("�������ͷ�������");
					if (element1 != null) {
						wtlxfslx += "\"" + element1.getTextTrim() + "\",";
					} else {
						wtlxfslx += "\"\",";
					}
					// .......���¶���.......���ࣨ�������ͷ������ͣ�
					element1 = element.element("����");
					if (element1 != null) {
						gn += "\"" + element1.getTextTrim() + "\",";
					} else {
						gn += "\"\",";
					}

					element1 = element.element("��������");
					if (element1 != null) {
						id4 += "\"" + element1.getTextTrim() + "\",";
					} else {
						id4 += "\"\",";
					}
					// .......���¶���.......����ԭ��
					element1 = element.element("����ԭ��");
					if (element1 != null) {
						fsyy += "\"" + element1.getTextTrim() + "\",";
					} else {
						fsyy += "\"\",";
					}
					// .......���¶���.......����Ա����
					element1 = element.element("����Ա����");
					if (element1 != null) {
						cxyfk += "\"" + element1.getTextTrim() + "\",";
					} else {
						cxyfk += "\"\",";
					}
					// .......��������.......����Ա����
					element1 = element.element("��˾���");
					if (element1 != null) {
						gsyj += "\"" + element1.getTextTrim() + "\",";
					} else {
						gsyj += "\"\",";
					}
					// .......��������.......Ԥ�����ʱ��
					element1 = element.element("Ԥ�����ʱ��");
					if (element1 != null) {
						yjwcsj += "\"" + element1.getTextTrim() + "\",";
					} else {
						yjwcsj += "\"\",";
					}
					// .......��������.......����취
					element1 = element.element("����취");
					if (element1 != null) {
						jjbf += "\"" + element1.getTextTrim() + "\",";
					} else {
						jjbf += "\"\",";
					}
					// .......��������.......��ϵ�绰
					element1 = element.element("��ϵ�绰");
					if (element1 != null) {
						lxdh += "\"" + element1.getTextTrim() + "\",";
					} else {
						lxdh += "\"\",";
					}

					element1 = element.element("��ע");
					if (element1 != null) {
						id5 += "\"";
						id5 += element1.getTextTrim() + "\",";
					} else {
						id5 += "\"\",";
					}

					ii++;
				}

				pguid = pguid.substring(0, pguid.length() - 1);
				i = i.substring(0, i.length() - 1);
				wtnum = wtnum.substring(0, wtnum.length() - 1);
				id = id.substring(0, id.length() - 1);
				id1 = id1.substring(0, id1.length() - 1);
				id2 = id2.substring(0, id2.length() - 1);
				tcr = tcr.substring(0, tcr.length() - 1);// �����
				id3 = id3.substring(0, id3.length() - 1);
				fsbb = fsbb.substring(0, fsbb.length() - 1);// �����汾
				jjsj = jjsj.substring(0, jjsj.length() - 1);// ���ʱ��
				jjbb = jjbb.substring(0, jjbb.length() - 1);// ����汾
				wtlxfslx = wtlxfslx.substring(0, wtlxfslx.length() - 1);// ����汾
				gn = gn.substring(0, gn.length() - 1);// ����
				id4 = id4.substring(0, id4.length() - 1);
				id4 = id4.replaceAll("\\\\", "\\\\\\\\");
				fsyy = fsyy.substring(0, fsyy.length() - 1);// ����ԭ��
				cxyfk = cxyfk.substring(0, cxyfk.length() - 1);// ����Ա����
				gsyj = gsyj.substring(0, gsyj.length() - 1);// ��˾���
				yjwcsj = yjwcsj.substring(0, yjwcsj.length() - 1);// Ԥ�����ʱ��
				jjbf = jjbf.substring(0, jjbf.length() - 1);// ����취
				lxdh = lxdh.substring(0, lxdh.length() - 1);// ��ϵ�绰
				id5 = id5.substring(0, id5.length() - 1);//��ע
				id5 = id5.replaceAll("\\\\", "\\\\\\\\");
				pguid += "],";
				i += "],";
				wtnum+="],";
				id += "],";
				id1 += "],";
				id2 += "],";
				tcr += "],";
				id3 += "],";
				fsbb += "],";
				jjsj += "],";
				jjbb += "],";
				wtlxfslx+="],";
				gn+="],";
				id4 += "],";
				fsyy+="],";
				cxyfk+="],";
				gsyj+="],";
				yjwcsj+="],";
				jjbf+="],";
				lxdh+="],";
				id5 += "]";
				result += pguid + i+wtnum + id1 + id + id2 + tcr + id3 + fsbb +jjsj+jjbb+wtlxfslx+ gn+id4+fsyy+cxyfk+gsyj +yjwcsj+jjbf+lxdh+ id5 + "]";
			}
			// result=result.substring(0, result.length()-1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// ���̰�װ��ʾ------------��ɾ��  û����  9��2�� ��
	public static String QdataProQuerygc1(String sql) {
		String result = "[";
		String result1 = "[]";
		String pguid = "[";
		String i = "[";
		String id = "[";
		String id1 = "[";
		String id2 = "[";
		String id3 = "[";
		String id4 = "[";
		String id5 = "[";
		int ii = 1;
		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			if (sss.equals("0")) {
				result = result1;
			} else {
				Document document = DocumentHelper.parseText(sss);
				Element root = document.getRootElement();
				List<Element> list = root.elements("Table");
				Element element1 = null;

				for (Element element : list) {

					element1 = element.element("PGUID");
					if (element1 != null) {
						pguid += "\"";
						pguid += element1.getTextTrim() + "\",";
					} else {
						pguid += "\"\",";
					}
					i += "\"" + ii + "\",";
					element1 = element.element("��λ");
					if (element1 != null) {
						id += "\"";
						id += element1.getTextTrim() + "\",";
					} else {
						id += "\"\",";
					}

					element1 = element.element("�ϼ���λ");//ԭ���¼���λ����ʮһ���޸�
					if (element1 != null) {
						id1 += "\"";
						id1 += element1.getTextTrim() + "\",";
					} else {
						id1 += "\"\",";
					}

					element1 = element.element("���ϵͳ");
					if (element1 != null) {
						id2 += "\"";
						id2 += element1.getTextTrim() + "\",";
					} else {
						id2 += "\"\",";
					}

					element1 = element.element("���ʱ��");
					if (element1 != null) {
						id3 += "\"";
						id3 += element1.getTextTrim() + "\",";
					} else {
						id3 += "\"\",";
					}

					element1 = element.element("��������");
					if (element1 != null) {
						id4 += "\"";
						id4 += element1.getTextTrim() + "\",";
					} else {
						id4 += "\"\",";
					}
					element1 = element.element("��ע");
					if (element1 != null) {
						id5 += "\"";
						id5 += element1.getTextTrim() + "\",";
					} else {
						id5 += "\"\",";
					}

					ii++;
				}

				pguid = pguid.substring(0, pguid.length() - 1);
				i = i.substring(0, i.length() - 1);
				id = id.substring(0, id.length() - 1);
				id1 = id1.substring(0, id1.length() - 1);
				id2 = id2.substring(0, id2.length() - 1);
				id3 = id3.substring(0, id3.length() - 1);
				id4 = id4.substring(0, id4.length() - 1);
				id4 = id4.replaceAll("\\\\", "\\\\\\\\");
				id5 = id5.substring(0, id5.length() - 1);
				id5 = id5.replaceAll("\\\\", "\\\\\\\\");
				pguid += "],";
				i += "],";
				id += "],";
				id1 += "],";
				id2 += "],";
				id3 += "],";
				id4 += "],";
				id5 += "]";

				result += pguid + i + id1 + id + id2 + id3 + id4 + id5 + "]";
			}
			// result=result.substring(0, result.length()-1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// ���̰�װȫ����Ϣ��ѯ
	public static String QdataProQuerygc(String sql) {
		String result = "[";
		String result1 = "[]";
		String pguid = "[";
		String i = "[";
		String id = "[";
		String id1 = "[";
		String id2 = "[";
		String id3 = "[";
		String id4 = "[";
		String id5 = "[";
		String id6 = "[";
		String id7 = "[";
		String id8 = "[";
		String id9 = "[";

		int ii = 1;
		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			if (sss.equals("0")) {
				result = result1;
			} else {
				Document document = DocumentHelper.parseText(sss);
				Element root = document.getRootElement();
				List<Element> list = root.elements("Table");
				Element element1 = null;

				for (Element element : list) {

					element1 = element.element("PGUID");
					if (element1 != null) {
						pguid += "\"";
						pguid += element1.getTextTrim() + "\",";
					} else {
						pguid += "\"\",";
					}
					i += "\"" + ii + "\",";
					element1 = element.element("��λ");
					if (element1 != null) {
						id += "\"";
						id += element1.getTextTrim() + "\",";
					} else {
						id += "\"\",";
					}

					element1 = element.element("�ϼ���λ");//ԭ���¼���λ����ʮһ���޸�
					if (element1 != null) {
						id1 += "\"";
						id1 += element1.getTextTrim() + "\",";
					} else {
						id1 += "\"\",";
					}

					element1 = element.element("���ϵͳ");
					if (element1 != null) {
						id2 += "\"";
						id2 += element1.getTextTrim() + "\",";
					} else {
						id2 += "\"\",";
					}

					element1 = element.element("���ʱ��");
					if (element1 != null) {
						id3 += "\"";
						id3 += element1.getTextTrim() + "\",";
					} else {
						id3 += "\"\",";
					}

					element1 = element.element("��������");
					if (element1 != null) {
						id4 += "\"";
						id4 += element1.getTextTrim() + "\",";
					} else {
						id4 += "\"\",";
					}
					element1 = element.element("�Ƿ���");
					if (element1 != null) {
						id5 += "\"";
						id5 += element1.getTextTrim() + "\",";
					} else {
						id5 += "\"\",";
					}

					element1 = element.element("���ʱ��");
					if (element1 != null) {
						id6 += "\"";
						id6 += element1.getTextTrim() + "\",";
					} else {
						id6 += "\"\",";
					}

					element1 = element.element("��������");
					if (element1 != null) {
						id7 += "\"";
						id7 += element1.getTextTrim() + "\",";
					} else {
						id7 += "\"\",";
					}
					element1 = element.element("��ע");
					if (element1 != null) {
						id8 += "\"";
						id8 += element1.getTextTrim() + "\",";
					} else {
						id8 += "\"\",";
					}

					element1 = element.element("��ͼ");
					if (element1 != null) {
						id9 += "\"";
						id9 += element1.getTextTrim() + "\",";
					} else {
						id9 += "\"\",";
					}

					ii++;
				}

				pguid = pguid.substring(0, pguid.length() - 1);
				i = i.substring(0, i.length() - 1);
				id = id.substring(0, id.length() - 1);
				id1 = id1.substring(0, id1.length() - 1);
				id2 = id2.substring(0, id2.length() - 1);
				id3 = id3.substring(0, id3.length() - 1);
				id4 = id4.substring(0, id4.length() - 1);
				id5 = id5.substring(0, id5.length() - 1);
				id6 = id6.substring(0, id6.length() - 1);
				id7 = id7.substring(0, id7.length() - 1);
				id7 = id7.replaceAll("\\\\", "\\\\\\\\");
				id8 = id8.substring(0, id8.length() - 1);
				id8 = id8.replaceAll("\\\\", "\\\\\\\\");
				id9 = id9.substring(0, id9.length() - 1);

				pguid += "],";
				i += "],";
				id += "],";
				id1 += "],";
				id2 += "],";
				id3 += "],";
				id4 += "],";
				id5 += "],";
				id6 += "],";
				id7 += "],";
				id8 += "],";
				id9 += "]";

				result += pguid + i + id1 + id + id2 + id3 + id4 + id5 + id6 + id7 + id8 + id9 + "]";
			}
			// result=result.substring(0, result.length()-1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	
	public static String jdsxQuery(String sql) {
		String result = "[";
		String result1 = "[]";
		String id1 = "[";
		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			if (sss.equals("0")) {
				result = result1;
			} else {
				Document document = DocumentHelper.parseText(sss);
				Element root = document.getRootElement();
				List<Element> list = root.elements("Table");
				Element element1 = null;
				for (Element element : list) {
					element1 = element.element("A");
					if (element1 != null) {
						id1 += "\"" + element1.getTextTrim() + "\",";
					} else {
						id1 += "\"\",";
					}
				}
				id1 = id1.substring(0, id1.length() - 1);
				id1 += "]";
				result += id1 + "]";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// ����ʵʩ��ѯ��ͷ
	public static String tableQuery(String sql) {
		String result = "[";
		String result1 = "[]";
		String id1 = "[";
		String id2 = "[";
		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			if (sss.equals("0")) {
				result = result1;
			} else {
				Document document = DocumentHelper.parseText(sss);
				Element root = document.getRootElement();
				List<Element> list = root.elements("Table");
				Element element1 = null;
				for (Element element : list) {
					element1 = element.element("�׶�����");
					if (element1 != null) {
						id1 += "\"" + element1.getTextTrim() + "\",";
					} else {
						id1 += "\"\",";
					}
					element1 = element.element("������");
					if (element1 != null) {
						id2 += "\"" + element1.getTextTrim() + "\",";
					} else {
						id2 += "\"\",";
					}
				}
				id1 = id1.substring(0, id1.length() - 1);
				id2 = id2.substring(0, id2.length() - 1);
				id1 += "]";
				id2 += "]";
				result += id1 + "," + id2 + "]";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// ����ʵʩ��ѯ�������
	public static String tabledataQuery(String sql, String sqjieduanname) {

		List<JdData> JdData1 = new ArrayList<>();
		JdData1.clear();
		int jiequ = sqjieduanname.indexOf("],[");
		if (jiequ < 0) {
			return "[]";
		}
		sqjieduanname = sqjieduanname.substring(0, jiequ);
		sqjieduanname = sqjieduanname.replace("[", "");
		sqjieduanname = sqjieduanname.replace("]", "");
		String[] array = sqjieduanname.split(",");
		String[] arrayname = { "һ�׶�", "���׶�", "���׶�", "�Ľ׶�", "��׶�", "���׶�", "�߽׶�", "�˽׶�", "�Ž׶�", "ʮ�׶�" };
		String result = "[";
		String result1 = "[]";

		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			if (sss.equals("0")) {
				result = result1;
			} else {
				Document document = DocumentHelper.parseText(sss);
				Element root = document.getRootElement();
				List<Element> list = root.elements("Table");
				Element element1 = null;
				for (Element element : list) {
					JdData mJdData = new JdData();
					element1 = element.element("��λ����");
					if (element1 != null) {
						mJdData.UnitName = element1.getTextTrim();
					}
					element1 = element.element("�ϼ���λ");
					if (element1 != null) {
						mJdData.UpUnitName = element1.getTextTrim();
					}
					element1 = element.element("PGUID");
					if (element1 != null) {
						mJdData.Pguid = element1.getTextTrim();
					}
					for (int i = 0; i < array.length; i++) {
						array[i] = arrayname[i];
						element1 = element.element(array[i]);
						if (element1 != null) {
							mJdData.JdStr[i] = element1.getTextTrim();
						}
					}
					element1 = element.element("��λ����");
					if (element1 != null) {
						mJdData.Type = element1.getTextTrim();
					}
					element1 = element.element("���ȱ�ע");
					if (element1 != null) {
						mJdData.jdBeizhu = element1.getTextTrim();
						mJdData.jdBeizhu = mJdData.jdBeizhu.replaceAll("\\\\", "\\\\\\\\");
					}
					JdData1.add(mJdData);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (JdData1.size() == 0) {
			return "[]";
		}
		DoUnitData mDoUnitData = new DoUnitData(JdData1);
		String json = mDoUnitData.doMyjieduanvalue(array.length);
		return json;
	}

	// ��ѯ�׶ζ�����Ϣ
	public static String jieduanQuery(String sql) {

		String result = "[";
		String result1 = "[]";
		String pguid = "[";
		String i = "[";
		String id = "[";
		String id1 = "[";
		String id2 = "[";
		String arr[] = { "��ѡ��", "��һ�׶�", "�ڶ��׶�", "�����׶�", "���Ľ׶�", "����׶�", "�����׶�", "���߽׶�", "�ڰ˽׶�", "�ھŽ׶�", "��ʮ�׶�" };
		int ii = 1;
		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			if (sss.equals("0")) {
				result = result1;
			} else {
				Document document = DocumentHelper.parseText(sss);
				Element root = document.getRootElement();
				List<Element> list = root.elements("Table");
				Element element1 = null;
				for (Element element : list) {
					element1 = element.element("PGUID");
					if (element1 != null) {
						pguid += "\"" + element1.getTextTrim() + "\",";
					} else {
						pguid += "\"\",";
					}
					i += "\"" + ii + "\",";
					element1 = element.element("�ֶ�����");
					if (element1 != null) {
						id += "\"" + arr[Integer.parseInt(element1.getTextTrim())] + "\",";
					} else {
						id += "\"\",";
					}
					element1 = element.element("�׶�����");
					if (element1 != null) {
						id1 += "\"" + element1.getTextTrim() + "\",";
					} else {
						id1 += "\"\",";
					}

					element1 = element.element("������");
					if (element1 != null) {
						id2 += "\"" + element1.getTextTrim() + "\",";
					} else {
						id2 += "\"\",";
					}
					ii++;
				}
				pguid = pguid.substring(0, pguid.length() - 1);
				i = i.substring(0, i.length() - 1);
				id = id.substring(0, id.length() - 1);
				id1 = id1.substring(0, id1.length() - 1);
				id2 = id2.substring(0, id2.length() - 1);
				pguid += "],";
				i += "],";
				id += "],";
				id1 += "],";
				id2 += "]";
				result += pguid + i + id + id1 + id2 + "]";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// ����ʵʩ��ѯ���м��ر��
	public static String impTableQuery(String sql) {
		String result = "[";
		String result1 = "[]";
		List<JdData> JdData1 = new ArrayList<>();
		JdData1.clear();
		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			if (sss.equals("0")) {
				result = result1;
			} else {
				Document document = DocumentHelper.parseText(sss);
				Element root = document.getRootElement();
				List<Element> list = root.elements("Table");
				Element element1 = null;
				for (Element element : list) {
					JdData mJdData = new JdData();
					element1 = element.element("PGUID");
					if (element1 != null) {
						mJdData.Pguid = element1.getTextTrim();
					}
					element1 = element.element("��λ����");
					if (element1 != null) {
						mJdData.UnitName = element1.getTextTrim();
					}
					element1 = element.element("ʩ���ƻ�");
					if (element1 != null) {
						mJdData.Sgplay = element1.getTextTrim();
					}
					element1 = element.element("��ϵ��");
					if (element1 != null) {
						mJdData.Sgtellphone = element1.getTextTrim();
					}
					element1 = element.element("��˾������");
					if (element1 != null) {
						mJdData.Gstellphone = element1.getTextTrim();
					}
					element1 = element.element("���̱�ע");
					if (element1 != null) {
						mJdData.Beizhu = element1.getTextTrim();
						mJdData.Beizhu = mJdData.Beizhu.replaceAll("\\\\", "\\\\\\\\");
					}
					element1 = element.element("�ϼ���λ");
					if (element1 != null) {
						mJdData.UpUnitName = element1.getTextTrim();
					}
					element1 = element.element("��λ����");
					if (element1 != null) {
						mJdData.Type = element1.getTextTrim();
					}
					JdData1.add(mJdData);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (JdData1.size() == 0) {
			return "[]";
		}
		DoUnitData mDoUnitData = new DoUnitData(JdData1);
		String json = mDoUnitData.doMyUnitName();
		return json;
	}

	// gongshis����ʵʩ��λ���Ʋ�ѯ
	public static String implementQuery(String sql) {
		String result = "[";
		String result1 = "[]";
		String id1 = "[\"��ѡ��\",";
		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			if (sss.equals("0")) {
				result = result1;
			} else {
				Document document = DocumentHelper.parseText(sss);
				Element root = document.getRootElement();
				List<Element> list = root.elements("Table");
				Element element1 = null;
				for (Element element : list) {
					element1 = element.element("��λ����");
					if (element1 != null) {
						id1 += "\"" + element1.getTextTrim() + "\",";
					} else {
						id1 += "\"\",";
					}
				}
				id1 = id1.substring(0, id1.length() - 1);
				id1 += "]";
				result += id1 + "]";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// ����ʵʩ�޸Ĳ�ѯ����
	public static String impTableQuerych(String sql) {
		String result = "[";
		String result1 = "[]";
		String i = "[";
		int ii = 1;
		String id1 = "[";
		String id2 = "[";
		String id3 = "[";
		String id4 = "[";
		String id5 = "[";
		String id6 = "[";
		String id7 = "[";
		String pguid = "[";

		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			if (sss.equals("0")) {
				result = result1;
			} else {
				Document document = DocumentHelper.parseText(sss);
				Element root = document.getRootElement();
				List<Element> list = root.elements("Table");
				Element element1 = null;
				for (Element element : list) {
					element1 = element.element("PGUID");
					if (element1 != null) {
						pguid += "\"" + element1.getTextTrim() + "\",";
					} else {
						pguid += "\"\",";
					}
					i += "\"" + ii + "\",";
					ii++;
					element1 = element.element("��λ����");
					if (element1 != null) {
						id1 += "\"" + element1.getTextTrim() + "\",";
					} else {
						id1 += "\"\",";
					}
					element1 = element.element("ʩ���ƻ�");
					if (element1 != null) {
						id2 += "\"" + element1.getTextTrim() + "\",";
					} else {
						id2 += "\"\",";
					}
					element1 = element.element("��ϵ��");
					if (element1 != null) {
						id3 += "\"" + element1.getTextTrim() + "\",";
					} else {
						id3 += "\"\",";
					}
					element1 = element.element("��˾������");
					if (element1 != null) {
						id4 += "\"" + element1.getTextTrim() + "\",";
					} else {
						id4 += "\"\",";
					}
					element1 = element.element("���̱�ע");
					if (element1 != null) {
						id5 += "\"" + element1.getTextTrim() + "\",";
					} else {
						id5 += "\"\",";
					}
					element1 = element.element("��λ����");
					if (element1 != null) {
						id6 += "\"" + element1.getTextTrim() + "\",";
					} else {
						id6 += "\"\",";
					}
					element1 = element.element("�ϼ���λ");
					if (element1 != null) {
						id7 += "\"";
						id7 += element1.getTextTrim() + "\",";
					} else {
						id7 += "\"\",";
					}
				}
				id1 = id1.substring(0, id1.length() - 1);
				id2 = id2.substring(0, id2.length() - 1);
				id3 = id3.substring(0, id3.length() - 1);
				id4 = id4.substring(0, id4.length() - 1);
				id5 = id5.substring(0, id5.length() - 1);
				id5 = id5.replaceAll("\\\\", "\\\\\\\\");
				id6 = id6.substring(0, id6.length() - 1);
				id7 = id7.substring(0, id7.length() - 1);
				pguid = pguid.substring(0, pguid.length() - 1);
				i = i.substring(0, i.length() - 1);
				/*
				 * id1 += "]"; id2 += "]"; id3 += "]"; id4 += "]"; id5 += "]";
				 * id6 += "]"; id7 += "]"; pguid += "]"; i += "]";
				 */
				result += pguid + "]," + i + "]," + id1 + "]," + id2 + "]," + id3 + "]," + id4 + "]," + id5 + "]," + id6
						+ "]," + id7 + "]]";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// �û���

	public static String QdataUser(String sql) {
		String result = "[";
		String result1 = "[[\"��ѡ��\",\"��ѡ��\"],";
		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			if (sss.equals("0")) {
				result = result1;
			} else {
				Document document = DocumentHelper.parseText(sss);
				Element root = document.getRootElement();
				List<Element> list = root.elements("Table");
				String element1 = null;
				for (Element element : list) {
					result += "[\"" + element.element("USERID").getTextTrim();
					result += "\",\"" + element.element("����").getTextTrim() + "\"";
					result += ",\"" + element.element("�û���").getTextTrim() + "\"";
					result += ",\"" + element.element("����").getTextTrim() + "\"";
					element1 = element.element("Ȩ��").getTextTrim();
					if (element1 != null) {
						result += ",\"" + element1 + "\"";
					} else {
						result += ",\"\"";
					}
					result += ",\"" + element.element("�Ƿ�༭").getTextTrim() + "\"";

					result += "],";
				}
			}
			result = result.substring(0, result.length() - 1);
			result += "]";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	//

	public static String QdataUserTable(String sql) {
		String result = "[";
		String result1 = "[]";
		/* String pguid="["; */
		String i = "[";
		String id = "[";
		String id1 = "[";
		String id2 = "[";
		String id3 = "[";
		String id4 = "[";
		String id5 = "[";
		int ii = 1;
		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			if (sss.equals("0")) {
				result = result1;
			} else {
				Document document = DocumentHelper.parseText(sss);
				Element root = document.getRootElement();
				List<Element> list = root.elements("Table");
				Element element1 = null;
				for (Element element : list) {
					i += "\"" + ii + "\",";
					element1 = element.element("USERID");
					if (element1 != null) {
						id += "\"";
						id += element1.getTextTrim() + "\",";
					} else {
						id += "\"\",";
					}

					element1 = element.element("����");
					if (element1 != null) {
						id1 += "\"";
						id1 += element1.getTextTrim() + "\",";
					} else {
						id1 += "\"\",";
					}

					element1 = element.element("�û���");
					if (element1 != null) {
						id2 += "\"";
						id2 += element1.getTextTrim() + "\",";
					} else {
						id2 += "\"\",";
					}

					element1 = element.element("����");
					if (element1 != null) {
						id3 += "\"";
						id3 += element1.getTextTrim() + "\",";
					} else {
						id3 += "\"\",";
					}

					element1 = element.element("Ȩ��");
					if (element1 != null) {
						id4 += "\"";
						id4 += element1.getTextTrim() + "\",";
					} else {
						id4 += "\"\",";
					}

					element1 = element.element("�Ƿ�༭");
					if (element1 != null) {
						id5 += "\"";
						id5 += element1.getTextTrim() + "\",";
					} else {
						id5 += "\"\",";
					}
					ii++;

				}

				/* pguid=pguid.substring(0, pguid.length()-1); */
				i = i.substring(0, i.length() - 1);
				id = id.substring(0, id.length() - 1);
				id1 = id1.substring(0, id1.length() - 1);
				id2 = id2.substring(0, id2.length() - 1);
				id3 = id3.substring(0, id3.length() - 1);
				id4 = id4.substring(0, id4.length() - 1);
				id5 = id5.substring(0, id5.length() - 1);

				/* pguid+="],"; */
				i += "],";
				id += "],";
				id1 += "],";
				id2 += "],";
				id3 += "],";
				id4 += "],";
				id5 += "]";

				result += id + i + id1 + id2 + id3 + id4 + id5 + "]";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	// �����޸�ǰ���ݲ�ѯ����

	public static String QdataCHQuery(String sql) {
		String result = "[";
		String result1 = "[]";
		String pguid = "[";
		String i = "[";
		String id = "[";
		String id1 = "[";
		String id2 = "[";
		String id3 = "[";
		String id4 = "[";
		String id5 = "[";
		String id6 = "[";
		//String id7 = "[";
		String id8 = "[";
		String id9 = "[";
		String id10 = "[";
		String id11 = "[";
		String id12 = "[";
		String id13 = "[";
		
	
		String id14 = "[";
		String id15 = "[";
		String id16 = "[";
		String id17 = "[";
		String id18 = "[";
		String id19 = "[";
		String id20 = "[";
     
		int ii = 1;
		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			if (sss.equals("0")) {
				result = result1;
			} else {
				Document document = DocumentHelper.parseText(sss);
				Element root = document.getRootElement();
				List<Element> list = root.elements("Table");
				Element element1 = null;

				for (Element element : list) {

					element1 = element.element("PGUID");
					if (element1 != null) {
						pguid += "\"";
						pguid += element1.getTextTrim() + "\",";
					} else {
						pguid += "\"\",";
					}
					i += "\"" + ii + "\",";
					element1 = element.element("��λ");
					if (element1 != null) {
						id += "\"";
						id += element1.getTextTrim() + "\",";
					} else {
						id += "\"\",";
					}

					element1 = element.element("�ϼ���λ");//ԭ���¼���λ����ʮһ���޸�
					if (element1 != null) {
						id1 += "\"";
						id1 += element1.getTextTrim() + "\",";
					} else {
						id1 += "\"\",";
					}

					element1 = element.element("����");
					if (element1 != null) {
						id2 += "\"";
						id2 += element1.getTextTrim() + "\",";
					} else {
						id2 += "\"\",";
					}

					element1 = element.element("��Ա");
					if (element1 != null) {
						id3 += "\"";
						id3 += element1.getTextTrim() + "\",";
					} else {
						id3 += "\"\",";
					}

					element1 = element.element("��ϵ�绰");
					if (element1 != null) {
						id4 += "\"";
						id4 += element1.getTextTrim() + "\",";
					} else {
						id4 += "\"\",";
					}
					element1 = element.element("���ϵͳ");
					if (element1 != null) {
						id5 += "\"";
						id5 += element1.getTextTrim() + "\",";
					} else {
						id5 += "\"\",";
					}

					element1 = element.element("���ʱ��");
					if (element1 != null) {
						id6 += "\"";
						id6 += element1.getTextTrim() + "\",";
					} else {
						id6 += "\"\",";
					}

					/*element1 = element.element("��������");
					if (element1 != null) {
						id7 += "\"";
						id7 += element1.getTextTrim() + "\",";
					} else {
						id7 += "\"\",";
					}*/
					element1 = element.element("��������");
					if (element1 != null) {
						id8 += "\"";
						id8 += element1.getTextTrim() + "\",";
					} else {
						id8 += "\"\",";
					}

					element1 = element.element("��ҵ");
					if (element1 != null) {
						id9 += "\"";
						id9 += element1.getTextTrim() + "\",";
					} else {
						id9 += "\"\",";
					}
					element1 = element.element("רҵ");
					if (element1 != null) {
						id10 += "\"";
						id10 += element1.getTextTrim() + "\",";
					} else {
						id10 += "\"\",";
					}
					element1 = element.element("��ͼ");
					if (element1 != null) {
						id11 += "\"";
						id11 += element1.getTextTrim() + "\",";
					} else {
						id11 += "\"\",";
					}
					element1 = element.element("��ע");
					if (element1 != null) {
						id12 += "\"";
						id12 += element1.getTextTrim() + "\",";
					} else {
						id12 += "\"\",";
					}
					element1 = element.element("�������ͷ�������");
					if (element1 != null) {
						id13 += "\"";
						id13 += element1.getTextTrim() + "\",";
					} else {
						id13 += "\"\",";
					}
					
					//����������
					element1 = element.element("�����汾");
					if (element1 != null) {
						id14 += "\"";
						id14 += element1.getTextTrim() + "\",";
					} else {
						id14 += "\"\",";
					}
					element1 = element.element("����");
					if (element1 != null) {
						id15 += "\"";
						id15 += element1.getTextTrim() + "\",";
					} else {
						id15 += "\"\",";
					}
					element1 = element.element("����ԭ��");
					if (element1 != null) {
						id16 += "\"";
						id16 += element1.getTextTrim() + "\",";
					} else {
						id16 += "\"\",";
					}
					element1 = element.element("����Ա����");
					if (element1 != null) {
						id17 += "\"";
						id17 += element1.getTextTrim() + "\",";
					} else {
						id17 += "\"\",";
					}
					element1 = element.element("��˾���");
					if (element1 != null) {
						id18 += "\"";
						id18 += element1.getTextTrim() + "\",";
					} else {
						id18 += "\"\",";
					}
					element1 = element.element("�޸ļƻ�");
					if (element1 != null) {
						id19 += "\"";
						id19 += element1.getTextTrim() + "\",";
					} else {
						id19 += "\"\",";
					}
					element1 = element.element("����취");
					if (element1 != null) {
						id20 += "\"";
						id20 += element1.getTextTrim() + "\",";
					} else {
						id20 += "\"\",";
					}
					
					ii++;
				}

				pguid = pguid.substring(0, pguid.length() - 1);
				i = i.substring(0, i.length() - 1);
				id = id.substring(0, id.length() - 1);
				id1 = id1.substring(0, id1.length() - 1);
				id2 = id2.substring(0, id2.length() - 1);
				id3 = id3.substring(0, id3.length() - 1);
				id4 = id4.substring(0, id4.length() - 1);
				id5 = id5.substring(0, id5.length() - 1);
				id6 = id6.substring(0, id6.length() - 1);
				//id7 = id7.substring(0, id7.length() - 1);
				id8 = id8.substring(0, id8.length() - 1);
				id8 = id8.replaceAll("\\\\", "\\\\\\\\");
				id9 = id9.substring(0, id9.length() - 1);
				id10 = id10.substring(0, id10.length() - 1);
				id11 = id11.substring(0, id11.length() - 1);
				id12 = id12.substring(0, id12.length() - 1);
				id12 = id12.replaceAll("\\\\", "\\\\\\\\");
				id13 = id13.substring(0, id13.length() - 1);
				
				id14 = id14.substring(0, id14.length() - 1);
				id15 = id15.substring(0, id15.length() - 1);
				id16 = id16.substring(0, id16.length() - 1);
				id17 = id17.substring(0, id17.length() - 1);
				id18 = id18.substring(0, id18.length() - 1);
				id19 = id19.substring(0, id19.length() - 1);
				id20 = id20.substring(0, id20.length() - 1);
				pguid += "],";
				i += "],";
				id += "],";
				id1 += "],";
				id2 += "],";
				id3 += "],";
				id4 += "],";
				id5 += "],";
				id6 += "],";
			//	id7 += "],";
				id8 += "],";
				id9 += "],";
				id10 += "],";
				id11 += "],";
				id12 += "],";
				
				id13 += "],";
				id14 += "],";
				id15 += "],";
				id16 += "],";
				id17 += "],";
				id18 += "],";
				id19 += "],";
				id20 += "]";
				

				result += pguid + i + id1 + id + id2 + id3 + id4 + id5 + id6 +  id8 + id9 + id10 + id11 + id12
						+ id13+ id14 +id15 +id16 +id17+id18 +id19 +id20 + "]";
			}
			// result=result.substring(0, result.length()-1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// ��װ��¼�޸�
	public static String QdataCHQuery2(String sql) {
		String result = "[";
		String result1 = "[]";
		String pguid = "[";
		String id = "[";
		String id1 = "[";
		String id2 = "[";
		String id3 = "[";
		String id4 = "[";
		String id5 = "[";
		String id6 = "[";
		String id7 = "[";
		String id8 = "[";
		String id9 = "[";
		String id10 = "[";
		String id11 = "[";
		String id12 = "[";
		String id13 = "[";
		int i;
		String arr[] = { "��ѡ��", "�ܹ�˾", "·��", "�����", "����", "����", "����" };
		String arr2[] = { "��ѡ��", "�ܹ�˾", "·��", "ͨ�Ŷ�", "����", "����", "����" };
		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			if (sss.equals("0")) {
				result = result1;
			} else {
				Document document = DocumentHelper.parseText(sss);
				Element root = document.getRootElement();
				List<Element> list = root.elements("Table");
				i = 1;
				Element element1 = null;
				for (Element element : list) {

					element1 = element.element("PGUID");
					if (element1 != null) {
						pguid += "\"";
						pguid += element1.getTextTrim() + "\",";
					} else {
						pguid += "\"\",";
					}

					id += "\"" + i + "\",";
					element1 = element.element("��װ��λ����");
					if (element1 != null) {
						id1 += "\"";
						id1 += element1.getTextTrim() + "\",";
					} else {
						id1 += "\"\",";
					}

					element1 = element.element("��װ��λ����");
					if (element1 != null) {
						id2 += "\"";
						if (element.element("רҵ").getTextTrim().equals("�ź�")) {
							id2 += arr[Integer.parseInt(element1.getTextTrim())] + "\",";
						}
						if (element.element("רҵ").getTextTrim().equals("ͨ��")) {
							id2 += arr2[Integer.parseInt(element1.getTextTrim())] + "\",";
						}
					} else {
						id2 += "\"\",";
					}

					element1 = element.element("�ϼ���λ����");
					if (element1 != null) {
						id3 += "\"";
						id3 += element1.getTextTrim() + "\",";
					} else {
						id3 += "\"\",";
					}

					element1 = element.element("�������");
					if (element1 != null) {
						id4 += "\"";
						id4 += element1.getTextTrim() + "\",";
					} else {
						id4 += "\"\",";
					}

					element1 = element.element("��װ�汾��");
					if (element1 != null) {
						id5 += "\"";
						id5 += element1.getTextTrim() + "\",";
					} else {
						id5 += "\"\",";
					}

					element1 = element.element("��װ������IP");
					if (element1 != null) {
						id6 += "\"";
						id6 += element1.getTextTrim() + "\",";
					} else {
						id6 += "\"\",";
					}

					element1 = element.element("��װ�������˿�");
					if (element1 != null) {
						id7 += "\"";
						id7 += element1.getTextTrim() + "\",";
					} else {
						id7 += "\"\",";
					}

					element1 = element.element("����˴������·��");
					if (element1 != null) {
						id8 += "\"";
						id8 += element1.getTextTrim() + "\",";
					} else {
						id8 += "\"\",";
					}

					element1 = element.element("��װ����");
					if (element1 != null) {
						id9 += "\"";
						id9 += element1.getTextTrim() + "\",";
					} else {
						id9 += "\"\",";
					}

					element1 = element.element("��װ��");
					if (element1 != null) {
						id10 += "\"";
						id10 += element1.getTextTrim() + "\",";
					} else {
						id10 += "\"\",";
					}

					element1 = element.element("��ע");
					if (element1 != null) {
						id11 += "\"";
						id11 += element1.getTextTrim() + "\",";
					} else {
						id11 += "\"\",";
					}
					element1 = element.element("��ҵ");
					if (element1 != null) {
						id12 += "\"";
						id12 += element1.getTextTrim() + "\",";
					} else {
						id12 += "\"\",";
					}
					element1 = element.element("רҵ");
					if (element1 != null) {
						id13 += "\"";
						id13 += element1.getTextTrim() + "\",";
					} else {
						id13 += "\"\",";
					}

					i++;
				}
				pguid = pguid.substring(0, pguid.length() - 1);
				id = id.substring(0, id.length() - 1);
				id1 = id1.substring(0, id1.length() - 1);
				id2 = id2.substring(0, id2.length() - 1);
				id3 = id3.substring(0, id3.length() - 1);
				id4 = id4.substring(0, id4.length() - 1);
				id5 = id5.substring(0, id5.length() - 1);
				id6 = id6.substring(0, id6.length() - 1);
				id7 = id7.substring(0, id7.length() - 1);
				id8 = id8.substring(0, id8.length() - 1);
				id8 = id8.replaceAll("\\\\", "\\\\\\\\");
				id9 = id9.substring(0, id9.length() - 1);
				id10 = id10.substring(0, id10.length() - 1);
				id11 = id11.substring(0, id11.length() - 1);
				id11 = id11.replaceAll("\\\\", "\\\\\\\\");
				id12 = id12.substring(0, id12.length() - 1);
				id13 = id13.substring(0, id13.length() - 1);

				pguid += "],";

				id += "],";
				id1 += "],";
				id2 += "],";
				id3 += "],";
				id4 += "],";
				id5 += "],";
				id6 += "],";
				id7 += "],";
				id8 += "],";
				id9 += "],";
				id10 += "],";
				id11 += "],";
				id12 += "],";
				id13 += "]";
				result += pguid + id + id1 + id2 + id3 + id4 + id5 + id6 + id7 + id8 + id9 + id10 + id11 + id12 + id13
						+ "]";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// pguid��ѯ
	public static String implementPGUIDQuery(String sql) {
		String result = "";
		String result1 = "[]";
		String id1 = "";
		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			if (sss.equals("0")) {
				result = result1;
			} else {
				Document document = DocumentHelper.parseText(sss);
				Element root = document.getRootElement();
				List<Element> list = root.elements("Table");
				Element element1 = null;
				for (Element element : list) {
					element1 = element.element("PGUID");
					if (element1 != null) {
						id1 += "";
						id1 += element1.getTextTrim() + ",";
					} else {
						id1 += ",";
					}
				}
				id1 = id1.substring(0, id1.length() - 1);
				id1 += "";
				result += id1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// ͨ���ϼ���λ����Pguid��ѯ��ѯ��λ����
	public static String QueryDataUpUnitName(String sql) {
		String result = "[";
		String result1 = "[[]";
		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			if (sss.equals("0")) {
				result = result1;
			} else {
				Document document = DocumentHelper.parseText(sss);
				Element root = document.getRootElement();
				List<Element> list = root.elements("Table");
				for (Element element : list) {
					result += "[\"" + element.element("��λ����").getTextTrim() + "\"]";
				}
			}
			result += "]";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static String QdataDepartmentTable(String sql) {
		String result = "[";
		String result1 = "[]";
		/* String pguid="["; */
		String i = "[";
		String pguid = "[";
		String id1 = "[";

		int ii = 1;
		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			if (sss.equals("0")) {
				result = result1;
			} else {
				Document document = DocumentHelper.parseText(sss);
				Element root = document.getRootElement();
				List<Element> list = root.elements("Table");
				Element element1 = null;

				for (Element element : list) {
					i += "\"" + ii + "\",";
					element1 = element.element("PGUID");
					if (element1 != null) {
						pguid += "\"";
						pguid += element1.getTextTrim() + "\",";
					} else {
						pguid += "\"\",";
					}
					element1 = element.element("��������");
					if (element1 != null) {
						id1 += "\"";
						id1 += element1.getTextTrim() + "\",";
					} else {
						id1 += "\"\",";
					}
					ii++;
				}
				i = i.substring(0, i.length() - 1);
				pguid = pguid.substring(0, pguid.length() - 1);
				id1 = id1.substring(0, id1.length() - 1);
				i += "],";
				pguid += "],";
				id1 += "]";
				result += pguid + i + id1 + "]";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// ....................................�������.......................................
	public static String QuestitionQuery(String sql) {
		String result = "[";
		String result1 = "[[\"��ѡ��\"]]";
		String id1 = "[\"��ѡ��\",";
		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			if (sss.equals("0")) {
				result = result1;
			} else {
				Document document = DocumentHelper.parseText(sss);
				Element root = document.getRootElement();
				List<Element> list = root.elements("Table");
				Element element1 = null;
				for (Element element : list) {
					element1 = element.element("�жϼ���");
					if (element1 != null) {
						id1 += "\"";
						id1 += element1.getTextTrim() + "\",";
					} else {
						id1 += "\"\",";
					}
				}
				id1 = id1.substring(0, id1.length() - 1);
				id1 += "]";
				result += id1 + "]";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// ..........................................�û�������.....................................
	public static String QdataDepartmentshowindex(String sql) {
		String result = "";
		String result1 = "[]";
		String showindex = "";
		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			if (sss.equals("0")) {
				result = result1;
			} else {
				Document document = DocumentHelper.parseText(sss);
				Element root = document.getRootElement();
				List<Element> list = root.elements("Table");
				Element element1 = null;

				for (Element element : list) {
					element1 = element.element("SHOWINDEX");
					if (element1 != null) {

						showindex += element1.getTextTrim() + "";
					} else {
						showindex += "";
					}

				}

				result = showindex;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static String BarAndPieQuery(String sql) {
		String result = "[";
		String result1 = "[[],[]]";
		String id1 = "[";
		String id2 = "[";
		String legend = "\"legend\":[";
		String series = "\"series\": [";
		String pieseries = "\"pieseries\": [ {\"name \": \"������Դ\",\"type\" : \"pie\",\"radius\" : \"35%\",\"center\" : [ \"50%\", \"40%\" ],\" label\":{\"normal\":{\"formatter\" : \"function(v) { let text = v.name  return  text.length < 4 ? text: `${text.slice(0,4)}\\n${text.slice(4)}` }\"}},\"data\" : [";
		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			if (sss.equals("0")) {
				result = result1;
			} else {
				Document document = DocumentHelper.parseText(sss);
				Element root = document.getRootElement();
				List<Element> list = root.elements("Table");
				Element element1 = null;
				for (Element element : list) {
					element1 = element.element("A");
					if (element1 != null) {
						id1 = "\"" + element1.getTextTrim() + "\"";
					} else {
						id1 = "\"\"";
					}
					element1 = element.element("�������ͷ�������");
					if (element1 != null) {
						id2 = "\"" + element1.getTextTrim() + "\"";
						legend += "\"" + element1.getTextTrim() + "\",";
					} else {
						id2 = "\"\",";
						legend += "\"  \",";
					}
					series += "{\"barMaxWidth\":\"60\",\"name\": " + id2 + ",\"type\": \"bar\", \"data\" :[" + id1
							+ "]},";
					pieseries += "{\"value\" : " + id1 + ",\"name\" :" + id2 + "},";
				}
				series = series.substring(0, series.length() - 1);
				legend = legend.substring(0, legend.length() - 1);
				pieseries = pieseries.substring(0, pieseries.length() - 1);
				series += "]";
				legend += "]";
				result = "[{" + legend + "," + series + "," + pieseries + "]}]}]";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static String BarAndPiechildQuery(String sql) {
		String result = "[";
		String result1 = "[[],[]]";
		String id1 = "[";
		String id2 = "[";
		String legend = "\"legend\": [";
		String series = "\"series\": [";
		String pieseries = "\"pieseries\": [ {\"name \": \"������Դ\",\"type\" : \"pie\",\"radius\" : \"35%\",\"center\" : [ \"50%\", \"40%\" ],\" label\":{\"normal\":{\"formatter\" : \"function(v) { let text = v.name  return  text.length < 3 ? text: `${text.slice(0,3)}\\n${text.slice(3)}` }\"}}, \"data\" : [";
		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			if (sss.equals("0")) {
				result = result1;
			} else {
				Document document = DocumentHelper.parseText(sss);
				Element root = document.getRootElement();
				List<Element> list = root.elements("Table");
				Element element1 = null;
				for (Element element : list) {
					element1 = element.element("A");
					if (element1 != null) {
						id1 = "\"" + element1.getTextTrim() + "\"";
					} else {
						id1 = "";
					}
					element1 = element.element("����ԭ��");
					if (element1 != null) {
						id2 = "\"" + element1.getTextTrim() + "\"";
						legend += "\"" + element1.getTextTrim() + "\",";
					} else {
						id2 = "\" \"";
						legend += "\" \",";
					}
					series += "{\"barMaxWidth\":\"60\",\"name\": " + id2
							+ ",\"type\": \"bar\",\"barGap\": \"0\", \"data\" :[" + id1 + "]},";
					pieseries += "{\"value\" : " + id1 + ",\"name\" :" + id2 + "},";
				}
				series = series.substring(0, series.length() - 1);
				legend = legend.substring(0, legend.length() - 1);
				pieseries = pieseries.substring(0, pieseries.length() - 1);
				series += "]";
				legend += "]";
				result = "[{" + legend + "," + series + "," + pieseries + "]}]}]";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static String BarAndPiechildunitQuery(String sql) {
		String result = "[";
		String result1 = "[[],[]]";
		String id1 = "[";
		String id2 = "[";
		String legend = "\"legend\": [";
		String series = "\"series\": [";
		String pieseries = "\"pieseries\": [ {\"name \": \"������Դ\",\"type\" : \"pie\",\"radius\" : \"35%\",\"center\" : [ \"50%\", \"40%\" ],\" label\":{\" normal\":{\"formatter\": \"funtion(v) { let text = v.name   return  text.length < 4 ? text: `${text.slice(0,4)}\\n ${text.slice(4)}` }\" } },\"data\" : [";
		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			if (sss.equals("0")) {
				result = result1;
			} else {
				Document document = DocumentHelper.parseText(sss);
				Element root = document.getRootElement();
				List<Element> list = root.elements("Table");
				Element element1 = null;
				for (Element element : list) {
					element1 = element.element("A");
					if (element1 != null) {
						id1 = "\"" + element1.getTextTrim() + "\"";
					} else {
						id1 = "\" \"";
					}
					element1 = element.element("�жϼ���");
					if (element1 != null) {
						id2 = "\"" + element1.getTextTrim() + "\"";
						legend += "\"" + element1.getTextTrim() + "\",";
					} else {
						id2 = "\" \"";
						legend += "\"\",";
					}
					series += "{\" barMaxWidth\":\"60\",\"name\": " + id2
							+ ",\"type\": \"bar\",\"barGap\": \"0\", \"data\" :[" + id1 + "]},";
					pieseries += "{\"value\" : " + id1 + ",\"name\" :" + id2 + "},";
				}
				series = series.substring(0, series.length() - 1);
				legend = legend.substring(0, legend.length() - 1);
				pieseries = pieseries.substring(0, pieseries.length() - 1);
				series += "]";
				legend += "]";
				result = "[{" + legend + "," + series + "," + pieseries + "]}]}]";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// ��ͼ����ʾ

	public static String BarAndPieSoftNameQuery(String sql) {
		String result = "[";
		String result1 = "[[],[]]";
		String id1 = "[";
		String id2 = "[";
		String legend = "\"legend\": [";
		String series = "\"series\": [";
		String pieseries = "\"pieseries\": [ {\"name \": \"������Դ\",\"type\" : \"pie\",\"radius\" : \"35%\",\"center\" : [ \"50%\", \"40%\" ],\" label\":{\" normal\":{\"formatter\": \"funtion(v) { let text = v.name   return  text.length < 4 ? text: `${text.slice(0,4)}\\n ${text.slice(4)}` }\" } },\"data\" : [";
		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			if (sss.equals("0")) {
				result = result1;
			} else {
				Document document = DocumentHelper.parseText(sss);
				Element root = document.getRootElement();
				List<Element> list = root.elements("Table");
				Element element1 = null;
				for (Element element : list) {
					element1 = element.element("A");
					if (element1 != null) {
						id1 = "\"" + element1.getTextTrim() + "\"";
					} else {
						id1 += "\"\",";
					}
					element1 = element.element("���ϵͳ");
					if (element1 != null) {
						id2 = "\"" + element1.getTextTrim() + "\"";
						legend += "\"" + element1.getTextTrim() + "\",";
					} else {
						id2 += "\"\",";
					}
					/*
					 * int s=list.size()-1,; if(s==v){ series +=
					 * "{\"barCategoryGap\": \"0\",\"barMaxWidth\":\"60\",\"name\": "
					 * + id2 + ",\"type\": \"bar\", \"data\" :[" + id1 + "]},";
					 * }else{ series += "{\"barMaxWidth\":\"60\",\"name\": " +
					 * id2 + ",\"type\": \"bar\", \"data\" :[" + id1 + "]},";
					 * 
					 * } v++;
					 */

					series += "{\"barMaxWidth\":\"60\",\"name\": " + id2
							+ ",\"type\": \"bar\",\"barGap\": \"0\", \"data\" :[" + id1 + "]},";
					pieseries += "{\"value\" : " + id1 + ",\"name\" :" + id2 + "},";
				}
				series = series.substring(0, series.length() - 1);
				legend = legend.substring(0, legend.length() - 1);
				pieseries = pieseries.substring(0, pieseries.length() - 1);
				series += "]";
				legend += "]";
				result = "[{" + legend + "," + series + "," + pieseries + "]}]}]";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// --------------��ͼ��ʾ------------------------------------------
	public static String BarAndPieCESHI(String sql, String a) {
		String[] arr = { "���̰�װ", "�������", "ϵͳ��������", "�û�ʹ��", "�û�����" };
		String result = "[";
		String result1 = "[[],[]]";
		String id1 = "[";
		String id2 = "[";
		String id3 = "[";
		String oldtype = "";
		String xAxisdata = "\"xAxisdata\":[ " + a + "]";// X��ֵ
		a = a.replace("\"", "");
		String[] arr2 = a.split(",");
		// String[] arr2 = { "�������", "����", "�������", "���������ϵͳ", "�������ϵͳ", "�������",
		// "�����ϱ�ϵͳ" };
		String legend = "\"legend\": [";
		String series = "\"series\": [";
		String pieseries = "\"pieseries\": [ {\"name \": \"������Դ\",\"type\" : \"pie\",\"radius\" : \"35%\",\"center\" : [ \"50%\", \"40%\" ],\" label\":{\" normal\":{\"formatter\": \"funtion(v) { let text = v.name   return  text.length < 4 ? text: `${text.slice(0,4)}\\n ${text.slice(4)}` }\" } },\"data\" : [";
		String[] arr3 = null;
		String[] arr5 = null;
		String arr4 = "";
		String seriesdata = "";
		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			if (sss.equals("0")) {
				result = result1;
			} else {
				Document document = DocumentHelper.parseText(sss);
				Element root = document.getRootElement();
				List<Element> list = root.elements("Table");
				Element element1 = null;
				for (Element element : list) {
					element1 = element.element("A");
					if (element1 != null) {
						id1 = element1.getTextTrim();
					} else {
						id1 += "\"\",";
					}
					element1 = element.element("���ϵͳ");
					if (element1 != null) {
						id2 = element1.getTextTrim();
					} else {
						id2 += "\"\",";
					}
					element1 = element.element("�������ͷ�������");
					if (element1 != null) {
						id3 = element1.getTextTrim();
					} else {
						id3 += "\"\",";
					}
					if (!id3.equals(oldtype)) {
						if (arr3 != null) {
							legend += "\"" + oldtype + "\",";
							seriesdata = "";
							for (int i = 0; i < arr3.length; i++) {
								seriesdata += "\"" + arr3[i] + "\",";
							}
							seriesdata = seriesdata.substring(0, seriesdata.length() - 1);
							arr4 += seriesdata + "s";
						}
						arr3 = new String[] { "0", "0", "0", "0", "0", "0", "0", "0", "0" };
						oldtype = id3;
					}
					// d��������и�ֵ ��
					for (int j = 0; j < arr2.length; j++) {
						if (arr2[j].equals(id2)) {
							arr3[j] = id1;
						}
					}
					pieseries += "{\"value\" : \"" + id1 + "\",\"name\" :\"" + id2 + "\"},";
				}
				if (arr3 != null) {
					legend += "\"" + oldtype + "\",";
					seriesdata = "";
					for (int i = 0; i < arr3.length; i++) {
						seriesdata += "\"" + arr3[i] + "\",";
					}
					seriesdata = seriesdata.substring(0, seriesdata.length() - 1);
					arr4 += seriesdata;
					arr5 = arr4.split("s");
				}
				
				for (int i = 0; i < arr.length; i++) {
					series += "{\"barMaxWidth\":\"60\",\"name\":\"" + arr[i]
							+ "\",\"type\": \"bar\",\"barGap\": \"0\", \"data\" :[" + arr5[i] + "]},";
					System.out.println("arr    ...      "+arr[i]);
				}
				series = series.substring(0, series.length() - 1);
				legend = legend.substring(0, legend.length() - 1);
				pieseries = pieseries.substring(0, pieseries.length() - 1);
				series += "]";
				legend += "]";
				result = "[{" + xAxisdata + "," + legend + "," + series + "," + pieseries + "]}]}]";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// ----------------------�ĸ���ҳ����ͼ��ʾ---------------------------------------------
	public static String ChildBarAndPieCESHI(String sql, String a, String b) {
		// String[] arr = { "���̰�װ", "�������", "�û�ʹ��", "�û�����" };
		b = b.replace("\"", "");
		String[] arr = b.split(",");
		String result = "[";
		String result1 = "[[],[]]";
		String id1 = "[";
		String id2 = "[";
		String id3 = "[";
		String oldtype = "";
		String xAxisdata = "\"xAxisdata\":[ " + a + "]";// X��ֵ
		a = a.replace("\"", "");
		String[] arr2 = a.split(",");
		// String[] arr2 = { "�������", "����", "�������", "���������ϵͳ", "�������ϵͳ", "�������",
		// "�����ϱ�ϵͳ" };
		String legend = "\"legend\": [";
		String series = "\"series\": [";
		String pieseries = "\"pieseries\": [ {\"name \": \"������Դ\",\"type\" : \"pie\",\"radius\" : \"35%\",\"center\" : [ \"50%\", \"40%\" ],\" label\":{\" normal\":{\"formatter\": \"funtion(v) { let text = v.name   return  text.length < 4 ? text: `${text.slice(0,4)}\\n ${text.slice(4)}` }\" } },\"data\" : [";
		String[] arr3 = null;
		String[] arr5 = null;
		String arr4 = "";
		String seriesdata = "";
		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			if (sss.equals("0")) {
				result = result1;
			} else {
				Document document = DocumentHelper.parseText(sss);
				Element root = document.getRootElement();
				List<Element> list = root.elements("Table");
				Element element1 = null;
				for (Element element : list) {
					element1 = element.element("A");
					if (element1 != null) {
						id1 = element1.getTextTrim();
					} else {
						id1 = "";
					}
					element1 = element.element("���ϵͳ");
					if (element1 != null) {
						id2 = element1.getTextTrim();
					} else {
						id2 = "  ";
					}
					element1 = element.element("����ԭ��");
					if (element1 != null) {
						id3 = element1.getTextTrim();
					} else {
						id3 = "  ";
					}
					//oldtype="";
					if (!id3.equals(oldtype)) {
						if (arr3 != null) {
							legend += "\"" + oldtype + "\",";
							System.out.println(legend);
							seriesdata = "";
							for (int i = 0; i < arr3.length; i++) {
								seriesdata += "\"" + arr3[i] + "\",";
							}
							seriesdata = seriesdata.substring(0, seriesdata.length() - 1);
							arr4 += seriesdata + "s";
						}
						arr3 = new String[] { "0", "0", "0", "0", "0", "0", "0", "0", "0", "0" , "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"};
						oldtype = id3;
					}
					// d��������и�ֵ ��
					for (int j = 0; j < arr2.length; j++) {
						if (arr2[j].equals(id2)) {
							arr3[j] = id1;
						}
					}
					pieseries += "{\"value\" : \"" + id1 + "\",\"name\" :\"" + id2 + "\"},";
				}
				
				if (arr3 != null) {
					if(oldtype.equals("")){
						legend +=   oldtype ;
					}else{
						legend += "\"" + oldtype + "\",";
					}
					
					
					seriesdata = "";
					for (int i = 0; i < arr3.length; i++) {
						seriesdata += "\"" + arr3[i] + "\",";
					}
					seriesdata = seriesdata.substring(0, seriesdata.length() - 1);
					arr4 += seriesdata;
					arr5 = arr4.split("s");
				}
				System.out.println("arr legent"+arr.length);
				for (int i = 0; i < arr.length; i++) {
					series += "{\"barMaxWidth\":\"60\",\"name\":\"" + arr[i]
							+ "\",\"type\": \"bar\",\"barGap\": \"0\", \"data\" :[" + arr5[i] + "]},";
				}
				series = series.substring(0, series.length() - 1);
				legend = legend.substring(0, legend.length() - 1);
				pieseries = pieseries.substring(0, pieseries.length() - 1);
				series += "]";
				legend += "]";
				result = "[{" + xAxisdata + "," + legend + "," + series + "," + pieseries + "]}]}]";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static String ChildSoftUnitBarAndPie(String sql, String a, String b) {
		b = b.replace("\"", "");
		String[] arr = b.split(",");
		String result = "[";
		String result1 = "[[],[]]";
		String id1 = "[";
		String id2 = "[";
		String id3 = "[";
		String oldtype = "";
		String xAxisdata = "\"xAxisdata\":[ " + a + "]";// X��ֵ
		a = a.replace("\"", "");
		String[] arr2 = a.split(",");
		// String[] arr2 = { "�������", "����", "�������", "���������ϵͳ", "�������ϵͳ", "�������",
		// "�����ϱ�ϵͳ" };
		String legend = "\"legend\": [";
		String series = "\"series\": [";
		String pieseries = "\"pieseries\": [ {\"name \": \"������Դ\",\"type\" : \"pie\",\"radius\" : \"35%\",\"center\" : [ \"50%\", \"40%\" ],\" label\":{\" normal\":{\"formatter\": \"funtion(v) { let text = v.name   return  text.length < 4 ? text: `${text.slice(0,4)}\\n ${text.slice(4)}` }\" } },\"data\" : [";
		String[] arr3 = null;
		String[] arr5 = null;
		String arr4 = "";
		String seriesdata = "";
		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			if (sss.equals("0")) {
				result = result1;
			} else {
				Document document = DocumentHelper.parseText(sss);
				Element root = document.getRootElement();
				List<Element> list = root.elements("Table");
				Element element1 = null;
				for (Element element : list) {
					element1 = element.element("A");
					if (element1 != null) {
						id1 = element1.getTextTrim();
					} else {
						id1 = "  ";
					}
					element1 = element.element("�жϼ���");
					if (element1 != null) {
						id2 = element1.getTextTrim();
					} else {
						id2 = "  ";
					}
					element1 = element.element("����ԭ��");
					if (element1 != null) {
						id3 = element1.getTextTrim();
					} else {
						id3 = "  ";
					}
					if (!id3.equals(oldtype)) {
						if (arr3 != null) {
							legend += "\"" + oldtype + "\",";
							System.out.println(legend);
							seriesdata = "";
							for (int i = 0; i < arr3.length; i++) {
								seriesdata += "\"" + arr3[i] + "\",";
							}
							seriesdata = seriesdata.substring(0, seriesdata.length() - 1);
							arr4 += seriesdata + "s";
						}
						arr3 = new String[] {
								"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0",
								"0", "0", "0", "0", "0" };
						oldtype = id3;
					}
					// d��������и�ֵ ��
					for (int j = 0; j < arr2.length; j++) {
						if (arr2[j].equals(id2)) {
							arr3[j] = id1;
						}
					}
					pieseries += "{\"value\" : \"" + id1 + "\",\"name\" :\"" + id2 + "\"},";
				}
				if (arr3 != null) {
					if(oldtype.equals("")){
						legend +=   oldtype ;
					}else{
						legend += "\"" + oldtype + "\",";
					}
					seriesdata = "";
					for (int i = 0; i < arr3.length; i++) {
						seriesdata += "\"" + arr3[i] + "\",";
					}
					seriesdata = seriesdata.substring(0, seriesdata.length() - 1);
					arr4 += seriesdata;
					arr5 = arr4.split("s");
				}
				for (int i = 0; i < arr.length; i++) {
					series += "{\"barMaxWidth\":\"60\",\"name\":\"" + arr[i]
							+ "\", \"stack\": \"��������\",\"type\": \"bar\",\"barGap\": \"0\", \"data\" :[" + arr5[i] + "]},";
				}
				series = series.substring(0, series.length() - 1);
				legend = legend.substring(0, legend.length() - 1);
				pieseries = pieseries.substring(0, pieseries.length() - 1);
				series += "]";
				legend += "]";
				result = "[{" + xAxisdata + "," + legend + "," + series + "," + pieseries + "]}]}]";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// ��ѯͼ���ǲ�ѯ���������ͷ���
	public static String getQuestion(String sql) {
		String result1 = "";
		String id2 = "";
		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			if (sss.equals("0")) {
				id2 = result1;
			} else {
				Document document = DocumentHelper.parseText(sss);
				Element root = document.getRootElement();
				List<Element> list = root.elements("Table");
				Element element1 = null;
				for (Element element : list) {
					element1 = element.element("����ԭ��");
					if (element1 != null) {
						id2 += "\"" + element1.getTextTrim() + "\",";
					} else {
						id2 += "\"  \",";
					}
				}
				id2 = id2.substring(0, id2.length() - 1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id2;
	}

	// -----xin����ӵĴ�����ͼ��legend,x���������ʾ�����ڸ�ֵ
	public static String getLegendUnit(String sql) {
		String result = "";
		String result1 = "";
		String id2 = "";
		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			if (sss.equals("0")) {
				result = result1;
			} else {
				Document document = DocumentHelper.parseText(sss);
				Element root = document.getRootElement();
				List<Element> list = root.elements("Table");
				Element element1 = null;
				for (Element element : list) {
					element1 = element.element("���ϵͳ");
					if (element1 != null) {
						id2 += "\"" + element1.getTextTrim() + "\",";
					} else {
						id2 += "\"\",";
					}
				}
				id2 = id2.substring(0, id2.length() - 1);
				id2 += "";
				result += id2 + "";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static String getSoftUnit(String sql) {
		String result = "";
		String result1 = "";
		String id2 = "";
		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			if (sss.equals("0")) {
				result = result1;
			} else {
				Document document = DocumentHelper.parseText(sss);
				Element root = document.getRootElement();
				List<Element> list = root.elements("Table");
				Element element1 = null;
				for (Element element : list) {
					element1 = element.element("�жϼ���");
					if (element1 != null) {
						id2 += "\"" + element1.getTextTrim() + "\",";
					} else {
						id2 += "\" \",";
					}
				}
				id2 = id2.substring(0, id2.length() - 1);
				id2 += "";
				result += id2 + "";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// �������������õĲ�ѯ����-----------������ʮһ�����----------------------------

	public static String functionQuery(String sql) {
		String result = "[";
		String result1 = "[]";
		String pguid = "[";
		String i = "[";
		String id1 = "[";
		int ii = 1;
		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			if (sss.equals("0")) {
				result = result1;
			} else {
				Document document = DocumentHelper.parseText(sss);
				Element root = document.getRootElement();
				List<Element> list = root.elements("Table");
				Element element1 = null;
				for (Element element : list) {
					element1 = element.element("PGUID");
					if (element1 != null) {
						pguid += "\"" + element1.getTextTrim() + "\",";
					} else {
						pguid += "\"\",";
					}
					i += "\"" + ii + "\",";

					element1 = element.element("����");
					if (element1 != null) {
						id1 += "\"" + element1.getTextTrim() + "\",";
					} else {
						id1 += "\"\",";
					}

					ii++;
				}
				pguid = pguid.substring(0, pguid.length() - 1);
				i = i.substring(0, i.length() - 1);
				id1 = id1.substring(0, id1.length() - 1);
				pguid += "],";
				i += "],";
				id1 += "]";
				result += pguid + i + id1 + "]";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// ������ʮһ����� ........ԭ�����õĲ�ѯ
	
	public static String CauseWtlx(String sql) {
		String result = "[";
		String result1 = "[]";
		String pguid = "[";
		String i = "[";
		String id1 = "[";
		int ii = 1;
		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			if (sss.equals("0")) {
				result = result1;
			} else {
				Document document = DocumentHelper.parseText(sss);
				Element root = document.getRootElement();
				List<Element> list = root.elements("Table");
				Element element1 = null;
				for (Element element : list) {
					element1 = element.element("PGUID");
					if (element1 != null) {
						pguid += "\"" + element1.getTextTrim() + "\",";
					} else {
						pguid += "\"\",";
					}
					i += "\"" + ii + "\",";

					element1 = element.element("ԭ��");
					if (element1 != null) {
						id1 += "\"" + element1.getTextTrim() + "\",";
					} else {
						id1 += "\"\",";
					}

					ii++;
				}
				pguid = pguid.substring(0, pguid.length() - 1);
				i = i.substring(0, i.length() - 1);
				id1 = id1.substring(0, id1.length() - 1);
				pguid += "],";
				i += "],";
				id1 += "]";
				result += pguid + i + id1 + "]";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
//���¾ź��������  ==---------  �ӵ�λ�ֵ���ѯ��λ����,Ӧ���������ŵ����
	public static String  getDWjb(String sql) {
		String result = "";
		String result1 = "";
		String id2 = "";
		try {
			sswServices service = new sswServices("QueryData");
			String sss = service.getByPost("sql=" + sql);
			sss = StringEscapeUtils.unescapeXml(sss);
			if (sss.equals("0")) {
				result = result1;
			} else {
				Document document = DocumentHelper.parseText(sss);
				Element root = document.getRootElement();
				List<Element> list = root.elements("Table");
				Element element1 = null;
				for (Element element : list) {
					element1 = element.element("��λ����");
					if (element1 != null) {
						if(element1.getTextTrim().equals("�ܹ�˾")){
							id2 = "a";
						}
						if(element1.getTextTrim().equals("·��")){
							id2 = "b";
						}
						if(element1.getTextTrim().equals("��")||element1.getTextTrim().equals("֧�߹�˾")){
							id2 = "c";
						}
						
					} else {
						id2 += "\"\",";
					}
				}
				result += id2;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
